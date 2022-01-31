import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class arxr
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
  
  arxr(arxh paramarxh, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375533);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375547));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375546));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131375532);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375545));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375534));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131375537);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131375536);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131375530);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131375544);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131375540);
    this.h = paramView.findViewById(2131375538);
    this.i = paramView.findViewById(2131375542);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375541));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375539));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375543));
    if (bfwa.a())
    {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130844529);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(arxh.a(paramarxh).getResources().getColor(2131165692));
      this.h.setBackgroundResource(2130844529);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(arxh.a(paramarxh).getResources().getColor(2131165692));
      this.i.setBackgroundResource(2130844529);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(arxh.a(paramarxh).getResources().getColor(2131165692));
      paramView.findViewById(2131365266).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131365267).setBackgroundColor(Color.parseColor("#282828"));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new arxs(this, paramarxh));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new arxt(this, paramarxh));
    if (bfwa.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130844530);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new arxu(this, paramarxh));
    this.h.setOnClickListener(new arxv(this, paramarxh));
    this.i.setOnClickListener(new arxw(this, paramarxh));
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
    LocationRoom.Venue localVenue = arxh.a(this.jdField_a_of_type_Arxh).a();
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
  
  void a(aryn paramaryn)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = arxh.a(this.jdField_a_of_type_Arxh).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    if (paramaryn != null) {}
    for (int j = paramaryn.jdField_a_of_type_JavaLangInteger.intValue();; j = 1)
    {
      b(j);
      return;
    }
  }
  
  @SuppressLint({"SetTextI18n", "DefaultLocale"})
  void a(aryn paramaryn, LocationRoom.Venue paramVenue)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramVenue.c);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(aryd.a(paramaryn.jdField_a_of_type_Float));
    if (paramaryn.b < 1000.0F) {}
    for (paramVenue = String.format(arxh.a(this.jdField_a_of_type_Arxh).getResources().getString(2131694003), new Object[] { Integer.valueOf(Math.round(paramaryn.b)) });; paramVenue = String.format(arxh.a(this.jdField_a_of_type_Arxh).getResources().getString(2131694002), new Object[] { Double.valueOf(paramaryn.b / 1000.0D) }))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramVenue);
      b(paramaryn.jdField_a_of_type_JavaLangInteger.intValue());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxr
 * JD-Core Version:    0.7.0.1
 */