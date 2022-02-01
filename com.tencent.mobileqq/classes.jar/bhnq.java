import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.IndividuationUrlHelper.1.1;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

public final class bhnq
  implements bhnt
{
  public void a()
  {
    int i = 0;
    if (i < bhnp.a().size())
    {
      Object localObject = (SoftReference)bhnp.a().get(i);
      if (localObject != null)
      {
        localObject = (bhnr)((SoftReference)localObject).get();
        if (localObject != null) {
          break label50;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label50:
        String str = (String)bhnp.b().get(((bhnr)localObject).jdField_a_of_type_JavaLangString);
        if ((((bhnr)localObject).jdField_a_of_type_AndroidWidgetImageView != null) && (!TextUtils.isEmpty(str))) {
          ((bhnr)localObject).jdField_a_of_type_AndroidWidgetImageView.post(new IndividuationUrlHelper.1.1(this, (bhnr)localObject, str));
        }
      }
    }
    bhnp.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhnq
 * JD-Core Version:    0.7.0.1
 */