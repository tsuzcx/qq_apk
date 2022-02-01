package com.tencent.biz.qqcircle.bizparts;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.PeakConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QQStoryMainActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPageSelectEvent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.localphoto.scan.QCirclePhotoScanManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.QCirclePermissionUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel.PublishButtonEventInfo;
import com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qcircle.api.event.QCirclePublishButtonEvent;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class QCirclePublishFeedPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  protected ActionSheet a;
  private View c;
  private ImageView d;
  private QCircleGuideBubbleView e;
  private FeedCloudMeta.StUser f;
  private FeedCloudMeta.StTagInfo g;
  private boolean h;
  private QCircleLoadingDialog i;
  private int j = 1;
  private boolean k = false;
  private ReportBean<QCircleReportBean> l;
  private QCircleInitBean m;
  private boolean n = false;
  private boolean o = false;
  private QCirclePublishButtonViewModel p;
  private ImageView q;
  private URLImageView r;
  private ViewGroup s;
  private View t;
  private String u;
  private String v = "";
  
  public QCirclePublishFeedPart(FeedCloudMeta.StUser paramStUser)
  {
    this.f = paramStUser;
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_scheme")) && (!TextUtils.isEmpty(c().getIntent().getStringExtra("key_scheme"))))
    {
      if (c().getIntent().hasExtra("fromType"))
      {
        this.k = true;
        this.j = c().getIntent().getIntExtra("fromType", this.j);
        return;
      }
      this.k = true;
      this.j = 7;
    }
  }
  
  private void a(QCirclePublishButtonViewModel.PublishButtonEventInfo paramPublishButtonEventInfo)
  {
    this.q = ((ImageView)this.c.findViewById(2131440944));
    this.r = ((URLImageView)this.c.findViewById(2131440945));
    this.r.setVisibility(0);
    if (paramPublishButtonEventInfo.f != null) {
      this.r.setImageDrawable(paramPublishButtonEventInfo.f);
    }
    if (paramPublishButtonEventInfo.a() == 1)
    {
      this.s = ((ViewGroup)((ViewStub)this.c.findViewById(2131441664)).inflate());
      this.t = this.s.findViewById(2131440954);
      if (paramPublishButtonEventInfo.e != null) {
        this.t.setBackgroundDrawable(paramPublishButtonEventInfo.e);
      }
      TextView localTextView1 = (TextView)this.s.findViewById(2131440977);
      TextView localTextView2 = (TextView)this.s.findViewById(2131440978);
      Object localObject = QCircleSkinHelper.getInstance().convertUrl(paramPublishButtonEventInfo.b);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ContextCompat.getDrawable(g(), 2130845362);
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        ((URLImageView)this.s.findViewById(2131440942)).setImageDrawable((Drawable)localObject);
      }
      localTextView1.setText(paramPublishButtonEventInfo.c);
      localTextView2.setText(paramPublishButtonEventInfo.d);
    }
  }
  
  private void b(QCirclePublishButtonViewModel.PublishButtonEventInfo paramPublishButtonEventInfo)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(320L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this.q, "rotation", new float[] { 0.0F, -90.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.q, "alpha", new float[] { 1.0F, 0.0F }));
    if (paramPublishButtonEventInfo.a() == 1)
    {
      localArrayList.add(ObjectAnimator.ofFloat(this.t, "alpha", new float[] { 0.0F, 1.0F }));
      localArrayList.add(ObjectAnimator.ofFloat(this.t, "translationX", new float[] { ViewUtils.a(80.0F), 0.0F }));
    }
    localAnimatorSet.playTogether(localArrayList);
    localAnimatorSet.addListener(new QCirclePublishFeedPart.5(this, paramPublishButtonEventInfo));
    localAnimatorSet.start();
    paramPublishButtonEventInfo = ObjectAnimator.ofFloat(this.r, "alpha", new float[] { 0.0F, 1.0F });
    paramPublishButtonEventInfo.setDuration(160L);
    paramPublishButtonEventInfo.setStartDelay(160L);
    paramPublishButtonEventInfo.start();
  }
  
  private void c(QCirclePublishButtonViewModel.PublishButtonEventInfo paramPublishButtonEventInfo)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(320L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this.q, "rotation", new float[] { -90.0F, 0.0F }));
    localArrayList.add(ObjectAnimator.ofFloat(this.q, "alpha", new float[] { 0.0F, 1.0F }));
    if (paramPublishButtonEventInfo.a() == 1)
    {
      localArrayList.add(ObjectAnimator.ofFloat(this.t, "alpha", new float[] { 1.0F, 0.0F }));
      localArrayList.add(ObjectAnimator.ofFloat(this.t, "translationX", new float[] { 0.0F, ViewUtils.a(80.0F) }));
    }
    localAnimatorSet.playTogether(localArrayList);
    localAnimatorSet.addListener(new QCirclePublishFeedPart.6(this, paramPublishButtonEventInfo));
    localAnimatorSet.start();
    ObjectAnimator.ofFloat(this.r, "alpha", new float[] { 1.0F, 0.0F }).setDuration(160L).start();
  }
  
  private void c(Object paramObject)
  {
    if ((!this.k) && ((paramObject instanceof Integer)))
    {
      int i1 = ((Integer)paramObject).intValue();
      if (i1 == 1) {
        this.j = 1;
      } else if (i1 == 6) {
        this.j = 2;
      } else if (i1 == 4) {
        this.j = 15;
      }
      QLog.d("[QcirclePublish]QCirclePublishFeedPart", 1, new Object[] { "[handleTabChangedEvent]... type:", Integer.valueOf(i1), " fromType:", Integer.valueOf(this.j) });
    }
  }
  
  private void d(Object paramObject)
  {
    if ((!this.k) && ((paramObject instanceof Integer)))
    {
      int i1 = ((Integer)paramObject).intValue();
      if (i1 == 1) {
        this.j = 16;
      } else if (i1 == 6) {
        this.j = 17;
      } else if (i1 == 4) {
        this.j = 18;
      }
      QLog.d("[QcirclePublish]QCirclePublishFeedPart", 1, new Object[] { "[handleNewLayerTabChangedEvent]... type:", Integer.valueOf(i1), " fromType:", Integer.valueOf(this.j) });
    }
  }
  
  private void m()
  {
    this.p.c().observe(j(), new QCirclePublishFeedPart.1(this));
    this.p.d();
  }
  
  private void n()
  {
    if ((this.h) && (!QCirclePluginConfig.a().g()) && (this.e != null))
    {
      this.h = false;
      this.p.b();
      this.e.a(3000);
      this.e.setOnShowListener(new QCirclePublishFeedPart.2(this));
    }
  }
  
  private boolean o()
  {
    if ((c() != null) && (c().getIntent() != null)) {
      return c().getIntent().getBooleanExtra("key_need_use_draft", false);
    }
    return true;
  }
  
  private void p()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      QCirclePermissionUtil.a(c(), new QCirclePublishFeedPart.3(this), 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    } else {
      q();
    }
    this.p.b(f(), this.j);
  }
  
  private void q()
  {
    if (!QCircleBindPhoneNumberHelper.a())
    {
      QCircleBindPhoneNumberHelper.a(c(), 1);
      return;
    }
    this.d.setClickable(false);
    QLog.d("[Performance2][QcirclePublish]QCirclePublishFeedPart", 1, "handlePublishEntranceClickNew...");
    this.u = QCirclePublishQualityReporter.getTraceId();
    String str = QCirclePublishQualityReporter.E_PUBLIC_START;
    Object localObject = str;
    if (QCircleConfigHelper.bh())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((IUploadCommonSetting)QRoute.api(IUploadCommonSetting.class)).getSpKey());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (QCirclePluginInitHelper.isPeakAlive(g()))
    {
      QCirclePublishQualityReporter.report((String)localObject, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.u), QCircleReportHelper.newEntry("ext1", String.valueOf(this.j)), QCircleReportHelper.newEntry("ext2", "PeakAlive"), QCircleReportHelper.newEntry("ret_code", "0") }));
      r();
      return;
    }
    QCirclePublishQualityReporter.report((String)localObject, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.u), QCircleReportHelper.newEntry("ext1", String.valueOf(this.j)), QCircleReportHelper.newEntry("ext2", "PeakNoAlive"), QCircleReportHelper.newEntry("ret_code", "0") }));
    localObject = this.i;
    if (localObject != null) {
      ((QCircleLoadingDialog)localObject).a();
    }
    QCirclePluginInitHelper.preloadPeakProcess(g());
    r();
  }
  
  private void r()
  {
    long l1 = Long.valueOf(HostDataTransUtils.getAccount()).longValue();
    Bundle localBundle = new Bundle();
    localBundle.putLong(QCircleHostConstants.PeakConstants.TIME_STAMP(), System.currentTimeMillis());
    localBundle.putLong(QCircleHostConstants.PeakConstants.TIMESTAMP_LAST_ACTIVITY(), System.currentTimeMillis());
    localBundle.putInt("key_qcircle_entrance_type", 3);
    localBundle.putBoolean("bundle_key_select_qq_photo", this.o);
    localBundle.putBoolean("bundle_key_allow_long_video", this.n);
    localBundle.putBoolean("key_qcircle_reopen_carema", true);
    localBundle.putAll(c().getIntent().getExtras());
    Object localObject1 = new QCircleInitBean();
    ((QCircleInitBean)localObject1).setFromReportBean(d().clone());
    localBundle.putSerializable("key_bundle_common_init_bean", (Serializable)localObject1);
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_scheme")))
    {
      localObject1 = c().getIntent().getStringExtra("key_scheme");
      localBundle.putString("key_scheme", (String)localObject1);
      c().getIntent().putExtra("key_scheme", "");
    }
    else
    {
      localObject1 = "";
    }
    if (!TextUtils.isEmpty(this.v)) {
      localBundle.putString("key_polymerization_scheme", this.v);
    }
    localBundle.putBoolean("key_is_capsule_button", this.p.j());
    this.p.a(Boolean.valueOf(false));
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_attrs")))
    {
      localBundle.putSerializable("key_attrs", (HashMap)c().getIntent().getSerializableExtra("key_attrs"));
      c().getIntent().putExtra("key_attrs", new HashMap());
    }
    Object localObject2 = this.m;
    if (((localObject2 instanceof QCirclePolymerizationBean)) && ((((QCirclePolymerizationBean)localObject2).getPolymerizationType() == 7) || (((QCirclePolymerizationBean)this.m).getPolymerizationType() == 20))) {
      localBundle.putBoolean("key_qcircle_publish_finish_jump_to_mainpage", true);
    }
    localObject2 = this.m;
    if (((localObject2 instanceof QCirclePolymerizationBean)) && (((QCirclePolymerizationBean)localObject2).getPolymerizationType() == 20) && (this.m.getSimulateData() != null) && (!TextUtils.isEmpty(this.m.getSimulateData().simulate_schema.get()))) {
      localBundle.putString("key_scheme", this.m.getSimulateData().simulate_schema.get());
    }
    localObject2 = this.g;
    if (localObject2 != null)
    {
      localBundle.putString("key_qcircle_publish_default_tag_id", ((FeedCloudMeta.StTagInfo)localObject2).tagId.get());
      localBundle.putString("key_qcircle_publish_default_tag_name", this.g.tagName.get());
    }
    localBundle.putBoolean("key_qcircle_publish_smart_block_buster", QCirclePhotoScanManager.f());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("jumpToPublishPage... schema:");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("[QcirclePublish]QCirclePublishFeedPart", 1, ((StringBuilder)localObject2).toString());
    QCircleLauncher.a(c(), localBundle, String.valueOf(l1), this.j, this.u);
    if ((QCircleConfigHelper.a(HostDataTransUtils.isStudyMode())) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      c().finish();
    }
  }
  
  public String a()
  {
    return "[QcirclePublish]QCirclePublishFeedPart";
  }
  
  public void a(int paramInt)
  {
    if (!this.k) {
      this.j = paramInt;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (256 == paramInt1)
    {
      QLog.d("[QcirclePublish]QCirclePublishFeedPart", 1, "doOnActivityResult，return from qzone publish page");
      QCircleReportHelper.getInstance().recordPageEndShow(36, true);
      return;
    }
    if (257 == paramInt1) {
      return;
    }
    if (QCircleHostConstants._QQStoryMainActivity.REQUEST_CODE_TAKE_VIDEO() == paramInt1)
    {
      HostUIHelper.closeHostEnvironment();
      Object localObject = c().getIntent();
      if (paramInt2 == -1)
      {
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getExtras();
          if (paramIntent != null)
          {
            if (!paramIntent.getBoolean("key_is_take_photo")) {
              return;
            }
            String str = paramIntent.getString(QCircleConstants.w, "");
            paramInt1 = paramIntent.getInt("fromType", 1);
            QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PICKER_EXIT_NORMAL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", str), QCircleReportHelper.newEntry("ext1", String.valueOf(paramInt1)), QCircleReportHelper.newEntry("ret_code", "0") }));
            paramIntent.putBoolean("key_is_take_photo", false);
            if ((localObject != null) && (((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean") != null)) {
              paramIntent.putSerializable("key_bundle_common_init_bean", ((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean"));
            }
            QCircleLauncher.a(g(), paramIntent);
            return;
          }
          return;
        }
        QCircleLauncher.a(g(), null);
        return;
      }
      if ((paramInt2 == 0) && (paramIntent != null))
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent == null) {
          return;
        }
        localObject = paramIntent.getString(QCircleConstants.w, "");
        paramInt1 = paramIntent.getInt("fromType", 1);
        QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PICKER_EXIT_CANCEL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", (String)localObject), QCircleReportHelper.newEntry("ext1", String.valueOf(paramInt1)), QCircleReportHelper.newEntry("ret_code", "0") }));
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.c = paramView;
    this.p = ((QCirclePublishButtonViewModel)a(QCirclePublishButtonViewModel.class));
    this.d = ((ImageView)paramView.findViewById(2131440943));
    this.d.setOnClickListener(this);
    FeedCloudMeta.StUser localStUser = this.f;
    if ((localStUser != null) && (QCirclePluginUtil.b(localStUser))) {
      this.d.setVisibility(0);
    } else {
      this.d.setVisibility(8);
    }
    VideoReport.setElementId(this.d, "em_xsj_edit_button");
    VideoReport.setElementParams(this.d, new QCircleDTParamBuilder().buildElementParams());
    this.e = ((QCircleGuideBubbleView)paramView.findViewById(2131441808));
    paramView = this.e;
    if (paramView != null)
    {
      paramView.setNeedFadeAnim(true);
      this.e.setText(QCircleConfigHelper.ad());
    }
    if (this.i == null) {
      this.i = new QCircleLoadingDialog(g());
    }
    long l1 = System.currentTimeMillis();
    LayoutInflater.from(g()).inflate(2131626925, null);
    if (QLog.isDevelopLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onInitView... cost:");
      paramView.append(System.currentTimeMillis() - l1);
      QLog.d("[Performance2][QcirclePublish]QCirclePublishFeedPart", 1, paramView.toString());
    }
    l1 = System.currentTimeMillis();
    QCircleHostLauncher.isCameraResReady();
    if (QLog.isDevelopLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onInitView... isCameraResReady cost:");
      paramView.append(System.currentTimeMillis() - l1);
      QLog.d("[Performance2][QcirclePublish]QCirclePublishFeedPart", 1, paramView.toString());
    }
    m();
  }
  
  public void a(QCircleInitBean paramQCircleInitBean)
  {
    this.m = paramQCircleInitBean;
  }
  
  public void a(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.l = paramReportBean;
  }
  
  public void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    this.g = paramStTagInfo;
  }
  
  void a(Object paramObject)
  {
    if ((paramObject instanceof Boolean))
    {
      boolean bool = ((Boolean)paramObject).booleanValue();
      if (QCirclePluginUtil.b(this.f))
      {
        paramObject = this.d;
        if (paramObject != null)
        {
          int i1;
          if (bool) {
            i1 = 0;
          } else {
            i1 = 8;
          }
          paramObject.setVisibility(i1);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.v = paramString;
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (TextUtils.equals(paramString, "tab_changed"))
    {
      c(paramObject);
      return;
    }
    if (TextUtils.equals(paramString, "tab_changed_new_layer"))
    {
      d(paramObject);
      return;
    }
    if (TextUtils.equals(paramString, "tab_rsp"))
    {
      b(paramObject);
      return;
    }
    if (TextUtils.equals(paramString, "publish_show_or_hide"))
    {
      a(paramObject);
      return;
    }
    if (TextUtils.equals(paramString, "publish_on_click"))
    {
      i();
      return;
    }
    if (TextUtils.equals(paramString, "show_publish_feed_guide_bubble")) {
      n();
    }
  }
  
  void b(Object paramObject)
  {
    if ((paramObject instanceof FeedCloudMeta.StTagInfo)) {
      this.g = ((FeedCloudMeta.StTagInfo)paramObject);
    }
  }
  
  public QCircleReportBean d()
  {
    ReportBean localReportBean = this.l;
    if (localReportBean != null) {
      return (QCircleReportBean)localReportBean.getReportBean();
    }
    return super.d();
  }
  
  protected int e()
  {
    if (this.b != null) {
      return QCircleReportBean.getParentPageId(a(), this.b);
    }
    if (this.l != null) {
      return QCircleReportBean.getParentPageId(a(), (QCircleReportBean)this.l.getReportBean());
    }
    return 0;
  }
  
  protected int f()
  {
    if (this.b != null) {
      return QCircleReportBean.getPageId(a(), this.b);
    }
    if (this.l != null) {
      return QCircleReportBean.getPageId(a(), (QCircleReportBean)this.l.getReportBean());
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePublishButtonEvent.class);
    localArrayList.add(QFSPageSelectEvent.class);
    return localArrayList;
  }
  
  public void i()
  {
    ImageView localImageView = this.d;
    if (localImageView != null) {
      localImageView.performClick();
    }
  }
  
  public void l()
  {
    if (j().getActivity() == null) {
      return;
    }
    ActionSheet localActionSheet = this.a;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      return;
    }
    this.a = ActionSheet.a(g());
    this.a.a(2131914989, 0);
    this.a.a(2131914990, 0);
    this.a.e(2131887648);
    this.a.a(new QCirclePublishFeedPart.4(this));
    if ((!c().isFinishing()) && (!this.a.isShowing())) {
      this.a.show();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    QCirclePhotoScanManager.a().d();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = this.d;
    if (paramActivity != null) {
      paramActivity.setClickable(true);
    }
    this.h = QCirclePluginConfig.a().C();
    SimpleEventBus.getInstance().registerReceiver(this);
    QCirclePhotoScanManager.a().c();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    paramActivity = this.i;
    if ((paramActivity != null) && (paramActivity.isShowing())) {
      this.i.dismiss();
    }
    this.p.f();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131440943)
    {
      boolean bool = true;
      QLog.e("[QcirclePublish]QCirclePublishFeedPart", 1, "click publish start");
      if ((QCircleConfigHelper.bg()) && (((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).hasRunningTask()))
      {
        QCircleToast.a(QCircleToast.b, 2131896236, 0);
      }
      else if ((QCirclePublishViewModel.a(LoginData.a().b())) && (o()))
      {
        QLog.d("[QcirclePublish]QCirclePublishFeedPart", 1, "onClick... hasDraft");
        p();
      }
      else
      {
        if (QCircleHostQzoneHelper.getInt4Uin("sp_key_allow_long_video_switch", 0, LoginData.a().b()) != 1) {
          bool = false;
        }
        this.n = bool;
        if ((this.n) && (this.j != 9)) {
          l();
        } else {
          p();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePublishButtonEvent))
    {
      this.p.a((QCirclePublishButtonEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QFSPageSelectEvent))
    {
      paramSimpleBaseEvent = this.p;
      if (paramSimpleBaseEvent != null) {
        paramSimpleBaseEvent.a(f(), this.j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart
 * JD-Core Version:    0.7.0.1
 */