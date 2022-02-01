package com.tencent.aelight.camera.aeeditor.view;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.PAG;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class AEEditorLoadingView
  extends FrameLayout
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e = WinkEditorResourceManager.c().x();
  private View f;
  private LinearLayout g;
  private VasPagView h;
  private VasPagView i;
  private ProgressBar j;
  private RelativeLayout k;
  private TextView l;
  private TextView m;
  private TextView n;
  private View o;
  private View p;
  private View q;
  private TextView r;
  private AEEditorLoadingView.LoadingListener s;
  private int t;
  private int u;
  private String v;
  private ObjectAnimator w;
  private CountDownTimer x;
  private boolean y = true;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.PAG.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("editor_loading_img_bmp.pag");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.PAG.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("editor_loading_text_filter_bmp.pag");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.PAG.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("editor_loading_text_dapian_bmp.pag");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.PAG.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("editor_loading_text_muban_bmp.pag");
    d = localStringBuilder.toString();
  }
  
  public AEEditorLoadingView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(float paramFloat)
  {
    paramFloat = paramFloat * 1000.0F / 1000.0F - 1.0F;
    return (paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F) * 1.0F + 0.0F;
  }
  
  private void a(@NonNull Context paramContext)
  {
    this.f = LayoutInflater.from(paramContext).inflate(2064056446, this);
    g();
    h();
  }
  
  private void a(PAGView paramPAGView, String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = PAGFile.Load(paramString.getAbsolutePath());
      if (paramString != null)
      {
        paramPAGView.setComposition(paramString);
        paramPAGView.setRepeatCount(0);
        paramPAGView.play();
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool;
    if (getResources().getString(2064187454).equals(this.v))
    {
      this.p.setVisibility(8);
      this.o.setVisibility(8);
      bool = true;
    }
    else
    {
      bool = false;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    if (paramBoolean)
    {
      localAnimatorSet.play(getLoadingFadeOutAnimator()).with(c(bool)).before(getContainerFadeOutAnimator());
      localAnimatorSet.addListener(new AEEditorLoadingView.5(this));
    }
    else
    {
      localAnimatorSet.play(getContainerFadeOutAnimator());
      localAnimatorSet.addListener(new AEEditorLoadingView.6(this));
    }
    if (this.w.isRunning()) {
      this.w.cancel();
    }
    ProgressBar localProgressBar = this.j;
    this.w = ObjectAnimator.ofInt(localProgressBar, "progress", new int[] { localProgressBar.getProgress(), 100 }).setDuration(100L);
    this.w.addListener(new AEEditorLoadingView.7(this, localAnimatorSet));
    this.w.start();
  }
  
  @NotNull
  private ValueAnimator c(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    localValueAnimator.setDuration(1000L);
    localValueAnimator.addUpdateListener(new AEEditorLoadingView.8(this, paramBoolean));
    return localValueAnimator;
  }
  
  private void g()
  {
    this.g = ((LinearLayout)findViewById(2063991230));
    this.j = ((ProgressBar)findViewById(2063991327));
    this.h = ((VasPagView)findViewById(2063991615));
    this.i = ((VasPagView)findViewById(2063991616));
    this.h.g().a();
    this.i.g().a();
    this.r = ((TextView)findViewById(2063991274));
    this.q = findViewById(2063991523);
    this.q.setOnClickListener(new AEEditorLoadingView.1(this));
  }
  
  @NotNull
  private ObjectAnimator getContainerFadeOutAnimator()
  {
    return ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F }).setDuration(500L);
  }
  
  @NotNull
  private ObjectAnimator getLoadingFadeOutAnimator()
  {
    return ObjectAnimator.ofFloat(this.g, "alpha", new float[] { 1.0F, 0.0F }).setDuration(500L);
  }
  
  private void h()
  {
    this.k = ((RelativeLayout)findViewById(2063991378));
    this.l = ((TextView)findViewById(2063991479));
    this.m = ((TextView)findViewById(2063991480));
    this.n = ((TextView)findViewById(2063991481));
    this.o = findViewById(2063991364);
    this.p = findViewById(2063991623);
    this.t = UIUtils.a(getContext(), 80.0F);
    this.u = UIUtils.a(getContext(), 7.0F);
  }
  
  private void i()
  {
    AEEditorLoadingView.LoadingListener localLoadingListener = this.s;
    if (localLoadingListener != null) {
      localLoadingListener.a();
    }
    a();
  }
  
  public void a()
  {
    if (getParent() == null) {
      return;
    }
    ((ViewGroup)getParent()).removeAllViews();
    CountDownTimer localCountDownTimer = this.x;
    if (localCountDownTimer != null) {
      localCountDownTimer.cancel();
    }
  }
  
  public void a(int paramInt)
  {
    this.f.setAlpha(0.0F);
    if (paramInt == 4)
    {
      this.j.setVisibility(8);
      this.q.setVisibility(8);
    }
    else
    {
      this.j.setVisibility(0);
      this.q.setVisibility(0);
    }
    this.w = ObjectAnimator.ofInt(this.j, "progress", new int[] { 0, 80 }).setDuration(3000L);
    this.w.start();
    ObjectAnimator.ofFloat(this.f, "alpha", new float[] { 0.0F, 1.0F }).setDuration(500L).start();
    this.h.g().a(new AEEditorLoadingView.2(this));
    this.i.g().a(new AEEditorLoadingView.3(this, paramInt));
    if (paramInt == 4) {
      this.r.setVisibility(0);
    } else {
      this.r.setVisibility(8);
    }
    this.x = new AEEditorLoadingView.4(this, 10000L, 1000L, paramInt);
    this.x.start();
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  public void setFromQCircle(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setLoadingListener(AEEditorLoadingView.LoadingListener paramLoadingListener)
  {
    this.s = paramLoadingListener;
  }
  
  public void setSceneText(String paramString1, String paramString2, String paramString3)
  {
    this.v = paramString1;
    TextView localTextView = this.l;
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = this.m;
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = this.n;
    if (paramString1 != null) {
      paramString1.setText(paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView
 * JD-Core Version:    0.7.0.1
 */