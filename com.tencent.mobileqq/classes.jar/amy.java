import android.view.View;
import android.view.View.OnClickListener;
import com.qq.im.poi.LbsPackInfo;
import com.qq.im.poi.LbsPackListAdapter;
import com.qq.im.poi.LbsPackListAdapter.LbsPackItemCallback;

public class amy
  implements View.OnClickListener
{
  public amy(LbsPackListAdapter paramLbsPackListAdapter, LbsPackInfo paramLbsPackInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (LbsPackListAdapter.a(this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter) != null) {
      LbsPackListAdapter.a(this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter).b(this.jdField_a_of_type_ComQqImPoiLbsPackInfo, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amy
 * JD-Core Version:    0.7.0.1
 */