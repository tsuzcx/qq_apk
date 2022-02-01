package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import rgj;
import scn;
import txj;

public class CompressVideoTaskStep$1$1
  implements Runnable
{
  public CompressVideoTaskStep$1$1(rgj paramrgj, int paramInt, String paramString, scn paramscn) {}
  
  public void run()
  {
    QLog.i("RIJUGC.CompressVideoTaskStep", 1, "onCompressFinished, retCode =" + this.jdField_a_of_type_Int + ",outPath = " + this.jdField_a_of_type_JavaLangString);
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      str1 = str2;
      if (!this.jdField_a_of_type_JavaLangString.isEmpty()) {
        str1 = txj.a(new File(this.jdField_a_of_type_JavaLangString));
      }
    }
    QLog.i("RIJUGC.CompressVideoTaskStep", 1, "get Md5, md5=" + str1);
    ThreadManagerV2.getUIHandlerV2().post(new CompressVideoTaskStep.1.1.1(this, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.CompressVideoTaskStep.1.1
 * JD-Core Version:    0.7.0.1
 */