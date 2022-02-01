package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

public abstract class AsyncListUtil$ViewCallback
{
  public static final int HINT_SCROLL_ASC = 2;
  public static final int HINT_SCROLL_DESC = 1;
  public static final int HINT_SCROLL_NONE = 0;
  
  @UiThread
  public void extendRangeInto(@NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2, int paramInt)
  {
    int i = paramArrayOfInt1[1] - paramArrayOfInt1[0] + 1;
    int j = i / 2;
    int m = paramArrayOfInt1[0];
    int k;
    if (paramInt == 1)
    {
      k = i;
      paramArrayOfInt2[0] = (m - k);
      k = paramArrayOfInt1[1];
      if (paramInt != 2) {
        break label65;
      }
    }
    for (;;)
    {
      paramArrayOfInt2[1] = (k + i);
      return;
      k = j;
      break;
      label65:
      i = j;
    }
  }
  
  @UiThread
  public abstract void getItemRangeInto(@NonNull int[] paramArrayOfInt);
  
  @UiThread
  public abstract void onDataRefresh();
  
  @UiThread
  public abstract void onItemLoaded(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncListUtil.ViewCallback
 * JD-Core Version:    0.7.0.1
 */