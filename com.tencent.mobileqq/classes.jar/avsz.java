import android.content.Context;
import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;

public class avsz
{
  protected Context a;
  protected avsx a;
  protected avsx b;
  protected avsx c;
  
  public avsz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public avsx a(int paramInt, avsr paramavsr)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_Avsx == null) {
        this.jdField_a_of_type_Avsx = new avsy(this.jdField_a_of_type_AndroidContentContext, 2130845891, paramavsr);
      }
      return this.jdField_a_of_type_Avsx;
    case 2: 
      if (this.c == null) {
        this.c = new PayLikeFloatViewBuilder(this.jdField_a_of_type_AndroidContentContext, 2130842568, paramavsr);
      }
      return this.c;
    }
    if (this.b == null) {
      this.b = new avsy(this.jdField_a_of_type_AndroidContentContext, 2130845895, paramavsr);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsz
 * JD-Core Version:    0.7.0.1
 */