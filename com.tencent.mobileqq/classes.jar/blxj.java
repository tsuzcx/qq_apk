import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class blxj
  implements Observer<blwu>
{
  blxj(blxg paramblxg) {}
  
  public void a(@Nullable blwu paramblwu)
  {
    blxg.a(this.a).a().removeObservers(blxg.a(this.a));
    blwu localblwu;
    if (paramblwu != null)
    {
      localblwu = paramblwu;
      if (paramblwu.jdField_a_of_type_JavaLangString != null) {}
    }
    else
    {
      localblwu = new blwu();
      localblwu.jdField_a_of_type_JavaLangString = "default";
    }
    paramblwu = (String)blxg.a(this.a).get(localblwu.jdField_a_of_type_JavaLangString);
    if (!localblwu.jdField_a_of_type_JavaLangString.equals("default")) {
      paramblwu = amtj.a(2131699148) + paramblwu + amtj.a(2131699141);
    }
    for (;;)
    {
      blxg.a(this.a).setText(paramblwu);
      if ((blxg.a(this.a).size() == 0) && (!blxg.a(this.a)))
      {
        blxg.a(this.a).addAll(localblwu.jdField_a_of_type_JavaUtilList);
        this.a.b();
        blxg.a(this.a, true);
      }
      return;
      paramblwu = amtj.a(2131699137);
      localblwu.jdField_a_of_type_JavaUtilList.addAll(blxg.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxj
 * JD-Core Version:    0.7.0.1
 */