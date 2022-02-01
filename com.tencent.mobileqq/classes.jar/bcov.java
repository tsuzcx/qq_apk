import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class bcov
  extends bckq
{
  private View jdField_a_of_type_AndroidViewView;
  private bcow jdField_a_of_type_Bcow;
  
  public bcov(bcke parambcke, Context paramContext)
  {
    super(parambcke, paramContext);
  }
  
  private void a()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RichTemplateOneSearchResultView", 2, "data->" + str);
      }
      this.jdField_a_of_type_Bcow.a();
      this.jdField_a_of_type_Bcow.a(str);
      this.jdField_a_of_type_Bcow.b();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RichTemplateOneSearchResultView", 2, "empty data");
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559864, null, false);
    this.jdField_a_of_type_Bcow.a(this.jdField_a_of_type_AndroidViewView);
  }
  
  public View a(Context paramContext)
  {
    this.jdField_a_of_type_Bcow = new bcow(paramContext);
    b(paramContext);
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void e()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcov
 * JD-Core Version:    0.7.0.1
 */