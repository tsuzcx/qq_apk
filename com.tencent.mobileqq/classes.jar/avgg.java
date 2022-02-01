import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class avgg
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  avgg(avfq paramavfq, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380350);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380352));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380349));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380354));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380351);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131380353);
    if (bjuk.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845259);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130845257);
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
      localVenue = avfq.a(this.jdField_a_of_type_Avfq).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(avfq.a(this.jdField_a_of_type_Avfq).getResources().getString(2131693530), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    avgm.a(avfq.a(this.jdField_a_of_type_Avfq, localVenue.a), avfq.a(this.jdField_a_of_type_Avfq).getResources().getString(2131693531), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new avgh(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new avgi(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgg
 * JD-Core Version:    0.7.0.1
 */