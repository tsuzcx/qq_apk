package com.tencent.biz.subscribe.utils;

import bdhb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import ymb;
import ymf;

public class SubscribeDraftManager$1
  implements Runnable
{
  public SubscribeDraftManager$1(ymb paramymb, String paramString1, String paramString2, String paramString3, String paramString4, ymf paramymf) {}
  
  public void run()
  {
    Pair localPair = ymb.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      int i;
      if ((this.this$0.a((String)localPair.first, this.c)) && (this.this$0.a((String)localPair.second, this.d)))
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        if (this.jdField_a_of_type_Ymf != null) {
          this.jdField_a_of_type_Ymf.a(3, true, this.b, new Object[0]);
        }
      }
      label100:
      do
      {
        return;
        i = 0;
        break;
        bdhb.d((String)localPair.first);
        bdhb.d((String)localPair.second);
      } while (this.jdField_a_of_type_Ymf == null);
      this.jdField_a_of_type_Ymf.a(3, false, this.b, new Object[0]);
      return;
    }
    if (this.jdField_a_of_type_Ymf != null) {
      this.jdField_a_of_type_Ymf.a(3, false, this.b, new Object[0]);
    }
    QLog.d(ymb.jdField_a_of_type_JavaLangString, 4, "modify new draft failed because cat't new folder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.1
 * JD-Core Version:    0.7.0.1
 */