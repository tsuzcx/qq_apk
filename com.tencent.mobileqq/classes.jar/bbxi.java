import com.tencent.image.URLDrawable.DownloadListener;

class bbxi
  implements URLDrawable.DownloadListener
{
  bbxi(bbxf parambbxf) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    bbxf.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxi
 * JD-Core Version:    0.7.0.1
 */