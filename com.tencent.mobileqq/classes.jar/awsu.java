import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class awsu
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  View jdField_e_of_type_AndroidViewView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  View jdField_f_of_type_AndroidViewView;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  View jdField_g_of_type_AndroidViewView;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  View h;
  View i;
  
  awsu(awsk paramawsk, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376969);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376983));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376982));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376968);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376981));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376970));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131376973);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131376972);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131376966);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131376980);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131376976);
    this.h = paramView.findViewById(2131376974);
    this.i = paramView.findViewById(2131376978);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376977));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376975));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376979));
    if (blqj.a())
    {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130845379);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(awsk.a(paramawsk).getResources().getColor(2131165777));
      this.h.setBackgroundResource(2130845379);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(awsk.a(paramawsk).getResources().getColor(2131165777));
      this.i.setBackgroundResource(2130845379);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(awsk.a(paramawsk).getResources().getColor(2131165777));
      paramView.findViewById(2131365629).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131365630).setBackgroundColor(Color.parseColor("#282828"));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new awsv(this, paramawsk));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new awsw(this, paramawsk));
    if (blqj.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845380);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new awsx(this, paramawsk));
    this.h.setOnClickListener(new awsy(this, paramawsk));
    this.i.setOnClickListener(new awsz(this, paramawsk));
  }
  
  private String a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return "drive";
    case 2: 
      return "bus";
    }
    return "walk";
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  void a(int paramInt)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    LocationRoom.Venue localVenue = awsk.a(this.jdField_a_of_type_Awsk).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    b(paramInt);
  }
  
  void a(View paramView)
  {
    this.jdField_g_of_type_AndroidViewView.setSelected(false);
    this.h.setSelected(false);
    this.i.setSelected(false);
    paramView.setSelected(true);
  }
  
  void a(awtq paramawtq)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = awsk.a(this.jdField_a_of_type_Awsk).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    if (paramawtq != null) {}
    for (int j = paramawtq.jdField_a_of_type_JavaLangInteger.intValue();; j = 1)
    {
      b(j);
      return;
    }
  }
  
  @SuppressLint({"SetTextI18n", "DefaultLocale"})
  void a(awtq paramawtq, LocationRoom.Venue paramVenue)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramVenue.c);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(awtg.a(paramawtq.jdField_a_of_type_Float));
    if (paramawtq.b < 1000.0F) {}
    for (paramVenue = String.format(awsk.a(this.jdField_a_of_type_Awsk).getResources().getString(2131693424), new Object[] { Integer.valueOf(Math.round(paramawtq.b)) });; paramVenue = String.format(awsk.a(this.jdField_a_of_type_Awsk).getResources().getString(2131693423), new Object[] { Double.valueOf(paramawtq.b / 1000.0D) }))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramVenue);
      b(paramawtq.jdField_a_of_type_JavaLangInteger.intValue());
      return;
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Int = 1;
      a(this.jdField_g_of_type_AndroidViewView);
      return;
    case 2: 
      a(this.h);
      return;
    }
    a(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsu
 * JD-Core Version:    0.7.0.1
 */