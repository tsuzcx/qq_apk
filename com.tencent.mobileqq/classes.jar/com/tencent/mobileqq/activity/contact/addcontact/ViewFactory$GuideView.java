package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ViewFactory$GuideView
  extends LinearLayout
  implements View.OnClickListener
{
  public static final int b = 2;
  public ViewFactory.GuideView.OnItemClickListener a;
  private int c = -1;
  
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
    while (i < b)
    {
      addView(paramContext.inflate(2131624055, this, false));
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      localView.setTag(((Integer)localView.getTag()).intValue(), paramString);
      ((TextView)localView.findViewById(2131434503)).setText(paramString);
      Object localObject = localView.getContentDescription();
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((CharSequence)localObject).toString();
      }
      int k = ((String)localObject).length();
      int m = ((String)localObject).indexOf(":");
      if ((m != -1) && (m != k - 1))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((String)localObject).substring(0, m + 1));
        localStringBuilder.append(paramString);
        localView.setContentDescription(localStringBuilder.toString());
      }
      i += 1;
    }
  }
  
  private void a(ArrayList<ViewFactory.GuideView.DataHolder> paramArrayList, String paramString)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      localView.setOnClickListener(this);
      localView.setTag(Integer.valueOf(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).b));
      localView.setTag(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).b, paramString);
      ((ImageView)localView.findViewById(2131434498)).setImageResource(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).b);
      Object localObject = (TextView)localView.findViewById(2131434514);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localView.getContext().getResources().getString(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).a));
      localStringBuilder.append(":");
      ((TextView)localObject).setText(localStringBuilder.toString());
      ((TextView)localView.findViewById(2131434503)).setText(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getResources().getString(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).a));
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramString);
      localView.setContentDescription(((StringBuilder)localObject).toString());
      i += 1;
    }
  }
  
  public ViewFactory.GuideView.DataHolder a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 80000002: 
      return new ViewFactory.GuideView.DataHolder(2131886282, 2130846147);
    case 80000001: 
      return new ViewFactory.GuideView.DataHolder(2131886283, 2130846146);
    }
    return new ViewFactory.GuideView.DataHolder(2131886281, 2130846145);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.c != paramInt)
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
      this.c = paramInt;
      a(localArrayList, paramString);
      return;
    }
    a(paramString);
  }
  
  public ViewFactory.GuideView.OnItemClickListener getListener()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    String str = (String)paramView.getTag(i);
    switch (i)
    {
    default: 
      break;
    case 2130846147: 
      i = 80000002;
      break;
    case 2130846146: 
      i = 80000001;
      break;
    case 2130846145: 
      i = 80000000;
    }
    ViewFactory.GuideView.OnItemClickListener localOnItemClickListener = this.a;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.a(i, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setListener(ViewFactory.GuideView.OnItemClickListener paramOnItemClickListener)
  {
    this.a = paramOnItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ViewFactory.GuideView
 * JD-Core Version:    0.7.0.1
 */