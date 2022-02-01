package com.tencent.biz.videostory.widget.easylyric;

import android.os.Looper;
import android.os.Message;

public class LyricControllerWrapper
  implements ILyriController
{
  private int jdField_a_of_type_Int = -1;
  protected ILyricView a;
  private LyricControllerWrapper.LyricServiceHandler jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricControllerWrapper$LyricServiceHandler = new LyricControllerWrapper.LyricServiceHandler(this, Looper.getMainLooper());
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricControllerWrapper$LyricServiceHandler.removeCallbacks(null);
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricView = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricControllerWrapper$LyricServiceHandler);
    localMessage.what = 7;
    localMessage.obj = new LyricControllerWrapper.CommonData(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(ILyricView paramILyricView)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricView = paramILyricView;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricControllerWrapper$LyricServiceHandler);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricView != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricView.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricControllerWrapper$LyricServiceHandler);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricView != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricView.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricView != null) {}
  }
  
  protected void e()
  {
    a(4);
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricView != null) {}
  }
  
  protected void f()
  {
    a(5);
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricView != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.LyricControllerWrapper
 * JD-Core Version:    0.7.0.1
 */