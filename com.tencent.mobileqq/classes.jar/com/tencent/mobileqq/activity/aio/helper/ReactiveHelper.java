package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

public class ReactiveHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  
  public ReactiveHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = this.a;
      if (localObject == null) {
        return;
      }
      localObject = ((BaseChatPie)localObject).a;
      if (localObject == null) {
        return;
      }
      if (paramIntent.getBooleanExtra("key_reactive_push_tip", false)) {
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A1BF", "0X800A1BF", 0, 0, "", "", "", "");
      }
    }
  }
  
  public String getTag()
  {
    return "ReactiveHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4) {
      return;
    }
    Object localObject2 = null;
    Object localObject3 = this.a;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseChatPie)localObject3).a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Activity)localObject3).getIntent();
      }
    }
    a((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ReactiveHelper
 * JD-Core Version:    0.7.0.1
 */