import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class bbvk
{
  int jdField_a_of_type_Int;
  bbvk jdField_a_of_type_Bbvk;
  List<bbvj> jdField_a_of_type_JavaUtilList;
  bbvk[] jdField_a_of_type_ArrayOfBbvk;
  int b;
  int c = -1;
  
  bbvk(bbvk parambbvk, List<bbvj> paramList)
  {
    this.jdField_a_of_type_Bbvk = parambbvk;
    this.jdField_a_of_type_ArrayOfBbvk = new bbvk[bbvj.jdField_a_of_type_Int];
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = ((bbvj)paramList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    this.jdField_a_of_type_Int = -1;
    parambbvk = new int[2];
    bbvk tmp57_56 = parambbvk;
    tmp57_56[0] = 0;
    bbvk tmp61_57 = tmp57_56;
    tmp61_57[1] = 0;
    tmp61_57;
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext())
    {
      i = ((bbvj)paramList.next()).b;
      parambbvk[i] += 1;
    }
    if (parambbvk[0] > parambbvk[1]) {}
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
      if (this.jdField_a_of_type_Bbvk != null) {
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
      while (i < bbvj.jdField_a_of_type_Int)
      {
        if (this.jdField_a_of_type_ArrayOfBbvk[i] != null) {
          this.jdField_a_of_type_ArrayOfBbvk[i].a(paramPrintWriter);
        }
        i += 1;
      }
      paramPrintWriter.println("<leaf>");
      break;
      label93:
      i = 0;
      while (i < bbvj.jdField_a_of_type_Int)
      {
        if (this == this.jdField_a_of_type_Bbvk.jdField_a_of_type_ArrayOfBbvk[i]) {
          paramPrintWriter.print("fts" + this.jdField_a_of_type_Bbvk.jdField_a_of_type_Int + " = " + i);
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
  
  public int a(bbvj parambbvj)
  {
    int i = -1;
    if (this.jdField_a_of_type_Int == -1) {
      i = this.c;
    }
    while (this.jdField_a_of_type_ArrayOfBbvk[parambbvj.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]] == null) {
      return i;
    }
    return this.jdField_a_of_type_ArrayOfBbvk[parambbvj.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]].a(parambbvj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvk
 * JD-Core Version:    0.7.0.1
 */