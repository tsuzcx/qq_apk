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

class atru
  implements attt
{
  private long jdField_a_of_type_Long;
  
  atru(atro paramatro, Activity paramActivity) {}
  
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
    atro.a(this.jdField_a_of_type_Atro, paramLatLng);
    atro.a(this.jdField_a_of_type_Atro).a(atro.a(this.jdField_a_of_type_Atro), atro.a(this.jdField_a_of_type_Atro).getMap(), paramLatLng, "");
    azqs.b(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_Atro.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bdhj.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          atro.a(this.jdField_a_of_type_Atro).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      atro.a(this.jdField_a_of_type_Atro).setClickable(false);
      if (bibv.a()) {
        atro.a(this.jdField_a_of_type_Atro).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840355));
      }
    }
    Rect localRect;
    do
    {
      return;
      atro.a(this.jdField_a_of_type_Atro).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840354));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      atro.a(this.jdField_a_of_type_Atro).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    atro.a(this.jdField_a_of_type_Atro).setClickable(true);
    atro.a(this.jdField_a_of_type_Atro).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840356));
  }
  
  public void a(boolean paramBoolean, attu paramattu) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atru
 * JD-Core Version:    0.7.0.1
 */