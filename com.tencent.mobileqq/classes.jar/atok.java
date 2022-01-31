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

class atok
  implements atpk
{
  atok(atof paramatof, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      atof.a(this.jdField_a_of_type_Atof);
      return;
    }
    atof.b(this.jdField_a_of_type_Atof);
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
        Bitmap localBitmap = this.jdField_a_of_type_Atof.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bdda.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          atof.a(this.jdField_a_of_type_Atof).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      atof.a(this.jdField_a_of_type_Atof).setClickable(false);
      if (bhxo.a()) {
        atof.a(this.jdField_a_of_type_Atof).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840354));
      }
    }
    Rect localRect;
    do
    {
      return;
      atof.a(this.jdField_a_of_type_Atof).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840353));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      atof.a(this.jdField_a_of_type_Atof).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    atof.a(this.jdField_a_of_type_Atof).setClickable(true);
    atof.a(this.jdField_a_of_type_Atof).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840355));
  }
  
  public void a(boolean paramBoolean, atpl paramatpl)
  {
    atof.a(this.jdField_a_of_type_Atof, paramBoolean, paramatpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atok
 * JD-Core Version:    0.7.0.1
 */