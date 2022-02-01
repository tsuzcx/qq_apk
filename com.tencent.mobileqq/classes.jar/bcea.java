import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class bcea
  extends bcdy
{
  public bcea(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!bcnc.a(this.b)) {
      bcnc.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      bcnc.a("search", "contact", "contacts", 0, 0, new String[] { bcnc.a(this.b) });
    }
  }
  
  public CharSequence c()
  {
    if (bcnc.a(this.b)) {
      return anvx.a(2131702052);
    }
    return anvx.a(2131702019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcea
 * JD-Core Version:    0.7.0.1
 */