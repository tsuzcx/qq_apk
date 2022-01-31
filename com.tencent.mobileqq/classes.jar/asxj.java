import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class asxj
  implements aswa
{
  asxj(asxg paramasxg) {}
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    asxg.a(this.a, paramBoolean);
    int i;
    if (!bdee.a(asxg.a(this.a).getApplicationContext()))
    {
      i = 1;
      if (!paramBoolean) {
        break label190;
      }
      localObject = asxx.a;
      if (i != 0) {
        break label185;
      }
    }
    label185:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((asxy)localObject).a(33, String.valueOf(paramBoolean));
      asxg.a(this.a).findViewById(16908290).setVisibility(8);
      if (!asxg.a(this.a).isFinishing())
      {
        if (this.a.jdField_a_of_type_Bepp != null) {
          this.a.jdField_a_of_type_Bepp.dismiss();
        }
        this.a.jdField_a_of_type_Bepp = new bepp(asxg.a(this.a), 40);
        this.a.jdField_a_of_type_Bepp.a(alpo.a(2131706032));
        this.a.jdField_a_of_type_Bepp.setOnDismissListener(new asxk(this));
        this.a.jdField_a_of_type_Bepp.show();
      }
      asxg.a(this.a, false);
      return;
      i = 0;
      break;
    }
    label190:
    Object localObject = asxx.a;
    if (i == 0)
    {
      paramBoolean = true;
      ((asxy)localObject).a(34, String.valueOf(paramBoolean));
      localObject = asxg.a(this.a).opType("huiyin").opName("hy_plugin_down");
      if (i != 0) {
        break label331;
      }
      paramBoolean = true;
      label237:
      ((IVPluginDataReporter)localObject).d1(String.valueOf(paramBoolean)).d2(String.valueOf(this.a.jdField_a_of_type_Boolean)).report();
      asxg.a(this.a).findViewById(16908290).setVisibility(0);
      if (i == 0) {
        break label336;
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        asxg.a(this.a).opType("huiyin").opName("plugin_view").report();
      }
      asxg.a(this.a, true);
    }
    for (;;)
    {
      aswy.b("2880338");
      return;
      paramBoolean = false;
      break;
      label331:
      paramBoolean = false;
      break label237;
      label336:
      if (!this.a.jdField_a_of_type_Boolean) {
        asxg.a(this.a).opType("huiyin").opName("plugin_download_loading_view").d1("3").report();
      }
      asxg.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxj
 * JD-Core Version:    0.7.0.1
 */