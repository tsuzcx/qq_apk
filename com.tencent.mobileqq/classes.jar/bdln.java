import java.util.ArrayList;
import java.util.LinkedList;

public class bdln
{
  public int a;
  private ArrayList<LinkedList<bdlo>> a;
  
  public bdln()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new LinkedList());
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bdlo a(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).size() != 0)
      {
        if (paramBoolean)
        {
          bdlo localbdlo = (bdlo)((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).remove(0);
          this.jdField_a_of_type_Int -= 1;
          return localbdlo;
        }
        return (bdlo)((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get(0);
      }
      i += 1;
    }
    return null;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      int j = 0;
      while (j < ((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).size())
      {
        localStringBuilder.append(bdbi.encodeToString(((bdlo)((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get(j)).b().getBytes(), 0));
        localStringBuilder.append("\r\n");
        j += 1;
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).clear();
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(bdlo parambdlo)
  {
    if (parambdlo == null) {}
    int i;
    do
    {
      return;
      i = parambdlo.b() - 200;
    } while ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size()));
    ((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).add(parambdlo);
    this.jdField_a_of_type_Int += 1;
  }
  
  public boolean a(bdlo parambdlo)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).remove(parambdlo))
        {
          this.jdField_a_of_type_Int -= 1;
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdln
 * JD-Core Version:    0.7.0.1
 */