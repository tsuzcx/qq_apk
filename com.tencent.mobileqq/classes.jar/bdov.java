import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bdov
  extends bdou
{
  private HashMap<String, bdor> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<bdos> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public String c = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
  
  public bdov()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private bdor a(String paramString1, String paramString2, bdos parambdos)
  {
    if ((TextUtils.isEmpty(paramString2)) || (parambdos == null)) {}
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
      arrayOfString = str1.split(parambdos.jdField_b_of_type_JavaLangString);
      if ((paramString2.length >= parambdos.jdField_a_of_type_Int) && (arrayOfString.length >= parambdos.d)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WadlCommConfig", 1, "interrupt url fail, pathInfo.length=" + paramString2.length + ",fileInfo.length=" + arrayOfString.length);
    return null;
    String str2 = paramString2[parambdos.jdField_b_of_type_Int];
    if (parambdos.c > -1)
    {
      paramString2 = paramString2[parambdos.c];
      if (parambdos.e <= -1) {
        break label192;
      }
    }
    label192:
    for (String str1 = arrayOfString[parambdos.e];; str1 = "")
    {
      return new bdor(str2, paramString2, str1, arrayOfString[parambdos.f], paramString1);
      paramString2 = "";
      break;
    }
  }
  
  /* Error */
  public bdor a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_0
    //   3: ifne +15 -> 18
    //   6: aload_0
    //   7: getfield 39	bdov:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   10: aload_1
    //   11: invokevirtual 130	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 115	bdor
    //   17: astore_2
    //   18: aload_2
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 34	bdov:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   24: invokeinterface 136 1 0
    //   29: astore 4
    //   31: aload_2
    //   32: astore_3
    //   33: aload 4
    //   35: invokeinterface 141 1 0
    //   40: ifeq +86 -> 126
    //   43: aload_2
    //   44: astore_3
    //   45: aload 4
    //   47: invokeinterface 145 1 0
    //   52: checkcast 68	bdos
    //   55: astore 5
    //   57: aload_2
    //   58: astore_3
    //   59: aload 5
    //   61: getfield 147	bdos:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokestatic 153	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   67: aload_1
    //   68: invokevirtual 157	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   71: astore 6
    //   73: aload_2
    //   74: astore_3
    //   75: aload 6
    //   77: invokevirtual 162	java/util/regex/Matcher:find	()Z
    //   80: ifeq +28 -> 108
    //   83: aload_2
    //   84: astore_3
    //   85: aload_0
    //   86: aload_1
    //   87: aload 6
    //   89: invokevirtual 165	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   92: aload 5
    //   94: invokespecial 167	bdov:a	(Ljava/lang/String;Ljava/lang/String;Lbdos;)Lbdor;
    //   97: astore_2
    //   98: aload_2
    //   99: astore_3
    //   100: aload_3
    //   101: astore_2
    //   102: aload_3
    //   103: ifnull +5 -> 108
    //   106: aload_3
    //   107: areturn
    //   108: goto -77 -> 31
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_2
    //   115: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   118: aload_1
    //   119: areturn
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: goto -9 -> 114
    //   126: aload_2
    //   127: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	bdov
    //   0	128	1	paramString	String
    //   1	101	2	localObject1	Object
    //   111	4	2	localException1	java.lang.Exception
    //   120	7	2	localException2	java.lang.Exception
    //   19	103	3	localObject2	Object
    //   29	17	4	localIterator	java.util.Iterator
    //   55	38	5	localbdos	bdos
    //   71	17	6	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   6	18	111	java/lang/Exception
    //   20	31	120	java/lang/Exception
    //   33	43	120	java/lang/Exception
    //   45	57	120	java/lang/Exception
    //   59	73	120	java/lang/Exception
    //   75	83	120	java/lang/Exception
    //   85	98	120	java/lang/Exception
  }
  
  public HashSet<String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a(String arg1)
  {
    boolean bool1 = true;
    super.a(???);
    if (TextUtils.isEmpty(???)) {
      return;
    }
    Object localObject3;
    Object localObject4;
    int j;
    int i;
    try
    {
      JSONObject localJSONObject = new JSONObject(new JSONObject(???).optString(this.jdField_a_of_type_JavaLangString));
      this.c = localJSONObject.optString("download_mgr_url", "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin");
      if (QLog.isColorLevel()) {
        QLog.d("WadlCommConfig", 1, "parse downloadMgrUrl=" + this.c);
      }
      localObject3 = localJSONObject.optJSONArray("websso_cmds");
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder().append("parse cmdArray=");
        if (localObject3 == null) {
          break label201;
        }
        ??? = ((JSONArray)localObject3).toString();
      }
      for (;;)
      {
        QLog.d("WadlCommConfig", 1, ???);
        if (localObject3 == null) {
          break label239;
        }
        j = ((JSONArray)localObject3).length();
        if (j <= 0) {
          break label239;
        }
        synchronized (this.jdField_a_of_type_JavaUtilHashSet)
        {
          this.jdField_a_of_type_JavaUtilHashSet.clear();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              boolean bool2 = TextUtils.isEmpty(((JSONArray)localObject3).optString(i));
              if (bool2)
              {
                i += 1;
                continue;
                label201:
                ??? = "empty";
                break;
              }
              this.jdField_a_of_type_JavaUtilHashSet.add(((JSONArray)localObject3).optString(i));
            }
          }
        }
      }
    }
    catch (JSONException ???)
    {
      ???.printStackTrace();
      return;
    }
    label239:
    label251:
    Object localObject2;
    if (localObject1.optInt("providerSwitch", 1) == 1)
    {
      this.jdField_a_of_type_Boolean = bool1;
      localObject2 = localObject1.optJSONObject("url_match_rule");
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("parse matchRuleObject=");
        if (localObject2 == null) {
          break label675;
        }
      }
    }
    label675:
    for (??? = ((JSONObject)localObject2).toString();; ??? = "empty")
    {
      QLog.d("WadlCommConfig", 1, ???);
      if (localObject2 == null) {
        break;
      }
      ??? = ((JSONObject)localObject2).optJSONArray("reg_list");
      if (??? != null)
      {
        j = ???.length();
        i = 0;
      }
      for (;;)
      {
        if (i < j)
        {
          localObject3 = ???.getJSONObject(i);
          localObject4 = new bdos();
          ((bdos)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("pattern");
          ((bdos)localObject4).jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("path_node_num");
          ((bdos)localObject4).jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("appid_index");
          ((bdos)localObject4).c = ((JSONObject)localObject3).optInt("app_name_index", -1);
          ((bdos)localObject4).jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).getString("split_name_char");
          ((bdos)localObject4).d = ((JSONObject)localObject3).getInt("name_node_num");
          ((bdos)localObject4).e = ((JSONObject)localObject3).optInt("channel_index", -1);
          ((bdos)localObject4).f = ((JSONObject)localObject3).getInt("pkg_name_index");
          if ((((bdos)localObject4).jdField_b_of_type_Int < ((bdos)localObject4).jdField_a_of_type_Int) && (((bdos)localObject4).c < ((bdos)localObject4).jdField_a_of_type_Int) && (((bdos)localObject4).e < ((bdos)localObject4).d) && (((bdos)localObject4).f < ((bdos)localObject4).d)) {
            this.jdField_a_of_type_JavaUtilList.add(localObject4);
          }
        }
        else
        {
          ??? = ((JSONObject)localObject2).optJSONArray("replace_list");
          if (??? == null) {
            break;
          }
          j = ???.length();
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
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, new bdor((String)localObject3, (String)localObject4, str1, str2, (String)localObject5));
            i += 1;
          }
          break;
        }
        i += 1;
      }
      bool1 = false;
      break label251;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdov
 * JD-Core Version:    0.7.0.1
 */