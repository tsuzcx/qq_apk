import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class argv
  implements arfp
{
  argv(argq paramargq) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((argq.a(this.a).isFinishing()) && (!this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if ((!argq.a(this.a)) || (this.a.jdField_a_of_type_Boolean)) {
        break;
      }
    } while ((paramInt != 8) && (paramInt != 7));
    argq.a(this.a).finish();
    this.a.jdField_a_of_type_Bcpq.dismiss();
    return;
    argq.a(this.a, paramInt);
    argq.a(this.a).setVisibility(8);
    argq.a(this.a).setVisibility(8);
    argq.a(this.a).setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      argq.a(this.a).setVisibility(4);
      argq.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      if (argq.b(this.a))
      {
        argq.a(this.a).setVisibility(0);
        argq.a(this.a).setVisibility(0);
        argq.a(this.a).setText(ajyc.a(2131705655));
        localObject = ajyc.a(2131705658);
        paramBundle = (Bundle)localObject;
        if (argq.a(this.a) != 0L) {
          paramBundle = (String)localObject + "(" + arev.a(argq.a(this.a)) + ")";
        }
        argq.a(this.a).setText(paramBundle);
        argq.a(this.a).setOnClickListener(new argw(this));
      }
      Log.i("huiyin.loading", "checkVersion? " + argq.b(this.a) + "checkversion ok " + argq.a(this.a));
      return;
    case 1: 
      argq.a(this.a).setVisibility(0);
      paramInt = paramBundle.getInt("key_progress", 0);
      argq.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      argq.a(this.a).setProgress(paramInt);
      paramBundle = arev.a(argq.a(this.a) * paramInt / 100L);
      localObject = arev.a(argq.a(this.a));
      argq.b(this.a).setText(paramBundle + "/" + (String)localObject);
      Log.i("huiyin.loading", "downloading... " + paramInt);
      return;
    case 2: 
      argq.a(this.a).setVisibility(0);
      argq.b(this.a).setText(ajyc.a(2131705659));
      paramBundle = Message.obtain();
      paramBundle.arg1 = 10;
      argq.a(this.a).sendMessage(paramBundle);
      Log.i("huiyin.loading", "download complete");
      if (argq.b(this.a) != 0L)
      {
        localObject = argq.a(this.a).opType("huiyin").opName("plugin_download_loading_view");
        if (!bbev.h(argq.a(this.a).getApplicationContext())) {
          break label670;
        }
      }
      for (paramBundle = "3";; paramBundle = "2")
      {
        ((IVPluginDataReporter)localObject).d1(paramBundle).d2(String.valueOf(System.currentTimeMillis() - argq.b(this.a))).d3(String.valueOf(this.a.jdField_a_of_type_Boolean)).report();
        arhh.a.a(50, null);
        return;
      }
    case 3: 
      arhh.a.a(41, null);
      argq.a(this.a).setVisibility(4);
      argq.a(this.a).setVisibility(0);
      localObject = ajyc.a(2131705657);
      paramBundle = (Bundle)localObject;
      if (argq.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + arev.a(argq.a(this.a)) + ")";
      }
      argq.a(this.a).setText(paramBundle);
      if (!bbev.g(argq.a(this.a).getApplicationContext()))
      {
        argq.a(this.a).setVisibility(0);
        argq.a(this.a).setText(ajyc.a(2131705652));
      }
      argq.a(this.a).opType("huiyin").opName("download_result").d1("1").d2(String.valueOf(bbev.a(argq.a(this.a).getApplicationContext()))).report();
      argq.a(this.a).setOnClickListener(new argx(this));
      Log.i("huiyin.loading", "download fail");
      return;
    case 5: 
    case 7: 
      argq.a(this.a).setVisibility(4);
      localObject = ajyc.a(2131705651);
      paramBundle = (Bundle)localObject;
      if (argq.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + arev.a(argq.a(this.a)) + ")";
      }
      argq.a(this.a).setText(paramBundle);
      argq.a(this.a).setOnClickListener(new argy(this));
      Log.i("huiyin.loading", "preload or load fail");
      argq.a(this.a).opType("huiyin").opName("launch_result").d1("1").report();
      arhh.a.a(51, null);
      return;
    case 4: 
      argq.a(this.a).setVisibility(0);
      argq.b(this.a).setText(ajyc.a(2131705656));
      return;
    case 6: 
      argq.a(this.a).setVisibility(0);
      argq.b(this.a, 90);
      argq.a(this.a).setProgress(90);
      argq.b(this.a).setText(ajyc.a(2131705653));
      Log.i("huiyin.loading", "load complete");
      return;
    case 9: 
      label670:
      if (this.a.jdField_a_of_type_Bcpq != null) {
        this.a.jdField_a_of_type_Bcpq.dismiss();
      }
      argq.a(this.a).finish();
      arhh.a.a(61, null);
      return;
    }
    argq.a(this.a).setVisibility(0);
    argq.b(this.a, 100);
    argq.a(this.a).setProgress(100);
    Log.i("huiyin.loading", "launch complete");
    argq.a(this.a).finish();
    Object localObject = argq.a(this.a).opType("huiyin").opName("launch_result").d1("0").d2(String.valueOf(System.currentTimeMillis() - argq.c(this.a)));
    if (this.a.jdField_a_of_type_Boolean) {}
    for (paramBundle = "1";; paramBundle = "2")
    {
      ((IVPluginDataReporter)localObject).d4(paramBundle).report();
      arhh.a.a(60, String.valueOf(System.currentTimeMillis() - argq.c(this.a)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argv
 * JD-Core Version:    0.7.0.1
 */