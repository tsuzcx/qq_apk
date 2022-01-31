import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class atte
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  atte(atso paramatso, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379506);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379508));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379505));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379510));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131379507);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131379509);
    if (bibv.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130844967);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130844965);
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
      localVenue = atso.a(this.jdField_a_of_type_Atso).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(atso.a(this.jdField_a_of_type_Atso).getResources().getString(2131694135), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    attk.a(atso.a(this.jdField_a_of_type_Atso, localVenue.a), atso.a(this.jdField_a_of_type_Atso).getResources().getString(2131694136), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new attf(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new attg(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atte
 * JD-Core Version:    0.7.0.1
 */