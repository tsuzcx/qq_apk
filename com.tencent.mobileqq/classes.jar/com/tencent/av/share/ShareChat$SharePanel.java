package com.tencent.av.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class ShareChat$SharePanel
{
  int jdField_a_of_type_Int = -1;
  final long jdField_a_of_type_Long;
  ShareChat.SharePanel.IHandle jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle = null;
  ShareChat.SharePanel.MyOnItemClickListener jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$MyOnItemClickListener;
  ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  String jdField_a_of_type_JavaLangString = null;
  int b;
  
  ShareChat$SharePanel(long paramLong, int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(long paramLong, Context paramContext, boolean paramBoolean, int paramInt, String paramString, ShareChat.SharePanel.IHandle paramIHandle)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    Bitmap localBitmap = null;
    if (paramIHandle != null) {
      localBitmap = paramIHandle.a(paramLong);
    }
    localBitmap = TroopShareUtility.a(localBitmap);
    String str2 = ShareChat.a(paramContext);
    paramIHandle = ShareChat.a(paramIHandle);
    int i;
    if (paramBoolean)
    {
      i = 3;
      a(paramLong, paramContext, str1, i, paramInt);
      if (!paramBoolean) {
        break label160;
      }
      WXShareHelper.a().a(str1, str2, localBitmap, paramIHandle, paramString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShareChat", 1, "shareToWX, mWXTransaction[" + str1 + "], bFriendCircle[" + paramBoolean + "], shareLink[" + paramString + "], seq[" + paramLong + "]");
      }
      return;
      i = 2;
      break;
      label160:
      paramContext = TroopShareUtility.a(paramIHandle, paramContext);
      WXShareHelper.a().b(str1, str2, localBitmap, paramContext, paramString);
    }
  }
  
  private void b(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString)
  {
    String str = ShareChat.b(paramIHandle);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(str)) {
      localArrayList.add(str);
    }
    str = paramContext.getString(2131693152) + paramString;
    Bundle localBundle = new Bundle();
    localBundle.putString("title", ShareChat.a(paramContext));
    localBundle.putString("desc", ShareChat.a(paramIHandle));
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", paramString);
    localBundle.putString("url", paramString);
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("troop_wording", str);
    localBundle.putString("bizname", "JoinTroopLink");
    localBundle.putParcelable("PARAM_ActivityResultReceiver", new ShareChat.MyResultReceiver(new Handler(), this, 1, paramInt, paramLong));
    QZoneShareManager.jumpToQzoneShare((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramContext, localBundle, null, 145);
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "shareToQzone, shareLink[" + paramString + "], seq[" + paramLong + "]");
    }
  }
  
  private void b(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramIHandle == null) || (paramActionSheetItem == null)) {
      return;
    }
    try
    {
      Object localObject2 = ShareChat.a(paramContext);
      String str1 = ShareChat.a(paramContext);
      Object localObject4 = ShareChat.a(paramIHandle);
      String str2 = ShareChat.b(paramIHandle);
      String str3 = paramContext.getString(2131693150);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("prompt", localObject2);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("forward", true);
      ((JSONObject)localObject2).put("autosize", true);
      ((JSONObject)localObject1).put("config", localObject2);
      ((JSONObject)localObject1).put("app", "com.tencent.qqavchat");
      ((JSONObject)localObject1).put("ver", "0.0.0.1");
      ((JSONObject)localObject1).put("view", "qqavchat");
      localObject2 = new JSONObject();
      Object localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("title", str1);
      ((JSONObject)localObject3).put("desc", localObject4);
      ((JSONObject)localObject3).put("preview", str2);
      ((JSONObject)localObject3).put("tag", str3);
      ((JSONObject)localObject3).put("jumpUrl", paramString);
      if (paramIHandle.a() == 99)
      {
        paramString = paramIHandle.a();
        ((JSONObject)localObject3).put("gav_ark_from_type", "gav_ark_share_from_chatting");
        ((JSONObject)localObject3).put("gav_ark_group_name_key", paramString.troopName);
        ((JSONObject)localObject3).put("gav_ark_group_owner_key", paramString.bOwner);
        ((JSONObject)localObject3).put("gav_ark_group_admin_key", paramString.bAdmin);
        ((JSONObject)localObject3).put("gav_ark_group_card_key", paramString.troopCard);
        ((JSONObject)localObject3).put("gav_ark_room_id_key", paramIHandle.a());
        ((JSONObject)localObject3).put("gav_ark_room_create_time_key", paramIHandle.b());
        ((JSONObject)localObject3).put("gav_ark_group_uin_key", this.jdField_a_of_type_JavaLangString);
      }
      paramIHandle = paramIHandle.a(0);
      if (!TextUtils.isEmpty(paramIHandle))
      {
        paramString = new JSONObject();
        paramString.put("type", paramIHandle);
        paramString.put("name", paramIHandle);
        paramString.put("reportType", "898");
        paramString.put("r2", StringUtil.a("ShareChat", this.jdField_a_of_type_JavaLangString));
        ((JSONObject)localObject3).put("report", paramString);
      }
      ((JSONObject)localObject2).put("news", localObject3);
      ((JSONObject)localObject1).put("meta", localObject2);
      localObject4 = ((JSONObject)localObject1).toString();
      paramIHandle = ((JSONObject)localObject1).getString("app");
      paramString = ((JSONObject)localObject1).getString("ver");
      localObject2 = ((JSONObject)localObject1).getString("view");
      localObject3 = ((JSONObject)localObject1).getString("config");
      str1 = ((JSONObject)localObject1).getString("meta");
      localObject1 = ((JSONObject)localObject1).getString("prompt");
      QLog.w("ShareChat", 1, "shareToMobileQQ, data[" + (String)localObject4 + "], appName[" + paramIHandle + "], appMinVersion[" + paramString + "], appView[" + (String)localObject2 + "], config[" + (String)localObject3 + "], metaList[" + str1 + "], promptText[" + (String)localObject1 + "], seq[" + paramLong + "]");
      localObject4 = new Intent();
      ((Intent)localObject4).putExtra("forward_type", 27);
      ((Intent)localObject4).putExtra("is_ark_display_share", true);
      ((Intent)localObject4).putExtra("forward_ark_app_name", paramIHandle);
      ((Intent)localObject4).putExtra("forward_ark_app_view", (String)localObject2);
      ((Intent)localObject4).putExtra("forward_ark_app_ver", paramString);
      ((Intent)localObject4).putExtra("forward_ark_app_prompt", (String)localObject1);
      ((Intent)localObject4).putExtra("forward_ark_app_meta", str1);
      ((Intent)localObject4).putExtra("forward_ark_app_config", (String)localObject3);
      paramIHandle = QQCustomArkDialog.AppInfo.a(paramIHandle, (String)localObject2, paramString, str1, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null);
      paramIHandle.putInt("key_req", ForwardRecentActivity.f);
      paramIHandle.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
      paramIHandle.putString("key_direct_show_uin", paramActionSheetItem.uin);
      ((Intent)localObject4).putExtras(paramIHandle);
      ((Intent)localObject4).putExtra("PARAM_ActivityResultReceiver", new ShareChat.MyResultReceiver(new Handler(), this, 3, paramInt, paramLong));
      ForwardBaseOption.a((Activity)paramContext, (Intent)localObject4, ForwardRecentTranslucentActivity.class, -1);
      return;
    }
    catch (Exception paramIHandle)
    {
      QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + paramLong + "]", paramIHandle);
      QQToast.a(paramContext, HardCodeUtil.a(2131713852), 0).a();
      a(0, paramInt, 3);
    }
  }
  
  private void c(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString)
  {
    paramIHandle = paramContext.getString(2131693152) + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "copyTroopLink, text[" + paramIHandle + "], seq[" + paramLong + "]");
    }
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("troop_url", paramIHandle));
    QQToast.a(paramContext, 2, 2131693153, 0).a();
    a(4, paramInt, 2);
  }
  
  private void c(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle == null) {
      QLog.w("ShareChat", 1, "tryToGetShareLink, mIHandle为空");
    }
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle.a(paramLong, this.b);
      if (TextUtils.isEmpty(str))
      {
        boolean bool = NetworkUtil.d(null);
        QLog.w("ShareChat", 1, "tryToGetShareLink, url为空, isConn[" + bool + "], mChoosedChannel[" + this.jdField_a_of_type_Int + "], mChoosedLinkType[" + this.b + "], seq[" + paramLong + "]");
        if ((!bool) && (this.jdField_a_of_type_Int != 4))
        {
          QQToast.a(paramContext, paramContext.getString(2131692257), 0).a();
          if (QLog.isColorLevel()) {
            QLog.w("ShareChat", 1, "tryToGetShareLink, !isNetSupport, mChoosedChannel[" + this.jdField_a_of_type_Int + "]");
          }
        }
        for (;;)
        {
          a(this.jdField_a_of_type_Int, this.b, 3);
          return;
          QQToast.a(paramContext, HardCodeUtil.a(2131713850), 0).a();
        }
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 0: 
      case 73: 
        a(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, str, paramActionSheetItem);
        return;
      case 3: 
        a(paramLong, paramContext, true, this.b, str, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle);
        return;
      case 2: 
        a(paramLong, paramContext, false, this.b, str, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle);
        return;
      case 72: 
        b(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, str, paramActionSheetItem);
        return;
      case 1: 
        b(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, str);
        return;
      case 4: 
        c(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, str);
        return;
      case 5: 
        a(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, str);
        return;
      case 26: 
        d(paramLong, paramContext, this.b, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle, str);
        return;
      }
    } while (!QfavBuilder.a(str).a(paramContext, paramActionSheetItem.uin, 103, null));
    QQToast.a(paramContext, 2, 2131692259, 0).a();
  }
  
  private void d(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString)
  {
    if (paramIHandle == null) {
      return;
    }
    paramIHandle = new Intent(paramContext, DirectForwardActivity.class);
    paramIHandle.putExtra("isFromShare", true);
    paramIHandle.putExtra("isFromTeamWork", true);
    paramIHandle.putExtra("toUin", AppConstants.DATALINE_PC_UIN);
    paramIHandle.putExtra("uinType", 6000);
    paramIHandle.putExtra("forward_type", -1);
    paramIHandle.putExtra("forward_text", paramContext.getResources().getText(2131693152) + paramString);
    paramIHandle.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    paramContext.startActivity(paramIHandle);
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle != null) {
      this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle.a(paramInt1, paramInt2, paramInt3);
    }
    a();
  }
  
  void a(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString)
  {
    TroopInfoData localTroopInfoData = paramIHandle.a();
    if (localTroopInfoData == null)
    {
      a(5, paramInt, 3);
      return;
    }
    Intent localIntent = new Intent(paramContext, QRDisplayActivity.class);
    localIntent.putExtra("title", paramContext.getString(2131716901));
    int i;
    if (TextUtils.isEmpty(localTroopInfoData.troopName))
    {
      localIntent.putExtra("nick", localTroopInfoData.newTroopName);
      paramIHandle = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("uin", localTroopInfoData.troopUin);
      if (!localTroopInfoData.bOwner) {
        break label343;
      }
      i = 0;
      label122:
      localIntent.putExtra("adminLevel", i);
      localIntent.putExtra("type", 11);
      localIntent.putExtra("GroupFlagExt", localTroopInfoData.dwGroupFlagExt);
      localIntent.putExtra("AuthGroupType", localTroopInfoData.dwAuthGroupType);
      if (!(paramIHandle instanceof QQAppInterface)) {
        break label363;
      }
    }
    label343:
    label363:
    for (paramIHandle = (QQAppInterface)paramIHandle;; paramIHandle = null)
    {
      boolean bool = false;
      if (paramIHandle != null) {
        bool = ((TroopManager)paramIHandle.getManager(QQManagerFactory.TROOP_MANAGER)).n(localTroopInfoData.troopUin);
      }
      localIntent.putExtra("isQidianPrivateTroop", bool);
      if (bool) {
        localIntent.putExtra("groupOwner", localTroopInfoData.troopowneruin);
      }
      localIntent.putExtra("PARAM_QRForwardReceiver", new ShareChat.MyResultReceiver(new Handler(), this, 4, paramInt, paramLong));
      localIntent.putExtra("PARAM_ActivityResultReceiver", new ShareChat.MyResultReceiver(new Handler(), this, 5, paramInt, paramLong));
      ThreadManager.post(new ShareChat.SharePanel.1(this, paramIHandle, localTroopInfoData, localIntent, paramContext, paramInt), 8, null, true);
      return;
      localIntent.putExtra("nick", localTroopInfoData.troopName);
      break;
      if (localTroopInfoData.bAdmin)
      {
        i = 1;
        break label122;
      }
      i = 2;
      break label122;
    }
  }
  
  public void a(long paramLong, Context paramContext, int paramInt, ShareChat.SharePanel.IHandle paramIHandle, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramIHandle == null) {
      return;
    }
    try
    {
      Object localObject1 = ShareChat.a(paramContext);
      String str1 = ShareChat.a(paramContext);
      Object localObject3 = ShareChat.a(paramIHandle);
      String str2 = ShareChat.b(paramIHandle);
      String str3 = paramContext.getString(2131693150);
      paramActionSheetItem = new JSONObject();
      paramActionSheetItem.put("prompt", localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("forward", true);
      ((JSONObject)localObject1).put("autosize", true);
      paramActionSheetItem.put("config", localObject1);
      paramActionSheetItem.put("app", "com.tencent.qqavchat");
      paramActionSheetItem.put("ver", "0.0.0.1");
      paramActionSheetItem.put("view", "qqavchat");
      localObject1 = new JSONObject();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("title", str1);
      ((JSONObject)localObject2).put("desc", localObject3);
      ((JSONObject)localObject2).put("preview", str2);
      ((JSONObject)localObject2).put("tag", str3);
      ((JSONObject)localObject2).put("jumpUrl", paramString);
      if (paramIHandle.a() == 99)
      {
        paramString = paramIHandle.a();
        ((JSONObject)localObject2).put("gav_ark_from_type", "gav_ark_share_from_chatting");
        ((JSONObject)localObject2).put("gav_ark_group_name_key", paramString.troopName);
        ((JSONObject)localObject2).put("gav_ark_group_owner_key", paramString.bOwner);
        ((JSONObject)localObject2).put("gav_ark_group_admin_key", paramString.bAdmin);
        ((JSONObject)localObject2).put("gav_ark_group_card_key", paramString.troopCard);
        ((JSONObject)localObject2).put("gav_ark_room_id_key", paramIHandle.a());
        ((JSONObject)localObject2).put("gav_ark_room_create_time_key", paramIHandle.b());
        ((JSONObject)localObject2).put("gav_ark_group_uin_key", this.jdField_a_of_type_JavaLangString);
      }
      paramIHandle = paramIHandle.a(0);
      if (!TextUtils.isEmpty(paramIHandle))
      {
        paramString = new JSONObject();
        paramString.put("type", paramIHandle);
        paramString.put("name", paramIHandle);
        paramString.put("reportType", "898");
        paramString.put("r2", StringUtil.a("ShareChat", this.jdField_a_of_type_JavaLangString));
        ((JSONObject)localObject2).put("report", paramString);
      }
      ((JSONObject)localObject1).put("news", localObject2);
      paramActionSheetItem.put("meta", localObject1);
      localObject3 = paramActionSheetItem.toString();
      paramIHandle = paramActionSheetItem.getString("app");
      paramString = paramActionSheetItem.getString("ver");
      localObject1 = paramActionSheetItem.getString("view");
      localObject2 = paramActionSheetItem.getString("config");
      str1 = paramActionSheetItem.getString("meta");
      paramActionSheetItem = paramActionSheetItem.getString("prompt");
      QLog.w("ShareChat", 1, "shareToMobileQQ, data[" + (String)localObject3 + "], appName[" + paramIHandle + "], appMinVersion[" + paramString + "], appView[" + (String)localObject1 + "], config[" + (String)localObject2 + "], metaList[" + str1 + "], promptText[" + paramActionSheetItem + "], seq[" + paramLong + "]");
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("forward_type", 27);
      ((Intent)localObject3).putExtra("is_ark_display_share", true);
      ((Intent)localObject3).putExtra("forward_ark_app_name", paramIHandle);
      ((Intent)localObject3).putExtra("forward_ark_app_view", (String)localObject1);
      ((Intent)localObject3).putExtra("forward_ark_app_ver", paramString);
      ((Intent)localObject3).putExtra("forward_ark_app_prompt", paramActionSheetItem);
      ((Intent)localObject3).putExtra("forward_ark_app_meta", str1);
      ((Intent)localObject3).putExtra("forward_ark_app_config", (String)localObject2);
      ((Intent)localObject3).putExtras(QQCustomArkDialog.AppInfo.a(paramIHandle, (String)localObject1, paramString, str1, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null));
      ((Intent)localObject3).putExtra("PARAM_ActivityResultReceiver", new ShareChat.MyResultReceiver(new Handler(), this, 2, paramInt, paramLong));
      ForwardBaseOption.a(paramContext, (Intent)localObject3);
      return;
    }
    catch (Exception paramIHandle)
    {
      QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + paramLong + "]", paramIHandle);
      QQToast.a(paramContext, HardCodeUtil.a(2131713852), 0).a();
      a(0, paramInt, 3);
    }
  }
  
  void a(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.b = 0;
    c(paramLong, paramContext, paramActionSheetItem);
  }
  
  void a(long paramLong, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    WXShareHelper.a().a(new ShareChat.SharePanel.MyWXShareListener(this, paramLong, paramContext, paramString, paramInt1, paramInt2));
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      return;
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = paramContext;
    ((ShareActionSheetV2.Param)localObject).fullScreen = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(paramContext.getString(2131719311));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(((Activity)paramContext).getIntent());
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    paramContext = new ArrayList();
    localObject = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    if (paramInt != 99) {
      paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    }
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    if (paramInt != 99)
    {
      ((List)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(1));
      ((List)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(6));
      ((List)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(123));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(paramContext, (List)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new ShareChat.SharePanel.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$MyOnItemClickListener);
  }
  
  void a(Context paramContext, String paramString, int paramInt, ShareChat.SharePanel.IHandle paramIHandle)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle = paramIHandle;
    this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$MyOnItemClickListener = new ShareChat.SharePanel.MyOnItemClickListener(this, paramContext);
    this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$MyOnItemClickListener.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    a(paramContext, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
  }
  
  void b(long paramLong, Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.b = 1;
    c(paramLong, paramContext, paramActionSheetItem);
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Long + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel
 * JD-Core Version:    0.7.0.1
 */