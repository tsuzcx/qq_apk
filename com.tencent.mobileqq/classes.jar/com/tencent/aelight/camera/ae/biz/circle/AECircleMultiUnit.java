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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.bean.Size;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class AECircleMultiUnit
  extends QIMCameraLifeCycleBaseUnit
  implements SimpleEventReceiver
{
  private AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
  private AECircleMultiUnit.AEEditorUIBroadCast jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleMultiUnit$AEEditorUIBroadCast;
  private AECircleMultiUnit.PhotoCameraViewPagerAdapter jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleMultiUnit$PhotoCameraViewPagerAdapter;
  private AECirclePhotoUnit jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoUnit;
  private AETouchNotifyRelativeLayout jdField_a_of_type_ComTencentAelightCameraAeViewAETouchNotifyRelativeLayout;
  private NoScrollViewPager jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager;
  private TabLayout jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout;
  private ICameraEntrance jdField_a_of_type_ComTencentAelightCameraAioeditorSettingICameraEntrance;
  private IQIMCameraContainer jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer;
  private List<AECircleMultiUnit.PageData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public AECircleMultiUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer = paramIQIMCameraContainer;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingICameraEntrance = paramICameraEntrance;
    b();
    c();
  }
  
  private Activity a()
  {
    IQIMCameraContainer localIQIMCameraContainer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer;
    if (localIQIMCameraContainer == null) {
      return null;
    }
    return localIQIMCameraContainer.a();
  }
  
  private QIMCameraLifeCycleBaseUnit a()
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager.getCurrentItem();
    return AECircleMultiUnit.PageData.a((AECircleMultiUnit.PageData)this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addPituCameraUnit... hasReloadPituCamera:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append(" unitList.size():");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
    QLog.d("[AEEditor2]AECircleMultiUnit", 1, ((StringBuilder)localObject).toString());
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() == 1))
    {
      this.jdField_a_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_JavaUtilList;
      AEPituCameraUnit localAEPituCameraUnit = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
      ((List)localObject).add(new AECircleMultiUnit.PageData(localAEPituCameraUnit, localAEPituCameraUnit.a()));
      this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager.getAdapter().notifyDataSetChanged();
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
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", paramBoolean);
    paramActivity.sendBroadcast(localIntent);
  }
  
  private boolean a()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    int i = localActivity.checkSelfPermission("android.permission.CAMERA");
    int j = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
    return (i == 0) && (j == 0);
  }
  
  private boolean a(QIMCameraLifeCycleBaseUnit paramQIMCameraLifeCycleBaseUnit)
  {
    if ((a() != null) && (AECameraEntryManager.o(a().getIntent()))) {
      return false;
    }
    AECirclePhotoUnit localAECirclePhotoUnit = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoUnit;
    if (paramQIMCameraLifeCycleBaseUnit == localAECirclePhotoUnit) {
      return localAECirclePhotoUnit.a();
    }
    if (paramQIMCameraLifeCycleBaseUnit == this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit) {}
    return true;
  }
  
  private void b()
  {
    if (a() == null) {
      return;
    }
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (AECameraEntry.a(i).a()) {
      AEBaseReportParam.a().a(i, str);
    }
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    AEBaseReportParam.a().c(str);
    AEBaseReportParam.a().a(true);
    AEBaseReportParam.a().b();
    AEBaseReportParam.a().a();
    AEBaseReportParam.a().d(CameraOperationHelper.a(a()));
  }
  
  private void c()
  {
    String str = a().getIntent().getStringExtra("qcircle_client_traceid");
    if (!TextUtils.isEmpty(str)) {
      PeakIpcController.a(str, "action_qcircle_report");
    }
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().getIntent().getStringExtra("tab");
    boolean bool2 = TextUtils.isEmpty((CharSequence)localObject);
    boolean bool1 = true;
    int i;
    if ((!bool2) && (((String)localObject).equals("camera"))) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (i == 0)
    {
      j = i;
      if (AECameraPrefsUtil.a().a("circle_entry_type_camera", false, 4)) {
        j = 1;
      }
    }
    localObject = AECameraPrefsUtil.a();
    if (j == 1) {
      bool1 = false;
    }
    ((AECameraPrefsUtil)localObject).a("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", bool1, 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initBottomTab] choose tab index=");
    ((StringBuilder)localObject).append(j);
    AEQLog.b("[AEEditor2]AECircleMultiUnit", ((StringBuilder)localObject).toString());
    localArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getResources().getString(2131694837));
    localArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getResources().getString(2064515075));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout.a(this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout.setTabSelectedCallback(new AECircleMultiUnit.1(this));
    if (!a())
    {
      if (j != 0) {
        k();
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout.setTabs(localArrayList, 0);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout.setTabs(localArrayList, j);
    }
    a(a(a()), a());
  }
  
  private void h()
  {
    if (a())
    {
      j();
      AEBaseDataReporter.a().ai();
      SimpleEventBus.getInstance().dispatchEvent(new AECircleClearAllSelectEvent());
      return;
    }
    k();
  }
  
  private void i()
  {
    AETouchNotifyRelativeLayout localAETouchNotifyRelativeLayout = this.jdField_a_of_type_ComTencentAelightCameraAeViewAETouchNotifyRelativeLayout;
    if (localAETouchNotifyRelativeLayout == null) {
      return;
    }
    localAETouchNotifyRelativeLayout.setIaeTouchNotify(new AECircleMultiUnit.2(this));
  }
  
  private void j()
  {
    AELaunchRecorder.a().b();
    this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager.setCurrentItem(1, true);
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.I();
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.e();
  }
  
  private void k()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a() instanceof QIMCameraCaptureActivity))
    {
      QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
      int i;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
        j = 1;
      } else {
        j = 0;
      }
      LinkedList localLinkedList = new LinkedList();
      if (i != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (j != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (localLinkedList.size() > 0) {
        localQIMCameraCaptureActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      }
    }
  }
  
  private void l()
  {
    Intent localIntent = new Intent();
    AEQLog.b("[AEEditor2]AECircleMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public void I()
  {
    super.I();
    a().I();
  }
  
  public void J()
  {
    super.J();
    a().J();
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getLayoutInflater().inflate(2064318509, null);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager = ((NoScrollViewPager)localView.findViewById(2064122836));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout = ((TabLayout)localView.findViewById(2064122668));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAETouchNotifyRelativeLayout = ((AETouchNotifyRelativeLayout)localView.findViewById(2064122225));
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleMultiUnit$AEEditorUIBroadCast.a(this.jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleMultiUnit$PhotoCameraViewPagerAdapter = new AECircleMultiUnit.PhotoCameraViewPagerAdapter(null);
    long l = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    AECirclePhotoUnit localAECirclePhotoUnit = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoUnit;
    ((List)localObject).add(new AECircleMultiUnit.PageData(localAECirclePhotoUnit, localAECirclePhotoUnit.a()));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreateView... aeCirclePhotoUnit cost:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    QLog.d("[AEEditor2]AECircleMultiUnit", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleMultiUnit$PhotoCameraViewPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleMultiUnit$PhotoCameraViewPagerAdapter);
    d();
    i();
    return localView;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    a().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AEQLog.b("[AEEditor2]AECircleMultiUnit", "on activity result.");
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 203) {
      a().a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1) {
      if ((a() != null) && (paramIntent != null))
      {
        String str1;
        String str2;
        ArrayList localArrayList;
        Object localObject;
        if (paramIntent.getBooleanExtra("h5_key_flag", false))
        {
          str1 = paramIntent.getStringExtra("h5_key_video_path");
          str2 = paramIntent.getStringExtra("h5_key_thumb_path");
          localArrayList = new ArrayList();
          localArrayList.add(str1);
          localObject = new HashMap();
          ((HashMap)localObject).put(str1, AELocalMediaInfoUtil.a(AELocalMediaInfoUtil.a(str1, str2), paramIntent.getStringExtra("widgetinfo"), "", null, 1, null));
          AEEditorJumpUtil.a(a(), localArrayList, (HashMap)localObject, AECameraEntryManager.a(a().getIntent()));
        }
        else if (paramIntent.getBooleanExtra("ae_editor_video_flag", false))
        {
          str1 = paramIntent.getStringExtra("ae_editor_video_path");
          str2 = paramIntent.getStringExtra("ae_editor_video_thumb_path");
          paramInt2 = paramIntent.getIntExtra("ae_editor_video_export_size_height", 0);
          int i = paramIntent.getIntExtra("ae_editor_video_export_size_width", 0);
          localArrayList = paramIntent.getStringArrayListExtra("ae_editor_video_text_cache");
          int j = paramIntent.getIntExtra("editorFrom", AECameraEntry.a.a());
          localObject = (LocalMediaInfo)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
          AEEditorJumpUtil.a(a(), str1, str2, new Size(i, paramInt2), localArrayList, (LocalMediaInfo)localObject, j, (HashMap)paramIntent.getSerializableExtra("key_image_sucai_info"));
        }
        else
        {
          AEEditorJumpUtil.a(a(), paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"), paramIntent.getIntExtra("editorFrom", AECameraEntry.y.a()), (HashMap)paramIntent.getSerializableExtra("key_image_sucai_info"));
        }
        if (paramInt1 != 203) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().finish();
        }
      }
      else {}
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    new AEEditorRecordRecoveryHelper(a()).a();
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = new AEPituCameraUnit(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer, this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingICameraEntrance);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoUnit = new AECirclePhotoUnit(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer, this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingICameraEntrance);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a(paramBundle);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate... aePituCameraUnit cost:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    QLog.d("[AEEditor2]AECircleMultiUnit", 1, ((StringBuilder)localObject).toString());
    l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoUnit.a(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("onCreate... aeCirclePhotoUnit cost:");
    paramBundle.append(System.currentTimeMillis() - l);
    QLog.d("[AEEditor2]AECircleMultiUnit", 1, paramBundle.toString());
    LiuHaiUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a());
    a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getResources().getColor(2131167333), true);
    paramBundle = new IntentFilter();
    paramBundle.addAction("ae_editor_bottom_tab_show_hide");
    paramBundle.addAction("ae_editor_bottom_tab_change_style");
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
    AECircleMultiUnit.AEEditorUIBroadCast localAEEditorUIBroadCast = new AECircleMultiUnit.AEEditorUIBroadCast(null);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleMultiUnit$AEEditorUIBroadCast = localAEEditorUIBroadCast;
    ((Activity)localObject).registerReceiver(localAEEditorUIBroadCast, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      i();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    a().b(paramBundle);
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    a();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
    if (localObject != null) {
      ((AEPituCameraUnit)localObject).d(paramBoolean);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoUnit;
    if (localObject != null) {
      ((AECirclePhotoUnit)localObject).d(paramBoolean);
    }
  }
  
  @QQPermissionDenied(1)
  public void denied() {}
  
  public void e()
  {
    super.e();
    a().e();
    if (this.jdField_a_of_type_ComTencentAelightCameraAeViewNoScrollViewPager.getCurrentItem() == 0) {
      AEBaseDataReporter.a().ah();
    } else {
      AEBaseDataReporter.a().ai();
    }
    l();
    AEQLog.b("[AEEditor2]AECircleMultiUnit", "onResume.");
    AEPituCameraUnit localAEPituCameraUnit = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
    if (localAEPituCameraUnit != null) {
      localAEPituCameraUnit.H();
    }
  }
  
  public void f()
  {
    super.f();
    a().f();
  }
  
  public void g()
  {
    super.g();
    AEQLog.b("[AEEditor2]AECircleMultiUnit", "on destroy");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().unregisterReceiver(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleMultiUnit$AEEditorUIBroadCast);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAETouchNotifyRelativeLayout.setIaeTouchNotify(null);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AECircleMultiUnit.PageData localPageData = (AECircleMultiUnit.PageData)((Iterator)localObject).next();
        if ((localPageData != null) && (AECircleMultiUnit.PageData.a(localPageData) != null)) {
          AECircleMultiUnit.PageData.a(localPageData).g();
        }
      }
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleJumpCameraPageEvent.class);
    localArrayList.add(AECircleChangeBottomTabVisibleEvent.class);
    return localArrayList;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    j();
  }
  
  public boolean i()
  {
    a().i();
    return super.i();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleJumpCameraPageEvent))
    {
      h();
      return;
    }
    if ((paramSimpleBaseEvent instanceof AECircleChangeBottomTabVisibleEvent)) {
      a(a(a()), a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit
 * JD-Core Version:    0.7.0.1
 */