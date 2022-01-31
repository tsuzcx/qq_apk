import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;

class amdk
  extends baot
{
  amdk(amdj paramamdj) {}
  
  public boolean a(baoo parambaoo)
  {
    String str = ThemeUtil.getCurrentThemeId();
    if (!parambaoo.a().equals(str)) {
      QQToast.a(this.a.app.getApplication(), alud.a(2131715307), 4000).a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdk
 * JD-Core Version:    0.7.0.1
 */