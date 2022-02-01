import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.1;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class bgtj
{
  public static bgtj a;
  public static final HashMap<String, String> a;
  public Object a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("troop_create", "https://admin.qun.qq.com/mcreatev3/info.html?_bid=206&_wv=2097155&cateid=<$CATEID>&subid=<$SUBID>&_nativeFrom=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_create_for_school", "https://admin.qun.qq.com/mcreatev4/classinfo?");
    jdField_a_of_type_JavaUtilHashMap.put("troop_create_for_game", "https://admin.qun.qq.com/mcreatev3/info.html?_bid=206&_wv=2097155&cateid=<$CATEID>&subid=<$SUBID>&_nativeFrom=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_rank", "https://qun.qq.com/qqweb/m/qun/rank/rank.html?gc=<$GC>&uin=<$UIN>&from=<$FROM>&_wv=1031&_bid=2468");
    jdField_a_of_type_JavaUtilHashMap.put("troop_level", "https://qinfo.clt.qq.com/qlevel/level.html?gc=<$GC>&type=<$TYPE>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_unique_title", "https://qun.qq.com/qqweb/m/qun/medal/index.html?_wv=16777223&_bid=2504&gc=<$GC>&uin=<$UIN>&from=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_create_notice", "https://web.qun.qq.com/mannounce/edit.html?_bid=148&_wv=1031&gc=<$GC>&title=<$TITLE>&content=<$CONTENT>&from=<$FROM>&school=1");
    jdField_a_of_type_JavaUtilHashMap.put("troop_create_homework", "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_list_homework", "https://qun.qq.com/homework/features/v2/index.html?_wv=1027&_bid=3089&gc=<$GC>&from=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_homework_create_notice", "https://web.qun.qq.com/mannounce/schooledit.html?_bid=148&_wv=1031&from=<$FROM>&content=<$CONTENT>&gc=<$GC>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_bind_game", "https://imgcache.qq.com/gc/gamecenterV2/dist/index/qqbindGroup/index.html?_wvx=10&_wvxBclr=0xffffff&_wv=1027");
    jdField_a_of_type_JavaUtilHashMap.put("troop_honor_page", "https://qun.qq.com/interactive/qunhonor?gc=<$GC>&_wv=3&&_wwv=128");
    jdField_a_of_type_JavaUtilHashMap.put("troop_member_honor_page", "https://qun.qq.com/interactive/userhonor?uin=<$UIN>&gc=<$GC>&_wv=3&&_wwv=128");
    jdField_a_of_type_JavaUtilHashMap.put("troop_honor_setting", "https://qinfo.clt.qq.com/qlevel/setting.html?_wv=4&_bid=125#gc=<$GC>&type=102&grayscale=<$GRAY>");
  }
  
  private bgtj()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.post(new TroopLinkManager.1(this, BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "troop_link_config.json"), 5, null, false);
  }
  
  public static bgtj a()
  {
    if (jdField_a_of_type_Bgtj == null) {}
    try
    {
      if (jdField_a_of_type_Bgtj == null) {
        jdField_a_of_type_Bgtj = new bgtj();
      }
      return jdField_a_of_type_Bgtj;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString = (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      return paramString;
    }
  }
  
  public String a(String paramString, int paramInt)
  {
    paramString = bgtk.a().a(paramString);
    String str = a().b("troop_honor_page", paramString);
    if (bdgb.b())
    {
      paramString = "&mode_color=000000";
      int i = bdgb.a();
      if (i != 0)
      {
        paramString = String.format("%08x", new Object[] { Integer.valueOf(i) }).substring(2);
        paramString = "&mode_color=" + paramString;
      }
    }
    for (paramString = str + paramString;; paramString = str) {
      return paramString + "&dragon_gray" + paramInt;
    }
  }
  
  public String a(String paramString, bgtk parambgtk)
  {
    String str1 = paramString;
    if (parambgtk.c != null) {
      str1 = paramString.replace("<$FROM>", parambgtk.c);
    }
    paramString = str1;
    if (parambgtk.a != null) {
      paramString = str1.replace("<$GC>", parambgtk.a);
    }
    str1 = paramString;
    if (parambgtk.e != null) {
      str1 = paramString.replace("<$NICK>", parambgtk.e);
    }
    paramString = str1;
    if (parambgtk.d != null) {
      paramString = str1.replace("<$TYPE>", parambgtk.d);
    }
    str1 = paramString;
    if (parambgtk.b != null) {
      str1 = paramString.replace("<$UIN>", parambgtk.b);
    }
    paramString = str1;
    if (parambgtk.f != null) {
      paramString = str1.replace("<$CATEID>", parambgtk.f);
    }
    str1 = paramString;
    if (parambgtk.g != null) {
      str1 = paramString.replace("<$SUBID>", parambgtk.g);
    }
    paramString = str1;
    if (parambgtk.j != null) {
      paramString = str1.replace("<$GRAY>", parambgtk.j);
    }
    str1 = paramString;
    if (parambgtk.h != null) {}
    try
    {
      str1 = paramString.replace("<$TITLE>", URLEncoder.encode(parambgtk.h, "UTF-8").replaceAll("\\+", "%20"));
      paramString = str1;
      if (parambgtk.i == null) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str2;
      for (;;)
      {
        try
        {
          paramString = str1.replace("<$CONTENT>", URLEncoder.encode(parambgtk.i, "UTF-8").replaceAll("\\+", "%20"));
          return paramString;
        }
        catch (UnsupportedEncodingException paramString)
        {
          paramString.printStackTrace();
        }
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        localUnsupportedEncodingException.printStackTrace();
        str2 = paramString;
      }
      return str2;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = bgtk.a().b(paramString2).a(paramString1);
    return a().b("troop_member_honor_page", paramString1);
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString3 = bgtk.a().a(paramString1).b(paramString2).e(paramString3).d("3").c("aio");
    paramString4 = a().b("troop_unique_title", paramString3);
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4))
    {
      paramString3 = new StringBuilder();
      paramString3.append("https://web.qun.qq.com/cgi-bin/misc/dynamic_url?");
      paramString3.append("gc=").append(paramString1).append("&");
      paramString3.append("uin=").append(paramString2).append("&");
      paramString3.append("type=").append(3).append("&");
      paramString3.append("from=").append("aio").append("&");
      paramString3.append("_wv=").append("16777223");
      paramString3.append("&_wwv=1");
      paramString3 = paramString3.toString();
    }
    return paramString3;
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    Object localObject = bgtk.a().a(paramString);
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      paramString = ((bgtk)localObject).f(paramString);
      localObject = a().b("troop_honor_setting", paramString);
      if (!bdgb.b()) {
        break;
      }
      paramString = "&mode_color=000000";
      int i = bdgb.a();
      if (i != 0)
      {
        paramString = String.format("%08x", new Object[] { Integer.valueOf(i) }).substring(2);
        paramString = "&mode_color=" + paramString;
      }
      return (String)localObject + paramString;
    }
    return localObject;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trooplink", 2, "config update:" + paramString);
    }
    try
    {
      localObject2 = new JSONObject(paramString);
      Iterator localIterator = ((JSONObject)localObject2).keys();
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = ((JSONObject)localObject2).getString(str1);
          jdField_a_of_type_JavaUtilHashMap.put(str1, str2);
        }
      }
      this.jdField_a_of_type_Boolean = true;
    }
    catch (Exception paramString)
    {
      QLog.e(".troop.trooplink", 1, "parseConfig failed!", paramString);
      return false;
    }
    ??? = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "troop_link_config.json";
    Object localObject2 = new File((String)???);
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    ThreadManager.post(new TroopLinkManager.2(this, (String)???, paramString), 5, null, false);
    return true;
  }
  
  public String b(String paramString, bgtk parambgtk)
  {
    String str = a(paramString);
    paramString = str;
    if (!TextUtils.isEmpty(str))
    {
      paramString = str;
      if (parambgtk != null) {
        paramString = a(str, parambgtk);
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtj
 * JD-Core Version:    0.7.0.1
 */