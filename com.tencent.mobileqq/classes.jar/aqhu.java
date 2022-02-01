import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class aqhu
  extends bhyn
{
  public aqhu(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bhyo parambhyo)
  {
    String str = parambhyo.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onCancel pkgName = " + str);
    }
    this.a.a("Bubble_download_cancel", parambhyo.b(), str, 0L);
  }
  
  public void onDone(bhyo parambhyo)
  {
    long l = parambhyo.h - parambhyo.g;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onDone downloadTime = " + l);
    }
    this.a.a("Bubble_download_succ", parambhyo.b(), "pkgName", l);
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    String str = parambhyo.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onStart pkgName = " + str);
    }
    this.a.a("Bubble_download", parambhyo.b(), str, 0L);
    super.onStart(parambhyo);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhu
 * JD-Core Version:    0.7.0.1
 */