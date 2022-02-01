import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.tencent.widget.XListView;

public class cb
  implements anuw
{
  public cb(LiteActivity paramLiteActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {}
    while ((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) {
      return;
    }
    if (paramInt > 0)
    {
      this.a.jdField_a_of_type_Dy.b();
      this.a.jdField_a_of_type_Dy.notifyDataSetChanged();
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromBottom(paramInt, 0);
    }
    this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cb
 * JD-Core Version:    0.7.0.1
 */