package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.IRichMediaListener;

class QCircleSharePartV2$7
  implements QCircleRichMediaDownLoadManager.IRichMediaListener
{
  QCircleSharePartV2$7(QCircleSharePartV2 paramQCircleSharePartV2) {}
  
  public void a(int paramInt)
  {
    if (this.a.E() != null)
    {
      this.a.c("rich_meida_download_progress", Integer.valueOf(paramInt));
      return;
    }
    if (QCircleSharePartV2.c(this.a) != null) {
      QCircleSharePartV2.c(this.a).a("rich_meida_download_progress", Integer.valueOf(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.E() != null)
    {
      this.a.c("rich_media_download_status", Boolean.valueOf(paramBoolean));
      return;
    }
    if (QCircleSharePartV2.c(this.a) != null) {
      QCircleSharePartV2.c(this.a).a("rich_media_download_status", Boolean.valueOf(paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2.7
 * JD-Core Version:    0.7.0.1
 */