import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.remind.widget.WheelView;

final class axih
  implements axiq
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
      str2 = axil.a(paramArrayOfInt[0]);
      if ((paramArrayOfInt[1] < 0) || (paramArrayOfInt[1] >= axil.a.length)) {
        break label206;
      }
    }
    label206:
    for (String str1 = axil.a[paramArrayOfInt[1]];; str1 = null)
    {
      Object localObject1 = localObject2;
      if (paramArrayOfInt[2] >= 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfInt[2] < axil.b.length) {
          localObject1 = axil.b[paramArrayOfInt[2]];
        }
      }
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        str1 = alpo.a(2131713772) + str2 + str1 + alpo.a(2131713770) + (String)localObject1 + alpo.a(2131713771);
        int j = paramArrayOfWheelView.length;
        int i = 0;
        while (i < j)
        {
          paramArrayOfWheelView[i].setContentDescription(str1);
          i += 1;
        }
      }
      return axil.a(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axih
 * JD-Core Version:    0.7.0.1
 */