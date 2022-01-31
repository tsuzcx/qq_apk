import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class awmz
  extends awmx
{
  public awmz(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!awwa.a(this.b)) {
      awwa.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      awwa.a("search", "contact", "contacts", 0, 0, new String[] { awwa.a(this.b) });
    }
  }
  
  public CharSequence c()
  {
    if (awwa.a(this.b)) {
      return ajya.a(2131702568);
    }
    return ajya.a(2131702535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmz
 * JD-Core Version:    0.7.0.1
 */