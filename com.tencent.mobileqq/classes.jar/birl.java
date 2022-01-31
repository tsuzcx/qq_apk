import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class birl
  extends bire<birk>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  protected birl(birk parambirk, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131310599));
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    if (paramInt < 0) {
      urk.e("SpeedFilterData", "speed < 0. speed:%s .", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      return;
      urk.a("SpeedFilterData", "updateSpeed: %s", Integer.valueOf(paramInt));
      if (paramInt == 0) {}
      char[] arrayOfChar;
      Object localObject1;
      for (boolean bool = true;; bool = false)
      {
        arrayOfChar = String.valueOf(paramInt).toCharArray();
        paramInt = i;
        while (paramInt < arrayOfChar.length)
        {
          Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
            ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          }
          a((ImageView)localObject1, arrayOfChar[paramInt], bool);
          paramInt += 1;
        }
      }
      paramInt = arrayOfChar.length;
      while (paramInt < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)localObject1);
        paramInt += 1;
      }
    }
  }
  
  private void a(ImageView paramImageView, char paramChar, boolean paramBoolean)
  {
    if (paramImageView == null) {
      return;
    }
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      if (paramBoolean)
      {
        paramImageView.setImageResource(2130845730);
        return;
      }
      paramImageView.setImageResource(2130845731);
      return;
    case '1': 
      paramImageView.setImageResource(2130845732);
      return;
    case '2': 
      paramImageView.setImageResource(2130845733);
      return;
    case '3': 
      paramImageView.setImageResource(2130845734);
      return;
    case '4': 
      paramImageView.setImageResource(2130845735);
      return;
    case '5': 
      paramImageView.setImageResource(2130845736);
      return;
    case '6': 
      paramImageView.setImageResource(2130845737);
      return;
    case '7': 
      paramImageView.setImageResource(2130845738);
      return;
    case '8': 
      paramImageView.setImageResource(2130845739);
      return;
    }
    paramImageView.setImageResource(2130845740);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131495774, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(birk parambirk, int paramInt)
  {
    super.a(parambirk, paramInt);
    a(birk.a(this.jdField_a_of_type_Birk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birl
 * JD-Core Version:    0.7.0.1
 */