package com.tencent.avgame.gameroom.stage.guesspicture;

import com.tencent.avgame.gamelogic.data.TopicMosaicGuess;
import com.tencent.avgame.util.MosaicUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class BaseGuessPictureStageView$6
  implements URLDrawable.URLDrawableListener
{
  BaseGuessPictureStageView$6(BaseGuessPictureStageView paramBaseGuessPictureStageView, TopicMosaicGuess paramTopicMosaicGuess) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseGuessPictureStageView", 2, "urlDrawable load failed and throwable" + paramThrowable);
    }
    ReportController.b(null, "dc00898", "", "", "0X800B0FA", "0X800B0FA", 0, 0, "", "", "", "");
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null) && (paramURLDrawable.getURL().toString().equals(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.d();
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseGuessPictureStageView", 2, "urlDrawable load success");
    }
    ReportController.b(null, "dc00898", "", "", "0X800B0F5", "0X800B0F5", 0, 0, "", "", "", "");
    paramURLDrawable = MosaicUtil.a(paramURLDrawable.getCurrDrawable());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_a_of_type_AndroidGraphicsBitmap = paramURLDrawable;
    BaseGuessPictureStageView localBaseGuessPictureStageView = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView;
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicMosaicGuess.c == 0) {}
    for (int i = 10;; i = this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicMosaicGuess.c)
    {
      localBaseGuessPictureStageView.setMosaicBitmapFromOriginal(paramURLDrawable, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView.6
 * JD-Core Version:    0.7.0.1
 */