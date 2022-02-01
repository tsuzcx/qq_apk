package com.tencent.avgame.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class CasualTips
  extends RelativeLayout
  implements Runnable
{
  int a = 0;
  Context b;
  private ArrayList<String> c = new ArrayList();
  private Handler d = new Handler(Looper.getMainLooper());
  private final int e = 2000;
  
  public CasualTips(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public CasualTips(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public CasualTips(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.b = paramContext;
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    b();
    postDelayed(new CasualTips.1(this, paramArrayList), 50L);
  }
  
  private void d()
  {
    if (this.c != null)
    {
      removeAllViews();
      this.a += 1;
      this.a %= this.c.size();
      Object localObject1 = (String)this.c.get(this.a);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setNextTip empty");
        ((StringBuilder)localObject1).append(this.a);
        QLog.e("CasualTips", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      localObject1 = ((String)localObject1).split("\\n");
      if (localObject1.length > 0)
      {
        if (this.b == null)
        {
          QLog.e("CasualTips", 2, "setNextTip mContext is null");
          return;
        }
        int k = ViewUtils.dip2px(20.0F);
        int m = localObject1.length;
        int i = 0;
        int j = 0;
        while (i < m)
        {
          Object localObject2 = localObject1[i];
          TextView localTextView = new TextView(this.b);
          localTextView.setText((CharSequence)localObject2);
          localTextView.setTextSize(14.0F);
          localTextView.setSingleLine(true);
          localTextView.setGravity(17);
          localTextView.setTextColor(Color.parseColor("#B0B3BF"));
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).setMargins(0, j * k, 0, 0);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          addView(localTextView);
          j += 1;
          i += 1;
        }
      }
      QLog.e("CasualTips", 2, "setNextTip lines empty");
    }
  }
  
  public void a()
  {
    this.d.removeCallbacksAndMessages(null);
    this.b = null;
  }
  
  public void b()
  {
    QLog.d("CasualTips", 2, "stopAnimation");
    this.d.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.d.removeCallbacksAndMessages(null);
    this.d.postDelayed(this, 2000L);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.d.removeCallbacksAndMessages(null);
  }
  
  public void run()
  {
    d();
    this.d.postDelayed(this, 2000L);
  }
  
  public void setTipsString(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      a(paramArrayList);
      return;
    }
    QLog.e("CasualTips", 2, "setTipsString empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.CasualTips
 * JD-Core Version:    0.7.0.1
 */