import android.content.Context;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.OCRScanEntryView;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.ar.view.ScanEntryProviderView;
import java.util.ArrayList;

public class apug
{
  private int jdField_a_of_type_Int;
  private ArrayList<apuh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131374748, 2131372011, 2131362869 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { anzj.a(2131712389), anzj.a(2131717571), "AR" };
  public boolean b;
  private final int[] b;
  public boolean c;
  private final int[] c;
  private final int[] d = { 2130844877, 2130844878, 2130844879, 2130844880, 2130844881, 2130844882, 2130844883, 2130844884 };
  
  public apug(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2130844885, 2130844886, 2130844887, 2130844888, 2130844889, 2130844890, 2130844891, 2130844892 };
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2130844860, 2130844861, 2130844862, 2130844863, 2130844864, 2130844865, 2130844866, 2130844867 };
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
  
  public apuh a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b())) {
      return (apuh)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public ScanEntryProviderView a(int paramInt, Context paramContext, apub paramapub)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new QRScanEntryView(paramContext, paramapub);
    case 3: 
      return new ARScanEntryView(paramContext, paramapub);
    }
    return new OCRScanEntryView(paramContext, paramapub);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new apuh(1, anzj.a(2131712390)));
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new apuh(2, "OCR"));
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new apuh(3, "AR"));
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
 * Qualified Name:     apug
 * JD-Core Version:    0.7.0.1
 */