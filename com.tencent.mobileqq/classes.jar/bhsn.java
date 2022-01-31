import android.support.annotation.Nullable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class bhsn
  implements bhwg<bhso>
{
  bhsn(bhsk parambhsk) {}
  
  public void a(@Nullable bhso parambhso)
  {
    bhsk.a(this.a).a().a(bhsk.a(this.a));
    bhso localbhso;
    if (parambhso != null)
    {
      localbhso = parambhso;
      if (parambhso.jdField_a_of_type_JavaLangString != null) {}
    }
    else
    {
      localbhso = new bhso();
      localbhso.jdField_a_of_type_JavaLangString = "default";
    }
    parambhso = (String)bhsk.a(this.a).get(localbhso.jdField_a_of_type_JavaLangString);
    if (!localbhso.jdField_a_of_type_JavaLangString.equals("default")) {
      parambhso = ajjy.a(2131634200) + parambhso + ajjy.a(2131634193);
    }
    for (;;)
    {
      bhsk.a(this.a).setText(parambhso);
      if ((bhsk.a(this.a).size() == 0) && (!bhsk.a(this.a)))
      {
        bhsk.a(this.a).addAll(localbhso.jdField_a_of_type_JavaUtilList);
        this.a.b();
        bhsk.a(this.a, true);
      }
      return;
      parambhso = ajjy.a(2131634189);
      localbhso.jdField_a_of_type_JavaUtilList.addAll(bhsk.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhsn
 * JD-Core Version:    0.7.0.1
 */