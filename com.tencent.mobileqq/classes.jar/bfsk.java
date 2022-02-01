import com.tencent.image.URLDrawable.DownloadListener;

class bfsk
  implements URLDrawable.DownloadListener
{
  bfsk(bfsh parambfsh) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    bfsh.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsk
 * JD-Core Version:    0.7.0.1
 */