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

class awrq
  implements awtp
{
  private long jdField_a_of_type_Long;
  
  awrq(awrk paramawrk, Activity paramActivity) {}
  
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
    awrk.a(this.jdField_a_of_type_Awrk, paramLatLng);
    awrk.a(this.jdField_a_of_type_Awrk).a(awrk.a(this.jdField_a_of_type_Awrk), awrk.a(this.jdField_a_of_type_Awrk).getMap(), paramLatLng, "");
    bdll.b(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_Awrk.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bhmq.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          awrk.a(this.jdField_a_of_type_Awrk).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      awrk.a(this.jdField_a_of_type_Awrk).setClickable(false);
      if (blqj.a()) {
        awrk.a(this.jdField_a_of_type_Awrk).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840551));
      }
    }
    Rect localRect;
    do
    {
      return;
      awrk.a(this.jdField_a_of_type_Awrk).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840550));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      awrk.a(this.jdField_a_of_type_Awrk).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    awrk.a(this.jdField_a_of_type_Awrk).setClickable(true);
    awrk.a(this.jdField_a_of_type_Awrk).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840552));
  }
  
  public void a(boolean paramBoolean, awtq paramawtq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrq
 * JD-Core Version:    0.7.0.1
 */