package com.tencent.biz.qqcircle.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qcircleshadow.lib.QCircleHostShareInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleProgressDialog;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QCircleWeChatShareOperation
  extends QCircleBaseShareOperation
{
  private QCircleWXShareListener a;
  private String b;
  private QCircleProgressDialog c;
  private String d;
  private String e;
  private String f;
  private Map<String, Bitmap> g;
  private Runnable h;
  
  public QCircleWeChatShareOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  private void A()
  {
    if (this.a != null) {
      return;
    }
    this.a = new QCircleWeChatShareOperation.1(this);
    QCircleHostShareInvokeHelper.addWxShareObserver(this.a);
  }
  
  private void B()
  {
    G();
    if (TextUtils.isEmpty(this.d))
    {
      QCircleToast.a(QCircleToast.c, HardCodeUtil.a(2131911948), 0);
      return;
    }
    String str1 = f().b.poster.id.get();
    String str2 = f().b.share.cover.picUrl.get();
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
    {
      QLog.d("QCircleWeChatShare", 1, "shareToWeChat no picture");
      D();
      return;
    }
    C();
  }
  
  private void C()
  {
    a(i());
    this.c.a(2131891516);
    if ((i() != null) && (!i().isFinishing())) {
      this.c.show();
    }
    RFThreadManager.execute(E());
  }
  
  private void D()
  {
    this.h.run();
  }
  
  private Runnable E()
  {
    return new QCircleWeChatShareOperation.2(this);
  }
  
  private void F()
  {
    String str = f().b.poster.icon.iconUrl.get();
    if (!TextUtils.isEmpty(str))
    {
      c(str);
      QLog.d("QCircleWeChatShare", 1, "shareToWeChat share user icon by url");
      return;
    }
    QLog.d("QCircleWeChatShare", 1, "shareToWeChat share user icon by uin");
    HostDataTransUtils.getUserFaceBitmap(f().b.poster.id.get(), new QCircleWeChatShareOperation.3(this));
  }
  
  private void G()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(f().b.share.url.get());
    localStringBuilder.append("&sharecategory=1");
    this.d = localStringBuilder.toString();
    this.e = b(f().b.share.title.get());
    this.f = b(f().b.share.desc.get());
    this.g = new HashMap(1);
    this.h = new QCircleWeChatShareOperation.4(this);
  }
  
  private boolean H()
  {
    if (!QCircleHostShareInvokeHelper.isWXInstalled())
    {
      QCircleToast.a(QCircleToast.b, 2131918154, 0);
      return false;
    }
    if (!QCircleHostShareInvokeHelper.isWXSupportApi())
    {
      QCircleToast.a(QCircleToast.b, 2131918155, 0);
      return false;
    }
    return true;
  }
  
  private void a(Activity paramActivity)
  {
    if (this.c == null) {
      this.c = new QCircleProgressDialog(paramActivity);
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      int k = j * i;
      Bitmap localBitmap = paramBitmap;
      if (k > 8000)
      {
        double d1 = k;
        Double.isNaN(d1);
        d1 = Math.sqrt(8000.0D / d1);
        double d2 = j;
        Double.isNaN(d2);
        j = (int)(d2 * d1);
        d2 = i;
        Double.isNaN(d2);
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, j, (int)(d2 * d1), true);
        if (f().d != 1) {
          paramBitmap.recycle();
        }
      }
      this.g.put("image", localBitmap);
    }
  }
  
  public static String b(String paramString)
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
  
  private void c(String paramString)
  {
    try
    {
      paramString = HttpUtil.openUrlForByte(QCircleApplication.APP, paramString, "GET", null, null);
      if (paramString != null)
      {
        a(BitmapFactory.decodeByteArray(paramString, 0, paramString.length));
        return;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareToWeChat  OutOfMemoryError : ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("QCircleWeChatShare", 1, localStringBuilder.toString());
      return;
    }
    catch (IOException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareToWeChat url Exception : ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("QCircleWeChatShare", 1, localStringBuilder.toString());
    }
  }
  
  private void u()
  {
    if ((!a(57)) && (!QCircleConfigHelper.bg()))
    {
      if (a(32))
      {
        y();
        return;
      }
      if (a(31))
      {
        x();
        return;
      }
      if (c())
      {
        w();
        return;
      }
      v();
      return;
    }
    z();
  }
  
  private void v()
  {
    if (f().c != null) {
      localObject = f().c.mFeed;
    } else {
      localObject = null;
    }
    Object localObject = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject);
    int i;
    if (o()) {
      i = 27;
    } else {
      i = 28;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = ((QCircleLpReportDc05501.DataBuilder)localObject).setActionType(i).setSubActionType(2);
    if ((f().c != null) && (f().c.mFeed != null)) {
      localObject = f().c.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    localObject = localDataBuilder.setToUin((String)localObject);
    if (f().c != null) {
      i = f().c.mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i).setPageId(g())));
  }
  
  private void w()
  {
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(d());
    int i = 3;
    localDataBuilder = localDataBuilder.setSubActionType(3);
    if (!o()) {
      i = 4;
    }
    QCircleLpReportDc05504.report(localDataBuilder.setThrActionType(i).setExt6(String.valueOf(f().f)).setPageId(g()));
  }
  
  private void x()
  {
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setToUin(f().b.poster.id.get()).setActionType(6);
    int i = 4;
    localDataBuilder = localDataBuilder.setSubActionType(4);
    if (o()) {
      i = 3;
    }
    QCircleLpReportDc05504.report(localDataBuilder.setThrActionType(i).setPageId(g()));
  }
  
  private void y()
  {
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setToUin(f().b.poster.id.get()).setActionType(11).setSubActionType(9);
    int i;
    if (o()) {
      i = 3;
    } else {
      i = 4;
    }
    QCircleLpReportDc05504.report(localDataBuilder.setThrActionType(i).setExt9(k()).setFeedReportInfo(l()).setPageId(g()));
  }
  
  private void z()
  {
    int i;
    if (o()) {
      i = 27;
    } else {
      i = 28;
    }
    a(i, 2, f().c, "");
    String str;
    if (o()) {
      str = "wechat_connects";
    } else {
      str = "wechat_moments";
    }
    a("share", str);
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (f().b.share != null) && (f().b.poster != null) && (i() != null))
    {
      Activity localActivity = i();
      String str;
      if (o()) {
        str = "share_type_wechat";
      } else {
        str = "share_type_temp_circle";
      }
      SharePreferenceUtils.a(localActivity, "share_lately_type_key", str);
      u();
      if (!H()) {
        return;
      }
      A();
      B();
      return;
    }
    a("QCircleWeChatShare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleWeChatShareOperation
 * JD-Core Version:    0.7.0.1
 */