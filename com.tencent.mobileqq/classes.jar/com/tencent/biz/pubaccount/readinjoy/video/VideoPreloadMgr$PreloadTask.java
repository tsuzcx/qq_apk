package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import onu;
import qtr;
import qtv;
import qty;
import quj;
import quk;

public class VideoPreloadMgr$PreloadTask
  implements Runnable
{
  qtr jdField_a_of_type_Qtr;
  qtv jdField_a_of_type_Qtv;
  quk jdField_a_of_type_Quk;
  
  public void a(qty paramqty, qtv paramqtv)
  {
    if ((paramqty == null) || (paramqtv == null) || (paramqty.a() == null) || (TextUtils.isEmpty(paramqtv.jdField_c_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      VideoPreloadMgr.a(this.this$0, paramqty);
      VideoPreloadMgr.a(this.this$0, paramqtv);
      if (QLog.isColorLevel()) {
        QLog.i("Q.readinjoy.video", 2, "[preload]:" + paramqtv.jdField_c_of_type_JavaLangString + ", busiType =" + paramqtv.f + ", articleID =" + paramqtv.jdField_c_of_type_Long);
      }
      paramqty.n();
      paramqty.a(Long.valueOf(paramqtv.jdField_c_of_type_Long));
      if (paramqtv.f == 2) {
        onu.a().a(paramqtv.jdField_c_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new quj(this, paramqty));
      }
      while (this.jdField_a_of_type_Quk != null)
      {
        paramqty = this.jdField_a_of_type_Quk;
        paramqty.i += 1;
        return;
        paramqty.a(paramqtv.jdField_c_of_type_JavaLangString, 2, 0L);
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Qtv != null) {
      a(this.jdField_a_of_type_Qtr.a(this.jdField_a_of_type_Qtv), this.jdField_a_of_type_Qtv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr.PreloadTask
 * JD-Core Version:    0.7.0.1
 */