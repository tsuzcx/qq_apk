package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

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
    if ((paramIntent == null) || (this.a == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.a.a;
    } while ((localQQAppInterface == null) || (!paramIntent.getBooleanExtra("key_reactive_push_tip", false)));
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A1BF", "0X800A1BF", 0, 0, "", "", "", "");
  }
  
  public String getTag()
  {
    return "ReactiveHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a != null)
    {
      BaseActivity localBaseActivity = this.a.a();
      localObject1 = localObject2;
      if (localBaseActivity != null) {
        localObject1 = localBaseActivity.getIntent();
      }
    }
    a((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ReactiveHelper
 * JD-Core Version:    0.7.0.1
 */