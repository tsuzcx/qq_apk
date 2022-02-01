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

class avew
  implements avgv
{
  private long jdField_a_of_type_Long;
  
  avew(aveq paramaveq, Activity paramActivity) {}
  
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
    aveq.a(this.jdField_a_of_type_Aveq, paramLatLng);
    aveq.a(this.jdField_a_of_type_Aveq).a(aveq.a(this.jdField_a_of_type_Aveq), aveq.a(this.jdField_a_of_type_Aveq).getMap(), paramLatLng, "");
    bcef.b(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_Aveq.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bfvo.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          aveq.a(this.jdField_a_of_type_Aveq).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      aveq.a(this.jdField_a_of_type_Aveq).setClickable(false);
      if (bjuk.a()) {
        aveq.a(this.jdField_a_of_type_Aveq).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840586));
      }
    }
    Rect localRect;
    do
    {
      return;
      aveq.a(this.jdField_a_of_type_Aveq).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840585));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      aveq.a(this.jdField_a_of_type_Aveq).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    aveq.a(this.jdField_a_of_type_Aveq).setClickable(true);
    aveq.a(this.jdField_a_of_type_Aveq).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840587));
  }
  
  public void a(boolean paramBoolean, avgw paramavgw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avew
 * JD-Core Version:    0.7.0.1
 */