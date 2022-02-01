package com.tencent.mobileqq.apollo.process.ui.framework;

import android.view.View;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;

class QzoneGameFloatView$1
  implements Runnable
{
  QzoneGameFloatView$1(QzoneGameFloatView paramQzoneGameFloatView, int paramInt, CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1) {
      QzoneGameFloatView.a(this.this$0, true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 5))
      {
        QzoneGameFloatView.b(this.this$0, true);
        QzoneGameFloatView.c(this.this$0, true);
        if ((this.this$0.g != null) && (this.this$0.g.getVisibility() == 0)) {
          this.this$0.g.setVisibility(8);
        }
      }
      return;
      QzoneGameFloatView.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView.1
 * JD-Core Version:    0.7.0.1
 */