package com.tencent.avgame.ui;

import agej;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class CasualTips
  extends RelativeLayout
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final int b = 2000;
  
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
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    b();
    postDelayed(new CasualTips.1(this, paramArrayList), 50L);
  }
  
  private void d()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      removeAllViews();
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_Int %= this.jdField_a_of_type_JavaUtilArrayList.size();
      localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label90;
      }
      QLog.e("CasualTips", 2, "setNextTip empty" + this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      return;
      label90:
      localObject1 = ((String)localObject1).split("\\n");
      if (localObject1.length <= 0) {
        break;
      }
      if (this.jdField_a_of_type_AndroidContentContext == null)
      {
        QLog.e("CasualTips", 2, "setNextTip mContext is null");
        return;
      }
      int k = agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int m = localObject1.length;
      int i = 0;
      int j = 0;
      while (i < m)
      {
        Object localObject2 = localObject1[i];
        TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        if (localTextView != null)
        {
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
        }
        j += 1;
        i += 1;
      }
    }
    QLog.e("CasualTips", 2, "setNextTip lines empty");
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void b()
  {
    QLog.d("CasualTips", 2, "stopAnimation");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 2000L);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void run()
  {
    d();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 2000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.CasualTips
 * JD-Core Version:    0.7.0.1
 */