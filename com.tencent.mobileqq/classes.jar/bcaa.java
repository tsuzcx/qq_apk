import java.util.ArrayList;
import java.util.LinkedList;

public class bcaa
{
  private static bcaa jdField_a_of_type_Bcaa;
  private ArrayList<bbzy> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private LinkedList<bbzx> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private bbzy a(int paramInt1, int paramInt2)
  {
    return new bbzy(paramInt1, paramInt2);
  }
  
  public static bcaa a()
  {
    if (jdField_a_of_type_Bcaa == null) {}
    try
    {
      if (jdField_a_of_type_Bcaa == null) {
        jdField_a_of_type_Bcaa = new bcaa();
      }
      return jdField_a_of_type_Bcaa;
    }
    finally {}
  }
  
  public bbzy a(bbzx parambbzx, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 5)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(parambbzx);
      return null;
    }
    bbzy localbbzy = a(paramInt1, paramInt2);
    localbbzy.a(parambbzx);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbbzy);
    return localbbzy;
  }
  
  public void a(bbzy parambbzy)
  {
    if (parambbzy != null)
    {
      parambbzy.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambbzy);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() < 5) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        parambbzy = (bbzx)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
        bbzy localbbzy = a(parambbzy.getRenderWidth(), parambbzy.getRenderHeight());
        localbbzy.a(parambbzy);
        this.jdField_a_of_type_JavaUtilArrayList.add(localbbzy);
        parambbzy.onSetRenderer(localbbzy);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcaa
 * JD-Core Version:    0.7.0.1
 */