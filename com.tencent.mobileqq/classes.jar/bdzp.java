import java.util.ArrayList;
import java.util.LinkedList;

public class bdzp
{
  private static bdzp jdField_a_of_type_Bdzp;
  private ArrayList<bdzn> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private LinkedList<bdzm> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private bdzn a(int paramInt1, int paramInt2)
  {
    return new bdzn(paramInt1, paramInt2);
  }
  
  public static bdzp a()
  {
    if (jdField_a_of_type_Bdzp == null) {}
    try
    {
      if (jdField_a_of_type_Bdzp == null) {
        jdField_a_of_type_Bdzp = new bdzp();
      }
      return jdField_a_of_type_Bdzp;
    }
    finally {}
  }
  
  public bdzn a(bdzm parambdzm, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 5)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(parambdzm);
      return null;
    }
    bdzn localbdzn = a(paramInt1, paramInt2);
    localbdzn.a(parambdzm);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbdzn);
    return localbdzn;
  }
  
  public void a(bdzn parambdzn)
  {
    if (parambdzn != null)
    {
      parambdzn.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambdzn);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() < 5) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        parambdzn = (bdzm)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
        bdzn localbdzn = a(parambdzn.getRenderWidth(), parambdzn.getRenderHeight());
        localbdzn.a(parambdzn);
        this.jdField_a_of_type_JavaUtilArrayList.add(localbdzn);
        parambdzn.onSetRenderer(localbdzn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzp
 * JD-Core Version:    0.7.0.1
 */