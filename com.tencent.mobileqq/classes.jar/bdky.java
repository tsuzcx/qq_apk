import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class bdky
  extends bkov
{
  bdky(bdkw parambdkw, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, List paramList, int[] paramArrayOfInt5)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bkou parambkou, View.OnClickListener paramOnClickListener)
  {
    parambkou = super.a(paramInt, paramObject, parambkou, paramOnClickListener);
    if (parambkou != null) {
      parambkou.setTag(-10, paramObject);
    }
    return parambkou;
  }
  
  public void a(int paramInt, Object paramObject, bkou[] paramArrayOfbkou)
  {
    paramInt = 0;
    Object localObject = this.jdField_a_of_type_Bdkw.a((bdmc)paramObject);
    int i = ((List)localObject).size();
    paramObject = localObject;
    if (i > 3)
    {
      paramObject = ((List)localObject).subList(i - 2, i);
      paramObject.add(0, bdkw.a);
    }
    i = Math.min(paramObject.size(), 3);
    if (paramInt < paramArrayOfbkou.length)
    {
      int j;
      if (paramInt < i)
      {
        localObject = (bdmd)paramObject.get(paramInt);
        j = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
        if (j < 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_JavaLangString, 1, "getRightMenuItemInfo error, can not find the menu， menuId[" + ((bdmd)localObject).b() + "]");
          }
          paramArrayOfbkou[paramInt].b = -1;
          paramArrayOfbkou[paramInt].a = -1;
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramArrayOfbkou[paramInt].b = j;
        paramArrayOfbkou[paramInt].a = this.jdField_a_of_type_ArrayOfInt[j];
        continue;
        paramArrayOfbkou[paramInt].b = -1;
        paramArrayOfbkou[paramInt].a = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdky
 * JD-Core Version:    0.7.0.1
 */