import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class atsy
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
  
  atsy(atso paramatso, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376076);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376090));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376089));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376075);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376088));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376077));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131376080);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131376079);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131376073);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131376087);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131376083);
    this.h = paramView.findViewById(2131376081);
    this.i = paramView.findViewById(2131376085);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376084));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376082));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376086));
    if (bibv.a())
    {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130844966);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(atso.a(paramatso).getResources().getColor(2131165729));
      this.h.setBackgroundResource(2130844966);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(atso.a(paramatso).getResources().getColor(2131165729));
      this.i.setBackgroundResource(2130844966);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(atso.a(paramatso).getResources().getColor(2131165729));
      paramView.findViewById(2131365352).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131365353).setBackgroundColor(Color.parseColor("#282828"));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new atsz(this, paramatso));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new atta(this, paramatso));
    if (bibv.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130844967);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new attb(this, paramatso));
    this.h.setOnClickListener(new attc(this, paramatso));
    this.i.setOnClickListener(new attd(this, paramatso));
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
    LocationRoom.Venue localVenue = atso.a(this.jdField_a_of_type_Atso).a();
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
  
  void a(attu paramattu)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = atso.a(this.jdField_a_of_type_Atso).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    if (paramattu != null) {}
    for (int j = paramattu.jdField_a_of_type_JavaLangInteger.intValue();; j = 1)
    {
      b(j);
      return;
    }
  }
  
  @SuppressLint({"SetTextI18n", "DefaultLocale"})
  void a(attu paramattu, LocationRoom.Venue paramVenue)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramVenue.c);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(attk.a(paramattu.jdField_a_of_type_Float));
    if (paramattu.b < 1000.0F) {}
    for (paramVenue = String.format(atso.a(this.jdField_a_of_type_Atso).getResources().getString(2131694122), new Object[] { Integer.valueOf(Math.round(paramattu.b)) });; paramVenue = String.format(atso.a(this.jdField_a_of_type_Atso).getResources().getString(2131694121), new Object[] { Double.valueOf(paramattu.b / 1000.0D) }))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramVenue);
      b(paramattu.jdField_a_of_type_JavaLangInteger.intValue());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsy
 * JD-Core Version:    0.7.0.1
 */