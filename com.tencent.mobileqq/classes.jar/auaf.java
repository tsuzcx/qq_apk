import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class auaf
{
  private OcrConfig a;
  public String a;
  public HashMap<String, String> a;
  public List<String> a;
  public String b;
  public List<String> b;
  public String c;
  public List<String> c;
  
  public auaf()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public Pair<String, String> a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((String)localEntry.getKey()).equalsIgnoreCase(paramString)) {
        return new Pair(localEntry.getKey(), localEntry.getValue());
      }
    }
    return null;
  }
  
  public String a()
  {
    Object localObject = "ocrLan:" + this.jdField_a_of_type_JavaLangString + ", ocrLanOptions:" + this.jdField_a_of_type_JavaUtilList.toString();
    String str1 = "srcLan:" + this.jdField_b_of_type_JavaLangString + ", srcLanOptions:" + this.jdField_b_of_type_JavaUtilList.toString();
    String str2 = "dstLan:" + this.jdField_c_of_type_JavaLangString + ", dstLanOptions:" + this.jdField_c_of_type_JavaUtilList.toString();
    localObject = new StringBuilder().append((String)localObject).append("\n").append(str1).append("\n").append(str2).append("\nOCRConfiGIsNull:");
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig == null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String a(String paramString)
  {
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_b_of_type_JavaLangString = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_c_of_type_JavaLangString = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auaf
 * JD-Core Version:    0.7.0.1
 */