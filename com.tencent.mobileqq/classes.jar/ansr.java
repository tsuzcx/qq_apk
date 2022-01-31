import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class ansr
  extends bdvu
{
  public ansr(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bdvv parambdvv)
  {
    String str = parambdvv.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onCancel pkgName = " + str);
    }
    this.a.a("Bubble_download_cancel", parambdvv.b(), str, 0L);
  }
  
  public void onDone(bdvv parambdvv)
  {
    long l = parambdvv.h - parambdvv.g;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onDone downloadTime = " + l);
    }
    this.a.a("Bubble_download_succ", parambdvv.b(), "pkgName", l);
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    String str = parambdvv.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onStart pkgName = " + str);
    }
    this.a.a("Bubble_download", parambdvv.b(), str, 0L);
    super.onStart(parambdvv);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansr
 * JD-Core Version:    0.7.0.1
 */