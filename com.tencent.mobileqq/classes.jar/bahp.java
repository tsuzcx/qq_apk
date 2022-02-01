import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bahp
  implements bimf
{
  private WeakReference<avsm> a;
  
  bahp(avsm paramavsm)
  {
    this.a = new WeakReference(paramavsm);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      avsm localavsm = (avsm)this.a.get();
      if (localavsm != null) {
        localavsm.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileQZoneComponent", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahp
 * JD-Core Version:    0.7.0.1
 */