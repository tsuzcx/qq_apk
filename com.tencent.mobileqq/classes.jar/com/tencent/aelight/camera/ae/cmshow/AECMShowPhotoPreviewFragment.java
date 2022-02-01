package com.tencent.aelight.camera.ae.cmshow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.FaceRectData;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.ScanViewListener;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.Pair;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.os.MqqHandler;

public class AECMShowPhotoPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, AECMShowFaceScanView.ScanViewListener, PublicFragmentActivityCallBackInterface
{
  private RelativeLayout a;
  private ImageView b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private AECMShowFaceScanView f;
  private FrameLayout g;
  private AECMShowLoadingView h;
  private View i;
  private Bitmap j;
  private String k;
  private int l;
  private int m;
  private AECMShowRequestController n;
  private boolean o;
  private CmShowDataWrapper p;
  private int q = 0;
  private boolean r = false;
  private int s = 0;
  private long t;
  
  @NonNull
  private DynamicTextItem.Pair<Boolean, List<PointF>> a(@Nullable Bitmap paramBitmap, @Nullable String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    paramString = Boolean.valueOf(false);
    if ((!bool) && (paramBitmap != null))
    {
      paramBitmap = FaceChangeUtils.detectBiggestFaceInGLThread(paramBitmap);
      if ((paramBitmap != null) && (paramBitmap.a != null) && (((Integer)paramBitmap.a).intValue() == 1) && (!CollectionUtils.isEmpty((Collection)paramBitmap.b)))
      {
        AEQLog.b("AECMShowPhotoPreviewFragment", "[detectFaceLocally] face detected");
        return new DynamicTextItem.Pair(Boolean.valueOf(true), FaceChangeUtils.transFromImageSpace2ContainerSpace(this.j.getWidth(), this.j.getHeight(), this.a.getWidth(), this.a.getHeight(), (List)paramBitmap.b));
      }
      AEQLog.b("AECMShowPhotoPreviewFragment", "[detectFaceLocally] no face detected");
      return new DynamicTextItem.Pair(paramString, null);
    }
    AEQLog.a("AECMShowPhotoPreviewFragment", "[detectFaceLocally] invalid data");
    return new DynamicTextItem.Pair(paramString, null);
  }
  
  private void a()
  {
    this.l = DisplayUtil.a(getBaseActivity());
    this.m = DisplayUtil.b(getBaseActivity());
    Object localObject = getArguments().getStringArrayList("PhotoConst.SELECTED_PATHS");
    if (!CollectionUtils.isEmpty((Collection)localObject)) {
      this.k = ((String)((ArrayList)localObject).get(0));
    }
    if (!TextUtils.isEmpty(this.k))
    {
      this.j = BitmapUtils.decodeSampledBitmapFromFileCheckExif(this.k, this.l, this.m);
      localObject = this.j;
      if (localObject != null)
      {
        this.b.setImageBitmap((Bitmap)localObject);
        localObject = this.b.getViewTreeObserver();
        if (((ViewTreeObserver)localObject).isAlive()) {
          ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new AECMShowPhotoPreviewFragment.2(this));
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivityForPeak.class, AECMShowPhotoPreviewFragment.class);
  }
  
  private void a(View paramView)
  {
    this.a = ((RelativeLayout)paramView.findViewById(2063991391));
    this.b = ((ImageView)paramView.findViewById(2063991203));
    this.c = ((ImageView)paramView.findViewById(2063991178));
    this.d = ((TextView)paramView.findViewById(2063991563));
    this.e = ((TextView)paramView.findViewById(2063991555));
    this.g = ((FrameLayout)paramView.findViewById(2063991088));
    this.h = ((AECMShowLoadingView)paramView.findViewById(2063990970));
    this.i = paramView.findViewById(2063991579);
    this.f = ((AECMShowFaceScanView)paramView.findViewById(2063991063));
    this.f.setListener(this);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.e.setEnabled(false);
  }
  
  private void a(List<PointF> paramList)
  {
    paramList = b(paramList);
    this.f.a(1001, paramList);
  }
  
  private AECMShowFaceScanView.FaceRectData b(@NonNull List<PointF> paramList)
  {
    PointF localPointF1 = (PointF)paramList.get(0);
    PointF localPointF2 = (PointF)paramList.get(1);
    localPointF2 = (PointF)paramList.get(2);
    Object localObject = (PointF)paramList.get(3);
    paramList = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
    float f1 = TAVStickerUtil.getDistance(paramList, (PointF)localObject);
    float f2 = TAVStickerUtil.getDistance(localPointF1, localPointF2) / 2.0F;
    localObject = new AECMShowFaceScanView.FaceRectData();
    RectF localRectF = new RectF();
    localRectF.left = (paramList.x - f2);
    localRectF.right = (paramList.x + f2);
    localRectF.top = (paramList.y - f1);
    localRectF.bottom = (paramList.y + f1);
    ((AECMShowFaceScanView.FaceRectData)localObject).a(localRectF);
    f1 = localPointF2.y;
    f2 = localPointF1.y;
    float f3 = localPointF2.x;
    float f4 = localPointF1.x;
    ((AECMShowFaceScanView.FaceRectData)localObject).a((float)Math.toDegrees(Math.atan2(f1 - f2, f3 - f4)));
    return localObject;
  }
  
  private void b()
  {
    AEQLog.b("AECMShowPhotoPreviewFragment", "startCmShowRequest");
    ThreadManager.getSubThreadHandler().post(new AECMShowPhotoPreviewFragment.3(this));
    this.s = 1;
    this.g.setVisibility(0);
    this.h.a(1, null);
    this.e.setVisibility(8);
  }
  
  private static void b(@NonNull Activity paramActivity, @NonNull CmShowDataWrapper paramCmShowDataWrapper)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10027);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("PeakConstants.ARG_FORCE_CAMERA", 1);
    localBundle.putSerializable("KEY_CMSHOW_DATA", paramCmShowDataWrapper);
    paramCmShowDataWrapper = QIMCameraCaptureActivity.b(paramActivity, localBundle);
    paramCmShowDataWrapper.addFlags(603979776);
    paramActivity.startActivity(paramCmShowDataWrapper);
    paramActivity.finish();
  }
  
  public void T()
  {
    this.f.a(1003, null);
    this.c.setImageResource(2063925306);
    b();
  }
  
  public void U() {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(paramActivity.getWindow());
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    if (this.s == 2) {
      AEBaseDataReporter.a().a(1, System.currentTimeMillis() - this.t);
    }
    getBaseActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2063991555)
    {
      onBackPressed();
      return;
    }
    if (i1 == 2063991178) {
      onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.n = new AECMShowRequestController(2, new AECMShowPhotoPreviewFragment.1(this));
    this.n.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064056359, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Bitmap localBitmap = this.j;
    if (localBitmap != null) {
      BitmapUtils.recycle(localBitmap);
    }
    this.n.b();
    this.p = null;
  }
  
  public void onPause()
  {
    super.onPause();
    this.o = true;
  }
  
  public void onResume()
  {
    super.onResume();
    this.o = false;
    if (this.p != null)
    {
      b(getBaseActivity(), this.p);
      this.p = null;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a(paramView);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowPhotoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */