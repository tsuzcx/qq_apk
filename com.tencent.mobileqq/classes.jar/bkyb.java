import android.support.annotation.Nullable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class bkyb
  implements bmac<bkxm>
{
  bkyb(bkxy parambkxy) {}
  
  public void a(@Nullable bkxm parambkxm)
  {
    bkxy.a(this.a).a().a(bkxy.a(this.a));
    bkxm localbkxm;
    if (parambkxm != null)
    {
      localbkxm = parambkxm;
      if (parambkxm.jdField_a_of_type_JavaLangString != null) {}
    }
    else
    {
      localbkxm = new bkxm();
      localbkxm.jdField_a_of_type_JavaLangString = "default";
    }
    parambkxm = (String)bkxy.a(this.a).get(localbkxm.jdField_a_of_type_JavaLangString);
    if (!localbkxm.jdField_a_of_type_JavaLangString.equals("default")) {
      parambkxm = alpo.a(2131700368) + parambkxm + alpo.a(2131700361);
    }
    for (;;)
    {
      bkxy.a(this.a).setText(parambkxm);
      if ((bkxy.a(this.a).size() == 0) && (!bkxy.a(this.a)))
      {
        bkxy.a(this.a).addAll(localbkxm.jdField_a_of_type_JavaUtilList);
        this.a.b();
        bkxy.a(this.a, true);
      }
      return;
      parambkxm = alpo.a(2131700357);
      localbkxm.jdField_a_of_type_JavaUtilList.addAll(bkxy.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyb
 * JD-Core Version:    0.7.0.1
 */