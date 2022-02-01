import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class bote
  implements Observer<bosp>
{
  bote(botb parambotb) {}
  
  public void a(@Nullable bosp parambosp)
  {
    botb.a(this.a).a().removeObservers(botb.a(this.a));
    bosp localbosp;
    if (parambosp != null)
    {
      localbosp = parambosp;
      if (parambosp.jdField_a_of_type_JavaLangString != null) {}
    }
    else
    {
      localbosp = new bosp();
      localbosp.jdField_a_of_type_JavaLangString = "default";
    }
    parambosp = (String)botb.a(this.a).get(localbosp.jdField_a_of_type_JavaLangString);
    if (!localbosp.jdField_a_of_type_JavaLangString.equals("default")) {
      parambosp = anzj.a(2131698913) + parambosp + anzj.a(2131698906);
    }
    for (;;)
    {
      botb.a(this.a).setText(parambosp);
      if ((botb.a(this.a).size() == 0) && (!botb.a(this.a)))
      {
        botb.a(this.a).addAll(localbosp.jdField_a_of_type_JavaUtilList);
        this.a.b();
        botb.a(this.a, true);
      }
      return;
      parambosp = anzj.a(2131698902);
      localbosp.jdField_a_of_type_JavaUtilList.addAll(botb.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bote
 * JD-Core Version:    0.7.0.1
 */