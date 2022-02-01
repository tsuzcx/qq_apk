package com.tencent.avgame.gameroom.pkstage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.gameroom.CoverRoundCornerRelativeLayout;
import com.tencent.avgame.ui.AVGameSplitNumberView;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import nfc;
import nfv;
import nio;
import njr;
import njs;
import njt;
import nqf;

public class SurvivalPkStageView
  extends CoverRoundCornerRelativeLayout
  implements njt
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AVGameSplitNumberView jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView;
  private njs jdField_a_of_type_Njs;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public SurvivalPkStageView(Context paramContext)
  {
    this(paramContext, null);
    h();
  }
  
  public SurvivalPkStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    h();
  }
  
  public SurvivalPkStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h();
  }
  
  private List<Bitmap> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 10)
    {
      localArrayList.add(nqf.a(String.format("avgame_pk_match_num%d@2x.png", new Object[] { Integer.valueOf(i) })));
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(View paramView)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.5F, 1.0F, 1.15F, 0.94F, 1.02F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.5F, 1.0F, 1.15F, 0.94F, 1.02F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(1500L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramView });
    localAnimatorSet.start();
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mUseApngImage = true;
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView != null) {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.a(paramInt);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Njs = new njr(this);
    setRadius(getContext().getResources().getColor(2131165345), ViewUtils.dpToPx(16.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558770, null));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380187));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView = ((AVGameSplitNumberView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369562));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380186));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setDimension(ViewUtils.dpToPx(77.0F), ViewUtils.dpToPx(125.0F));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setNumDrawable(a());
    b(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558771, null));
    this.c = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380190));
    this.d = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380189));
    this.e = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380188));
    this.c.setTypeface(AVGameText.a());
    this.d.setTypeface(AVGameText.a());
    this.e.setTypeface(AVGameText.a());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_suc2.png"));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail.png"));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null) {
      removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, -1, -1);
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)
    {
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
        removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13, -1);
      addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null) {
      removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
        removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
        removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, -1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    setBackgroundDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/avgames/survival/avgame_room_survival_bg.png"));
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
        removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public njs a()
  {
    return this.jdField_a_of_type_Njs;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_suc2.png");
    l();
    i();
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    this.c.setText(getResources().getString(2131690454));
    this.d.setText(getResources().getString(2131690453));
    this.e.setText(getResources().getString(2131690452));
    this.e.setTextSize(1, 21.0F);
    setBackgroundDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_win_bg.png"));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131690458));
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  public void a(nfv paramnfv)
  {
    if (paramnfv.n() == 3)
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
  }
  
  public void a(nio paramnio)
  {
    this.jdField_a_of_type_Njs.a(paramnio);
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail.png");
    l();
    i();
    this.c.setVisibility(0);
    this.d.setVisibility(8);
    this.c.setText(getResources().getString(2131690449));
    this.e.setText(getResources().getString(2131690448));
    this.e.setTextSize(1, 28.0F);
    setBackgroundDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail_bg.png"));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131690458));
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void c()
  {
    j();
    k();
    g();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131690450));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void d()
  {
    j();
    k();
    String str = getContext().getResources().getString(2131690459);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
  
  public void e()
  {
    l();
    i();
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.d.setText(getResources().getString(2131690447));
    this.e.setText(getResources().getString(2131690446));
    this.e.setTextSize(1, 21.0F);
  }
  
  public void f()
  {
    l();
    i();
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.e.setVisibility(0);
    this.d.setText(getResources().getString(2131690456));
    this.e.setText(getResources().getString(2131690455));
    setBackgroundDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/avgames/survival/avgame_room_survival_bg.png"));
  }
  
  public void g()
  {
    int i = nfc.a().a().p();
    String str = getContext().getResources().getString(2131690451);
    if (i > 0) {}
    for (str = String.format(str, new Object[] { Integer.valueOf(i) });; str = str.split("\n")[0])
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.pkstage.SurvivalPkStageView
 * JD-Core Version:    0.7.0.1
 */