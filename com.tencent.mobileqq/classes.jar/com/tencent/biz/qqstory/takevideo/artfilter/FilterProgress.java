package com.tencent.biz.qqstory.takevideo.artfilter;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProgressPieView;
import com.tencent.widget.ProgressPieView.OnProgressListener;

public class FilterProgress
  extends RelativeLayout
  implements ProgressPieView.OnProgressListener
{
  public Context a;
  public Handler a;
  public ProgressPieView a;
  
  public FilterProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetProgressPieView != null)
    {
      removeView(this.jdField_a_of_type_ComTencentWidgetProgressPieView);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(38);
      this.jdField_a_of_type_ComTencentWidgetProgressPieView = null;
      setVisibility(8);
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.record.FilterProgress", 2, "onProgressCompleted");
    }
    a();
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.artfilter.FilterProgress
 * JD-Core Version:    0.7.0.1
 */