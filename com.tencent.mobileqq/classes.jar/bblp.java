import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class bblp
  extends bbln
{
  public bblp(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!bbup.a(this.b)) {
      bbup.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      bbup.a("search", "contact", "contacts", 0, 0, new String[] { bbup.a(this.b) });
    }
  }
  
  public CharSequence c()
  {
    if (bbup.a(this.b)) {
      return anni.a(2131701359);
    }
    return anni.a(2131701326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblp
 * JD-Core Version:    0.7.0.1
 */