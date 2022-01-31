package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class ViewFactory$GuideView
  extends LinearLayout
  implements View.OnClickListener
{
  private int a;
  public ViewFactory.GuideView.OnItemClickListener a;
  
  public ViewFactory$GuideView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    paramContext = LayoutInflater.from(paramContext);
    int i = 0;
    while (i < 3)
    {
      addView(paramContext.inflate(2130968616, this, false));
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      localView.setTag(((Integer)localView.getTag()).intValue(), paramString);
      ((TextView)localView.findViewById(2131362881)).setText(paramString);
      String str = localView.getContentDescription().toString();
      int k = str.length();
      int m = str.indexOf(":");
      if ((m == -1) || (m == k - 1)) {}
      for (;;)
      {
        i += 1;
        break;
        localView.setContentDescription(str.substring(0, m + 1) + paramString);
      }
    }
  }
  
  private void a(ArrayList paramArrayList, String paramString)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      localView.setOnClickListener(this);
      localView.setTag(Integer.valueOf(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).b));
      localView.setTag(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).b, paramString);
      ((ImageView)localView.findViewById(2131362879)).setImageResource(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).b);
      ((TextView)localView.findViewById(2131362880)).setText(localView.getContext().getResources().getString(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).jdField_a_of_type_Int) + ":");
      ((TextView)localView.findViewById(2131362881)).setText(paramString);
      localView.setContentDescription(getResources().getString(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).jdField_a_of_type_Int) + ":" + paramString);
      i += 1;
    }
  }
  
  public ViewFactory.GuideView.DataHolder a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 80000000: 
      return new ViewFactory.GuideView.DataHolder(2131434377, 2130842179);
    case 80000001: 
      return new ViewFactory.GuideView.DataHolder(2131434378, 2130842180);
    }
    return new ViewFactory.GuideView.DataHolder(2131434379, 2130842181);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      ArrayList localArrayList = new ArrayList(3);
      int[] arrayOfInt = ViewFactory.a(paramInt);
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(arrayOfInt[i]));
        i += 1;
      }
      this.jdField_a_of_type_Int = paramInt;
      a(localArrayList, paramString);
      return;
    }
    a(paramString);
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = (String)paramView.getTag(i);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView$OnItemClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView$OnItemClickListener.a(i, paramView);
      }
      return;
      i = 80000000;
      continue;
      i = 80000001;
      continue;
      i = 80000002;
    }
  }
  
  public void setListener(ViewFactory.GuideView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView$OnItemClickListener = paramOnItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ViewFactory.GuideView
 * JD-Core Version:    0.7.0.1
 */