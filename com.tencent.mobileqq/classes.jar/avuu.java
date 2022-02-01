import android.view.View;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class avuu
  implements avux
{
  public avuu(HotVideoMongoliaRelativeLayout paramHotVideoMongoliaRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.hotpic.HotPicPageView.b = true;
    if ((this.a.jdField_a_of_type_Int == 2) && (this.a.jdField_a_of_type_Avva != null))
    {
      this.a.jdField_a_of_type_Avva.a(0, paramView);
      return;
    }
    if ((this.a.jdField_a_of_type_Int == 3) && (this.a.jdField_a_of_type_Avva != null)) {
      this.a.jdField_a_of_type_Avva.a(4, paramView);
    }
    for (;;)
    {
      QLog.d("HotVideoRelativeLayout", 2, "click base view");
      return;
      if ((this.a.jdField_a_of_type_Int == 4) && (this.a.jdField_a_of_type_Avva != null)) {
        this.a.jdField_a_of_type_Avva.a(1, paramView);
      } else if ((this.a.jdField_a_of_type_Int == 6) && (this.a.jdField_a_of_type_Avva != null)) {
        this.a.jdField_a_of_type_Avva.a(2, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avuu
 * JD-Core Version:    0.7.0.1
 */