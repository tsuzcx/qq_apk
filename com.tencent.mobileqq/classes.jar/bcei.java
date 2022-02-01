import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class bcei
  extends bceg
{
  public bcei(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!bcni.a(this.b)) {
      bcni.a(paramView, this);
    }
    if (SearchConfigManager.needSeparate) {
      bcni.a("search", "contact", "contacts", 0, 0, new String[] { bcni.a(this.b) });
    }
  }
  
  public CharSequence c()
  {
    if (bcni.a(this.b)) {
      return anzj.a(2131701466);
    }
    return anzj.a(2131701433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcei
 * JD-Core Version:    0.7.0.1
 */