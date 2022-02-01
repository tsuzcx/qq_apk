import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class baxk
  extends baxi
{
  public baxk(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!bbgk.a(this.b)) {
      bbgk.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      bbgk.a("search", "contact", "contacts", 0, 0, new String[] { bbgk.a(this.b) });
    }
  }
  
  public CharSequence c()
  {
    if (bbgk.a(this.b)) {
      return amtj.a(2131701701);
    }
    return amtj.a(2131701668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxk
 * JD-Core Version:    0.7.0.1
 */