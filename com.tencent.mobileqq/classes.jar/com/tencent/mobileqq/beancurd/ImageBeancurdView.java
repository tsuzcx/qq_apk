package com.tencent.mobileqq.beancurd;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.mobileqq.data.MessageForBeancurd;
import com.tencent.mobileqq.gamecenter.ui.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ImageBeancurdView
  extends TextBeancurdView
{
  private CornerImageView jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView;
  private String jdField_a_of_type_JavaLangString = "#80000000";
  private CornerImageView jdField_b_of_type_ComTencentMobileqqGamecenterUiCornerImageView;
  private String jdField_b_of_type_JavaLangString = "#00000000";
  
  public ImageBeancurdView(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
    a();
  }
  
  private void b(MessageForBeancurd paramMessageForBeancurd)
  {
    Object localObject = paramMessageForBeancurd.getBackground();
    if (!URLUtil.isHttpsUrl((String)localObject))
    {
      if (QLog.isColorLevel())
      {
        paramMessageForBeancurd = new StringBuilder();
        paramMessageForBeancurd.append("background is not web url : ");
        paramMessageForBeancurd.append((String)localObject);
        QLog.i("ImageBeancurdView", 2, paramMessageForBeancurd.toString());
      }
      return;
    }
    int i = Color.parseColor(this.jdField_a_of_type_JavaLangString);
    int j = Color.parseColor(this.jdField_b_of_type_JavaLangString);
    localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j });
    ((GradientDrawable)localObject).setCornerRadii(new float[] { this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, 0.0F, 0.0F, 0.0F, 0.0F });
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setVisibility(0);
    if (paramMessageForBeancurd.getContentList() != null)
    {
      if (paramMessageForBeancurd.getContentList().isEmpty()) {
        return;
      }
      paramMessageForBeancurd = new GradientDrawable();
      paramMessageForBeancurd.setColor(i);
      paramMessageForBeancurd.setCornerRadius(this.jdField_a_of_type_Int);
      this.jdField_b_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setBackgroundDrawable(paramMessageForBeancurd);
      this.jdField_b_of_type_ComTencentMobileqqGamecenterUiCornerImageView.setVisibility(0);
    }
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUiCornerImageView = ((CornerImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369416));
    this.jdField_b_of_type_ComTencentMobileqqGamecenterUiCornerImageView = ((CornerImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369417));
  }
  
  protected void a(MessageForBeancurd paramMessageForBeancurd)
  {
    super.a(paramMessageForBeancurd);
    b(paramMessageForBeancurd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.beancurd.ImageBeancurdView
 * JD-Core Version:    0.7.0.1
 */