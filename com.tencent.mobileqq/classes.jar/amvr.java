import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager.LoadMusicStepListener;
import java.util.Iterator;
import java.util.List;

public class amvr
  implements Runnable
{
  public amvr(QIMMusicConfigManager paramQIMMusicConfigManager, int paramInt, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    Iterator localIterator = QIMMusicConfigManager.a(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager).iterator();
    while (localIterator.hasNext()) {
      ((QIMMusicConfigManager.LoadMusicStepListener)localIterator.next()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amvr
 * JD-Core Version:    0.7.0.1
 */