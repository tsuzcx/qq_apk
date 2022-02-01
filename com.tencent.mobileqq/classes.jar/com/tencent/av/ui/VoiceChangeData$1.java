package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class VoiceChangeData$1
  implements URLDrawable.URLDrawableListener
{
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    AVLog.printErrorLog(VoiceChangeData.a, "getDrawable|urldrawable load failed. url = " + this.jdField_a_of_type_ComTencentAvUiVoiceChangeData$VoiceInfo.b);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    AVLog.printErrorLog(VoiceChangeData.a, "getDrawable|urldrawable load failed. url = " + this.jdField_a_of_type_ComTencentAvUiVoiceChangeData$VoiceInfo.b);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVoiceChangeData$GetDrawableCallack != null) {
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeData$GetDrawableCallack.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeData.1
 * JD-Core Version:    0.7.0.1
 */