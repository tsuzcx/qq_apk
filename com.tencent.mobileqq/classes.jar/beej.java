import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class beej
  extends blfn
{
  beej(beeh parambeeh, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, List paramList, int[] paramArrayOfInt5)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, blfm paramblfm, View.OnClickListener paramOnClickListener)
  {
    paramblfm = super.a(paramInt, paramObject, paramblfm, paramOnClickListener);
    if (paramblfm != null) {
      paramblfm.setTag(-10, paramObject);
    }
    return paramblfm;
  }
  
  public void a(int paramInt, Object paramObject, blfm[] paramArrayOfblfm)
  {
    paramInt = 0;
    Object localObject = this.jdField_a_of_type_Beeh.a((befn)paramObject);
    int i = ((List)localObject).size();
    paramObject = localObject;
    if (i > 3)
    {
      paramObject = ((List)localObject).subList(i - 2, i);
      paramObject.add(0, beeh.a);
    }
    i = Math.min(paramObject.size(), 3);
    if (paramInt < paramArrayOfblfm.length)
    {
      int j;
      if (paramInt < i)
      {
        localObject = (befo)paramObject.get(paramInt);
        j = this.jdField_a_of_type_JavaUtilList.indexOf(localObject);
        if (j < 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_JavaLangString, 1, "getRightMenuItemInfo error, can not find the menu， menuId[" + ((befo)localObject).b() + "]");
          }
          paramArrayOfblfm[paramInt].b = -1;
          paramArrayOfblfm[paramInt].a = -1;
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramArrayOfblfm[paramInt].b = j;
        paramArrayOfblfm[paramInt].a = this.jdField_a_of_type_ArrayOfInt[j];
        continue;
        paramArrayOfblfm[paramInt].b = -1;
        paramArrayOfblfm[paramInt].a = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beej
 * JD-Core Version:    0.7.0.1
 */