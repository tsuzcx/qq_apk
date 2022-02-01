package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import sfb;
import slm;
import trl;
import trn;
import trp;

public class VideoPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private sfb jdField_a_of_type_Sfb;
  private trp jdField_a_of_type_Trp;
  
  public VideoPlayManager$PlayStartVideoRunnable(VideoPlayManager paramVideoPlayManager, trp paramtrp)
  {
    this.jdField_a_of_type_Trp = paramtrp;
    this.jdField_a_of_type_Sfb = trp.a(paramtrp);
    this.jdField_a_of_type_Int = paramtrp.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    if ((this.jdField_a_of_type_Trp == null) || (this.jdField_a_of_type_Sfb == null) || (VideoPlayManager.c(this.this$0))) {}
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
            if (this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_Int != 0) {
              break;
            }
          } while (TextUtils.isEmpty(this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_d_of_type_JavaLangString));
          this.jdField_a_of_type_Sfb.a("", this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_d_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_d_of_type_Int);
          return;
          if ((this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_Int == 7))
          {
            this.jdField_a_of_type_Sfb.a(this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Int);
            return;
          }
          if ((this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_Int != 2) && ((this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_JavaLangString)))) {
            break;
          }
        } while (this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_JavaLangString == null);
        slm.a().a(this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_JavaLangString, new trn(this));
        return;
        if (this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_Int != 5) {
          break;
        }
      } while (this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_JavaLangString == null);
      this.jdField_a_of_type_Sfb.a("", this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_d_of_type_Int, false);
      return;
    } while ((this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_d_of_type_JavaLangString)));
    this.jdField_a_of_type_Sfb.a("", this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_d_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Trp.jdField_a_of_type_Trl.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */