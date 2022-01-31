import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public abstract class ayff<M extends ayji, V extends ayrs>
  extends ayfe<M, V>
  implements bcwt, bhpo
{
  protected int a;
  protected bcws a;
  private ListView a;
  
  public ayff(ListView paramListView, bcws parambcws)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Bcws = parambcws;
    parambcws.a(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Bcws.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        ayji localayji = (ayji)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379913);
        if ((localayji != null) && (localayji.c() == paramInt2) && (paramString.equals(localayji.b())))
        {
          aymf localaymf = (aymf)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379915);
          ayrs localayrs = (ayrs)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379918);
          if ((localaymf != null) && (localayrs != null)) {
            localaymf.a(localayji, localayrs, paramBitmap);
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
      if (this.jdField_a_of_type_Bcws.a()) {
        this.jdField_a_of_type_Bcws.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        ayji localayji = (ayji)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379913);
        aymf localaymf = (aymf)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379915);
        ayrs localayrs = (ayrs)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379918);
        if ((localaymf != null) && (localayji != null) && (paramAbsListView != null)) {
          localaymf.a(localayji, localayrs);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Bcws.a();
    this.jdField_a_of_type_Bcws.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayff
 * JD-Core Version:    0.7.0.1
 */