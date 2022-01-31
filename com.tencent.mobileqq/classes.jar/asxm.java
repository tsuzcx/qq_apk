import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class asxm
  implements View.OnClickListener
{
  asxm(asxl paramasxl) {}
  
  public void onClick(View paramView)
  {
    this.a.a.c = "download";
    asxg.a(this.a.a).opType("huiyin").opName("plugin_download_click").d1(String.valueOf(bdee.a(asxg.a(this.a.a).getApplicationContext()))).report();
    asxg.a(this.a.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxm
 * JD-Core Version:    0.7.0.1
 */