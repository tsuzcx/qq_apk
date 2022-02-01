import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class appu
  implements aozx
{
  appu(appt paramappt) {}
  
  public void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)appt.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        appx localappx = (appx)paramString2.next();
        if ((localappx != null) && (localappx.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) && (localappx.jdField_a_of_type_Aqoi != null))
        {
          localappx.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(paramBitmap);
          localappx.jdField_a_of_type_Aqoi.c(true);
        }
      }
    }
    appt.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appu
 * JD-Core Version:    0.7.0.1
 */