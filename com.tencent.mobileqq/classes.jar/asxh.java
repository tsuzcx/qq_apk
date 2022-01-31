import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class asxh
  implements View.OnClickListener
{
  asxh(asxg paramasxg) {}
  
  public void onClick(View paramView)
  {
    asxx.a.a(31, null);
    aswd.a(asxg.a(this.a).getApplicationContext(), this.a.a).a();
    asxg.a(this.a).finish();
    asxg.a(this.a).opType("huiyin").opName("loading_close").d1(String.valueOf(bdee.a(asxg.a(this.a).getApplicationContext()))).d2(String.valueOf(asxg.a(this.a))).report();
    if (asxg.a(this.a) == 1)
    {
      if (!bdee.a(asxg.a(this.a).getApplicationContext())) {
        asxg.a(this.a).opType("huiyin").opName("plugin_download_close").report();
      }
    }
    else {
      return;
    }
    asxg.a(this.a).opType("huiyin").opName("plugin_download_loading_close").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxh
 * JD-Core Version:    0.7.0.1
 */