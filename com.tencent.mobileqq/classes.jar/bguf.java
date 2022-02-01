import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bguf
  implements bgui
{
  bguf(bgua parambgua) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.d = paramString;
      bgua.f(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131715145), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguf
 * JD-Core Version:    0.7.0.1
 */