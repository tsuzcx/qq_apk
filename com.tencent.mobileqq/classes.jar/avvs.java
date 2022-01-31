import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class avvs
{
  public String a;
  public HashMap<String, String> a;
  public List<String> a;
  public String b;
  public List<String> b;
  public String c;
  public List<String> c;
  
  public avvs()
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
    String str1 = "ocrLan:" + this.jdField_a_of_type_JavaLangString + ", ocrLanOptions:" + this.jdField_a_of_type_JavaUtilList.toString();
    String str2 = "srcLan:" + this.jdField_b_of_type_JavaLangString + ", srcLanOptions:" + this.jdField_b_of_type_JavaUtilList.toString();
    String str3 = "dstLan:" + this.jdField_c_of_type_JavaLangString + ", dstLanOptions:" + this.jdField_c_of_type_JavaUtilList.toString();
    return str1 + "\n" + str2 + "\n" + str3;
  }
  
  public String a(String paramString)
  {
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_c_of_type_JavaUtilList = avvq.a(this.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = ((String)this.jdField_c_of_type_JavaUtilList.get(0));
    }
  }
  
  public boolean a(List<String> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((String)paramList.next()).trim().equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public String b(String paramString)
  {
    if (paramString.equalsIgnoreCase("zh")) {
      return "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th".trim().split("/")[0];
    }
    return "zh";
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_c_of_type_JavaLangString = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avvs
 * JD-Core Version:    0.7.0.1
 */