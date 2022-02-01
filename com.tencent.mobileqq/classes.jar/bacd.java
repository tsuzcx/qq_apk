import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bacd
  implements bide
{
  private WeakReference<avli> a;
  
  bacd(avli paramavli)
  {
    this.a = new WeakReference(paramavli);
  }
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      avli localavli = (avli)this.a.get();
      if (localavli != null) {
        localavli.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileQZoneComponent", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacd
 * JD-Core Version:    0.7.0.1
 */