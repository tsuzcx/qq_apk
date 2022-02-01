import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.IndividuationUrlHelper.1.1;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

public final class bgyh
  implements bgyk
{
  public void a()
  {
    int i = 0;
    if (i < bgyg.a().size())
    {
      Object localObject = (SoftReference)bgyg.a().get(i);
      if (localObject != null)
      {
        localObject = (bgyi)((SoftReference)localObject).get();
        if (localObject != null) {
          break label50;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label50:
        String str = (String)bgyg.b().get(((bgyi)localObject).jdField_a_of_type_JavaLangString);
        if ((((bgyi)localObject).jdField_a_of_type_AndroidWidgetImageView != null) && (!TextUtils.isEmpty(str))) {
          ((bgyi)localObject).jdField_a_of_type_AndroidWidgetImageView.post(new IndividuationUrlHelper.1.1(this, (bgyi)localObject, str));
        }
      }
    }
    bgyg.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgyh
 * JD-Core Version:    0.7.0.1
 */