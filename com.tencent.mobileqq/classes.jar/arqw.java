import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ListView;

public class arqw
  extends aryi
{
  private Context jdField_a_of_type_AndroidContentContext;
  private avad jdField_a_of_type_Avad;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String b;
  
  public arqw(QQAppInterface paramQQAppInterface, Context paramContext, avad paramavad)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Avad = paramavad;
  }
  
  public int a()
  {
    return 2;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public String a()
  {
    return "RichTextPanelEmoticonSearchLayoutHelper";
  }
  
  public void a() {}
  
  public void a(ListView paramListView, arwf paramarwf)
  {
    b(paramListView, paramarwf);
    paramarwf = b();
    if (paramarwf.getParent() == null) {
      paramListView.addFooterView(paramarwf);
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Avad.n();
  }
  
  public void c()
  {
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqw
 * JD-Core Version:    0.7.0.1
 */