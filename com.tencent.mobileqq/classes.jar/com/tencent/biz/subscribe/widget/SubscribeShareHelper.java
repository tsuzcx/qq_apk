package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShareQzoneInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import NS_COMM.COMM.Entry;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.network.SubscribeDeleteFeedRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class SubscribeShareHelper
{
  public static String a = "certified_account=1";
  public Activity a;
  private ShareInfoBean jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
  private SubscribeQRCodeShareHelper jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeQRCodeShareHelper;
  private IColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  public boolean a;
  private String b;
  private String c;
  
  public SubscribeShareHelper(Activity paramActivity)
  {
    this(paramActivity, null);
  }
  
  public SubscribeShareHelper(Activity paramActivity, SubscribeShareHelper.ShareActionItemClickListenr paramShareActionItemClickListenr)
  {
    boolean bool;
    if (Integer.parseInt(QzoneConfig.getInstance().getConfig("qqsubscribe", "ShowShopConfigEntrance", "0")) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
    localParam.context = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(localParam);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new SubscribeShareHelper.1(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new SubscribeShareHelper.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new SubscribeShareHelper.SheetItemClickProcessor(this, paramShareActionItemClickListenr));
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeQRCodeShareHelper == null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeQRCodeShareHelper = new SubscribeQRCodeShareHelper(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  private Intent a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    if ((localObject != null) && (((ShareInfoBean)localObject).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get())) {
        return null;
      }
      localObject = new Intent();
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ShareActionSheet shareToFriend");
      }
      ((Intent)localObject).putExtra("isWebCompShare", true);
      ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ForwardRecentActivity.class);
      ((Intent)localObject).putExtra("key_flag_from_plugin", true);
      ((Intent)localObject).putExtra("category", this.jdField_a_of_type_AndroidAppActivity.getString(2131695266));
      ((Intent)localObject).putExtra("forward_type", 1001);
      ((Intent)localObject).putExtra("detail_url", this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.b());
      ((Intent)localObject).putExtra("title", this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.f());
      ((Intent)localObject).putExtra("forward _key_nojump", true);
      ((Intent)localObject).putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696401, new Object[] { this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.f() }));
      ((Intent)localObject).putExtra("desc", a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.g()));
      ((Intent)localObject).putExtra("req_type", 1);
      ((Intent)localObject).putExtra("struct_share_key_content_action", "plugin");
      ((Intent)localObject).putExtra("pubUin", this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
      ((Intent)localObject).putExtra("pluginName", "public_account");
      ((Intent)localObject).putExtra("pubUin", this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
      ((Intent)localObject).putExtra("image_url_remote", this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get());
      ((Intent)localObject).putExtra("struct_share_key_content_action_DATA", a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get()));
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(((Intent)localObject).getExtras());
      if (localAbsStructMsg != null)
      {
        localAbsStructMsg.mMsgServiceID = 152;
        ((Intent)localObject).putExtra("stuctmsg_bytes", localAbsStructMsg.getBytes());
        ((Intent)localObject).putExtra("from_card", true);
        return localObject;
      }
    }
    return null;
  }
  
  public static String a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://qsubscribe");
    localStringBuilder.append("/");
    localStringBuilder.append("opendetail");
    localStringBuilder.append("?");
    localStringBuilder.append("src_type=internal");
    localStringBuilder.append("&version=1");
    localStringBuilder.append("&uin=");
    localStringBuilder.append(paramStFeed.poster.id.get());
    localStringBuilder.append("&feedId=");
    localStringBuilder.append(paramStFeed.id.get());
    localStringBuilder.append("&type=");
    localStringBuilder.append(paramStFeed.type.get());
    localStringBuilder.append("&width=");
    localStringBuilder.append(paramStFeed.video.width.get());
    localStringBuilder.append("&height=");
    localStringBuilder.append(paramStFeed.video.height.get());
    localStringBuilder.append("&createtime=");
    localStringBuilder.append(paramStFeed.createTime.get());
    return localStringBuilder.toString();
  }
  
  private static String a(CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((paramExtraTypeInfo != null) && (paramExtraTypeInfo.pageType == 7002)) {
      return String.format("https://h5.qzone.qq.com/subscription/report/%s?_proxy=1&_wv=3&usertype=%s", new Object[] { paramStFeed.poster.id.get(), Integer.valueOf(paramStFeed.poster.type.get()) });
    }
    return String.format("https://h5.qzone.qq.com/subscription/report/%s?_proxy=1&_wv=3&userid=%s&usertype=%s", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Integer.valueOf(paramStFeed.poster.type.get()) });
  }
  
  public static String a(ExtraTypeInfo paramExtraTypeInfo)
  {
    if (paramExtraTypeInfo == null) {
      return "";
    }
    int i = paramExtraTypeInfo.pageType;
    if (i != 8001)
    {
      switch (i)
      {
      default: 
        return "";
      case 7002: 
        return "person";
      case 7001: 
        return "multi_pic";
      }
      return "video";
    }
    return "image";
  }
  
  public static String a(ShareInfoBean paramShareInfoBean)
  {
    if (paramShareInfoBean != null)
    {
      String str = paramShareInfoBean.d();
      Object localObject = str;
      if (paramShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) {
        if (paramShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 7002)
        {
          localObject = str;
          if (paramShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 7005) {}
        }
        else
        {
          paramShareInfoBean = paramShareInfoBean.a().poster.desc.get();
          if ((!TextUtils.isEmpty(paramShareInfoBean)) && (!paramShareInfoBean.equals(HardCodeUtil.a(2131719357))))
          {
            localObject = paramShareInfoBean;
            if (!TextUtils.isEmpty(paramShareInfoBean.trim())) {}
          }
          else
          {
            localObject = HardCodeUtil.a(2131719356);
          }
        }
      }
      return localObject;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if ((paramString.length() <= 30) && (paramString.getBytes().length <= 100)) {
      return paramString;
    }
    Object localObject = paramString;
    if (paramString.length() > 30) {
      localObject = paramString.substring(0, 30);
    }
    paramString = (String)localObject;
    if (Math.min(((String)localObject).getBytes().length, 100) == 100)
    {
      int i = ((String)localObject).length() / 2;
      paramString = new StringBuilder(((String)localObject).substring(0, i));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(((String)localObject).charAt(i));
        i += 1;
      }
      paramString = paramString.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("...");
    return ((StringBuilder)localObject).toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://qsubscribe");
    localStringBuilder.append("/");
    localStringBuilder.append("openhomepage");
    localStringBuilder.append("?");
    localStringBuilder.append("src_type=internal");
    localStringBuilder.append("&version=1");
    localStringBuilder.append("&uid=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&nick=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&icon=");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  private List<Integer> a(ShareInfoBean paramShareInfoBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    if (paramShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) {
      return localArrayList;
    }
    int i = paramShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
    if ((i == 7000) || (i == 8001)) {
      localArrayList.add(Integer.valueOf(6));
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    if (localObject1 != null)
    {
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        return;
      }
      Object localObject2 = ((ShareInfoBean)localObject1).b();
      String str1 = a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.c());
      String str2 = a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.d());
      localObject1 = new HashMap(1);
      if ((localObject2 != null) && (!((String)localObject2).isEmpty()))
      {
        int i;
        if (!WXShareHelper.a().a()) {
          i = 2131720478;
        } else if (!WXShareHelper.a().b()) {
          i = 2131720479;
        } else {
          i = -1;
        }
        if (i != -1)
        {
          QRUtils.a(0, i);
          return;
        }
        f();
        localObject2 = new SubscribeShareHelper.4(this, (Map)localObject1, str1, str2, (String)localObject2, paramInt);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.e()))
        {
          ((Runnable)localObject2).run();
          return;
        }
        a(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        ThreadManager.post(new SubscribeShareHelper.5(this, (Map)localObject1, (Runnable)localObject2), 8, null, false);
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, HardCodeUtil.a(2131714438), 0).a();
    }
  }
  
  private void a(CertifiedAccountMeta.StFeed paramStFeed, int paramInt, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((paramStFeed != null) && (!StringUtil.a(paramStFeed.poster.id.get())) && (!StringUtil.a(paramStFeed.id.get())) && (paramExtraTypeInfo != null))
    {
      String str = paramStFeed.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clk_");
      localStringBuilder.append(a(paramExtraTypeInfo));
      VSReporter.a(str, "auth_share", localStringBuilder.toString(), paramInt, 0, new String[] { "", "", paramStFeed.id.get() });
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity);
    }
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    ShareInfoBean localShareInfoBean = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    if ((localShareInfoBean != null) && (localShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (a()) && ((this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7000) || (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7001) || (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8001))) {
      paramArrayList.add(Integer.valueOf(40));
    }
  }
  
  private boolean a()
  {
    ShareInfoBean localShareInfoBean = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    if ((localShareInfoBean != null) && (localShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)) {
      return SubscribeUtils.a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get());
    }
    return false;
  }
  
  @NotNull
  private List[] a(ShareInfoBean paramShareInfoBean)
  {
    List localList = a(paramShareInfoBean);
    paramShareInfoBean = b(paramShareInfoBean);
    if (((String)VSConfigManager.a().a("is_open_sharing", "1")).equals("1"))
    {
      ShareInfoBean localShareInfoBean = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
      if ((localShareInfoBean != null) && (localShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (SubscribeUtils.a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.status.get())))
      {
        i = 1;
        break label81;
      }
    }
    int i = 0;
    label81:
    if (i != 0) {
      return new List[] { localList, paramShareInfoBean };
    }
    return new List[] { paramShareInfoBean };
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(List<Integer>[] paramArrayOfList)
  {
    List[] arrayOfList = new List[paramArrayOfList.length];
    int i = 0;
    while (i < paramArrayOfList.length)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(((Integer)localIterator.next()).intValue()));
      }
      arrayOfList[i] = localArrayList;
      i += 1;
    }
    return arrayOfList;
  }
  
  private Intent b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    if ((localObject1 != null) && (((ShareInfoBean)localObject1).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shareCardInfo.get())))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ForwardRecentActivity.class);
      try
      {
        JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shareCardInfo.get());
        Object localObject2 = localJSONObject.getJSONObject("aio");
        localJSONObject = localJSONObject.getJSONObject("popUp");
        String str1 = ((JSONObject)localObject2).getString("app");
        String str2 = ((JSONObject)localObject2).getString("ver");
        String str3 = ((JSONObject)localObject2).getString("view");
        String str4 = ((JSONObject)localObject2).getString("meta");
        localObject2 = ((JSONObject)localObject2).getString("prompt");
        ((Intent)localObject1).putExtra("forward_type", 27);
        ((Intent)localObject1).putExtra("is_ark_display_share", true);
        ((Intent)localObject1).putExtra("forward_ark_app_name", str1);
        ((Intent)localObject1).putExtra("forward_ark_app_view", str3);
        ((Intent)localObject1).putExtra("forward_ark_app_ver", str2);
        ((Intent)localObject1).putExtra("forward_ark_app_prompt", (String)localObject2);
        ((Intent)localObject1).putExtra("forward_ark_app_meta", str4);
        localObject2 = localJSONObject.getString("app");
        str1 = localJSONObject.getString("ver");
        str2 = localJSONObject.getString("view");
        str3 = localJSONObject.getString("meta");
        localJSONObject.getString("prompt");
        ((Intent)localObject1).putExtras(QQCustomArkDialog.AppInfo.a((String)localObject2, str2, str1, str3, ArkAppCenterUtil.a(), null, null));
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localObject1;
      }
    }
    return null;
  }
  
  public static String b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return b(paramStFeed.poster.id.get());
  }
  
  public static String b(String paramString)
  {
    return String.format("https://h5.qzone.qq.com/subscription/homepage/%s?_proxy=1&_wv=16777217&_wwv=4", new Object[] { paramString });
  }
  
  private List<Integer> b(ShareInfoBean paramShareInfoBean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((paramShareInfoBean != null) && (paramShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (paramShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      paramShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.type.get();
      i = paramShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      Object localObject;
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
        if ((localObject != null) && (((IColorNoteController)localObject).shouldDisplayColorNote())) {
          if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.isColorNoteExist()) {
            localArrayList.add(Integer.valueOf(82));
          } else {
            localArrayList.add(Integer.valueOf(70));
          }
        }
      }
      a(localArrayList);
      if (i == 7002)
      {
        if (a())
        {
          localObject = this.jdField_a_of_type_AndroidAppActivity;
          if (localObject != null) {
            ((Activity)localObject).getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_mainhp");
          }
          if (b())
          {
            localArrayList.add(Integer.valueOf(155));
            VSReporter.b(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_shoplist", 0, 0, new String[0]);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localArrayList.add(Integer.valueOf(157));
            localObject = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
            if ((localObject != null) && (((ShareInfoBean)localObject).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)) {
              VSReporter.a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_shop", 0, 0, new String[0]);
            }
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_AndroidAppActivity;
          if (localObject != null) {
            ((Activity)localObject).getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_guesthp");
          }
        }
      }
      else if (this.jdField_a_of_type_AndroidAppActivity != null) {
        if (a()) {
          this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_main");
        } else {
          this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_dyh_guest");
        }
      }
      if ((paramShareInfoBean.jdField_a_of_type_Boolean) && (!a())) {
        localArrayList.add(Integer.valueOf(11));
      }
      int j = QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntrance", 1);
      if ((i == 7002) && (a()) && (j == 1)) {
        localArrayList.add(Integer.valueOf(152));
      }
      if ((i == 7002) && (paramShareInfoBean.b)) {
        localArrayList.add(Integer.valueOf(154));
      }
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.c)
    {
      i = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      if ((i == 7001) || (i == 7002) || (i == 7005) || (i == 7000)) {
        localArrayList.add(Integer.valueOf(153));
      }
    }
    return localArrayList;
  }
  
  private boolean b()
  {
    ShareInfoBean localShareInfoBean = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    if ((localShareInfoBean != null) && (localShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)) {
      return SubscribeUtils.d(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get());
    }
    return false;
  }
  
  public static String c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/imagedetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    if (localObject != null)
    {
      if (((ShareInfoBean)localObject).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
        return;
      }
      localObject = new SubscribeDeleteFeedRequest(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new SubscribeShareHelper.3(this));
    }
    try
    {
      VSReporter.a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.a(), "auth_share", "delete", 0, 0, new String[] { "", "", ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.author.get()).nick.get(), this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.c() });
      return;
    }
    catch (Exception localException) {}
  }
  
  public static String d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/carousel/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    if ((localObject != null) && (((ShareInfoBean)localObject).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      String str1 = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.c();
      this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.d();
      String str2 = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.e();
      String str3 = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.a();
      int i = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      if (i != 8001) {
        switch (i)
        {
        default: 
          localObject = null;
          break;
        case 7002: 
          localObject = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.b();
          break;
        }
      } else {
        localObject = a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      }
      String str4 = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.f();
      QfavBuilder.a(3, str1, (String)localObject, null, null, str2, null, null, false, -1L).c(str3).a("lCategory", 10L).b("sUin", str4).b("sName", str4).c(this.jdField_a_of_type_AndroidAppActivity, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 2, null);
    }
  }
  
  public static String e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/videodetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private void e()
  {
    SubscribeLaucher.a(a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new SubscribeShareHelper.6(this);
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  private void g()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.c());
    localBundle.putString("desc", a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean));
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.b());
    ((StringBuilder)localObject1).append("&source=qzone");
    localBundle.putString("detail_url", ((StringBuilder)localObject1).toString());
    localObject1 = new ArrayList(1);
    ((ArrayList)localObject1).add(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.e());
    localBundle.putStringArrayList("image_url", (ArrayList)localObject1);
    localBundle.putLong("req_share_id", 0L);
    if (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shareQzoneInfo.entrys.get();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new SerializableMap();
        HashMap localHashMap = new HashMap();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          COMM.Entry localEntry = (COMM.Entry)((Iterator)localObject2).next();
          localHashMap.put(localEntry.key.get(), localEntry.value.get());
        }
        ((SerializableMap)localObject1).setMap(localHashMap);
        break label235;
      }
    }
    localObject1 = null;
    label235:
    localBundle.putSerializable("share_qzone_info", (Serializable)localObject1);
    QZoneShareManager.jumpToQzoneShare(String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()), this.jdField_a_of_type_AndroidAppActivity, localBundle, null, -1);
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
    int i = 1;
    if (localObject != null)
    {
      int j = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      if (j != 8001)
      {
        switch (j)
        {
        default: 
          break;
        case 7002: 
          localObject = a();
          break;
        case 7000: 
          localObject = b();
          break;
        }
      }
      else
      {
        localObject = b();
        break label92;
      }
    }
    localObject = null;
    i = 21;
    label92:
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if (localObject != null) {
        QQToast.a((Context)localObject, HardCodeUtil.a(2131714441), 0).a();
      }
      return;
    }
    if (localObject != null)
    {
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      if (localActivity != null) {
        localActivity.startActivityForResult((Intent)localObject, i);
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if ((localObject != null) && (((ShareActionSheet)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeQRCodeShareHelper;
    if (localObject != null) {
      ((SubscribeQRCodeShareHelper)localObject).a();
    }
  }
  
  public void a(ShareInfoBean paramShareInfoBean, IColorNoteController paramIColorNoteController)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null) {
      return;
    }
    ShareInfoBean localShareInfoBean = paramShareInfoBean;
    if (paramShareInfoBean == null) {
      localShareInfoBean = new ShareInfoBean();
    }
    this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean = localShareInfoBean;
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = paramIColorNoteController;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get())))
    {
      paramShareInfoBean = a(localShareInfoBean);
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(a(paramShareInfoBean));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      SimpleEventBus.getInstance().dispatchEvent(new SharePanelShowStateEvent(true));
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131714452), 0).a();
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
    }
  }
  
  public void b()
  {
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if ((localShareActionSheet != null) && (localShareActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper
 * JD-Core Version:    0.7.0.1
 */