import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class awmx
  extends awmv
{
  public awmx(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!awvy.a(this.b)) {
      awvy.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      awvy.a("search", "contact", "contacts", 0, 0, new String[] { awvy.a(this.b) });
    }
  }
  
  public CharSequence c()
  {
    if (awvy.a(this.b)) {
      return ajyc.a(2131702557);
    }
    return ajyc.a(2131702524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmx
 * JD-Core Version:    0.7.0.1
 */