import android.content.BroadcastReceiver;
import android.content.Context;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class belr
{
  private static volatile belr jdField_a_of_type_Belr;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bels(this);
  private belt jdField_a_of_type_Belt;
  
  public static belr a()
  {
    if (jdField_a_of_type_Belr == null) {}
    try
    {
      if (jdField_a_of_type_Belr == null) {
        jdField_a_of_type_Belr = new belr();
      }
      return jdField_a_of_type_Belr;
    }
    finally {}
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.jdField_a_of_type_Belt != null))
    {
      MiniAppEnv.g().getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Belt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     belr
 * JD-Core Version:    0.7.0.1
 */