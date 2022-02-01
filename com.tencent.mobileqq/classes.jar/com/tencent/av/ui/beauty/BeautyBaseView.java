package com.tencent.av.ui.beauty;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import mcc;
import mmo;

public abstract class BeautyBaseView
  extends RelativeLayout
  implements View.OnClickListener, mcc, mmo
{
  long jdField_a_of_type_Long = 0L;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  public BeautyBaseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BeautyBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BeautyBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void b(long paramLong, boolean paramBoolean) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    long l = SystemClock.elapsedRealtime();
    if (((i & 0xFF) != 2) || (Math.abs(l - this.jdField_a_of_type_Long) > 200L))
    {
      this.jdField_a_of_type_Long = l;
      EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, -1043L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != paramVideoAppInterface) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautyBaseView
 * JD-Core Version:    0.7.0.1
 */