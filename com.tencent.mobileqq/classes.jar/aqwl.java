import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class aqwl
  implements aqgm
{
  aqwl(aqwk paramaqwk) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)aqwk.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        aqwo localaqwo = (aqwo)paramString2.next();
        if ((localaqwo != null) && (localaqwo.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) && (localaqwo.jdField_a_of_type_Aruk != null))
        {
          localaqwo.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(paramBitmap);
          localaqwo.jdField_a_of_type_Aruk.c(true);
        }
      }
    }
    aqwk.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqwl
 * JD-Core Version:    0.7.0.1
 */