package com.tencent.av.utils;

import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class NotificationStyleDiscover
{
  Integer a = null;
  float b = 14.0F;
  Integer c = null;
  float d = 16.0F;
  DisplayMetrics e = new DisplayMetrics();
  Context f;
  
  public NotificationStyleDiscover(Context paramContext)
  {
    this.f = paramContext;
    ((WindowManager)this.f.getSystemService("window")).getDefaultDisplay().getMetrics(this.e);
    if ((this.a != null) && (this.c != null)) {
      return;
    }
    try
    {
      Object localObject = new Notification.Builder(this.f).setContentTitle("SearchForTitle").setContentText("SearchForText").build();
      paramContext = new LinearLayout(this.f);
      localObject = (ViewGroup)((Notification)localObject).contentView.apply(this.f, paramContext);
      a((ViewGroup)localObject);
      b((ViewGroup)localObject);
      paramContext.removeAllViews();
      return;
    }
    catch (Exception paramContext)
    {
      label151:
      break label151;
    }
    QLog.e("NotificationStyleDiscover", 2, "erro");
  }
  
  boolean a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForTitle".equals(localTextView.getText().toString()))
        {
          this.c = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.d = localTextView.getTextSize();
          this.d /= this.e.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (a((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean b(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForText".equals(localTextView.getText().toString()))
        {
          this.a = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.b = localTextView.getTextSize();
          this.b /= this.e.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (b((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.NotificationStyleDiscover
 * JD-Core Version:    0.7.0.1
 */