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

class atbu
  implements atao
{
  atbu(atbp paramatbp) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((atbp.a(this.a).isFinishing()) && (!this.a.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if ((!atbp.a(this.a)) || (this.a.jdField_a_of_type_Boolean)) {
        break;
      }
    } while ((paramInt != 8) && (paramInt != 7));
    atbp.a(this.a).finish();
    this.a.jdField_a_of_type_Bety.dismiss();
    return;
    atbp.a(this.a, paramInt);
    atbp.a(this.a).setVisibility(8);
    atbp.a(this.a).setVisibility(8);
    atbp.a(this.a).setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      atbp.a(this.a).setVisibility(4);
      atbp.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      if (atbp.b(this.a))
      {
        atbp.a(this.a).setVisibility(0);
        atbp.a(this.a).setVisibility(0);
        atbp.a(this.a).setText(alud.a(2131706050));
        localObject = alud.a(2131706053);
        paramBundle = (Bundle)localObject;
        if (atbp.a(this.a) != 0L) {
          paramBundle = (String)localObject + "(" + aszu.a(atbp.a(this.a)) + ")";
        }
        atbp.a(this.a).setText(paramBundle);
        atbp.a(this.a).setOnClickListener(new atbv(this));
      }
      Log.i("huiyin.loading", "checkVersion? " + atbp.b(this.a) + "checkversion ok " + atbp.a(this.a));
      return;
    case 1: 
      atbp.a(this.a).setVisibility(0);
      paramInt = paramBundle.getInt("key_progress", 0);
      atbp.a(this.a, paramBundle.getLong("key_totalSize", 0L));
      atbp.a(this.a).setProgress(paramInt);
      paramBundle = aszu.a(atbp.a(this.a) * paramInt / 100L);
      localObject = aszu.a(atbp.a(this.a));
      atbp.b(this.a).setText(paramBundle + "/" + (String)localObject);
      Log.i("huiyin.loading", "downloading... " + paramInt);
      return;
    case 2: 
      atbp.a(this.a).setVisibility(0);
      atbp.b(this.a).setText(alud.a(2131706054));
      paramBundle = Message.obtain();
      paramBundle.arg1 = 10;
      atbp.a(this.a).sendMessage(paramBundle);
      Log.i("huiyin.loading", "download complete");
      if (atbp.b(this.a) != 0L)
      {
        localObject = atbp.a(this.a).opType("huiyin").opName("plugin_download_loading_view");
        if (!bdin.h(atbp.a(this.a).getApplicationContext())) {
          break label670;
        }
      }
      for (paramBundle = "3";; paramBundle = "2")
      {
        ((IVPluginDataReporter)localObject).d1(paramBundle).d2(String.valueOf(System.currentTimeMillis() - atbp.b(this.a))).d3(String.valueOf(this.a.jdField_a_of_type_Boolean)).report();
        atcg.a.a(50, null);
        return;
      }
    case 3: 
      atcg.a.a(41, null);
      atbp.a(this.a).setVisibility(4);
      atbp.a(this.a).setVisibility(0);
      localObject = alud.a(2131706052);
      paramBundle = (Bundle)localObject;
      if (atbp.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + aszu.a(atbp.a(this.a)) + ")";
      }
      atbp.a(this.a).setText(paramBundle);
      if (!bdin.g(atbp.a(this.a).getApplicationContext()))
      {
        atbp.a(this.a).setVisibility(0);
        atbp.a(this.a).setText(alud.a(2131706047));
      }
      atbp.a(this.a).opType("huiyin").opName("download_result").d1("1").d2(String.valueOf(bdin.a(atbp.a(this.a).getApplicationContext()))).report();
      atbp.a(this.a).setOnClickListener(new atbw(this));
      Log.i("huiyin.loading", "download fail");
      return;
    case 5: 
    case 7: 
      atbp.a(this.a).setVisibility(4);
      localObject = alud.a(2131706046);
      paramBundle = (Bundle)localObject;
      if (atbp.a(this.a) != 0L) {
        paramBundle = (String)localObject + "(" + aszu.a(atbp.a(this.a)) + ")";
      }
      atbp.a(this.a).setText(paramBundle);
      atbp.a(this.a).setOnClickListener(new atbx(this));
      Log.i("huiyin.loading", "preload or load fail");
      atbp.a(this.a).opType("huiyin").opName("launch_result").d1("1").report();
      atcg.a.a(51, null);
      return;
    case 4: 
      atbp.a(this.a).setVisibility(0);
      atbp.b(this.a).setText(alud.a(2131706051));
      return;
    case 6: 
      atbp.a(this.a).setVisibility(0);
      atbp.b(this.a, 90);
      atbp.a(this.a).setProgress(90);
      atbp.b(this.a).setText(alud.a(2131706048));
      Log.i("huiyin.loading", "load complete");
      return;
    case 9: 
      label670:
      if (this.a.jdField_a_of_type_Bety != null) {
        this.a.jdField_a_of_type_Bety.dismiss();
      }
      atbp.a(this.a).finish();
      atcg.a.a(61, null);
      return;
    }
    atbp.a(this.a).setVisibility(0);
    atbp.b(this.a, 100);
    atbp.a(this.a).setProgress(100);
    Log.i("huiyin.loading", "launch complete");
    atbp.a(this.a).finish();
    Object localObject = atbp.a(this.a).opType("huiyin").opName("launch_result").d1("0").d2(String.valueOf(System.currentTimeMillis() - atbp.c(this.a)));
    if (this.a.jdField_a_of_type_Boolean) {}
    for (paramBundle = "1";; paramBundle = "2")
    {
      ((IVPluginDataReporter)localObject).d4(paramBundle).report();
      atcg.a.a(60, String.valueOf(System.currentTimeMillis() - atbp.c(this.a)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbu
 * JD-Core Version:    0.7.0.1
 */