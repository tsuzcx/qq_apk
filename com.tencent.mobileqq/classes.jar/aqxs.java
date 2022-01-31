import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

class aqxs
  implements aqxm
{
  aqxs(aqxo paramaqxo, aqxm paramaqxm) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Aqxm.a(paramInt, paramString);
    aqxi.a(this.jdField_a_of_type_Aqxo.jdField_a_of_type_Arit.a());
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aqxo.b = paramString1;
    this.jdField_a_of_type_Aqxo.d = paramString2;
    aqxo.c(this.jdField_a_of_type_Aqxo);
    this.jdField_a_of_type_Aqxo.jdField_a_of_type_Int = this.jdField_a_of_type_Aqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPlayWithSavePath(20160714, this.jdField_a_of_type_Aqxo.b, arrr.a(this.jdField_a_of_type_Aqxo.c), 0L, 0, this.jdField_a_of_type_Aqxo.c, 0);
    this.jdField_a_of_type_Aqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, this.jdField_a_of_type_Aqxo.jdField_a_of_type_Int, 6);
    paramString1 = this.jdField_a_of_type_Aqxo.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.buildPlayURLMp4(this.jdField_a_of_type_Aqxo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aqxo.hashCode() + "][" + this.jdField_a_of_type_Aqxo.jdField_a_of_type_Arit.a() + "]getDiscPlayUrl, mPlayId[" + this.jdField_a_of_type_Aqxo.jdField_a_of_type_Int + "]");
    }
    this.jdField_a_of_type_Aqxm.a(paramString1, paramString2);
  }
  
  public void aG_()
  {
    this.jdField_a_of_type_Aqxm.aG_();
  }
  
  public void aH_()
  {
    this.jdField_a_of_type_Aqxm.aH_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxs
 * JD-Core Version:    0.7.0.1
 */