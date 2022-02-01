import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

class awmd
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
  
  awmd(awlt paramawlt, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376991);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377005));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377004));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376990);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377003));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376992));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131376995);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131376994);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131376988);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131377002);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131376998);
    this.h = paramView.findViewById(2131376996);
    this.i = paramView.findViewById(2131377000);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376999));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376997));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377001));
    if (blfw.a())
    {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130845343);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(awlt.a(paramawlt).getResources().getColor(2131165796));
      this.h.setBackgroundResource(2130845343);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(awlt.a(paramawlt).getResources().getColor(2131165796));
      this.i.setBackgroundResource(2130845343);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(awlt.a(paramawlt).getResources().getColor(2131165796));
      paramView.findViewById(2131365756).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131365757).setBackgroundColor(Color.parseColor("#282828"));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new awme(this, paramawlt));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new awmf(this, paramawlt));
    if (blfw.a())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845344);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new awmg(this, paramawlt));
    this.h.setOnClickListener(new awmh(this, paramawlt));
    this.i.setOnClickListener(new awmi(this, paramawlt));
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
    LocationRoom.Venue localVenue = awlt.a(this.jdField_a_of_type_Awlt).a();
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
  
  void a(awmz paramawmz)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = awlt.a(this.jdField_a_of_type_Awlt).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    if (paramawmz != null) {}
    for (int j = paramawmz.jdField_a_of_type_JavaLangInteger.intValue();; j = 1)
    {
      b(j);
      return;
    }
  }
  
  @SuppressLint({"SetTextI18n", "DefaultLocale"})
  void a(awmz paramawmz, LocationRoom.Venue paramVenue)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramVenue.c);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(awmp.a(paramawmz.jdField_a_of_type_Float));
    if (paramawmz.b < 1000.0F) {}
    for (paramVenue = String.format(awlt.a(this.jdField_a_of_type_Awlt).getResources().getString(2131693700), new Object[] { Integer.valueOf(Math.round(paramawmz.b)) });; paramVenue = String.format(awlt.a(this.jdField_a_of_type_Awlt).getResources().getString(2131693699), new Object[] { Double.valueOf(paramawmz.b / 1000.0D) }))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramVenue);
      b(paramawmz.jdField_a_of_type_JavaLangInteger.intValue());
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
 * Qualified Name:     awmd
 * JD-Core Version:    0.7.0.1
 */