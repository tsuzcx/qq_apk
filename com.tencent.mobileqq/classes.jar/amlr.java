import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class amlr
  implements alxj
{
  amlr(amlq paramamlq) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)amlq.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        amlu localamlu = (amlu)paramString2.next();
        if ((localamlu != null) && (localamlu.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) && (localamlu.jdField_a_of_type_Angi != null))
        {
          localamlu.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(paramBitmap);
          localamlu.jdField_a_of_type_Angi.c(true);
        }
      }
    }
    amlq.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amlr
 * JD-Core Version:    0.7.0.1
 */