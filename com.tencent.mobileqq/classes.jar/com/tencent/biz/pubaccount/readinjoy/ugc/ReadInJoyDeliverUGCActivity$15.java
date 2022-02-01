package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.qphone.base.util.QLog;

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
        localObject = new ReadInJoyDeliverUGCActivity.UploadImage(this.this$0, str, this.jdField_a_of_type_Int).a();
      } while (((ReadInJoyDeliverUGCActivity.UploadImage)localObject).a());
      l = ((ReadInJoyDeliverUGCActivity.UploadImage)localObject).a();
      localObject = new ReadInJoyDeliverUGCActivity.CompressFile(this.this$0, str, l).a();
    } while (((ReadInJoyDeliverUGCActivity.CompressFile)localObject).a());
    ReadInJoyDeliverUGCActivity.a(this.this$0, str, l, (ReadInJoyDeliverUGCActivity.CompressFile)localObject, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.15
 * JD-Core Version:    0.7.0.1
 */