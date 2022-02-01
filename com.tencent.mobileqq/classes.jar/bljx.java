import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class bljx
  extends blic
{
  private bllr jdField_a_of_type_Bllr;
  private bnbo jdField_a_of_type_Bnbo;
  private bnbp jdField_a_of_type_Bnbp;
  
  public bljx(bnbp parambnbp, bnbo parambnbo)
  {
    this.jdField_a_of_type_Bnbp = parambnbp;
    this.jdField_a_of_type_Bnbo = parambnbo;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_Bnbp.a().getLayoutInflater().inflate(2131558583, null);
  }
  
  public void a()
  {
    Intent localIntent = this.jdField_a_of_type_Bnbp.a().getIntent();
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 7);
    this.jdField_a_of_type_Bllr = new bllr();
    this.jdField_a_of_type_Bnbp.a().getFragmentManager().beginTransaction().add(2131366745, this.jdField_a_of_type_Bllr).commit();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bnbp == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Bllr != null) && (this.jdField_a_of_type_Bllr.a != null)) {
      this.jdField_a_of_type_Bllr.a.a(null);
    }
    return true;
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Bnbp.a().finish();
  }
  
  public void o()
  {
    super.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljx
 * JD-Core Version:    0.7.0.1
 */