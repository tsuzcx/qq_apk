import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class beln
  implements Iterator<belm>
{
  private Iterator<belm> jdField_a_of_type_JavaUtilIterator;
  List<belm> jdField_a_of_type_JavaUtilList;
  
  public beln(String paramString)
  {
    if (beks.a)
    {
      this.jdField_a_of_type_JavaUtilList = new belo().a(paramString);
      this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Matcher localMatcher = Pattern.compile("((?:\\*[0-9a-z]+)*)(?:\\|([0-9a-z]+))?([-+=])([0-9a-z]+)|\\?|").matcher(paramString);
    label61:
    Object localObject;
    char c;
    label140:
    String str;
    while (localMatcher.find()) {
      if (localMatcher.group(0).length() != 0)
      {
        if ("?".equals(localMatcher.group(0))) {
          throw new IllegalArgumentException("Hit error opcode in op stream: " + paramString);
        }
        localObject = localMatcher.group(3);
        if (!belw.a((String)localObject)) {
          break label220;
        }
        c = '\000';
        localObject = beks.a(c);
        str = localMatcher.group(2);
        if (!belw.a(str)) {
          break label230;
        }
        i = 0;
        label164:
        ((belm)localObject).b = i;
        ((belm)localObject).jdField_a_of_type_JavaLangString = localMatcher.group(1);
        str = localMatcher.group(4);
        if (!belw.a(str)) {
          break label239;
        }
      }
    }
    label220:
    label230:
    label239:
    for (int i = 0;; i = beks.a(str))
    {
      ((belm)localObject).jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      break label61;
      break;
      c = ((String)localObject).charAt(0);
      break label140;
      i = beks.a(str);
      break label164;
    }
  }
  
  public belm a()
  {
    return (belm)this.jdField_a_of_type_JavaUtilIterator.next();
  }
  
  public boolean hasNext()
  {
    return this.jdField_a_of_type_JavaUtilIterator.hasNext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beln
 * JD-Core Version:    0.7.0.1
 */