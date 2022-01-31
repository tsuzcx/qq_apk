import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class arxz
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  arxz(arxj paramarxj, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378827);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378829));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378826));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378831));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131378828);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131378830);
    if (bfwr.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130844531);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130844529);
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
      localVenue = arxj.a(this.jdField_a_of_type_Arxj).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(arxj.a(this.jdField_a_of_type_Arxj).getResources().getString(2131694017), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    aryf.a(arxj.a(this.jdField_a_of_type_Arxj, localVenue.a), arxj.a(this.jdField_a_of_type_Arxj).getResources().getString(2131694018), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new arya(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new aryb(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxz
 * JD-Core Version:    0.7.0.1
 */