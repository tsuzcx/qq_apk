import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;

public final class bohb
  implements zxa<CLIENT.StSmartMatchMusicRsp>
{
  public bohb(zxa paramzxa, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    bnzb.b("AEEditorMusicHelper", "[requestRecommendedMusicList], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Zxa != null) {
      this.jdField_a_of_type_Zxa.onReceive(paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int i = (int)paramLong;
    if (paramBoolean) {
      i = 1000;
    }
    bnyh.a().a(i, l1 - l2 + "", "AEEditorMusicList", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohb
 * JD-Core Version:    0.7.0.1
 */