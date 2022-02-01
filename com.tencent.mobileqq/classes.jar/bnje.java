import dov.com.qq.im.ae.cmshow.AECMShowResourceManager.1;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class bnje
  implements bnuy
{
  public bnje(AECMShowResourceManager.1 param1, String paramString, HashMap paramHashMap, AEEditorDownloadResBean paramAEEditorDownloadResBean, boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bnrh.a("AECMShowResourceManager", "[downloadEssentialResource], resId=" + this.jdField_a_of_type_JavaLangString + ", download succeeded");
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, bnjd.b(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowResourceManager$1.this$0, this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
      bnrh.a("AECMShowResourceManager", "[downloadEssentialResource], resId=" + this.jdField_a_of_type_JavaLangString + ", download failed");
      this.jdField_a_of_type_ArrayOfBoolean[0] = false;
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnje
 * JD-Core Version:    0.7.0.1
 */