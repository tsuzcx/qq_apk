import android.content.Context;
import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;

public class asto
{
  protected Context a;
  protected astm a;
  protected astm b;
  protected astm c;
  
  public asto(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public astm a(int paramInt, astg paramastg)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_Astm == null) {
        this.jdField_a_of_type_Astm = new astn(this.jdField_a_of_type_AndroidContentContext, 2130845479, paramastg);
      }
      return this.jdField_a_of_type_Astm;
    case 2: 
      if (this.c == null) {
        this.c = new PayLikeFloatViewBuilder(this.jdField_a_of_type_AndroidContentContext, 2130842245, paramastg);
      }
      return this.c;
    }
    if (this.b == null) {
      this.b = new astn(this.jdField_a_of_type_AndroidContentContext, 2130845483, paramastg);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asto
 * JD-Core Version:    0.7.0.1
 */