package com.tencent.aelight.camera.aioeditor.docenhance;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.gyailib.library.GYAIDocEnhance;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForMultiProcess;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.widget.ScaleGestureDetector;
import java.util.Arrays;
import mqq.os.MqqHandler;

public class DocEnhanceFragment
  extends AEFullScreenPublicFragment
  implements View.OnClickListener
{
  private static final int H = ViewConfiguration.get(BaseApplicationImpl.getContext()).getScaledTouchSlop();
  private static final int I = ViewConfiguration.getLongPressTimeout();
  private Bitmap A;
  private float[] B = { 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private int C = 2;
  private GYAIDocEnhance D = new GYAIDocEnhance();
  private Bitmap E;
  private float F;
  private float G;
  private Runnable J;
  private Handler K = new Handler();
  private ImageView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private RelativeLayout g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private BubbleTextView n;
  private Rect o = new Rect();
  private Matrix p = new Matrix();
  private float q;
  private float r;
  private final float[] s = new float[9];
  private final RectF t = new RectF();
  private final RectF u = new RectF();
  private int v;
  private int w;
  private boolean x;
  private Bitmap y;
  private String z;
  
  private void a()
  {
    ScaleGestureDetector localScaleGestureDetector = new ScaleGestureDetector(getContext(), new DocEnhanceFragment.7(this));
    this.a.setOnTouchListener(new DocEnhanceFragment.8(this, localScaleGestureDetector));
  }
  
  private void a(int paramInt)
  {
    if (this.C == paramInt) {
      return;
    }
    this.C = paramInt;
    c();
    r();
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, float[] paramArrayOfFloat, int paramInt2)
  {
    if (!FeatureManager.Features.LIGHT_SDK.init())
    {
      AEQLog.d("DocEnhanceFragment", "jumpToMeForResult---light sdk not ready");
      ThreadManager.getUIHandler().post(new DocEnhanceFragment.1());
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_RAW_PIC_PATH", paramString1);
    localIntent.putExtra("ARG_ENHANCED_PIC_PATH", paramString2);
    localIntent.putExtra("ARG_ENHANCED_POINTS_ARRAY", paramArrayOfFloat);
    localIntent.putExtra("ARG_ENHANCED_COLOR_CONFIG", paramInt2);
    QPublicFragmentActivityForMultiProcess.a(paramActivity, localIntent, DocEnhanceFragment.class, paramInt1);
  }
  
  private void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.v = paramBitmap.getWidth();
      this.w = paramBitmap.getHeight();
      int i1 = this.a.getWidth();
      int i2 = this.a.getHeight();
      float f1 = i1;
      float f2 = f1 * 1.0F / this.v;
      float f4 = i2;
      float f5 = 1.0F * f4 / this.w;
      float f3 = Math.min(f2, f5);
      if (f2 < f5)
      {
        f1 = (f4 - this.w * f3) / 2.0F;
        f2 = 0.0F;
      }
      else
      {
        f2 = (f1 - this.v * f3) / 2.0F;
        f1 = 0.0F;
      }
      this.p.reset();
      this.p.postScale(f3, f3);
      this.p.postTranslate(f2, f1);
      this.a.setImageMatrix(this.p);
      this.q = f3;
      this.r = Math.max(3.0F, f3);
      this.t.set(0.0F, 0.0F, this.v, this.w);
      this.p.mapRect(this.t);
    }
  }
  
  private void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.a.getWidth() > 0) && (this.a.getHeight() > 0)) {
        a(paramBitmap);
      } else {
        this.a.addOnLayoutChangeListener(new DocEnhanceFragment.6(this, paramBitmap));
      }
    }
    this.a.setImageBitmap(paramBitmap);
  }
  
  private void a(FragmentActivity paramFragmentActivity)
  {
    ThreadManager.excute(new DocEnhanceFragment.9(this, paramFragmentActivity), 64, null, false);
  }
  
  private void a(boolean paramBoolean)
  {
    Bitmap localBitmap1 = o();
    if (localBitmap1 != null)
    {
      this.x = true;
      this.b.setEnabled(true);
      Bitmap localBitmap2 = this.A;
      if ((localBitmap2 != null) && (localBitmap2 != localBitmap1) && (localBitmap2 != this.y) && (localBitmap2 != this.E)) {
        localBitmap2.recycle();
      }
      this.A = localBitmap1;
      a(this.A, paramBoolean);
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() <= I) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    float f1 = paramMotionEvent.getRawX() - this.F;
    float f2 = paramMotionEvent.getRawY() - this.G;
    boolean bool2;
    if (Math.sqrt(f1 * f1 + f2 * f2) <= H) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("considerAClick inTapTime=");
    paramMotionEvent.append(bool1);
    paramMotionEvent.append(", inTapDis=");
    paramMotionEvent.append(bool2);
    AEQLog.a("DocEnhanceFragment", paramMotionEvent.toString());
    return (bool1) && (bool2);
  }
  
  private void b()
  {
    RectF localRectF = this.u;
    float f1 = this.v;
    float f2 = this.w;
    float f3 = 0.0F;
    localRectF.set(0.0F, 0.0F, f1, f2);
    this.p.mapRect(this.u);
    if (this.u.left > this.t.left) {
      f1 = this.t.left;
    }
    for (f2 = this.u.left;; f2 = this.u.right)
    {
      f1 -= f2;
      break label121;
      if (this.u.right >= this.t.right) {
        break;
      }
      f1 = this.t.right;
    }
    f1 = 0.0F;
    label121:
    if (this.u.top > this.t.top) {
      f2 = this.t.top;
    }
    for (f3 = this.u.top;; f3 = this.u.bottom)
    {
      f2 -= f3;
      break;
      f2 = f3;
      if (this.u.bottom >= this.t.bottom) {
        break;
      }
      f2 = this.t.bottom;
    }
    this.p.postTranslate(f1, f2);
  }
  
  private void c()
  {
    this.h.setSelected(false);
    this.i.setSelected(false);
    this.j.setSelected(false);
    int i1 = this.C;
    if (i1 == 1) {
      this.h.setSelected(true);
    } else if (i1 == 2) {
      this.i.setSelected(true);
    } else if (i1 == 3) {
      this.j.setSelected(true);
    }
    if (this.C == 2)
    {
      this.d.setTextColor(-16725252);
      this.d.setCompoundDrawablesWithIntrinsicBounds(2063925412, 0, 0, 0);
      return;
    }
    this.d.setTextColor(-1);
    this.d.setCompoundDrawablesWithIntrinsicBounds(2063925411, 0, 0, 0);
  }
  
  private void d()
  {
    if (this.C == 2)
    {
      a(1);
      return;
    }
    a(2);
  }
  
  private void e()
  {
    this.g.setVisibility(8);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    this.g.startAnimation(localTranslateAnimation);
  }
  
  private void f()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (this.x)
      {
        a(localFragmentActivity);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("RESULT_KEY_IS_ENHANCED", this.x);
      localFragmentActivity.setResult(-1, localIntent);
      localFragmentActivity.finish();
    }
  }
  
  private void g()
  {
    i();
  }
  
  private void h()
  {
    this.x = false;
    this.b.setEnabled(false);
    a(this.y, true);
    this.B = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
    q();
    this.C = 1;
    c();
  }
  
  private void i()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(getContext(), 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(HardCodeUtil.a(2064187493));
    localQQCustomDialog.setMessage(HardCodeUtil.a(2064187492));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2064187459), new DocEnhanceFragment.10(this));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2064187461), new DocEnhanceFragment.11(this));
    localQQCustomDialog.setCanceledOnTouchOutside(true);
    localQQCustomDialog.show();
  }
  
  private void j()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = this.D.documentDetect(this.y);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doEnhancementOnFirstEnter---detect points=");
    ((StringBuilder)localObject2).append(Arrays.toString((float[])localObject1));
    AEQLog.b("DocEnhanceFragment", ((StringBuilder)localObject2).toString());
    if ((localObject1 != null) && (localObject1.length == 8))
    {
      int i1 = 0;
      while (i1 < 4)
      {
        localObject2 = this.B;
        int i2 = i1 * 2;
        localObject1[i2] /= this.y.getWidth();
        localObject2 = this.B;
        i2 += 1;
        localObject1[i2] /= this.y.getHeight();
        i1 += 1;
      }
      k();
    }
    else
    {
      l();
    }
    q();
    a(true);
    if ((localObject1 != null) && (localObject1.length == 8))
    {
      long l2 = System.currentTimeMillis();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doEnhancementOnFirstEnter---cost=");
      ((StringBuilder)localObject1).append(l2 - l1);
      AEQLog.b("DocEnhanceFragment", ((StringBuilder)localObject1).toString());
    }
  }
  
  private void k()
  {
    boolean bool = AECameraPrefsUtil.a().b("sp_key_doc_enhance_has_shown_adjust_guide_bubble", false, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkShowGuideBubble---hasShown=");
    localStringBuilder.append(bool);
    AEQLog.b("DocEnhanceFragment", localStringBuilder.toString());
    if (bool) {
      return;
    }
    AECameraPrefsUtil.a().a("sp_key_doc_enhance_has_shown_adjust_guide_bubble", true, 0);
    m();
    this.n.setText(2064187490);
    this.n.setVisibility(0);
  }
  
  private void l()
  {
    int i1 = AECameraPrefsUtil.a().b("sp_key_doc_enhance_fail_detect_bubble_times", 0, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkShowNeedAdjustBubble---showTimes=");
    localStringBuilder.append(i1);
    AEQLog.b("DocEnhanceFragment", localStringBuilder.toString());
    if (i1 >= 2) {
      return;
    }
    AECameraPrefsUtil.a().a("sp_key_doc_enhance_fail_detect_bubble_times", i1 + 1, 0);
    m();
    this.n.setText(2064187491);
    this.n.setVisibility(0);
    n();
  }
  
  private void m()
  {
    this.K.removeCallbacks(this.J);
  }
  
  private void n()
  {
    this.K.postDelayed(this.J, 3000L);
  }
  
  @Nullable
  private Bitmap o()
  {
    int i1 = this.C;
    if (i1 == 1) {
      return this.E;
    }
    if (i1 == 2) {
      return this.D.documentDeshadow(this.E);
    }
    if (i1 == 3) {
      return this.D.documentEnhance(this.E);
    }
    return null;
  }
  
  private void p()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doEnhancementOnAdjustPointsChanged---mAdjustPoints=");
    ((StringBuilder)localObject).append(Arrays.toString(this.B));
    AEQLog.b("DocEnhanceFragment", ((StringBuilder)localObject).toString());
    localObject = this.B;
    if ((localObject != null) && (localObject.length == 8))
    {
      q();
      a(true);
    }
  }
  
  private void q()
  {
    float[] arrayOfFloat = this.B;
    if (arrayOfFloat != null)
    {
      if (arrayOfFloat.length != 8) {
        return;
      }
      arrayOfFloat = new float[8];
      int i1 = 0;
      while (i1 < 4)
      {
        int i2 = i1 * 2;
        arrayOfFloat[i2] = (this.B[i2] * this.y.getWidth());
        i2 += 1;
        arrayOfFloat[i2] = (this.B[i2] * this.y.getHeight());
        i1 += 1;
      }
      Bitmap localBitmap = this.E;
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      this.E = this.D.documentWarp(this.y, arrayOfFloat);
    }
  }
  
  private void r()
  {
    if (this.E == null) {
      return;
    }
    a(false);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 0)
    {
      if (i1 == 1)
      {
        if ((this.n.getVisibility() == 0) && (a(paramMotionEvent)))
        {
          m();
          this.n.setVisibility(8);
          return false;
        }
        if ((this.g.getVisibility() == 0) && (a(paramMotionEvent)))
        {
          this.g.getGlobalVisibleRect(this.o);
          i1 = (int)paramMotionEvent.getRawX();
          int i2 = (int)paramMotionEvent.getRawY();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("considerAClick mConfigPanelRect=");
          localStringBuilder.append(this.o);
          localStringBuilder.append(", ev=");
          localStringBuilder.append(i1);
          localStringBuilder.append(",");
          localStringBuilder.append(i2);
          AEQLog.a("DocEnhanceFragment", localStringBuilder.toString());
          if (i2 < this.o.top)
          {
            e();
            return true;
          }
        }
      }
    }
    else
    {
      this.F = paramMotionEvent.getRawX();
      this.G = paramMotionEvent.getRawY();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772014, 2130772007);
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if ((paramInt1 == 3721) && (paramInt2 == -1) && (paramIntent != null))
    {
      this.B = paramIntent.getFloatArrayExtra("RESULT_ADJUST_POINTS_ARRAY");
      p();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.g.getVisibility() == 0)
    {
      e();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2063991562: 
      g();
      AEBaseDataReporter.a().t("还原");
      return;
    case 2063991537: 
      f();
      AEBaseDataReporter.a().t("完成");
      return;
    case 2063991534: 
      d();
      AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
      if (this.C != 1) {
        paramView = "效果开";
      } else {
        paramView = "效果关";
      }
      localAEBaseDataReporter.t(paramView);
      return;
    case 2063991523: 
      onBackEvent();
      AEBaseDataReporter.a().t("取消");
      return;
    }
    DocEnhanceAdjustFragment.a(getActivity(), 3721, this.z, this.B);
    AEBaseDataReporter.a().t("校准");
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      String str = paramBundle.getString("ARG_RAW_PIC_PATH");
      if (!TextUtils.isEmpty(str))
      {
        this.z = str;
        this.y = BitmapFactory.decodeFile(str);
      }
      str = paramBundle.getString("ARG_ENHANCED_PIC_PATH");
      float[] arrayOfFloat = paramBundle.getFloatArray("ARG_ENHANCED_POINTS_ARRAY");
      if ((!TextUtils.isEmpty(str)) && (arrayOfFloat != null) && (arrayOfFloat.length == 8))
      {
        this.B = arrayOfFloat;
        this.A = BitmapFactory.decodeFile(str);
        this.C = paramBundle.getInt("ARG_ENHANCED_COLOR_CONFIG", 2);
        this.x = true;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate--mIsEnhanced=");
      paramBundle.append(this.x);
      paramBundle.append(", mRawPicPath=");
      paramBundle.append(this.z);
      paramBundle.append(", mEnhancedPicPath=");
      paramBundle.append(str);
      paramBundle.append(", mEnhancePoints=");
      paramBundle.append(Arrays.toString(this.B));
      AEQLog.b("DocEnhanceFragment", paramBundle.toString());
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064056435, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Bitmap localBitmap = this.y;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.y = null;
    }
    localBitmap = this.A;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.A = null;
    }
    localBitmap = this.E;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.E = null;
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    this.a = ((ImageView)paramView.findViewById(2063991182));
    this.b = ((TextView)paramView.findViewById(2063991562));
    this.c = ((TextView)paramView.findViewById(2063991519));
    this.d = ((TextView)paramView.findViewById(2063991534));
    this.e = ((TextView)paramView.findViewById(2063991523));
    this.f = ((TextView)paramView.findViewById(2063991537));
    this.n = ((BubbleTextView)paramView.findViewById(2063990935));
    paramBundle = getContext();
    this.n.setPadding(UIUtils.a(paramBundle, 10.0F), UIUtils.a(paramBundle, 11.0F), UIUtils.a(paramBundle, 10.0F), UIUtils.a(paramBundle, 11.0F));
    this.n.setIncludeFontPadding(false);
    this.n.setTextSize(1, 14.0F);
    this.n.setTextColor(Color.parseColor("#03081A"));
    BubbleTextView localBubbleTextView = this.n;
    localBubbleTextView.e = -1;
    localBubbleTextView.b = UIUtils.a(paramBundle, 6.0F);
    this.n.a();
    this.J = new DocEnhanceFragment.2(this);
    this.g = ((RelativeLayout)paramView.findViewById(2063991386));
    paramView = this.g.findViewById(2063991227);
    this.h = ((ImageView)paramView.findViewById(2063991193));
    this.k = ((TextView)paramView.findViewById(2063991526));
    paramView.setOnClickListener(new DocEnhanceFragment.3(this));
    paramView = this.g.findViewById(2063991226);
    this.i = ((ImageView)paramView.findViewById(2063991193));
    this.l = ((TextView)paramView.findViewById(2063991526));
    paramView.setOnClickListener(new DocEnhanceFragment.4(this));
    paramView = this.g.findViewById(2063991225);
    this.j = ((ImageView)paramView.findViewById(2063991193));
    this.m = ((TextView)paramView.findViewById(2063991526));
    paramView.setOnClickListener(new DocEnhanceFragment.5(this));
    this.k.setText(2064187485);
    this.l.setText(2064187484);
    this.m.setText(2064187483);
    this.h.setImageResource(2063925410);
    this.i.setImageResource(2063925406);
    this.j.setImageResource(2063925405);
    c();
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.b.setEnabled(this.x);
    this.a.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.x)
    {
      a(this.A, true);
      q();
    }
    else
    {
      a(this.y, true);
      j();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhanceFragment
 * JD-Core Version:    0.7.0.1
 */