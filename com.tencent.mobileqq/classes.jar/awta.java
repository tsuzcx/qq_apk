import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class awta
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  awta(awsk paramawsk, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380627);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380629));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380626));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380631));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380628);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131380630);
    if (blqj.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845380);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130845378);
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
      localVenue = awsk.a(this.jdField_a_of_type_Awsk).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(awsk.a(this.jdField_a_of_type_Awsk).getResources().getString(2131693435), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    awtg.a(awsk.a(this.jdField_a_of_type_Awsk, localVenue.a), awsk.a(this.jdField_a_of_type_Awsk).getResources().getString(2131693436), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new awtb(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new awtc(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awta
 * JD-Core Version:    0.7.0.1
 */