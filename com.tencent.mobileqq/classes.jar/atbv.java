import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class atbv
  implements View.OnClickListener
{
  atbv(atbu paramatbu) {}
  
  public void onClick(View paramView)
  {
    this.a.a.c = "download";
    atbp.a(this.a.a).opType("huiyin").opName("plugin_download_click").d1(String.valueOf(bdin.a(atbp.a(this.a.a).getApplicationContext()))).report();
    atbp.a(this.a.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbv
 * JD-Core Version:    0.7.0.1
 */