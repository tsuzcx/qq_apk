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

class asxl
  implements aswf
{
  asxl(asxg paramasxg) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((asxg.a(this.a).isFinishing()) && (!this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if ((!asxg.a(this.a)) || (this.a.jdField_a_of_type_Boolean)) {
        break;
      }
    } while ((paramInt != 8) && (paramInt != 7));
    asxg.a(this.a).finish();
    this.a.jdField_a_of_type_Bepp.dismiss();
    return;
    asxg.a(this.a, paramInt);
    asxg.a(this.a).setVisibility(8);
    asxg.a(this.a).setVisibility(8);
    asxg.a(this.a).setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      asxg.a(this.a).setVisibility(4);
      asxg.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      if (asxg.b(this.a))
      {
        asxg.a(this.a).setVisibility(0);
        asxg.a(this.a).setVisibility(0);
        asxg.a(this.a).setText(alpo.a(2131706038));
        localObject = alpo.a(2131706041);
        paramBundle = (Bundle)localObject;
        if (asxg.a(this.a) != 0L) {
          paramBundle = (String)localObject + "(" + asvl.a(asxg.a(this.a)) + ")";
        }
        asxg.a(this.a).setText(paramBundle);
        asxg.a(this.a).setOnClickListener(new asxm(this));
      }
      Log.i("huiyin.loading", "checkVersion? " + asxg.b(this.a) + "checkversion ok " + asxg.a(this.a));
      return;
    case 1: 
      asxg.a(this.a).setVisibility(0);
      paramInt = paramBundle.getInt("key_progress", 0);
      asxg.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      asxg.a(this.a).setProgress(paramInt);
      paramBundle = asvl.a(asxg.a(this.a) * paramInt / 100L);
      localObject = asvl.a(asxg.a(this.a));
      asxg.b(this.a).setText(paramBundle + "/" + (String)localObject);
      Log.i("huiyin.loading", "downloading... " + paramInt);
      return;
    case 2: 
      asxg.a(this.a).setVisibility(0);
      asxg.b(this.a).setText(alpo.a(2131706042));
      paramBundle = Message.obtain();
      paramBundle.arg1 = 10;
      asxg.a(this.a).sendMessage(paramBundle);
      Log.i("huiyin.loading", "download complete");
      if (asxg.b(this.a) != 0L)
      {
        localObject = asxg.a(this.a).opType("huiyin").opName("plugin_download_loading_view");
        if (!bdee.h(asxg.a(this.a).getApplicationContext())) {
          break label670;
        }
      }
      for (paramBundle = "3";; paramBundle = "2")
      {
        ((IVPluginDataReporter)localObject).d1(paramBundle).d2(String.valueOf(System.currentTimeMillis() - asxg.b(this.a))).d3(String.valueOf(this.a.jdField_a_of_type_Boolean)).report();
        asxx.a.a(50, null);
        return;
      }
    case 3: 
      asxx.a.a(41, null);
      asxg.a(this.a).setVisibility(4);
      asxg.a(this.a).setVisibility(0);
      localObject = alpo.a(2131706040);
      paramBundle = (Bundle)localObject;
      if (asxg.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + asvl.a(asxg.a(this.a)) + ")";
      }
      asxg.a(this.a).setText(paramBundle);
      if (!bdee.g(asxg.a(this.a).getApplicationContext()))
      {
        asxg.a(this.a).setVisibility(0);
        asxg.a(this.a).setText(alpo.a(2131706035));
      }
      asxg.a(this.a).opType("huiyin").opName("download_result").d1("1").d2(String.valueOf(bdee.a(asxg.a(this.a).getApplicationContext()))).report();
      asxg.a(this.a).setOnClickListener(new asxn(this));
      Log.i("huiyin.loading", "download fail");
      return;
    case 5: 
    case 7: 
      asxg.a(this.a).setVisibility(4);
      localObject = alpo.a(2131706034);
      paramBundle = (Bundle)localObject;
      if (asxg.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + asvl.a(asxg.a(this.a)) + ")";
      }
      asxg.a(this.a).setText(paramBundle);
      asxg.a(this.a).setOnClickListener(new asxo(this));
      Log.i("huiyin.loading", "preload or load fail");
      asxg.a(this.a).opType("huiyin").opName("launch_result").d1("1").report();
      asxx.a.a(51, null);
      return;
    case 4: 
      asxg.a(this.a).setVisibility(0);
      asxg.b(this.a).setText(alpo.a(2131706039));
      return;
    case 6: 
      asxg.a(this.a).setVisibility(0);
      asxg.b(this.a, 90);
      asxg.a(this.a).setProgress(90);
      asxg.b(this.a).setText(alpo.a(2131706036));
      Log.i("huiyin.loading", "load complete");
      return;
    case 9: 
      label670:
      if (this.a.jdField_a_of_type_Bepp != null) {
        this.a.jdField_a_of_type_Bepp.dismiss();
      }
      asxg.a(this.a).finish();
      asxx.a.a(61, null);
      return;
    }
    asxg.a(this.a).setVisibility(0);
    asxg.b(this.a, 100);
    asxg.a(this.a).setProgress(100);
    Log.i("huiyin.loading", "launch complete");
    asxg.a(this.a).finish();
    Object localObject = asxg.a(this.a).opType("huiyin").opName("launch_result").d1("0").d2(String.valueOf(System.currentTimeMillis() - asxg.c(this.a)));
    if (this.a.jdField_a_of_type_Boolean) {}
    for (paramBundle = "1";; paramBundle = "2")
    {
      ((IVPluginDataReporter)localObject).d4(paramBundle).report();
      asxx.a.a(60, String.valueOf(System.currentTimeMillis() - asxg.c(this.a)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxl
 * JD-Core Version:    0.7.0.1
 */