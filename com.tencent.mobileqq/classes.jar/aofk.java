import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;

class aofk
  implements aoll
{
  aofk(aofj paramaofj, ArrayList paramArrayList, int paramInt1, int paramInt2) {}
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Rect a(int paramInt)
  {
    Rect localRect = new Rect(0, 0, 0, 0);
    int i = a();
    if (i > 1)
    {
      if (paramInt == 0)
      {
        localRect.right = this.b;
        localRect.left = (this.b * 2);
      }
    }
    else {
      return localRect;
    }
    if (paramInt == i - 1)
    {
      localRect.left = this.b;
      localRect.right = (this.b * 2);
      return localRect;
    }
    paramInt = this.b;
    localRect.right = paramInt;
    localRect.left = paramInt;
    return localRect;
  }
  
  public View a(int paramInt)
  {
    int j = a();
    if (j <= b()) {}
    for (int i = 2131560740;; i = 2131560741)
    {
      View localView = View.inflate(this.jdField_a_of_type_Aofj.itemView.getContext(), i, null);
      aofj.a(this.jdField_a_of_type_Aofj, localView, (aofi)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), paramInt, j);
      aofj.a(this.jdField_a_of_type_Aofj, (aofi)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), paramInt, "0X800A9B0");
      return localView;
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofk
 * JD-Core Version:    0.7.0.1
 */