import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;

class anbu
  extends bdbp
{
  anbu(anbt paramanbt) {}
  
  public boolean a(bdbk parambdbk)
  {
    String str = ThemeUtil.getCurrentThemeId();
    if (!parambdbk.a().equals(str)) {
      QQToast.a(this.a.app.getApplication(), amtj.a(2131713947), 4000).a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbu
 * JD-Core Version:    0.7.0.1
 */