import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atmd
  implements View.OnClickListener
{
  public atmd(ForwardFileOption paramForwardFileOption, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption.l = true;
    ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmd
 * JD-Core Version:    0.7.0.1
 */