package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import ocm;
import qhw;
import rmi;
import rmk;
import rmm;

public class VideoPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private qhw jdField_a_of_type_Qhw;
  private rmm jdField_a_of_type_Rmm;
  
  public VideoPlayManager$PlayStartVideoRunnable(VideoPlayManager paramVideoPlayManager, rmm paramrmm)
  {
    this.jdField_a_of_type_Rmm = paramrmm;
    this.jdField_a_of_type_Qhw = rmm.a(paramrmm);
    this.jdField_a_of_type_Int = paramrmm.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    if ((this.jdField_a_of_type_Rmm == null) || (this.jdField_a_of_type_Qhw == null) || (VideoPlayManager.c(this.this$0))) {}
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
            if (this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_Int != 0) {
              break;
            }
          } while (TextUtils.isEmpty(this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_d_of_type_JavaLangString));
          this.jdField_a_of_type_Qhw.a("", this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_d_of_type_JavaLangString, 2, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_d_of_type_Int);
          return;
          if ((this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_Int == 7))
          {
            this.jdField_a_of_type_Qhw.a(this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int);
            return;
          }
          if ((this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_Int != 2) && ((this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_JavaLangString)))) {
            break;
          }
        } while (this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_JavaLangString == null);
        ocm.a().a(this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new rmk(this));
        return;
        if (this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_Int != 5) {
          break;
        }
      } while (this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_JavaLangString == null);
      this.jdField_a_of_type_Qhw.a("", this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_d_of_type_Int, false);
      return;
    } while ((this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_d_of_type_JavaLangString)));
    this.jdField_a_of_type_Qhw.a("", this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_d_of_type_JavaLangString, 2, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_Rmm.jdField_a_of_type_Rmi.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */