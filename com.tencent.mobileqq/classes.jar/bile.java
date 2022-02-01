import android.view.View;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import java.lang.reflect.Method;

public class bile
  implements bkzq
{
  public bile(WerewolvesHostInterface paramWerewolvesHostInterface, Object paramObject, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = bikr.a(this.jdField_a_of_type_JavaLangObject.getClass(), "onClick", new Class[] { Integer.TYPE });
    try
    {
      paramView.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Bkzi.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bile
 * JD-Core Version:    0.7.0.1
 */