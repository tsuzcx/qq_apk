import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.PokeBigResHandler.NetEngine.1;

public class ammw
  implements bapx
{
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_a_of_type_Int == 0) {
      ThreadManagerV2.excute(new PokeBigResHandler.NetEngine.1(this, parambaqw.jdField_a_of_type_Baqv.c), 64, null, true);
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    Log.e("Ron", "req:[" + parambaqv.toString() + "\n curOffset" + paramLong1 + "\n totalLen" + paramLong2 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ammw
 * JD-Core Version:    0.7.0.1
 */