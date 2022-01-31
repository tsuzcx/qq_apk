import android.app.Notification;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RemoteViews;
import android.widget.TextView;

public class bflp
{
  protected float a;
  protected DisplayMetrics a;
  protected Integer a;
  protected final String a;
  protected float b;
  protected Integer b;
  protected final String b;
  
  bflp(bfln parambfln, Context paramContext)
  {
    this.jdField_a_of_type_Float = 14.0F;
    this.jdField_b_of_type_Float = 16.0F;
    this.jdField_a_of_type_JavaLangString = "SearchForText";
    this.jdField_b_of_type_JavaLangString = "SearchForTitle";
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    a(paramContext);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public Integer a()
  {
    return this.jdField_a_of_type_JavaLangInteger;
  }
  
  protected void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_JavaLangInteger != null) && (this.jdField_b_of_type_JavaLangInteger != null)) {
      return;
    }
    try
    {
      Notification localNotification = new Notification();
      localNotification.setLatestEventInfo(paramContext, "SearchForTitle", "SearchForText", null);
      paramContext = (ViewGroup)localNotification.contentView.apply(paramContext, null);
      a(paramContext);
      b(paramContext);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  protected boolean a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForTitle".equals(localTextView.getText().toString()))
        {
          this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.jdField_b_of_type_Float = localTextView.getTextSize();
          this.jdField_b_of_type_Float /= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (a((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public Integer b()
  {
    return this.jdField_b_of_type_JavaLangInteger;
  }
  
  protected boolean b(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForText".equals(localTextView.getText().toString()))
        {
          this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.jdField_a_of_type_Float = localTextView.getTextSize();
          this.jdField_a_of_type_Float /= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (b((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bflp
 * JD-Core Version:    0.7.0.1
 */