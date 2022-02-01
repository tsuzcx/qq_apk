package com.tencent.avgame.ui;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.gamelogic.data.QuestionClassInfoItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter$1
  implements View.OnClickListener
{
  AVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter$1(AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter paramAVGameQuestionClassViewAdapter, QuestionClassInfoItem paramQuestionClassInfoItem) {}
  
  public void onClick(View paramView)
  {
    AVGameQuestionClassSelectDialog.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter.a, this.jdField_a_of_type_ComTencentAvgameGamelogicDataQuestionClassInfoItem.a);
    if (AVGameQuestionClassSelectDialog.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter.a)) {
      AVGameQuestionClassSelectDialog.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter.a).removeMessages(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */