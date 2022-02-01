package com.tencent.mobileqq.app;

import android.support.v4.app.FragmentActivity;
import anly;
import axzw;
import bcst;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

public class FrameHelperActivity$1$1
  implements Runnable
{
  public FrameHelperActivity$1$1(anly paramanly) {}
  
  public void run()
  {
    if ((this.a.a.getActivity() == null) || (this.a.a.getActivity().app == null)) {}
    for (;;)
    {
      return;
      Object localObject = (axzw)this.a.a.getActivity().app.getManager(160);
      RedTouchItem localRedTouchItem1 = ((axzw)localObject).a(10015);
      RedTouchItem localRedTouchItem2 = ((axzw)localObject).a(10016);
      RedTouchItem localRedTouchItem3 = ((axzw)localObject).a(-7);
      if ((localRedTouchItem3 != null) && (localRedTouchItem3.unReadFlag) && ((localRedTouchItem1 != null) || (localRedTouchItem2 != null)))
      {
        int i = ((axzw)localObject).a();
        localObject = null;
        switch (i)
        {
        }
        while (localObject != null)
        {
          bcst.b(this.a.a.getActivity().app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
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