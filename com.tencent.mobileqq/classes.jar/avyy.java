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

class avyy
  implements awax
{
  private long jdField_a_of_type_Long;
  
  avyy(avys paramavys, Activity paramActivity) {}
  
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
    avys.a(this.jdField_a_of_type_Avys, paramLatLng);
    avys.a(this.jdField_a_of_type_Avys).a(avys.a(this.jdField_a_of_type_Avys), avys.a(this.jdField_a_of_type_Avys).getMap(), paramLatLng, "");
    bcst.b(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_Avys.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bgmo.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          avys.a(this.jdField_a_of_type_Avys).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      avys.a(this.jdField_a_of_type_Avys).setClickable(false);
      if (bkpg.a()) {
        avys.a(this.jdField_a_of_type_Avys).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840541));
      }
    }
    Rect localRect;
    do
    {
      return;
      avys.a(this.jdField_a_of_type_Avys).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840540));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      avys.a(this.jdField_a_of_type_Avys).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    avys.a(this.jdField_a_of_type_Avys).setClickable(true);
    avys.a(this.jdField_a_of_type_Avys).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840542));
  }
  
  public void a(boolean paramBoolean, away paramaway) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyy
 * JD-Core Version:    0.7.0.1
 */