import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeLabelTextView;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class beui
{
  private static beui a;
  public int a;
  protected SparseArray<beuj> a;
  
  private beui()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = BaseApplication.getContext().getResources().getColor(2131166222);
  }
  
  public static beui a()
  {
    try
    {
      if (jdField_a_of_type_Beui == null) {
        jdField_a_of_type_Beui = b();
      }
      beui localbeui = jdField_a_of_type_Beui;
      return localbeui;
    }
    finally {}
  }
  
  protected static beui a(String paramString)
  {
    try
    {
      beui localbeui = new beui();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localbeui;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        beuj localbeuj = new beuj();
        localbeuj.jdField_a_of_type_Int = paramString.getInt("id");
        localbeuj.jdField_a_of_type_JavaLangString = paramString.getString("rank");
        localbeuj.b = Color.parseColor(paramString.getString("bg"));
        localbeui.jdField_a_of_type_AndroidUtilSparseArray.put(localbeuj.jdField_a_of_type_Int, localbeuj);
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "parseConfig exp:", paramString);
      }
      paramString = null;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setBackgroundDrawable(bfup.a(BaseApplication.getContext().getResources(), paramInt));
    if ((paramTextView instanceof ThemeLabelTextView)) {
      ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bcst.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, "report,  opType=" + paramString1 + ", opName=" + paramString2);
    }
  }
  
  public static boolean a(String paramString)
  {
    bool2 = false;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "refreshConfig:" + paramString);
      }
      beui localbeui = a(paramString);
      bool1 = bool2;
      if (localbeui != null)
      {
        jdField_a_of_type_Beui = localbeui;
        BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 0).edit().putString("rank_map_key", paramString).commit();
        bool1 = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("TroopRankConfig", 2, "TroopRankTitleConfig.refreshConfig exp, jsonStr=" + paramString, localException);
          bool1 = bool2;
        }
      }
    }
    finally {}
    return bool1;
  }
  
  protected static beui b()
  {
    try
    {
      Object localObject1 = a(BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 0).getString("rank_map_key", ""));
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopRankConfig", 2, "getConfigFromLocal exp, localConfig==null");
        }
        localObject3 = new beui();
        localObject1 = new beuj();
        ((beuj)localObject1).jdField_a_of_type_Int = 300;
        ((beuj)localObject1).jdField_a_of_type_JavaLangString = anni.a(2131714406);
        ((beuj)localObject1).b = Color.parseColor("#F4BF20");
        beuj localbeuj1 = new beuj();
        localbeuj1.jdField_a_of_type_Int = 301;
        localbeuj1.jdField_a_of_type_JavaLangString = anni.a(2131714395);
        localbeuj1.b = Color.parseColor("#6CD9A3");
        beuj localbeuj2 = new beuj();
        localbeuj2.jdField_a_of_type_Int = 302;
        localbeuj2.jdField_a_of_type_JavaLangString = "";
        localbeuj2.b = Color.parseColor("#B395EF");
        beuj localbeuj3 = new beuj();
        localbeuj3.jdField_a_of_type_Int = 303;
        localbeuj3.jdField_a_of_type_JavaLangString = anni.a(2131714396);
        localbeuj3.b = Color.parseColor("#F4BF20");
        beuj localbeuj4 = new beuj();
        localbeuj4.jdField_a_of_type_Int = 304;
        localbeuj4.jdField_a_of_type_JavaLangString = anni.a(2131714403);
        localbeuj4.b = Color.parseColor("#6CD9A3");
        beuj localbeuj5 = new beuj();
        localbeuj5.jdField_a_of_type_Int = 305;
        localbeuj5.jdField_a_of_type_JavaLangString = anni.a(2131714398);
        localbeuj5.b = Color.parseColor("#FF988A");
        beuj localbeuj6 = new beuj();
        localbeuj6.jdField_a_of_type_Int = 306;
        localbeuj6.jdField_a_of_type_JavaLangString = anni.a(2131714405);
        localbeuj6.b = Color.parseColor("#F4BF20");
        beuj localbeuj7 = new beuj();
        localbeuj7.jdField_a_of_type_Int = 307;
        localbeuj7.jdField_a_of_type_JavaLangString = anni.a(2131714400);
        localbeuj7.b = Color.parseColor("#72CCE6");
        beuj localbeuj8 = new beuj();
        localbeuj8.jdField_a_of_type_Int = 308;
        localbeuj8.jdField_a_of_type_JavaLangString = anni.a(2131714404);
        localbeuj8.b = Color.parseColor("#FF988A");
        beuj localbeuj9 = new beuj();
        localbeuj9.jdField_a_of_type_Int = 315;
        localbeuj9.jdField_a_of_type_JavaLangString = "";
        localbeuj9.b = Color.parseColor("#8EBDF9");
        beuj localbeuj10 = new beuj();
        localbeuj10.jdField_a_of_type_Int = 311;
        localbeuj10.jdField_a_of_type_JavaLangString = anni.a(2131714399);
        localbeuj10.b = Color.parseColor("#F25D5D");
        beuj localbeuj11 = new beuj();
        localbeuj11.jdField_a_of_type_Int = 312;
        localbeuj11.jdField_a_of_type_JavaLangString = anni.a(2131714401);
        localbeuj11.b = Color.parseColor("#F25D5D");
        beuj localbeuj12 = new beuj();
        localbeuj12.jdField_a_of_type_Int = 313;
        localbeuj12.jdField_a_of_type_JavaLangString = anni.a(2131714408);
        localbeuj12.b = Color.parseColor("#FFA5BD");
        beuj localbeuj13 = new beuj();
        localbeuj13.jdField_a_of_type_Int = 314;
        localbeuj13.jdField_a_of_type_JavaLangString = anni.a(2131714397);
        localbeuj13.b = Color.parseColor("#FFA5BD");
        beuj localbeuj14 = new beuj();
        localbeuj14.jdField_a_of_type_Int = 332;
        localbeuj14.jdField_a_of_type_JavaLangString = anni.a(2131714402);
        localbeuj14.b = Color.parseColor("#F4C020");
        beuj localbeuj15 = new beuj();
        localbeuj15.jdField_a_of_type_Int = 333;
        localbeuj15.jdField_a_of_type_JavaLangString = anni.a(2131714407);
        localbeuj15.b = Color.parseColor("#F4C020");
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(300, localObject1);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(301, localbeuj1);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(302, localbeuj2);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(303, localbeuj3);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(304, localbeuj4);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(305, localbeuj5);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(306, localbeuj6);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(307, localbeuj7);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(308, localbeuj8);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(311, localbeuj10);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(312, localbeuj11);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(313, localbeuj12);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(314, localbeuj13);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(315, localbeuj9);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(332, localbeuj14);
        ((beui)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(333, localbeuj15);
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopRankConfig", 2, "getConfigFromLocal exp:", localException);
        }
        Object localObject2 = null;
      }
    }
  }
  
  public beuj a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (paramBoolean3) {
      return (beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    return (beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 10000);
  }
  
  protected beuj a(beuj parambeuj, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((parambeuj == null) || (parambeuj.jdField_a_of_type_Int == 300) || (parambeuj.jdField_a_of_type_Int == 301)) {}
    beuj localbeuj;
    do
    {
      return parambeuj;
      if ((paramBoolean1) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(300) != null))
      {
        if (paramBoolean3)
        {
          localbeuj = new beuj();
          localbeuj.jdField_a_of_type_Int = parambeuj.jdField_a_of_type_Int;
          localbeuj.jdField_a_of_type_JavaLangString = parambeuj.jdField_a_of_type_JavaLangString;
          localbeuj.b = ((beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
          return localbeuj;
        }
        parambeuj.b = ((beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
        return parambeuj;
      }
    } while ((!paramBoolean2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(301) == null));
    if (paramBoolean3)
    {
      localbeuj = new beuj();
      localbeuj.jdField_a_of_type_Int = parambeuj.jdField_a_of_type_Int;
      localbeuj.jdField_a_of_type_JavaLangString = parambeuj.jdField_a_of_type_JavaLangString;
      localbeuj.b = ((beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
      return localbeuj;
    }
    parambeuj.b = ((beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
    return parambeuj;
  }
  
  public beuj a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    beuj localbeuj1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      localbeuj1 = (beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((i != 302) || (localbeuj1 == null)) {
        break;
      }
      paramTroopInfo = new beuj();
      paramTroopInfo.jdField_a_of_type_Int = localbeuj1.jdField_a_of_type_Int;
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.b = localbeuj1.b;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    beuj localbeuj2;
    if (i == 315)
    {
      localbeuj2 = new beuj();
      if (localbeuj1 != null) {}
      for (localbeuj2.b = localbeuj1.b;; localbeuj2.b = Color.parseColor("#8EBDF9"))
      {
        localbeuj2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbeuj2.jdField_a_of_type_Int = i;
        return a(localbeuj2, bool2, bool1, false);
      }
    }
    return a(localbeuj1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(302);
      if (paramTroopInfo != null)
      {
        localbeuj1 = new beuj();
        localbeuj1.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_Int;
        localbeuj1.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localbeuj1.b = paramTroopInfo.b;
        return a(localbeuj1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (bool1) {
      return (beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    if (i == 10315)
    {
      localbeuj1 = (beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(315);
      localbeuj2 = new beuj();
      if (localbeuj1 != null) {}
      for (localbeuj2.b = localbeuj1.b;; localbeuj2.b = Color.parseColor("#8EBDF9"))
      {
        localbeuj2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbeuj2.jdField_a_of_type_Int = 315;
        return localbeuj2;
      }
    }
    return (beuj)this.jdField_a_of_type_AndroidUtilSparseArray.get(i - 10000);
  }
  
  public beuj a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return a(300, false, true, false);
    }
    if (paramBoolean2) {
      return a(301, false, false, true);
    }
    return null;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, "setHasNewRankRedDot, troopUin=" + paramString1 + ", memberUin=" + paramString2 + ", hasRedDot=" + paramBoolean);
    }
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("troop_rank_cfg", 4).edit().putBoolean("new_rank_flag" + paramString1 + "_" + paramString2, paramBoolean).commit();
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopRankConfig", 2, "setHasNewRankRedDot exp:", paramString1);
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("troop_rank_cfg", 4).getBoolean("new_rank_flag" + paramString1 + "_" + paramString2, false);
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "hasNewRankRedDot: troopUin=" + paramString1 + ", memberUin=" + paramString2 + ", ret=" + bool);
      }
      return bool;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "hasNewRankRedDot exp:", paramString1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beui
 * JD-Core Version:    0.7.0.1
 */