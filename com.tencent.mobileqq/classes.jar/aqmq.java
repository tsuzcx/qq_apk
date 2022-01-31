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

class aqmq
  implements aqlk
{
  aqmq(aqml paramaqml) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((aqml.a(this.a).isFinishing()) && (!this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if ((!aqml.a(this.a)) || (this.a.jdField_a_of_type_Boolean)) {
        break;
      }
    } while ((paramInt != 8) && (paramInt != 7));
    aqml.a(this.a).finish();
    this.a.jdField_a_of_type_Bbms.dismiss();
    return;
    aqml.a(this.a, paramInt);
    aqml.a(this.a).setVisibility(8);
    aqml.a(this.a).setVisibility(8);
    aqml.a(this.a).setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      aqml.a(this.a).setVisibility(4);
      aqml.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      if (aqml.b(this.a))
      {
        aqml.a(this.a).setVisibility(0);
        aqml.a(this.a).setVisibility(0);
        aqml.a(this.a).setText(ajjy.a(2131639870));
        localObject = ajjy.a(2131639873);
        paramBundle = (Bundle)localObject;
        if (aqml.a(this.a) != 0L) {
          paramBundle = (String)localObject + "(" + aqkq.a(aqml.a(this.a)) + ")";
        }
        aqml.a(this.a).setText(paramBundle);
        aqml.a(this.a).setOnClickListener(new aqmr(this));
      }
      Log.i("huiyin.loading", "checkVersion? " + aqml.b(this.a) + "checkversion ok " + aqml.a(this.a));
      return;
    case 1: 
      aqml.a(this.a).setVisibility(0);
      paramInt = paramBundle.getInt("key_progress", 0);
      aqml.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      aqml.a(this.a).setProgress(paramInt);
      paramBundle = aqkq.a(aqml.a(this.a) * paramInt / 100L);
      localObject = aqkq.a(aqml.a(this.a));
      aqml.b(this.a).setText(paramBundle + "/" + (String)localObject);
      Log.i("huiyin.loading", "downloading... " + paramInt);
      return;
    case 2: 
      aqml.a(this.a).setVisibility(0);
      aqml.b(this.a).setText(ajjy.a(2131639874));
      paramBundle = Message.obtain();
      paramBundle.arg1 = 10;
      aqml.a(this.a).sendMessage(paramBundle);
      Log.i("huiyin.loading", "download complete");
      if (aqml.b(this.a) != 0L)
      {
        localObject = aqml.a(this.a).opType("huiyin").opName("plugin_download_loading_view");
        if (!badq.h(aqml.a(this.a).getApplicationContext())) {
          break label670;
        }
      }
      for (paramBundle = "3";; paramBundle = "2")
      {
        ((IVPluginDataReporter)localObject).d1(paramBundle).d2(String.valueOf(System.currentTimeMillis() - aqml.b(this.a))).d3(String.valueOf(this.a.jdField_a_of_type_Boolean)).report();
        aqnc.a.a(50, null);
        return;
      }
    case 3: 
      aqnc.a.a(41, null);
      aqml.a(this.a).setVisibility(4);
      aqml.a(this.a).setVisibility(0);
      localObject = ajjy.a(2131639872);
      paramBundle = (Bundle)localObject;
      if (aqml.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + aqkq.a(aqml.a(this.a)) + ")";
      }
      aqml.a(this.a).setText(paramBundle);
      if (!badq.g(aqml.a(this.a).getApplicationContext()))
      {
        aqml.a(this.a).setVisibility(0);
        aqml.a(this.a).setText(ajjy.a(2131639867));
      }
      aqml.a(this.a).opType("huiyin").opName("download_result").d1("1").d2(String.valueOf(badq.a(aqml.a(this.a).getApplicationContext()))).report();
      aqml.a(this.a).setOnClickListener(new aqms(this));
      Log.i("huiyin.loading", "download fail");
      return;
    case 5: 
    case 7: 
      aqml.a(this.a).setVisibility(4);
      localObject = ajjy.a(2131639866);
      paramBundle = (Bundle)localObject;
      if (aqml.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + aqkq.a(aqml.a(this.a)) + ")";
      }
      aqml.a(this.a).setText(paramBundle);
      aqml.a(this.a).setOnClickListener(new aqmt(this));
      Log.i("huiyin.loading", "preload or load fail");
      aqml.a(this.a).opType("huiyin").opName("launch_result").d1("1").report();
      aqnc.a.a(51, null);
      return;
    case 4: 
      aqml.a(this.a).setVisibility(0);
      aqml.b(this.a).setText(ajjy.a(2131639871));
      return;
    case 6: 
      aqml.a(this.a).setVisibility(0);
      aqml.b(this.a, 90);
      aqml.a(this.a).setProgress(90);
      aqml.b(this.a).setText(ajjy.a(2131639868));
      Log.i("huiyin.loading", "load complete");
      return;
    case 9: 
      label670:
      if (this.a.jdField_a_of_type_Bbms != null) {
        this.a.jdField_a_of_type_Bbms.dismiss();
      }
      aqml.a(this.a).finish();
      aqnc.a.a(61, null);
      return;
    }
    aqml.a(this.a).setVisibility(0);
    aqml.b(this.a, 100);
    aqml.a(this.a).setProgress(100);
    Log.i("huiyin.loading", "launch complete");
    aqml.a(this.a).finish();
    Object localObject = aqml.a(this.a).opType("huiyin").opName("launch_result").d1("0").d2(String.valueOf(System.currentTimeMillis() - aqml.c(this.a)));
    if (this.a.jdField_a_of_type_Boolean) {}
    for (paramBundle = "1";; paramBundle = "2")
    {
      ((IVPluginDataReporter)localObject).d4(paramBundle).report();
      aqnc.a.a(60, String.valueOf(System.currentTimeMillis() - aqml.c(this.a)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqmq
 * JD-Core Version:    0.7.0.1
 */