import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;
import com.tencent.widget.HorizontalListView;

public class amjp
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  private final int f;
  private int g;
  
  public amjp(HorizontalListView paramHorizontalListView)
  {
    this.f = ViewConfiguration.get(paramHorizontalListView.getContext()).getScaledFadingEdgeLength();
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.removeCallbacks(this);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 2000);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.jdField_a_of_type_JavaLangRunnable = new amjq(this, paramInt1, paramInt2);
    }
    int j;
    do
    {
      return;
      j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
    } while (j == 0);
    int i;
    int k;
    if (!this.jdField_a_of_type_ComTencentWidgetHorizontalListView.d)
    {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.k;
      j = j + i - 1;
      k = Math.max(0, Math.min(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - 1, paramInt1));
      if (k >= i) {
        break label162;
      }
      paramInt1 = i - k + 1;
      label113:
      if (paramInt1 <= 0) {
        break label188;
      }
    }
    label162:
    label188:
    for (this.e = (paramInt1 / (j - i) * paramInt3);; this.e = paramInt3)
    {
      this.b = k;
      c(this.b, paramInt2, this.e);
      return;
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.l;
      break;
      if (k > j)
      {
        paramInt1 = k - j + 1;
        break label113;
      }
      b(k, paramInt3);
      return;
    }
  }
  
  @TargetApi(16)
  void a(Runnable paramRunnable)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postOnAnimation(paramRunnable);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(this);
      return;
    }
    catch (Exception paramRunnable)
    {
      paramRunnable.printStackTrace();
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, 0, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.jdField_a_of_type_JavaLangRunnable = new amjr(this, paramInt1, paramInt2, paramInt3);
    }
    int j;
    do
    {
      return;
      j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
    } while (j == 0);
    int i;
    label135:
    label158:
    float f1;
    if (!this.jdField_a_of_type_ComTencentWidgetHorizontalListView.d)
    {
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getPaddingLeft();
      paramInt2 += i;
      this.b = Math.max(0, Math.min(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - 1, paramInt1));
      this.g = paramInt2;
      this.c = -1;
      this.d = -1;
      this.jdField_a_of_type_Int = 5;
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.d) {
        break label201;
      }
      paramInt1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.k;
      i = paramInt1 + j - 1;
      if (this.b >= paramInt1) {
        break label212;
      }
      paramInt1 -= this.b;
      f1 = paramInt1 / j;
      if (f1 >= 1.0F) {
        break label293;
      }
    }
    for (;;)
    {
      this.e = paramInt3;
      this.d = -1;
      a(this);
      return;
      i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getPaddingRight();
      break;
      label201:
      paramInt1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.l;
      break label135;
      label212:
      if (this.b > i)
      {
        paramInt1 = this.b - i;
        break label158;
      }
      View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(this.b - paramInt1);
      if (!this.jdField_a_of_type_ComTencentWidgetHorizontalListView.d) {}
      for (paramInt1 = -localView.getLeft();; paramInt1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getWidth() - localView.getRight())
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.c(paramInt1 - paramInt2, paramInt3);
        return;
      }
      label293:
      paramInt3 = (int)(paramInt3 / f1);
    }
  }
  
  void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.k;
    int j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
    View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0);
    if ((paramInt1 < i) || (paramInt1 > j + i - 1)) {}
    for (paramInt1 = (paramInt1 - i) * (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(1).getLeft() - localView.getLeft()) + localView.getLeft(); paramInt1 == 0; paramInt1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(paramInt1 - i).getLeft() - Math.abs(localView.getLeft())) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.c(-(paramInt1 + paramInt2), paramInt3);
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight();
    if (!this.jdField_a_of_type_ComTencentWidgetHorizontalListView.d) {}
    for (int j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.k;; j = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.l) {
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    }
    if (this.d == j)
    {
      a(this);
      return;
    }
    this.d = j;
    int n = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
    int k = this.b;
    int m = j + n - 1;
    int i = 0;
    float f1;
    if (k < j)
    {
      i = j - k + 1;
      f1 = Math.min(Math.abs(i / n), 1.0F);
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.d) {
        break label220;
      }
    }
    float f2;
    label220:
    for (i = 1;; i = -1)
    {
      f1 = i * f1;
      if (k >= j) {
        break label225;
      }
      i = (int)(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getWidth() * f1);
      f2 = this.e;
      j = (int)(Math.abs(f1) * f2);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.c(i, j);
      a(this);
      return;
      if (k <= m) {
        break;
      }
      i = k - m;
      break;
    }
    label225:
    if (k > m)
    {
      i = (int)(-this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getWidth() * f1);
      f2 = this.e;
      j = (int)(Math.abs(f1) * f2);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.c(i, j);
      a(this);
      return;
    }
    View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(k - j);
    if (!this.jdField_a_of_type_ComTencentWidgetHorizontalListView.d) {}
    for (i = -localView.getLeft();; i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getWidth() - localView.getRight())
    {
      i -= this.g;
      j = (int)(this.e * (Math.abs(i) / this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getWidth()));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.c(i, j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjp
 * JD-Core Version:    0.7.0.1
 */