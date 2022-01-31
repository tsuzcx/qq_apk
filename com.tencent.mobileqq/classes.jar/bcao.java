import java.util.ArrayList;
import java.util.LinkedList;

public class bcao
{
  private static bcao jdField_a_of_type_Bcao;
  private ArrayList<bcam> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private LinkedList<bcal> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private bcam a(int paramInt1, int paramInt2)
  {
    return new bcam(paramInt1, paramInt2);
  }
  
  public static bcao a()
  {
    if (jdField_a_of_type_Bcao == null) {}
    try
    {
      if (jdField_a_of_type_Bcao == null) {
        jdField_a_of_type_Bcao = new bcao();
      }
      return jdField_a_of_type_Bcao;
    }
    finally {}
  }
  
  public bcam a(bcal parambcal, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 5)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(parambcal);
      return null;
    }
    bcam localbcam = a(paramInt1, paramInt2);
    localbcam.a(parambcal);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbcam);
    return localbcam;
  }
  
  public void a(bcam parambcam)
  {
    if (parambcam != null)
    {
      parambcam.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambcam);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() < 5) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        parambcam = (bcal)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
        bcam localbcam = a(parambcam.getRenderWidth(), parambcam.getRenderHeight());
        localbcam.a(parambcam);
        this.jdField_a_of_type_JavaUtilArrayList.add(localbcam);
        parambcam.onSetRenderer(localbcam);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcao
 * JD-Core Version:    0.7.0.1
 */