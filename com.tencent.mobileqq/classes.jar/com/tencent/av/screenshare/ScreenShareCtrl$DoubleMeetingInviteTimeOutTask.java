package com.tencent.av.screenshare;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import ley;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

class ScreenShareCtrl$DoubleMeetingInviteTimeOutTask
  implements Runnable
{
  public final ley a;
  private final WeakReference<VideoController> a;
  
  public ScreenShareCtrl$DoubleMeetingInviteTimeOutTask(VideoController paramVideoController, @NotNull ley paramley)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramVideoController);
    this.jdField_a_of_type_Ley = paramley;
  }
  
  public void run()
  {
    long l = AudioHelper.b();
    VideoController localVideoController = (VideoController)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localVideoController != null) && (this.jdField_a_of_type_Ley.jdField_g_of_type_Int == 9))
    {
      if (localVideoController.a.a() <= 0) {
        break label82;
      }
      localVideoController.a.a(new Object[] { Integer.valueOf(404), Long.valueOf(l), Long.valueOf(this.jdField_a_of_type_Ley.jdField_g_of_type_Long) });
    }
    label82:
    while (!localVideoController.a.isBackground_Stop) {
      return;
    }
    localVideoController.a(l, this.jdField_a_of_type_Ley.jdField_g_of_type_Long, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.DoubleMeetingInviteTimeOutTask
 * JD-Core Version:    0.7.0.1
 */