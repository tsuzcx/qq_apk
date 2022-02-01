import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public abstract class bcbj<M extends bcfo, V extends bcnx>
  extends bcbi<M, V>
  implements aoog, blih
{
  protected int a;
  protected aoof a;
  private ListView a;
  
  public bcbj(ListView paramListView, aoof paramaoof)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Aoof = paramaoof;
    paramaoof.a(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_Aoof.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        bcfo localbcfo = (bcfo)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131381109);
        if ((localbcfo != null) && (localbcfo.c() == paramInt2) && (paramString.equals(localbcfo.b())))
        {
          bcik localbcik = (bcik)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131381111);
          bcnx localbcnx = (bcnx)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131381115);
          if ((localbcik != null) && (localbcnx != null)) {
            localbcik.a(localbcfo, localbcnx, paramBitmap);
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
      if (this.jdField_a_of_type_Aoof.a()) {
        this.jdField_a_of_type_Aoof.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        bcfo localbcfo = (bcfo)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131381109);
        bcik localbcik = (bcik)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131381111);
        bcnx localbcnx = (bcnx)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131381115);
        if ((localbcik != null) && (localbcfo != null) && (paramAbsListView != null)) {
          localbcik.a(localbcfo, localbcnx);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_Aoof.a();
    this.jdField_a_of_type_Aoof.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbj
 * JD-Core Version:    0.7.0.1
 */