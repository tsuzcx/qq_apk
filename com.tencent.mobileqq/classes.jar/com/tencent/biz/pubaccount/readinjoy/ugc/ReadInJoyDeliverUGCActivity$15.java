package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.qphone.base.util.QLog;
import rhp;
import rht;

class ReadInJoyDeliverUGCActivity$15
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$15(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, Object paramObject, int paramInt) {}
  
  public void run()
  {
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic");
    if (ReadInJoyDeliverUGCActivity.a(this.this$0, this.jdField_a_of_type_JavaLangObject)) {}
    String str;
    Object localObject;
    long l;
    do
    {
      do
      {
        do
        {
          return;
          str = ReadInJoyDeliverUGCActivity.a(this.this$0, this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Int);
        } while (str == null);
        localObject = new rht(this.this$0, str, this.jdField_a_of_type_Int).a();
      } while (((rht)localObject).a());
      l = ((rht)localObject).a();
      localObject = new rhp(this.this$0, str, l).a();
    } while (((rhp)localObject).a());
    ReadInJoyDeliverUGCActivity.a(this.this$0, str, l, (rhp)localObject, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.15
 * JD-Core Version:    0.7.0.1
 */