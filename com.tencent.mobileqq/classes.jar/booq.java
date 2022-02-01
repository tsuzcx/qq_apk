import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class booq
{
  public static final int[] a;
  public static final int[] b = { 101, 2130849671, 2131374148 };
  public static final int[] c = { 102, 2130849670, 2131374147 };
  private int jdField_a_of_type_Int;
  private ArrayList<int[]> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 100, 2130849669, 2131374146 };
  }
  
  public booq(int paramInt, List<Integer> paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramInt = ((Integer)paramList.next()).intValue();
        if (paramInt == 100) {
          this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
        } else if (paramInt == 101) {
          this.jdField_a_of_type_JavaUtilArrayList.add(b);
        } else if (paramInt == 102) {
          this.jdField_a_of_type_JavaUtilArrayList.add(c);
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[1];
  }
  
  public ProviderView a(Context paramContext, int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramContext = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ProviderViewBuilder", 2, "bad id=" + paramInt);
        paramContext = localObject;
      }
      break;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        paramContext.setCaptureScene(this.jdField_a_of_type_Int);
        paramContext.setTabBarPosition(2);
        paramContext.d(231);
      }
      return paramContext;
      paramContext = new QIMFilterProviderView(paramContext);
      paramContext.setId(2131364285);
      continue;
      paramContext = new StaticStickerProviderView(paramContext);
      paramContext.setId(2131364294);
    }
  }
  
  public int b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[2];
  }
  
  public int c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return -1;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     booq
 * JD-Core Version:    0.7.0.1
 */