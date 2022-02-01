package com.tencent.mobileqq.activity.aio.photo;

class AIOImageListScene$8
  implements Runnable
{
  AIOImageListScene$8(AIOImageListScene paramAIOImageListScene, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      AIORichMediaInfo localAIORichMediaInfo = this.this$0.a.a();
      if (this.this$0.a.a(this.jdField_a_of_type_Long) != null) {
        this.this$0.e();
      }
      if ((this.jdField_a_of_type_Boolean) && (localAIORichMediaInfo != null) && (this.jdField_a_of_type_Long == localAIORichMediaInfo.a.f)) {
        AIOGalleryMsgRevokeMgr.a(AIOImageListScene.p(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.8
 * JD-Core Version:    0.7.0.1
 */