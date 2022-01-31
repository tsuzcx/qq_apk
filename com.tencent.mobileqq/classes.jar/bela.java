import android.content.BroadcastReceiver;
import android.content.Context;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class bela
{
  private static volatile bela jdField_a_of_type_Bela;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new belb(this);
  private belc jdField_a_of_type_Belc;
  
  public static bela a()
  {
    if (jdField_a_of_type_Bela == null) {}
    try
    {
      if (jdField_a_of_type_Bela == null) {
        jdField_a_of_type_Bela = new bela();
      }
      return jdField_a_of_type_Bela;
    }
    finally {}
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.jdField_a_of_type_Belc != null))
    {
      MiniAppEnv.g().getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Belc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bela
 * JD-Core Version:    0.7.0.1
 */