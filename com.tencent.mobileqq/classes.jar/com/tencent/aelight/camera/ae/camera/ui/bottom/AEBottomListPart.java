package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.Toast;
import androidx.annotation.MainThread;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.play.AEPlayShowGridAdapter;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.view.AECameraCancelableProgressDialog;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.biz.videostory.capture.widgets.ScaleTransformer.Builder;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

public class AEBottomListPart
  extends VideoStoryBasePart
  implements AEBottomListScrollView.LayoutCallback, AEBottomListScrollView.OnItemChangedListener<AEBottomListAdapter.ViewHolder>, AEBottomListScrollView.ScrollStateChangeListener<AEBottomListAdapter.ViewHolder>, Observer
{
  protected int a;
  protected AEPituCameraUnit a;
  protected AECaptureController a;
  protected AEBottomListAdapter a;
  protected AEBottomListScrollView a;
  protected AEMaterialManager a;
  private AECaptureMode jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel;
  private AECameraCancelableProgressDialog jdField_a_of_type_ComTencentAelightCameraAeViewAECameraCancelableProgressDialog;
  private final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public AEBottomListPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a();
  }
  
  private int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.getItemCount())
    {
      AEMaterialMetaData localAEMaterialMetaData = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(i);
      if ((localAEMaterialMetaData != null) && (paramString.equals(localAEMaterialMetaData.k))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private AEMaterialMetaData a(int paramInt)
  {
    AEBottomListAdapter localAEBottomListAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter;
    if (localAEBottomListAdapter != null) {
      return localAEBottomListAdapter.a(paramInt);
    }
    return null;
  }
  
  private AEMaterialMetaData a(String paramString, List<AEMaterialCategory> paramList)
  {
    AEMaterialMetaData localAEMaterialMetaData;
    do
    {
      do
      {
        paramList = paramList.iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localObject = (AEMaterialCategory)paramList.next();
          } while ((localObject == null) || (((AEMaterialCategory)localObject).a == null));
          localObject = ((AEMaterialCategory)localObject).a.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject).next();
      } while (localAEMaterialMetaData == null);
      if (TextUtils.isEmpty(paramString)) {
        return localAEMaterialMetaData;
      }
    } while (!paramString.equals(localAEMaterialMetaData.k));
    return localAEMaterialMetaData;
    return null;
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData != null) && (!paramAEMaterialMetaData.equals(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData)))
    {
      int k = 0;
      int i = 1;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.getItemCount()) {
          break;
        }
        j = k;
        if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(i) == null) {
          break;
        }
        if (paramAEMaterialMetaData.k.equals(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(i).k))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(i).a(paramAEMaterialMetaData);
          c(i);
          j = 1;
          break;
        }
        i += 1;
      }
      if (j == 0)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(paramAEMaterialMetaData);
        c(1);
      }
    }
  }
  
  private void a(String paramString)
  {
    AEBaseReportParam.a().m("-1");
    int j = a(paramString);
    Object localObject1;
    Object localObject2;
    int i;
    if (j != -1)
    {
      localObject1 = this.mActivity.getIntent();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("camera^");
      ((StringBuilder)localObject2).append(paramString);
      ((Intent)localObject1).putExtra("widgetinfo", ((StringBuilder)localObject2).toString());
      paramString = a(j);
      i = j;
      if (paramString != null)
      {
        AEBaseDataReporter.a().c(paramString.k);
        paramString.b = true;
        this.mActivity.getIntent().putExtra("key_camera_material_name", paramString.s);
        i = j;
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
      localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
      boolean bool;
      if ((localObject2 != null) && (((AEPituCameraUnit)localObject2).l())) {
        bool = true;
      } else {
        bool = false;
      }
      paramString = ((AEMaterialManager)localObject1).a(paramString, bool);
      if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(paramString);
        AEBaseDataReporter.a().c(paramString.k);
        paramString.b = true;
        i = 1;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.NORMAL)
        {
          paramString = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
          if (paramString != null) {
            Toast.makeText(paramString.a(), 2064515088, 1).show();
          }
        }
        i = 0;
      }
    }
    if (i < this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.getItemCount())
    {
      c(i);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.getAdapter().notifyDataSetChanged();
    }
  }
  
  @MainThread
  private void a(String paramString1, String paramString2)
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if ((paramString1 == null) || (paramString1.equals(AECaptureMode.NORMAL.name))) {
        if (!TextUtils.isEmpty(paramString2))
        {
          if (paramString2.startsWith("http"))
          {
            b(paramString2);
          }
          else if (!this.jdField_a_of_type_Boolean)
          {
            a(paramString2);
          }
          else
          {
            AEQLog.b("AEBottomListPart", "take same procedure CANCELED, handleNormalEnter");
            m();
          }
        }
        else {
          m();
        }
      }
      l();
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 116);
    }
  }
  
  @WorkerThread
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramBoolean, a());
    ThreadManager.getUIHandler().post(new AEBottomListPart.7(this, (List)localObject));
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(paramString2, a());
    if ((a(paramString1, paramString2)) && (localObject != null) && (!((AEMaterialMetaData)localObject).f) && (!((AEMaterialMetaData)localObject).e)) {
      if (!NetworkUtil.isNetworkAvailable(this.mActivity))
      {
        AEQLog.b("AEBottomListPart", "loadAndHandleData---no network");
        this.jdField_a_of_type_Boolean = true;
        ThreadManager.getUIHandler().post(new AEBottomListPart.8(this));
      }
      else
      {
        AEMaterialManager localAEMaterialManager = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
        localAEMaterialManager.a(localAEMaterialManager.getApp(), (AEMaterialMetaData)localObject, new AEBottomListPart.9(this));
        AEQLog.b("AEBottomListPart", "wait till takeSameMaterial download finish, BEGIN");
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        AEQLog.b("AEBottomListPart", "wait till takeSameMaterial download finish, OVER");
      }
    }
    ThreadManager.getUIHandler().post(new AEBottomListPart.10(this, paramString1, paramString2));
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if ((paramString1 != null) && (!paramString1.equals(AECaptureMode.NORMAL.name))) {
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString2))
    {
      bool1 = bool2;
      if (!paramString2.startsWith("http")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleTakeSameH5Enter---url=");
    ((StringBuilder)localObject).append(paramString);
    AEQLog.b("AEBottomListPart", ((StringBuilder)localObject).toString());
    try
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", URLDecoder.decode(paramString, "UTF-8"));
      ((Intent)localObject).putExtra("loc_play_show_material_id", paramString);
      boolean bool = this.mActivity.getIntent().hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE");
      if (bool) {
        ((Intent)localObject).putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", this.mActivity.getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      } else {
        ((Intent)localObject).putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", this.mActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      }
      ((Intent)localObject).putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.L.a());
      ((Intent)localObject).putExtra("VIDEO_STORY_ACTIVITY_ID", this.mActivity.getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID"));
      this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().startActivity((Intent)localObject);
      this.mActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel;
    if ((localObject != null) && (((AEVideoStoryStateViewModel)localObject).a() != null))
    {
      localObject = (Boolean)this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().getValue();
      if (localObject != null)
      {
        bool = ((Boolean)localObject).booleanValue();
        break label44;
      }
    }
    boolean bool = true;
    label44:
    return (!c()) && (this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.b()) && (bool);
  }
  
  private boolean c()
  {
    return (this.mActivity != null) && ((AECameraEntryManager.g(this.mActivity.getIntent())) || (AECameraEntryManager.i(this.mActivity.getIntent())) || (AECameraEntryManager.j(this.mActivity.getIntent())) || (AECameraEntryManager.a(this.mActivity.getIntent()) == AECameraEntry.I.a()));
  }
  
  private void j()
  {
    if (!b()) {
      return;
    }
    ViewAnimator.a(new View[] { this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new AEBottomListPart.4(this)).b();
  }
  
  private void k()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraCancelableProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraCancelableProgressDialog = new AECameraCancelableProgressDialog(this.mActivity);
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraCancelableProgressDialog.a(new AEBottomListPart.6(this));
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraCancelableProgressDialog.show();
    }
  }
  
  private void l()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      AECameraCancelableProgressDialog localAECameraCancelableProgressDialog = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraCancelableProgressDialog;
      if ((localAECameraCancelableProgressDialog != null) && (localAECameraCancelableProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraCancelableProgressDialog.dismiss();
      }
    }
  }
  
  private void m()
  {
    AEMaterialMetaData localAEMaterialMetaData = AEMaterialManager.a();
    int i;
    if (localAEMaterialMetaData != null)
    {
      int j = a(localAEMaterialMetaData.k);
      i = j;
      if (j == -1)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(localAEMaterialMetaData);
        i = 1;
      }
    }
    else
    {
      i = 0;
    }
    if (i < this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.getItemCount()) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.scrollToPosition(i);
    }
  }
  
  private void n()
  {
    if ((AEMaterialManager.a() != null) && (AEMaterialManager.a().jdField_a_of_type_Boolean)) {
      AEMaterialManager.a().b = true;
    }
  }
  
  private void o()
  {
    AEMaterialMetaData localAEMaterialMetaData1 = AEMaterialManager.a();
    int j = 0;
    if (localAEMaterialMetaData1 != null)
    {
      AEMaterialMetaData localAEMaterialMetaData2 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localAEMaterialMetaData2 != null)
      {
        i = j;
        if (localAEMaterialMetaData1.k.equals(localAEMaterialMetaData2.k))
        {
          c(this.jdField_a_of_type_Int);
          return;
        }
      }
      while (i < this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.getItemCount())
      {
        localAEMaterialMetaData2 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(i);
        if ((localAEMaterialMetaData2 != null) && (localAEMaterialMetaData1.k.equals(localAEMaterialMetaData2.k)))
        {
          c(i);
          return;
        }
        i += 1;
      }
      c(this.jdField_a_of_type_Int);
      return;
    }
    c(0);
  }
  
  private void p()
  {
    String str = AECameraPrefsUtil.a().a("sp_key_ae_user_selected_watermark", "", 0);
    if (!"sp_val_ae_user_selected_watermark_none".equals(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recoverLastWatermark---materialId=");
      localStringBuilder.append(str);
      AEQLog.b("AEBottomListPart", localStringBuilder.toString());
      AEBaseDataReporter.a().ax();
      ThreadManager.excute(new AEBottomListPart.16(this, str), 64, null, true);
    }
  }
  
  public AEMaterialManager a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a();
    AEBaseReportParam.a().i();
    AEBaseDataReporter.a().ae();
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable AEBottomListAdapter.ViewHolder paramViewHolder1, @Nullable AEBottomListAdapter.ViewHolder paramViewHolder2) {}
  
  protected void a(int paramInt)
  {
    int i = UIUtils.a(this.mActivity, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEBottomListPart.12(this));
    localAnimatorSet.setDuration(300L).start();
    b(paramInt);
  }
  
  public void a(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.a(4);
    if ((!"call_material_id".equals(paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (!this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a()) && (paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.jdField_a_of_type_Boolean))
    {
      paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.b = false;
      paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.c = false;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(false);
  }
  
  public void a(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.b) {
      paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.c = true;
    } else {
      paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.b = true;
    }
    if ((!"call_material_id".equals(paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (AEMaterialManager.a() != null) && (!AEMaterialManager.a().equals(paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData)))
    {
      AEMaterialManager.a().b = false;
      AEMaterialManager.a().c = false;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData != null) {
      return paramAEMaterialMetaData.a();
    }
    return false;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEBottomListPart.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEBottomListPart.3(this));
  }
  
  protected void b(int paramInt)
  {
    Animation localAnimation = QIMAnimationUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    localAnimation.setStartOffset(0L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new AEBottomListPart.13(this, paramInt));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.startAnimation(localAnimation);
  }
  
  public void b(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (!"call_material_id".equals(paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k))
    {
      this.jdField_a_of_type_Int = paramInt;
      paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.b = true;
      if ((AEMaterialManager.a() != null) && (!AEMaterialManager.a().equals(paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData)))
      {
        AEMaterialManager.a().b = false;
        AEMaterialManager.a().c = false;
      }
    }
    paramViewHolder = new StringBuilder();
    paramViewHolder.append("prePosition:");
    paramViewHolder.append(this.jdField_a_of_type_Int);
    QLog.d("AEBottomListPart", 4, paramViewHolder.toString());
  }
  
  protected void c()
  {
    if (this.mActivity != null)
    {
      if (this.mActivity.isFinishing()) {
        return;
      }
      Intent localIntent = this.mActivity.getIntent();
      Object localObject2 = localIntent.getStringExtra("KEY_CURRENT_SELECT_ID");
      String str = localIntent.getStringExtra("KEY_CURRENT_TAB");
      Object localObject1 = localObject2;
      if ("null".equalsIgnoreCase((String)localObject2)) {
        localObject1 = null;
      }
      boolean bool2 = a(str, localObject1);
      boolean bool1 = bool2;
      if (bool2)
      {
        ((AEMaterialManager)AEQIMManager.a(1)).a(localObject1);
        localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(localObject1, a());
        bool1 = bool2;
        if (localObject2 != null)
        {
          bool1 = bool2;
          if (((AEMaterialMetaData)localObject2).e) {
            bool1 = false;
          }
        }
        if (bool1)
        {
          k();
          localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraCancelableProgressDialog;
          if (localObject2 != null) {
            ((AECameraCancelableProgressDialog)localObject2).a(10);
          }
        }
        localIntent.removeExtra("KEY_CURRENT_SELECT_ID");
        localIntent.removeExtra("KEY_CURRENT_TAB");
      }
      ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.5(this, str, localObject1, bool1));
    }
  }
  
  protected void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reset Selection pos: ");
    localStringBuilder.append(paramInt);
    AEQLog.a("AEBottomListPart", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(paramInt));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  public void c(@Nullable AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null)
    {
      paramViewHolder.a(3);
      paramViewHolder = paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
      WatermarkDataManager.a().a(paramViewHolder);
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter != null)
      {
        if (a(paramViewHolder))
        {
          WeishiGuideUtils.a(this.mActivity, paramViewHolder, 1);
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.b(paramViewHolder);
      }
    }
  }
  
  @TargetApi(12)
  protected void d()
  {
    int i = UIUtils.a(this.mActivity, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.getHeight());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    localAnimatorSet.addListener(new AEBottomListPart.11(this));
    localAnimatorSet.setDuration(300L).start();
    h();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.a(327683, new Object[0]);
        this.mPartManager.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().a(true, 150);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.d())
    {
      if (this.mPartManager != null) {
        this.mPartManager.a(327698, new Object[0]);
      }
      Log.d("AEBottomListPart", "arcake : startARPanel");
      this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().a(true, 150);
      return;
    }
    a(327683);
  }
  
  protected void f() {}
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.a(327684, new Object[0]);
        this.mPartManager.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().a(true, 150);
      return;
    }
    a(327684);
  }
  
  protected void h()
  {
    Animation localAnimation = QIMAnimationUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    localAnimation.setStartOffset(200L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new AEBottomListPart.14(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.startAnimation(localAnimation);
  }
  
  public void i()
  {
    if (AEPlayShowGridAdapter.selectedMidMaterialNotConsumed())
    {
      a(AEPlayShowGridAdapter.selectedMidMaterial);
      AEPlayShowGridAdapter.onSelectedMidMaterialConsumed();
    }
  }
  
  public void initView()
  {
    if (this.mRootView != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.mRootView.findViewById(2064122645)).inflate().findViewById(2064122531));
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new ScaleTransformer.Builder().a(0.88F).a());
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter = new AEBottomListAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(new AEBottomListPart.1(this));
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter);
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager = ((AEMaterialManager)AEQIMManager.a().b(1));
      if (!c())
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 113);
        this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 114);
        this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 115);
        this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this, 112);
        a();
        c();
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.b();
      }
    }
    b();
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    paramObject = new StringBuilder();
    paramObject.append("AEBottomListPart notify---eventId=");
    paramObject.append(paramInt);
    AEQLog.a("AEBottomListPart", paramObject.toString());
    if (paramInt == 113)
    {
      paramObject = AEMaterialManager.a();
      if ((paramObject != null) && (!paramObject.equals(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData)))
      {
        a(paramObject);
      }
      else
      {
        c(0);
        if (a()) {
          p();
        }
      }
      QLog.d("AEBottomListPart", 4, "current pendant has change");
      return;
    }
    if (paramInt == 1024)
    {
      QLog.d("AEBottomListPart", 4, "current watermark has change");
      c(0);
      return;
    }
    if (paramInt == 114)
    {
      paramObject = AEMaterialManager.a();
      if ((paramObject != null) && (!paramObject.equals(AEMaterialMetaData.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData))) {
        paramObject.jdField_a_of_type_Boolean = true;
      }
      a(paramObject);
      return;
    }
    if (paramInt == 115)
    {
      paramObject = AEMaterialManager.a();
      if (paramObject != null) {
        paramObject.jdField_a_of_type_Boolean = false;
      }
      a(paramObject);
      return;
    }
    if (paramInt == 112)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
      {
        paramObject = (AEMaterialMetaData)paramVarArgs[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.getItemCount())
        {
          paramVarArgs = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a(paramInt);
          if ((paramVarArgs != null) && (paramObject.k.equals(paramVarArgs.k)))
          {
            paramVarArgs.e = true;
            paramVarArgs.f = false;
            this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.notifyItemChanged(paramInt);
            return;
          }
          paramInt += 1;
        }
      }
    }
    else if (paramInt == 116)
    {
      AEQLog.b("AEBottomListPart", "notify---TEMPLATE_INFO_LIST_UPDATE");
      ThreadManager.getUIHandler().post(new AEBottomListPart.15(this));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView.setVisibility(0);
    }
  }
  
  public void onActivityResume()
  {
    if ((AEMaterialManager.a() != null) && (!AEMaterialManager.a().c()) && (this.mActivity.getIntent().getStringExtra("widgetinfo") == null))
    {
      Intent localIntent = this.mActivity.getIntent();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("camera^");
      localStringBuilder.append(AEMaterialManager.a().k);
      localIntent.putExtra("widgetinfo", localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.a(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.f();
    AEBottomListAdapter localAEBottomListAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter;
    if (localAEBottomListAdapter != null) {
      localAEBottomListAdapter.c();
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 131078: 
      this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.d().postValue(Boolean.valueOf(true));
      f();
      return;
    case 131077: 
      g();
      return;
    case 131076: 
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.b().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.d().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.c().postValue(Boolean.valueOf(false));
    n();
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.b()) && (!c()))
    {
      o();
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart
 * JD-Core Version:    0.7.0.1
 */