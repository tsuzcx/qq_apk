import android.view.View;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class asra
  implements asrd
{
  public asra(HotVideoMongoliaRelativeLayout paramHotVideoMongoliaRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.hotpic.HotPicPageView.b = true;
    if ((this.a.jdField_a_of_type_Int == 2) && (this.a.jdField_a_of_type_Asrg != null))
    {
      this.a.jdField_a_of_type_Asrg.a(0, paramView);
      return;
    }
    if ((this.a.jdField_a_of_type_Int == 3) && (this.a.jdField_a_of_type_Asrg != null)) {
      this.a.jdField_a_of_type_Asrg.a(4, paramView);
    }
    for (;;)
    {
      QLog.d("HotVideoRelativeLayout", 2, "click base view");
      return;
      if ((this.a.jdField_a_of_type_Int == 4) && (this.a.jdField_a_of_type_Asrg != null)) {
        this.a.jdField_a_of_type_Asrg.a(1, paramView);
      } else if ((this.a.jdField_a_of_type_Int == 6) && (this.a.jdField_a_of_type_Asrg != null)) {
        this.a.jdField_a_of_type_Asrg.a(2, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asra
 * JD-Core Version:    0.7.0.1
 */