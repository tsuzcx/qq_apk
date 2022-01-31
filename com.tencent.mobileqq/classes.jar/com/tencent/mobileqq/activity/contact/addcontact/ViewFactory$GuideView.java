package com.tencent.mobileqq.activity.contact.addcontact;

import ahjf;
import ahjg;
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
  public static final int a;
  public ahjg a;
  private int b = -1;
  
  static
  {
    jdField_a_of_type_Int = 3;
  }
  
  public ViewFactory$GuideView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    paramContext = LayoutInflater.from(paramContext);
    int i = 0;
    while (i < jdField_a_of_type_Int)
    {
      addView(paramContext.inflate(2131558465, this, false));
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
      ((TextView)localView.findViewById(2131367409)).setText(paramString);
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
  
  private void a(ArrayList<ahjf> paramArrayList, String paramString)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      localView.setOnClickListener(this);
      localView.setTag(Integer.valueOf(((ahjf)paramArrayList.get(i)).b));
      localView.setTag(((ahjf)paramArrayList.get(i)).b, paramString);
      ((ImageView)localView.findViewById(2131367404)).setImageResource(((ahjf)paramArrayList.get(i)).b);
      ((TextView)localView.findViewById(2131367419)).setText(localView.getContext().getResources().getString(((ahjf)paramArrayList.get(i)).jdField_a_of_type_Int) + ":");
      ((TextView)localView.findViewById(2131367409)).setText(paramString);
      localView.setContentDescription(getResources().getString(((ahjf)paramArrayList.get(i)).jdField_a_of_type_Int) + ":" + paramString);
      i += 1;
    }
  }
  
  public ahjf a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 80000000: 
      return new ahjf(2131689718, 2130844326);
    case 80000001: 
      return new ahjf(2131689720, 2130844327);
    }
    return new ahjf(2131689719, 2130844328);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.b != paramInt)
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
      this.b = paramInt;
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
      if (this.jdField_a_of_type_Ahjg != null) {
        this.jdField_a_of_type_Ahjg.a(i, paramView);
      }
      return;
      i = 80000000;
      continue;
      i = 80000001;
      continue;
      i = 80000002;
    }
  }
  
  public void setListener(ahjg paramahjg)
  {
    this.jdField_a_of_type_Ahjg = paramahjg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ViewFactory.GuideView
 * JD-Core Version:    0.7.0.1
 */