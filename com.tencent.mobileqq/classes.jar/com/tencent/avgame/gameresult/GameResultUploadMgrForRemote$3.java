package com.tencent.avgame.gameresult;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.qphone.base.util.QLog;

class GameResultUploadMgrForRemote$3
  implements Runnable
{
  GameResultUploadMgrForRemote$3(GameResultUploadMgrForRemote paramGameResultUploadMgrForRemote, GameResultUploadMgrForRemote.UploadInfo paramUploadInfo, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote$UploadInfo.jdField_b_of_type_JavaLangString == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote$UploadInfo.jdField_b_of_type_Boolean = true;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" upload video");
      QLog.i("GameResultUploadMgrForRemote_GameRC", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = GameResultUploadMgrForRemote.a(this.this$0);
    if (localObject != null) {
      GameResultUploadMgrForRemote.a(this.this$0, (BaseQQAppInterface)localObject, this.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote$UploadInfo.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.3
 * JD-Core Version:    0.7.0.1
 */