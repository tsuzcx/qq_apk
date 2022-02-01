package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.subscribe.SubscribeGlobalInfo;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.ar.utils.QRScanUtil;
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
  private ShareActionSheet.OnItemClickListener jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  private final String b = "https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=";
  private final String c;
  private String d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("subscribe_shared_card/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public SubscribeQRCodeShareHelper(Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("subscribe_card/");
    this.c = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener = new SubscribeQRCodeShareHelper.4(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramActivity = ThreadManager.newFreeHandlerThread("subscribe_create_card", 0);
    paramActivity.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramActivity.getLooper());
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.1(this));
  }
  
  private AbsSubscribeShareCardView a()
  {
    ShareInfoBean localShareInfoBean = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    if ((localShareInfoBean != null) && (localShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      int i = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      if (i != 7005) {
        switch (i)
        {
        default: 
          return null;
        case 7001: 
          return new SubscribeMultiPicSharedCardView(this.jdField_a_of_type_AndroidAppActivity);
        case 7000: 
          return new SubscribeVideoSharedCardView(this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_Int == 1) {
        return new SubScribePersonalSharedCardView(this.jdField_a_of_type_AndroidAppActivity);
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_Int == 3) {
        return new SubscribeVideoSharedCardView(this.jdField_a_of_type_AndroidAppActivity);
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_Int == 4) {
        return new SubscribeMultiPicSharedCardView(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    return null;
  }
  
  private String a()
  {
    ShareInfoBean localShareInfoBean = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    if ((localShareInfoBean != null) && (localShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      int i = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      if (i != 7005) {
        switch (i)
        {
        default: 
          return "";
        case 7000: 
        case 7001: 
          return c();
        }
      }
      return b();
    }
    return "";
  }
  
  private String a(Context paramContext, String paramString)
  {
    Object localObject2 = new File(paramString);
    boolean bool = ((File)localObject2).exists();
    Object localObject1 = null;
    if (!bool) {
      return null;
    }
    try
    {
      localObject2 = FileProvider.getUriForFile(paramContext, "com.tencent.mobileqq.fileprovider", (File)localObject2);
      localObject1 = localObject2;
      paramContext.grantUriPermission("com.tencent.mm", (Uri)localObject2, 1);
      localObject1 = localObject2;
    }
    catch (Exception paramContext)
    {
      SLog.e("SubscribeQRCodeShareHelper", paramContext.getMessage());
      paramContext.printStackTrace();
    }
    if (localObject1 != null) {
      paramString = localObject1.toString();
    }
    return paramString;
  }
  
  private String a(String paramString)
  {
    boolean bool = AppConstants.SDCARD_IMG_SAVE.equals(paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".nomedia");
    FileUtils.createFileIfNotExits(((StringBuilder)localObject1).toString());
    Object localObject2 = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean;
    localObject1 = "";
    if ((localObject2 != null) && (((ShareInfoBean)localObject2).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.a() != null))
    {
      int i = this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      if (i != 7005) {
        switch (i)
        {
        default: 
          return "";
        case 7000: 
        case 7001: 
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.a().get()).id.get());
          if (bool) {
            localObject1 = Long.valueOf(System.currentTimeMillis());
          }
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(".png");
          return ((StringBuilder)localObject2).toString();
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(MD5.a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.a().poster.id.get()));
      if (bool) {
        localObject1 = Long.valueOf(System.currentTimeMillis());
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(".png");
      return ((StringBuilder)localObject2).toString();
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
    ShareActionSheet localShareActionSheet = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localShareActionSheet != null)
    {
      if (localShareActionSheet.isShowing()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.3(this, paramAbsSubscribeShareCardView));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject != null) {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog == null) {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog = new SubscirbeLoadingDialog((Context)localObject, "卡片生成中...");
        }
        if ((!this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog.isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog.show();
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog;
        if ((localObject != null) && (((SubscirbeLoadingDialog)localObject).isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscirbeLoadingDialog.dismiss();
        }
      }
    }
  }
  
  private boolean a()
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
      return false;
    }
    return true;
  }
  
  private String b()
  {
    Object localObject1 = SubscribeGlobalInfo.a();
    if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).share != null)) {
      localObject1 = ((CertifiedAccountRead.StGetMainPageRsp)localObject1).share.shorturl.get();
    } else {
      localObject1 = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        Object localObject2 = new StringBuilder("https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=");
        ((StringBuilder)localObject2).append(URLEncoder.encode(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get()), "UTF-8"));
        localObject2 = ((StringBuilder)localObject2).toString();
        return localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
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
          return QRScanUtil.a(localBitmap, str, Bitmap.CompressFormat.JPEG, 80, true);
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
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_AndroidAppActivity);
    } else {
      bool = true;
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
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_AndroidAppActivity);
    } else {
      bool = true;
    }
    if (!bool)
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    if ((paramShareInfoBean != null) && (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity)))
    {
      this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean = paramShareInfoBean;
      a(true);
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.2(this));
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131716888, 1).a();
    QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code because shareInfoBean is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper
 * JD-Core Version:    0.7.0.1
 */