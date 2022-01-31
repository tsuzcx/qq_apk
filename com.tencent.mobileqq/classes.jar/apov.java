import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

class apov
  implements AdapterView.OnItemClickListener
{
  apov(apou paramapou) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    do
    {
      do
      {
        return;
        ((FileBrowserActivity)this.a.a.a).a.b();
        paramAdapterView = ((bbjv)paramAdapterView).a;
        paramAdapterView.a.onClick(paramView);
      } while (!"export_auto_open".equals(((FileBrowserActivity)this.a.a.a).a.a()));
      if (paramAdapterView.c == 2)
      {
        axqy.b(null, "dc00898", "", "", "0X800A3B8", "0X800A3B8", 0, 0, "", "", "", "");
        return;
      }
      if (paramAdapterView.c == 27)
      {
        axqy.b(null, "dc00898", "", "", "0X800A3B9", "0X800A3B9", 0, 0, "", "", "", "");
        return;
      }
    } while (paramAdapterView.c != 6);
    axqy.b(null, "dc00898", "", "", "0X800A3BA", "0X800A3BA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apov
 * JD-Core Version:    0.7.0.1
 */