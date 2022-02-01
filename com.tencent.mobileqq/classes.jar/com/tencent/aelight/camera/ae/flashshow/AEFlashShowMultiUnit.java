package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.IQIMCameraLifeCallback;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPanelViewModel;
import com.tencent.aelight.camera.ae.flashshow.view.TabLayout;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.view.NoScrollViewPager;
import com.tencent.aelight.camera.aebase.QIMCameraLifeCycleBaseUnit;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListFragment;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleChangeBottomTabVisibleEvent;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleClosePreviewLayerEvent;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleShowPhotoPreviewEvent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AEFlashShowMultiUnit
  extends QIMCameraLifeCycleBaseUnit
  implements SimpleEventReceiver
{
  private static final List<String> a = new ArrayList(Arrays.asList(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE" }));
  private final QPublicFragmentActivity b;
  private final IQIMCameraContainer c;
  private final ICameraEntrance d;
  private final AEFlashShowCameraUnit e;
  private final int f;
  private final FlashShowCaptureViewManager g;
  private View h;
  private NoScrollViewPager i;
  private TabLayout j;
  private View k;
  private View l;
  private int m = -1;
  private AEFlashShowBottomPanelViewModel n;
  private AEVideoStoryStateViewModel o;
  private final int p;
  private WinkCirclePhotoListFragment q;
  private boolean r = true;
  private String s;
  
  public AEFlashShowMultiUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    this.b = ((QPublicFragmentActivity)paramIQIMCameraContainer.getActivity());
    this.c = paramIQIMCameraContainer;
    this.d = paramICameraEntrance;
    this.f = ((int)TypedValue.applyDimension(1, 56.0F, this.b.getResources().getDisplayMetrics()));
    this.e = new AEFlashShowCameraUnit(paramIQIMCameraContainer, paramICameraEntrance);
    this.g = new FlashShowCaptureViewManager(this.b, this.e);
    this.p = this.b.getIntent().getIntExtra("AECAMERA_TAB_SELECTED", 0);
    paramIQIMCameraContainer = new StringBuilder();
    paramIQIMCameraContainer.append("init tab index is: ");
    paramIQIMCameraContainer.append(this.p);
    AEQLog.b("AEFlashShowMultiUnit", paramIQIMCameraContainer.toString());
    a();
  }
  
  private void a()
  {
    this.s = this.b.getIntent().getStringExtra("qcircle_client_traceid");
    if (!TextUtils.isEmpty(this.s)) {
      PeakIpcController.a(this.s, "action_qcircle_report");
    }
  }
  
  private void a(int paramInt)
  {
    if (this.m == paramInt) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("change tab to: ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.b("AEFlashShowMultiUnit", ((StringBuilder)localObject).toString());
    this.m = paramInt;
    this.i.setCurrentItem(paramInt);
    localObject = this.j;
    int i1;
    if (paramInt == 0) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    ((TabLayout)localObject).a(i1);
    if ((paramInt == 0) && (this.k != null))
    {
      this.g.c().k();
      this.g.a();
      i();
    }
    else
    {
      this.g.b();
      this.g.c().l();
      n();
    }
    d();
  }
  
  private void a(@NonNull View paramView)
  {
    this.i = ((NoScrollViewPager)paramView.findViewById(2063990827));
    this.i.setOffscreenPageLimit(2);
    this.i.setAdapter(new AEFlashShowMultiUnit.5(this));
  }
  
  private void a(Boolean paramBoolean)
  {
    if (this.j != null)
    {
      WinkCirclePhotoListFragment localWinkCirclePhotoListFragment = this.q;
      if (localWinkCirclePhotoListFragment == null) {
        return;
      }
      if ((localWinkCirclePhotoListFragment.e().booleanValue()) && (paramBoolean.booleanValue())) {
        return;
      }
      int i1;
      if (paramBoolean.booleanValue()) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      if ((this.j.getVisibility() != i1) && (this.l != null))
      {
        int i2;
        if (paramBoolean.booleanValue()) {
          i2 = this.f;
        } else {
          i2 = 0;
        }
        this.l.setPadding(0, 0, 0, i2);
        this.j.setVisibility(i1);
      }
      paramBoolean = this.q;
      if ((paramBoolean != null) && (paramBoolean.h() > 0))
      {
        this.j.setVisibility(8);
        this.l.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  private void b()
  {
    this.n = ((AEFlashShowBottomPanelViewModel)AEViewModelProviders.a(this.e).get(AEFlashShowBottomPanelViewModel.class));
    this.o = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.e).get(AEVideoStoryStateViewModel.class));
    this.n.f().observe(this.e, new AEFlashShowMultiUnit.2(this));
    this.o.a().observe(this.e, new AEFlashShowMultiUnit.3(this));
    this.n.e().observe(this.e, new AEFlashShowMultiUnit.4(this));
  }
  
  private void b(@NonNull View paramView)
  {
    Resources localResources = this.c.getActivity().getResources();
    this.j = ((TabLayout)paramView.findViewById(2063990826));
    this.j.setTabSelectCallback(new AEFlashShowMultiUnit.6(this));
    this.j.setTabs(Arrays.asList(new String[] { localResources.getString(2064187400), localResources.getString(2131892540) }), this.p);
    c();
  }
  
  private void c()
  {
    if (this.j == null) {
      return;
    }
    Object localObject = this.n;
    int i1 = 0;
    if ((localObject != null) && (((AEFlashShowBottomPanelViewModel)localObject).f().getValue() == Boolean.TRUE)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    localObject = this.o;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((AEVideoStoryStateViewModel)localObject).a().getValue() != Boolean.TRUE) {
        bool1 = false;
      }
    }
    boolean bool2 = bool1;
    if (this.m == 1)
    {
      bool2 = bool1;
      if (this.q != null) {
        bool2 = this.r;
      }
    }
    localObject = this.q;
    bool1 = bool2;
    if (localObject != null) {
      if (!((WinkCirclePhotoListFragment)localObject).e().booleanValue())
      {
        bool1 = bool2;
        if (this.q.h() <= 0) {}
      }
      else
      {
        bool1 = false;
      }
    }
    localObject = this.j;
    if (!bool1) {
      i1 = 4;
    }
    ((TabLayout)localObject).setVisibility(i1);
  }
  
  private void d()
  {
    boolean bool;
    if (this.m != 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateStatusBarTheme, darkText = ");
    ((StringBuilder)localObject).append(bool);
    AEQLog.b("AEFlashShowMultiUnit", ((StringBuilder)localObject).toString());
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = this.b.getWindow().getDecorView();
      if (bool)
      {
        ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x2000);
        return;
      }
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFDFFF);
    }
  }
  
  private void e()
  {
    Object localObject = this.q;
    if (localObject == null) {
      return;
    }
    if (((WinkCirclePhotoListFragment)localObject).e().booleanValue())
    {
      this.q.f();
      localObject = this.l;
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(-1);
      }
      this.q.a(-1);
      d();
      return;
    }
    if (this.q.g().booleanValue())
    {
      this.q.a(Boolean.valueOf(false));
      return;
    }
    if (this.b != null) {
      this.q.a("");
    }
  }
  
  private void f()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      View localView = this.c.getActivity().getWindow().getDecorView();
      localView.setOnSystemUiVisibilityChangeListener(null);
      localView.setSystemUiVisibility(1792);
    }
  }
  
  private void g()
  {
    Window localWindow = this.c.getActivity().getWindow();
    localWindow.clearFlags(1024);
    localWindow.addFlags(2048);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localWindow.clearFlags(67108864);
      localWindow.clearFlags(134217728);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(0);
      localWindow.setNavigationBarColor(-16777216);
    }
  }
  
  private void h()
  {
    Intent localIntent = new Intent();
    AEQLog.b("AEFlashShowMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void i()
  {
    AEQLog.b("AEFlashShowMultiUnit", "register datong pageId to flash show camera");
    VideoReport.addToDetectionWhitelist(this.b);
    VideoReport.setPageId(this.h, "pg_xsj_camera_page");
    VideoReport.setPageParams(this.h, new PageParams(FlashShowDtReportHelper.a().c()));
  }
  
  private void n()
  {
    VideoReport.setElementId(this.j, "em_xsj_album_tab");
    VideoReport.setElementParams(this.j, FlashShowDtReportHelper.a().d());
    VideoReport.reportEvent("dt_clck", this.j, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConfigurationChanged: width = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height = ");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEFlashShowMultiUnit", localStringBuilder.toString());
    super.a(paramInt1, paramInt2);
    this.g.c().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult, requestCode = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", resultCode = ");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEFlashShowMultiUnit", localStringBuilder.toString());
    super.a(paramInt1, paramInt2, paramIntent);
    this.g.c().a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.g.c().a(paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
    FlashShowDtReportHelper.a().a(this.b);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      ak();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public void ai()
  {
    AEQLog.b("AEFlashShowMultiUnit", "onActivityStart...");
    super.ai();
    if (this.m == 0) {
      this.g.c().ai();
    }
  }
  
  public void aj()
  {
    AEQLog.b("AEFlashShowMultiUnit", "onActivityStop...");
    super.aj();
    if (this.m == 0) {
      this.g.c().aj();
    }
  }
  
  public boolean ak()
  {
    ((IPeakIpcController)QRoute.api(IPeakIpcController.class)).report(this.s, ((IPeakIpcModuleServer)QRoute.api(IPeakIpcModuleServer.class)).ACTION_QCIRCLE_PICKER_EXIT_CANCEL());
    int i1 = this.m;
    if (i1 == 0)
    {
      this.g.c().ak();
      return super.ak();
    }
    boolean bool2 = true;
    if (i1 == 1)
    {
      e();
      WinkCirclePhotoListFragment localWinkCirclePhotoListFragment = this.q;
      boolean bool1 = bool2;
      if (localWinkCirclePhotoListFragment != null) {
        if (localWinkCirclePhotoListFragment.h() <= 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      a(Boolean.valueOf(bool1));
      return super.ak();
    }
    this.c.b();
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    AEQLog.b("AEFlashShowMultiUnit", "onSaveInstanceState...");
    super.b(paramBundle);
    this.g.c().b(paramBundle);
  }
  
  public void e(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWindowFocusChanged, hasFocus = ");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("AEFlashShowMultiUnit", localStringBuilder.toString());
    super.e(paramBoolean);
    if (this.m == 0) {
      this.g.c().e(paramBoolean);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WinkCircleChangeBottomTabVisibleEvent.class);
    localArrayList.add(WinkCircleShowPhotoPreviewEvent.class);
    localArrayList.add(WinkCircleClosePreviewLayerEvent.class);
    return localArrayList;
  }
  
  public View j()
  {
    View localView = LayoutInflater.from(this.c.getActivity()).inflate(2064056473, null, false);
    ViewCompat.setOnApplyWindowInsetsListener(localView, new AEFlashShowMultiUnit.1(this));
    this.h = localView;
    a(localView);
    b(localView);
    b();
    g();
    return localView;
  }
  
  public void k()
  {
    AEQLog.b("AEFlashShowMultiUnit", "onActivityResume...");
    super.k();
    if (this.m == 0) {
      this.g.c().k();
    }
    f();
    d();
    h();
  }
  
  public void l()
  {
    AEQLog.b("AEFlashShowMultiUnit", "onActivityPause...");
    super.l();
    if (this.m == 0) {
      this.g.c().l();
    }
  }
  
  public void m()
  {
    AEQLog.b("AEFlashShowMultiUnit", "onDestroy...");
    super.m();
    this.g.c().m();
    FlashShowDtReportHelper.a().b();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof WinkCircleChangeBottomTabVisibleEvent))
    {
      paramSimpleBaseEvent = (WinkCircleChangeBottomTabVisibleEvent)paramSimpleBaseEvent;
      a(paramSimpleBaseEvent.mShowBottomTab);
      this.r = paramSimpleBaseEvent.mShowBottomTab.booleanValue();
      return;
    }
    if ((paramSimpleBaseEvent instanceof WinkCircleShowPhotoPreviewEvent))
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramSimpleBaseEvent = this.l;
        if (paramSimpleBaseEvent != null)
        {
          paramSimpleBaseEvent.setBackgroundColor(-16777216);
          this.q.a(-16777216);
          if (Build.VERSION.SDK_INT >= 23)
          {
            paramSimpleBaseEvent = this.b.getWindow().getDecorView();
            paramSimpleBaseEvent.setSystemUiVisibility(paramSimpleBaseEvent.getSystemUiVisibility() & 0xFFFFDFFF);
          }
        }
      }
    }
    else if ((paramSimpleBaseEvent instanceof WinkCircleClosePreviewLayerEvent))
    {
      paramSimpleBaseEvent = this.l;
      if (paramSimpleBaseEvent != null)
      {
        paramSimpleBaseEvent.setBackgroundColor(-1);
        this.q.a(-1);
        d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowMultiUnit
 * JD-Core Version:    0.7.0.1
 */