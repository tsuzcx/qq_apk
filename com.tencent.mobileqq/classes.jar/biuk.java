import android.view.View;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import java.lang.reflect.Method;

public class biuk
  implements bliz
{
  public biuk(WerewolvesHostInterface paramWerewolvesHostInterface, Object paramObject, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = bitx.a(this.jdField_a_of_type_JavaLangObject.getClass(), "onClick", new Class[] { Integer.TYPE });
    try
    {
      paramView.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Blir.dismiss();
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
 * Qualified Name:     biuk
 * JD-Core Version:    0.7.0.1
 */