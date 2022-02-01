package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class SmallScreenAudio
  extends SmallScreenItemBase
{
  protected int a;
  protected View a;
  protected ImageView a;
  protected TextView a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  
  public SmallScreenAudio(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangString = "SmallScreenAudio";
    paramContext = paramContext.getResources();
    this.i = 2013396993;
    this.j = paramContext.getDimensionPixelSize(2131297961);
    this.k = paramContext.getDimensionPixelSize(2131297955);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(2131297962);
    this.b = paramContext.getDimensionPixelSize(2131297956);
    this.c = paramContext.getDimensionPixelSize(2131297957);
    this.d = paramContext.getDimensionPixelSize(2131297959);
    this.e = paramContext.getDimensionPixelSize(2131297958);
    this.f = paramContext.getDimensionPixelSize(2131297960);
    this.g = paramContext.getDimensionPixelSize(2131297953);
    this.h = paramContext.getDimensionPixelSize(2131297954);
  }
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, SmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    super.a(paramContext, paramLayoutInflater, paramFloatListener);
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setTitleHeight(paramContext.getDimensionPixelSize(2131299168) * 5 / 2);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2013331469));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2013331464));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842341);
    paramContext = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((paramContext instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramContext).start();
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2013331462);
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramBaseSmallScreenService.f)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, this.k);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842335);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localLayoutParams1.leftMargin = this.c;
      localLayoutParams1.topMargin = this.d;
      localLayoutParams2.bottomMargin = this.g;
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, this.b);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842337);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localLayoutParams1.leftMargin = this.e;
      localLayoutParams1.topMargin = this.f;
      localLayoutParams2.bottomMargin = this.h;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams2);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenAudio
 * JD-Core Version:    0.7.0.1
 */