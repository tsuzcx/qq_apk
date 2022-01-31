import android.view.View;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;

public class cj
  implements OverScrollViewListener
{
  public cj(PrinterActivity paramPrinterActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramInt = PrinterActivity.a(this.a).a.a();
    if (paramInt > 0)
    {
      PrinterActivity.a(this.a).a.a.b();
      this.a.a.setSelectionFromBottom(paramInt, 0);
      PrinterActivity.a(this.a).a.a.notifyDataSetChanged();
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     cj
 * JD-Core Version:    0.7.0.1
 */