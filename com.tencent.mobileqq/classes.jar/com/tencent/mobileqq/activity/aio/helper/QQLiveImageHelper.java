package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/helper/QQLiveImageHelper;", "Lcom/tencent/mobileqq/activity/aio/helper/ILifeCycleHelper;", "chatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "(Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V", "getTag", "", "interestedIn", "", "onMoveToState", "", "state", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQLiveImageHelper
  implements ILifeCycleHelper
{
  public static final QQLiveImageHelper.Companion a;
  private final BaseChatPie a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioHelperQQLiveImageHelper$Companion = new QQLiveImageHelper.Companion(null);
  }
  
  public QQLiveImageHelper(@NotNull BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  @NotNull
  public String getTag()
  {
    return "QQLiveImagehelper";
  }
  
  @NotNull
  public int[] interestedIn()
  {
    return new int[] { 9, 6, 10, 11, 14, 17, 16, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveImagehelper", 2, "onMoveToState: state=" + paramInt);
    }
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 12: 
    case 13: 
    default: 
      return;
    case 9: 
      QQLiveImage.resumeAll((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    case 6: 
      QQLiveImage.onForeground((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    case 10: 
      QQLiveImage.pauseAll((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    case 11: 
      QQLiveImage.onBackground((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    case 14: 
      QQLiveImage.releaseAll((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    case 17: 
      QQLiveImage.resumeAll((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      return;
    }
    QQLiveImage.pauseAll((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQLiveImageHelper
 * JD-Core Version:    0.7.0.1
 */