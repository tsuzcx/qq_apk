package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import java.util.Observer;

class TipsManager$1
  implements Runnable
{
  TipsManager$1(TipsManager paramTipsManager, TipsBarTask paramTipsBarTask, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask.a(this.jdField_a_of_type_ArrayOfJavaLangObject);
    TipsManager.a(this.this$0).a(localView, TipsManager.a(this.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask);
    TipsManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask);
    if (TipsManager.a(this.this$0) != null) {
      TipsManager.a(this.this$0).update(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TipsManager.1
 * JD-Core Version:    0.7.0.1
 */