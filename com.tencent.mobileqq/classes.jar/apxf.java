import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class apxf
  extends bhhe
{
  public apxf(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bhhf parambhhf)
  {
    String str = parambhhf.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onCancel pkgName = " + str);
    }
    this.a.a("Bubble_download_cancel", parambhhf.b(), str, 0L);
  }
  
  public void onDone(bhhf parambhhf)
  {
    long l = parambhhf.h - parambhhf.g;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onDone downloadTime = " + l);
    }
    this.a.a("Bubble_download_succ", parambhhf.b(), "pkgName", l);
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    String str = parambhhf.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onStart pkgName = " + str);
    }
    this.a.a("Bubble_download", parambhhf.b(), str, 0L);
    super.onStart(parambhhf);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxf
 * JD-Core Version:    0.7.0.1
 */