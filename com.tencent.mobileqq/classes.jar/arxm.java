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

class arxm
  implements arym
{
  arxm(arxh paramarxh, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      arxh.a(this.jdField_a_of_type_Arxh);
      return;
    }
    arxh.b(this.jdField_a_of_type_Arxh);
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
        Bitmap localBitmap = this.jdField_a_of_type_Arxh.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bbdr.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          arxh.a(this.jdField_a_of_type_Arxh).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      arxh.a(this.jdField_a_of_type_Arxh).setClickable(false);
      if (bfwa.a()) {
        arxh.a(this.jdField_a_of_type_Arxh).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840254));
      }
    }
    Rect localRect;
    do
    {
      return;
      arxh.a(this.jdField_a_of_type_Arxh).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840253));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      arxh.a(this.jdField_a_of_type_Arxh).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    arxh.a(this.jdField_a_of_type_Arxh).setClickable(true);
    arxh.a(this.jdField_a_of_type_Arxh).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840255));
  }
  
  public void a(boolean paramBoolean, aryn paramaryn)
  {
    arxh.a(this.jdField_a_of_type_Arxh, paramBoolean, paramaryn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxm
 * JD-Core Version:    0.7.0.1
 */