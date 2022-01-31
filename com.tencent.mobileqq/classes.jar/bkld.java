import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class bkld
  extends bkis
{
  private bkml jdField_a_of_type_Bkml;
  private bmcu jdField_a_of_type_Bmcu;
  private bmcv jdField_a_of_type_Bmcv;
  
  public bkld(bmcv parambmcv, bmcu parambmcu)
  {
    this.jdField_a_of_type_Bmcv = parambmcv;
    this.jdField_a_of_type_Bmcu = parambmcu;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_Bmcv.a().getLayoutInflater().inflate(2131558551, null);
  }
  
  public void a()
  {
    Intent localIntent = this.jdField_a_of_type_Bmcv.a().getIntent();
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 7);
    this.jdField_a_of_type_Bkml = new bkml();
    this.jdField_a_of_type_Bmcv.a().getFragmentManager().beginTransaction().add(2131366415, this.jdField_a_of_type_Bkml).commit();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bmcv == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Bkml != null) && (this.jdField_a_of_type_Bkml.a != null)) {
      this.jdField_a_of_type_Bkml.a.a(null);
    }
    return true;
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Bmcv.a().finish();
  }
  
  public void p()
  {
    super.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkld
 * JD-Core Version:    0.7.0.1
 */