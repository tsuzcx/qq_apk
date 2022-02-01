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

class awsp
  implements awtp
{
  awsp(awsk paramawsk, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      awsk.a(this.jdField_a_of_type_Awsk);
      return;
    }
    awsk.b(this.jdField_a_of_type_Awsk);
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
        Bitmap localBitmap = this.jdField_a_of_type_Awsk.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bhmq.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          awsk.a(this.jdField_a_of_type_Awsk).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      awsk.a(this.jdField_a_of_type_Awsk).setClickable(false);
      if (blqj.a()) {
        awsk.a(this.jdField_a_of_type_Awsk).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840551));
      }
    }
    Rect localRect;
    do
    {
      return;
      awsk.a(this.jdField_a_of_type_Awsk).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840550));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      awsk.a(this.jdField_a_of_type_Awsk).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    awsk.a(this.jdField_a_of_type_Awsk).setClickable(true);
    awsk.a(this.jdField_a_of_type_Awsk).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840552));
  }
  
  public void a(boolean paramBoolean, awtq paramawtq)
  {
    awsk.a(this.jdField_a_of_type_Awsk, paramBoolean, paramawtq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsp
 * JD-Core Version:    0.7.0.1
 */