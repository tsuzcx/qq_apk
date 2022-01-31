import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqreader.utils.QRDebugEnvUrlUtils;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bizx
{
  public static final int a;
  public static final int b;
  public static final int c;
  private Context jdField_a_of_type_AndroidContentContext;
  private bjan jdField_a_of_type_Bjan = new bizz(this);
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new bizy(this);
  private String jdField_a_of_type_JavaLangString = "#FDFDFD";
  private ArrayList<bjam> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap(6);
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private String jdField_b_of_type_JavaLangString = "#666666";
  private ArrayList<bjam> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, String> jdField_b_of_type_JavaUtilHashMap = new HashMap(6);
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  private String jdField_c_of_type_JavaLangString = "#E0AC00";
  private HashMap<Integer, String> jdField_c_of_type_JavaUtilHashMap = new HashMap(6);
  private String[] jdField_c_of_type_ArrayOfJavaLangString;
  
  static
  {
    jdField_a_of_type_Int = Color.parseColor("#FDFDFD");
    jdField_b_of_type_Int = Color.parseColor("#666666");
    jdField_c_of_type_Int = Color.parseColor("#E0AC00");
  }
  
  public bizx(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    d();
    e();
  }
  
  public static int a(int paramInt)
  {
    HashMap localHashMap = new HashMap(6);
    localHashMap.put(Integer.valueOf(102), Integer.valueOf(0));
    localHashMap.put(Integer.valueOf(100), Integer.valueOf(1));
    localHashMap.put(Integer.valueOf(101), Integer.valueOf(2));
    localHashMap.put(Integer.valueOf(104), Integer.valueOf(3));
    localHashMap.put(Integer.valueOf(103), Integer.valueOf(6));
    localHashMap.put(Integer.valueOf(105), Integer.valueOf(4));
    return ((Integer)localHashMap.get(Integer.valueOf(paramInt))).intValue();
  }
  
  @Nullable
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = e();
    paramString = paramString + (String)localObject;
    localObject = new StringBuilder().append(paramString);
    if (paramString.contains("?")) {}
    for (paramString = "&";; paramString = "?")
    {
      localObject = paramString;
      paramString = (String)localObject;
      if (!((String)localObject).contains("_bid=2036")) {
        paramString = (String)localObject + "_bid=2036";
      }
      localObject = paramString;
      if (!paramString.contains("&refer=qqreader")) {
        localObject = paramString + "&refer=qqreader";
      }
      paramString = (String)localObject;
      if (!((String)localObject).contains("&ChannelID=")) {
        paramString = (String)localObject + "&ChannelID=" + bjbq.a();
      }
      localObject = paramString;
      if (QRDebugEnvUrlUtils.isDebugEnv()) {
        localObject = QRDebugEnvUrlUtils.getTestUrl(paramString);
      }
      bjbl.e("ReaderTabConfigDataHelper", " url=" + (String)localObject);
      return localObject;
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[paramInt];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[paramInt];
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[paramInt];
    this.jdField_c_of_type_ArrayOfJavaLangString = new String[paramInt];
  }
  
  private void a(ArrayList<bjam> paramArrayList)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      bjam localbjam = (bjam)paramArrayList.get(i);
      this.jdField_c_of_type_ArrayOfJavaLangString[i] = localbjam.jdField_c_of_type_JavaLangString;
      int k = localbjam.jdField_a_of_type_Int;
      this.jdField_a_of_type_ArrayOfInt[i] = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k))).intValue();
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(k)));
      this.jdField_b_of_type_ArrayOfJavaLangString[i] = ((String)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(k)));
      i += 1;
    }
  }
  
  private boolean a(ArrayList<bjam> paramArrayList1, ArrayList<bjam> paramArrayList2)
  {
    int j = paramArrayList1.size();
    if (paramArrayList1.size() == paramArrayList2.size())
    {
      int i = 0;
      while (i < j)
      {
        if (!((bjam)paramArrayList1.get(i)).equals(paramArrayList2.get(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = (JSONArray)paramJSONObject.get("tabList");
        if (!QLog.isColorLevel()) {
          break label137;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = (String)paramJSONObject.get("tabColor");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.jdField_a_of_type_JavaLangString = ((String)localObject2);
          }
          localObject2 = (String)paramJSONObject.get("tabNameDefaultColor");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.jdField_b_of_type_JavaLangString = ((String)localObject2);
          }
          paramJSONObject = (String)paramJSONObject.get("tabNameSelectedColor");
          if (!TextUtils.isEmpty(paramJSONObject)) {
            this.jdField_c_of_type_JavaLangString = paramJSONObject;
          }
          paramJSONObject = localJSONArray;
          if (paramJSONObject != null) {
            break label140;
          }
          i = 0;
          if (i != 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("ReaderTabConfigDataHelper", 2, "jsonDataToTabItemData ,size=0");
          }
          return false;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i;
            int j;
            int m;
            ArrayList localArrayList;
            int k;
            paramJSONObject = (JSONObject)localObject1;
            Object localObject1 = localException2;
            continue;
            j += 1;
          }
        }
        localException1 = localException1;
        paramJSONObject = (JSONObject)localObject2;
      }
      QLog.e("ReaderTabConfigDataHelper", 2, localException1.getMessage());
      label137:
      continue;
      label140:
      i = paramJSONObject.length();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    j = 0;
    if (j < i) {}
    try
    {
      localObject1 = paramJSONObject.getJSONObject(j);
      localObject2 = (JSONArray)((JSONObject)localObject1).get("tabUrls");
      m = ((JSONArray)localObject2).length();
      localArrayList = new ArrayList(2);
      k = 0;
      while (k < m)
      {
        localArrayList.add(a(((JSONArray)localObject2).getString(k)));
        k += 1;
      }
      k = ((JSONObject)localObject1).optInt("tabHidden");
      localObject1 = new bjam(((JSONObject)localObject1).optInt("tabID", -1), ((JSONObject)localObject1).optString("tabName"), ((JSONObject)localObject1).optString("n_tabIcon"), ((JSONObject)localObject1).optString("h_tabIcon"), localArrayList, k);
      if (k != 0) {
        break label397;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
    }
    catch (Exception paramJSONObject)
    {
      if (!QLog.isColorLevel()) {
        break label383;
      }
      QLog.e("ReaderTabConfigDataHelper", 2, paramJSONObject.getMessage());
      return false;
    }
    paramJSONObject = this.jdField_a_of_type_AndroidContentContext;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      bjbj.d(paramJSONObject, paramBoolean);
      if (!a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilArrayList)) {
        b();
      }
      this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      return true;
    }
  }
  
  private void c() {}
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(102), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(100), Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(101), Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(104), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(103), Integer.valueOf(6));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(105), Integer.valueOf(4));
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(102), "302");
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100), "10100");
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(101), "300");
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(104), "310");
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(103), "");
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(105), "");
    this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(102), "10298");
    this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(100), "10296");
    this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(101), "10297");
    this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(104), "10299");
    this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(103), "");
    this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(105), "");
  }
  
  private String e()
  {
    return "&" + d();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      a(this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
      bjbl.d("ReaderTabConfigDataHelper", "tab url from local");
      a(4);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      bjam localbjam = new bjam();
      localbjam.jdField_a_of_type_Int = 100;
      localbjam.jdField_a_of_type_JavaLangString = "书城";
      localbjam.jdField_b_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_ELPT79nUxC.png";
      localbjam.jdField_c_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_AXwBTwpLm8.png";
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(a("https://cdn.vip.qq.com/club/client/read/6/rel/bookStore_index.html?configfrom=local&_bid=2036&_wwv=128"));
      localbjam.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      this.jdField_a_of_type_JavaUtilArrayList.add(localbjam);
      localbjam = new bjam();
      localbjam.jdField_a_of_type_Int = 101;
      localbjam.jdField_a_of_type_JavaLangString = "分类";
      localbjam.jdField_b_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_u3wddLskp6.png";
      localbjam.jdField_c_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_xYKQeprMCg.png";
      localArrayList = new ArrayList(1);
      localArrayList.add(a("https://cdn.vip.qq.com/club/client/read/6/rel/category_index.html?configfrom=local&_bid=2036"));
      localbjam.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      this.jdField_a_of_type_JavaUtilArrayList.add(localbjam);
      localbjam = new bjam();
      localbjam.jdField_a_of_type_Int = 102;
      localbjam.jdField_a_of_type_JavaLangString = "书架";
      localbjam.jdField_b_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_G6VUELHdgC.png";
      localbjam.jdField_c_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_f9xtLKYkBV.png";
      localArrayList = new ArrayList(2);
      localArrayList.add(a("https://cdn.vip.qq.com/club/client/read/6/rel/newBookShelf_index.html?configfrom=local&_bid=2036"));
      localArrayList.add(a("https://cdn.vip.qq.com/club/client/read/6/rel/newBookShelf_fm.html?configfrom=local&_bid=2036"));
      localbjam.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      this.jdField_a_of_type_JavaUtilArrayList.add(localbjam);
      localbjam = new bjam();
      localbjam.jdField_a_of_type_Int = 104;
      localbjam.jdField_a_of_type_JavaLangString = "我的";
      localbjam.jdField_b_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190604150617_XAeQPgB9Z8.png";
      localbjam.jdField_c_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190603213616_wdBlMCyKuS.png";
      localArrayList = new ArrayList(1);
      localArrayList.add(a("https://cdn.vip.qq.com/club/client/read/6/rel/mytab_index.html?configfrom=local&_bid=2036"));
      localbjam.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      this.jdField_a_of_type_JavaUtilArrayList.add(localbjam);
    }
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("CGI_RESPONSE", 0).getString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), "");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    try
    {
      a(new JSONObject(str), true);
      return;
    }
    catch (JSONException localJSONException)
    {
      bjbl.a("ReaderTabConfigDataHelper", "getTabConfigDataFromDB," + localJSONException.getMessage());
    }
  }
  
  private void g()
  {
    bjcd.a(bjcd.a, this.jdField_a_of_type_Bjan);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NonNull
  public ArrayList<bjam> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    f();
    g();
  }
  
  @Nullable
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  @Nullable
  public String[] a()
  {
    return this.jdField_c_of_type_ArrayOfJavaLangString;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    e();
  }
  
  @Nullable
  public String[] b()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  @Nullable
  public String[] c()
  {
    return this.jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public String d()
  {
    int i = 0;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    }
    return "&height=" + (bdaq.b(this.jdField_a_of_type_AndroidContentContext, i) + 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bizx
 * JD-Core Version:    0.7.0.1
 */