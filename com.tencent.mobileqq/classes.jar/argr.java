import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class argr
  implements View.OnClickListener
{
  argr(argq paramargq) {}
  
  public void onClick(View paramView)
  {
    arhh.a.a(31, null);
    arfn.a(argq.a(this.a).getApplicationContext(), this.a.a).a();
    argq.a(this.a).finish();
    argq.a(this.a).opType("huiyin").opName("loading_close").d1(String.valueOf(bbev.a(argq.a(this.a).getApplicationContext()))).d2(String.valueOf(argq.a(this.a))).report();
    if (argq.a(this.a) == 1)
    {
      if (!bbev.a(argq.a(this.a).getApplicationContext())) {
        argq.a(this.a).opType("huiyin").opName("plugin_download_close").report();
      }
    }
    else {
      return;
    }
    argq.a(this.a).opType("huiyin").opName("plugin_download_loading_close").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argr
 * JD-Core Version:    0.7.0.1
 */