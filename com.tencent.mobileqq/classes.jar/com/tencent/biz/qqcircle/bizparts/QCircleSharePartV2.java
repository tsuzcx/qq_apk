package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._BigBrotherSource;
import com.tencent.biz.qcircleshadow.lib.variation.HostShareUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.IRichMediaListener;
import com.tencent.biz.qqcircle.flutter.event.QCircleFlutterShareCloseEvent;
import com.tencent.biz.qqcircle.manager.QCircleSwitchConfigManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.report.QCircleRecentlyChatReportHelper;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.impl.ShareActionSheetListenerImpl.Builder;
import com.tencent.biz.qqcircle.share.interfaces.IDialogListener;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.share.api.ShareConfig;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.avatar.AvatarOption;
import cooperation.qqcircle.picload.avatar.QCircleAvatarLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StImageUrl;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.util.Iterator;
import java.util.List;

public class QCircleSharePartV2
  extends QCircleBasePart
{
  private HostShareUtils a;
  private QCircleShareInfo c;
  private FeedCloudMeta.StFeed d;
  private String e;
  private byte[] f = null;
  private ReportBean<QCircleReportBean> g;
  private boolean h = false;
  private Handler i = new Handler(Looper.getMainLooper());
  private Activity j;
  private QCircleRichMediaDownLoadPart k;
  private AlertDialog l;
  
  public QCircleSharePartV2() {}
  
  public QCircleSharePartV2(Activity paramActivity)
  {
    this.j = paramActivity;
    this.k = new QCircleRichMediaDownLoadPart(c());
  }
  
  private boolean A()
  {
    QCircleShareInfo localQCircleShareInfo = this.c;
    boolean bool = false;
    if (localQCircleShareInfo == null) {
      return false;
    }
    if ((localQCircleShareInfo.d == 4) || (this.c.d == 5) || (this.c.d == 6)) {
      bool = true;
    }
    return bool;
  }
  
  private int B()
  {
    QCircleShareInfo localQCircleShareInfo = this.c;
    if (localQCircleShareInfo == null) {
      return 0;
    }
    int m = localQCircleShareInfo.d;
    if (m != 4)
    {
      if (m != 5)
      {
        if (m != 6) {
          return 0;
        }
        return 47;
      }
      return 48;
    }
    return 46;
  }
  
  private boolean H()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((QCircleShareInfo)localObject).b != null)) {
      if (this.c.b.type.get() == 3)
      {
        localObject = this.c.b.video.vecVideoUrl.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int m = 0;
          while (m < ((List)localObject).size())
          {
            if (((FeedCloudMeta.StVideoUrl)((List)localObject).get(m)).levelType.get() == 20) {
              return true;
            }
            m += 1;
          }
        }
      }
      else if (this.c.b.type.get() == 2)
      {
        localObject = (FeedCloudMeta.StImage)this.c.b.images.get(this.c.e);
        if ((localObject != null) && (((FeedCloudMeta.StImage)localObject).vecImageUrl.size() > 0))
        {
          localObject = ((FeedCloudMeta.StImage)localObject).vecImageUrl.get().iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((FeedCloudMeta.StImageUrl)((Iterator)localObject).next()).levelType.get() == 4) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.c.b.poster.id.get()).setActionType(paramInt1).setSubActionType(paramInt2).setThrActionType(paramInt3).setPageId(f()));
  }
  
  private void a(Context paramContext)
  {
    this.a = new HostShareUtils(paramContext);
    this.a.setOnDismissListener(new QCircleSharePartV2.1(this));
    this.a.setCancelListener(new QCircleSharePartV2.2(this));
  }
  
  private void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(21).setSubActionType(2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setExt1("").setPageId(f()).setfpageid(e()));
      return;
    }
    QLog.e("QCircleReportHelper_RHF-QCircleSharePart", 1, "extraTypeInfo is null or lost feed,actionType:21,subActionType:2");
  }
  
  private void a(PBStringField paramPBStringField)
  {
    if (!paramPBStringField.has())
    {
      QLog.d("RHF-QCircleSharePart", 1, "[handleShareCardInfo] shareCardInfo is null. ");
      return;
    }
    String str1 = paramPBStringField.get();
    String str2 = str1.substring(str1.indexOf("\"iconUrl\":\"") + 11);
    if (TextUtils.isEmpty(str2))
    {
      QLog.d("RHF-QCircleSharePart", 1, "[handleShareCardInfo] subString error. ");
      return;
    }
    if (TextUtils.isEmpty(str2.substring(0, str2.indexOf("\""))))
    {
      paramPBStringField = new AvatarOption().setUin(String.valueOf(this.c.b.poster.id.get())).setUrlListener(new QCircleSharePartV2.5(this, str1, str2, paramPBStringField));
      QCircleAvatarLoader.g().loadAvatar(paramPBStringField);
    }
  }
  
  private void a(String paramString)
  {
    if ((this.c.b.poster.has()) && (this.c.b.poster.icon.has()) && (TextUtils.isEmpty(this.c.b.poster.icon.iconUrl.get()))) {
      this.c.b.poster.icon.iconUrl.set(paramString);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    i();
    if (!paramBoolean1) {
      n();
    }
    if (!paramBoolean2) {
      x();
    }
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == f();
  }
  
  private void b(Context paramContext)
  {
    if ((c() != null) && (this.c != null))
    {
      if (FastClickUtils.a("RHF-QCircleSharePartshowActionSheet", 800L)) {
        return;
      }
      c(paramContext);
      if (this.a == null) {
        return;
      }
      w();
      this.a.setActionSheetItems(y());
      t();
      this.a.show(QCircleConfigHelper.bg());
      m();
      paramContext = new StringBuilder();
      paramContext.append("showActionSheet  feedId : ");
      paramContext.append(this.c.b.id.get());
      paramContext.append(" , userId : ");
      paramContext.append(this.c.b.poster.id.get());
      paramContext.append(" , pageId : ");
      paramContext.append(f());
      paramContext.append(" , parentPageId : ");
      paramContext.append(e());
      QLog.d("RHF-QCircleSharePart", 1, paramContext.toString());
      s();
      return;
    }
    QCircleToast.a(HardCodeUtil.a(2131911962), 0);
  }
  
  private void c(Context paramContext)
  {
    HostShareUtils localHostShareUtils = this.a;
    if ((localHostShareUtils != null) && (localHostShareUtils.isShowing()))
    {
      QLog.e("RHF-QCircleSharePart", 1, "[showActionSheet] current is showing state, not repeat show.");
      return;
    }
    QLog.d("RHF-QCircleSharePart", 1, "showActionSheet");
    a(paramContext);
  }
  
  private void i()
  {
    HostShareUtils localHostShareUtils = this.a;
    if ((localHostShareUtils != null) && (localHostShareUtils.isShowing()))
    {
      this.a.dismiss();
      QLog.d("RHF-QCircleSharePart", 1, "safeCloseSheet  dismiss");
      if (this.i == null) {
        this.i = new Handler(Looper.getMainLooper());
      }
    }
    l();
  }
  
  private void l()
  {
    Handler localHandler = this.i;
    if (localHandler == null)
    {
      QLog.e("RHF-QCircleSharePart", 1, "mUIHandler == null");
      return;
    }
    localHandler.postDelayed(new QCircleSharePartV2.3(this), 200L);
  }
  
  private void m()
  {
    if (this.l == null)
    {
      this.l = new AlertDialog.Builder(g()).create();
      this.l.setCancelable(false);
      this.l.show();
    }
  }
  
  private void n()
  {
    AlertDialog localAlertDialog = this.l;
    if (localAlertDialog != null)
    {
      localAlertDialog.dismiss();
      this.l = null;
    }
  }
  
  private void o()
  {
    boolean bool = this.c.g;
    int n = 3;
    int m;
    if ((bool) && ((f() == 1) || (f() == 3)))
    {
      m = 100;
    }
    else
    {
      m = 21;
      n = 2;
    }
    if (this.c.c != null) {
      localObject = this.c.c.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(m).setSubActionType(n);
    if ((this.c.c != null) && (this.c.c.mFeed != null)) {
      localObject = this.c.c.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    Object localObject = localDataBuilder.setToUin((String)localObject);
    if (this.c.c != null) {
      m = this.c.c.mDataPosition;
    } else {
      m = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(m).setPageId(f())));
  }
  
  private void p()
  {
    a(6, 3, 0);
  }
  
  private void q()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(B()).setSubActionType(2).setThrActionType(0).setExt6(String.valueOf(this.c.f)).setPageId(f()));
  }
  
  private void r()
  {
    if ((this.c.c != null) && (this.c.c.pageType == 9))
    {
      a(11, 15, 1);
      return;
    }
    a(11, 7, 1);
  }
  
  private void s()
  {
    if ((!a(57)) && (!QCircleConfigHelper.bg()))
    {
      if (a(32))
      {
        r();
        return;
      }
      if (a(31))
      {
        p();
        return;
      }
      if (A())
      {
        q();
        return;
      }
      o();
      return;
    }
    a(this.c.c);
  }
  
  private void t()
  {
    QCircleRichMediaDownLoadManager.IRichMediaListener localIRichMediaListener = v();
    IDialogListener localIDialogListener = u();
    this.a.setActionSheetClickListener(new ShareActionSheetListenerImpl.Builder().a(this.c).a(c()).a(this.e).a(this.f).a(f()).b(e()).a(d()).a(localIRichMediaListener).a(localIDialogListener).a());
  }
  
  private IDialogListener u()
  {
    return new QCircleSharePartV2.6(this);
  }
  
  private QCircleRichMediaDownLoadManager.IRichMediaListener v()
  {
    return new QCircleSharePartV2.7(this);
  }
  
  private void w()
  {
    Object localObject = QCircleBaseShareOperation.a(c(), this.c.b);
    this.a.setIntentForStartForwardRecentActivity((Intent)localObject);
    this.a.setRowVisibility(0, 0, 0);
    localObject = this.c.c;
    QCircleRecentlyChatReportHelper.a(f(), e()).b((QCircleExtraTypeInfo)localObject);
  }
  
  private void x()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFlutterShareCloseEvent());
  }
  
  private ShareConfig y()
  {
    ShareConfig localShareConfig = new ShareConfig();
    localShareConfig.isShowShareToFriend = true;
    int m = QCircleConfigHelper.f();
    int n = 0;
    if (m == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localShareConfig.isShowShareToQZone = bool1;
    localShareConfig.isShowShareToWechat = true;
    localShareConfig.isShowShareToWechatCircle = true;
    localShareConfig.isForceNightTheme = QCircleConfigHelper.bg();
    Object localObject = this.c;
    if (localObject == null) {
      return localShareConfig;
    }
    localShareConfig.isShowDelete = ((QCircleShareInfo)localObject).i;
    boolean bool1 = H();
    boolean bool2 = this.c.p;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" | ");
    ((StringBuilder)localObject).append(z());
    QLog.d("RHF-QCircleSharePart", 1, new Object[] { "[Share-getShareConfig] isShowDownLoad: ", Boolean.valueOf(bool2), " | hasMarkUrl: ", ((StringBuilder)localObject).toString() });
    if ((this.c.p) && (bool1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localShareConfig.isShowSave = bool1;
    if (QCircleConfigHelper.bg())
    {
      m = n;
      if (f() == 501) {
        break label244;
      }
      m = n;
      if (f() == 503) {
        break label244;
      }
      if (f() == 57)
      {
        m = n;
        break label244;
      }
    }
    m = 1;
    label244:
    if ((QCircleConfigHelper.s()) && (m != 0) && (this.c.k))
    {
      bool1 = QCircleSwitchConfigManager.a().b();
      localShareConfig.isShowBarrageClose = bool1;
      localShareConfig.isShowBarrageOpen = (true ^ bool1);
    }
    localShareConfig.isShowDisLike = this.c.l;
    localShareConfig.isShowHideThisWork = this.c.m;
    localShareConfig.isShowReport = this.c.j;
    localShareConfig.isShowDeletePush = this.c.n;
    localShareConfig.isShowDeletePushDisable = this.c.o;
    localShareConfig.isShowDebug = this.c.q;
    return localShareConfig;
  }
  
  private String z()
  {
    if (this.d == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    List localList = this.d.opMask2.get();
    localStringBuilder.append("feedId: ");
    localStringBuilder.append(this.d.id.get());
    localStringBuilder.append(" | ");
    localStringBuilder.append("opMask2: ");
    int n = 0;
    int m;
    if (localList == null) {
      m = 0;
    } else {
      m = localList.size();
    }
    while (n < m)
    {
      Object localObject = localList.get(n);
      if (localObject != null)
      {
        localStringBuilder.append(localObject);
        if (n < m - 1) {
          localStringBuilder.append("|");
        }
      }
      n += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    return "RHF-QCircleSharePart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    QLog.d("RHF-QCircleSharePart", 4, localStringBuilder.toString());
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.g = paramReportBean;
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (TextUtils.equals(paramString, "share_action_show_share_sheet"))
    {
      if (FastClickUtils.a("RHF-QCircleShareParthandleBroadcastMessage", 800L)) {
        return;
      }
      if ((paramObject instanceof QCircleShareInfo))
      {
        this.c = ((QCircleShareInfo)paramObject);
        if (this.c.c != null) {
          this.c.c.mFeed = this.c.b;
        }
        if (this.c.r != null) {
          this.b = this.c.r;
        }
        this.d = this.c.b;
        localObject = this.d;
        if (localObject != null)
        {
          this.e = ((FeedCloudMeta.StFeed)localObject).id.get();
          if (this.d.busiReport.has()) {
            this.f = this.d.busiReport.get().toByteArray();
          }
          if (this.c.b.share.has()) {
            a(this.c.b.share.shareCardInfo);
          }
        }
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra(QCircleHostConstants._BigBrotherSource.KEY(), QCircleHostConstants._BigBrotherSource.SRC_JC_WEZONE());
      HostUIHelper.openHostEnvironment(new QCircleSharePartV2.4(this), (Intent)localObject);
    }
    super.a(paramString, paramObject);
  }
  
  public Activity c()
  {
    Activity localActivity2 = this.j;
    Activity localActivity1 = localActivity2;
    if (localActivity2 == null) {
      localActivity1 = super.c();
    }
    return localActivity1;
  }
  
  public QCircleReportBean d()
  {
    if (this.b != null) {
      return QCircleReportBean.getReportBean("RHF-QCircleSharePart", this.b).clone();
    }
    ReportBean localReportBean = this.g;
    if (localReportBean != null) {
      return QCircleReportBean.getReportBean("RHF-QCircleSharePart", (QCircleReportBean)localReportBean.getReportBean()).clone();
    }
    return new QCircleReportBean();
  }
  
  protected int e()
  {
    if (this.b != null) {
      return QCircleReportBean.getParentPageId("RHF-QCircleSharePart", this.b);
    }
    ReportBean localReportBean = this.g;
    if (localReportBean != null) {
      return QCircleReportBean.getParentPageId("RHF-QCircleSharePart", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
  
  protected int f()
  {
    if (this.b != null) {
      return QCircleReportBean.getPageId("RHF-QCircleSharePart", this.b);
    }
    ReportBean localReportBean = this.g;
    if (localReportBean != null) {
      return QCircleReportBean.getPageId("RHF-QCircleSharePart", (QCircleReportBean)localReportBean.getReportBean());
    }
    return 0;
  }
  
  public Context g()
  {
    return c();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.i != null) {
      this.i = null;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if ((this.h) && (QCirclePluginGlobalInfo.h() == 0) && (g() != null)) {
      QCircleToast.a(QCircleToast.d, g().getString(2131895928), 0);
    }
    this.h = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2
 * JD-Core Version:    0.7.0.1
 */