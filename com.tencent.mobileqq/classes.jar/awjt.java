import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class awjt
{
  int jdField_a_of_type_Int;
  awjt jdField_a_of_type_Awjt;
  List<awjs> jdField_a_of_type_JavaUtilList;
  awjt[] jdField_a_of_type_ArrayOfAwjt;
  int b;
  int c = -1;
  
  awjt(awjt paramawjt, List<awjs> paramList)
  {
    this.jdField_a_of_type_Awjt = paramawjt;
    this.jdField_a_of_type_ArrayOfAwjt = new awjt[awjs.jdField_a_of_type_Int];
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = ((awjs)paramList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    this.jdField_a_of_type_Int = -1;
    paramawjt = new int[2];
    awjt tmp57_56 = paramawjt;
    tmp57_56[0] = 0;
    awjt tmp61_57 = tmp57_56;
    tmp61_57[1] = 0;
    tmp61_57;
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext())
    {
      i = ((awjs)paramList.next()).b;
      paramawjt[i] += 1;
    }
    if (paramawjt[0] > paramawjt[1]) {}
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
      if (this.jdField_a_of_type_Awjt != null) {
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
      while (i < awjs.jdField_a_of_type_Int)
      {
        if (this.jdField_a_of_type_ArrayOfAwjt[i] != null) {
          this.jdField_a_of_type_ArrayOfAwjt[i].a(paramPrintWriter);
        }
        i += 1;
      }
      paramPrintWriter.println("<leaf>");
      break;
      label93:
      i = 0;
      while (i < awjs.jdField_a_of_type_Int)
      {
        if (this == this.jdField_a_of_type_Awjt.jdField_a_of_type_ArrayOfAwjt[i]) {
          paramPrintWriter.print("fts" + this.jdField_a_of_type_Awjt.jdField_a_of_type_Int + " = " + i);
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
  
  public int a(awjs paramawjs)
  {
    int i = -1;
    if (this.jdField_a_of_type_Int == -1) {
      i = this.c;
    }
    while (this.jdField_a_of_type_ArrayOfAwjt[paramawjs.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]] == null) {
      return i;
    }
    return this.jdField_a_of_type_ArrayOfAwjt[paramawjs.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]].a(paramawjs);
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
 * Qualified Name:     awjt
 * JD-Core Version:    0.7.0.1
 */