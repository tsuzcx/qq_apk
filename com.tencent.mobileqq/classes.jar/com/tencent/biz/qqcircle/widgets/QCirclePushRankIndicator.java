package com.tencent.biz.qqcircle.widgets;

import agej;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QCirclePushRankIndicator
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private final String jdField_a_of_type_JavaLangString = "#7A7A8D";
  private ArrayList<ImageView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString = "#B8B9C7";
  
  public QCirclePushRankIndicator(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  private void a()
  {
    int j = agej.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int m = agej.a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      BubbleViewLayout localBubbleViewLayout = new BubbleViewLayout(this.jdField_a_of_type_AndroidContentContext);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(m, 0, 0, 0);
      }
      localBubbleViewLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localBubbleViewLayout.a(false);
      localBubbleViewLayout.setRadius(3.0F);
      addView(localBubbleViewLayout);
      localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      if (i == 0)
      {
        ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(k, j));
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#7A7A8D")));
      }
      for (;;)
      {
        localBubbleViewLayout.addView((View)localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        i += 1;
        break;
        ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j, j));
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#B8B9C7")));
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int > 1) {}
    for (int i = paramInt % this.jdField_a_of_type_Int;; i = paramInt)
    {
      if (paramInt < 0) {
        i += this.jdField_a_of_type_Int;
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AccountDetailBannerIndicator", 2, "updateCurrentItem->pos:" + paramInt + ", newPos:" + i);
        }
        paramInt = agej.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        int j = agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ImageView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).setImageDrawable(new ColorDrawable(Color.parseColor("#B8B9C7")));
        ((ImageView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).setLayoutParams(new RelativeLayout.LayoutParams(paramInt, paramInt));
        this.jdField_b_of_type_Int = i;
        ((ImageView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).setImageDrawable(new ColorDrawable(Color.parseColor("#7A7A8D")));
        ((ImageView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).setLayoutParams(new RelativeLayout.LayoutParams(j, paramInt));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankIndicator
 * JD-Core Version:    0.7.0.1
 */