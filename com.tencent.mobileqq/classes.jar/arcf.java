import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class arcf
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  arcf(arbp paramarbp, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131312997);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312999));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312996));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131313001));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131312998);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131313000);
    if (beog.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130844447);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130844445);
      if ((this.jdField_b_of_type_AndroidViewView instanceof TextView)) {
        ((TextView)this.jdField_b_of_type_AndroidViewView).setTextColor(-1);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      ((TextView)this.jdField_b_of_type_AndroidViewView).setTextColor(-1);
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  void a(LocationRoom.Venue paramVenue)
  {
    LocationRoom.Venue localVenue = paramVenue;
    if (paramVenue == null) {
      localVenue = arbp.a(this.jdField_a_of_type_Arbp).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(arbp.a(this.jdField_a_of_type_Arbp).getResources().getString(2131628375), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    arcl.a(arbp.a(this.jdField_a_of_type_Arbp, localVenue.a), arbp.a(this.jdField_a_of_type_Arbp).getResources().getString(2131628376), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new arcg(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new arch(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arcf
 * JD-Core Version:    0.7.0.1
 */