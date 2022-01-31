import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

class aojn
  implements aojh
{
  aojn(aojj paramaojj, aojh paramaojh) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Aojh.a(paramInt, paramString);
    aojd.a(this.jdField_a_of_type_Aojj.jdField_a_of_type_Aotv.a());
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aojj.b = paramString1;
    this.jdField_a_of_type_Aojj.d = paramString2;
    aojj.c(this.jdField_a_of_type_Aojj);
    this.jdField_a_of_type_Aojj.jdField_a_of_type_Int = this.jdField_a_of_type_Aojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPlayWithSavePath(20160714, this.jdField_a_of_type_Aojj.b, apck.a(this.jdField_a_of_type_Aojj.c), 0L, 0, this.jdField_a_of_type_Aojj.c, 0);
    this.jdField_a_of_type_Aojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, this.jdField_a_of_type_Aojj.jdField_a_of_type_Int, 6);
    paramString1 = this.jdField_a_of_type_Aojj.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.buildPlayURLMp4(this.jdField_a_of_type_Aojj.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aojj.hashCode() + "][" + this.jdField_a_of_type_Aojj.jdField_a_of_type_Aotv.a() + "]getDiscPlayUrl, mPlayId[" + this.jdField_a_of_type_Aojj.jdField_a_of_type_Int + "]");
    }
    this.jdField_a_of_type_Aojh.a(paramString1, paramString2);
  }
  
  public void aF_()
  {
    this.jdField_a_of_type_Aojh.aF_();
  }
  
  public void aG_()
  {
    this.jdField_a_of_type_Aojh.aG_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aojn
 * JD-Core Version:    0.7.0.1
 */