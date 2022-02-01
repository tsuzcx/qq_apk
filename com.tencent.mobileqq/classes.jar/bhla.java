import java.util.ArrayList;
import java.util.LinkedList;

public class bhla
{
  private static bhla jdField_a_of_type_Bhla;
  private ArrayList<bhky> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private LinkedList<bhkx> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private bhky a(int paramInt1, int paramInt2)
  {
    return new bhky(paramInt1, paramInt2);
  }
  
  public static bhla a()
  {
    if (jdField_a_of_type_Bhla == null) {}
    try
    {
      if (jdField_a_of_type_Bhla == null) {
        jdField_a_of_type_Bhla = new bhla();
      }
      return jdField_a_of_type_Bhla;
    }
    finally {}
  }
  
  public bhky a(bhkx parambhkx, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 5)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(parambhkx);
      return null;
    }
    bhky localbhky = a(paramInt1, paramInt2);
    localbhky.a(parambhkx);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbhky);
    return localbhky;
  }
  
  public void a(bhky parambhky)
  {
    if (parambhky != null)
    {
      parambhky.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambhky);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() < 5) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        parambhky = (bhkx)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
        bhky localbhky = a(parambhky.getRenderWidth(), parambhky.getRenderHeight());
        localbhky.a(parambhky);
        this.jdField_a_of_type_JavaUtilArrayList.add(localbhky);
        parambhky.onSetRenderer(localbhky);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhla
 * JD-Core Version:    0.7.0.1
 */