import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bkaf
  extends bkae
{
  public int a;
  private HashMap<String, bkab> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<bkac> jdField_a_of_type_JavaUtilList = new ArrayList();
  public String c = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
  
  public bkaf()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  private bkab a(String paramString1, String paramString2, bkac parambkac)
  {
    if ((TextUtils.isEmpty(paramString2)) || (parambkac == null)) {}
    String[] arrayOfString;
    do
    {
      int i;
      do
      {
        return null;
        i = paramString2.lastIndexOf("/") + 1;
      } while (i < 2);
      str1 = paramString2.substring(i);
      paramString2 = paramString2.substring(0, i).split("/");
      arrayOfString = str1.split(parambkac.jdField_b_of_type_JavaLangString);
      if ((paramString2.length >= parambkac.jdField_a_of_type_Int) && (arrayOfString.length >= parambkac.d)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WadlCommConfig", 1, "interrupt url fail, pathInfo.length=" + paramString2.length + ",fileInfo.length=" + arrayOfString.length);
    return null;
    String str2 = paramString2[parambkac.jdField_b_of_type_Int];
    if (parambkac.c > -1)
    {
      paramString2 = paramString2[parambkac.c];
      if (parambkac.e <= -1) {
        break label192;
      }
    }
    label192:
    for (String str1 = arrayOfString[parambkac.e];; str1 = "")
    {
      return new bkab(str2, paramString2, str1, arrayOfString[parambkac.f], paramString1);
      paramString2 = "";
      break;
    }
  }
  
  /* Error */
  public bkab a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	bkaf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: aload_1
    //   5: invokevirtual 128	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 113	bkab
    //   11: astore_2
    //   12: aload_2
    //   13: astore_3
    //   14: aload_2
    //   15: ifnonnull +70 -> 85
    //   18: aload_0
    //   19: getfield 34	bkaf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   22: invokeinterface 134 1 0
    //   27: astore 4
    //   29: aload_2
    //   30: astore_3
    //   31: aload 4
    //   33: invokeinterface 139 1 0
    //   38: ifeq +47 -> 85
    //   41: aload 4
    //   43: invokeinterface 143 1 0
    //   48: checkcast 68	bkac
    //   51: astore_3
    //   52: aload_3
    //   53: getfield 145	bkac:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokestatic 151	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   59: aload_1
    //   60: invokevirtual 155	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   63: astore 5
    //   65: aload 5
    //   67: invokevirtual 160	java/util/regex/Matcher:find	()Z
    //   70: ifeq -41 -> 29
    //   73: aload_0
    //   74: aload_1
    //   75: aload 5
    //   77: invokevirtual 163	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   80: aload_3
    //   81: invokespecial 165	bkaf:a	(Ljava/lang/String;Ljava/lang/String;Lbkac;)Lbkab;
    //   84: astore_3
    //   85: aload_3
    //   86: areturn
    //   87: astore_1
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_1
    //   91: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   94: aload_2
    //   95: areturn
    //   96: astore_1
    //   97: goto -7 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	bkaf
    //   0	100	1	paramString	String
    //   11	84	2	localbkab	bkab
    //   13	73	3	localObject	Object
    //   27	15	4	localIterator	java.util.Iterator
    //   63	13	5	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   0	12	87	java/lang/Exception
    //   18	29	96	java/lang/Exception
    //   31	85	96	java/lang/Exception
  }
  
  public HashSet<String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a(String arg1)
  {
    boolean bool = true;
    super.a(???);
    Object localObject3;
    int j;
    int i;
    Object localObject4;
    try
    {
      JSONObject localJSONObject = new JSONObject(new JSONObject(???).optString(this.jdField_a_of_type_JavaLangString));
      this.c = localJSONObject.optString("download_mgr_url", "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin");
      this.jdField_a_of_type_Int = localJSONObject.optInt("x5_log_seed", -1);
      localObject3 = localJSONObject.optJSONArray("websso_cmds");
      if (localObject3 == null) {
        break label149;
      }
      j = ((JSONArray)localObject3).length();
      if (j <= 0) {
        break label149;
      }
      synchronized (this.jdField_a_of_type_JavaUtilHashSet)
      {
        this.jdField_a_of_type_JavaUtilHashSet.clear();
        i = 0;
        if (i >= j) {
          break label147;
        }
        localObject4 = ((JSONArray)localObject3).optString(i);
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label544;
        }
        this.jdField_a_of_type_JavaUtilHashSet.add(localObject4);
      }
      return;
    }
    catch (JSONException ???)
    {
      ???.printStackTrace();
    }
    label146:
    label147:
    label149:
    if (localObject1.optInt("providerSwitch", 1) == 1) {}
    for (;;)
    {
      cooperation.wadl.WadlProvider.jdField_a_of_type_Boolean = bool;
      cooperation.wadl.WadlProvider.jdField_a_of_type_JavaLangString = localObject1.optString("providerSignKey", "");
      ??? = localObject1.optJSONObject("url_match_rule");
      if (??? == null) {
        break label146;
      }
      Object localObject2 = ???.optJSONArray("reg_list");
      if (localObject2 != null)
      {
        j = ((JSONArray)localObject2).length();
        if (j > 0) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject4 = new bkac();
          ((bkac)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("pattern");
          ((bkac)localObject4).jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("path_node_num");
          ((bkac)localObject4).jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("appid_index");
          ((bkac)localObject4).c = ((JSONObject)localObject3).optInt("app_name_index", -1);
          ((bkac)localObject4).jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).getString("split_name_char");
          ((bkac)localObject4).d = ((JSONObject)localObject3).getInt("name_node_num");
          ((bkac)localObject4).e = ((JSONObject)localObject3).optInt("channel_index", -1);
          ((bkac)localObject4).f = ((JSONObject)localObject3).getInt("pkg_name_index");
          if ((((bkac)localObject4).jdField_b_of_type_Int < ((bkac)localObject4).jdField_a_of_type_Int) && (((bkac)localObject4).c < ((bkac)localObject4).jdField_a_of_type_Int) && (((bkac)localObject4).e < ((bkac)localObject4).d) && (((bkac)localObject4).f < ((bkac)localObject4).d)) {
            this.jdField_a_of_type_JavaUtilList.add(localObject4);
          }
        }
        else
        {
          ??? = ???.optJSONArray("replace_list");
          if (??? == null) {
            break label146;
          }
          j = ???.length();
          if (j <= 0) {
            break label146;
          }
          i = 0;
          while (i < j)
          {
            Object localObject5 = ???.getJSONObject(i);
            localObject2 = ((JSONObject)localObject5).getString("url");
            localObject3 = ((JSONObject)localObject5).getString("appid");
            localObject4 = ((JSONObject)localObject5).optString("app_name", "");
            String str1 = ((JSONObject)localObject5).optString("channel", "");
            String str2 = ((JSONObject)localObject5).getString("pkg_name");
            localObject5 = ((JSONObject)localObject5).optString("replace_url", "");
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, new bkab((String)localObject3, (String)localObject4, str1, str2, (String)localObject5));
            i += 1;
          }
          break label146;
          label544:
          i += 1;
          break;
        }
        i += 1;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkaf
 * JD-Core Version:    0.7.0.1
 */