import android.view.View;
import com.tencent.qidian.PhotoWallViewForQiDianProfile;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class bjww
  implements AdapterView.OnItemClickListener
{
  public bjww(PhotoWallViewForQiDianProfile paramPhotoWallViewForQiDianProfile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bjyl)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.a.jdField_a_of_type_Bjwz == null) {
      return;
    }
    this.a.jdField_a_of_type_Bjwz.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjww
 * JD-Core Version:    0.7.0.1
 */