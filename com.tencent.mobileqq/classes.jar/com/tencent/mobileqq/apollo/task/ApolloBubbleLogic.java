package com.tencent.mobileqq.apollo.task;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteStatusChanged;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ApolloBubbleLogic
  implements ISpriteStatusChanged
{
  private int jdField_a_of_type_Int = 1;
  SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  
  public ApolloBubbleLogic(SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (localObject == null) {}
    ApolloGameManager localApolloGameManager;
    ApolloManager localApolloManager;
    do
    {
      return;
      localApolloGameManager = (ApolloGameManager)((QQAppInterface)localObject).getManager(210);
      localApolloManager = (ApolloManager)((QQAppInterface)localObject).getManager(152);
      localObject = null;
      if (localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush != null) {
        localObject = localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a();
      }
    } while ((localObject == null) || (((DrawerPushItem)localObject).msg_type != 7));
    QLog.i("ApolloBubbleLogic", 1, "checkIfPanelBubble remove panel bubble");
    localApolloManager.a((DrawerPushItem)localObject);
    localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    Object localObject3;
    SpriteActionScript localSpriteActionScript;
    boolean bool1;
    ApolloManager localApolloManager;
    Object localObject2;
    Object localObject4;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              b();
              return;
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
            } while ((localObject3 == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null));
            localSpriteActionScript = SpriteUtil.a((QQAppInterface)localObject3);
          } while (localSpriteActionScript == null);
          localObject1 = ((QQAppInterface)localObject3).getApp().getSharedPreferences("apollo_sp", 0);
          bool1 = ((SharedPreferences)localObject1).getBoolean("is_add_new_game" + ((QQAppInterface)localObject3).getCurrentAccountUin(), false);
          localApolloManager = (ApolloManager)((QQAppInterface)localObject3).getManager(152);
          if ((!bool1) || (localApolloManager == null) || (ApolloManager.c("gameSwitch") != 1)) {
            break;
          }
          localObject2 = "new_added_game_id" + ((QQAppInterface)localObject3).getCurrentAccountUin();
          paramInt = ((SharedPreferences)localObject1).getInt((String)localObject2, -1);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "new added game id=", Integer.valueOf(paramInt) });
          }
        } while (paramInt == -1);
        localObject4 = (ApolloDaoManager)((QQAppInterface)localObject3).getManager(154);
      } while (localObject4 == null);
      localObject4 = ((ApolloDaoManager)localObject4).a(paramInt);
    } while ((localObject4 == null) || (TextUtils.isEmpty(((ApolloGameData)localObject4).name)));
    localSpriteActionScript.a("", String.format("马上来玩%s", new Object[] { ((ApolloGameData)localObject4).name }));
    ((ApolloGameManager)((QQAppInterface)localObject3).getManager(210)).jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBubbleLogic", 2, new Object[] { "show aio bubble for new added game, game id=", Integer.valueOf(paramInt), ", game name=", ((ApolloGameData)localObject4).name });
    }
    Object localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).remove((String)localObject2);
    ((SharedPreferences.Editor)localObject1).commit();
    VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "aio_msg_display", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 2, new String[] { String.valueOf(((ApolloGameData)localObject4).gameId), "0" });
    return;
    ApolloGameManager localApolloGameManager = (ApolloGameManager)((QQAppInterface)localObject3).getManager(210);
    boolean bool2 = false;
    if (localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush != null) {}
    for (localObject1 = localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a();; localObject1 = null)
    {
      bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (((DrawerPushItem)localObject1).msg_type != 7)
        {
          bool1 = localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a((QQAppInterface)localObject3, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int);
          if ((bool1) && (((DrawerPushItem)localObject1).msg_type == 4))
          {
            localApolloGameManager.jdField_a_of_type_Int = ((DrawerPushItem)localObject1).reddotGameId;
            VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "aio_msg_display", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 3, new String[] { String.valueOf(((DrawerPushItem)localObject1).reddotGameId), String.valueOf(((DrawerPushItem)localObject1).reddotRedId) });
            if (QLog.isColorLevel()) {
              QLog.d("ApolloBubbleLogic", 2, new Object[] { "show aio bubble for reddot game, game id=", Integer.valueOf(((DrawerPushItem)localObject1).reddotGameId) });
            }
          }
        }
      }
      if (bool1) {
        break;
      }
      localObject2 = null;
      localObject4 = ((QQAppInterface)localObject3).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject3).c(), 0);
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = ApolloGameUtil.a((QQAppInterface)localObject3);
      Object localObject5 = (ApolloDaoManager)((QQAppInterface)localObject3).getManager(154);
      int i = 0;
      paramInt = 0;
      if (((ApolloDaoManager)localObject5).b != null)
      {
        localObject5 = ((ApolloDaoManager)localObject5).b.iterator();
        label677:
        ApolloActionPackage localApolloActionPackage;
        do
        {
          i = paramInt;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localApolloActionPackage = (ApolloActionPackage)((Iterator)localObject5).next();
        } while (localApolloActionPackage == null);
        if (localApolloActionPackage.packageId != 100) {
          break label1179;
        }
        paramInt = 1;
      }
      label1162:
      label1173:
      label1179:
      for (;;)
      {
        break label677;
        if ((((SharedPreferences)localObject4).getBoolean("aio_game_bubble", false)) && (l1 - l2 < 604800000L) && (i != 0))
        {
          paramInt = ((SharedPreferences)localObject4).getInt("aio_bubble_recommend_game_id", -1);
          if (paramInt == -1) {
            break label1173;
          }
          localObject1 = (ApolloDaoManager)((QQAppInterface)localObject3).getManager(154);
          if (localObject1 == null) {
            break label1173;
          }
          localObject2 = ((ApolloDaoManager)localObject1).a(paramInt);
          if ((localObject2 == null) || (TextUtils.isEmpty(((ApolloGameData)localObject2).name))) {
            break label1173;
          }
          localObject1 = String.format("马上来玩%s", new Object[] { ((ApolloGameData)localObject2).name });
          localApolloGameManager.jdField_a_of_type_Int = paramInt;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "show aio bubble for recommend game, game id=", Integer.valueOf(paramInt), ", game name=", ((ApolloGameData)localObject2).name });
          }
          VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "aio_msg_display", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 1, new String[] { String.valueOf(((ApolloGameData)localObject2).gameId), "0" });
          ((SharedPreferences)localObject4).edit().remove("aio_bubble_recommend_game_id").commit();
        }
        for (;;)
        {
          localObject3 = "aio_game_bubble";
          localObject2 = localObject1;
          localObject1 = localObject3;
          label953:
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((SharedPreferences)localObject4).getBoolean((String)localObject1, false)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloBubbleLogic", 2, new Object[] { "notifyAddBubble， text=", localObject2 });
            }
            localSpriteActionScript.a("", (String)localObject2);
            ((SharedPreferences)localObject4).edit().putBoolean((String)localObject1, false).commit();
            if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int != 3000) {
              break label1162;
            }
          }
          for (paramInt = 2;; paramInt = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int)
          {
            VipUtils.a(null, "cmshow", "Apollo", "peoplebubble", paramInt, 0, new String[] { String.valueOf(0) });
            return;
            if ((localObject1 != null) && (((DrawerPushItem)localObject1).msg_type == 7))
            {
              localApolloGameManager.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a((QQAppInterface)localObject3, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int);
              if (localApolloManager != null) {
                localApolloManager.f = true;
              }
              VipUtils.a(null, "cmshow", "Apollo", "peoplebubble", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 0, new String[] { String.valueOf(1) });
            }
            localObject1 = null;
            break label953;
            break;
          }
          localObject1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloBubbleLogic
 * JD-Core Version:    0.7.0.1
 */