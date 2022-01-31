package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import osf;
import rjg;
import rjk;
import rjn;
import rjy;
import rjz;

public class VideoPreloadMgr$PreloadTask
  implements Runnable
{
  rjg jdField_a_of_type_Rjg;
  rjk jdField_a_of_type_Rjk;
  rjz jdField_a_of_type_Rjz;
  
  public void a(rjn paramrjn, rjk paramrjk)
  {
    if ((paramrjn == null) || (paramrjk == null) || (paramrjn.a() == null) || (TextUtils.isEmpty(paramrjk.jdField_c_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      VideoPreloadMgr.a(this.this$0, paramrjn);
      VideoPreloadMgr.a(this.this$0, paramrjk);
      if (QLog.isColorLevel()) {
        QLog.i("Q.readinjoy.video", 2, "[preload]:" + paramrjk.jdField_c_of_type_JavaLangString + ", busiType =" + paramrjk.f + ", articleID =" + paramrjk.jdField_c_of_type_Long);
      }
      paramrjn.n();
      paramrjn.a(Long.valueOf(paramrjk.jdField_c_of_type_Long));
      if (paramrjk.f == 2) {
        osf.a().a(paramrjk.jdField_c_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new rjy(this, paramrjn));
      }
      while (this.jdField_a_of_type_Rjz != null)
      {
        paramrjn = this.jdField_a_of_type_Rjz;
        paramrjn.i += 1;
        return;
        paramrjn.a(paramrjk.jdField_c_of_type_JavaLangString, 2, 0L);
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Rjk != null) {
      a(this.jdField_a_of_type_Rjg.a(this.jdField_a_of_type_Rjk), this.jdField_a_of_type_Rjk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr.PreloadTask
 * JD-Core Version:    0.7.0.1
 */