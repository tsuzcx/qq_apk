package com.tencent.mobileqq.activity.aio.photo;

class AIOImageListScene$8
  implements Runnable
{
  AIOImageListScene$8(AIOImageListScene paramAIOImageListScene, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.u != null)
    {
      AIORichMediaInfo localAIORichMediaInfo = this.this$0.u.c();
      if (this.this$0.u.a(this.a) != null) {
        this.this$0.l();
      }
      if ((this.b) && (localAIORichMediaInfo != null) && (this.a == localAIORichMediaInfo.a.L)) {
        AIOGalleryMsgRevokeMgr.a(AIOImageListScene.B(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.8
 * JD-Core Version:    0.7.0.1
 */