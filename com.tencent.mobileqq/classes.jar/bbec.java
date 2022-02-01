import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.remind.widget.WheelView;

final class bbec
  implements bbel
{
  public long a(WheelView[] paramArrayOfWheelView, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    if ((paramArrayOfInt.length != 3) || (paramArrayOfWheelView.length != 3)) {
      return -1L;
    }
    String str2;
    if (AppSetting.c)
    {
      str2 = bbeg.a(paramArrayOfInt[0]);
      if ((paramArrayOfInt[1] < 0) || (paramArrayOfInt[1] >= bbeg.a.length)) {
        break label206;
      }
    }
    label206:
    for (String str1 = bbeg.a[paramArrayOfInt[1]];; str1 = null)
    {
      Object localObject1 = localObject2;
      if (paramArrayOfInt[2] >= 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfInt[2] < bbeg.b.length) {
          localObject1 = bbeg.b[paramArrayOfInt[2]];
        }
      }
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        str1 = anvx.a(2131712851) + str2 + str1 + anvx.a(2131712849) + (String)localObject1 + anvx.a(2131712850);
        int j = paramArrayOfWheelView.length;
        int i = 0;
        while (i < j)
        {
          paramArrayOfWheelView[i].setContentDescription(str1);
          i += 1;
        }
      }
      return bbeg.a(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbec
 * JD-Core Version:    0.7.0.1
 */