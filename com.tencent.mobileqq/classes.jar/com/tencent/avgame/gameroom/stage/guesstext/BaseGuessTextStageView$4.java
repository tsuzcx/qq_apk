package com.tencent.avgame.gameroom.stage.guesstext;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;

class BaseGuessTextStageView$4
  implements Runnable
{
  BaseGuessTextStageView$4(BaseGuessTextStageView paramBaseGuessTextStageView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_JavaUtilArrayList != null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.jdField_a_of_type_JavaLangRunnable);
      if (this.this$0.jdField_a_of_type_Int < this.this$0.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((this.this$0.jdField_a_of_type_AndroidViewView != null) && (this.this$0.jdField_a_of_type_AndroidViewView.getVisibility() == 8))
        {
          this.this$0.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.this$0.b.setVisibility(0);
        }
        this.this$0.a((String)((Pair)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.this$0.jdField_a_of_type_Int)).second);
        if (this.this$0.jdField_a_of_type_Int < this.this$0.jdField_a_of_type_JavaUtilArrayList.size() - 1)
        {
          Handler localHandler = ThreadManager.getUIHandlerV2();
          ArrayList localArrayList = this.this$0.jdField_a_of_type_JavaUtilArrayList;
          BaseGuessTextStageView localBaseGuessTextStageView = this.this$0;
          int i = localBaseGuessTextStageView.jdField_a_of_type_Int + 1;
          localBaseGuessTextStageView.jdField_a_of_type_Int = i;
          localHandler.postDelayed(this, (((Integer)((Pair)localArrayList.get(i)).first).intValue() - ((Integer)((Pair)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.this$0.jdField_a_of_type_Int - 1)).first).intValue()) * 1000);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.BaseGuessTextStageView.4
 * JD-Core Version:    0.7.0.1
 */