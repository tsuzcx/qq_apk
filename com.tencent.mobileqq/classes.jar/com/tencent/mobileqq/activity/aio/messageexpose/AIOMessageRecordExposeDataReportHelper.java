package com.tencent.mobileqq.activity.aio.messageexpose;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.widget.ListView;

public class AIOMessageRecordExposeDataReportHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  private boolean b = false;
  private AIOMessageRecordExposeLogic c;
  
  public AIOMessageRecordExposeDataReportHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private ListView a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie instanceof MultiForwardChatPie)) {
      return ((MultiForwardChatPie)localBaseChatPie).bB();
    }
    return localBaseChatPie.U;
  }
  
  public String getTag()
  {
    return "AIOMessageRecordExposeDataReportHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15, 20 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15)
        {
          if (paramInt != 20) {
            return;
          }
          if (this.b) {
            this.c.b(this.a.d, a());
          }
        }
        else
        {
          this.b = false;
          this.c = null;
        }
      }
      else
      {
        this.b = true;
        this.c.a(this.a.d, a());
      }
    }
    else {
      this.c = new AIOMessageRecordExposeLogic();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeDataReportHelper
 * JD-Core Version:    0.7.0.1
 */