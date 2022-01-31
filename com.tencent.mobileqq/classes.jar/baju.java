import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class baju
  extends bibk
{
  baju(bajs parambajs, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, List paramList, int[] paramArrayOfInt5)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bibj parambibj, View.OnClickListener paramOnClickListener)
  {
    parambibj = super.a(paramInt, paramObject, parambibj, paramOnClickListener);
    if (parambibj != null) {
      parambibj.setTag(-10, paramObject);
    }
    return parambibj;
  }
  
  public void a(int paramInt, Object paramObject, bibj[] paramArrayOfbibj)
  {
    paramInt = 0;
    Object localObject = this.jdField_a_of_type_Bajs.a((baky)paramObject);
    int i = ((List)localObject).size();
    paramObject = localObject;
    if (i > 3)
    {
      paramObject = ((List)localObject).subList(i - 2, i);
      paramObject.add(0, bajs.a);
    }
    i = Math.min(paramObject.size(), 3);
    if (paramInt < paramArrayOfbibj.length)
    {
      int j;
      if (paramInt < i)
      {
        localObject = (bakz)paramObject.get(paramInt);
        j = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
        if (j < 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_JavaLangString, 1, "getRightMenuItemInfo error, can not find the menu， menuId[" + ((bakz)localObject).b() + "]");
          }
          paramArrayOfbibj[paramInt].b = -1;
          paramArrayOfbibj[paramInt].a = -1;
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramArrayOfbibj[paramInt].b = j;
        paramArrayOfbibj[paramInt].a = this.jdField_a_of_type_ArrayOfInt[j];
        continue;
        paramArrayOfbibj[paramInt].b = -1;
        paramArrayOfbibj[paramInt].a = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baju
 * JD-Core Version:    0.7.0.1
 */