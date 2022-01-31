import android.content.Context;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.OCRScanEntryView;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.ar.view.ScanEntryProviderView;
import java.util.ArrayList;

public class andt
{
  private int jdField_a_of_type_Int;
  private ArrayList<andu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131373854, 2131371313, 2131362739 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { alpo.a(2131713889), alpo.a(2131719384), "AR" };
  public boolean b;
  private final int[] b;
  public boolean c;
  private final int[] c;
  private final int[] d = { 2130844397, 2130844398, 2130844399, 2130844400, 2130844401, 2130844402, 2130844403, 2130844404 };
  
  public andt(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2130844405, 2130844406, 2130844407, 2130844408, 2130844409, 2130844410, 2130844411, 2130844412 };
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2130844380, 2130844381, 2130844382, 2130844383, 2130844384, 2130844385, 2130844386, 2130844387 };
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
  
  public andu a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b())) {
      return (andu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public ScanEntryProviderView a(int paramInt, Context paramContext, ando paramando)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new QRScanEntryView(paramContext, paramando);
    case 3: 
      return new ARScanEntryView(paramContext, paramando);
    }
    return new OCRScanEntryView(paramContext, paramando);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new andu(1, alpo.a(2131713890)));
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new andu(2, "OCR"));
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new andu(3, "AR"));
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
 * Qualified Name:     andt
 * JD-Core Version:    0.7.0.1
 */