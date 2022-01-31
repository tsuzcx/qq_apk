import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;

class amod
  implements View.OnClickListener
{
  amod(amob paramamob) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    paramView = new Intent(paramView.getContext(), PoiMapActivity.class).putExtra("lat", Double.toString(this.a.jdField_a_of_type_Amwm.a * 1.0D / 1000000.0D)).putExtra("lon", Double.toString(this.a.jdField_a_of_type_Amwm.b * 1.0D / 1000000.0D));
    this.a.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amod
 * JD-Core Version:    0.7.0.1
 */