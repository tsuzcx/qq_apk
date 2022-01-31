import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class argt
  implements arfk
{
  argt(argq paramargq) {}
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    argq.a(this.a, paramBoolean);
    int i;
    if (!bbev.a(argq.a(this.a).getApplicationContext()))
    {
      i = 1;
      if (!paramBoolean) {
        break label190;
      }
      localObject = arhh.a;
      if (i != 0) {
        break label185;
      }
    }
    label185:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((arhi)localObject).a(33, String.valueOf(paramBoolean));
      argq.a(this.a).findViewById(16908290).setVisibility(8);
      if (!argq.a(this.a).isFinishing())
      {
        if (this.a.jdField_a_of_type_Bcpq != null) {
          this.a.jdField_a_of_type_Bcpq.dismiss();
        }
        this.a.jdField_a_of_type_Bcpq = new bcpq(argq.a(this.a), 40);
        this.a.jdField_a_of_type_Bcpq.a(ajyc.a(2131705649));
        this.a.jdField_a_of_type_Bcpq.setOnDismissListener(new argu(this));
        this.a.jdField_a_of_type_Bcpq.show();
      }
      argq.a(this.a, false);
      return;
      i = 0;
      break;
    }
    label190:
    Object localObject = arhh.a;
    if (i == 0)
    {
      paramBoolean = true;
      ((arhi)localObject).a(34, String.valueOf(paramBoolean));
      localObject = argq.a(this.a).opType("huiyin").opName("hy_plugin_down");
      if (i != 0) {
        break label331;
      }
      paramBoolean = true;
      label237:
      ((IVPluginDataReporter)localObject).d1(String.valueOf(paramBoolean)).d2(String.valueOf(this.a.jdField_a_of_type_Boolean)).report();
      argq.a(this.a).findViewById(16908290).setVisibility(0);
      if (i == 0) {
        break label336;
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        argq.a(this.a).opType("huiyin").opName("plugin_view").report();
      }
      argq.a(this.a, true);
    }
    for (;;)
    {
      argi.b("2880338");
      return;
      paramBoolean = false;
      break;
      label331:
      paramBoolean = false;
      break label237;
      label336:
      if (!this.a.jdField_a_of_type_Boolean) {
        argq.a(this.a).opType("huiyin").opName("plugin_download_loading_view").d1("3").report();
      }
      argq.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argt
 * JD-Core Version:    0.7.0.1
 */