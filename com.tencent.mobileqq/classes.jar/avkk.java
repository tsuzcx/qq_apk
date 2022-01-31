import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public abstract class avkk<M extends avok, V extends avwu>
  extends avkj<M, V>
  implements azwh, begh
{
  protected int a;
  protected azwg a;
  private ListView a;
  
  public avkk(ListView paramListView, azwg paramazwg)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Azwg = paramazwg;
    paramazwg.a(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Azwg.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        avok localavok = (avok)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131313373);
        if ((localavok != null) && (localavok.c() == paramInt2) && (paramString.equals(localavok.b())))
        {
          avrh localavrh = (avrh)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131313375);
          avwu localavwu = (avwu)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131313378);
          if ((localavrh != null) && (localavwu != null)) {
            localavrh.a(localavok, localavwu, paramBitmap);
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
      if (this.jdField_a_of_type_Azwg.a()) {
        this.jdField_a_of_type_Azwg.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        avok localavok = (avok)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131313373);
        avrh localavrh = (avrh)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131313375);
        avwu localavwu = (avwu)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131313378);
        if ((localavrh != null) && (localavok != null) && (paramAbsListView != null)) {
          localavrh.a(localavok, localavwu);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Azwg.a();
    this.jdField_a_of_type_Azwg.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkk
 * JD-Core Version:    0.7.0.1
 */