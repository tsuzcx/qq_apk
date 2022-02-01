import androidx.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;

class blvd
  extends blva
{
  blvd(blvc paramblvc) {}
  
  public void a()
  {
    blvc.a(this.a, null);
    if (!this.a.c()) {
      blvc.a(this.a);
    }
  }
  
  @UiThread
  public void a(String paramString, blvg paramblvg)
  {
    if (paramblvg == null)
    {
      QLog.i("IliveGroupTipsBarHelper", 1, "handleIliveGroupData entity request error");
      return;
    }
    blvc.a(this.a, paramblvg);
    StringBuilder localStringBuilder = new StringBuilder().append("handleIliveGroupData ");
    if (blvc.a(this.a) == null)
    {
      paramblvg = " data = null";
      QLog.i("IliveGroupTipsBarHelper", 1, paramblvg + " source = " + paramString);
      if ((blvc.a(this.a) == null) || (!blvc.a(this.a).a)) {
        break label151;
      }
    }
    label151:
    for (boolean bool = true;; bool = false)
    {
      blvc.a(this.a, bool);
      if (bool) {
        break label156;
      }
      this.a.c();
      return;
      paramblvg = " value = " + blvc.a(this.a).toString();
      break;
    }
    label156:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvd
 * JD-Core Version:    0.7.0.1
 */