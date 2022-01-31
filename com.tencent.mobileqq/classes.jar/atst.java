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

class atst
  implements attt
{
  atst(atso paramatso, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      atso.a(this.jdField_a_of_type_Atso);
      return;
    }
    atso.b(this.jdField_a_of_type_Atso);
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
        Bitmap localBitmap = this.jdField_a_of_type_Atso.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bdhj.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          atso.a(this.jdField_a_of_type_Atso).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      atso.a(this.jdField_a_of_type_Atso).setClickable(false);
      if (bibv.a()) {
        atso.a(this.jdField_a_of_type_Atso).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840355));
      }
    }
    Rect localRect;
    do
    {
      return;
      atso.a(this.jdField_a_of_type_Atso).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840354));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      atso.a(this.jdField_a_of_type_Atso).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    atso.a(this.jdField_a_of_type_Atso).setClickable(true);
    atso.a(this.jdField_a_of_type_Atso).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840356));
  }
  
  public void a(boolean paramBoolean, attu paramattu)
  {
    atso.a(this.jdField_a_of_type_Atso, paramBoolean, paramattu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atst
 * JD-Core Version:    0.7.0.1
 */