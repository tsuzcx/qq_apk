package com.tencent.biz.qqcircle.bizparts;

class QCircleRichMediaDownLoadPart$1
  implements Runnable
{
  QCircleRichMediaDownLoadPart$1(QCircleRichMediaDownLoadPart paramQCircleRichMediaDownLoadPart, String paramString, Object paramObject) {}
  
  public void run()
  {
    if ("rich_media_download_show".equals(this.a))
    {
      QCircleRichMediaDownLoadPart.a(this.this$0);
      return;
    }
    Object localObject;
    if ("rich_media_download_status".equals(this.a))
    {
      localObject = this.b;
      if ((localObject instanceof Boolean)) {
        QCircleRichMediaDownLoadPart.a(this.this$0, ((Boolean)localObject).booleanValue());
      }
    }
    else if ("rich_meida_download_progress".equals(this.a))
    {
      localObject = this.b;
      if ((localObject instanceof Integer)) {
        QCircleRichMediaDownLoadPart.a(this.this$0, ((Integer)localObject).intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart.1
 * JD-Core Version:    0.7.0.1
 */