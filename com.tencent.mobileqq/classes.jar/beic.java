import android.view.View;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import java.lang.reflect.Method;

public class beic
  implements bhqd
{
  public beic(WerewolvesHostInterface paramWerewolvesHostInterface, Object paramObject, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = behp.a(this.jdField_a_of_type_JavaLangObject.getClass(), "onClick", new Class[] { Integer.TYPE });
    try
    {
      paramView.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beic
 * JD-Core Version:    0.7.0.1
 */