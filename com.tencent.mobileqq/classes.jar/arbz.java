import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class arbz
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
  
  arbz(arbp paramarbp, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131309774);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309788));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309787));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131309773);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309786));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309775));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131309778);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131309777);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131309771);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131309785);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131309781);
    this.h = paramView.findViewById(2131309779);
    this.i = paramView.findViewById(2131309783);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309782));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309780));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309784));
    if (beog.a())
    {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130844446);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(arbp.a(paramarbp).getResources().getColor(2131100106));
      this.h.setBackgroundResource(2130844446);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(arbp.a(paramarbp).getResources().getColor(2131100106));
      this.i.setBackgroundResource(2130844446);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(arbp.a(paramarbp).getResources().getColor(2131100106));
      paramView.findViewById(2131299698).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131299699).setBackgroundColor(Color.parseColor("#282828"));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new arca(this, paramarbp));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new arcb(this, paramarbp));
    if (beog.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130844447);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new arcc(this, paramarbp));
    this.h.setOnClickListener(new arcd(this, paramarbp));
    this.i.setOnClickListener(new arce(this, paramarbp));
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
    LocationRoom.Venue localVenue = arbp.a(this.jdField_a_of_type_Arbp).a();
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
  
  void a(arcv paramarcv)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = arbp.a(this.jdField_a_of_type_Arbp).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    if (paramarcv != null) {}
    for (int j = paramarcv.jdField_a_of_type_JavaLangInteger.intValue();; j = 1)
    {
      b(j);
      return;
    }
  }
  
  @SuppressLint({"SetTextI18n", "DefaultLocale"})
  void a(arcv paramarcv, LocationRoom.Venue paramVenue)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramVenue.c);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(arcl.a(paramarcv.jdField_a_of_type_Float));
    if (paramarcv.b < 1000.0F) {}
    for (paramVenue = String.format(arbp.a(this.jdField_a_of_type_Arbp).getResources().getString(2131628362), new Object[] { Integer.valueOf(Math.round(paramarcv.b)) });; paramVenue = String.format(arbp.a(this.jdField_a_of_type_Arbp).getResources().getString(2131628361), new Object[] { Double.valueOf(paramarcv.b / 1000.0D) }))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramVenue);
      b(paramarcv.jdField_a_of_type_JavaLangInteger.intValue());
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
 * Qualified Name:     arbz
 * JD-Core Version:    0.7.0.1
 */