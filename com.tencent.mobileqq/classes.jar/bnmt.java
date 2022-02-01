import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class bnmt
  implements Observer<bnme>
{
  bnmt(bnmq parambnmq) {}
  
  public void a(@Nullable bnme parambnme)
  {
    bnmq.a(this.a).a().removeObservers(bnmq.a(this.a));
    bnme localbnme;
    if (parambnme != null)
    {
      localbnme = parambnme;
      if (parambnme.jdField_a_of_type_JavaLangString != null) {}
    }
    else
    {
      localbnme = new bnme();
      localbnme.jdField_a_of_type_JavaLangString = "default";
    }
    parambnme = (String)bnmq.a(this.a).get(localbnme.jdField_a_of_type_JavaLangString);
    if (!localbnme.jdField_a_of_type_JavaLangString.equals("default")) {
      parambnme = anvx.a(2131699499) + parambnme + anvx.a(2131699492);
    }
    for (;;)
    {
      bnmq.a(this.a).setText(parambnme);
      if ((bnmq.a(this.a).size() == 0) && (!bnmq.a(this.a)))
      {
        bnmq.a(this.a).addAll(localbnme.jdField_a_of_type_JavaUtilList);
        this.a.b();
        bnmq.a(this.a, true);
      }
      return;
      parambnme = anvx.a(2131699488);
      localbnme.jdField_a_of_type_JavaUtilList.addAll(bnmq.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmt
 * JD-Core Version:    0.7.0.1
 */