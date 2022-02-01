package com.tencent.mobileqq.apollo.aio;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.OnActivityResultCallback;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.api.script.ISpriteActionScript;
import com.tencent.mobileqq.apollo.api.script.ISpriteUtil;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.CmShowStatUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneVipInfoManager;
import java.util.HashMap;
import java.util.Map;

public class ApolloHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private long b;
  
  public ApolloHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_Long = DeviceInfoUtil.i();
    this.b = DeviceInfoUtil.j();
    paramHelperProvider.a(this);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if ((paramIntent != null) && (paramInt1 == 14002) && (paramInt2 == -1))
    {
      localObject = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localObject != null) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            String str = paramIntent.getStringExtra("uin");
            paramInt1 = paramIntent.getIntExtra("uintype", -1);
            paramInt2 = paramIntent.getIntExtra("cmshow_game_id", -1);
            ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramInt1, (AbsStructMsg)localObject, null);
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "share_url_succeed", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramInt1), 0, new String[] { Integer.toString(paramInt2) });
            return;
            if (paramInt1 != 9999) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "isActionBack");
          }
          ((IApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 128, "apolloPanel");
          return;
          if (paramInt1 != 14003) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "check slave");
        }
        ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager().a(null);
        return;
      } while ((paramInt1 == 14004) || ((paramInt1 != 14006) && (paramInt1 != 14005)));
      localObject = CmGameUtil.a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).runRenderTask(new ApolloHelper.3(this, (ApolloSurfaceView)localObject, paramInt1, paramInt2, paramIntent));
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b.dismiss();
      }
      localObject2 = new ApolloFavActionData();
      localObject1 = (HashMap)paramObject;
      paramObject = (String)((Map)localObject1).get("optFrom");
    } while ((TextUtils.isEmpty(paramObject)) || (!"actionAdd".equals(paramObject)));
    int m = Integer.parseInt((String)((Map)localObject1).get("id"));
    String str2 = (String)((Map)localObject1).get("actionText");
    int i = 0;
    if (!TextUtils.isEmpty((String)((Map)localObject1).get("textType"))) {
      i = Integer.parseInt((String)((Map)localObject1).get("textType"));
    }
    int j = 0;
    paramObject = (String)((Map)localObject1).get("audioId");
    if (!TextUtils.isEmpty(paramObject)) {
      j = Integer.parseInt(paramObject);
    }
    float f = 0.0F;
    paramObject = (String)((Map)localObject1).get("audioTime");
    if (!TextUtils.isEmpty(paramObject)) {
      f = Float.parseFloat(paramObject);
    }
    int k = 0;
    paramObject = (String)((Map)localObject1).get("isPlayDefultAudio");
    if (!TextUtils.isEmpty(paramObject)) {
      k = Integer.parseInt(paramObject);
    }
    paramObject = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    ((ApolloFavActionData)localObject2).textType = i;
    ((ApolloFavActionData)localObject2).text = str2;
    ((ApolloFavActionData)localObject2).acitonId = m;
    ((ApolloFavActionData)localObject2).audioId = j;
    ((ApolloFavActionData)localObject2).audioStartTime = f;
    ((ApolloFavActionData)localObject2).playOriginalAudio = k;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloHelper", 2, "action auth success from add fav action=" + ((ApolloFavActionData)localObject2).toString());
      }
      ApolloItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (ApolloFavActionData)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    i = Integer.parseInt((String)((Map)localObject1).get("ret"));
    String str3 = "";
    Object localObject3 = null;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloHelper", 2, "action auth fail from fav add action=" + ((ApolloFavActionData)localObject2).toString() + " errcode = " + i);
    }
    paramObject.findActionById(m);
    String str1;
    switch (i)
    {
    default: 
      String str4 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690129);
      String str5 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690129);
      paramObject = str4;
      localObject1 = str5;
      str1 = str3;
      localObject2 = localObject3;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloHelper", 2, "unknown action auth errcode");
        localObject2 = localObject3;
        str1 = str3;
        localObject1 = str5;
        paramObject = str4;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 0, paramObject, (CharSequence)localObject1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695015), str1, (DialogInterface.OnClickListener)localObject2, new ApolloHelper.2(this));
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      str1 = "" + m;
      paramObject = str2;
      if (TextUtils.isEmpty(str2)) {
        paramObject = "0";
      }
      VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "add_action", (String)localObject2, i, 0, new String[] { str1, "", paramObject, String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    case 31004: 
    case 31005: 
      QZoneVipInfoManager.cmJumpToYellowPlayDialog((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
      return;
    case 31006: 
      label572:
      paramObject = (String)((Map)localObject1).get("content");
      if (TextUtils.isEmpty(paramObject)) {
        paramObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690121);
      }
      break;
    }
    for (;;)
    {
      localObject1 = (String)((Map)localObject1).get("url");
      localObject1 = (String)localObject1 + "&actionid=" + m;
      str3 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690120);
      str1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690120);
      localObject2 = new ApolloHelper.1(this, (String)localObject1, m);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "activity_alert_show", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + m, "1" });
      localObject1 = paramObject;
      paramObject = str3;
      break label572;
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690106), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloHelper", 2, "fav action network error");
      return;
    }
  }
  
  public String getTag()
  {
    return "ApolloHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14, 7, 19, 5 };
  }
  
  public void onMoveToState(int paramInt)
  {
    int i = 1;
    long l;
    switch (paramInt)
    {
    default: 
      return;
    case 14: 
      a();
      return;
    case 7: 
      CmShowStatUtil.a("aio_pre");
      return;
    case 19: 
      l = DeviceInfoUtil.a(true);
      if ((this.jdField_a_of_type_Long != l) && (this.jdField_a_of_type_Long != this.b)) {
        QLog.d("ApolloHelper", 1, new Object[] { "[doOnConfigurationChanged] screenWidth:", Long.valueOf(l), ",mLastScreenWidth:", Long.valueOf(this.jdField_a_of_type_Long), ",mLastScreenHeight:", Long.valueOf(this.b) });
      }
      break;
    }
    for (paramInt = i;; paramInt = 0)
    {
      this.jdField_a_of_type_Long = l;
      this.b = DeviceInfoUtil.j();
      if (paramInt == 0) {
        break;
      }
      ISpriteUtil localISpriteUtil = (ISpriteUtil)QRoute.api(ISpriteUtil.class);
      ISpriteActionScript localISpriteActionScript = localISpriteUtil.getActionScript(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localISpriteActionScript != null) {
        localISpriteActionScript.a(this.jdField_a_of_type_Long, this.b, localISpriteUtil.getAIOSurfaceInitWidth(), localISpriteUtil.getAIOSurfaceInitHeight());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      CmShowStatUtil.a();
      if (QLog.isColorLevel()) {
        QLog.i("ChatPieApolloViewController", 1, "START");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController = new ChatPieApolloViewController();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloHelper
 * JD-Core Version:    0.7.0.1
 */