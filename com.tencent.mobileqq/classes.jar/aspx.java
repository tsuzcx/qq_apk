import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tbs.reader.TbsReaderView;

class aspx
  implements View.OnClickListener
{
  aspx(aspt paramaspt, int paramInt, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (this.jdField_a_of_type_Int == 5018)
    {
      Display localDisplay = this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
      if (localDisplay.getWidth() > localDisplay.getHeight())
      {
        i = 0;
        if (i == 0) {
          break label61;
        }
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
      break;
      label61:
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      continue;
      aspt.a(this.jdField_a_of_type_Aspt).doCommand(Integer.valueOf(this.jdField_a_of_type_Int), null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspx
 * JD-Core Version:    0.7.0.1
 */