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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask.a(this.jdField_a_of_type_ArrayOfJavaLangObject);
    TipsManager.a(this.this$0).a((View)localObject, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask);
    localObject = this.this$0;
    ((TipsManager)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask;
    if (TipsManager.a((TipsManager)localObject) != null) {
      TipsManager.a(this.this$0).update(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TipsManager.1
 * JD-Core Version:    0.7.0.1
 */