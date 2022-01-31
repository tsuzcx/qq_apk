import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

class aqtj
  implements aqtd
{
  aqtj(aqtf paramaqtf, aqtd paramaqtd) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Aqtd.a(paramInt, paramString);
    aqsz.a(this.jdField_a_of_type_Aqtf.jdField_a_of_type_Arek.a());
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aqtf.b = paramString1;
    this.jdField_a_of_type_Aqtf.d = paramString2;
    aqtf.c(this.jdField_a_of_type_Aqtf);
    this.jdField_a_of_type_Aqtf.jdField_a_of_type_Int = this.jdField_a_of_type_Aqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPlayWithSavePath(20160714, this.jdField_a_of_type_Aqtf.b, arni.a(this.jdField_a_of_type_Aqtf.c), 0L, 0, this.jdField_a_of_type_Aqtf.c, 0);
    this.jdField_a_of_type_Aqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, this.jdField_a_of_type_Aqtf.jdField_a_of_type_Int, 6);
    paramString1 = this.jdField_a_of_type_Aqtf.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.buildPlayURLMp4(this.jdField_a_of_type_Aqtf.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aqtf.hashCode() + "][" + this.jdField_a_of_type_Aqtf.jdField_a_of_type_Arek.a() + "]getDiscPlayUrl, mPlayId[" + this.jdField_a_of_type_Aqtf.jdField_a_of_type_Int + "]");
    }
    this.jdField_a_of_type_Aqtd.a(paramString1, paramString2);
  }
  
  public void aJ_()
  {
    this.jdField_a_of_type_Aqtd.aJ_();
  }
  
  public void aK_()
  {
    this.jdField_a_of_type_Aqtd.aK_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtj
 * JD-Core Version:    0.7.0.1
 */