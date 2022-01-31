import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class atbq
  implements View.OnClickListener
{
  atbq(atbp paramatbp) {}
  
  public void onClick(View paramView)
  {
    atcg.a.a(31, null);
    atam.a(atbp.a(this.a).getApplicationContext(), this.a.a).a();
    atbp.a(this.a).finish();
    atbp.a(this.a).opType("huiyin").opName("loading_close").d1(String.valueOf(bdin.a(atbp.a(this.a).getApplicationContext()))).d2(String.valueOf(atbp.a(this.a))).report();
    if (atbp.a(this.a) == 1)
    {
      if (!bdin.a(atbp.a(this.a).getApplicationContext())) {
        atbp.a(this.a).opType("huiyin").opName("plugin_download_close").report();
      }
    }
    else {
      return;
    }
    atbp.a(this.a).opType("huiyin").opName("plugin_download_loading_close").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbq
 * JD-Core Version:    0.7.0.1
 */