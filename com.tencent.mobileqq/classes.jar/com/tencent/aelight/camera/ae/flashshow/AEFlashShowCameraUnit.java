package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.AEMaterialViewModel;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.MaterialState;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashCameraCaptureButtonLayout.Style;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPanelViewModel;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowChangeModeViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.flashshow.util.PostEditLaunchUtil;
import com.tencent.aelight.camera.ae.gesture.CameraProviderViewGesture;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEBeautyReportParam;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture.CameraSwitchGestureListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.music.viewmodel.AbsWinkMusicPlayerViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModelFactory;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.util.LiuHaiUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import org.light.bean.WMElement;

public class AEFlashShowCameraUnit
  extends AEPituCameraUnit
{
  protected CameraSwitchGesture.CameraSwitchGestureListener E = new AEFlashShowCameraUnit.4(this);
  private AEFlashShowBottomPanelViewModel F;
  private AEVideoStoryStateViewModel G;
  private AEFlashShowChangeModeViewModel H;
  private AbsWinkMusicPlayerViewModel ap;
  private MusicSourceViewModel aq;
  private Dialog ar;
  private boolean as = false;
  private boolean at = false;
  private boolean au = false;
  
  public AEFlashShowCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
  }
  
  private void R()
  {
    this.F = ((AEFlashShowBottomPanelViewModel)AEViewModelProviders.a(this).get(AEFlashShowBottomPanelViewModel.class));
    this.G = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this).get(AEVideoStoryStateViewModel.class));
    this.H = ((AEFlashShowChangeModeViewModel)AEViewModelProviders.a(this).get(AEFlashShowChangeModeViewModel.class));
    MusicPlayerViewModelFactory localMusicPlayerViewModelFactory = new MusicPlayerViewModelFactory((AudioManager)s().getSystemService("audio"), Scene.CAMERA);
    Activity localActivity = s();
    if ((localActivity instanceof FragmentActivity))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)localActivity;
      this.aq = ((MusicSourceViewModel)new ViewModelProvider(localFragmentActivity).get(MusicSourceViewModel.class));
      this.ap = ((AbsWinkMusicPlayerViewModel)new ViewModelProvider(localFragmentActivity, localMusicPlayerViewModelFactory).get(AbsWinkMusicPlayerViewModel.class));
    }
    else
    {
      this.aq = ((MusicSourceViewModel)new ViewModelProvider(this).get(MusicSourceViewModel.class));
    }
    this.G.e().observe(this, new -..Lambda.AEFlashShowCameraUnit.xQzE6SlJlQU-UON00U6cXcdqJvc(this));
    this.aq.j().observe(this, new -..Lambda.AEFlashShowCameraUnit.8j6DEWBkhV_igFqSc5DY7PiFplQ(localActivity));
    this.F.e().observe(this, new AEFlashShowCameraUnit.1(this));
  }
  
  private void T()
  {
    ThreadManager.getUIHandler().post(new AEFlashShowCameraUnit.2(this));
  }
  
  private MusicVolumeControlViewModel U()
  {
    Activity localActivity = s();
    if ((localActivity instanceof FragmentActivity)) {
      return (MusicVolumeControlViewModel)new ViewModelProvider((ViewModelStoreOwner)localActivity).get(MusicVolumeControlViewModel.class);
    }
    return (MusicVolumeControlViewModel)new ViewModelProvider(this).get(MusicVolumeControlViewModel.class);
  }
  
  private void a(boolean paramBoolean, LocalMediaInfo paramLocalMediaInfo)
  {
    this.aa = false;
    this.G.e().postValue(Boolean.valueOf(false));
    if ((paramLocalMediaInfo != null) && (paramBoolean))
    {
      Object localObject1 = this.a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[onVideoCaptured] videoInfo = ");
      ((StringBuilder)localObject2).append(paramLocalMediaInfo.mDuration);
      AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
      AEBaseReportParam.a().b(2L);
      AEBeautyReportParam.a().a(this);
      AEBaseDataReporter.a().a(new HashMap(AEBeautyReportParam.a().b()));
      WinkEditorMusicInfo localWinkEditorMusicInfo = this.aq.h();
      localObject1 = Float.valueOf(0.0F);
      if (localWinkEditorMusicInfo != null) {
        localObject1 = (Float)U().d().getValue();
      }
      localObject2 = null;
      if (localWinkEditorMusicInfo != null) {
        localObject2 = this.aq.a(localWinkEditorMusicInfo.c());
      }
      PostEditLaunchUtil.a(this.b.getActivity(), 4097, paramLocalMediaInfo, localWinkEditorMusicInfo, (Integer)localObject2, (Float)localObject1);
      return;
    }
    onCaptureError(101);
  }
  
  private void aM()
  {
    ThreadManager.getUIHandler().post(new AEFlashShowCameraUnit.9(this));
  }
  
  private void aN()
  {
    if (this.I != null)
    {
      Object localObject = this.I.wmGetEditableWMElements();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          WMElement localWMElement = (WMElement)((Iterator)localObject).next();
          if ("CHECK_IN".equals(localWMElement.type)) {
            localWMElement.doCheckIn();
          }
        }
      }
    }
  }
  
  private void j(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.b.getActivity();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        if (this.ar == null)
        {
          this.ar = new Dialog((Context)localObject, 2131953338);
          this.ar.setCancelable(false);
          this.ar.setCanceledOnTouchOutside(false);
          this.ar.setContentView(2131625585);
        }
        this.ar.show();
      }
    }
    else
    {
      localObject = this.ar;
      if ((localObject != null) && (((Dialog)localObject).isShowing())) {
        this.ar.dismiss();
      }
    }
  }
  
  protected void C()
  {
    if (this.C)
    {
      B();
      return;
    }
    AEQLog.d(this.a, "try open camera, but permission is not fulfilled, so ignore");
  }
  
  public void D()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if ((this.b.getActivity() instanceof QPublicFragmentActivity))
    {
      QPublicFragmentActivity localQPublicFragmentActivity = (QPublicFragmentActivity)this.b.getActivity();
      int i;
      if (localQPublicFragmentActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (localQPublicFragmentActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
        j = 1;
      } else {
        j = 0;
      }
      boolean bool = PermissionUtils.isStorePermissionEnable(localQPublicFragmentActivity);
      LinkedList localLinkedList = new LinkedList();
      if (i != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (j != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if ((bool ^ true))
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() > 0) {
        localQPublicFragmentActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      }
    }
  }
  
  public void N()
  {
    if (this.ag != null)
    {
      MaterialState localMaterialState = (MaterialState)this.ag.a().getValue();
      if ((localMaterialState != null) && (localMaterialState.b() != 1)) {
        this.R.a(null);
      }
    }
  }
  
  public void O()
  {
    if (this.ag != null)
    {
      MaterialState localMaterialState = (MaterialState)this.ag.a().getValue();
      if ((localMaterialState != null) && (localMaterialState.b() != 1)) {
        this.R.a(localMaterialState.a());
      }
    }
  }
  
  public void P()
  {
    AbsWinkMusicPlayerViewModel localAbsWinkMusicPlayerViewModel = this.ap;
    if (localAbsWinkMusicPlayerViewModel != null) {
      localAbsWinkMusicPlayerViewModel.d();
    }
  }
  
  public void Q()
  {
    AbsWinkMusicPlayerViewModel localAbsWinkMusicPlayerViewModel = this.ap;
    if (localAbsWinkMusicPlayerViewModel != null) {
      localAbsWinkMusicPlayerViewModel.c();
    }
  }
  
  protected void S()
  {
    super.S();
    this.G.f().postValue(Boolean.valueOf(true));
    T();
  }
  
  protected VideoStoryCapturePartManager X()
  {
    Activity localActivity = s();
    View localView = localActivity.findViewById(2063990825);
    if (localView != null) {
      return new VideoStoryCapturePartManager(localActivity, localView, this);
    }
    return super.X();
  }
  
  protected boolean Y()
  {
    return true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.R.e();
    ThreadManager.getUIHandler().post(new AEFlashShowCameraUnit.5(this));
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    am().a();
  }
  
  protected void aC()
  {
    super.aC();
    this.N.a(new AEFlashShowCameraUnit.3(this));
    this.M = new CameraSwitchGesture(this.h.getContext(), this.E);
  }
  
  protected void aH()
  {
    LiuHaiUtils.a(this.m, this.n, ViewUtils.dip2px(1.0F));
    this.m.setVisibility(8);
    this.n.setVisibility(8);
    if (this.af != null)
    {
      ViewTreeObserver localViewTreeObserver = this.af.getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.addOnGlobalLayoutListener(new AEFlashShowCameraUnit.6(this));
      }
    }
  }
  
  public boolean ak()
  {
    if (this.F.g())
    {
      this.F.h();
      return false;
    }
    return super.ak();
  }
  
  protected void at()
  {
    super.at();
    R();
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.C = false;
    Object localObject = this.b.getActivity();
    int i;
    if (ContextCompat.checkSelfPermission((Context)localObject, "android.permission.CAMERA") != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (ContextCompat.checkSelfPermission((Context)localObject, "android.permission.RECORD_AUDIO") != 0) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool = PermissionUtils.isStorePermissionEnable((Context)localObject);
    localObject = new LinkedList();
    if (i != 0)
    {
      ((List)localObject).add("android.permission.CAMERA");
      AEQLog.b(this.a, "【Camera Permission】denied");
    }
    if (j != 0)
    {
      ((List)localObject).add("android.permission.RECORD_AUDIO");
      AEQLog.b(this.a, "【Audio Permission】denied");
    }
    if ((bool ^ true))
    {
      ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
      ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
      AEQLog.b(this.a, "【External Storage Permission】denied");
    }
    localObject = DialogUtil.a((String[])((List)localObject).toArray(new String[0]));
    ThreadManager.getUIHandler().post(new AEFlashShowCameraUnit.7(this, (String)localObject));
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    AEQLog.b(this.a, "all necessary permissions granted");
    this.C = true;
    if (this.A)
    {
      AEQLog.b(this.a, "current activity resumed, try open camera");
      B();
    }
  }
  
  public void i()
  {
    AEQLog.b(this.a, "onPhotoCaptureStart---");
    az();
    if (this.i != null) {
      this.i.setVisibility(8);
    }
    this.S.b(196609, new Object[0]);
    j(true);
  }
  
  public View j()
  {
    this.Q = new GestureDetector(s(), new AEFlashShowCameraUnit.AEGestureListener(this), null, true);
    return super.j();
  }
  
  public void k()
  {
    super.k();
    Object localObject = this.H;
    if ((localObject != null) && (((AEFlashShowChangeModeViewModel)localObject).a.getValue() == AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE)) {
      Q();
    }
    this.at = false;
    if ((this.au) && (this.o != null))
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mAEVideoCaptureResult :");
      localStringBuilder.append(this.o.mergedMp4FilePath);
      AEQLog.a((String)localObject, localStringBuilder.toString());
      onVideoCaptured(this.o);
    }
    this.au = false;
  }
  
  public void l()
  {
    super.l();
    this.at = true;
    if (this.ao != null)
    {
      this.as = false;
      this.ao.c().postValue(Boolean.valueOf(true));
    }
    P();
  }
  
  protected int n()
  {
    return 2064056470;
  }
  
  public void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    AEQLog.b(this.a, "onPhotoCaptured--- [Type] Photo");
    this.p = paramAEPhotoCaptureResult;
    AEBaseReportParam.a().b(1L);
    AEBeautyReportParam.a().a(this);
    AEBaseDataReporter.a().a(new HashMap(AEBeautyReportParam.a().b()));
    aN();
    if (paramAEPhotoCaptureResult != null)
    {
      this.q = new LocalMediaInfo();
      this.q.path = paramAEPhotoCaptureResult.filePath;
      this.q.mMimeType = "image/*";
      paramAEPhotoCaptureResult = s().getIntent();
      if (paramAEPhotoCaptureResult != null)
      {
        paramAEPhotoCaptureResult = (HashMap)paramAEPhotoCaptureResult.getSerializableExtra("key_attrs");
        if (paramAEPhotoCaptureResult != null)
        {
          paramAEPhotoCaptureResult = (String)paramAEPhotoCaptureResult.get("music");
          break label133;
        }
      }
      paramAEPhotoCaptureResult = "";
      label133:
      PostEditLaunchUtil.a(this.b.getActivity(), 4097, this.q, paramAEPhotoCaptureResult);
    }
    aM();
    j(false);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void onVideoCaptureStart()
  {
    aB();
    e(8);
    ThreadManager.getUIHandler().post(new AEFlashShowCameraUnit.8(this));
    this.S.b(196609, new Object[0]);
  }
  
  public void onVideoCaptured(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoCaptured--- [Type] Video");
    localStringBuilder.append(this.at);
    AEQLog.b(str, localStringBuilder.toString());
    this.o = paramAEVideoCaptureResult;
    this.o.finishTimeMs = System.currentTimeMillis();
    this.q = new LocalMediaInfo();
    this.q.path = paramAEVideoCaptureResult.videoMp4FilePath;
    this.q.mMimeType = "video/mp4";
    aM();
    if (this.at) {
      this.au = true;
    }
    if (MediaUtil.a(paramAEVideoCaptureResult.videoMp4FilePath) <= 0L)
    {
      this.aa = false;
      this.G.e().postValue(Boolean.valueOf(false));
      b();
      return;
    }
    ThreadManager.getFileThreadHandler().post(new -..Lambda.AEFlashShowCameraUnit.fw0I-HzuQnrxlgjKUJ388f52Bnk(this, paramAEVideoCaptureResult));
  }
  
  protected int w()
  {
    this.w = AEVideoStoryTopBarViewModel.Ratio.FULL;
    return this.w.code;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit
 * JD-Core Version:    0.7.0.1
 */