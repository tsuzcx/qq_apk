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
  private final String b = "https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=";
  private final String c;
  private Activity d;
  private ShareInfoBean e;
  private Handler f;
  private AbsSubscribeShareCardView g;
  private WXShareHelper.WXShareListener h;
  private String i;
  private SubscirbeLoadingDialog j;
  private ShareActionSheet k;
  private ShareActionSheet.OnItemClickListener l;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("subscribe_shared_card/");
    a = localStringBuilder.toString();
  }
  
  public SubscribeQRCodeShareHelper(Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("subscribe_card/");
    this.c = localStringBuilder.toString();
    this.l = new SubscribeQRCodeShareHelper.4(this);
    this.d = paramActivity;
    paramActivity = ThreadManager.newFreeHandlerThread("subscribe_create_card", 0);
    paramActivity.start();
    this.f = new Handler(paramActivity.getLooper());
    this.f.post(new SubscribeQRCodeShareHelper.1(this));
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
    Object localObject2 = this.e;
    localObject1 = "";
    if ((localObject2 != null) && (((ShareInfoBean)localObject2).e != null) && (this.e.a() != null))
    {
      int m = this.e.e.pageType;
      if (m != 7005) {
        switch (m)
        {
        default: 
          return "";
        case 7000: 
        case 7001: 
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(((CertifiedAccountMeta.StFeed)this.e.a().get()).id.get());
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
      ((StringBuilder)localObject2).append(MD5.b(this.e.a().poster.id.get()));
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
    if (j())
    {
      this.g.a();
      this.f.post(new SubscribeQRCodeShareHelper.8(this, paramInt));
    }
  }
  
  private void a(AbsSubscribeShareCardView paramAbsSubscribeShareCardView)
  {
    if (this.k == null) {
      f();
    }
    ShareActionSheet localShareActionSheet = this.k;
    if (localShareActionSheet != null)
    {
      if (localShareActionSheet.isShowing()) {
        return;
      }
      this.k.show();
      ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.3(this, paramAbsSubscribeShareCardView));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.d;
    if (localObject != null) {
      if (paramBoolean)
      {
        if (this.j == null) {
          this.j = new SubscirbeLoadingDialog((Context)localObject, "卡片生成中...");
        }
        if ((!this.j.isShowing()) && (!this.d.isFinishing())) {
          this.j.show();
        }
      }
      else
      {
        localObject = this.j;
        if ((localObject != null) && (((SubscirbeLoadingDialog)localObject).isShowing()) && (!this.d.isFinishing())) {
          this.j.dismiss();
        }
      }
    }
  }
  
  private AbsSubscribeShareCardView b()
  {
    ShareInfoBean localShareInfoBean = this.e;
    if ((localShareInfoBean != null) && (localShareInfoBean.e != null))
    {
      int m = this.e.e.pageType;
      if (m != 7005) {
        switch (m)
        {
        default: 
          return null;
        case 7001: 
          return new SubscribeMultiPicSharedCardView(this.d);
        case 7000: 
          return new SubscribeVideoSharedCardView(this.d);
        }
      }
      if (this.e.a == 1) {
        return new SubScribePersonalSharedCardView(this.d);
      }
      if (this.e.a == 3) {
        return new SubscribeVideoSharedCardView(this.d);
      }
      if (this.e.a == 4) {
        return new SubscribeMultiPicSharedCardView(this.d);
      }
    }
    return null;
  }
  
  private String c()
  {
    ShareInfoBean localShareInfoBean = this.e;
    if ((localShareInfoBean != null) && (localShareInfoBean.e != null))
    {
      int m = this.e.e.pageType;
      if (m != 7005) {
        switch (m)
        {
        default: 
          return "";
        case 7000: 
        case 7001: 
          return e();
        }
      }
      return d();
    }
    return "";
  }
  
  private String d()
  {
    Object localObject1 = SubscribeGlobalInfo.b();
    if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).share != null)) {
      localObject1 = ((CertifiedAccountRead.StGetMainPageRsp)localObject1).share.shorturl.get();
    } else {
      localObject1 = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        Object localObject2 = new StringBuilder("https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=");
        ((StringBuilder)localObject2).append(URLEncoder.encode(SubscribeShareHelper.a(this.e.b.poster.id.get(), this.e.b.poster.nick.get(), this.e.b.poster.icon.get()), "UTF-8"));
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
  
  private String e()
  {
    if (TextUtils.isEmpty(this.e.i())) {
      try
      {
        Object localObject = new StringBuilder("https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=");
        ((StringBuilder)localObject).append(URLEncoder.encode(SubscribeShareHelper.a(this.e.a()), "UTF-8"));
        localObject = ((StringBuilder)localObject).toString();
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return "";
      }
    }
    return this.e.i();
  }
  
  private void f()
  {
    Object localObject = new ShareActionSheetV2.Param();
    this.d.getIntent().putExtra("big_brother_source_key", "dingyuehao");
    ((ShareActionSheetV2.Param)localObject).context = this.d;
    this.k = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    this.k.setItemClickListenerV2(this.l);
    localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(2));
    ((List)localObject).add(Integer.valueOf(3));
    ((List)localObject).add(Integer.valueOf(9));
    ((List)localObject).add(Integer.valueOf(10));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(39));
    this.k.setActionSheetItems(a((List)localObject), a(localArrayList));
    this.k.setRowVisibility(8, 0, 0);
  }
  
  private void g()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = PermissionUtils.isStorePermissionEnable(this.d);
    } else {
      bool = true;
    }
    if (!bool)
    {
      DialogUtil.a(this.d);
      return;
    }
    this.g.a();
    this.f.post(new SubscribeQRCodeShareHelper.5(this));
  }
  
  private void h()
  {
    this.g.a();
    this.f.post(new SubscribeQRCodeShareHelper.6(this));
  }
  
  private void i()
  {
    this.g.a();
    this.f.post(new SubscribeQRCodeShareHelper.7(this));
  }
  
  private boolean j()
  {
    int m;
    if (!WXShareHelper.a().b()) {
      m = 2131918154;
    } else if (!WXShareHelper.a().c()) {
      m = 2131918155;
    } else {
      m = -1;
    }
    if (m != -1)
    {
      QRUtils.a(0, m);
      return false;
    }
    return true;
  }
  
  private void k()
  {
    if (this.h != null) {
      return;
    }
    this.h = new SubscribeQRCodeShareHelper.9(this);
    WXShareHelper.a().a(this.h);
  }
  
  private boolean l()
  {
    if (this.g != null)
    {
      String str = a(this.c);
      if (!TextUtils.isEmpty(str))
      {
        if (new File(str).exists())
        {
          QLog.d("SubscribeQRCodeShareHelper", 4, "save file  is exit");
          return true;
        }
        Bitmap localBitmap = this.g.getSharedBitmap();
        if (localBitmap != null) {
          return QRScanUtil.a(localBitmap, str, Bitmap.CompressFormat.JPEG, 80, true);
        }
      }
    }
    return false;
  }
  
  private boolean m()
  {
    return (WXShareHelper.a().e() != null) && (WXShareHelper.a().e().getWXAppSupportAPI() >= 654314752);
  }
  
  private boolean n()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public void a()
  {
    WXShareHelper.a().b(this.h);
    this.f.post(new SubscribeQRCodeShareHelper.10(this));
    a(false);
  }
  
  public void a(ShareInfoBean paramShareInfoBean)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = PermissionUtils.isStorePermissionEnable(this.d);
    } else {
      bool = true;
    }
    if (!bool)
    {
      DialogUtil.a(this.d);
      return;
    }
    if ((paramShareInfoBean != null) && (NetworkUtil.isNetworkAvailable(this.d)))
    {
      this.e = paramShareInfoBean;
      a(true);
      this.f.post(new SubscribeQRCodeShareHelper.2(this));
      return;
    }
    QQToast.makeText(this.d, 1, 2131914361, 1).show();
    QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code because shareInfoBean is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper
 * JD-Core Version:    0.7.0.1
 */