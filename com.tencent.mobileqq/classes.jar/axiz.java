import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class axiz
{
  int jdField_a_of_type_Int;
  axiz jdField_a_of_type_Axiz;
  List<axiy> jdField_a_of_type_JavaUtilList;
  axiz[] jdField_a_of_type_ArrayOfAxiz;
  int b;
  int c = -1;
  
  axiz(axiz paramaxiz, List<axiy> paramList)
  {
    this.jdField_a_of_type_Axiz = paramaxiz;
    this.jdField_a_of_type_ArrayOfAxiz = new axiz[axiy.jdField_a_of_type_Int];
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = ((axiy)paramList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    this.jdField_a_of_type_Int = -1;
    paramaxiz = new int[2];
    axiz tmp57_56 = paramaxiz;
    tmp57_56[0] = 0;
    axiz tmp61_57 = tmp57_56;
    tmp61_57[1] = 0;
    tmp61_57;
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext())
    {
      i = ((axiy)paramList.next()).b;
      paramaxiz[i] += 1;
    }
    if (paramaxiz[0] > paramaxiz[1]) {}
    for (int i = 0;; i = 1)
    {
      this.c = i;
      return;
    }
  }
  
  private void a(PrintWriter paramPrintWriter)
  {
    int j = 0;
    if (this.jdField_a_of_type_Int != -1)
    {
      paramPrintWriter.println("<branch>");
      paramPrintWriter.print("<attribute name=\"name\" value=\"");
      if (this.jdField_a_of_type_Axiz != null) {
        break label93;
      }
      paramPrintWriter.print("root");
    }
    for (;;)
    {
      paramPrintWriter.println("\" />");
      if (this.jdField_a_of_type_Int == -1) {
        break label167;
      }
      int i = j;
      while (i < axiy.jdField_a_of_type_Int)
      {
        if (this.jdField_a_of_type_ArrayOfAxiz[i] != null) {
          this.jdField_a_of_type_ArrayOfAxiz[i].a(paramPrintWriter);
        }
        i += 1;
      }
      paramPrintWriter.println("<leaf>");
      break;
      label93:
      i = 0;
      while (i < axiy.jdField_a_of_type_Int)
      {
        if (this == this.jdField_a_of_type_Axiz.jdField_a_of_type_ArrayOfAxiz[i]) {
          paramPrintWriter.print("fts" + this.jdField_a_of_type_Axiz.jdField_a_of_type_Int + " = " + i);
        }
        i += 1;
      }
    }
    paramPrintWriter.println("</branch>");
    return;
    label167:
    paramPrintWriter.println("<attribute name=\"weight\" value=\"" + this.jdField_a_of_type_JavaUtilList.size() + "\" />");
    paramPrintWriter.println("</leaf>");
  }
  
  public int a(axiy paramaxiy)
  {
    int i = -1;
    if (this.jdField_a_of_type_Int == -1) {
      i = this.c;
    }
    while (this.jdField_a_of_type_ArrayOfAxiz[paramaxiy.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]] == null) {
      return i;
    }
    return this.jdField_a_of_type_ArrayOfAxiz[paramaxiy.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]].a(paramaxiy);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new PrintWriter(new FileWriter(paramString));
      paramString.println("<?xml version=\"1.0\" ?>");
      paramString.println("<tree>");
      paramString.println("<declarations>");
      paramString.println("<attributeDecl name=\"name\" type=\"String\" />");
      paramString.println("<attributeDecl name=\"weight\" type=\"Real\" />");
      paramString.println("</declarations>");
      a(paramString);
      paramString.println("</tree>");
      paramString.close();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axiz
 * JD-Core Version:    0.7.0.1
 */