package com.tencent.mobileqq.apollo.game.process.data;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.ApolloGameTimeReporter;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class CmGameManager
  implements Manager
{
  protected BroadcastReceiver a;
  private AppInterface b;
  private CopyOnWriteArrayList<CmGameLauncher> c = new CopyOnWriteArrayList();
  private ConcurrentHashMap<Integer, String> d = new ConcurrentHashMap();
  
  public CmGameManager(AppInterface paramAppInterface)
  {
    QLog.i("cmgame_process.CmGameManager", 1, "[CmGameManager] created.");
    this.b = paramAppInterface;
    this.a = new CmGameManager.GameEventReceiver();
    paramAppInterface = new IntentFilter();
    paramAppInterface.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    try
    {
      if (this.b != null)
      {
        this.b.getApplication().registerReceiver(this.a, paramAppInterface, "com.tencent.msg.permission.pushnotify", null);
        return;
      }
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e("cmgame_process.CmGameManager", 1, paramAppInterface, new Object[0]);
    }
  }
  
  public CmGameLauncher a(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      CmGameLauncher localCmGameLauncher = (CmGameLauncher)localIterator.next();
      if ((localCmGameLauncher != null) && (paramInt == localCmGameLauncher.g())) {
        return localCmGameLauncher;
      }
    }
    return null;
  }
  
  public CmGameLauncher a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameManager", 2, "[getLauncher], invalid gameId.");
      }
      return null;
    }
    finally {}
    CmGameLauncher localCmGameLauncher = new CmGameLauncher(paramInt1);
    localCmGameLauncher.c = paramInt2;
    this.c.add(0, localCmGameLauncher);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add a new launcher, gameId:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",total size:");
    localStringBuilder.append(this.c.size());
    QLog.i("cmgame_process.CmGameManager", 1, localStringBuilder.toString());
    return localCmGameLauncher;
  }
  
  public CmGameLauncher a(long paramLong)
  {
    try
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        CmGameLauncher localCmGameLauncher = (CmGameLauncher)localIterator.next();
        if (localCmGameLauncher != null)
        {
          ApolloSurfaceView localApolloSurfaceView = localCmGameLauncher.e();
          if (localApolloSurfaceView != null)
          {
            long l = localApolloSurfaceView.getLuaState();
            if (l == paramLong) {
              return localCmGameLauncher;
            }
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ssoCmdRule gameId: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", rule: ");
      QLog.d("cmgame_process.CmGameManager", 2, new Object[] { localStringBuilder.toString(), paramString });
    }
    if ((paramInt > 0) && (!TextUtils.isEmpty(paramString))) {
      this.d.put(Integer.valueOf(paramInt), paramString);
    }
  }
  
  public CmGameLauncher b(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject2 = this.c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        CmGameLauncher localCmGameLauncher = (CmGameLauncher)((Iterator)localObject2).next();
        if ((localCmGameLauncher != null) && (paramInt1 == localCmGameLauncher.g()) && (paramInt2 == localCmGameLauncher.c) && (this.c.remove(localCmGameLauncher)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("remove a launcher, gameId:");
          ((StringBuilder)localObject2).append(paramInt1);
          ((StringBuilder)localObject2).append(",total size:");
          ((StringBuilder)localObject2).append(this.c.size());
          QLog.i("cmgame_process.CmGameManager", 1, ((StringBuilder)localObject2).toString());
          return localCmGameLauncher;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public String b(int paramInt)
  {
    if (this.d.get(Integer.valueOf(paramInt)) != null) {
      return (String)this.d.get(Integer.valueOf(paramInt));
    }
    return "^(apollo_game_[_a-zA-Z0-9.]*|apollo_aio_game[_a-zA-Z0-9.]*)";
  }
  
  public void onDestroy()
  {
    QLog.i("cmgame_process.CmGameManager", 1, "[CmGameManager] destroyed.");
    try
    {
      if (this.a != null) {
        this.b.getApplication().unregisterReceiver(this.a);
      }
      ApolloGameTimeReporter.a();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameManager", 1, "[doDestroy] exception=", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameManager
 * JD-Core Version:    0.7.0.1
 */