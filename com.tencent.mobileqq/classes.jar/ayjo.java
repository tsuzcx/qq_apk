import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public abstract class ayjo<M extends aynr, V extends aywb>
  extends ayjn<M, V>
  implements bdbc, bhtv
{
  protected int a;
  protected bdbb a;
  private ListView a;
  
  public ayjo(ListView paramListView, bdbb parambdbb)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Bdbb = parambdbb;
    parambdbb.a(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Bdbb.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        aynr localaynr = (aynr)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379971);
        if ((localaynr != null) && (localaynr.c() == paramInt2) && (paramString.equals(localaynr.b())))
        {
          ayqo localayqo = (ayqo)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379973);
          aywb localaywb = (aywb)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131379976);
          if ((localayqo != null) && (localaywb != null)) {
            localayqo.a(localaynr, localaywb, paramBitmap);
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
      if (this.jdField_a_of_type_Bdbb.a()) {
        this.jdField_a_of_type_Bdbb.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        aynr localaynr = (aynr)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379971);
        ayqo localayqo = (ayqo)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379973);
        aywb localaywb = (aywb)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131379976);
        if ((localayqo != null) && (localaynr != null) && (paramAbsListView != null)) {
          localayqo.a(localaynr, localaywb);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Bdbb.a();
    this.jdField_a_of_type_Bdbb.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjo
 * JD-Core Version:    0.7.0.1
 */