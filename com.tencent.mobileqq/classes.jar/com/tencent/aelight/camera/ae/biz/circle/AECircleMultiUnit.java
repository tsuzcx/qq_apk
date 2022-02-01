package com.tencent.aelight.camera.ae.biz.circle;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleChangeBottomTabVisibleEvent;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleClearAllSelectEvent;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleJumpCameraPageEvent;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.view.AETouchNotifyRelativeLayout;
import com.tencent.aelight.camera.ae.view.NoScrollViewPager;
import com.tencent.aelight.camera.ae.view.TabLayout;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aebase.QIMCameraLifeCycleBaseUnit;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.aeeditor.record.AEEditorRecordRecoveryHelper;
import com.tencent.aelight.camera.aeeditor.util.AEEditorJumpUtil;
import com.tencent.aelight.camera.aeeditor.util.AELocalMediaInfoUtil;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AECircleMultiUnit
  extends QIMCameraLifeCycleBaseUnit
  implements SimpleEventReceiver
{
  private IQIMCameraContainer a;
  private ICameraEntrance b;
  private NoScrollViewPager c;
  private AECircleMultiUnit.PhotoCameraViewPagerAdapter d;
  private List<AECircleMultiUnit.PageData> e = new ArrayList();
  private AEPituCameraUnit f;
  private AECirclePhotoUnit g;
  private TabLayout h;
  private AETouchNotifyRelativeLayout i;
  private AECircleMultiUnit.AEEditorUIBroadCast j;
  private boolean k = false;
  
  public AECircleMultiUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    this.a = paramIQIMCameraContainer;
    this.b = paramICameraEntrance;
    b();
    c();
  }
  
  private void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addPituCameraUnit... hasReloadPituCamera:");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append(" unitList.size():");
    ((StringBuilder)localObject).append(this.e.size());
    QLog.d("[AEEditor2]AECircleMultiUnit", 1, ((StringBuilder)localObject).toString());
    if ((!this.k) && (this.e.size() == 1))
    {
      this.k = true;
      localObject = this.e;
      AEPituCameraUnit localAEPituCameraUnit = this.f;
      ((List)localObject).add(new AECircleMultiUnit.PageData(localAEPituCameraUnit, localAEPituCameraUnit.j()));
      this.c.getAdapter().notifyDataSetChanged();
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = paramActivity.getWindow();
      localWindow.clearFlags(67108864);
      localWindow.getDecorView().setSystemUiVisibility(1280);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(paramInt);
    }
    else if (Build.VERSION.SDK_INT >= 19)
    {
      paramActivity.getWindow().addFlags(67108864);
    }
    ImmersiveUtils.setStatusTextColor(paramBoolean, paramActivity.getWindow());
  }
  
  public static void a(boolean paramBoolean, Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if ((!paramActivity.hasWindowFocus()) && (paramBoolean)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", paramBoolean);
    paramActivity.sendBroadcast(localIntent);
  }
  
  private boolean a(QIMCameraLifeCycleBaseUnit paramQIMCameraLifeCycleBaseUnit)
  {
    if ((d() != null) && (AECameraEntryManager.t(d().getIntent()))) {
      return false;
    }
    if ((d() != null) && (AECameraEntryManager.u(d().getIntent()))) {
      return false;
    }
    AECirclePhotoUnit localAECirclePhotoUnit = this.g;
    if (paramQIMCameraLifeCycleBaseUnit == localAECirclePhotoUnit) {
      return localAECirclePhotoUnit.b();
    }
    if (paramQIMCameraLifeCycleBaseUnit == this.f) {}
    return true;
  }
  
  private void b()
  {
    if (d() == null) {
      return;
    }
    int m = d().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    String str = d().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (AECameraEntry.a(m).c()) {
      AEBaseReportParam.a().a(m, str);
    }
    str = d().getIntent().getStringExtra("intent_key_uid_for_report");
    AEBaseReportParam.a().c(str);
    AEBaseReportParam.a().a(true);
    AEBaseReportParam.a().d();
    AEBaseReportParam.a().b();
    AEBaseReportParam.a().d(CameraOperationHelper.a());
    AEBaseReportParam.a().e(CameraOperationHelper.b());
    AEBaseReportParam.a().a(ParamsUtil.b());
  }
  
  private void c()
  {
    String str = d().getIntent().getStringExtra("qcircle_client_traceid");
    if (!TextUtils.isEmpty(str)) {
      PeakIpcController.a(str, "action_qcircle_report");
    }
  }
  
  private Activity d()
  {
    IQIMCameraContainer localIQIMCameraContainer = this.a;
    if (localIQIMCameraContainer == null) {
      return null;
    }
    return localIQIMCameraContainer.getActivity();
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = d().getIntent().getStringExtra("tab");
    boolean bool2 = TextUtils.isEmpty((CharSequence)localObject);
    boolean bool1 = true;
    int m;
    if ((!bool2) && (((String)localObject).equals("camera"))) {
      m = 1;
    } else {
      m = 0;
    }
    int n = m;
    if (m == 0)
    {
      n = m;
      if (AECameraPrefsUtil.a().b("circle_entry_type_camera", false, 4)) {
        n = 1;
      }
    }
    localObject = AECameraPrefsUtil.a();
    if (n == 1) {
      bool1 = false;
    }
    ((AECameraPrefsUtil)localObject).a("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", bool1, 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initBottomTab] choose tab index=");
    ((StringBuilder)localObject).append(n);
    AEQLog.b("[AEEditor2]AECircleMultiUnit", ((StringBuilder)localObject).toString());
    localArrayList.add(this.a.getActivity().getResources().getString(2131892540));
    localArrayList.add(this.a.getActivity().getResources().getString(2064187400));
    this.h.a(this.c);
    this.h.setTabSelectedCallback(new AECircleMultiUnit.1(this));
    if (!n())
    {
      if (n != 0) {
        o();
      }
      this.h.setTabs(localArrayList, 0);
    }
    else
    {
      this.h.setTabs(localArrayList, n);
    }
    a(a(i()), d());
  }
  
  private void f()
  {
    if (n())
    {
      h();
      AEBaseDataReporter.a().an();
      SimpleEventBus.getInstance().dispatchEvent(new AECircleClearAllSelectEvent());
      return;
    }
    o();
  }
  
  private void g()
  {
    AETouchNotifyRelativeLayout localAETouchNotifyRelativeLayout = this.i;
    if (localAETouchNotifyRelativeLayout == null) {
      return;
    }
    localAETouchNotifyRelativeLayout.setIaeTouchNotify(new AECircleMultiUnit.2(this));
  }
  
  private void h()
  {
    AELaunchRecorder.d().b();
    this.c.setCurrentItem(1, true);
    this.f.ai();
    this.f.k();
  }
  
  private QIMCameraLifeCycleBaseUnit i()
  {
    int m = this.c.getCurrentItem();
    return AECircleMultiUnit.PageData.a((AECircleMultiUnit.PageData)this.e.get(m));
  }
  
  private boolean n()
  {
    Activity localActivity = this.a.getActivity();
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    int m = localActivity.checkSelfPermission("android.permission.CAMERA");
    int n = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
    return (m == 0) && (n == 0);
  }
  
  private void o()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if ((this.a.getActivity() instanceof QIMCameraCaptureActivity))
    {
      QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.a.getActivity();
      int m;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
        m = 1;
      } else {
        m = 0;
      }
      int n;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
        n = 1;
      } else {
        n = 0;
      }
      LinkedList localLinkedList = new LinkedList();
      if (m != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (n != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (localLinkedList.size() > 0) {
        localQIMCameraCaptureActivity.requestPermissions(new AECircleMultiUnit.3(this, localQIMCameraCaptureActivity), 1, (String[])localLinkedList.toArray(new String[0]));
      }
    }
  }
  
  private void p()
  {
    Intent localIntent = new Intent();
    AEQLog.b("[AEEditor2]AECircleMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    i().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AEQLog.b("[AEEditor2]AECircleMultiUnit", "on activity result.");
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 203) {
      i().a(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt2 == -1) && (d() != null))
    {
      if (paramIntent == null) {
        return;
      }
      Object localObject1;
      String str;
      ArrayList localArrayList;
      Object localObject2;
      if (paramIntent.getBooleanExtra("h5_key_flag", false))
      {
        localObject1 = paramIntent.getStringExtra("h5_key_video_path");
        str = paramIntent.getStringExtra("h5_key_thumb_path");
        localArrayList = new ArrayList();
        localArrayList.add(localObject1);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put(localObject1, AELocalMediaInfoUtil.a(AELocalMediaInfoUtil.a((String)localObject1, str), paramIntent.getStringExtra("widgetinfo"), "", null, 1, null));
        AEEditorJumpUtil.a(d(), localArrayList, (HashMap)localObject2, AECameraEntryManager.a(d().getIntent()));
      }
      else if (paramIntent.getBooleanExtra("ae_editor_video_flag", false))
      {
        localObject1 = paramIntent.getStringExtra("ae_editor_video_path");
        str = paramIntent.getStringExtra("ae_editor_video_thumb_path");
        paramInt2 = paramIntent.getIntExtra("ae_editor_video_export_size_height", 0);
        int m = paramIntent.getIntExtra("ae_editor_video_export_size_width", 0);
        localArrayList = paramIntent.getStringArrayListExtra("ae_editor_video_text_cache");
        int n = paramIntent.getIntExtra("editorFrom", AECameraEntry.a.a());
        localObject2 = (LocalMediaInfo)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        AEEditorJumpUtil.a(d(), (String)localObject1, str, new Size(m, paramInt2), localArrayList, (LocalMediaInfo)localObject2, n, (HashMap)paramIntent.getSerializableExtra("key_image_sucai_info"));
      }
      else
      {
        if (paramIntent.getBooleanExtra("key_qcircle_is_back_from_image_edit", false))
        {
          localObject1 = this.g;
          if (localObject1 != null) {
            ((AECirclePhotoUnit)localObject1).a(paramInt1, paramInt2, paramIntent);
          }
          return;
        }
        AEEditorJumpUtil.a(d(), paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"), paramIntent.getIntExtra("editorFrom", AECameraEntry.y.a()), (HashMap)paramIntent.getSerializableExtra("key_image_sucai_info"));
      }
      if (paramInt1 != 203) {
        this.a.getActivity().finish();
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    new AEEditorRecordRecoveryHelper(d()).a();
    this.f = new AEPituCameraUnit(this.a, this.b);
    this.g = new AECirclePhotoUnit(this.a, this.b);
    long l = System.currentTimeMillis();
    this.f.a(paramBundle);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate... aePituCameraUnit cost:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    QLog.d("[AEEditor2]AECircleMultiUnit", 1, ((StringBuilder)localObject).toString());
    l = System.currentTimeMillis();
    this.g.a(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("onCreate... aeCirclePhotoUnit cost:");
    paramBundle.append(System.currentTimeMillis() - l);
    QLog.d("[AEEditor2]AECircleMultiUnit", 1, paramBundle.toString());
    LiuHaiUtils.g(this.a.getActivity());
    a(this.a.getActivity(), this.a.getActivity().getResources().getColor(2131168376), true);
    paramBundle = new IntentFilter();
    paramBundle.addAction("ae_editor_bottom_tab_show_hide");
    paramBundle.addAction("ae_editor_bottom_tab_change_style");
    localObject = this.a.getActivity();
    AECircleMultiUnit.AEEditorUIBroadCast localAEEditorUIBroadCast = new AECircleMultiUnit.AEEditorUIBroadCast(null);
    this.j = localAEEditorUIBroadCast;
    ((Activity)localObject).registerReceiver(localAEEditorUIBroadCast, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
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
    super.ai();
    i().ai();
  }
  
  public void aj()
  {
    super.aj();
    i().aj();
  }
  
  public boolean ak()
  {
    i().ak();
    return super.ak();
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    i().b(paramBundle);
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    a();
    Object localObject = this.f;
    if (localObject != null) {
      ((AEPituCameraUnit)localObject).e(paramBoolean);
    }
    localObject = this.g;
    if (localObject != null) {
      ((AECirclePhotoUnit)localObject).e(paramBoolean);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleJumpCameraPageEvent.class);
    localArrayList.add(AECircleChangeBottomTabVisibleEvent.class);
    return localArrayList;
  }
  
  public View j()
  {
    View localView = this.a.getActivity().getLayoutInflater().inflate(2064056377, null);
    this.c = ((NoScrollViewPager)localView.findViewById(2063991610));
    this.h = ((TabLayout)localView.findViewById(2063991465));
    this.i = ((AETouchNotifyRelativeLayout)localView.findViewById(2063991107));
    this.j.a(this.h);
    this.d = new AECircleMultiUnit.PhotoCameraViewPagerAdapter(null);
    long l = System.currentTimeMillis();
    Object localObject = this.e;
    AECirclePhotoUnit localAECirclePhotoUnit = this.g;
    ((List)localObject).add(new AECircleMultiUnit.PageData(localAECirclePhotoUnit, localAECirclePhotoUnit.j()));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreateView... aeCirclePhotoUnit cost:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    QLog.d("[AEEditor2]AECircleMultiUnit", 1, ((StringBuilder)localObject).toString());
    this.d.a(this.e);
    this.c.setAdapter(this.d);
    e();
    g();
    return localView;
  }
  
  public void k()
  {
    super.k();
    i().k();
    if (this.c.getCurrentItem() == 0) {
      AEBaseDataReporter.a().am();
    } else {
      AEBaseDataReporter.a().an();
    }
    p();
    AEQLog.b("[AEEditor2]AECircleMultiUnit", "onResume.");
    AEPituCameraUnit localAEPituCameraUnit = this.f;
    if (localAEPituCameraUnit != null) {
      localAEPituCameraUnit.ah();
    }
  }
  
  public void l()
  {
    super.l();
    i().l();
  }
  
  public void m()
  {
    super.m();
    AEQLog.b("[AEEditor2]AECircleMultiUnit", "on destroy");
    this.a.getActivity().unregisterReceiver(this.j);
    this.i.setIaeTouchNotify(null);
    Object localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AECircleMultiUnit.PageData localPageData = (AECircleMultiUnit.PageData)((Iterator)localObject).next();
        if ((localPageData != null) && (AECircleMultiUnit.PageData.a(localPageData) != null)) {
          AECircleMultiUnit.PageData.a(localPageData).m();
        }
      }
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleJumpCameraPageEvent))
    {
      f();
      return;
    }
    if ((paramSimpleBaseEvent instanceof AECircleChangeBottomTabVisibleEvent)) {
      a(a(i()), d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit
 * JD-Core Version:    0.7.0.1
 */