import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class atop
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
  
  atop(atof paramatof, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376023);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376037));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376036));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376022);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376035));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376024));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131376027);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131376026);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131376020);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131376034);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131376030);
    this.h = paramView.findViewById(2131376028);
    this.i = paramView.findViewById(2131376032);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376031));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376029));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376033));
    if (bhxo.a())
    {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130844894);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(atof.a(paramatof).getResources().getColor(2131165729));
      this.h.setBackgroundResource(2130844894);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(atof.a(paramatof).getResources().getColor(2131165729));
      this.i.setBackgroundResource(2130844894);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(atof.a(paramatof).getResources().getColor(2131165729));
      paramView.findViewById(2131365350).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131365351).setBackgroundColor(Color.parseColor("#282828"));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new atoq(this, paramatof));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new ator(this, paramatof));
    if (bhxo.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130844895);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new atos(this, paramatof));
    this.h.setOnClickListener(new atot(this, paramatof));
    this.i.setOnClickListener(new atou(this, paramatof));
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
    LocationRoom.Venue localVenue = atof.a(this.jdField_a_of_type_Atof).a();
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
  
  void a(atpl paramatpl)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = atof.a(this.jdField_a_of_type_Atof).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    if (paramatpl != null) {}
    for (int j = paramatpl.jdField_a_of_type_JavaLangInteger.intValue();; j = 1)
    {
      b(j);
      return;
    }
  }
  
  @SuppressLint({"SetTextI18n", "DefaultLocale"})
  void a(atpl paramatpl, LocationRoom.Venue paramVenue)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramVenue.c);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(atpb.a(paramatpl.jdField_a_of_type_Float));
    if (paramatpl.b < 1000.0F) {}
    for (paramVenue = String.format(atof.a(this.jdField_a_of_type_Atof).getResources().getString(2131694120), new Object[] { Integer.valueOf(Math.round(paramatpl.b)) });; paramVenue = String.format(atof.a(this.jdField_a_of_type_Atof).getResources().getString(2131694119), new Object[] { Double.valueOf(paramatpl.b / 1000.0D) }))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramVenue);
      b(paramatpl.jdField_a_of_type_JavaLangInteger.intValue());
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
 * Qualified Name:     atop
 * JD-Core Version:    0.7.0.1
 */