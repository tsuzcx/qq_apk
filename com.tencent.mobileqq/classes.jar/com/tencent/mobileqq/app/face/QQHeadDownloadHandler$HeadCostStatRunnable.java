package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.avatar.handler.AvatarHandler;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;

class QQHeadDownloadHandler$HeadCostStatRunnable
  implements Runnable
{
  int downloadSize;
  String downloadUrl;
  int dstUsrType;
  int errCode;
  String id;
  int idType;
  int resultCode = 0;
  int sizeType;
  int state;
  long time;
  
  public QQHeadDownloadHandler$HeadCostStatRunnable(QQHeadDownloadHandler paramQQHeadDownloadHandler, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, int paramInt7, long paramLong)
  {
    this.resultCode = paramInt1;
    this.id = paramString1;
    this.idType = paramInt2;
    this.sizeType = paramInt3;
    this.dstUsrType = paramInt4;
    this.state = paramInt5;
    this.downloadSize = paramInt6;
    this.downloadUrl = paramString2;
    this.errCode = paramInt7;
    this.time = paramLong;
  }
  
  public void run()
  {
    QQHeadDownloadHandler.access$000(this.this$0).a(this.resultCode, this.id, this.dstUsrType, 4, this.downloadSize, this.downloadUrl, this.errCode, this.time);
    String str = AvatarUtil.a(this.dstUsrType, this.id, this.idType, this.sizeType);
    QQHeadDownloadHandler.access$000(this.this$0).a(str, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.QQHeadDownloadHandler.HeadCostStatRunnable
 * JD-Core Version:    0.7.0.1
 */