import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

class arbu
  implements arcu
{
  arbu(arbp paramarbp, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      arbp.a(this.jdField_a_of_type_Arbp);
      return;
    }
    arbp.b(this.jdField_a_of_type_Arbp);
  }
  
  public void a(LatLng paramLatLng) {}
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.jdField_a_of_type_Arbp.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bacm.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          arbp.a(this.jdField_a_of_type_Arbp).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      arbp.a(this.jdField_a_of_type_Arbp).setClickable(false);
      if (beog.a()) {
        arbp.a(this.jdField_a_of_type_Arbp).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840207));
      }
    }
    Rect localRect;
    do
    {
      return;
      arbp.a(this.jdField_a_of_type_Arbp).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840206));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      arbp.a(this.jdField_a_of_type_Arbp).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    arbp.a(this.jdField_a_of_type_Arbp).setClickable(true);
    arbp.a(this.jdField_a_of_type_Arbp).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840208));
  }
  
  public void a(boolean paramBoolean, arcv paramarcv)
  {
    arbp.a(this.jdField_a_of_type_Arbp, paramBoolean, paramarcv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbu
 * JD-Core Version:    0.7.0.1
 */