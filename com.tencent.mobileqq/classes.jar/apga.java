import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public abstract class apga
  extends awoj
{
  protected int a;
  protected Bundle a;
  protected String a;
  
  public apga(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<awoi> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return new ArrayList(0);
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(View paramView)
  {
    int i = d();
    if (i == 1) {
      if (paramView.getId() == 2131366211) {
        b(paramView);
      }
    }
    while (i <= 1)
    {
      return;
      c(paramView);
      return;
    }
    d(paramView);
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected abstract void b(View paramView);
  
  public abstract boolean b();
  
  public abstract String c();
  
  protected abstract void c(View paramView);
  
  public int d()
  {
    return 0;
  }
  
  public abstract String d();
  
  protected abstract void d(View paramView);
  
  public abstract int e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apga
 * JD-Core Version:    0.7.0.1
 */