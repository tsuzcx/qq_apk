import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aufv
  implements View.OnClickListener
{
  aufv(aufu paramaufu) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = 4;
    if (aufu.a(this.a) == 1)
    {
      i = 2;
      label33:
      if ((aufu.a(this.a) == null) || (!aufu.a(this.a).equals(AppConstants.DATALINE_PC_UIN))) {
        break label240;
      }
      i = 3;
    }
    label240:
    for (;;)
    {
      long l = atpm.b();
      bdla.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
      if (aufu.a(this.a) == 1101)
      {
        Object localObject = new ArrayList();
        ((ArrayList)localObject).addAll(atpm.a());
        Intent localIntent = new Intent();
        localIntent.putExtra("file_choose_search_result_code", "file_choose_search_result_code");
        localIntent.putParcelableArrayListExtra("reslut_select_file_info_list", (ArrayList)localObject);
        localObject = (Activity)this.a.jdField_a_of_type_AndroidContentContext;
        ((Activity)localObject).setResult(-1, localIntent);
        ((Activity)localObject).finish();
        break;
        if (aufu.a(this.a) != 0) {
          break label33;
        }
        i = 1;
        break label33;
      }
      if (aufu.a(this.a) == 1)
      {
        aufu.a(this.a);
        break;
      }
      aufu.b(this.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufv
 * JD-Core Version:    0.7.0.1
 */