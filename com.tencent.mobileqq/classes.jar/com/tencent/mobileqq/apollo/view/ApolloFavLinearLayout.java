package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class ApolloFavLinearLayout
  extends ApolloLinearLayout
{
  public ApolloFavLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(1);
    this.d = paramInt;
    int j = this.b;
    int k = this.c;
    float f = paramContext.getResources().getDisplayMetrics().density;
    int m = (int)((int)((int)((int)(XPanelContainer.a - (XPanelContainer.d * 0.25D + 21.0F * f)) - (12.0F * f + 10.0F * f + 10.0F * f)) - 20.0F * f) - 40.0F * f) / 2;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLinearLayout", 2, "panel height = " + XPanelContainer.a + "imgHeight = " + m + "addHeight=" + XPanelContainer.d);
    }
    paramInt = 0;
    while (paramInt < k)
    {
      paramAttributeSet = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, m);
      localLayoutParams.leftMargin = ((int)(15.0F * f));
      localLayoutParams.rightMargin = ((int)(15.0F * f));
      paramAttributeSet.setOrientation(0);
      if (paramInt == 0) {
        if (XPanelContainer.d > 0) {
          localLayoutParams.topMargin = ((int)(21.0F * f));
        }
      }
      for (;;)
      {
        int i = 0;
        while (i < j)
        {
          Object localObject = new LinearLayout.LayoutParams(-1, -1);
          ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
          View localView = LayoutInflater.from(paramContext).inflate(2130968693, null);
          paramAttributeSet.addView(localView, (ViewGroup.LayoutParams)localObject);
          localObject = new ApolloLinearLayout.ViewHolder();
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363237));
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363239));
          ((ApolloLinearLayout.ViewHolder)localObject).e = ((ImageView)localView.findViewById(2131363236));
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131363238));
          RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          localLayoutParams1.height = m;
          localLayoutParams1.width = m;
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363246));
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131363240));
          ((ApolloLinearLayout.ViewHolder)localObject).b = ((ImageView)localView.findViewById(2131363243));
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363247));
          ((ApolloLinearLayout.ViewHolder)localObject).d = ((ImageView)localView.findViewById(2131363241));
          localView.setTag(localObject);
          i += 1;
        }
        localLayoutParams.topMargin = ((int)(21.0F * f));
        continue;
        localLayoutParams.topMargin = ((int)(20.0F * f));
      }
      super.addView(paramAttributeSet, localLayoutParams);
      paramInt += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloFavLinearLayout
 * JD-Core Version:    0.7.0.1
 */