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

class atnl
  implements atpk
{
  private long jdField_a_of_type_Long;
  
  atnl(atnf paramatnf, Activity paramActivity) {}
  
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
    atnf.a(this.jdField_a_of_type_Atnf, paramLatLng);
    atnf.a(this.jdField_a_of_type_Atnf).a(atnf.a(this.jdField_a_of_type_Atnf), atnf.a(this.jdField_a_of_type_Atnf).getMap(), paramLatLng, "");
    azmj.b(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_Atnf.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bdda.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          atnf.a(this.jdField_a_of_type_Atnf).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      atnf.a(this.jdField_a_of_type_Atnf).setClickable(false);
      if (bhxo.a()) {
        atnf.a(this.jdField_a_of_type_Atnf).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840354));
      }
    }
    Rect localRect;
    do
    {
      return;
      atnf.a(this.jdField_a_of_type_Atnf).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840353));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      atnf.a(this.jdField_a_of_type_Atnf).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    atnf.a(this.jdField_a_of_type_Atnf).setClickable(true);
    atnf.a(this.jdField_a_of_type_Atnf).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840355));
  }
  
  public void a(boolean paramBoolean, atpl paramatpl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnl
 * JD-Core Version:    0.7.0.1
 */