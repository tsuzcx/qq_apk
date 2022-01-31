import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class amls
  implements alxk
{
  amls(amlr paramamlr) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)amlr.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        amlv localamlv = (amlv)paramString2.next();
        if ((localamlv != null) && (localamlv.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) && (localamlv.jdField_a_of_type_Angd != null))
        {
          localamlv.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(paramBitmap);
          localamlv.jdField_a_of_type_Angd.c(true);
        }
      }
    }
    amlr.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amls
 * JD-Core Version:    0.7.0.1
 */