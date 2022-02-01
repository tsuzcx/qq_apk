import java.util.ArrayList;
import java.util.LinkedList;

public class bgry
{
  private static bgry jdField_a_of_type_Bgry;
  private ArrayList<bgrw> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private LinkedList<bgrv> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private bgrw a(int paramInt1, int paramInt2)
  {
    return new bgrw(paramInt1, paramInt2);
  }
  
  public static bgry a()
  {
    if (jdField_a_of_type_Bgry == null) {}
    try
    {
      if (jdField_a_of_type_Bgry == null) {
        jdField_a_of_type_Bgry = new bgry();
      }
      return jdField_a_of_type_Bgry;
    }
    finally {}
  }
  
  public bgrw a(bgrv parambgrv, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 5)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(parambgrv);
      return null;
    }
    bgrw localbgrw = a(paramInt1, paramInt2);
    localbgrw.a(parambgrv);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbgrw);
    return localbgrw;
  }
  
  public void a(bgrw parambgrw)
  {
    if (parambgrw != null)
    {
      parambgrw.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambgrw);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() < 5) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        parambgrw = (bgrv)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
        bgrw localbgrw = a(parambgrw.getRenderWidth(), parambgrw.getRenderHeight());
        localbgrw.a(parambgrw);
        this.jdField_a_of_type_JavaUtilArrayList.add(localbgrw);
        parambgrw.onSetRenderer(localbgrw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgry
 * JD-Core Version:    0.7.0.1
 */