import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;

public final class bpix
  implements aaav<CLIENT.StBatchGetMusicInfoRsp>
{
  public bpix(aaav paramaaav, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    bpam.b("AEEditorMusicHelper", "[requestDetailedMusicInfo], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Aaav != null) {
      this.jdField_a_of_type_Aaav.onReceive(paramBoolean, paramLong, paramString, paramStBatchGetMusicInfoRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int i = (int)paramLong;
    if (paramBoolean) {
      i = 1000;
    }
    bozr.a().a(i, l1 - l2 + "", "AEEditorMusicInfo", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpix
 * JD-Core Version:    0.7.0.1
 */