import android.content.Context;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.OCRScanEntryView;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.ar.view.ScanEntryProviderView;
import java.util.ArrayList;

public class apqu
{
  private int jdField_a_of_type_Int;
  private ArrayList<apqv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131374754, 2131372167, 2131362897 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { anvx.a(2131712968), anvx.a(2131718189), "AR" };
  public boolean b;
  private final int[] b;
  public boolean c;
  private final int[] c;
  private final int[] d = { 2130844831, 2130844832, 2130844833, 2130844834, 2130844835, 2130844836, 2130844837, 2130844838 };
  
  public apqu(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2130844839, 2130844840, 2130844841, 2130844842, 2130844843, 2130844844, 2130844845, 2130844846 };
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2130844814, 2130844815, 2130844816, 2130844817, 2130844818, 2130844819, 2130844820, 2130844821 };
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_ArrayOfInt.length;
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 0;
    }
    while (paramInt == 2) {
      return i;
    }
    return 2;
  }
  
  public apqv a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b())) {
      return (apqv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public ScanEntryProviderView a(int paramInt, Context paramContext, apqp paramapqp)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new QRScanEntryView(paramContext, paramapqp);
    case 3: 
      return new ARScanEntryView(paramContext, paramapqp);
    }
    return new OCRScanEntryView(paramContext, paramapqp);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new apqv(1, anvx.a(2131712969)));
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new apqv(2, "OCR"));
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new apqv(3, "AR"));
      }
    }
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_b_of_type_ArrayOfInt;
    }
    if (paramInt == 1) {
      return this.d;
    }
    if (paramInt == 2) {
      return this.jdField_c_of_type_ArrayOfInt;
    }
    return null;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqu
 * JD-Core Version:    0.7.0.1
 */