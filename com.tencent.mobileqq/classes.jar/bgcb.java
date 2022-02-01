import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bgcb
  implements bgce
{
  bgcb(bgbw parambgbw) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.d = paramString;
      bgbw.f(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, anni.a(2131714456), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcb
 * JD-Core Version:    0.7.0.1
 */