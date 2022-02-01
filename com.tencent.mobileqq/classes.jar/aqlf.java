import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class aqlf
  extends biht
{
  public aqlf(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bihu parambihu)
  {
    String str = parambihu.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onCancel pkgName = " + str);
    }
    this.a.a("Bubble_download_cancel", parambihu.b(), str, 0L);
  }
  
  public void onDone(bihu parambihu)
  {
    long l = parambihu.h - parambihu.g;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onDone downloadTime = " + l);
    }
    this.a.a("Bubble_download_succ", parambihu.b(), "pkgName", l);
  }
  
  public boolean onStart(bihu parambihu)
  {
    String str = parambihu.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onStart pkgName = " + str);
    }
    this.a.a("Bubble_download", parambihu.b(), str, 0L);
    super.onStart(parambihu);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlf
 * JD-Core Version:    0.7.0.1
 */