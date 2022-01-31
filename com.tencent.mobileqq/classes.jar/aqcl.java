import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.util.Set;

public class aqcl
  extends aqbc
{
  public aqcl(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected View a()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_hiboom_id");
    HiBoomTextView localHiBoomTextView = new HiBoomTextView(this.jdField_a_of_type_AndroidAppActivity);
    localHiBoomTextView.setHiBoom(i, 0, aqxh.jdField_a_of_type_Aqxa);
    localHiBoomTextView.setText(this.jdField_a_of_type_JavaLangString);
    localHiBoomTextView.setMaxSize(aqxh.jdField_a_of_type_Int);
    localHiBoomTextView.setLayoutParams(new RelativeLayout.LayoutParams(500, 500));
    return localHiBoomTextView;
  }
  
  protected void a()
  {
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public boolean a()
  {
    super.a();
    return true;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Bbgg.setMessage(null);
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean h()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcl
 * JD-Core Version:    0.7.0.1
 */