import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public abstract class awkd<M extends awod, V extends awwn>
  extends awkc<M, V>
  implements baxl, bfob
{
  protected int a;
  protected baxk a;
  private ListView a;
  
  public awkd(ListView paramListView, baxk parambaxk)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Baxk = parambaxk;
    parambaxk.a(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Baxk.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        awod localawod = (awod)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379208);
        if ((localawod != null) && (localawod.c() == paramInt2) && (paramString.equals(localawod.b())))
        {
          awra localawra = (awra)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379210);
          awwn localawwn = (awwn)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379213);
          if ((localawra != null) && (localawwn != null)) {
            localawra.a(localawod, localawwn, paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      if (this.jdField_a_of_type_Baxk.a()) {
        this.jdField_a_of_type_Baxk.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        awod localawod = (awod)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379208);
        awra localawra = (awra)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379210);
        awwn localawwn = (awwn)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379213);
        if ((localawra != null) && (localawod != null) && (paramAbsListView != null)) {
          localawra.a(localawod, localawwn);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Baxk.a();
    this.jdField_a_of_type_Baxk.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkd
 * JD-Core Version:    0.7.0.1
 */