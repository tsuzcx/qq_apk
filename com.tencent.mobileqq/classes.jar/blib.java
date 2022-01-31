import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class blib
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("调试信息：\n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str + "：" + (String)this.jdField_a_of_type_JavaUtilHashMap.get(str) + "\n");
    }
    return localStringBuilder.toString();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length / 2)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramArrayOfString[(i * 2)], paramArrayOfString[(i * 2 + 1)]);
      i += 1;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blib
 * JD-Core Version:    0.7.0.1
 */