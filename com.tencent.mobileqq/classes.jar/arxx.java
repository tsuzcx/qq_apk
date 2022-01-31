import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class arxx
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  arxx(arxh paramarxh, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378822);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378824));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378821));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378826));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131378823);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131378825);
    if (bfwa.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130844530);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130844528);
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
      localVenue = arxh.a(this.jdField_a_of_type_Arxh).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(arxh.a(this.jdField_a_of_type_Arxh).getResources().getString(2131694016), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    aryd.a(arxh.a(this.jdField_a_of_type_Arxh, localVenue.a), arxh.a(this.jdField_a_of_type_Arxh).getResources().getString(2131694017), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new arxy(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new arxz(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxx
 * JD-Core Version:    0.7.0.1
 */