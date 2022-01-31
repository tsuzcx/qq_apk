import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;

public class awhk
  extends awig
{
  private SearchHistory a;
  
  public awhk(QQAppInterface paramQQAppInterface, SearchHistory paramSearchHistory)
  {
    this.a = paramSearchHistory;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public SearchHistory a()
  {
    return this.a;
  }
  
  public String a()
  {
    return this.a.extralInfo;
  }
  
  public void a(String paramString) {}
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    return null;
  }
  
  public int c()
  {
    switch (this.a.type)
    {
    default: 
    case 3000: 
    case 1: 
    case 1006: 
    case 56938: 
    case 1008: 
      do
      {
        return 1;
        return 101;
        return 4;
        return 11;
      } while (!TextUtils.equals(this.a.uin, ajsf.az));
      return 110;
    }
    return 111;
  }
  
  public String c()
  {
    return this.a.displayName;
  }
  
  public String d()
  {
    return this.a.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhk
 * JD-Core Version:    0.7.0.1
 */