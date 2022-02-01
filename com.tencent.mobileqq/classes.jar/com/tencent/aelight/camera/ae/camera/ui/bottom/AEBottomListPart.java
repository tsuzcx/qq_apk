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
  protected AEPituCameraUnit a;
  protected AEBottomListScrollView b;
  protected AEBottomListAdapter c;
  protected AECaptureController d;
  protected AEMaterialManager e;
  protected int f;
  private AEVideoStoryCaptureModeViewModel g;
  private AEVideoStoryStateViewModel h;
  private AECaptureMode i;
  private AECameraCancelableProgressDialog j;
  private volatile boolean k = false;
  private final CountDownLatch l = new CountDownLatch(1);
  
  public AEBottomListPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.a = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.d = this.a.am();
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
    } while (!paramString.equals(localAEMaterialMetaData.m));
    return localAEMaterialMetaData;
    return null;
  }
  
  private void a(String paramString)
  {
    AEBaseReportParam.a().q("-1");
    int n = c(paramString);
    Object localObject1;
    Object localObject2;
    int m;
    if (n != -1)
    {
      localObject1 = this.mActivity.getIntent();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("camera^");
      ((StringBuilder)localObject2).append(paramString);
      ((Intent)localObject1).putExtra("widgetinfo", ((StringBuilder)localObject2).toString());
      paramString = d(n);
      m = n;
      if (paramString != null)
      {
        AEBaseDataReporter.a().c(paramString.m);
        paramString.v = true;
        this.mActivity.getIntent().putExtra("key_camera_material_name", paramString.H);
        m = n;
      }
    }
    else
    {
      localObject1 = this.e;
      localObject2 = this.a;
      boolean bool;
      if ((localObject2 != null) && (((AEPituCameraUnit)localObject2).M())) {
        bool = true;
      } else {
        bool = false;
      }
      paramString = ((AEMaterialManager)localObject1).a(paramString, bool);
      if (paramString != null)
      {
        this.c.a(paramString);
        AEBaseDataReporter.a().c(paramString.m);
        paramString.v = true;
        m = 1;
      }
      else
      {
        if (this.i == AECaptureMode.NORMAL)
        {
          paramString = this.a;
          if (paramString != null) {
            Toast.makeText(paramString.s(), 2064187418, 1).show();
          }
        }
        m = 0;
      }
    }
    if (m < this.c.getItemCount())
    {
      c(m);
      this.b.getAdapter().notifyDataSetChanged();
    }
  }
  
  @WorkerThread
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = this.e.a(paramBoolean, k());
    ThreadManager.getUIHandler().post(new AEBottomListPart.7(this, (List)localObject));
    localObject = this.e.a(paramString2, k());
    if ((a(paramString1, paramString2)) && (localObject != null) && (!((AEMaterialMetaData)localObject).B) && (!((AEMaterialMetaData)localObject).A)) {
      if (!NetworkUtil.isNetworkAvailable(this.mActivity))
      {
        AEQLog.b("AEBottomListPart", "loadAndHandleData---no network");
        this.k = true;
        ThreadManager.getUIHandler().post(new AEBottomListPart.8(this));
      }
      else
      {
        AEMaterialManager localAEMaterialManager = this.e;
        localAEMaterialManager.a(localAEMaterialManager.getApp(), (AEMaterialMetaData)localObject, new AEBottomListPart.9(this));
        AEQLog.b("AEBottomListPart", "wait till takeSameMaterial download finish, BEGIN");
        try
        {
          this.l.await();
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
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData != null) && (!paramAEMaterialMetaData.equals(AEMaterialMetaData.l)))
    {
      int i1 = 0;
      int m = 1;
      int n;
      for (;;)
      {
        n = i1;
        if (m >= this.c.getItemCount()) {
          break;
        }
        n = i1;
        if (this.c.a(m) == null) {
          break;
        }
        if (paramAEMaterialMetaData.m.equals(this.c.a(m).m))
        {
          this.c.a(m).b(paramAEMaterialMetaData);
          c(m);
          n = 1;
          break;
        }
        m += 1;
      }
      if (n == 0)
      {
        this.c.a(paramAEMaterialMetaData);
        c(1);
      }
    }
  }
  
  private void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleTakeSameH5Enter---url=");
    ((StringBuilder)localObject).append(paramString);
    AEQLog.b("AEBottomListPart", ((StringBuilder)localObject).toString());
    try
    {
      localObject = new Intent(this.a.s(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", URLDecoder.decode(paramString, "UTF-8"));
      ((Intent)localObject).putExtra("loc_play_show_material_id", paramString);
      boolean bool = this.mActivity.getIntent().hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE");
      if (bool) {
        ((Intent)localObject).putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", this.mActivity.getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      } else {
        ((Intent)localObject).putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", this.mActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      }
      ((Intent)localObject).putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.N.a());
      ((Intent)localObject).putExtra("VIDEO_STORY_ACTIVITY_ID", this.mActivity.getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID"));
      this.a.s().startActivity((Intent)localObject);
      this.mActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @MainThread
  private void b(String paramString1, String paramString2)
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
          else if (!this.k)
          {
            a(paramString2);
          }
          else
          {
            AEQLog.b("AEBottomListPart", "take same procedure CANCELED, handleNormalEnter");
            q();
          }
        }
        else {
          q();
        }
      }
      p();
      this.e.a(this, 116);
    }
  }
  
  private int c(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    int m = 0;
    while (m < this.c.getItemCount())
    {
      AEMaterialMetaData localAEMaterialMetaData = this.c.a(m);
      if ((localAEMaterialMetaData != null) && (paramString.equals(localAEMaterialMetaData.m))) {
        return m;
      }
      m += 1;
    }
    return -1;
  }
  
  private AEMaterialMetaData d(int paramInt)
  {
    AEBottomListAdapter localAEBottomListAdapter = this.c;
    if (localAEBottomListAdapter != null) {
      return localAEBottomListAdapter.a(paramInt);
    }
    return null;
  }
  
  private void m()
  {
    if (!n()) {
      return;
    }
    ViewAnimator.a(new View[] { this.b }).d(new float[] { 0.0F, 1.0F }).a(300L).a(new AEBottomListPart.4(this)).d();
  }
  
  private boolean n()
  {
    Object localObject = this.h;
    if ((localObject != null) && (((AEVideoStoryStateViewModel)localObject).a() != null))
    {
      localObject = (Boolean)this.h.a().getValue();
      if (localObject != null)
      {
        bool = ((Boolean)localObject).booleanValue();
        break label44;
      }
    }
    boolean bool = true;
    label44:
    return (!r()) && (this.g.b()) && (bool);
  }
  
  private void o()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (this.j == null)
      {
        this.j = new AECameraCancelableProgressDialog(this.mActivity);
        this.j.a(new AEBottomListPart.6(this));
      }
      this.j.show();
    }
  }
  
  private void p()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      AECameraCancelableProgressDialog localAECameraCancelableProgressDialog = this.j;
      if ((localAECameraCancelableProgressDialog != null) && (localAECameraCancelableProgressDialog.isShowing())) {
        this.j.dismiss();
      }
    }
  }
  
  private void q()
  {
    AEMaterialMetaData localAEMaterialMetaData = AEMaterialManager.n();
    int m;
    if (localAEMaterialMetaData != null)
    {
      int n = c(localAEMaterialMetaData.m);
      m = n;
      if (n == -1)
      {
        this.c.a(localAEMaterialMetaData);
        m = 1;
      }
    }
    else
    {
      m = 0;
    }
    if (m < this.c.getItemCount()) {
      this.b.scrollToPosition(m);
    }
  }
  
  private boolean r()
  {
    if (this.mActivity == null) {
      return true;
    }
    return AECameraEntryManager.o(this.mActivity.getIntent()) ^ true;
  }
  
  private void s()
  {
    if ((AEMaterialManager.n() != null) && (AEMaterialManager.n().u)) {
      AEMaterialManager.n().v = true;
    }
  }
  
  private void t()
  {
    AEMaterialMetaData localAEMaterialMetaData1 = AEMaterialManager.n();
    int n = 0;
    if (localAEMaterialMetaData1 != null)
    {
      AEMaterialMetaData localAEMaterialMetaData2 = this.c.a(this.f);
      int m = n;
      if (localAEMaterialMetaData2 != null)
      {
        m = n;
        if (localAEMaterialMetaData1.m.equals(localAEMaterialMetaData2.m))
        {
          c(this.f);
          return;
        }
      }
      while (m < this.c.getItemCount())
      {
        localAEMaterialMetaData2 = this.c.a(m);
        if ((localAEMaterialMetaData2 != null) && (localAEMaterialMetaData1.m.equals(localAEMaterialMetaData2.m)))
        {
          c(m);
          return;
        }
        m += 1;
      }
      c(this.f);
      return;
    }
    c(0);
  }
  
  private void u()
  {
    String str = AECameraPrefsUtil.a().b("sp_key_ae_user_selected_watermark", "", 0);
    if (!"sp_val_ae_user_selected_watermark_none".equals(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recoverLastWatermark---materialId=");
      localStringBuilder.append(str);
      AEQLog.b("AEBottomListPart", localStringBuilder.toString());
      AEBaseDataReporter.a().aC();
      ThreadManager.excute(new AEBottomListPart.16(this, str), 64, null, true);
    }
  }
  
  protected void a()
  {
    this.c.a();
    AEBaseReportParam.a().N();
    AEBaseDataReporter.a().aj();
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable AEBottomListAdapter.ViewHolder paramViewHolder1, @Nullable AEBottomListAdapter.ViewHolder paramViewHolder2) {}
  
  protected void a(int paramInt)
  {
    int m = UIUtils.a(this.mActivity, this.b.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.b, "translationY", new float[] { 0.0F, m });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEBottomListPart.12(this));
    localAnimatorSet.setDuration(300L).start();
    b(paramInt);
  }
  
  public void a(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.a(4);
    if ((!"call_material_id".equals(paramViewHolder.a.m)) && (!this.c.d()) && (paramViewHolder.a.u))
    {
      paramViewHolder.a.v = false;
      paramViewHolder.a.w = false;
    }
    this.c.a(false);
  }
  
  public void a(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramViewHolder.a.v) {
      paramViewHolder.a.w = true;
    } else {
      paramViewHolder.a.v = true;
    }
    if ((!"call_material_id".equals(paramViewHolder.a.m)) && (AEMaterialManager.n() != null) && (!AEMaterialManager.n().equals(paramViewHolder.a)))
    {
      AEMaterialManager.n().v = false;
      AEMaterialManager.n().w = false;
    }
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
    this.g = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.a).get(AEVideoStoryCaptureModeViewModel.class));
    this.g.a.observe(this.a, new AEBottomListPart.2(this));
    this.h = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.a).get(AEVideoStoryStateViewModel.class));
    this.h.a().observe(this.a, new AEBottomListPart.3(this));
  }
  
  protected void b(int paramInt)
  {
    Animation localAnimation = QIMAnimationUtils.a(this.b, 1.0F, 0.0F);
    localAnimation.setStartOffset(0L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new AEBottomListPart.13(this, paramInt));
    this.b.startAnimation(localAnimation);
  }
  
  public void b(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (!"call_material_id".equals(paramViewHolder.a.m))
    {
      this.f = paramInt;
      paramViewHolder.a.v = true;
      if ((AEMaterialManager.n() != null) && (!AEMaterialManager.n().equals(paramViewHolder.a)))
      {
        AEMaterialManager.n().v = false;
        AEMaterialManager.n().w = false;
      }
    }
    paramViewHolder = new StringBuilder();
    paramViewHolder.append("prePosition:");
    paramViewHolder.append(this.f);
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
        localObject2 = this.e.a(localObject1, k());
        bool1 = bool2;
        if (localObject2 != null)
        {
          bool1 = bool2;
          if (((AEMaterialMetaData)localObject2).A) {
            bool1 = false;
          }
        }
        if (bool1)
        {
          o();
          localObject2 = this.j;
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
    this.b.a(paramInt, this.c.a(paramInt));
    this.b.invalidate();
  }
  
  public void c(@Nullable AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null)
    {
      paramViewHolder.a(3);
      paramViewHolder = paramViewHolder.a;
      WatermarkDataManager.a().a(paramViewHolder);
      if (this.c != null)
      {
        if (a(paramViewHolder))
        {
          WeishiGuideUtils.a(this.mActivity, paramViewHolder, 1);
          return;
        }
        this.c.b(paramViewHolder);
      }
    }
  }
  
  @TargetApi(12)
  protected void d()
  {
    int m = UIUtils.a(this.mActivity, this.b.getHeight());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.b, "translationY", new float[] { m, 0.0F }));
    localAnimatorSet.addListener(new AEBottomListPart.11(this));
    localAnimatorSet.setDuration(300L).start();
    i();
  }
  
  protected void e()
  {
    if (this.g.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.b(327683, new Object[0]);
        this.mPartManager.b(196612, new Object[0]);
      }
      this.a.am().a(true, 150);
      return;
    }
    if (this.g.d())
    {
      if (this.mPartManager != null) {
        this.mPartManager.b(327698, new Object[0]);
      }
      Log.d("AEBottomListPart", "arcake : startARPanel");
      this.a.am().a(true, 150);
      return;
    }
    a(327683);
  }
  
  protected void f() {}
  
  protected void g()
  {
    if (this.g.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.b(327684, new Object[0]);
        this.mPartManager.b(196612, new Object[0]);
      }
      this.a.am().a(true, 150);
      return;
    }
    a(327684);
  }
  
  protected void h()
  {
    if (this.g.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.b(327701, new Object[0]);
        this.mPartManager.b(196612, new Object[0]);
      }
      this.a.am().a(true, 150);
      return;
    }
    a(327701);
  }
  
  protected void i()
  {
    Animation localAnimation = QIMAnimationUtils.a(this.b, 0.0F, 1.0F);
    localAnimation.setStartOffset(200L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new AEBottomListPart.14(this));
    this.b.startAnimation(localAnimation);
  }
  
  public void initView()
  {
    if (this.mRootView != null)
    {
      this.b = ((AEBottomListScrollView)((ViewStub)this.mRootView.findViewById(2063991432)).inflate().findViewById(2063991350));
      this.b.setSlideOnFling(true);
      this.b.setItemTransitionTimeMillis(100);
      this.b.setSlideOnFlingThreshold(1000);
      this.b.setOffscreenItems(10);
      this.b.setOnItemChangedListener(this);
      this.b.setScrollStateChangeListener(this);
      this.b.setItemTransformer(new ScaleTransformer.Builder().a(0.754F).a());
      this.b.setLayoutCallback(this);
      this.c = new AEBottomListAdapter(this.a, this.b, this.d);
      this.c.a(new AEBottomListPart.1(this));
      this.b.setAdapter(this.c);
      this.e = ((AEMaterialManager)AEQIMManager.a().b(1));
      if (!r())
      {
        this.e.a(this, 113);
        this.e.a(this, 114);
        this.e.a(this, 115);
        this.e.a(this, 112);
        a();
        c();
      }
      else
      {
        this.b.setVisibility(8);
        this.c.b();
      }
    }
    b();
  }
  
  public AEMaterialManager j()
  {
    return this.e;
  }
  
  public boolean k()
  {
    return false;
  }
  
  public void l()
  {
    if (AEPlayShowGridAdapter.selectedMidMaterialNotConsumed())
    {
      b(AEPlayShowGridAdapter.selectedMidMaterial);
      AEPlayShowGridAdapter.onSelectedMidMaterialConsumed();
    }
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    paramObject = new StringBuilder();
    paramObject.append("AEBottomListPart notify---eventId=");
    paramObject.append(paramInt);
    AEQLog.a("AEBottomListPart", paramObject.toString());
    if (paramInt == 113)
    {
      paramObject = AEMaterialManager.n();
      if ((paramObject != null) && (!paramObject.equals(AEMaterialMetaData.l)))
      {
        b(paramObject);
      }
      else
      {
        c(0);
        if (k()) {
          u();
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
      paramObject = AEMaterialManager.n();
      if ((paramObject != null) && (!paramObject.equals(AEMaterialMetaData.l))) {
        paramObject.u = true;
      }
      b(paramObject);
      return;
    }
    if (paramInt == 115)
    {
      paramObject = AEMaterialManager.n();
      if (paramObject != null) {
        paramObject.u = false;
      }
      b(paramObject);
      return;
    }
    if (paramInt == 112)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
      {
        paramObject = (AEMaterialMetaData)paramVarArgs[0];
        paramInt = 0;
        while (paramInt < this.c.getItemCount())
        {
          paramVarArgs = this.c.a(paramInt);
          if ((paramVarArgs != null) && (paramObject.m.equals(paramVarArgs.m)))
          {
            paramVarArgs.A = true;
            paramVarArgs.B = false;
            this.c.notifyItemChanged(paramInt);
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
    if (n()) {
      this.b.setVisibility(0);
    }
  }
  
  public void onActivityResume()
  {
    if ((AEMaterialManager.n() != null) && (!AEMaterialManager.n().d()) && (this.mActivity.getIntent().getStringExtra("widgetinfo") == null))
    {
      Intent localIntent = this.mActivity.getIntent();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("camera^");
      localStringBuilder.append(AEMaterialManager.n().m);
      localIntent.putExtra("widgetinfo", localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    this.e.a(this);
    this.e.k();
    AEBottomListAdapter localAEBottomListAdapter = this.c;
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
    case 131079: 
      h();
      return;
    case 131078: 
      this.h.d().postValue(Boolean.valueOf(true));
      f();
      return;
    case 131077: 
      g();
      return;
    case 131076: 
      e();
      return;
    }
    this.h.b().postValue(Boolean.valueOf(false));
    this.h.d().postValue(Boolean.valueOf(false));
    this.h.c().postValue(Boolean.valueOf(false));
    s();
    if ((this.g.b()) && (!r()))
    {
      t();
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart
 * JD-Core Version:    0.7.0.1
 */