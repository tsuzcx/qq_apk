package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import java.util.Random;
import ndl;
import nfc;
import nin;
import nkj;
import nkl;
import nkm;
import nkn;

public class SurvivalMemberItemView
  extends RelativeLayout
{
  private Animator.AnimatorListener a;
  public ImageView a;
  public RoundCorneredRelativeLayout a;
  public nkl a;
  private Animator.AnimatorListener b = new nkn(this);
  
  public SurvivalMemberItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SurvivalMemberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SurvivalMemberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new nkm(this);
  }
  
  private Bitmap a(long paramLong, ndl paramndl)
  {
    if (20 < new Random().nextInt(100) % 100 + 1) {
      return ndl.a();
    }
    return paramndl.a(String.valueOf(paramLong), (byte)1, true, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout = ((RoundCorneredRelativeLayout)findViewById(2131379209));
    float f = nin.v / 6;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.setRadius(f, f, f, f);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372643));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = nin.v;
    localLayoutParams.height = nin.w;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  public void a(ndl paramndl, nkl paramnkl, nkj paramnkj)
  {
    if ((paramnkl == null) || (paramnkl.a() < 0L) || (paramnkl.b() == -1) || (nfc.a().a() == null)) {
      if ((this.jdField_a_of_type_Nkl != null) && (this.jdField_a_of_type_Nkl.a() < 0L) && (this.jdField_a_of_type_Nkl.b() >= 0) && (this.jdField_a_of_type_Nkl.a() != 0))
      {
        paramnkj.b(this, this.b);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(getContext().getResources().getColor(2131165349));
        this.jdField_a_of_type_Nkl = paramnkl;
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
      break;
      this.jdField_a_of_type_Nkl = paramnkl;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramnkl.a(), paramndl));
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.5F);
    } while (paramnkl.a() != 0);
    paramnkj.a(this, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalMemberItemView
 * JD-Core Version:    0.7.0.1
 */