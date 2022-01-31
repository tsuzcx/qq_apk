import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class bjkg
  extends RecyclerView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  bjkg(bjkf parambjkf) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bjkf.a();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjkg
 * JD-Core Version:    0.7.0.1
 */