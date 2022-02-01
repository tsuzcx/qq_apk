import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class bofg
  extends bocu
{
  private bogv jdField_a_of_type_Bogv;
  private bqah jdField_a_of_type_Bqah;
  private bqai jdField_a_of_type_Bqai;
  
  public bofg(bqai parambqai, bqah parambqah)
  {
    this.jdField_a_of_type_Bqai = parambqai;
    this.jdField_a_of_type_Bqah = parambqah;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_Bqai.a().getLayoutInflater().inflate(2131558580, null);
  }
  
  public void a()
  {
    Intent localIntent = this.jdField_a_of_type_Bqai.a().getIntent();
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 7);
    this.jdField_a_of_type_Bogv = new bogv();
    this.jdField_a_of_type_Bqai.a().getFragmentManager().beginTransaction().add(2131366715, this.jdField_a_of_type_Bogv).commit();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bqai == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Bogv != null) && (this.jdField_a_of_type_Bogv.a != null)) {
      this.jdField_a_of_type_Bogv.a.a(null);
    }
    return true;
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Bqai.a().finish();
  }
  
  public void p()
  {
    super.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofg
 * JD-Core Version:    0.7.0.1
 */