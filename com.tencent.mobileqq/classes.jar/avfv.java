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

class avfv
  implements avgv
{
  avfv(avfq paramavfq, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      avfq.a(this.jdField_a_of_type_Avfq);
      return;
    }
    avfq.b(this.jdField_a_of_type_Avfq);
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
        Bitmap localBitmap = this.jdField_a_of_type_Avfq.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bfvo.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          avfq.a(this.jdField_a_of_type_Avfq).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      avfq.a(this.jdField_a_of_type_Avfq).setClickable(false);
      if (bjuk.a()) {
        avfq.a(this.jdField_a_of_type_Avfq).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840586));
      }
    }
    Rect localRect;
    do
    {
      return;
      avfq.a(this.jdField_a_of_type_Avfq).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840585));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      avfq.a(this.jdField_a_of_type_Avfq).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    avfq.a(this.jdField_a_of_type_Avfq).setClickable(true);
    avfq.a(this.jdField_a_of_type_Avfq).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840587));
  }
  
  public void a(boolean paramBoolean, avgw paramavgw)
  {
    avfq.a(this.jdField_a_of_type_Avfq, paramBoolean, paramavgw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfv
 * JD-Core Version:    0.7.0.1
 */