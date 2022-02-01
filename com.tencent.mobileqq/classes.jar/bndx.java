import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class bndx
  extends bnbm
{
  private bnfn jdField_a_of_type_Bnfn;
  private boym jdField_a_of_type_Boym;
  private boyn jdField_a_of_type_Boyn;
  
  public bndx(boyn paramboyn, boym paramboym)
  {
    this.jdField_a_of_type_Boyn = paramboyn;
    this.jdField_a_of_type_Boym = paramboym;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_Boyn.a().getLayoutInflater().inflate(2131558578, null);
  }
  
  public void a()
  {
    Intent localIntent = this.jdField_a_of_type_Boyn.a().getIntent();
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 7);
    this.jdField_a_of_type_Bnfn = new bnfn();
    this.jdField_a_of_type_Boyn.a().getFragmentManager().beginTransaction().add(2131366665, this.jdField_a_of_type_Bnfn).commit();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boyn == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Bnfn != null) && (this.jdField_a_of_type_Bnfn.a != null)) {
      this.jdField_a_of_type_Bnfn.a.a(null);
    }
    return true;
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Boyn.a().finish();
  }
  
  public void p()
  {
    super.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndx
 * JD-Core Version:    0.7.0.1
 */