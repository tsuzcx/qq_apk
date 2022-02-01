package com.tencent.mobileqq.apollo.game.process.data;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.ApolloGameTimeReporter;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloImageDownloaderImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class CmGameManager
  implements Manager
{
  public int a;
  protected BroadcastReceiver a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CmGameManager.2(this);
  public List<CmGameManager.GameRunningTask> a;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<Integer, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<CmGameLauncher> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  
  public CmGameManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    QLog.i("cmgame_process.CmGameManager", 1, "[CmGameManager] created.");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new CmGameManager.GameEventReceiver();
    paramAppInterface = new IntentFilter();
    paramAppInterface.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    try
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramAppInterface, "com.tencent.msg.permission.pushnotify", null);
      }
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e("cmgame_process.CmGameManager", 1, paramAppInterface, new Object[0]);
    }
    ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 64, null, true);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("apollo_sp", 4);
    this.jdField_b_of_type_Int = ((SharedPreferences)localObject1).getInt("sp_key_exit_game_guide_count_limit", 0);
    boolean bool;
    if (((SharedPreferences)localObject1).getInt("sp_key_exit_show_game_box_guide", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("apollo_sp");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    this.jdField_a_of_type_Int = ((SharedPreferences)localObject1).getInt("sp_key_exit_game_guide_count", 0);
    b();
    if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = (WindowManager)BaseApplicationImpl.getApplication().getSystemService("window");
      if (localObject2 != null)
      {
        int i = ((WindowManager)localObject2).getDefaultDisplay().getWidth();
        if (i <= 480)
        {
          this.jdField_a_of_type_Boolean = false;
          QLog.e("cmgame_process.CmGameManager", 1, new Object[] { "initGameExitData current display not should show game exit guide width:", Integer.valueOf(i) });
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("exit_game_guide_today_");
      ((StringBuilder)localObject2).append(ApolloUtilImpl.getTodayKey());
      if (((SharedPreferences)localObject1).contains(((StringBuilder)localObject2).toString())) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "initGameExitData mGameExitCurrentCount:", Integer.valueOf(this.jdField_a_of_type_Int), ",mGameExitLimitCount:", Integer.valueOf(this.jdField_b_of_type_Int), ",mShouldShowGameGuide:", Boolean.valueOf(this.jdField_a_of_type_Boolean), ",mShouldShowGameBoxGuide:", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    }
  }
  
  private void b()
  {
    String[] arrayOfString = new String[4];
    int i = 0;
    arrayOfString[0] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_play.png";
    arrayOfString[1] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_play_landscape.png";
    arrayOfString[2] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_plus.png";
    arrayOfString[3] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_plus_landscape.png";
    while (i < arrayOfString.length)
    {
      ApolloImageDownloaderImpl.preloadUrlImage(arrayOfString[i]);
      i += 1;
    }
  }
  
  public CmGameLauncher a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      CmGameLauncher localCmGameLauncher = (CmGameLauncher)localIterator.next();
      if ((localCmGameLauncher != null) && (paramInt == localCmGameLauncher.a())) {
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
    localCmGameLauncher.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, localCmGameLauncher);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add a new launcher, gameId:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",total size:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    QLog.i("cmgame_process.CmGameManager", 1, localStringBuilder.toString());
    return localCmGameLauncher;
  }
  
  public CmGameLauncher a(long paramLong)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        CmGameLauncher localCmGameLauncher = (CmGameLauncher)localIterator.next();
        if (localCmGameLauncher != null)
        {
          ApolloSurfaceView localApolloSurfaceView = localCmGameLauncher.a();
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
  
  public String a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) != null) {
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    return "^(apollo_game_[_a-zA-Z0-9.]*|apollo_aio_game[_a-zA-Z0-9.]*)";
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
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramString);
    }
  }
  
  public CmGameLauncher b(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        CmGameLauncher localCmGameLauncher = (CmGameLauncher)((Iterator)localObject2).next();
        if ((localCmGameLauncher != null) && (paramInt1 == localCmGameLauncher.a()) && (paramInt2 == localCmGameLauncher.jdField_b_of_type_Int) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localCmGameLauncher)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("remove a launcher, gameId:");
          ((StringBuilder)localObject2).append(paramInt1);
          ((StringBuilder)localObject2).append(",total size:");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
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
  
  public void onDestroy()
  {
    QLog.i("cmgame_process.CmGameManager", 1, "[CmGameManager] destroyed.");
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameManager
 * JD-Core Version:    0.7.0.1
 */