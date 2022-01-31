import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class aqmo
  implements aqlf
{
  aqmo(aqml paramaqml) {}
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    aqml.a(this.a, paramBoolean);
    int i;
    if (!badq.a(aqml.a(this.a).getApplicationContext()))
    {
      i = 1;
      if (!paramBoolean) {
        break label190;
      }
      localObject = aqnc.a;
      if (i != 0) {
        break label185;
      }
    }
    label185:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((aqnd)localObject).a(33, String.valueOf(paramBoolean));
      aqml.a(this.a).findViewById(16908290).setVisibility(8);
      if (!aqml.a(this.a).isFinishing())
      {
        if (this.a.jdField_a_of_type_Bbms != null) {
          this.a.jdField_a_of_type_Bbms.dismiss();
        }
        this.a.jdField_a_of_type_Bbms = new bbms(aqml.a(this.a), 40);
        this.a.jdField_a_of_type_Bbms.a(ajjy.a(2131639864));
        this.a.jdField_a_of_type_Bbms.setOnDismissListener(new aqmp(this));
        this.a.jdField_a_of_type_Bbms.show();
      }
      aqml.a(this.a, false);
      return;
      i = 0;
      break;
    }
    label190:
    Object localObject = aqnc.a;
    if (i == 0)
    {
      paramBoolean = true;
      ((aqnd)localObject).a(34, String.valueOf(paramBoolean));
      localObject = aqml.a(this.a).opType("huiyin").opName("hy_plugin_down");
      if (i != 0) {
        break label331;
      }
      paramBoolean = true;
      label237:
      ((IVPluginDataReporter)localObject).d1(String.valueOf(paramBoolean)).d2(String.valueOf(this.a.jdField_a_of_type_Boolean)).report();
      aqml.a(this.a).findViewById(16908290).setVisibility(0);
      if (i == 0) {
        break label336;
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        aqml.a(this.a).opType("huiyin").opName("plugin_view").report();
      }
      aqml.a(this.a, true);
    }
    for (;;)
    {
      aqmd.b("2880338");
      return;
      paramBoolean = false;
      break;
      label331:
      paramBoolean = false;
      break label237;
      label336:
      if (!this.a.jdField_a_of_type_Boolean) {
        aqml.a(this.a).opType("huiyin").opName("plugin_download_loading_view").d1("3").report();
      }
      aqml.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqmo
 * JD-Core Version:    0.7.0.1
 */