package com.tencent.gdtad.basics.motivevideo.title;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.gdtad.views.video.circle.DonutProgress;
import com.tencent.qphone.base.util.QLog;

public class GdtMvCircleTitleFactory
  implements IGdtMvTitleFactory
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = 100;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private DonutProgress jdField_a_of_type_ComTencentGdtadViewsVideoCircleDonutProgress;
  private final String jdField_a_of_type_JavaLangString = "GdtMvCircleTitleFactory";
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 0;
  private DonutProgress jdField_b_of_type_ComTencentGdtadViewsVideoCircleDonutProgress;
  private float c;
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentGdtadViewsVideoCircleDonutProgress == null)
    {
      QLog.i("GdtMvCircleTitleFactory", 1, "refreshTimeView view is null");
      return;
    }
    int j = (int)(this.c / this.jdField_a_of_type_Float * 100.0F);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshTimeView mVideoPlayedMs:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(";;;progress:");
      localStringBuilder.append(j);
      QLog.i("GdtMvCircleTitleFactory", 2, localStringBuilder.toString());
    }
    int i = j;
    if (j >= 100)
    {
      paramInt = 0;
      i = 100;
    }
    this.jdField_b_of_type_ComTencentGdtadViewsVideoCircleDonutProgress.setProgress(i);
    this.jdField_b_of_type_ComTencentGdtadViewsVideoCircleDonutProgress.setText(String.valueOf(paramInt));
    this.jdField_b_of_type_ComTencentGdtadViewsVideoCircleDonutProgress.setVisibility(0);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoCircleDonutProgress == null)
    {
      QLog.i("GdtMvCircleTitleFactory", 1, "refreshCloseView view is null");
      return;
    }
    int i = (int)(this.c / this.jdField_b_of_type_Float * 100.0F);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshCloseView mVideoPlayedMs:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(";;;progress:");
      localStringBuilder.append(i);
      QLog.i("GdtMvCircleTitleFactory", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentGdtadViewsVideoCircleDonutProgress.setProgress(Math.min(i, 100));
  }
  
  public void a()
  {
    this.jdField_b_of_type_ComTencentGdtadViewsVideoCircleDonutProgress.setVisibility(8);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoCircleDonutProgress.setProgress(100.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = ((float)paramLong1);
      this.jdField_b_of_type_Float = Math.min((float)paramLong2, this.jdField_a_of_type_Float);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == 0L) && (paramLong2 == 0L) && (paramLong3 == 0L))
    {
      a();
      return;
    }
    this.c = ((float)paramLong3);
    a((int)((this.jdField_a_of_type_Float - this.c) / 1000.0F));
    b();
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      QLog.i("GdtMvCircleTitleFactory", 1, "refreshVoiceIconDrawableInner return");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshVoiceIconDrawableInner ");
    localStringBuilder.append(paramBoolean);
    QLog.i("GdtMvCircleTitleFactory", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      paramContext = paramContext.getResources().getDrawable(2130840265);
      GdtMvTitleUtil.a(this.jdField_a_of_type_AndroidWidgetImageView, paramContext, 2131692869);
      return;
    }
    paramContext = paramContext.getResources().getDrawable(2130840266);
    GdtMvTitleUtil.a(this.jdField_a_of_type_AndroidWidgetImageView, paramContext, 2131692868);
  }
  
  public void a(ViewGroup paramViewGroup, GdtMvTitleHelper paramGdtMvTitleHelper)
  {
    paramViewGroup.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559191, paramViewGroup, false));
    this.jdField_b_of_type_ComTencentGdtadViewsVideoCircleDonutProgress = ((DonutProgress)paramViewGroup.findViewById(2131364645));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoCircleDonutProgress = ((DonutProgress)paramViewGroup.findViewById(2131364644));
    this.jdField_b_of_type_ComTencentGdtadViewsVideoCircleDonutProgress.setClockWise(true);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoCircleDonutProgress.setClockWise(true);
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentGdtadViewsVideoCircleDonutProgress;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364646));
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramGdtMvTitleHelper);
    paramGdtMvTitleHelper.jdField_a_of_type_AndroidViewView.setOnClickListener(paramGdtMvTitleHelper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.title.GdtMvCircleTitleFactory
 * JD-Core Version:    0.7.0.1
 */