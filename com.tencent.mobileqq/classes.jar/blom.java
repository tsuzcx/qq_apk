import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;

public final class blom
  implements zac<CLIENT.StBatchGetMusicInfoRsp>
{
  public blom(zac paramzac, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    bljn.b("AEEditorMusicHelper", "[requestDetailedMusicInfo], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Zac != null) {
      this.jdField_a_of_type_Zac.a(paramBoolean, paramLong, paramString, paramStBatchGetMusicInfoRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    bliu.a().a((int)paramLong, l1 - l2 + "", "AEEditorMusicInfo", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blom
 * JD-Core Version:    0.7.0.1
 */