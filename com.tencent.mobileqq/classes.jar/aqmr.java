import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class aqmr
  implements View.OnClickListener
{
  aqmr(aqmq paramaqmq) {}
  
  public void onClick(View paramView)
  {
    this.a.a.c = "download";
    aqml.a(this.a.a).opType("huiyin").opName("plugin_download_click").d1(String.valueOf(badq.a(aqml.a(this.a.a).getApplicationContext()))).report();
    aqml.a(this.a.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqmr
 * JD-Core Version:    0.7.0.1
 */