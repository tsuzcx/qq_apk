import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;

public class arvg
  extends asbj
{
  public arvg(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity) {}
  
  protected void onZipImageThumbDownloadCompleted(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvg
 * JD-Core Version:    0.7.0.1
 */