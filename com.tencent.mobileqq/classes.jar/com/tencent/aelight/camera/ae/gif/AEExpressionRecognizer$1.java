package com.tencent.aelight.camera.ae.gif;

import com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver;
import com.tencent.common.app.AppInterface;

class AEExpressionRecognizer$1
  extends CameraPeakServiceObserver
{
  AEExpressionRecognizer$1(AEExpressionRecognizer paramAEExpressionRecognizer, AppInterface paramAppInterface) {}
  
  public void onUpdateRecommendText(boolean paramBoolean, RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean)
    {
      AEExpressionRecognizer.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifAEExpressionRecognizer).a(paramRecognizedEmotionBean);
      return;
    }
    AEExpressionRecognizer.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifAEExpressionRecognizer).a(new RecognizedEmotionBean());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEExpressionRecognizer.1
 * JD-Core Version:    0.7.0.1
 */