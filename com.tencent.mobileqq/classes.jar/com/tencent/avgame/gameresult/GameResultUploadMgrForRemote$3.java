package com.tencent.avgame.gameresult;

import com.tencent.qphone.base.util.QLog;
import mzn;
import mzq;

public class GameResultUploadMgrForRemote$3
  implements Runnable
{
  public GameResultUploadMgrForRemote$3(mzn parammzn, mzq parammzq, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Mzq.jdField_b_of_type_Boolean = true;
    if (QLog.isDevelopLevel()) {
      QLog.i("GameResultUploadMgrForRemote_GameRC", 1, this.jdField_a_of_type_JavaLangString + " upload video");
    }
    mzn.a(this.this$0, this.this$0.a, this.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Mzq.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.3
 * JD-Core Version:    0.7.0.1
 */