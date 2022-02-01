import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.IndividuationUrlHelper.1.1;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

public final class bgew
  implements bgez
{
  public void a()
  {
    int i = 0;
    if (i < bgev.a().size())
    {
      Object localObject = (SoftReference)bgev.a().get(i);
      if (localObject != null)
      {
        localObject = (bgex)((SoftReference)localObject).get();
        if (localObject != null) {
          break label50;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label50:
        String str = (String)bgev.b().get(((bgex)localObject).jdField_a_of_type_JavaLangString);
        if ((((bgex)localObject).jdField_a_of_type_AndroidWidgetImageView != null) && (!TextUtils.isEmpty(str))) {
          ((bgex)localObject).jdField_a_of_type_AndroidWidgetImageView.post(new IndividuationUrlHelper.1.1(this, (bgex)localObject, str));
        }
      }
    }
    bgev.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgew
 * JD-Core Version:    0.7.0.1
 */