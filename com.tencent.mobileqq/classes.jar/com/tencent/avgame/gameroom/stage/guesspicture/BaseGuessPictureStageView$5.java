package com.tencent.avgame.gameroom.stage.guesspicture;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.util.UiUtils;
import com.tencent.qphone.base.util.QLog;

class BaseGuessPictureStageView$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BaseGuessPictureStageView$5(BaseGuessPictureStageView paramBaseGuessPictureStageView, String paramString) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidWidgetTextView.getWidth() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidWidgetTextView.getPaddingLeft() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidWidgetTextView.getPaddingRight();
    if (QLog.isColorLevel())
    {
      QLog.d("BaseGuessPictureStageView", 2, "onShowMosaicImageGameTopicTips tip = " + this.jdField_a_of_type_JavaLangString);
      QLog.d("BaseGuessPictureStageView", 2, "onShowMosaicImageGameTopicTips tipWidth  = " + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidWidgetTextView.getWidth());
      QLog.d("BaseGuessPictureStageView", 2, "onShowMosaicImageGameTopicTips caluWidth  = " + i);
    }
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (UiUtils.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidWidgetTextView) <= 1) {
        break label284;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.a.a().b());
      localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidViewView.getWidth();
      localLayoutParams.height = (localLayoutParams.width * 130 / 478);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("BaseGuessPictureStageView", 2, "onShowMosaicImageGameTopicTips 130 w = " + localLayoutParams.width + ", h = " + localLayoutParams.height);
      }
    }
    label284:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.a.a().a());
      localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidViewView.getWidth();
      localLayoutParams.height = (localLayoutParams.width * 110 / 478);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    } while (!QLog.isColorLevel());
    QLog.d("BaseGuessPictureStageView", 2, "onShowMosaicImageGameTopicTips 110 w = " + localLayoutParams.width + ", h = " + localLayoutParams.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView.5
 * JD-Core Version:    0.7.0.1
 */