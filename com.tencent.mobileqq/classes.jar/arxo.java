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

class arxo
  implements aryo
{
  arxo(arxj paramarxj, Activity paramActivity) {}
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (paramVenue != null)
    {
      arxj.a(this.jdField_a_of_type_Arxj);
      return;
    }
    arxj.b(this.jdField_a_of_type_Arxj);
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
        Bitmap localBitmap = this.jdField_a_of_type_Arxj.a(paramList);
        if (localBitmap != null)
        {
          localBitmap = bbef.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          arxj.a(this.jdField_a_of_type_Arxj).a(paramList, localBitmap);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Point paramPoint)
  {
    if (paramBoolean)
    {
      arxj.a(this.jdField_a_of_type_Arxj).setClickable(false);
      if (bfwr.a()) {
        arxj.a(this.jdField_a_of_type_Arxj).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840251));
      }
    }
    Rect localRect;
    do
    {
      return;
      arxj.a(this.jdField_a_of_type_Arxj).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840250));
      return;
      if (paramPoint == null) {
        break;
      }
      localRect = new Rect();
      arxj.a(this.jdField_a_of_type_Arxj).getGlobalVisibleRect(localRect);
    } while (localRect.contains(paramPoint.x, paramPoint.y));
    arxj.a(this.jdField_a_of_type_Arxj).setClickable(true);
    arxj.a(this.jdField_a_of_type_Arxj).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840252));
  }
  
  public void a(boolean paramBoolean, aryp paramaryp)
  {
    arxj.a(this.jdField_a_of_type_Arxj, paramBoolean, paramaryp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxo
 * JD-Core Version:    0.7.0.1
 */