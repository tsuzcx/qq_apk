import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class bmwz
  extends bmut
{
  private bmza jdField_a_of_type_Bmza;
  private borg jdField_a_of_type_Borg;
  private borh jdField_a_of_type_Borh;
  
  public bmwz(borh paramborh, borg paramborg)
  {
    this.jdField_a_of_type_Borh = paramborh;
    this.jdField_a_of_type_Borg = paramborg;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_Borh.a().getLayoutInflater().inflate(2131558595, null);
  }
  
  public void a()
  {
    Intent localIntent = this.jdField_a_of_type_Borh.a().getIntent();
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 7);
    this.jdField_a_of_type_Bmza = new bmza();
    this.jdField_a_of_type_Borh.a().getFragmentManager().beginTransaction().add(2131366861, this.jdField_a_of_type_Bmza).commit();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Borh == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Bmza != null) && (this.jdField_a_of_type_Bmza.a != null)) {
      this.jdField_a_of_type_Bmza.a.a(null);
    }
    return true;
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Borh.a().finish();
  }
  
  public void j()
  {
    super.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwz
 * JD-Core Version:    0.7.0.1
 */