package com.tencent.avgame.gameroom.stage.guesspicture;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;

class GuessPictureClickStageView$1
  implements Runnable
{
  GuessPictureClickStageView$1(GuessPictureClickStageView paramGuessPictureClickStageView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_JavaUtilArrayList != null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.this$0.f);
      if (this.this$0.jdField_a_of_type_Int < this.this$0.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((this.this$0.jdField_b_of_type_AndroidViewView != null) && (this.this$0.jdField_b_of_type_AndroidViewView.getVisibility() == 8))
        {
          this.this$0.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.this$0.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        Object localObject = this.this$0;
        ((GuessPictureClickStageView)localObject).a((String)((Pair)((GuessPictureClickStageView)localObject).jdField_a_of_type_JavaUtilArrayList.get(this.this$0.jdField_a_of_type_Int)).second);
        if (this.this$0.jdField_a_of_type_Int < this.this$0.jdField_a_of_type_JavaUtilArrayList.size() - 1)
        {
          localObject = ThreadManager.getUIHandlerV2();
          ArrayList localArrayList = this.this$0.jdField_a_of_type_JavaUtilArrayList;
          GuessPictureClickStageView localGuessPictureClickStageView = this.this$0;
          int i = localGuessPictureClickStageView.jdField_a_of_type_Int + 1;
          localGuessPictureClickStageView.jdField_a_of_type_Int = i;
          ((Handler)localObject).postDelayed(this, (((Integer)((Pair)localArrayList.get(i)).first).intValue() - ((Integer)((Pair)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.this$0.jdField_a_of_type_Int - 1)).first).intValue()) * 1000);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureClickStageView.1
 * JD-Core Version:    0.7.0.1
 */