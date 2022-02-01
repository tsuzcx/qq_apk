package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qphone.base.util.QLog;
import ncp;

public class AddMemberItemView
  extends RelativeLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private AutoBgImageView jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
  
  public AddMemberItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AddMemberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddMemberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public RectF a()
  {
    int[] arrayOfInt = new int[2];
    ncp.a(this, arrayOfInt);
    RectF localRectF = new RectF();
    localRectF.left = arrayOfInt[0];
    localRectF.top = arrayOfInt[1];
    localRectF.right = (localRectF.left + getMeasuredWidth());
    localRectF.bottom = (localRectF.top + getMeasuredHeight());
    if (QLog.isColorLevel()) {
      QLog.i("AddMemberItemView", 2, "getViewRect rectF:" + localRectF);
    }
    return localRectF;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)findViewById(2131362132));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362202);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = ncp.s;
    localLayoutParams.height = ncp.s;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getContext().getResources().getColor(2131165342));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.AddMemberItemView
 * JD-Core Version:    0.7.0.1
 */