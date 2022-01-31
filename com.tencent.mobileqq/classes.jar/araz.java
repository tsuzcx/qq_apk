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

class araz
  implements arcu
{
  private long jdField_a_of_type_Long;
  
  araz(arat paramarat, Activity paramActivity) {}
  
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
    arat.a(this.jdField_a_of_type_Arat, paramLatLng);
    arat.a(this.jdField_a_of_type_Arat).a(arat.a(this.jdField_a_of_type_Arat), (int)Math.round(paramLatLng.latitude * 1000000.0D), (int)Math.round(paramLatLng.longitude * 1000000.0D), "");
    awqx.b(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_Arat.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bacm.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          arat.a(this.jdField_a_of_type_Arat).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      arat.a(this.jdField_a_of_type_Arat).setClickable(false);
      if (beog.a()) {
        arat.a(this.jdField_a_of_type_Arat).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840207));
      }
    }
    Rect localRect;
    do
    {
      return;
      arat.a(this.jdField_a_of_type_Arat).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840206));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      arat.a(this.jdField_a_of_type_Arat).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    arat.a(this.jdField_a_of_type_Arat).setClickable(true);
    arat.a(this.jdField_a_of_type_Arat).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840208));
  }
  
  public void a(boolean paramBoolean, arcv paramarcv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     araz
 * JD-Core Version:    0.7.0.1
 */