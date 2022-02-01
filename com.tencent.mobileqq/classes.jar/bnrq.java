import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class bnrq
  implements Observer<bnrb>
{
  bnrq(bnrn parambnrn) {}
  
  public void a(@Nullable bnrb parambnrb)
  {
    bnrn.a(this.a).a().removeObservers(bnrn.a(this.a));
    bnrb localbnrb;
    if (parambnrb != null)
    {
      localbnrb = parambnrb;
      if (parambnrb.jdField_a_of_type_JavaLangString != null) {}
    }
    else
    {
      localbnrb = new bnrb();
      localbnrb.jdField_a_of_type_JavaLangString = "default";
    }
    parambnrb = (String)bnrn.a(this.a).get(localbnrb.jdField_a_of_type_JavaLangString);
    if (!localbnrb.jdField_a_of_type_JavaLangString.equals("default")) {
      parambnrb = anni.a(2131698806) + parambnrb + anni.a(2131698799);
    }
    for (;;)
    {
      bnrn.a(this.a).setText(parambnrb);
      if ((bnrn.a(this.a).size() == 0) && (!bnrn.a(this.a)))
      {
        bnrn.a(this.a).addAll(localbnrb.jdField_a_of_type_JavaUtilList);
        this.a.b();
        bnrn.a(this.a, true);
      }
      return;
      parambnrb = anni.a(2131698795);
      localbnrb.jdField_a_of_type_JavaUtilList.addAll(bnrn.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrq
 * JD-Core Version:    0.7.0.1
 */