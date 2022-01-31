package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import onx;
import qub;
import ryz;
import rzb;
import rzd;

public class VideoPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private qub jdField_a_of_type_Qub;
  private rzd jdField_a_of_type_Rzd;
  
  public VideoPlayManager$PlayStartVideoRunnable(VideoPlayManager paramVideoPlayManager, rzd paramrzd)
  {
    this.jdField_a_of_type_Rzd = paramrzd;
    this.jdField_a_of_type_Qub = rzd.a(paramrzd);
    this.jdField_a_of_type_Int = paramrzd.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    if ((this.jdField_a_of_type_Rzd == null) || (this.jdField_a_of_type_Qub == null) || (VideoPlayManager.c(this.this$0))) {}
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
            if (this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_Int != 0) {
              break;
            }
          } while (TextUtils.isEmpty(this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_d_of_type_JavaLangString));
          this.jdField_a_of_type_Qub.a("", this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_d_of_type_JavaLangString, 2, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_d_of_type_Int);
          return;
          if ((this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_Int == 7))
          {
            this.jdField_a_of_type_Qub.a(this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int);
            return;
          }
          if ((this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_Int != 2) && ((this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_JavaLangString)))) {
            break;
          }
        } while (this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_JavaLangString == null);
        onx.a().a(this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new rzb(this));
        return;
        if (this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_Int != 5) {
          break;
        }
      } while (this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_JavaLangString == null);
      this.jdField_a_of_type_Qub.a("", this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_d_of_type_Int, false);
      return;
    } while ((this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_d_of_type_JavaLangString)));
    this.jdField_a_of_type_Qub.a("", this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_d_of_type_JavaLangString, 2, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Rzd.jdField_a_of_type_Ryz.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */