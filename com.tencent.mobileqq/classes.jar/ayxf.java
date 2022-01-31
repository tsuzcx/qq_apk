import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class ayxf
  extends ayta
{
  private View jdField_a_of_type_AndroidViewView;
  private ayxg jdField_a_of_type_Ayxg;
  
  public ayxf(ayso paramayso, Context paramContext)
  {
    super(paramayso, paramContext);
  }
  
  private void a()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RichTemplateOneSearchResultView", 2, "data->" + str);
      }
      this.jdField_a_of_type_Ayxg.a();
      this.jdField_a_of_type_Ayxg.a(str);
      this.jdField_a_of_type_Ayxg.b();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RichTemplateOneSearchResultView", 2, "empty data");
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559675, null, false);
    this.jdField_a_of_type_Ayxg.a(this.jdField_a_of_type_AndroidViewView);
  }
  
  public View a(Context paramContext)
  {
    this.jdField_a_of_type_Ayxg = new ayxg(paramContext);
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
 * Qualified Name:     ayxf
 * JD-Core Version:    0.7.0.1
 */