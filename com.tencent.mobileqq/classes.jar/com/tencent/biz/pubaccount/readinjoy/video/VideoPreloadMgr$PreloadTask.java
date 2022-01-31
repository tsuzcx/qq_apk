package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import ocm;
import qhp;
import qht;
import qhw;
import qih;
import qii;

public class VideoPreloadMgr$PreloadTask
  implements Runnable
{
  qhp jdField_a_of_type_Qhp;
  qht jdField_a_of_type_Qht;
  qii jdField_a_of_type_Qii;
  
  public void a(qhw paramqhw, qht paramqht)
  {
    if ((paramqhw == null) || (paramqht == null) || (paramqhw.a() == null) || (TextUtils.isEmpty(paramqht.jdField_c_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      VideoPreloadMgr.a(this.this$0, paramqhw);
      VideoPreloadMgr.a(this.this$0, paramqht);
      if (QLog.isColorLevel()) {
        QLog.i("Q.readinjoy.video", 2, "[preload]:" + paramqht.jdField_c_of_type_JavaLangString + ", busiType =" + paramqht.f + ", articleID =" + paramqht.jdField_c_of_type_Long);
      }
      paramqhw.n();
      paramqhw.a(Long.valueOf(paramqht.jdField_c_of_type_Long));
      if (paramqht.f == 2) {
        ocm.a().a(paramqht.jdField_c_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new qih(this, paramqhw));
      }
      while (this.jdField_a_of_type_Qii != null)
      {
        paramqhw = this.jdField_a_of_type_Qii;
        paramqhw.i += 1;
        return;
        paramqhw.a(paramqht.jdField_c_of_type_JavaLangString, 2, 0L);
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Qht != null) {
      a(this.jdField_a_of_type_Qhp.a(this.jdField_a_of_type_Qht), this.jdField_a_of_type_Qht);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr.PreloadTask
 * JD-Core Version:    0.7.0.1
 */