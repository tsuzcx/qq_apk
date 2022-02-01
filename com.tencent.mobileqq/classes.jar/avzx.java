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

class avzx
  implements awax
{
  avzx(avzs paramavzs, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      avzs.a(this.jdField_a_of_type_Avzs);
      return;
    }
    avzs.b(this.jdField_a_of_type_Avzs);
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
        Bitmap localBitmap = this.jdField_a_of_type_Avzs.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bgmo.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          avzs.a(this.jdField_a_of_type_Avzs).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      avzs.a(this.jdField_a_of_type_Avzs).setClickable(false);
      if (bkpg.a()) {
        avzs.a(this.jdField_a_of_type_Avzs).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840541));
      }
    }
    Rect localRect;
    do
    {
      return;
      avzs.a(this.jdField_a_of_type_Avzs).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840540));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      avzs.a(this.jdField_a_of_type_Avzs).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    avzs.a(this.jdField_a_of_type_Avzs).setClickable(true);
    avzs.a(this.jdField_a_of_type_Avzs).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840542));
  }
  
  public void a(boolean paramBoolean, away paramaway)
  {
    avzs.a(this.jdField_a_of_type_Avzs, paramBoolean, paramaway);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzx
 * JD-Core Version:    0.7.0.1
 */