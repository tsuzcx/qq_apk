import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ayxg
  implements bgso
{
  private WeakReference<aufo> a;
  
  ayxg(aufo paramaufo)
  {
    this.a = new WeakReference(paramaufo);
  }
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aufo localaufo = (aufo)this.a.get();
      if (localaufo != null) {
        localaufo.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileQZoneComponent", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxg
 * JD-Core Version:    0.7.0.1
 */