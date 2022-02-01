import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class azoz
  implements bhlk
{
  private WeakReference<aval> a;
  
  azoz(aval paramaval)
  {
    this.a = new WeakReference(paramaval);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aval localaval = (aval)this.a.get();
      if (localaval != null) {
        localaval.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileQZoneComponent", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azoz
 * JD-Core Version:    0.7.0.1
 */