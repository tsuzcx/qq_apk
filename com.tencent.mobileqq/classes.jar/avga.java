import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class avga
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
  
  avga(avfq paramavfq, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376723);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376737));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376736));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376722);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376735));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376724));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131376727);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131376726);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131376720);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131376734);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131376730);
    this.h = paramView.findViewById(2131376728);
    this.i = paramView.findViewById(2131376732);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376731));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376729));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376733));
    if (bjuk.a())
    {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130845258);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(avfq.a(paramavfq).getResources().getColor(2131165787));
      this.h.setBackgroundResource(2130845258);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(avfq.a(paramavfq).getResources().getColor(2131165787));
      this.i.setBackgroundResource(2130845258);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(avfq.a(paramavfq).getResources().getColor(2131165787));
      paramView.findViewById(2131365662).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131365663).setBackgroundColor(Color.parseColor("#282828"));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new avgb(this, paramavfq));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new avgc(this, paramavfq));
    if (bjuk.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845259);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new avgd(this, paramavfq));
    this.h.setOnClickListener(new avge(this, paramavfq));
    this.i.setOnClickListener(new avgf(this, paramavfq));
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
    LocationRoom.Venue localVenue = avfq.a(this.jdField_a_of_type_Avfq).a();
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
  
  void a(avgw paramavgw)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = avfq.a(this.jdField_a_of_type_Avfq).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    if (paramavgw != null) {}
    for (int j = paramavgw.jdField_a_of_type_JavaLangInteger.intValue();; j = 1)
    {
      b(j);
      return;
    }
  }
  
  @SuppressLint({"SetTextI18n", "DefaultLocale"})
  void a(avgw paramavgw, LocationRoom.Venue paramVenue)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramVenue.c);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(avgm.a(paramavgw.jdField_a_of_type_Float));
    if (paramavgw.b < 1000.0F) {}
    for (paramVenue = String.format(avfq.a(this.jdField_a_of_type_Avfq).getResources().getString(2131693519), new Object[] { Integer.valueOf(Math.round(paramavgw.b)) });; paramVenue = String.format(avfq.a(this.jdField_a_of_type_Avfq).getResources().getString(2131693518), new Object[] { Double.valueOf(paramavgw.b / 1000.0D) }))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramVenue);
      b(paramavgw.jdField_a_of_type_JavaLangInteger.intValue());
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
 * Qualified Name:     avga
 * JD-Core Version:    0.7.0.1
 */