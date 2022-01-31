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

class argx
  implements arfr
{
  argx(args paramargs) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((args.a(this.a).isFinishing()) && (!this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if ((!args.a(this.a)) || (this.a.jdField_a_of_type_Boolean)) {
        break;
      }
    } while ((paramInt != 8) && (paramInt != 7));
    args.a(this.a).finish();
    this.a.jdField_a_of_type_Bcqf.dismiss();
    return;
    args.a(this.a, paramInt);
    args.a(this.a).setVisibility(8);
    args.a(this.a).setVisibility(8);
    args.a(this.a).setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      args.a(this.a).setVisibility(4);
      args.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      if (args.b(this.a))
      {
        args.a(this.a).setVisibility(0);
        args.a(this.a).setVisibility(0);
        args.a(this.a).setText(ajya.a(2131705666));
        localObject = ajya.a(2131705669);
        paramBundle = (Bundle)localObject;
        if (args.a(this.a) != 0L) {
          paramBundle = (String)localObject + "(" + arex.a(args.a(this.a)) + ")";
        }
        args.a(this.a).setText(paramBundle);
        args.a(this.a).setOnClickListener(new argy(this));
      }
      Log.i("huiyin.loading", "checkVersion? " + args.b(this.a) + "checkversion ok " + args.a(this.a));
      return;
    case 1: 
      args.a(this.a).setVisibility(0);
      paramInt = paramBundle.getInt("key_progress", 0);
      args.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      args.a(this.a).setProgress(paramInt);
      paramBundle = arex.a(args.a(this.a) * paramInt / 100L);
      localObject = arex.a(args.a(this.a));
      args.b(this.a).setText(paramBundle + "/" + (String)localObject);
      Log.i("huiyin.loading", "downloading... " + paramInt);
      return;
    case 2: 
      args.a(this.a).setVisibility(0);
      args.b(this.a).setText(ajya.a(2131705670));
      paramBundle = Message.obtain();
      paramBundle.arg1 = 10;
      args.a(this.a).sendMessage(paramBundle);
      Log.i("huiyin.loading", "download complete");
      if (args.b(this.a) != 0L)
      {
        localObject = args.a(this.a).opType("huiyin").opName("plugin_download_loading_view");
        if (!bbfj.h(args.a(this.a).getApplicationContext())) {
          break label670;
        }
      }
      for (paramBundle = "3";; paramBundle = "2")
      {
        ((IVPluginDataReporter)localObject).d1(paramBundle).d2(String.valueOf(System.currentTimeMillis() - args.b(this.a))).d3(String.valueOf(this.a.jdField_a_of_type_Boolean)).report();
        arhj.a.a(50, null);
        return;
      }
    case 3: 
      arhj.a.a(41, null);
      args.a(this.a).setVisibility(4);
      args.a(this.a).setVisibility(0);
      localObject = ajya.a(2131705668);
      paramBundle = (Bundle)localObject;
      if (args.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + arex.a(args.a(this.a)) + ")";
      }
      args.a(this.a).setText(paramBundle);
      if (!bbfj.g(args.a(this.a).getApplicationContext()))
      {
        args.a(this.a).setVisibility(0);
        args.a(this.a).setText(ajya.a(2131705663));
      }
      args.a(this.a).opType("huiyin").opName("download_result").d1("1").d2(String.valueOf(bbfj.a(args.a(this.a).getApplicationContext()))).report();
      args.a(this.a).setOnClickListener(new argz(this));
      Log.i("huiyin.loading", "download fail");
      return;
    case 5: 
    case 7: 
      args.a(this.a).setVisibility(4);
      localObject = ajya.a(2131705662);
      paramBundle = (Bundle)localObject;
      if (args.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + arex.a(args.a(this.a)) + ")";
      }
      args.a(this.a).setText(paramBundle);
      args.a(this.a).setOnClickListener(new arha(this));
      Log.i("huiyin.loading", "preload or load fail");
      args.a(this.a).opType("huiyin").opName("launch_result").d1("1").report();
      arhj.a.a(51, null);
      return;
    case 4: 
      args.a(this.a).setVisibility(0);
      args.b(this.a).setText(ajya.a(2131705667));
      return;
    case 6: 
      args.a(this.a).setVisibility(0);
      args.b(this.a, 90);
      args.a(this.a).setProgress(90);
      args.b(this.a).setText(ajya.a(2131705664));
      Log.i("huiyin.loading", "load complete");
      return;
    case 9: 
      label670:
      if (this.a.jdField_a_of_type_Bcqf != null) {
        this.a.jdField_a_of_type_Bcqf.dismiss();
      }
      args.a(this.a).finish();
      arhj.a.a(61, null);
      return;
    }
    args.a(this.a).setVisibility(0);
    args.b(this.a, 100);
    args.a(this.a).setProgress(100);
    Log.i("huiyin.loading", "launch complete");
    args.a(this.a).finish();
    Object localObject = args.a(this.a).opType("huiyin").opName("launch_result").d1("0").d2(String.valueOf(System.currentTimeMillis() - args.c(this.a)));
    if (this.a.jdField_a_of_type_Boolean) {}
    for (paramBundle = "1";; paramBundle = "2")
    {
      ((IVPluginDataReporter)localObject).d4(paramBundle).report();
      arhj.a.a(60, String.valueOf(System.currentTimeMillis() - args.c(this.a)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argx
 * JD-Core Version:    0.7.0.1
 */