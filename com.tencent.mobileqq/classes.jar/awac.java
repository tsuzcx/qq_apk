import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class awac
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
  
  awac(avzs paramavzs, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376832);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376846));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376845));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376831);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376844));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376833));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131376836);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131376835);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131376829);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131376843);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131376839);
    this.h = paramView.findViewById(2131376837);
    this.i = paramView.findViewById(2131376841);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376840));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376838));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376842));
    if (bkpg.a())
    {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130845364);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(avzs.a(paramavzs).getResources().getColor(2131165777));
      this.h.setBackgroundResource(2130845364);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(avzs.a(paramavzs).getResources().getColor(2131165777));
      this.i.setBackgroundResource(2130845364);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(avzs.a(paramavzs).getResources().getColor(2131165777));
      paramView.findViewById(2131365587).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131365588).setBackgroundColor(Color.parseColor("#282828"));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new awad(this, paramavzs));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new awae(this, paramavzs));
    if (bkpg.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845365);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new awaf(this, paramavzs));
    this.h.setOnClickListener(new awag(this, paramavzs));
    this.i.setOnClickListener(new awah(this, paramavzs));
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
    LocationRoom.Venue localVenue = avzs.a(this.jdField_a_of_type_Avzs).a();
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
  
  void a(away paramaway)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = avzs.a(this.jdField_a_of_type_Avzs).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    if (paramaway != null) {}
    for (int j = paramaway.jdField_a_of_type_JavaLangInteger.intValue();; j = 1)
    {
      b(j);
      return;
    }
  }
  
  @SuppressLint({"SetTextI18n", "DefaultLocale"})
  void a(away paramaway, LocationRoom.Venue paramVenue)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramVenue.c);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(awao.a(paramaway.jdField_a_of_type_Float));
    if (paramaway.b < 1000.0F) {}
    for (paramVenue = String.format(avzs.a(this.jdField_a_of_type_Avzs).getResources().getString(2131693412), new Object[] { Integer.valueOf(Math.round(paramaway.b)) });; paramVenue = String.format(avzs.a(this.jdField_a_of_type_Avzs).getResources().getString(2131693411), new Object[] { Double.valueOf(paramaway.b / 1000.0D) }))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramVenue);
      b(paramaway.jdField_a_of_type_JavaLangInteger.intValue());
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
 * Qualified Name:     awac
 * JD-Core Version:    0.7.0.1
 */