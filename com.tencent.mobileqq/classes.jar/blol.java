import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;

public final class blol
  implements zac<CLIENT.StSmartMatchMusicRsp>
{
  public blol(zac paramzac, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    bljn.b("AEEditorMusicHelper", "[requestRecommendedMusicList], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Zac != null) {
      this.jdField_a_of_type_Zac.a(paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    bliu.a().a((int)paramLong, l1 - l2 + "", "AEEditorMusicList", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blol
 * JD-Core Version:    0.7.0.1
 */