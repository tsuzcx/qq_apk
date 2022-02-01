package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.subscribe.SubscribeGlobalInfo;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.minicode.Utils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class SubscribeQRCodeShareHelper
{
  public static final String a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ShareInfoBean jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
  private AbsSubscribeShareCardView jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView;
  private SubscirbeLoadingDialog jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog;
  private ShareActionSheet.OnItemClickListener jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener = new SubscribeQRCodeShareHelper.4(this);
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  private final String b = "https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=";
  private final String c = AppConstants.SDCARD_PATH + "subscribe_card/";
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + "subscribe_shared_card/";
  }
  
  public SubscribeQRCodeShareHelper(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramActivity = ThreadManager.newFreeHandlerThread("subscribe_create_card", 0);
    paramActivity.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramActivity.getLooper());
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.1(this));
  }
  
  private AbsSubscribeShareCardView a()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null)) {
      switch (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      }
    }
    do
    {
      return null;
      return new SubscribeVideoSharedCardView(this.jdField_a_of_type_AndroidAppActivity);
      return new SubscribeMultiPicSharedCardView(this.jdField_a_of_type_AndroidAppActivity);
      if (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_Int == 1) {
        return new SubScribePersonalSharedCardView(this.jdField_a_of_type_AndroidAppActivity);
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_Int == 3) {
        return new SubscribeVideoSharedCardView(this.jdField_a_of_type_AndroidAppActivity);
      }
    } while (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_Int != 4);
    return new SubscribeMultiPicSharedCardView(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      switch (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      case 7003: 
      case 7004: 
      default: 
        return "";
      case 7000: 
      case 7001: 
        return c();
      }
      return b();
    }
    return "";
  }
  
  /* Error */
  private String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 142	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 149	java/io/File:exists	()Z
    //   13: ifne +7 -> 20
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_2
    //   19: areturn
    //   20: aload_1
    //   21: ldc 151
    //   23: aload_3
    //   24: invokestatic 157	android/support/v4/content/FileProvider:getUriForFile	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;
    //   27: astore_3
    //   28: aload_1
    //   29: ldc 159
    //   31: aload_3
    //   32: iconst_1
    //   33: invokevirtual 165	android/content/Context:grantUriPermission	(Ljava/lang/String;Landroid/net/Uri;I)V
    //   36: aload_3
    //   37: ifnull -19 -> 18
    //   40: aload_3
    //   41: invokevirtual 168	android/net/Uri:toString	()Ljava/lang/String;
    //   44: areturn
    //   45: astore_1
    //   46: aconst_null
    //   47: astore_3
    //   48: ldc 170
    //   50: aload_1
    //   51: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   54: invokestatic 179	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_1
    //   58: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   61: goto -25 -> 36
    //   64: astore_1
    //   65: goto -17 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	SubscribeQRCodeShareHelper
    //   0	68	1	paramContext	android.content.Context
    //   0	68	2	paramString	String
    //   8	40	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	28	45	java/lang/Exception
    //   28	36	64	java/lang/Exception
  }
  
  private String a(String paramString)
  {
    boolean bool = AppConstants.SDCARD_IMG_SAVE.equals(paramString);
    FileUtils.c(paramString + ".nomedia");
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.a() != null))
    {
      switch (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      case 7003: 
      case 7004: 
      default: 
        return "";
      case 7000: 
      case 7001: 
        localStringBuilder = new StringBuilder().append(paramString).append(((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.a().get()).id.get());
        if (bool) {}
        for (paramString = Long.valueOf(System.currentTimeMillis());; paramString = "") {
          return paramString + ".png";
        }
      }
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(MD5.a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.a().poster.id.get()));
      if (bool) {}
      for (paramString = Long.valueOf(System.currentTimeMillis());; paramString = "") {
        return paramString + ".png";
      }
    }
    return "";
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> a(List<Integer> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(((Integer)paramList.next()).intValue()));
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.a();
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.8(this, paramInt));
    }
  }
  
  private void a(AbsSubscribeShareCardView paramAbsSubscribeShareCardView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null) {
      b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
    ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.3(this, paramAbsSubscribeShareCardView));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      if (!paramBoolean) {
        break label64;
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog == null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog = new SubscirbeLoadingDialog(this.jdField_a_of_type_AndroidAppActivity, "卡片生成中...");
      }
      if ((!this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog.isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog.show();
      }
    }
    label64:
    while ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog == null) || (!this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog.isShowing()) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog.dismiss();
  }
  
  private boolean a()
  {
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131720753;
    }
    for (;;)
    {
      if (i != -1)
      {
        QRUtils.a(0, i);
        return false;
        if (!WXShareHelper.a().b()) {
          i = 2131720754;
        }
      }
      else
      {
        return true;
      }
      i = -1;
    }
  }
  
  private String b()
  {
    Object localObject2 = "";
    CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = SubscribeGlobalInfo.a();
    Object localObject1 = localObject2;
    if (localStGetMainPageRsp != null)
    {
      localObject1 = localObject2;
      if (localStGetMainPageRsp.share != null) {
        localObject1 = localStGetMainPageRsp.share.shorturl.get();
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      localObject2 = new StringBuilder("https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=");
      ((StringBuilder)localObject2).append(URLEncoder.encode(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get()), "UTF-8"));
      localObject2 = ((StringBuilder)localObject2).toString();
      return localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return localObject1;
  }
  
  private void b()
  {
    Object localObject = new ShareActionSheetV2.Param();
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", "dingyuehao");
    ((ShareActionSheetV2.Param)localObject).context = this.jdField_a_of_type_AndroidAppActivity;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener);
    localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(2));
    ((List)localObject).add(Integer.valueOf(3));
    ((List)localObject).add(Integer.valueOf(9));
    ((List)localObject).add(Integer.valueOf(10));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(39));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(a((List)localObject), a(localArrayList));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView != null)
    {
      String str = a(this.c);
      if (!TextUtils.isEmpty(str))
      {
        if (new File(str).exists())
        {
          QLog.d("SubscribeQRCodeShareHelper", 4, "save file  is exit");
          return true;
        }
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.a();
        if (localBitmap != null) {
          return Utils.saveBitmapToFile(localBitmap, str, Bitmap.CompressFormat.JPEG, 80, true);
        }
      }
    }
    return false;
  }
  
  private String c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.h())) {
      try
      {
        Object localObject = new StringBuilder("https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=");
        ((StringBuilder)localObject).append(URLEncoder.encode(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.a()), "UTF-8"));
        localObject = ((StringBuilder)localObject).toString();
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return "";
      }
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.h();
  }
  
  private void c()
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_AndroidAppActivity);
    }
    if (!bool)
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.a();
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.5(this));
  }
  
  private boolean c()
  {
    return (WXShareHelper.a().a() != null) && (WXShareHelper.a().a().getWXAppSupportAPI() >= 654314752);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.a();
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.6(this));
  }
  
  private boolean d()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.a();
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.7(this));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new SubscribeQRCodeShareHelper.9(this);
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  public void a()
  {
    WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.10(this));
    a(false);
  }
  
  public void a(ShareInfoBean paramShareInfoBean)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_AndroidAppActivity);; bool = true)
    {
      if (!bool)
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity);
        return;
      }
      if ((paramShareInfoBean == null) || (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131717229, 1).a();
        QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code because shareInfoBean is empty");
        return;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean = paramShareInfoBean;
      a(true);
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.2(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper
 * JD-Core Version:    0.7.0.1
 */