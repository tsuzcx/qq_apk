import java.util.ArrayList;
import java.util.LinkedList;

public class bico
{
  private static bico jdField_a_of_type_Bico;
  private ArrayList<bicm> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private LinkedList<bicl> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private bicm a(int paramInt1, int paramInt2)
  {
    return new bicm(paramInt1, paramInt2);
  }
  
  public static bico a()
  {
    if (jdField_a_of_type_Bico == null) {}
    try
    {
      if (jdField_a_of_type_Bico == null) {
        jdField_a_of_type_Bico = new bico();
      }
      return jdField_a_of_type_Bico;
    }
    finally {}
  }
  
  public bicm a(bicl parambicl, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 5)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(parambicl);
      return null;
    }
    bicm localbicm = a(paramInt1, paramInt2);
    localbicm.a(parambicl);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbicm);
    return localbicm;
  }
  
  public void a(bicm parambicm)
  {
    if (parambicm != null)
    {
      parambicm.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambicm);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() < 5) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        parambicm = (bicl)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
        bicm localbicm = a(parambicm.getRenderWidth(), parambicm.getRenderHeight());
        localbicm.a(parambicm);
        this.jdField_a_of_type_JavaUtilArrayList.add(localbicm);
        parambicm.onSetRenderer(localbicm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bico
 * JD-Core Version:    0.7.0.1
 */