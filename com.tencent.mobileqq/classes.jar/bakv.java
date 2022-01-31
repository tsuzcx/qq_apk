import java.util.ArrayList;
import java.util.LinkedList;

public class bakv
{
  public int a;
  private ArrayList<LinkedList<bakw>> a;
  
  public bakv()
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
  
  public bakw a(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).size() != 0)
      {
        if (paramBoolean)
        {
          bakw localbakw = (bakw)((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).remove(0);
          this.jdField_a_of_type_Int -= 1;
          return localbakw;
        }
        return (bakw)((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get(0);
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
        localStringBuilder.append(baaw.encodeToString(((bakw)((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get(j)).b().getBytes(), 0));
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
  
  public void a(bakw parambakw)
  {
    if (parambakw == null) {}
    int i;
    do
    {
      return;
      i = parambakw.b() - 200;
    } while ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size()));
    ((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).add(parambakw);
    this.jdField_a_of_type_Int += 1;
  }
  
  public boolean a(bakw parambakw)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((LinkedList)this.jdField_a_of_type_JavaUtilArrayList.get(i)).remove(parambakw))
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
 * Qualified Name:     bakv
 * JD-Core Version:    0.7.0.1
 */