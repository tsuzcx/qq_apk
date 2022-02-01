package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AccountDetailBannerIndicator
  extends LinearLayout
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private final String jdField_a_of_type_JavaLangString = "#FFFFFFFF";
  private ArrayList<ImageView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int = 0;
  private final String jdField_b_of_type_JavaLangString = "#33FFFFFF";
  
  public AccountDetailBannerIndicator(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  private void a()
  {
    int j = AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = AIOUtils.b(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      BubbleViewLayout localBubbleViewLayout = new BubbleViewLayout(this.jdField_a_of_type_AndroidContentContext);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(k, 0, 0, 0);
      }
      localBubbleViewLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localBubbleViewLayout.a(false);
      localBubbleViewLayout.setRadius(3.0F);
      addView(localBubbleViewLayout);
      localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j, j));
      if (i == 0) {
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
      } else {
        ((ImageView)localObject).setImageDrawable(new ColorDrawable(Color.parseColor("#33FFFFFF")));
      }
      localBubbleViewLayout.addView((View)localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    if (i > 1) {
      i = paramInt % i;
    } else {
      i = paramInt;
    }
    int j = i;
    if (paramInt < 0) {
      j = i + this.jdField_a_of_type_Int;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCurrentItem->pos:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", newPos:");
      localStringBuilder.append(j);
      QLog.d("AccountDetailBannerIndicator", 2, localStringBuilder.toString());
    }
    ((ImageView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).setImageDrawable(new ColorDrawable(Color.parseColor("#33FFFFFF")));
    this.jdField_b_of_type_Int = j;
    ((ImageView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).setImageDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailBannerIndicator
 * JD-Core Version:    0.7.0.1
 */