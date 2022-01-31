import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class aocp
  implements anoi
{
  aocp(aoco paramaoco) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)aoco.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        aocs localaocs = (aocs)paramString2.next();
        if ((localaocs != null) && (localaocs.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) && (localaocs.jdField_a_of_type_Aoxp != null))
        {
          localaocs.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(paramBitmap);
          localaocs.jdField_a_of_type_Aoxp.c(true);
        }
      }
    }
    aoco.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocp
 * JD-Core Version:    0.7.0.1
 */