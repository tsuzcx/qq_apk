import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;

class bkir
  implements MediaScanner.OnMediaInfoScannerListener
{
  bkir(bkil parambkil) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.a.a(101);
      return;
    }
    this.a.a(this.a.a, paramLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkir
 * JD-Core Version:    0.7.0.1
 */