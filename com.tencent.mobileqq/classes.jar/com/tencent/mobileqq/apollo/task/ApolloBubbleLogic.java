package com.tencent.mobileqq.apollo.task;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteStatusChanged;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ApolloBubbleLogic
  implements ISpriteStatusChanged
{
  public static boolean a;
  private int jdField_a_of_type_Int = 1;
  SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private boolean b = false;
  private boolean c = false;
  
  public ApolloBubbleLogic(SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject3 = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp", 0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject1).append("_aio_bubble_count_");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(ApolloUtilImpl.getTodayKey());
    localObject2 = ((StringBuilder)localObject2).toString();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject3).edit();
    if (((SharedPreferences)localObject3).contains((String)localObject2))
    {
      localEditor.putInt((String)localObject2, ((SharedPreferences)localObject3).getInt((String)localObject2, 0) + 1);
    }
    else
    {
      Object localObject4 = ((SharedPreferences)localObject3).getAll();
      localObject3 = new ArrayList();
      if (localObject4 != null)
      {
        localObject4 = ((Map)localObject4).entrySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
          String str = (String)localEntry.getKey();
          if ((str != null) && (str.startsWith((String)localObject1))) {
            ((List)localObject3).add(localEntry.getKey());
          }
        }
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localEditor.remove((String)((Iterator)localObject1).next());
        }
      }
      localEditor.putInt((String)localObject2, 1);
    }
    localEditor.commit();
    a(paramQQAppInterface);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      Object localObject = paramAppRuntime.getApplication();
      boolean bool = false;
      localObject = ((MobileQQ)localObject).getSharedPreferences("apollo_sp", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("_aio_bubble_count_");
      localStringBuilder.append(ApolloUtilImpl.getTodayKey());
      if (((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0) >= ((SharedPreferences)localObject).getInt("sp_key_aio_bubble_max_count", 3)) {
        bool = true;
      }
      jdField_a_of_type_Boolean = bool;
    }
  }
  
  private void b()
  {
    if (!this.b) {
      return;
    }
    this.b = false;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (localQQAppInterface == null) {
      return;
    }
    ApolloGameManagerImpl localApolloGameManagerImpl = (ApolloGameManagerImpl)localQQAppInterface.getRuntimeService(IApolloGameManager.class, "all");
    Object localObject = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    localObject = null;
    if (localApolloGameManagerImpl.mBubblePush != null) {
      localObject = localApolloGameManagerImpl.mBubblePush.a();
    }
    if ((localObject != null) && ((((DrawerPushItem)localObject).msg_type == 7) || (((DrawerPushItem)localObject).msg_type == 9) || (((DrawerPushItem)localObject).msg_type == 2) || (((DrawerPushItem)localObject).msg_type == 10)))
    {
      QLog.i("[cmshow]ApolloBubbleLogic", 1, "checkIfPanelBubble remove panel bubble");
      ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).removePushItem((DrawerPushItem)localObject);
      localApolloGameManagerImpl.mBubblePush.a();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if (localObject != null)
    {
      localObject = (ApolloGameManagerImpl)((SpriteContext)localObject).a().getRuntimeService(IApolloGameManager.class, "all");
      ((ApolloGameManagerImpl)localObject).mCurrentBubbleGameId = -1;
      ((ApolloGameManagerImpl)localObject).setCurrentPanelBubbleGame(-1, -1);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = null;
    this.c = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      b();
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (localQQAppInterface == null) {
      return;
    }
    if (SpriteUtil.a(localQQAppInterface) == null) {
      return;
    }
    SharedPreferences localSharedPreferences = localQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_aio_bubble_count_");
    localStringBuilder.append(ApolloUtilImpl.getTodayKey());
    int i = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    int j = localSharedPreferences.getInt("sp_key_aio_bubble_max_count", 3);
    if (i >= j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloBubbleLogic", 2, new Object[] { "AIO Bubble show count limited:", Integer.valueOf(j) });
      }
      return;
    }
    if (this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloBubbleLogic", 2, "current AIO has play bubble, wait for next time");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloBubbleLogic", 2, "start play bubble");
    }
    if (a(localQQAppInterface)) {
      paramInt = 2;
    } else if (b(localQQAppInterface)) {
      paramInt = 3;
    } else {
      paramInt = 0;
    }
    if (paramInt > 0)
    {
      this.b = true;
      this.c = true;
      a(localQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloBubbleLogic", 2, new Object[] { "AIO bubble play type:", Integer.valueOf(paramInt), ",current count:", Integer.valueOf(i), ",maxCount:", Integer.valueOf(j) });
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    ApolloGameManagerImpl localApolloGameManagerImpl = (ApolloGameManagerImpl)paramQQAppInterface.getRuntimeService(IApolloGameManager.class, "all");
    DrawerPushItem localDrawerPushItem;
    if (localApolloGameManagerImpl.mBubblePush != null) {
      localDrawerPushItem = localApolloGameManagerImpl.mBubblePush.a();
    } else {
      localDrawerPushItem = null;
    }
    if ((localDrawerPushItem != null) && (localDrawerPushItem.msg_type != 7) && (localApolloGameManagerImpl.mBubblePush.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int)))
    {
      if (localDrawerPushItem.reddotGameId > 0)
      {
        localApolloGameManagerImpl.mCurrentBubbleGameId = localDrawerPushItem.reddotGameId;
        localApolloGameManagerImpl.setCurrentPanelBubbleGame(localDrawerPushItem.reddotGameId, 3);
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_msg_display", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 3, new String[] { String.valueOf(localDrawerPushItem.reddotGameId), String.valueOf(localDrawerPushItem.reddotRedId) });
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloBubbleLogic", 2, new Object[] { "show aio bubble for reddot game, game id=", Integer.valueOf(localDrawerPushItem.reddotGameId) });
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    ApolloGameManagerImpl localApolloGameManagerImpl = (ApolloGameManagerImpl)paramQQAppInterface.getRuntimeService(IApolloGameManager.class, "all");
    Object localObject;
    if (localApolloGameManagerImpl.mBubblePush != null) {
      localObject = localApolloGameManagerImpl.mBubblePush.a();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((DrawerPushItem)localObject).msg_type == 7))
    {
      localObject = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (localApolloGameManagerImpl.mBubblePush.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int))
      {
        if (localObject != null) {
          ((ApolloManagerServiceImpl)localObject).mIsBubbleTab = true;
        }
        VipUtils.a(null, "cmshow", "Apollo", "peoplebubble", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 0, new String[] { String.valueOf(1) });
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloBubbleLogic
 * JD-Core Version:    0.7.0.1
 */