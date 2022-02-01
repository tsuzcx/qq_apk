import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public abstract class bbip<M extends bbmv, V extends bbve>
  extends bbio<M, V>
  implements aobv, bkhe
{
  protected int a;
  protected aobu a;
  private ListView a;
  
  public bbip(ListView paramListView, aobu paramaobu)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Aobu = paramaobu;
    paramaobu.a(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Aobu.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        bbmv localbbmv = (bbmv)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131380929);
        if ((localbbmv != null) && (localbbmv.c() == paramInt2) && (paramString.equals(localbbmv.b())))
        {
          bbpr localbbpr = (bbpr)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131380931);
          bbve localbbve = (bbve)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131380935);
          if ((localbbpr != null) && (localbbve != null)) {
            localbbpr.a(localbbmv, localbbve, paramBitmap);
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
      if (this.jdField_a_of_type_Aobu.a()) {
        this.jdField_a_of_type_Aobu.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        bbmv localbbmv = (bbmv)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131380929);
        bbpr localbbpr = (bbpr)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131380931);
        bbve localbbve = (bbve)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131380935);
        if ((localbbpr != null) && (localbbmv != null) && (paramAbsListView != null)) {
          localbbpr.a(localbbmv, localbbve);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Aobu.a();
    this.jdField_a_of_type_Aobu.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbip
 * JD-Core Version:    0.7.0.1
 */