import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class aqhi
  implements apsw
{
  aqhi(aqhh paramaqhh) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)aqhh.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        aqhl localaqhl = (aqhl)paramString2.next();
        if ((localaqhl != null) && (localaqhl.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) && (localaqhl.jdField_a_of_type_Arev != null))
        {
          localaqhl.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(paramBitmap);
          localaqhl.jdField_a_of_type_Arev.c(true);
        }
      }
    }
    aqhh.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhi
 * JD-Core Version:    0.7.0.1
 */