import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;

public class bglh
{
  private static volatile bglh jdField_a_of_type_Bglh;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bgli(this);
  private bglj jdField_a_of_type_Bglj;
  
  public static bglh a()
  {
    if (jdField_a_of_type_Bglh == null) {}
    try
    {
      if (jdField_a_of_type_Bglh == null) {
        jdField_a_of_type_Bglh = new bglh();
      }
      return jdField_a_of_type_Bglh;
    }
    finally {}
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.jdField_a_of_type_Bglj != null))
    {
      AppLoaderFactory.g().getMiniAppEnv().getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Bglj = null;
    }
  }
  
  public void a(bglj parambglj)
  {
    this.jdField_a_of_type_Bglj = parambglj;
    parambglj = new IntentFilter();
    parambglj.addAction("android.intent.action.SCREEN_ON");
    parambglj.addAction("android.intent.action.SCREEN_OFF");
    AppLoaderFactory.g().getMiniAppEnv().getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, parambglj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglh
 * JD-Core Version:    0.7.0.1
 */