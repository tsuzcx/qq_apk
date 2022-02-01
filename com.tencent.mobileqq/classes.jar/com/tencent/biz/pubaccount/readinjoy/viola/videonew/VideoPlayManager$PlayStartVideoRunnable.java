package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import rwf;
import scq;
import tih;
import tij;
import til;

public class VideoPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private rwf jdField_a_of_type_Rwf;
  private til jdField_a_of_type_Til;
  
  public VideoPlayManager$PlayStartVideoRunnable(VideoPlayManager paramVideoPlayManager, til paramtil)
  {
    this.jdField_a_of_type_Til = paramtil;
    this.jdField_a_of_type_Rwf = til.a(paramtil);
    this.jdField_a_of_type_Int = paramtil.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    if ((this.jdField_a_of_type_Til == null) || (this.jdField_a_of_type_Rwf == null) || (VideoPlayManager.c(this.this$0))) {}
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
            if (this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_Int != 0) {
              break;
            }
          } while (TextUtils.isEmpty(this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_d_of_type_JavaLangString));
          this.jdField_a_of_type_Rwf.a("", this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_d_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_d_of_type_Int);
          return;
          if ((this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_Int == 7))
          {
            this.jdField_a_of_type_Rwf.a(this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Int);
            return;
          }
          if ((this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_Int != 2) && ((this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString)))) {
            break;
          }
        } while (this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString == null);
        scq.a().a(this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString, new tij(this));
        return;
        if (this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_Int != 5) {
          break;
        }
      } while (this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString == null);
      this.jdField_a_of_type_Rwf.a("", this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_d_of_type_Int, false);
      return;
    } while ((this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_d_of_type_JavaLangString)));
    this.jdField_a_of_type_Rwf.a("", this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_d_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Til.jdField_a_of_type_Tih.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */