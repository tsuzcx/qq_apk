import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;

public final class bohc
  implements zxa<CLIENT.StBatchGetMusicInfoRsp>
{
  public bohc(zxa paramzxa, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    bnzb.b("AEEditorMusicHelper", "[requestDetailedMusicInfo], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Zxa != null) {
      this.jdField_a_of_type_Zxa.onReceive(paramBoolean, paramLong, paramString, paramStBatchGetMusicInfoRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int i = (int)paramLong;
    if (paramBoolean) {
      i = 1000;
    }
    bnyh.a().a(i, l1 - l2 + "", "AEEditorMusicInfo", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohc
 * JD-Core Version:    0.7.0.1
 */