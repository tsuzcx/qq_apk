import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class bkpk
  extends bkmz
{
  private bkqs jdField_a_of_type_Bkqs;
  private bmhg jdField_a_of_type_Bmhg;
  private bmhh jdField_a_of_type_Bmhh;
  
  public bkpk(bmhh parambmhh, bmhg parambmhg)
  {
    this.jdField_a_of_type_Bmhh = parambmhh;
    this.jdField_a_of_type_Bmhg = parambmhg;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_Bmhh.a().getLayoutInflater().inflate(2131558551, null);
  }
  
  public void a()
  {
    Intent localIntent = this.jdField_a_of_type_Bmhh.a().getIntent();
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 7);
    this.jdField_a_of_type_Bkqs = new bkqs();
    this.jdField_a_of_type_Bmhh.a().getFragmentManager().beginTransaction().add(2131366417, this.jdField_a_of_type_Bkqs).commit();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bmhh == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Bkqs != null) && (this.jdField_a_of_type_Bkqs.a != null)) {
      this.jdField_a_of_type_Bkqs.a.a(null);
    }
    return true;
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Bmhh.a().finish();
  }
  
  public void p()
  {
    super.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpk
 * JD-Core Version:    0.7.0.1
 */