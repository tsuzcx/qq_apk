import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class apez
  implements View.OnClickListener
{
  apez(apex paramapex) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    Intent localIntent = new Intent(paramView.getContext(), PoiMapActivity.class).putExtra("lat", Double.toString(this.a.jdField_a_of_type_Apnc.a * 1.0D / 1000000.0D)).putExtra("lon", Double.toString(this.a.jdField_a_of_type_Apnc.b * 1.0D / 1000000.0D));
    this.a.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apez
 * JD-Core Version:    0.7.0.1
 */