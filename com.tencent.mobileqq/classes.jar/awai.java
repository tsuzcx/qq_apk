import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class awai
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  awai(avzs paramavzs, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380441);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380443));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380440));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380445));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380442);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131380444);
    if (bkpg.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845365);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130845363);
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
      localVenue = avzs.a(this.jdField_a_of_type_Avzs).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(avzs.a(this.jdField_a_of_type_Avzs).getResources().getString(2131693423), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    awao.a(avzs.a(this.jdField_a_of_type_Avzs, localVenue.a), avzs.a(this.jdField_a_of_type_Avzs).getResources().getString(2131693424), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new awaj(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new awak(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awai
 * JD-Core Version:    0.7.0.1
 */