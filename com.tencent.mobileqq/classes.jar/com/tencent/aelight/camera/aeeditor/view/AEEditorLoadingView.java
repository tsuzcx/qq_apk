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
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class AEEditorLoadingView
  extends FrameLayout
{
  private static final String jdField_a_of_type_JavaLangString;
  private static final String jdField_b_of_type_JavaLangString;
  private static final String jdField_c_of_type_JavaLangString;
  private static final String d;
  private int jdField_a_of_type_Int;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEEditorLoadingView.LoadingListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView$LoadingListener;
  private VasPagView jdField_a_of_type_ComTencentMobileqqVasUiVasPagView;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VasPagView jdField_b_of_type_ComTencentMobileqqVasUiVasPagView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String e;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.PAG.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("editor_loading_img_bmp.pag");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.PAG.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("editor_loading_text_filter_bmp.pag");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.PAG.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("editor_loading_text_dapian_bmp.pag");
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.PAG.jdField_b_of_type_JavaLangString);
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
  
  @NotNull
  private ObjectAnimator a()
  {
    return ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "alpha", new float[] { 1.0F, 0.0F }).setDuration(500L);
  }
  
  @NotNull
  private ValueAnimator a(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    localValueAnimator.setDuration(1000L);
    localValueAnimator.addUpdateListener(new AEEditorLoadingView.8(this, paramBoolean));
    return localValueAnimator;
  }
  
  private void a(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2064318574, this);
    b();
    c();
  }
  
  private void a(PAGView paramPAGView, String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = PAGFile.Load(paramString.getAbsolutePath());
      if (paramString != null)
      {
        paramPAGView.setFile(paramString);
        paramPAGView.setRepeatCount(0);
        paramPAGView.play();
      }
    }
  }
  
  @NotNull
  private ObjectAnimator b()
  {
    return ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F }).setDuration(500L);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2064122357));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2064122511));
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView = ((VasPagView)findViewById(2064122842));
    this.jdField_b_of_type_ComTencentMobileqqVasUiVasPagView = ((VasPagView)findViewById(2064122843));
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.a().a();
    this.jdField_b_of_type_ComTencentMobileqqVasUiVasPagView.a().a();
    findViewById(2064122749).setOnClickListener(new AEEditorLoadingView.1(this));
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool;
    if (getResources().getString(2064515112).equals(this.e))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      bool = true;
    }
    else
    {
      bool = false;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    if (paramBoolean)
    {
      localAnimatorSet.play(a()).with(a(bool)).before(b());
      localAnimatorSet.addListener(new AEEditorLoadingView.5(this));
    }
    else
    {
      localAnimatorSet.play(b());
      localAnimatorSet.addListener(new AEEditorLoadingView.6(this));
    }
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
    ProgressBar localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(localProgressBar, "progress", new int[] { localProgressBar.getProgress(), 100 }).setDuration(100L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new AEEditorLoadingView.7(this, localAnimatorSet));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2064122561));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2064122684));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2064122685));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2064122686));
    this.jdField_b_of_type_AndroidViewView = findViewById(2064122546);
    this.jdField_c_of_type_AndroidViewView = findViewById(2064122850);
    this.jdField_a_of_type_Int = UIUtils.a(getContext(), 80.0F);
    this.jdField_b_of_type_Int = UIUtils.a(getContext(), 7.0F);
  }
  
  private void d()
  {
    AEEditorLoadingView.LoadingListener localLoadingListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView$LoadingListener;
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
    CountDownTimer localCountDownTimer = this.jdField_a_of_type_AndroidOsCountDownTimer;
    if (localCountDownTimer != null) {
      localCountDownTimer.cancel();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetProgressBar, "progress", new int[] { 0, 80 }).setDuration(3000L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(500L).start();
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.a().a(new AEEditorLoadingView.2(this));
    this.jdField_b_of_type_ComTencentMobileqqVasUiVasPagView.a().a(new AEEditorLoadingView.3(this, paramInt));
    this.jdField_a_of_type_AndroidOsCountDownTimer = new AEEditorLoadingView.4(this, 10000L, 1000L);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  public void setLoadingListener(AEEditorLoadingView.LoadingListener paramLoadingListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView$LoadingListener = paramLoadingListener;
  }
  
  public void setSceneText(String paramString1, String paramString2, String paramString3)
  {
    this.e = paramString1;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = this.jdField_c_of_type_AndroidWidgetTextView;
    if (paramString1 != null) {
      paramString1.setText(paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView
 * JD-Core Version:    0.7.0.1
 */