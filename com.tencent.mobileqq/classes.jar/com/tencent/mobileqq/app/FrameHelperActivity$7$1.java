package com.tencent.mobileqq.app;

import alol;
import android.support.v4.app.FragmentActivity;
import avod;
import azmj;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

public class FrameHelperActivity$7$1
  implements Runnable
{
  public FrameHelperActivity$7$1(alol paramalol) {}
  
  public void run()
  {
    if ((this.a.a.getActivity() == null) || (this.a.a.getActivity().app == null)) {}
    for (;;)
    {
      return;
      Object localObject = (avod)this.a.a.getActivity().app.getManager(160);
      RedTouchItem localRedTouchItem1 = ((avod)localObject).a(10015);
      RedTouchItem localRedTouchItem2 = ((avod)localObject).a(10016);
      RedTouchItem localRedTouchItem3 = ((avod)localObject).a(-7);
      if ((localRedTouchItem3 != null) && (localRedTouchItem3.unReadFlag) && ((localRedTouchItem1 != null) || (localRedTouchItem2 != null)))
      {
        int i = ((avod)localObject).a();
        localObject = null;
        switch (i)
        {
        }
        while (localObject != null)
        {
          azmj.b(this.a.a.getActivity().app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
          return;
          localObject = "0X80073B1";
          continue;
          localObject = "0X80073B3";
          continue;
          localObject = "0X80073B7";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.7.1
 * JD-Core Version:    0.7.0.1
 */