import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;

class awum
  implements awtp
{
  awum(awuj paramawuj) {}
  
  public void a(LocationRoom.Venue paramVenue) {}
  
  public void a(LatLng paramLatLng) {}
  
  public void a(LatLng paramLatLng, float paramFloat, List<String> paramList)
  {
    if (paramList != null)
    {
      paramLatLng = paramList.iterator();
      while (paramLatLng.hasNext())
      {
        paramList = (String)paramLatLng.next();
        Bitmap localBitmap = this.a.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bhmq.c(localBitmap, 16, 16);
          awuj.a(this.a).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint) {}
  
  public void a(boolean paramBoolean, awtq paramawtq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awum
 * JD-Core Version:    0.7.0.1
 */