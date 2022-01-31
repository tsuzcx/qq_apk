import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;

public class aopg
  implements ShortVideoResourceManager.INet_ShortVideoResource
{
  private String a;
  
  public void C_()
  {
    VideoEnvironment.a(this.a, "onNetWorkNone...", null);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    VideoEnvironment.a(this.a, "onDownloadFinish| name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
    if (paramString1.startsWith("new_qq_android_native_art_filter_"))
    {
      SoLoader.a(BaseApplicationImpl.getContext());
      ((CaptureComboManager)QIMManager.a().c(5)).e();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    VideoEnvironment.a(this.a, "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aopg
 * JD-Core Version:    0.7.0.1
 */