import android.support.annotation.Nullable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class bisr
  implements bjob<bisc>
{
  bisr(biso parambiso) {}
  
  public void a(@Nullable bisc parambisc)
  {
    biso.a(this.a).a().a(biso.a(this.a));
    bisc localbisc;
    if (parambisc != null)
    {
      localbisc = parambisc;
      if (parambisc.jdField_a_of_type_JavaLangString != null) {}
    }
    else
    {
      localbisc = new bisc();
      localbisc.jdField_a_of_type_JavaLangString = "default";
    }
    parambisc = (String)biso.a(this.a).get(localbisc.jdField_a_of_type_JavaLangString);
    if (!localbisc.jdField_a_of_type_JavaLangString.equals("default")) {
      parambisc = ajyc.a(2131699988) + parambisc + ajyc.a(2131699981);
    }
    for (;;)
    {
      biso.a(this.a).setText(parambisc);
      if ((biso.a(this.a).size() == 0) && (!biso.a(this.a)))
      {
        biso.a(this.a).addAll(localbisc.jdField_a_of_type_JavaUtilList);
        this.a.b();
        biso.a(this.a, true);
      }
      return;
      parambisc = ajyc.a(2131699977);
      localbisc.jdField_a_of_type_JavaUtilList.addAll(biso.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bisr
 * JD-Core Version:    0.7.0.1
 */