import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

public class aysu
  implements avym
{
  private long jdField_a_of_type_Long;
  
  public aysu(OnlineStatusLocationFragment paramOnlineStatusLocationFragment) {}
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList) {}
  
  public void a(LatLng paramLatLng, List<String> paramList)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusLocationFragment", 2, "onMapStable onClick: invoked. center: " + paramLatLng);
      }
      OnlineStatusLocationFragment.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment, paramLatLng);
      if (paramList != null)
      {
        paramLatLng = paramList.iterator();
        while (paramLatLng.hasNext())
        {
          paramList = (String)paramLatLng.next();
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment.a(paramList);
          if (localBitmap != null)
          {
            localBitmap = bgmo.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
            OnlineStatusLocationFragment.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment).a(paramList, localBitmap);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment.a.setClickable(false);
      if (bkpg.a()) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment.a.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment.getActivity().getResources().getDrawable(2130840541));
      }
    }
    Rect localRect;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment.a.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment.getActivity().getResources().getDrawable(2130840540));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment.a.getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment.a.setClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment.a.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusLocationOnlineStatusLocationFragment.getActivity().getResources().getDrawable(2130840542));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysu
 * JD-Core Version:    0.7.0.1
 */