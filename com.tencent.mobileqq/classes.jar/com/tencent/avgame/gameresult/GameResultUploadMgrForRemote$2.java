package com.tencent.avgame.gameresult;

import com.tencent.mobileqq.app.QQAppInterface;

class GameResultUploadMgrForRemote$2
  implements Runnable
{
  GameResultUploadMgrForRemote$2(GameResultUploadMgrForRemote paramGameResultUploadMgrForRemote, String paramString1, GameResultUploadMgrForRemote.UploadInfo paramUploadInfo, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote$UploadInfo.a = true;
    GameResultUploadMgrForRemote.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, 0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.2
 * JD-Core Version:    0.7.0.1
 */