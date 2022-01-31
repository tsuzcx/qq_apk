import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class aogy
  implements ansr
{
  aogy(aogx paramaogx) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)aogx.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        aohb localaohb = (aohb)paramString2.next();
        if ((localaohb != null) && (localaohb.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) && (localaohb.jdField_a_of_type_Apby != null))
        {
          localaohb.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(paramBitmap);
          localaohb.jdField_a_of_type_Apby.c(true);
        }
      }
    }
    aogx.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogy
 * JD-Core Version:    0.7.0.1
 */