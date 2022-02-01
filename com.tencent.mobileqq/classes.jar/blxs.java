import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class blxs
  implements View.OnClickListener
{
  blxs(blxr paramblxr, blxt paramblxt, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (blxr.a(this.jdField_a_of_type_Blxr) != this.jdField_a_of_type_Blxt.getLayoutPosition()) {
      bmbc.a().i(this.jdField_a_of_type_JavaLangString);
    }
    if ((blxr.a(this.jdField_a_of_type_Blxr) == -1) && (TextUtils.isEmpty(blxr.a(this.jdField_a_of_type_Blxr).a())))
    {
      blxr.a(this.jdField_a_of_type_Blxr).a(this.jdField_a_of_type_JavaLangString, ((blxe)blxd.a.get(0)).jdField_a_of_type_JavaLangString, ((blxe)blxd.a.get(0)).b);
      blxr.a(this.jdField_a_of_type_Blxr).a(true, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Blxr.a();
      blxr.a(this.jdField_a_of_type_Blxr, this.jdField_a_of_type_Blxt.getLayoutPosition());
      ((blxc)blxr.a(this.jdField_a_of_type_Blxr).get(blxr.a(this.jdField_a_of_type_Blxr) - 1)).a(true);
      this.jdField_a_of_type_Blxt.a(true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      blxr.a(this.jdField_a_of_type_Blxr).a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxs
 * JD-Core Version:    0.7.0.1
 */