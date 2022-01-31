import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class aqmm
  implements View.OnClickListener
{
  aqmm(aqml paramaqml) {}
  
  public void onClick(View paramView)
  {
    aqnc.a.a(31, null);
    aqli.a(aqml.a(this.a).getApplicationContext(), this.a.a).a();
    aqml.a(this.a).finish();
    aqml.a(this.a).opType("huiyin").opName("loading_close").d1(String.valueOf(badq.a(aqml.a(this.a).getApplicationContext()))).d2(String.valueOf(aqml.a(this.a))).report();
    if (aqml.a(this.a) == 1)
    {
      if (!badq.a(aqml.a(this.a).getApplicationContext())) {
        aqml.a(this.a).opType("huiyin").opName("plugin_download_close").report();
      }
    }
    else {
      return;
    }
    aqml.a(this.a).opType("huiyin").opName("plugin_download_loading_close").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqmm
 * JD-Core Version:    0.7.0.1
 */