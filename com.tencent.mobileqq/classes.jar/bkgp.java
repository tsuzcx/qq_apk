import android.view.View;
import com.tencent.qidian.PhotoWallViewForQiDianProfile;
import com.tencent.widget.AdapterView;
import java.util.List;

public class bkgp
  implements bljm
{
  public bkgp(PhotoWallViewForQiDianProfile paramPhotoWallViewForQiDianProfile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bkie)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.a.jdField_a_of_type_Bkgs == null) {
      return;
    }
    this.a.jdField_a_of_type_Bkgs.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgp
 * JD-Core Version:    0.7.0.1
 */