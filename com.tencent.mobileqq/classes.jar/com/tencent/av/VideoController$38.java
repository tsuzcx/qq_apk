package com.tencent.av;

import android.content.Context;
import com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper;
import com.tencent.av.wtogether.callback.RealNameAuthCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class VideoController$38
  implements RealNameAuthCallback
{
  VideoController$38(VideoController paramVideoController, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, Context paramContext, WTogetherRealNameVideoProcessHelper paramWTogetherRealNameVideoProcessHelper) {}
  
  public void a()
  {
    QLog.d(VideoController.a, 2, "onScreenShareRecv onCancel");
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper.a(null);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695840, 1).a();
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d(VideoController.a, 2, "onScreenShareRecv onAuthResult auth:" + paramBoolean);
    if (paramBoolean) {
      VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, true, this.jdField_a_of_type_Int, false, this.c, this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper.a(null);
      return;
      QLog.e(VideoController.a, 2, "onScreenShareRecv fail to auth");
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695840, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.38
 * JD-Core Version:    0.7.0.1
 */