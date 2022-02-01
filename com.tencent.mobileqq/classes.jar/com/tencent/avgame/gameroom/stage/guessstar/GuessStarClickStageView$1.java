package com.tencent.avgame.gameroom.stage.guessstar;

import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;

class GuessStarClickStageView$1
  implements Runnable
{
  GuessStarClickStageView$1(GuessStarClickStageView paramGuessStarClickStageView) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_JavaUtilArrayList != null) && (this.this$0.jdField_a_of_type_Int < this.this$0.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      if ((this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8))
      {
        this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.this$0.a((String)((Pair)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.this$0.jdField_a_of_type_Int)).second);
      if (this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter != null) {
        this.this$0.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter.b(this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      if (this.this$0.jdField_a_of_type_Int < this.this$0.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        Handler localHandler = ThreadManager.getUIHandlerV2();
        ArrayList localArrayList = this.this$0.jdField_a_of_type_JavaUtilArrayList;
        GuessStarClickStageView localGuessStarClickStageView = this.this$0;
        int i = localGuessStarClickStageView.jdField_a_of_type_Int + 1;
        localGuessStarClickStageView.jdField_a_of_type_Int = i;
        localHandler.postDelayed(this, (((Integer)((Pair)localArrayList.get(i)).first).intValue() - ((Integer)((Pair)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.this$0.jdField_a_of_type_Int - 1)).first).intValue()) * 1000);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStageView.1
 * JD-Core Version:    0.7.0.1
 */