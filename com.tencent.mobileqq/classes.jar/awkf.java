import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public abstract class awkf<M extends awof, V extends awwp>
  extends awke<M, V>
  implements baxz, bfos
{
  protected int a;
  protected baxy a;
  private ListView a;
  
  public awkf(ListView paramListView, baxy parambaxy)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Baxy = parambaxy;
    parambaxy.a(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Baxy.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        awof localawof = (awof)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379213);
        if ((localawof != null) && (localawof.c() == paramInt2) && (paramString.equals(localawof.b())))
        {
          awrc localawrc = (awrc)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379215);
          awwp localawwp = (awwp)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379218);
          if ((localawrc != null) && (localawwp != null)) {
            localawrc.a(localawof, localawwp, paramBitmap);
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
      if (this.jdField_a_of_type_Baxy.a()) {
        this.jdField_a_of_type_Baxy.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        awof localawof = (awof)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379213);
        awrc localawrc = (awrc)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379215);
        awwp localawwp = (awwp)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379218);
        if ((localawrc != null) && (localawof != null) && (paramAbsListView != null)) {
          localawrc.a(localawof, localawwp);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Baxy.a();
    this.jdField_a_of_type_Baxy.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkf
 * JD-Core Version:    0.7.0.1
 */