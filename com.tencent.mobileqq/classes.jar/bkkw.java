import com.tencent.widget.AbsListView;
import com.tencent.widget.GestureSelectGridView;

public class bkkw
  implements bkhe
{
  public bkkw(GestureSelectGridView paramGestureSelectGridView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      int i = paramInt1 + paramInt2;
      if ((!this.a.jdField_b_of_type_Boolean) || (Math.abs(i - this.a.c) < 3) || (Math.abs(i - this.a.c) > 5)) {
        break label161;
      }
      if (this.a.c + 3 <= paramInt3 - 1) {
        break label140;
      }
      this.a.c = (paramInt3 - 1);
      this.a.jdField_a_of_type_Bkkx.a(this.a.jdField_b_of_type_Int, this.a.c);
    }
    label140:
    GestureSelectGridView localGestureSelectGridView;
    label161:
    while ((this.a.jdField_b_of_type_Boolean) || (Math.abs(paramInt1 - this.a.c) < 3) || (Math.abs(paramInt1 - this.a.c) > 5)) {
      for (;;)
      {
        if (this.a.jdField_a_of_type_Bkhe != null) {
          this.a.jdField_a_of_type_Bkhe.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
        }
        return;
        localGestureSelectGridView = this.a;
        localGestureSelectGridView.c += 3;
      }
    }
    if (this.a.c - 3 < 0) {}
    for (this.a.c = 0;; localGestureSelectGridView.c -= 3)
    {
      this.a.jdField_a_of_type_Bkkx.a(this.a.jdField_b_of_type_Int, this.a.c);
      break;
      localGestureSelectGridView = this.a;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.a.jdField_a_of_type_Bkhe != null) {
      this.a.jdField_a_of_type_Bkhe.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkw
 * JD-Core Version:    0.7.0.1
 */