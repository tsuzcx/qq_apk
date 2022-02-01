import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;

public final class bpiw
  implements aaav<CLIENT.StSmartMatchMusicRsp>
{
  public bpiw(aaav paramaaav, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    bpam.b("AEEditorMusicHelper", "[requestRecommendedMusicList], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Aaav != null) {
      this.jdField_a_of_type_Aaav.onReceive(paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int i = (int)paramLong;
    if (paramBoolean) {
      i = 1000;
    }
    bozr.a().a(i, l1 - l2 + "", "AEEditorMusicList", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpiw
 * JD-Core Version:    0.7.0.1
 */