import java.util.ArrayList;
import java.util.LinkedList;

public class bedy
{
  private static bedy jdField_a_of_type_Bedy;
  private ArrayList<bedw> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private LinkedList<bedv> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private bedw a(int paramInt1, int paramInt2)
  {
    return new bedw(paramInt1, paramInt2);
  }
  
  public static bedy a()
  {
    if (jdField_a_of_type_Bedy == null) {}
    try
    {
      if (jdField_a_of_type_Bedy == null) {
        jdField_a_of_type_Bedy = new bedy();
      }
      return jdField_a_of_type_Bedy;
    }
    finally {}
  }
  
  public bedw a(bedv parambedv, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 5)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(parambedv);
      return null;
    }
    bedw localbedw = a(paramInt1, paramInt2);
    localbedw.a(parambedv);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbedw);
    return localbedw;
  }
  
  public void a(bedw parambedw)
  {
    if (parambedw != null)
    {
      parambedw.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambedw);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() < 5) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        parambedw = (bedv)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
        bedw localbedw = a(parambedw.getRenderWidth(), parambedw.getRenderHeight());
        localbedw.a(parambedw);
        this.jdField_a_of_type_JavaUtilArrayList.add(localbedw);
        parambedw.onSetRenderer(localbedw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedy
 * JD-Core Version:    0.7.0.1
 */