import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class bmue
  extends bmuf
{
  private float a;
  private float b;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  
  public bmue(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  private void a(String paramString)
  {
    try
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView).setTextSize(0, a(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private int b(String paramString)
  {
    int j = 3;
    if (TextUtils.isEmpty(paramString)) {
      throw new RuntimeException(getClass().getName() + " setGravity value can not be null");
    }
    int i;
    if ("center".equals(paramString)) {
      i = 17;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while ("left".equals(paramString));
      i = j;
    } while (!"right".equals(paramString));
    return 5;
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setTextColor(Color.parseColor(paramString));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!(this.jdField_a_of_type_AndroidViewView instanceof TextView)) {}
    do
    {
      return;
      if ("content".equals(paramString1))
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(paramString2);
        return;
      }
      if ("text_color".equals(paramString1))
      {
        b(paramString2);
        return;
      }
      if ("text_align".equals(paramString1))
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setGravity(b(paramString2));
        return;
      }
      if ("max_lines".equals(paramString1))
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setMaxLines(Integer.parseInt(paramString2));
        return;
      }
      if ("shadow_color".equals(paramString1))
      {
        this.jdField_c_of_type_Int = Color.parseColor(paramString2);
        return;
      }
      if ("shadow_x".equals(paramString1))
      {
        this.jdField_a_of_type_Float = Float.parseFloat(paramString2);
        return;
      }
      if ("shadow_y".equals(paramString1))
      {
        this.b = Float.parseFloat(paramString2);
        return;
      }
      if ("shadow_radius".equals(paramString1))
      {
        this.jdField_c_of_type_Float = Float.parseFloat(paramString2);
        return;
      }
    } while (!"text_size".equals(paramString1));
    a(paramString2);
  }
  
  protected void b()
  {
    super.b();
    ((TextView)this.jdField_a_of_type_AndroidViewView).setShadowLayer(this.jdField_c_of_type_Float, this.jdField_a_of_type_Float, this.b, this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmue
 * JD-Core Version:    0.7.0.1
 */