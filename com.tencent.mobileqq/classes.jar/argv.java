import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

class argv
  implements arfm
{
  argv(args paramargs) {}
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    args.a(this.a, paramBoolean);
    int i;
    if (!bbfj.a(args.a(this.a).getApplicationContext()))
    {
      i = 1;
      if (!paramBoolean) {
        break label190;
      }
      localObject = arhj.a;
      if (i != 0) {
        break label185;
      }
    }
    label185:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((arhk)localObject).a(33, String.valueOf(paramBoolean));
      args.a(this.a).findViewById(16908290).setVisibility(8);
      if (!args.a(this.a).isFinishing())
      {
        if (this.a.jdField_a_of_type_Bcqf != null) {
          this.a.jdField_a_of_type_Bcqf.dismiss();
        }
        this.a.jdField_a_of_type_Bcqf = new bcqf(args.a(this.a), 40);
        this.a.jdField_a_of_type_Bcqf.a(ajya.a(2131705660));
        this.a.jdField_a_of_type_Bcqf.setOnDismissListener(new argw(this));
        this.a.jdField_a_of_type_Bcqf.show();
      }
      args.a(this.a, false);
      return;
      i = 0;
      break;
    }
    label190:
    Object localObject = arhj.a;
    if (i == 0)
    {
      paramBoolean = true;
      ((arhk)localObject).a(34, String.valueOf(paramBoolean));
      localObject = args.a(this.a).opType("huiyin").opName("hy_plugin_down");
      if (i != 0) {
        break label331;
      }
      paramBoolean = true;
      label237:
      ((IVPluginDataReporter)localObject).d1(String.valueOf(paramBoolean)).d2(String.valueOf(this.a.jdField_a_of_type_Boolean)).report();
      args.a(this.a).findViewById(16908290).setVisibility(0);
      if (i == 0) {
        break label336;
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        args.a(this.a).opType("huiyin").opName("plugin_view").report();
      }
      args.a(this.a, true);
    }
    for (;;)
    {
      argk.b("2880338");
      return;
      paramBoolean = false;
      break;
      label331:
      paramBoolean = false;
      break label237;
      label336:
      if (!this.a.jdField_a_of_type_Boolean) {
        args.a(this.a).opType("huiyin").opName("plugin_download_loading_view").d1("3").report();
      }
      args.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argv
 * JD-Core Version:    0.7.0.1
 */