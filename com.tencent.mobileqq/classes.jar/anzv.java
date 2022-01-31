import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator;

public class anzv
  implements Runnable
{
  public anzv(DoodleTextureView paramDoodleTextureView) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.g();
      PersonalityOperator localPersonalityOperator = (PersonalityOperator)this.a.a.a(102);
      if (localPersonalityOperator != null) {
        localPersonalityOperator.b();
      }
      this.a.a = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleTextureView", 2, "onDestroy end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzv
 * JD-Core Version:    0.7.0.1
 */