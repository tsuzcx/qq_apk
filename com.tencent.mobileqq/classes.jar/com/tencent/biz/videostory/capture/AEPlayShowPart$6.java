package com.tencent.biz.videostory.capture;

import bgxt;
import com.tencent.biz.videostory.capture.widgets.AEPlayShowPageView;
import java.util.List;
import wru;

public class AEPlayShowPart$6
  implements Runnable
{
  public AEPlayShowPart$6(wru paramwru, String paramString, int paramInt) {}
  
  public void run()
  {
    if ("".equals(this.jdField_a_of_type_JavaLangString)) {
      wru.a(this.this$0, 0);
    }
    for (;;)
    {
      return;
      List localList = wru.a(this.this$0).a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          bgxt localbgxt = (bgxt)localList.get(i);
          if ((localbgxt != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localbgxt.b)))
          {
            wru.a(this.this$0, i);
            if (wru.a(this.this$0).a() != null) {
              wru.a(this.this$0).a().b(this.jdField_a_of_type_Int);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.AEPlayShowPart.6
 * JD-Core Version:    0.7.0.1
 */