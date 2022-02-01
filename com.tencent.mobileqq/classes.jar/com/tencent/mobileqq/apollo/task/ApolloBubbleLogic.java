package com.tencent.mobileqq.apollo.task;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteStatusChanged;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      if (localSharedPreferences.getInt(paramQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_" + ApolloUtilImpl.getTodayKey(), 0) >= localSharedPreferences.getInt("sp_key_aio_bubble_max_count", 3)) {
        bool = true;
      }
      jdField_a_of_type_Boolean = bool;
    }
  }
  
  private void b()
  {
    if (!this.b) {}
    Object localObject;
    ApolloGameManager localApolloGameManager;
    ApolloManagerServiceImpl localApolloManagerServiceImpl;
    do
    {
      do
      {
        return;
        this.b = false;
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
      } while (localObject == null);
      localApolloGameManager = (ApolloGameManager)((QQAppInterface)localObject).getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
      localApolloManagerServiceImpl = (ApolloManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
      localObject = null;
      if (localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush != null) {
        localObject = localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a();
      }
    } while ((localObject == null) || ((((DrawerPushItem)localObject).msg_type != 7) && (((DrawerPushItem)localObject).msg_type != 9) && (((DrawerPushItem)localObject).msg_type != 2) && (((DrawerPushItem)localObject).msg_type != 10)));
    QLog.i("ApolloBubbleLogic", 1, "checkIfPanelBubble remove panel bubble");
    localApolloManagerServiceImpl.removePushItem((DrawerPushItem)localObject);
    localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a();
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp", 0);
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_";
    String str1 = (String)localObject1 + ApolloUtilImpl.getTodayKey();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    if (((SharedPreferences)localObject2).contains(str1)) {
      localEditor.putInt(str1, ((SharedPreferences)localObject2).getInt(str1, 0) + 1);
    }
    for (;;)
    {
      localEditor.commit();
      a(paramQQAppInterface);
      return;
      Object localObject3 = ((SharedPreferences)localObject2).getAll();
      localObject2 = new ArrayList();
      if (localObject3 != null)
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          String str2 = (String)localEntry.getKey();
          if ((str2 != null) && (str2.startsWith((String)localObject1))) {
            ((List)localObject2).add(localEntry.getKey());
          }
        }
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localEditor.remove((String)((Iterator)localObject1).next());
        }
      }
      localEditor.putInt(str1, 1);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext != null)
    {
      ApolloGameManager localApolloGameManager = (ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
      localApolloGameManager.jdField_a_of_type_Int = -1;
      localApolloGameManager.a(-1, -1);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = null;
    this.c = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    label304:
    for (;;)
    {
      return;
      b();
      return;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
      if ((localQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() != null) && (SpriteUtil.a(localQQAppInterface) != null))
      {
        SharedPreferences localSharedPreferences = localQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
        int i = localSharedPreferences.getInt(localQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_" + ApolloUtilImpl.getTodayKey(), 0);
        int j = localSharedPreferences.getInt("sp_key_aio_bubble_max_count", 3);
        if (i >= j)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "AIO Bubble show count limited:", Integer.valueOf(j) });
          }
        }
        else if (this.c)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, "current AIO has play bubble, wait for next time");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, "start play bubble");
          }
          if (a(localQQAppInterface)) {
            paramInt = 2;
          }
          for (;;)
          {
            if (paramInt <= 0) {
              break label304;
            }
            this.b = true;
            this.c = true;
            b(localQQAppInterface);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "AIO bubble play type:", Integer.valueOf(paramInt), ",current count:", Integer.valueOf(i), ",maxCount:", Integer.valueOf(j) });
            return;
            if (b(localQQAppInterface)) {
              paramInt = 3;
            } else {
              paramInt = 0;
            }
          }
        }
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    ApolloGameManager localApolloGameManager = (ApolloGameManager)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
    if (localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush != null) {}
    for (DrawerPushItem localDrawerPushItem = localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a();; localDrawerPushItem = null)
    {
      if ((localDrawerPushItem != null) && (localDrawerPushItem.msg_type != 7) && (localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int)))
      {
        if (localDrawerPushItem.reddotGameId > 0)
        {
          localApolloGameManager.jdField_a_of_type_Int = localDrawerPushItem.reddotGameId;
          localApolloGameManager.a(localDrawerPushItem.reddotGameId, 3);
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_msg_display", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 3, new String[] { String.valueOf(localDrawerPushItem.reddotGameId), String.valueOf(localDrawerPushItem.reddotRedId) });
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "show aio bubble for reddot game, game id=", Integer.valueOf(localDrawerPushItem.reddotGameId) });
          }
        }
        return true;
      }
      return false;
    }
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    ApolloGameManager localApolloGameManager = (ApolloGameManager)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
    if (localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush != null) {}
    for (Object localObject = localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a();; localObject = null)
    {
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((DrawerPushItem)localObject).msg_type == 7)
        {
          localObject = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
          bool1 = bool2;
          if (localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int))
          {
            if (localObject != null) {
              ((ApolloManagerServiceImpl)localObject).mIsBubbleTab = true;
            }
            VipUtils.a(null, "cmshow", "Apollo", "peoplebubble", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 0, new String[] { String.valueOf(1) });
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloBubbleLogic
 * JD-Core Version:    0.7.0.1
 */