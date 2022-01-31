import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class axhj
  extends benv
{
  axhj(axhh paramaxhh, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, List paramList, int[] paramArrayOfInt5)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, benu parambenu, View.OnClickListener paramOnClickListener)
  {
    parambenu = super.a(paramInt, paramObject, parambenu, paramOnClickListener);
    if (parambenu != null) {
      parambenu.setTag(-10, paramObject);
    }
    return parambenu;
  }
  
  public void a(int paramInt, Object paramObject, benu[] paramArrayOfbenu)
  {
    paramInt = 0;
    Object localObject = this.jdField_a_of_type_Axhh.a((axin)paramObject);
    int i = ((List)localObject).size();
    paramObject = localObject;
    if (i > 3)
    {
      paramObject = ((List)localObject).subList(i - 2, i);
      paramObject.add(0, axhh.a);
    }
    i = Math.min(paramObject.size(), 3);
    if (paramInt < paramArrayOfbenu.length)
    {
      int j;
      if (paramInt < i)
      {
        localObject = (axio)paramObject.get(paramInt);
        j = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
        if (j < 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_JavaLangString, 1, "getRightMenuItemInfo error, can not find the menu， menuId[" + ((axio)localObject).b() + "]");
          }
          paramArrayOfbenu[paramInt].b = -1;
          paramArrayOfbenu[paramInt].a = -1;
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramArrayOfbenu[paramInt].b = j;
        paramArrayOfbenu[paramInt].a = this.jdField_a_of_type_ArrayOfInt[j];
        continue;
        paramArrayOfbenu[paramInt].b = -1;
        paramArrayOfbenu[paramInt].a = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axhj
 * JD-Core Version:    0.7.0.1
 */