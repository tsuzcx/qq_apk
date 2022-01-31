import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;

public final class bljz
  implements yvn<CLIENT.StSmartMatchMusicRsp>
{
  public bljz(yvn paramyvn, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    blfg.b("AEEditorMusicHelper", "[requestRecommendedMusicList], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Yvn != null) {
      this.jdField_a_of_type_Yvn.a(paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    blen.a().a((int)paramLong, l1 - l2 + "", "AEEditorMusicList", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljz
 * JD-Core Version:    0.7.0.1
 */