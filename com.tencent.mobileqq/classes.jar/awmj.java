import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class awmj
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  awmj(awlt paramawlt, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380686);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380688));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380685));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380690));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380687);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131380689);
    if (blfw.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845344);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130845342);
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
      localVenue = awlt.a(this.jdField_a_of_type_Awlt).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(awlt.a(this.jdField_a_of_type_Awlt).getResources().getString(2131693711), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    awmp.a(awlt.a(this.jdField_a_of_type_Awlt, localVenue.a), awlt.a(this.jdField_a_of_type_Awlt).getResources().getString(2131693712), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new awmk(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new awml(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmj
 * JD-Core Version:    0.7.0.1
 */