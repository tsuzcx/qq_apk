import com.tencent.image.URLDrawable.DownloadListener;

class bgbz
  implements URLDrawable.DownloadListener
{
  bgbz(bgbw parambgbw) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    bgbw.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbz
 * JD-Core Version:    0.7.0.1
 */