package com.tencent.mobileqq.app;

import alta;
import android.support.v4.app.FragmentActivity;
import avsm;
import azqs;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

public class FrameHelperActivity$7$1
  implements Runnable
{
  public FrameHelperActivity$7$1(alta paramalta) {}
  
  public void run()
  {
    if ((this.a.a.getActivity() == null) || (this.a.a.getActivity().app == null)) {}
    for (;;)
    {
      return;
      Object localObject = (avsm)this.a.a.getActivity().app.getManager(160);
      RedTouchItem localRedTouchItem1 = ((avsm)localObject).a(10015);
      RedTouchItem localRedTouchItem2 = ((avsm)localObject).a(10016);
      RedTouchItem localRedTouchItem3 = ((avsm)localObject).a(-7);
      if ((localRedTouchItem3 != null) && (localRedTouchItem3.unReadFlag) && ((localRedTouchItem1 != null) || (localRedTouchItem2 != null)))
      {
        int i = ((avsm)localObject).a();
        localObject = null;
        switch (i)
        {
        }
        while (localObject != null)
        {
          azqs.b(this.a.a.getActivity().app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
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