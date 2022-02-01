package com.tencent.biz.qqcircle.share;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Key;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.ForwardType;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.IRichMediaListener;
import com.tencent.biz.qqcircle.flutter.event.QCircleFlutterShareCloseEvent;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.share.interfaces.IDialogListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class QCircleBaseShareOperation
{
  private final QCircleShareInfo a;
  private final int b;
  private final int c;
  private final Activity d;
  private final QCircleReportBean e;
  private final String f;
  private final byte[] g;
  private final String h;
  private final int i;
  private final boolean j;
  private final QCircleRichMediaDownLoadManager.IRichMediaListener k;
  private final IDialogListener l;
  private final boolean m;
  private final int n;
  private final boolean o;
  private boolean p;
  private FrameLayout q;
  private View r;
  
  public QCircleBaseShareOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    this.a = QCircleBaseShareOperation.Builder.a(paramBuilder);
    this.b = QCircleBaseShareOperation.Builder.b(paramBuilder);
    this.c = QCircleBaseShareOperation.Builder.c(paramBuilder);
    this.d = QCircleBaseShareOperation.Builder.d(paramBuilder);
    this.e = QCircleBaseShareOperation.Builder.e(paramBuilder);
    this.f = QCircleBaseShareOperation.Builder.f(paramBuilder);
    this.g = QCircleBaseShareOperation.Builder.g(paramBuilder);
    this.h = QCircleBaseShareOperation.Builder.h(paramBuilder);
    this.i = QCircleBaseShareOperation.Builder.i(paramBuilder);
    this.j = QCircleBaseShareOperation.Builder.j(paramBuilder);
    this.k = QCircleBaseShareOperation.Builder.k(paramBuilder);
    this.l = QCircleBaseShareOperation.Builder.l(paramBuilder);
    this.m = QCircleBaseShareOperation.Builder.m(paramBuilder);
    this.n = QCircleBaseShareOperation.Builder.n(paramBuilder);
    this.o = QCircleBaseShareOperation.Builder.o(paramBuilder);
  }
  
  public static Intent a(Activity paramActivity, FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramActivity != null) && (paramStFeed != null) && (paramStFeed.share != null))
    {
      Intent localIntent = new Intent(paramActivity.getApplicationContext(), QCircleHostClassHelper.getForwardRecentActivityClass());
      try
      {
        paramActivity = new JSONObject(RichTextAtParser.a(paramStFeed.share.shareCardInfo.get()));
        String str1 = paramActivity.optString("app");
        String str2 = paramActivity.optString("ver");
        String str3 = paramActivity.optString("view");
        paramStFeed = paramActivity.optString("meta");
        paramActivity = paramActivity.optString("prompt");
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_TYPE(), QCircleHostConstants.ForwardType.SEND_ARK_MSG());
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_DISPLAY_ARK(), true);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_NAME(), str1);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_VIEW(), str3);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_VER(), str2);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_PROMPT(), paramActivity);
        localIntent.putExtra(QCircleHostConstants.AppConstants.Key.FORWARD_ARK_APP_META(), paramStFeed);
        paramActivity = paramStFeed;
        if (!TextUtils.isEmpty(paramStFeed))
        {
          paramActivity = paramStFeed;
          if (paramStFeed.contains("\"isAIO\":1")) {
            paramActivity = paramStFeed.replace("\"isAIO\":1", "\"isAIO\":0");
          }
        }
        localIntent.putExtras(HostDataTransUtils.getArkDialogZipArgs(str1, str3, str2, paramActivity));
        return localIntent;
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        paramStFeed = new StringBuilder();
        paramStFeed.append("getShareArkIntent  exception message: ");
        paramStFeed.append(paramActivity.getMessage());
        QLog.d("QCircleBaseShare", 1, paramStFeed.toString());
        return localIntent;
      }
    }
    return null;
  }
  
  public abstract void a();
  
  protected void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, String paramString)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setExt1(paramString).setPageId(g()).setfpageid(h()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QCircleBaseShare", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  protected void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("build ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" error, check the building params");
    QLog.d(paramString, 1, localStringBuilder.toString());
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ((f() != null) && (f().a != null) && (f().b != null))
    {
      if (!QCircleConfigHelper.bg()) {
        return;
      }
      if ((g() != 501) && (g() != 503) && (g() != 57)) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dtReportCustomShareReport actionType = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" , shareTarget");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("QCircleBaseShare", 1, ((StringBuilder)localObject).toString());
      localObject = new QCircleDTParamBuilder().buildElementParams();
      ((Map)localObject).putAll(QCirclePluginReportUtil.a(f().a));
      int i1;
      if (f().c != null) {
        i1 = f().c.mDataPosition + 1;
      } else {
        i1 = -1;
      }
      ((Map)localObject).put("xsj_feed_index", Integer.valueOf(i1));
      ((Map)localObject).put("xsj_target_qq", f().b.poster.id.get());
      ((Map)localObject).put("xsj_action_type", paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        ((Map)localObject).put("xsj_share_target", paramString2);
      }
      paramString1 = b();
      if (paramString1 != null) {
        ((Map)localObject).putAll(paramString1);
      }
      if ((this.q == null) || (this.r == null))
      {
        this.q = new FrameLayout(i());
        this.r = new View(i());
        this.q.addView(this.r);
      }
      VideoReport.setPageId(this.q, j().getDtPageId());
      VideoReport.setElementId(this.r, "em_xsj_sharepanel");
      VideoReport.reportEvent("ev_xsj_sharepanel_action", this.r, (Map)localObject);
      return;
    }
    a("QCircleBaseShare");
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == g();
  }
  
  protected Map<String, Object> b()
  {
    return null;
  }
  
  protected boolean c()
  {
    QCircleShareInfo localQCircleShareInfo = f();
    boolean bool = false;
    if (localQCircleShareInfo == null) {
      return false;
    }
    if ((f().d == 4) || (f().d == 5) || (f().d == 6)) {
      bool = true;
    }
    return bool;
  }
  
  protected int d()
  {
    if (f() == null) {
      return 0;
    }
    int i1 = f().d;
    if (i1 != 4)
    {
      if (i1 != 5)
      {
        if (i1 != 6) {
          return 0;
        }
        return 47;
      }
      return 48;
    }
    return 46;
  }
  
  protected void e()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFlutterShareCloseEvent());
  }
  
  public QCircleShareInfo f()
  {
    return this.a;
  }
  
  public int g()
  {
    return this.b;
  }
  
  public int h()
  {
    return this.c;
  }
  
  public Activity i()
  {
    return this.d;
  }
  
  public QCircleReportBean j()
  {
    return this.e;
  }
  
  public String k()
  {
    return this.f;
  }
  
  public byte[] l()
  {
    return this.g;
  }
  
  public String m()
  {
    return this.h;
  }
  
  public int n()
  {
    return this.i;
  }
  
  public boolean o()
  {
    return this.j;
  }
  
  public QCircleRichMediaDownLoadManager.IRichMediaListener p()
  {
    return this.k;
  }
  
  public IDialogListener q()
  {
    return this.l;
  }
  
  public boolean r()
  {
    return this.m;
  }
  
  public int s()
  {
    return this.n;
  }
  
  public boolean t()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
 * JD-Core Version:    0.7.0.1
 */