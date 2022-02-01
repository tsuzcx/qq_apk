import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;

public class bote
  extends botf
{
  @Nullable
  private OrientationHelper jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper;
  private int[] jdField_a_of_type_ArrayOfInt;
  @Nullable
  private OrientationHelper b;
  
  private float a(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    Object localObject1 = null;
    int i = 2147483647;
    int i1 = paramLayoutManager.getChildCount();
    if (i1 == 0) {
      return 1.0F;
    }
    int k = 0;
    Object localObject2 = null;
    int m = -2147483648;
    View localView;
    int n;
    if (k < i1)
    {
      localView = paramLayoutManager.getChildAt(k);
      n = paramLayoutManager.getPosition(localView);
      if (n != -1) {}
    }
    for (;;)
    {
      k += 1;
      break;
      int j = i;
      if (n < i)
      {
        j = n;
        localObject2 = localView;
      }
      if (n > m)
      {
        m = n;
        i = j;
        localObject1 = localView;
        continue;
        if ((localObject2 == null) || (localObject1 == null)) {
          return 1.0F;
        }
        j = Math.min(paramOrientationHelper.getDecoratedStart(localObject2), paramOrientationHelper.getDecoratedStart(localObject1));
        j = Math.max(paramOrientationHelper.getDecoratedEnd(localObject2), paramOrientationHelper.getDecoratedEnd(localObject1)) - j;
        if (j == 0) {
          return 1.0F;
        }
        return j * 1.0F / (m - i + 1);
      }
      else
      {
        i = j;
      }
    }
  }
  
  private int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      return -1;
    }
    int n = this.jdField_a_of_type_ArrayOfInt.length;
    if (n == -1) {
      return -1;
    }
    int j = 2147483647;
    int i = 0;
    int k = -1;
    Object localObject;
    if (i < n)
    {
      localObject = this.jdField_a_of_type_ArrayOfInt;
      localObject[i] -= paramInt;
      int m = Math.abs(this.jdField_a_of_type_ArrayOfInt[i]);
      if (m >= j) {
        break label109;
      }
      k = i;
      j = m;
    }
    label109:
    for (;;)
    {
      i += 1;
      break;
      localObject = paramLayoutManager.getChildAt(k);
      if (localObject == null) {
        return -1;
      }
      return paramLayoutManager.getPosition((View)localObject);
    }
  }
  
  private int a(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = a(paramInt1, paramInt2);
    float f = a(paramLayoutManager, paramOrientationHelper);
    if (f <= 0.0F) {
      return 0;
    }
    if (Math.abs(arrayOfInt[0]) > Math.abs(arrayOfInt[1])) {}
    for (paramInt1 = arrayOfInt[0]; paramInt1 > 0; paramInt1 = arrayOfInt[1]) {
      return (int)Math.floor(paramInt1 / f);
    }
    return (int)Math.ceil(paramInt1 / f);
  }
  
  private int a(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    int j = paramOrientationHelper.getDecoratedStart(paramView);
    int k = paramOrientationHelper.getDecoratedMeasurement(paramView) / 2;
    if (paramLayoutManager.getClipToPadding()) {}
    for (int i = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;; i = paramOrientationHelper.getEnd() / 2) {
      return k + j - i;
    }
  }
  
  @NonNull
  private OrientationHelper a(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper == null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper = OrientationHelper.createVerticalHelper(paramLayoutManager);
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetOrientationHelper;
  }
  
  @Nullable
  private View a(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int n = paramLayoutManager.getChildCount();
    if (n == 0) {}
    int j;
    int i;
    int k;
    label54:
    do
    {
      return localObject2;
      if (!paramLayoutManager.getClipToPadding()) {
        break;
      }
      j = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
      i = 2147483647;
      this.jdField_a_of_type_ArrayOfInt = new int[n];
      k = 0;
      localObject2 = localObject1;
    } while (k >= n);
    localObject2 = paramLayoutManager.getChildAt(k);
    int m = paramOrientationHelper.getDecoratedStart((View)localObject2);
    int i1 = paramOrientationHelper.getDecoratedMeasurement((View)localObject2) / 2 + m;
    m = Math.abs(i1 - j);
    this.jdField_a_of_type_ArrayOfInt[k] = (i1 - j);
    if (m < i)
    {
      localObject1 = localObject2;
      i = m;
    }
    for (;;)
    {
      k += 1;
      break label54;
      j = paramOrientationHelper.getEnd() / 2;
      break;
    }
  }
  
  @NonNull
  private OrientationHelper b(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    if (this.b == null) {
      this.b = OrientationHelper.createHorizontalHelper(paramLayoutManager);
    }
    return this.b;
  }
  
  public int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int j = paramLayoutManager.getItemCount();
    if (j == 0) {
      paramInt2 = -1;
    }
    label197:
    label203:
    do
    {
      return paramInt2;
      Object localObject = a(paramLayoutManager);
      if (localObject == null) {
        return -1;
      }
      int k = paramLayoutManager.getPosition((View)localObject);
      if (k == -1) {
        return -1;
      }
      localObject = ((LinearLayoutManager)paramLayoutManager).computeScrollVectorForPosition(j - 1);
      if (localObject == null) {
        return -1;
      }
      int[] arrayOfInt = a(paramInt1, paramInt2);
      int i;
      if (paramLayoutManager.canScrollHorizontally())
      {
        i = a(paramLayoutManager, b(paramLayoutManager), paramInt1, 0);
        paramInt1 = i;
        if (((PointF)localObject).x < 0.0F) {
          paramInt1 = -i;
        }
        i = paramInt1;
        if (paramInt1 == 0)
        {
          int m = a(paramLayoutManager, arrayOfInt[0]);
          i = paramInt1;
          if (m != -1) {
            return m;
          }
        }
      }
      else
      {
        i = 0;
      }
      if (paramLayoutManager.canScrollVertically())
      {
        paramInt2 = a(paramLayoutManager, a(paramLayoutManager), 0, paramInt2);
        paramInt1 = paramInt2;
        if (((PointF)localObject).y < 0.0F) {
          paramInt1 = -paramInt2;
        }
        if (!paramLayoutManager.canScrollVertically()) {
          break label197;
        }
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label203;
        }
        return -1;
        paramInt1 = 0;
        break;
        paramInt1 = i;
      }
      paramInt2 = k + paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      paramInt2 = paramInt1;
    } while (paramInt1 < j);
    return j - 1;
  }
  
  public View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager.canScrollVertically()) {
      return a(paramLayoutManager, a(paramLayoutManager));
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      return a(paramLayoutManager, b(paramLayoutManager));
    }
    return null;
  }
  
  public int[] a(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = a(paramLayoutManager, paramView, b(paramLayoutManager));
    }
    while (paramLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = a(paramLayoutManager, paramView, a(paramLayoutManager));
      return arrayOfInt;
      arrayOfInt[0] = 0;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bote
 * JD-Core Version:    0.7.0.1
 */