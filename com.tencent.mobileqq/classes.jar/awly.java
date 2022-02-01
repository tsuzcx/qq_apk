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

class awly
  implements awmy
{
  awly(awlt paramawlt, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      awlt.a(this.jdField_a_of_type_Awlt);
      return;
    }
    awlt.b(this.jdField_a_of_type_Awlt);
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
        Bitmap localBitmap = this.jdField_a_of_type_Awlt.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bheg.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          awlt.a(this.jdField_a_of_type_Awlt).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      awlt.a(this.jdField_a_of_type_Awlt).setClickable(false);
      if (blfw.a()) {
        awlt.a(this.jdField_a_of_type_Awlt).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840625));
      }
    }
    Rect localRect;
    do
    {
      return;
      awlt.a(this.jdField_a_of_type_Awlt).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840624));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      awlt.a(this.jdField_a_of_type_Awlt).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    awlt.a(this.jdField_a_of_type_Awlt).setClickable(true);
    awlt.a(this.jdField_a_of_type_Awlt).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840626));
  }
  
  public void a(boolean paramBoolean, awmz paramawmz)
  {
    awlt.a(this.jdField_a_of_type_Awlt, paramBoolean, paramawmz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awly
 * JD-Core Version:    0.7.0.1
 */