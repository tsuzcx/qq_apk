import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class bflp
  implements bflr
{
  bflp(bflj parambflj) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.d = paramString;
      bflj.e(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, amtj.a(2131714800), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflp
 * JD-Core Version:    0.7.0.1
 */