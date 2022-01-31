package com.tencent.biz.subscribe.utils;

import bbdj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import wsz;
import wtd;

public class SubscribeDraftManager$1
  implements Runnable
{
  public SubscribeDraftManager$1(wsz paramwsz, String paramString1, String paramString2, String paramString3, String paramString4, wtd paramwtd) {}
  
  public void run()
  {
    Pair localPair = wsz.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      int i;
      if ((this.this$0.a((String)localPair.first, this.c)) && (this.this$0.a((String)localPair.second, this.d)))
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        if (this.jdField_a_of_type_Wtd != null) {
          this.jdField_a_of_type_Wtd.a(3, true, this.b, new Object[0]);
        }
      }
      label100:
      do
      {
        return;
        i = 0;
        break;
        bbdj.d((String)localPair.first);
        bbdj.d((String)localPair.second);
      } while (this.jdField_a_of_type_Wtd == null);
      this.jdField_a_of_type_Wtd.a(3, false, this.b, new Object[0]);
      return;
    }
    if (this.jdField_a_of_type_Wtd != null) {
      this.jdField_a_of_type_Wtd.a(3, false, this.b, new Object[0]);
    }
    QLog.d(wsz.jdField_a_of_type_JavaLangString, 4, "modify new draft failed because cat't new folder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.1
 * JD-Core Version:    0.7.0.1
 */