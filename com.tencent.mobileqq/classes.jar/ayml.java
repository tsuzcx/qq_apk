import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class ayml
  extends aymj
{
  public ayml(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!ayvm.a(this.b)) {
      ayvm.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      ayvm.a("search", "contact", "contacts", 0, 0, new String[] { ayvm.a(this.b) });
    }
  }
  
  public CharSequence c()
  {
    if (ayvm.a(this.b)) {
      return alud.a(2131702952);
    }
    return alud.a(2131702919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayml
 * JD-Core Version:    0.7.0.1
 */