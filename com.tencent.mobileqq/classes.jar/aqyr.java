import android.content.Context;
import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;

public class aqyr
{
  protected Context a;
  protected aqyp a;
  protected aqyp b;
  protected aqyp c;
  
  public aqyr(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public aqyp a(int paramInt, aqyj paramaqyj)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_Aqyp == null) {
        this.jdField_a_of_type_Aqyp = new aqyq(this.jdField_a_of_type_AndroidContentContext, 2130845042, paramaqyj);
      }
      return this.jdField_a_of_type_Aqyp;
    case 2: 
      if (this.c == null) {
        this.c = new PayLikeFloatViewBuilder(this.jdField_a_of_type_AndroidContentContext, 2130842079, paramaqyj);
      }
      return this.c;
    }
    if (this.b == null) {
      this.b = new aqyq(this.jdField_a_of_type_AndroidContentContext, 2130845046, paramaqyj);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqyr
 * JD-Core Version:    0.7.0.1
 */