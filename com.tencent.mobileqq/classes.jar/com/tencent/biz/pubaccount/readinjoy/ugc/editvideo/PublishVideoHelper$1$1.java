package com.tencent.biz.pubaccount.readinjoy.ugc.editvideo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import rmd;

public class PublishVideoHelper$1$1
  implements Runnable
{
  public PublishVideoHelper$1$1(rmd paramrmd, int paramInt) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    int i;
    if (this.a == 0)
    {
      i = 2;
      if (this.a != 0) {
        break label40;
      }
    }
    label40:
    for (String str = "视频上传成功";; str = "视频上传失败")
    {
      QQToast.a(localBaseApplicationImpl, i, str, 0).a();
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.PublishVideoHelper.1.1
 * JD-Core Version:    0.7.0.1
 */