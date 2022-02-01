package com.tencent.avgame.gameroom.stage.guessstar;

import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;
import nbo;

class GuessStarStageView$1
  implements Runnable
{
  GuessStarStageView$1(GuessStarStageView paramGuessStarStageView) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_JavaUtilArrayList != null) && (this.this$0.jdField_a_of_type_Int < this.this$0.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      if ((this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8))
      {
        this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.this$0.b.setVisibility(0);
        this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      GuessStarStageView.a(this.this$0, (String)((Pair)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.this$0.jdField_a_of_type_Int)).second);
      if (this.this$0.jdField_a_of_type_Nbo != null) {
        this.this$0.jdField_a_of_type_Nbo.b(this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      if (this.this$0.jdField_a_of_type_Int < this.this$0.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        Handler localHandler = ThreadManager.getUIHandlerV2();
        ArrayList localArrayList = this.this$0.jdField_a_of_type_JavaUtilArrayList;
        GuessStarStageView localGuessStarStageView = this.this$0;
        int i = localGuessStarStageView.jdField_a_of_type_Int + 1;
        localGuessStarStageView.jdField_a_of_type_Int = i;
        localHandler.postDelayed(this, (((Integer)((Pair)localArrayList.get(i)).first).intValue() - ((Integer)((Pair)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.this$0.jdField_a_of_type_Int - 1)).first).intValue()) * 1000);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView.1
 * JD-Core Version:    0.7.0.1
 */