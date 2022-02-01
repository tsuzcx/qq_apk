import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class aqsy
  implements aqdb
{
  aqsy(aqsx paramaqsx) {}
  
  public void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)aqsx.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        aqtb localaqtb = (aqtb)paramString2.next();
        if ((localaqtb != null) && (localaqtb.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) && (localaqtb.jdField_a_of_type_Arrt != null))
        {
          localaqtb.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(paramBitmap);
          localaqtb.jdField_a_of_type_Arrt.c(true);
        }
      }
    }
    aqsx.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsy
 * JD-Core Version:    0.7.0.1
 */