import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aupg
  implements View.OnClickListener
{
  aupg(aupf paramaupf) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = 4;
    if (aupf.a(this.a) == 1)
    {
      i = 2;
      label33:
      if ((aupf.a(this.a) == null) || (!aupf.a(this.a).equals(antf.z))) {
        break label240;
      }
      i = 3;
    }
    label240:
    for (;;)
    {
      long l = atyw.b();
      bdll.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
      if (aupf.a(this.a) == 1101)
      {
        Object localObject = new ArrayList();
        ((ArrayList)localObject).addAll(atyw.a());
        Intent localIntent = new Intent();
        localIntent.putExtra("file_choose_search_result_code", "file_choose_search_result_code");
        localIntent.putParcelableArrayListExtra("reslut_select_file_info_list", (ArrayList)localObject);
        localObject = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
        ((Activity)localObject).setResult(-1, localIntent);
        ((Activity)localObject).finish();
        break;
        if (aupf.a(this.a) != 0) {
          break label33;
        }
        i = 1;
        break label33;
      }
      if (aupf.a(this.a) == 1)
      {
        aupf.a(this.a);
        break;
      }
      aupf.b(this.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupg
 * JD-Core Version:    0.7.0.1
 */