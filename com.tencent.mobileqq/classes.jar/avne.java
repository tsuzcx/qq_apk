import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class avne
  extends avnc
{
  public avne(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!avwf.a(this.b)) {
      avwf.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      avwf.a("search", "contact", "contacts", 0, 0, new String[] { avwf.a(this.b) });
    }
  }
  
  public CharSequence c()
  {
    if (avwf.a(this.b)) {
      return ajjy.a(2131636773);
    }
    return ajjy.a(2131636740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avne
 * JD-Core Version:    0.7.0.1
 */