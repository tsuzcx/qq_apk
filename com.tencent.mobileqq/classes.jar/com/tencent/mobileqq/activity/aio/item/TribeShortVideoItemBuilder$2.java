package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.qphone.base.util.QLog;

class TribeShortVideoItemBuilder$2
  implements Runnable
{
  TribeShortVideoItemBuilder$2(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, String paramString, TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("itemBuilder handleGetVideo 2: fileName = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("TribeShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    ((TribeShortVideoItemBuilder.TribeShortVideoMsgHolder)localObject).s = true;
    ((TribeShortVideoItemBuilder.TribeShortVideoMsgHolder)localObject).c.b();
    this.b.c.setVisibility(8);
    localObject = this.this$0;
    ((TribeShortVideoItemBuilder)localObject).a(this.b, this.c, ((TribeShortVideoItemBuilder)localObject).z, this.this$0.A, this.d.coverImgUrl, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */