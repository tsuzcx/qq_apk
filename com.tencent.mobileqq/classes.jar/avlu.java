import android.content.Context;
import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;

public class avlu
{
  protected Context a;
  protected avls a;
  protected avls b;
  protected avls c;
  
  public avlu(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public avls a(int paramInt, avlm paramavlm)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_Avls == null) {
        this.jdField_a_of_type_Avls = new avlt(this.jdField_a_of_type_AndroidContentContext, 2130845879, paramavlm);
      }
      return this.jdField_a_of_type_Avls;
    case 2: 
      if (this.c == null) {
        this.c = new PayLikeFloatViewBuilder(this.jdField_a_of_type_AndroidContentContext, 2130842643, paramavlm);
      }
      return this.c;
    }
    if (this.b == null) {
      this.b = new avlt(this.jdField_a_of_type_AndroidContentContext, 2130845883, paramavlm);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avlu
 * JD-Core Version:    0.7.0.1
 */