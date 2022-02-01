import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class apeq
  extends bgod
{
  public apeq(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bgoe parambgoe)
  {
    String str = parambgoe.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onCancel pkgName = " + str);
    }
    this.a.a("Bubble_download_cancel", parambgoe.b(), str, 0L);
  }
  
  public void onDone(bgoe parambgoe)
  {
    long l = parambgoe.h - parambgoe.g;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onDone downloadTime = " + l);
    }
    this.a.a("Bubble_download_succ", parambgoe.b(), "pkgName", l);
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    String str = parambgoe.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onStart pkgName = " + str);
    }
    this.a.a("Bubble_download", parambgoe.b(), str, 0L);
    super.onStart(parambgoe);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apeq
 * JD-Core Version:    0.7.0.1
 */