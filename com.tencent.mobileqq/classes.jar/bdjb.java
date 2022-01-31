import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.PhoneCodeUtils.1;
import com.tencent.mobileqq.utils.PhoneCodeUtils.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bdjb
{
  private static int jdField_a_of_type_Int = jdField_a_of_type_ArrayOfChar.length;
  private static String jdField_a_of_type_JavaLangString;
  public static HashMap<String, String> a;
  private static char[] jdField_a_of_type_ArrayOfChar;
  public static HashMap<String, String> b;
  private static HashMap<String, String> c = new HashMap(250);
  
  static
  {
    c.put("IL", "972");
    c.put("AF", "93");
    c.put("AL", "355");
    c.put("DZ", "213");
    c.put("AS", "1684");
    c.put("AD", "376");
    c.put("AO", "244");
    c.put("AI", "1264");
    c.put("AQ", "672");
    c.put("AG", "1268");
    c.put("AR", "54");
    c.put("AM", "374");
    c.put("AW", "297");
    c.put("AU", "61");
    c.put("AT", "43");
    c.put("AZ", "994");
    c.put("BS", "1242");
    c.put("BH", "973");
    c.put("BD", "880");
    c.put("BB", "1246");
    c.put("BY", "375");
    c.put("BE", "32");
    c.put("BZ", "501");
    c.put("BJ", "229");
    c.put("BM", "1441");
    c.put("BT", "975");
    c.put("BA", "387");
    c.put("BW", "267");
    c.put("BR", "55");
    c.put("IO", "246");
    c.put("BG", "359");
    c.put("BF", "226");
    c.put("BI", "257");
    c.put("KH", "855");
    c.put("CM", "237");
    c.put("CA", "1");
    c.put("CV", "238");
    c.put("KY", "345");
    c.put("CF", "236");
    c.put("TD", "235");
    c.put("CL", "56");
    c.put("CN", "86");
    c.put("CX", "61");
    c.put("CO", "57");
    c.put("KM", "269");
    c.put("CG", "242");
    c.put("CK", "682");
    c.put("CR", "506");
    c.put("HR", "385");
    c.put("CU", "53");
    c.put("CY", "537");
    c.put("CZ", "420");
    c.put("DK", "45");
    c.put("DJ", "253");
    c.put("DM", "1767");
    c.put("DO", "1809");
    c.put("EC", "593");
    c.put("EG", "20");
    c.put("SV", "503");
    c.put("GQ", "240");
    c.put("ER", "291");
    c.put("EE", "372");
    c.put("ET", "251");
    c.put("FO", "298");
    c.put("FJ", "679");
    c.put("FI", "358");
    c.put("FR", "33");
    c.put("GF", "594");
    c.put("PF", "689");
    c.put("GA", "241");
    c.put("GM", "220");
    c.put("GE", "995");
    c.put("DE", "49");
    c.put("GH", "233");
    c.put("GI", "350");
    c.put("GR", "30");
    c.put("GL", "299");
    c.put("GD", "1473");
    c.put("GP", "590");
    c.put("GU", "1671");
    c.put("GT", "502");
    c.put("GN", "224");
    c.put("GW", "245");
    c.put("GY", "595");
    c.put("HT", "509");
    c.put("HN", "504");
    c.put("HU", "36");
    c.put("IS", "354");
    c.put("IN", "91");
    c.put("ID", "62");
    c.put("IQ", "964");
    c.put("IE", "353");
    c.put("IL", "972");
    c.put("IT", "39");
    c.put("JM", "1876");
    c.put("JP", "81");
    c.put("JO", "962");
    c.put("KZ", "77");
    c.put("KE", "254");
    c.put("KI", "686");
    c.put("KW", "965");
    c.put("KG", "996");
    c.put("LV", "371");
    c.put("LB", "961");
    c.put("LS", "266");
    c.put("LR", "231");
    c.put("LI", "423");
    c.put("LT", "370");
    c.put("LU", "352");
    c.put("MG", "261");
    c.put("MW", "265");
    c.put("MY", "60");
    c.put("MV", "960");
    c.put("ML", "223");
    c.put("MT", "356");
    c.put("MH", "692");
    c.put("MQ", "596");
    c.put("MR", "222");
    c.put("MU", "230");
    c.put("YT", "262");
    c.put("MX", "52");
    c.put("MC", "377");
    c.put("MN", "976");
    c.put("ME", "382");
    c.put("MS", "1664");
    c.put("MA", "212");
    c.put("MM", "95");
    c.put("NA", "264");
    c.put("NR", "674");
    c.put("NP", "977");
    c.put("NL", "31");
    c.put("AN", "599");
    c.put("NC", "687");
    c.put("NZ", "64");
    c.put("NI", "505");
    c.put("NE", "227");
    c.put("NG", "234");
    c.put("NU", "683");
    c.put("NF", "672");
    c.put("MP", "1670");
    c.put("NO", "47");
    c.put("OM", "968");
    c.put("PK", "92");
    c.put("PW", "680");
    c.put("PA", "507");
    c.put("PG", "675");
    c.put("PY", "595");
    c.put("PE", "51");
    c.put("PH", "63");
    c.put("PL", "48");
    c.put("PT", "351");
    c.put("PR", "1");
    c.put("QA", "974");
    c.put("RO", "40");
    c.put("RW", "250");
    c.put("WS", "685");
    c.put("SM", "378");
    c.put("SA", "966");
    c.put("SN", "221");
    c.put("RS", "381");
    c.put("SC", "248");
    c.put("SL", "232");
    c.put("SG", "65");
    c.put("SK", "421");
    c.put("SI", "386");
    c.put("SB", "677");
    c.put("ZA", "27");
    c.put("GS", "500");
    c.put("ES", "34");
    c.put("LK", "94");
    c.put("SD", "249");
    c.put("SR", "597");
    c.put("SZ", "268");
    c.put("SE", "46");
    c.put("CH", "41");
    c.put("TJ", "992");
    c.put("TH", "66");
    c.put("TG", "228");
    c.put("TK", "690");
    c.put("TO", "676");
    c.put("TT", "1868");
    c.put("TN", "216");
    c.put("TR", "90");
    c.put("TM", "993");
    c.put("TC", "1649");
    c.put("TV", "688");
    c.put("UG", "256");
    c.put("UA", "380");
    c.put("AE", "971");
    c.put("GB", "44");
    c.put("US", "1");
    c.put("UY", "598");
    c.put("UZ", "998");
    c.put("VU", "678");
    c.put("WF", "681");
    c.put("YE", "967");
    c.put("ZM", "260");
    c.put("ZW", "263");
    c.put("BO", "591");
    c.put("BN", "673");
    c.put("CC", "61");
    c.put("CD", "243");
    c.put("CI", "225");
    c.put("FK", "500");
    c.put("GG", "44");
    c.put("VA", "379");
    c.put("HK", "852");
    c.put("IR", "98");
    c.put("IM", "44");
    c.put("JE", "44");
    c.put("KP", "850");
    c.put("KR", "82");
    c.put("LA", "856");
    c.put("LY", "218");
    c.put("MO", "853");
    c.put("MK", "389");
    c.put("FM", "691");
    c.put("MD", "373");
    c.put("MZ", "258");
    c.put("PS", "970");
    c.put("PN", "872");
    c.put("RE", "262");
    c.put("RU", "7");
    c.put("BL", "590");
    c.put("SH", "290");
    c.put("KN", "1869");
    c.put("LC", "1758");
    c.put("MF", "590");
    c.put("PM", "508");
    c.put("VC", "1784");
    c.put("ST", "239");
    c.put("SO", "252");
    c.put("SJ", "47");
    c.put("SY", "963");
    c.put("TW", "886");
    c.put("TZ", "255");
    c.put("TL", "670");
    c.put("VE", "58");
    c.put("VN", "84");
    c.put("VG", "1284");
    c.put("VI", "1340");
    jdField_a_of_type_JavaUtilHashMap = new PhoneCodeUtils.1(130);
    b = new PhoneCodeUtils.2(20);
    jdField_a_of_type_ArrayOfChar = new char[] { 0, 1, 0, 1 };
  }
  
  public static String a()
  {
    String str = b(null);
    if (!TextUtils.isEmpty(str))
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (str.equals(localEntry.getValue())) {
          localHashSet.add(localEntry.getKey());
        }
      }
      if (!localHashSet.isEmpty()) {
        return (String)localHashSet.iterator().next();
      }
    }
    return "";
  }
  
  public static String a(Context paramContext)
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getCountry();
      if (!TextUtils.isEmpty(paramContext)) {
        jdField_a_of_type_JavaLangString = (String)c.get(paramContext.toUpperCase());
      }
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        jdField_a_of_type_JavaLangString = "86";
      }
      jdField_a_of_type_JavaLangString = "+" + jdField_a_of_type_JavaLangString;
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = String.valueOf(Long.valueOf(Long.valueOf(paramString).longValue() + 6666L)).toCharArray();
      char[] arrayOfChar = new char[paramString.length];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfChar[i] = ((char)(paramString[i] ^ jdField_a_of_type_ArrayOfChar[(i % jdField_a_of_type_Int)]));
        i += 1;
      }
      if (arrayOfChar.length == 0) {
        return "";
      }
      paramString = new String(arrayOfChar);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(Locale paramLocale)
  {
    String str1 = paramLocale.getLanguage();
    String str2 = paramLocale.getCountry();
    paramLocale = str1;
    if (!bdnn.a(str2)) {
      paramLocale = str1 + "-" + str2;
    }
    return paramLocale.toLowerCase();
  }
  
  public static ArrayList<bdjc> a(String paramString)
  {
    QLog.d("PhoneCodeUtils", 1, "start parseCountryList");
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("PhoneCodeUtils", 1, "parseCountryList error : countryData is empty");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optJSONArray("favList");
      localObject = ((JSONObject)localObject).optJSONArray("itemList");
      paramString = a(paramString);
      if (paramString != null) {
        localArrayList.addAll(paramString);
      }
      paramString = a((JSONArray)localObject);
      if (paramString != null) {
        localArrayList.addAll(paramString);
      }
      QLog.d("PhoneCodeUtils", 1, "parseCountryList finish");
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      QLog.e("PhoneCodeUtils", 1, new Object[] { "parseCountryList JSONException : ", paramString.getMessage() });
    }
    return localArrayList;
  }
  
  public static ArrayList<bdjc> a(JSONArray paramJSONArray)
  {
    Object localObject2;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      QLog.e("PhoneCodeUtils", 1, "parseCountryList error : countryArray is null or empty");
      localObject2 = null;
    }
    ArrayList localArrayList;
    for (;;)
    {
      return localObject2;
      localArrayList = new ArrayList();
      Object localObject1 = null;
      int i = 0;
      localObject2 = localArrayList;
      try
      {
        if (i < paramJSONArray.length())
        {
          localObject2 = paramJSONArray.getJSONObject(i);
          String str1 = ((JSONObject)localObject2).optString("tag");
          String str2 = ((JSONObject)localObject2).optString("name");
          String str3 = ((JSONObject)localObject2).optString("abbr");
          String str4 = ((JSONObject)localObject2).optString("code");
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (localObject1.equals(str1)) {}
          }
          else
          {
            localArrayList.add(new bdjc(str1));
            localObject2 = str1;
          }
          localArrayList.add(new bdjc(str1, str3, str2, str4));
          i += 1;
          localObject1 = localObject2;
        }
      }
      catch (JSONException paramJSONArray)
      {
        QLog.e("PhoneCodeUtils", 1, new Object[] { "parseCountryList JSONException : ", paramJSONArray.getMessage() });
      }
    }
    return localArrayList;
  }
  
  public static LinkedHashMap<String, Integer> a(String[] paramArrayOfString, List<bdjc> paramList)
  {
    int j = 0;
    if ((paramList == null) || (paramArrayOfString == null))
    {
      QLog.e("PhoneCodeUtils", 1, "getNavigateMap error : countryCodes is null or navigationTags is null");
      return null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      bdjc localbdjc = (bdjc)paramList.next();
      if (localLinkedHashMap.containsKey(localbdjc.jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        localLinkedHashMap.put(localbdjc.jdField_a_of_type_JavaLangString, Integer.valueOf(i));
        i += 1;
      }
    }
    int m = paramArrayOfString.length;
    int k = 0;
    i = j;
    j = k;
    if (i < m)
    {
      paramList = paramArrayOfString[i];
      if (localLinkedHashMap.containsKey(paramList)) {
        j = ((Integer)localLinkedHashMap.get(paramList)).intValue();
      }
      for (;;)
      {
        i += 1;
        break;
        localLinkedHashMap.put(paramList, Integer.valueOf(j));
      }
    }
    return localLinkedHashMap;
  }
  
  public static String b()
  {
    String str = a(Locale.getDefault());
    if (b.containsKey(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneCodeUtil", 2, "code from Locale=" + str);
      }
      return (String)b.get(str);
    }
    return "86";
  }
  
  public static String b(Context paramContext)
  {
    paramContext = bdgk.b();
    if ((!TextUtils.isEmpty(paramContext)) && (paramContext.length() > 3))
    {
      String str = paramContext.trim().substring(0, 3);
      str = (String)jdField_a_of_type_JavaUtilHashMap.get(str);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneCodeUtil", 2, "code from IMSI=" + paramContext + "code=" + str);
      }
      return str;
    }
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjb
 * JD-Core Version:    0.7.0.1
 */