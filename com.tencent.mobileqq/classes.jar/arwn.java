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

class arwn
  implements arym
{
  private long jdField_a_of_type_Long;
  
  arwn(arwh paramarwh, Activity paramActivity) {}
  
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
    arwh.a(this.jdField_a_of_type_Arwh, paramLatLng);
    arwh.a(this.jdField_a_of_type_Arwh).a(arwh.a(this.jdField_a_of_type_Arwh), arwh.a(this.jdField_a_of_type_Arwh).getMap(), paramLatLng, "");
    axqw.b(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_Arwh.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bbdr.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          arwh.a(this.jdField_a_of_type_Arwh).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      arwh.a(this.jdField_a_of_type_Arwh).setClickable(false);
      if (bfwa.a()) {
        arwh.a(this.jdField_a_of_type_Arwh).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840254));
      }
    }
    Rect localRect;
    do
    {
      return;
      arwh.a(this.jdField_a_of_type_Arwh).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840253));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      arwh.a(this.jdField_a_of_type_Arwh).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    arwh.a(this.jdField_a_of_type_Arwh).setClickable(true);
    arwh.a(this.jdField_a_of_type_Arwh).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840255));
  }
  
  public void a(boolean paramBoolean, aryn paramaryn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arwn
 * JD-Core Version:    0.7.0.1
 */