import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class atov
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  atov(atof paramatof, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379448);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379450));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379447));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379452));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131379449);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131379451);
    if (bhxo.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130844895);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130844893);
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
      localVenue = atof.a(this.jdField_a_of_type_Atof).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(atof.a(this.jdField_a_of_type_Atof).getResources().getString(2131694133), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    atpb.a(atof.a(this.jdField_a_of_type_Atof, localVenue.a), atof.a(this.jdField_a_of_type_Atof).getResources().getString(2131694134), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new atow(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new atox(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atov
 * JD-Core Version:    0.7.0.1
 */