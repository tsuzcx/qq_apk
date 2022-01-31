package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import onu;
import qty;
import ryw;
import ryy;
import rza;

public class VideoPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private qty jdField_a_of_type_Qty;
  private rza jdField_a_of_type_Rza;
  
  public VideoPlayManager$PlayStartVideoRunnable(VideoPlayManager paramVideoPlayManager, rza paramrza)
  {
    this.jdField_a_of_type_Rza = paramrza;
    this.jdField_a_of_type_Qty = rza.a(paramrza);
    this.jdField_a_of_type_Int = paramrza.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    if ((this.jdField_a_of_type_Rza == null) || (this.jdField_a_of_type_Qty == null) || (VideoPlayManager.c(this.this$0))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            VideoPlayManager.a(this.this$0, true);
            if (this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_Int != 0) {
              break;
            }
          } while (TextUtils.isEmpty(this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_d_of_type_JavaLangString));
          this.jdField_a_of_type_Qty.a("", this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_d_of_type_JavaLangString, 2, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_d_of_type_Int);
          return;
          if ((this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_Int == 7))
          {
            this.jdField_a_of_type_Qty.a(this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int);
            return;
          }
          if ((this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_Int != 2) && ((this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString)))) {
            break;
          }
        } while (this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString == null);
        onu.a().a(this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new ryy(this));
        return;
        if (this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_Int != 5) {
          break;
        }
      } while (this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString == null);
      this.jdField_a_of_type_Qty.a("", this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_d_of_type_Int, false);
      return;
    } while ((this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_d_of_type_JavaLangString)));
    this.jdField_a_of_type_Qty.a("", this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_d_of_type_JavaLangString, 2, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Rza.jdField_a_of_type_Ryw.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */