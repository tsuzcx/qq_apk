import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

class awkz
  implements awmy
{
  private long jdField_a_of_type_Long;
  
  awkz(awkt paramawkt, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue) {}
  
  public void a(LatLng paramLatLng)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onMapStable onClick: invoked. center: " + paramLatLng);
    }
    awkt.a(this.jdField_a_of_type_Awkt, paramLatLng);
    awkt.a(this.jdField_a_of_type_Awkt).a(awkt.a(this.jdField_a_of_type_Awkt), awkt.a(this.jdField_a_of_type_Awkt).getMap(), paramLatLng, "");
    bdla.b(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_Awkt.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bheg.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          awkt.a(this.jdField_a_of_type_Awkt).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      awkt.a(this.jdField_a_of_type_Awkt).setClickable(false);
      if (blfw.a()) {
        awkt.a(this.jdField_a_of_type_Awkt).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840625));
      }
    }
    Rect localRect;
    do
    {
      return;
      awkt.a(this.jdField_a_of_type_Awkt).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840624));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      awkt.a(this.jdField_a_of_type_Awkt).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    awkt.a(this.jdField_a_of_type_Awkt).setClickable(true);
    awkt.a(this.jdField_a_of_type_Awkt).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840626));
  }
  
  public void a(boolean paramBoolean, awmz paramawmz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkz
 * JD-Core Version:    0.7.0.1
 */