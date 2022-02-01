package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.portal.StrokeTextView;

public class RedPacketRollNumberView
  extends LinearLayout
  implements RedPacketRollTextView.OnRollTextChangeListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private RedPacketRollNumberView.OnRollListener jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollNumberView$OnRollListener;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c = 0;
  
  public RedPacketRollNumberView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public RedPacketRollNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext, paramAttributeSet);
  }
  
  public RedPacketRollNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.rollText);
    this.b = ((int)paramContext.getDimension(3, 12.0F));
    paramContext.recycle();
  }
  
  public void a()
  {
    post(new RedPacketRollNumberView.1(this));
  }
  
  public void a(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      throw new Exception("no must be positive");
    }
    StrokeTextView localStrokeTextView = new StrokeTextView(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localStrokeTextView.setIncludeFontPadding(false);
    localStrokeTextView.setLayoutParams(localLayoutParams);
    localStrokeTextView.setGravity(80);
    localStrokeTextView.setTextSize(0, this.b);
    localStrokeTextView.setStrokeEnable(true);
    localStrokeTextView.setStrokeColor(-1);
    localStrokeTextView.setStrokeSize(AIOUtils.a(6.0F, getResources()));
    localStrokeTextView.setInnerTextColor(-2094274);
    localStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
    int i = (int)paramDouble;
    int j = (int)Math.round((paramDouble - i) * 1000.0D) / 10;
    a(j);
    if (j < 10) {
      a(0);
    }
    localStrokeTextView.setText(".");
    addView(localStrokeTextView, 0);
    a(i);
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      throw new Exception("no must be positive");
    }
    RedPacketRollTextView localRedPacketRollTextView = new RedPacketRollTextView(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_Boolean);
    localRedPacketRollTextView.setListener(this);
    addView(localRedPacketRollTextView, 0);
    localRedPacketRollTextView.setScope(0, paramInt % 10);
    paramInt /= 10;
    while (paramInt > 0)
    {
      localRedPacketRollTextView = new RedPacketRollTextView(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_Boolean);
      localRedPacketRollTextView.setListener(this);
      localRedPacketRollTextView.setScope(0, paramInt % 10);
      addView(localRedPacketRollTextView, 0);
      paramInt /= 10;
    }
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void b()
  {
    if ((this.c == this.jdField_a_of_type_Int - 2) && (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollNumberView$OnRollListener != null)) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollNumberView$OnRollListener.a();
    }
    this.c += 1;
  }
  
  public void b(double paramDouble)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      View localView = getChildAt(i);
      if ((localView != null) && ((localView instanceof RedPacketRollTextView))) {
        ((RedPacketRollTextView)localView).a();
      }
      i += 1;
    }
    removeAllViews();
    try
    {
      this.c = 0;
      a(paramDouble);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setIsRool(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLisener(RedPacketRollNumberView.OnRollListener paramOnRollListener)
  {
    if (paramOnRollListener != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollNumberView$OnRollListener = paramOnRollListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketRollNumberView
 * JD-Core Version:    0.7.0.1
 */