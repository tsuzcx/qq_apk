package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import onx;
import qtu;
import qty;
import qub;
import qum;
import qun;

public class VideoPreloadMgr$PreloadTask
  implements Runnable
{
  qtu jdField_a_of_type_Qtu;
  qty jdField_a_of_type_Qty;
  qun jdField_a_of_type_Qun;
  
  public void a(qub paramqub, qty paramqty)
  {
    if ((paramqub == null) || (paramqty == null) || (paramqub.a() == null) || (TextUtils.isEmpty(paramqty.jdField_c_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      VideoPreloadMgr.a(this.this$0, paramqub);
      VideoPreloadMgr.a(this.this$0, paramqty);
      if (QLog.isColorLevel()) {
        QLog.i("Q.readinjoy.video", 2, "[preload]:" + paramqty.jdField_c_of_type_JavaLangString + ", busiType =" + paramqty.f + ", articleID =" + paramqty.jdField_c_of_type_Long);
      }
      paramqub.n();
      paramqub.a(Long.valueOf(paramqty.jdField_c_of_type_Long));
      if (paramqty.f == 2) {
        onx.a().a(paramqty.jdField_c_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new qum(this, paramqub));
      }
      while (this.jdField_a_of_type_Qun != null)
      {
        paramqub = this.jdField_a_of_type_Qun;
        paramqub.i += 1;
        return;
        paramqub.a(paramqty.jdField_c_of_type_JavaLangString, 2, 0L);
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Qty != null) {
      a(this.jdField_a_of_type_Qtu.a(this.jdField_a_of_type_Qty), this.jdField_a_of_type_Qty);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr.PreloadTask
 * JD-Core Version:    0.7.0.1
 */