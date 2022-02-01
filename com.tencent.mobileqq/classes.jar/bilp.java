import java.util.ArrayList;
import java.util.LinkedList;

public class bilp
{
  private static bilp jdField_a_of_type_Bilp;
  private ArrayList<biln> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private LinkedList<bilm> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private biln a(int paramInt1, int paramInt2)
  {
    return new biln(paramInt1, paramInt2);
  }
  
  public static bilp a()
  {
    if (jdField_a_of_type_Bilp == null) {}
    try
    {
      if (jdField_a_of_type_Bilp == null) {
        jdField_a_of_type_Bilp = new bilp();
      }
      return jdField_a_of_type_Bilp;
    }
    finally {}
  }
  
  public biln a(bilm parambilm, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 5)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(parambilm);
      return null;
    }
    biln localbiln = a(paramInt1, paramInt2);
    localbiln.a(parambilm);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbiln);
    return localbiln;
  }
  
  public void a(biln parambiln)
  {
    if (parambiln != null)
    {
      parambiln.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambiln);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() < 5) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        parambiln = (bilm)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
        biln localbiln = a(parambiln.getRenderWidth(), parambiln.getRenderHeight());
        localbiln.a(parambiln);
        this.jdField_a_of_type_JavaUtilArrayList.add(localbiln);
        parambiln.onSetRenderer(localbiln);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bilp
 * JD-Core Version:    0.7.0.1
 */