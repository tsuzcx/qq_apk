import androidx.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;

class bkjq
  extends bkjn
{
  bkjq(bkjp parambkjp) {}
  
  public void a()
  {
    bkjp.a(this.a, null);
    if (!this.a.c()) {
      bkjp.a(this.a);
    }
  }
  
  @UiThread
  public void a(String paramString, bkjt parambkjt)
  {
    if (parambkjt == null)
    {
      QLog.i("IliveGroupTipsBarHelper", 1, "handleIliveGroupData entity request error");
      return;
    }
    bkjp.a(this.a, parambkjt);
    StringBuilder localStringBuilder = new StringBuilder().append("handleIliveGroupData ");
    if (bkjp.a(this.a) == null)
    {
      parambkjt = " data = null";
      QLog.i("IliveGroupTipsBarHelper", 1, parambkjt + " source = " + paramString);
      if ((bkjp.a(this.a) == null) || (!bkjp.a(this.a).a)) {
        break label151;
      }
    }
    label151:
    for (boolean bool = true;; bool = false)
    {
      bkjp.a(this.a, bool);
      if (bool) {
        break label156;
      }
      this.a.c();
      return;
      parambkjt = " value = " + bkjp.a(this.a).toString();
      break;
    }
    label156:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjq
 * JD-Core Version:    0.7.0.1
 */