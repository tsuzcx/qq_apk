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

class arwp
  implements aryo
{
  private long jdField_a_of_type_Long;
  
  arwp(arwj paramarwj, Activity paramActivity) {}
  
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
    arwj.a(this.jdField_a_of_type_Arwj, paramLatLng);
    arwj.a(this.jdField_a_of_type_Arwj).a(arwj.a(this.jdField_a_of_type_Arwj), arwj.a(this.jdField_a_of_type_Arwj).getMap(), paramLatLng, "");
    axqy.b(null, "CliOper", "", "", "0X800A95D", "0X800A95D", 0, 0, "", "0", "0", "");
  }
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_Arwj.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bbef.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          arwj.a(this.jdField_a_of_type_Arwj).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      arwj.a(this.jdField_a_of_type_Arwj).setClickable(false);
      if (bfwr.a()) {
        arwj.a(this.jdField_a_of_type_Arwj).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840251));
      }
    }
    Rect localRect;
    do
    {
      return;
      arwj.a(this.jdField_a_of_type_Arwj).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840250));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      arwj.a(this.jdField_a_of_type_Arwj).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    arwj.a(this.jdField_a_of_type_Arwj).setClickable(true);
    arwj.a(this.jdField_a_of_type_Arwj).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840252));
  }
  
  public void a(boolean paramBoolean, aryp paramaryp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arwp
 * JD-Core Version:    0.7.0.1
 */