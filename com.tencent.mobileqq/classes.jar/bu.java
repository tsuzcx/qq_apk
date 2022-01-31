import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.tencent.widget.XListView;

public class bu
  implements akeo
{
  public bu(LiteActivity paramLiteActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {}
    while ((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) {
      return;
    }
    if (paramInt > 0)
    {
      this.a.jdField_a_of_type_Dr.b();
      this.a.jdField_a_of_type_Dr.notifyDataSetChanged();
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromBottom(paramInt, 0);
    }
    this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bu
 * JD-Core Version:    0.7.0.1
 */