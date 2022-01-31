import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class ayic
  extends ayia
{
  public ayic(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!ayrd.a(this.b)) {
      ayrd.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      ayrd.a("search", "contact", "contacts", 0, 0, new String[] { ayrd.a(this.b) });
    }
  }
  
  public CharSequence c()
  {
    if (ayrd.a(this.b)) {
      return alpo.a(2131702940);
    }
    return alpo.a(2131702907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayic
 * JD-Core Version:    0.7.0.1
 */