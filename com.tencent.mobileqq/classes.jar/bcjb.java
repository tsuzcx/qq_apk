import android.view.View;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import java.lang.reflect.Method;

public class bcjb
  implements bfph
{
  public bcjb(WerewolvesHostInterface paramWerewolvesHostInterface, Object paramObject, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = bcio.a(this.jdField_a_of_type_JavaLangObject.getClass(), "onClick", new Class[] { Integer.TYPE });
    try
    {
      paramView.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Bfpc.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcjb
 * JD-Core Version:    0.7.0.1
 */