package com.tencent.avgame.gameresult;

import com.tencent.common.app.business.BaseQQAppInterface;

class GameResultUploadMgrForRemote$2
  implements Runnable
{
  GameResultUploadMgrForRemote$2(GameResultUploadMgrForRemote paramGameResultUploadMgrForRemote, String paramString1, GameResultUploadMgrForRemote.UploadInfo paramUploadInfo, BaseQQAppInterface paramBaseQQAppInterface, String paramString2) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameresultGameResultUploadMgrForRemote$UploadInfo.a = true;
    GameResultUploadMgrForRemote.a(this.this$0, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.b, 0, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.2
 * JD-Core Version:    0.7.0.1
 */