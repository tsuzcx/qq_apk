package com.tencent.avgame.gameresult;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class GameResultUploadMgrForRemote$3
  implements Runnable
{
  GameResultUploadMgrForRemote$3(GameResultUploadMgrForRemote paramGameResultUploadMgrForRemote, GameResultUploadMgrForRemote.UploadInfo paramUploadInfo, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote$UploadInfo.jdField_b_of_type_JavaLangString == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote$UploadInfo.jdField_b_of_type_Boolean = true;
      if (QLog.isDevelopLevel()) {
        QLog.i("GameResultUploadMgrForRemote_GameRC", 1, this.jdField_a_of_type_JavaLangString + " upload video");
      }
      localQQAppInterface = GameResultUploadMgrForRemote.a(this.this$0);
    } while (localQQAppInterface == null);
    GameResultUploadMgrForRemote.a(this.this$0, localQQAppInterface, this.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote$UploadInfo.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.3
 * JD-Core Version:    0.7.0.1
 */