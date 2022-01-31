import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.4;
import java.util.concurrent.CountDownLatch;

public class bljk
  implements bljm
{
  public bljk(AEEditorFiltersManager.4 param4, int paramInt, AEEditorDownloadResBean paramAEEditorDownloadResBean, CountDownLatch paramCountDownLatch) {}
  
  public void a(boolean paramBoolean)
  {
    blfg.b("AEEditorFiltersManager", "preDownloadAllRes---[finish] " + this.jdField_a_of_type_Int + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljk
 * JD-Core Version:    0.7.0.1
 */