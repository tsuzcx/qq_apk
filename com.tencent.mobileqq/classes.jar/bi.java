import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy.LoadMoreAioMessageCb;
import com.tencent.widget.XListView;

public class bi
  implements DataLineMsgProxy.LoadMoreAioMessageCb
{
  public bi(LiteActivity paramLiteActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {}
    while ((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) {
      return;
    }
    if (paramInt > 0)
    {
      this.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.b();
      this.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromBottom(paramInt, 0);
    }
    this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bi
 * JD-Core Version:    0.7.0.1
 */