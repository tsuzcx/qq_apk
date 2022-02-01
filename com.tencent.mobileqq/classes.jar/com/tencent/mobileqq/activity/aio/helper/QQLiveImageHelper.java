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
  public static final QQLiveImageHelper.Companion a = new QQLiveImageHelper.Companion(null);
  private final BaseChatPie b;
  
  public QQLiveImageHelper(@NotNull BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  @NotNull
  public String getTag()
  {
    return "QQLiveImagehelper";
  }
  
  @NotNull
  public int[] interestedIn()
  {
    return new int[] { 10, 7, 11, 12, 15, 18, 17, 16 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMoveToState: state=");
      localStringBuilder.append(paramInt);
      QLog.d("QQLiveImagehelper", 2, localStringBuilder.toString());
    }
    switch (paramInt)
    {
    case 8: 
    case 9: 
    case 13: 
    case 14: 
    default: 
      return;
    case 18: 
      QQLiveImage.resumeAll((Activity)this.b.aX());
      return;
    case 16: 
    case 17: 
      QQLiveImage.pauseAll((Activity)this.b.aX());
      return;
    case 15: 
      QQLiveImage.releaseAll((Activity)this.b.aX());
      return;
    case 12: 
      QQLiveImage.onBackground((Activity)this.b.aX());
      return;
    case 11: 
      QQLiveImage.pauseAll((Activity)this.b.aX());
      return;
    case 10: 
      QQLiveImage.resumeAll((Activity)this.b.aX());
      return;
    }
    QQLiveImage.onForeground((Activity)this.b.aX());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQLiveImageHelper
 * JD-Core Version:    0.7.0.1
 */