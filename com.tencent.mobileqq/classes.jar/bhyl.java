import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.IndividuationUrlHelper.1.1;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

public final class bhyl
  implements bhyo
{
  public void a()
  {
    int i = 0;
    if (i < bhyk.a().size())
    {
      Object localObject = (SoftReference)bhyk.a().get(i);
      if (localObject != null)
      {
        localObject = (bhym)((SoftReference)localObject).get();
        if (localObject != null) {
          break label50;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label50:
        String str = (String)bhyk.b().get(((bhym)localObject).jdField_a_of_type_JavaLangString);
        if ((((bhym)localObject).jdField_a_of_type_AndroidWidgetImageView != null) && (!TextUtils.isEmpty(str))) {
          ((bhym)localObject).jdField_a_of_type_AndroidWidgetImageView.post(new IndividuationUrlHelper.1.1(this, (bhym)localObject, str));
        }
      }
    }
    bhyk.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhyl
 * JD-Core Version:    0.7.0.1
 */