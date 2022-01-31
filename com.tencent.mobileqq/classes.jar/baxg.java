import java.util.ArrayList;
import java.util.LinkedList;

public class baxg
{
  private static baxg jdField_a_of_type_Baxg;
  private ArrayList<baxe> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private LinkedList<baxd> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private baxe a(int paramInt1, int paramInt2)
  {
    return new baxe(paramInt1, paramInt2);
  }
  
  public static baxg a()
  {
    if (jdField_a_of_type_Baxg == null) {}
    try
    {
      if (jdField_a_of_type_Baxg == null) {
        jdField_a_of_type_Baxg = new baxg();
      }
      return jdField_a_of_type_Baxg;
    }
    finally {}
  }
  
  public baxe a(baxd parambaxd, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 5)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(parambaxd);
      return null;
    }
    baxe localbaxe = a(paramInt1, paramInt2);
    localbaxe.a(parambaxd);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbaxe);
    return localbaxe;
  }
  
  public void a(baxe parambaxe)
  {
    if (parambaxe != null)
    {
      parambaxe.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambaxe);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() < 5) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        parambaxe = (baxd)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
        baxe localbaxe = a(parambaxe.getRenderWidth(), parambaxe.getRenderHeight());
        localbaxe.a(parambaxe);
        this.jdField_a_of_type_JavaUtilArrayList.add(localbaxe);
        parambaxe.onSetRenderer(localbaxe);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baxg
 * JD-Core Version:    0.7.0.1
 */