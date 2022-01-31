import android.content.Context;
import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;

public class aqyp
{
  protected Context a;
  protected aqyn a;
  protected aqyn b;
  protected aqyn c;
  
  public aqyp(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public aqyn a(int paramInt, aqyh paramaqyh)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_Aqyn == null) {
        this.jdField_a_of_type_Aqyn = new aqyo(this.jdField_a_of_type_AndroidContentContext, 2130845041, paramaqyh);
      }
      return this.jdField_a_of_type_Aqyn;
    case 2: 
      if (this.c == null) {
        this.c = new PayLikeFloatViewBuilder(this.jdField_a_of_type_AndroidContentContext, 2130842078, paramaqyh);
      }
      return this.c;
    }
    if (this.b == null) {
      this.b = new aqyo(this.jdField_a_of_type_AndroidContentContext, 2130845045, paramaqyh);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqyp
 * JD-Core Version:    0.7.0.1
 */