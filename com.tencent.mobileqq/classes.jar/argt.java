import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class argt
  implements View.OnClickListener
{
  argt(args paramargs) {}
  
  public void onClick(View paramView)
  {
    arhj.a.a(31, null);
    arfp.a(args.a(this.a).getApplicationContext(), this.a.a).a();
    args.a(this.a).finish();
    args.a(this.a).opType("huiyin").opName("loading_close").d1(String.valueOf(bbfj.a(args.a(this.a).getApplicationContext()))).d2(String.valueOf(args.a(this.a))).report();
    if (args.a(this.a) == 1)
    {
      if (!bbfj.a(args.a(this.a).getApplicationContext())) {
        args.a(this.a).opType("huiyin").opName("plugin_download_close").report();
      }
    }
    else {
      return;
    }
    args.a(this.a).opType("huiyin").opName("plugin_download_loading_close").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argt
 * JD-Core Version:    0.7.0.1
 */