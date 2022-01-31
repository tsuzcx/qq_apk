import android.widget.Scroller;
import com.tencent.widget.VerticalGallery;

public class amed
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private int b;
  
  public amed(VerticalGallery paramVerticalGallery)
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramVerticalGallery.getContext());
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery.removeCallbacks(this);
  }
  
  private void b(boolean paramBoolean)
  {
    VerticalGallery.b(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, false);
    this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.c();
    }
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery.g();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery.mItemCount == 0)
    {
      b(true);
      return;
    }
    VerticalGallery.c(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, false);
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    boolean bool = localScroller.computeScrollOffset();
    int j = localScroller.getCurrY();
    int i = this.b - j;
    if (i > 0) {
      VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, this.jdField_a_of_type_ComTencentWidgetVerticalGallery.mFirstPosition);
    }
    for (i = Math.min(this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getHeight() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingTop() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingBottom() - 1, i);; i = Math.max(-(this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getHeight() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingBottom() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingTop() - 1), i))
    {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.b(i);
      if ((!bool) || (VerticalGallery.b(this.jdField_a_of_type_ComTencentWidgetVerticalGallery))) {
        break;
      }
      this.b = j;
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
      return;
      int k = this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getChildCount();
      VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, k - 1 + this.jdField_a_of_type_ComTencentWidgetVerticalGallery.mFirstPosition);
    }
    b(true);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    b();
    if (VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery))
    {
      if (paramInt < 0) {}
      for (i = 2147483647;; i = 0)
      {
        this.b = i;
        this.jdField_a_of_type_AndroidWidgetScroller.fling(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
        return;
      }
    }
    if (paramInt < 0) {}
    for (int i = 2147483647;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_AndroidWidgetScroller.fling(i, 0, paramInt, 0, 0, 2147483647, 0, 2147483647);
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery.removeCallbacks(this);
    b(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery))
    {
      b();
      VerticalGallery.b(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, true);
      this.b = 0;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, 0, -paramInt, VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery));
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
      return;
    }
    b();
    VerticalGallery.b(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, true);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, -paramInt, 0, VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery));
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
  }
  
  public void run()
  {
    if (VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery))
    {
      a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery.mItemCount == 0)
    {
      b(true);
      return;
    }
    VerticalGallery.c(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, false);
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    boolean bool = localScroller.computeScrollOffset();
    int j = localScroller.getCurrX();
    int i = this.jdField_a_of_type_Int - j;
    if (i > 0) {
      VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, this.jdField_a_of_type_ComTencentWidgetVerticalGallery.mFirstPosition);
    }
    for (i = Math.min(this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getWidth() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingLeft() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingRight() - 1, i);; i = Math.max(-(this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getWidth() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingRight() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingLeft() - 1), i))
    {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.a(i);
      if ((!bool) || (VerticalGallery.b(this.jdField_a_of_type_ComTencentWidgetVerticalGallery))) {
        break;
      }
      this.jdField_a_of_type_Int = j;
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
      return;
      int k = this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getChildCount();
      VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, k - 1 + this.jdField_a_of_type_ComTencentWidgetVerticalGallery.mFirstPosition);
    }
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amed
 * JD-Core Version:    0.7.0.1
 */