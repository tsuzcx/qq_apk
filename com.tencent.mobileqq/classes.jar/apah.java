import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

class apah
  implements apab
{
  apah(apad paramapad, apab paramapab) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Apab.a(paramInt, paramString);
    aozx.a(this.jdField_a_of_type_Apad.jdField_a_of_type_Aplh.a());
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Apad.b = paramString1;
    this.jdField_a_of_type_Apad.d = paramString2;
    apad.c(this.jdField_a_of_type_Apad);
    this.jdField_a_of_type_Apad.jdField_a_of_type_Int = this.jdField_a_of_type_Apad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPlayWithSavePath(20160714, this.jdField_a_of_type_Apad.b, apue.a(this.jdField_a_of_type_Apad.c), 0L, 0, this.jdField_a_of_type_Apad.c, 0);
    this.jdField_a_of_type_Apad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, this.jdField_a_of_type_Apad.jdField_a_of_type_Int, 6);
    paramString1 = this.jdField_a_of_type_Apad.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.buildPlayURLMp4(this.jdField_a_of_type_Apad.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Apad.hashCode() + "][" + this.jdField_a_of_type_Apad.jdField_a_of_type_Aplh.a() + "]getDiscPlayUrl, mPlayId[" + this.jdField_a_of_type_Apad.jdField_a_of_type_Int + "]");
    }
    this.jdField_a_of_type_Apab.a(paramString1, paramString2);
  }
  
  public void aC_()
  {
    this.jdField_a_of_type_Apab.aC_();
  }
  
  public void aD_()
  {
    this.jdField_a_of_type_Apab.aD_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apah
 * JD-Core Version:    0.7.0.1
 */