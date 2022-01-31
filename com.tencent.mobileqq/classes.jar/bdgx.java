import android.content.BroadcastReceiver;
import android.content.Context;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class bdgx
{
  private static volatile bdgx jdField_a_of_type_Bdgx;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bdgy(this);
  private bdgz jdField_a_of_type_Bdgz;
  
  public static bdgx a()
  {
    if (jdField_a_of_type_Bdgx == null) {}
    try
    {
      if (jdField_a_of_type_Bdgx == null) {
        jdField_a_of_type_Bdgx = new bdgx();
      }
      return jdField_a_of_type_Bdgx;
    }
    finally {}
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.jdField_a_of_type_Bdgz != null))
    {
      MiniAppEnv.g().getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Bdgz = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdgx
 * JD-Core Version:    0.7.0.1
 */