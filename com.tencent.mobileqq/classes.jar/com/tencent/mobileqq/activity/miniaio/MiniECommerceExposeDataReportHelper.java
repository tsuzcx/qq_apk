package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeLogic;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class MiniECommerceExposeDataReportHelper
  implements ILifeCycleHelper
{
  private MiniPie a;
  private boolean b = false;
  private boolean c = false;
  private AIOMessageRecordExposeLogic d;
  private Runnable e = new MiniECommerceExposeDataReportHelper.1(this);
  
  MiniECommerceExposeDataReportHelper(MiniPie paramMiniPie)
  {
    this.a = paramMiniPie;
  }
  
  private ListView a()
  {
    return this.a.i;
  }
  
  public String getTag()
  {
    return "ECommerceExposeDataReportHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 15, 20, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 15)
        {
          if (paramInt != 20) {
            return;
          }
          if (this.b) {
            this.d.b(this.a.d, a());
          }
        }
        else
        {
          this.b = false;
          this.c = false;
          this.d = null;
          ThreadManager.getUIHandler().removeCallbacks(this.e);
        }
      }
      else if (!this.c)
      {
        this.c = true;
        ThreadManager.getUIHandler().postDelayed(this.e, 800L);
      }
    }
    else {
      this.d = new AIOMessageRecordExposeLogic();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper
 * JD-Core Version:    0.7.0.1
 */