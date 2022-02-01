import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ListView;

public class asgk
  extends asnw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private avse jdField_a_of_type_Avse;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String b;
  
  public asgk(QQAppInterface paramQQAppInterface, Context paramContext, avse paramavse)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Avse = paramavse;
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
  
  public void a(ListView paramListView, aslt paramaslt)
  {
    b(paramListView, paramaslt);
    paramaslt = b();
    if (paramaslt.getParent() == null) {
      paramListView.addFooterView(paramaslt);
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
    this.jdField_a_of_type_Avse.n();
  }
  
  public void c()
  {
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgk
 * JD-Core Version:    0.7.0.1
 */