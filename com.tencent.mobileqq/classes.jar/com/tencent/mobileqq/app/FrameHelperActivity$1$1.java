package com.tencent.mobileqq.app;

import android.support.v4.app.FragmentActivity;
import anxu;
import aysq;
import bdll;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

public class FrameHelperActivity$1$1
  implements Runnable
{
  public FrameHelperActivity$1$1(anxu paramanxu) {}
  
  public void run()
  {
    if ((this.a.a.getActivity() == null) || (this.a.a.getActivity().app == null)) {}
    for (;;)
    {
      return;
      Object localObject = (aysq)this.a.a.getActivity().app.getManager(160);
      RedTouchItem localRedTouchItem1 = ((aysq)localObject).a(10015);
      RedTouchItem localRedTouchItem2 = ((aysq)localObject).a(10016);
      RedTouchItem localRedTouchItem3 = ((aysq)localObject).a(-7);
      if ((localRedTouchItem3 != null) && (localRedTouchItem3.unReadFlag) && ((localRedTouchItem1 != null) || (localRedTouchItem2 != null)))
      {
        int i = ((aysq)localObject).a();
        localObject = null;
        switch (i)
        {
        }
        while (localObject != null)
        {
          bdll.b(this.a.a.getActivity().app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.1.1
 * JD-Core Version:    0.7.0.1
 */