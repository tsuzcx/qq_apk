import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.PokeBigResHandler.NetEngine.1;

public class apds
  implements beuq
{
  public void onResp(bevm parambevm)
  {
    if (parambevm.jdField_a_of_type_Int == 0) {
      ThreadManagerV2.excute(new PokeBigResHandler.NetEngine.1(this, parambevm.jdField_a_of_type_Bevl.c), 64, null, true);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    Log.e("Ron", "req:[" + parambevl.toString() + "\n curOffset" + paramLong1 + "\n totalLen" + paramLong2 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apds
 * JD-Core Version:    0.7.0.1
 */