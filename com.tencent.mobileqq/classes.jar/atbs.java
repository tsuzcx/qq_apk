import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class atbs
  implements ataj
{
  atbs(atbp paramatbp) {}
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    atbp.a(this.a, paramBoolean);
    int i;
    if (!bdin.a(atbp.a(this.a).getApplicationContext()))
    {
      i = 1;
      if (!paramBoolean) {
        break label190;
      }
      localObject = atcg.a;
      if (i != 0) {
        break label185;
      }
    }
    label185:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((atch)localObject).a(33, String.valueOf(paramBoolean));
      atbp.a(this.a).findViewById(16908290).setVisibility(8);
      if (!atbp.a(this.a).isFinishing())
      {
        if (this.a.jdField_a_of_type_Bety != null) {
          this.a.jdField_a_of_type_Bety.dismiss();
        }
        this.a.jdField_a_of_type_Bety = new bety(atbp.a(this.a), 40);
        this.a.jdField_a_of_type_Bety.a(alud.a(2131706044));
        this.a.jdField_a_of_type_Bety.setOnDismissListener(new atbt(this));
        this.a.jdField_a_of_type_Bety.show();
      }
      atbp.a(this.a, false);
      return;
      i = 0;
      break;
    }
    label190:
    Object localObject = atcg.a;
    if (i == 0)
    {
      paramBoolean = true;
      ((atch)localObject).a(34, String.valueOf(paramBoolean));
      localObject = atbp.a(this.a).opType("huiyin").opName("hy_plugin_down");
      if (i != 0) {
        break label331;
      }
      paramBoolean = true;
      label237:
      ((IVPluginDataReporter)localObject).d1(String.valueOf(paramBoolean)).d2(String.valueOf(this.a.jdField_a_of_type_Boolean)).report();
      atbp.a(this.a).findViewById(16908290).setVisibility(0);
      if (i == 0) {
        break label336;
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        atbp.a(this.a).opType("huiyin").opName("plugin_view").report();
      }
      atbp.a(this.a, true);
    }
    for (;;)
    {
      atbh.b("2880338");
      return;
      paramBoolean = false;
      break;
      label331:
      paramBoolean = false;
      break label237;
      label336:
      if (!this.a.jdField_a_of_type_Boolean) {
        atbp.a(this.a).opType("huiyin").opName("plugin_download_loading_view").d1("3").report();
      }
      atbp.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbs
 * JD-Core Version:    0.7.0.1
 */