import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;

public class bgpo
{
  private static volatile bgpo jdField_a_of_type_Bgpo;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bgpp(this);
  private bgpq jdField_a_of_type_Bgpq;
  
  public static bgpo a()
  {
    if (jdField_a_of_type_Bgpo == null) {}
    try
    {
      if (jdField_a_of_type_Bgpo == null) {
        jdField_a_of_type_Bgpo = new bgpo();
      }
      return jdField_a_of_type_Bgpo;
    }
    finally {}
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.jdField_a_of_type_Bgpq != null))
    {
      AppLoaderFactory.g().getMiniAppEnv().getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Bgpq = null;
    }
  }
  
  public void a(bgpq parambgpq)
  {
    this.jdField_a_of_type_Bgpq = parambgpq;
    parambgpq = new IntentFilter();
    parambgpq.addAction("android.intent.action.SCREEN_ON");
    parambgpq.addAction("android.intent.action.SCREEN_OFF");
    AppLoaderFactory.g().getMiniAppEnv().getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, parambgpq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgpo
 * JD-Core Version:    0.7.0.1
 */