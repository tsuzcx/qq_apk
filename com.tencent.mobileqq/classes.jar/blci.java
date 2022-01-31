import android.support.annotation.Nullable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class blci
  implements bmeo<blbt>
{
  blci(blcf paramblcf) {}
  
  public void a(@Nullable blbt paramblbt)
  {
    blcf.a(this.a).a().a(blcf.a(this.a));
    blbt localblbt;
    if (paramblbt != null)
    {
      localblbt = paramblbt;
      if (paramblbt.jdField_a_of_type_JavaLangString != null) {}
    }
    else
    {
      localblbt = new blbt();
      localblbt.jdField_a_of_type_JavaLangString = "default";
    }
    paramblbt = (String)blcf.a(this.a).get(localblbt.jdField_a_of_type_JavaLangString);
    if (!localblbt.jdField_a_of_type_JavaLangString.equals("default")) {
      paramblbt = alud.a(2131700380) + paramblbt + alud.a(2131700373);
    }
    for (;;)
    {
      blcf.a(this.a).setText(paramblbt);
      if ((blcf.a(this.a).size() == 0) && (!blcf.a(this.a)))
      {
        blcf.a(this.a).addAll(localblbt.jdField_a_of_type_JavaUtilList);
        this.a.b();
        blcf.a(this.a, true);
      }
      return;
      paramblbt = alud.a(2131700369);
      localblbt.jdField_a_of_type_JavaUtilList.addAll(blcf.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blci
 * JD-Core Version:    0.7.0.1
 */