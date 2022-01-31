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
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class azrf
{
  private static azrf a;
  public int a;
  protected SparseArray<azrg> a;
  
  private azrf()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = BaseApplication.getContext().getResources().getColor(2131166128);
  }
  
  public static azrf a()
  {
    try
    {
      if (jdField_a_of_type_Azrf == null) {
        jdField_a_of_type_Azrf = b();
      }
      azrf localazrf = jdField_a_of_type_Azrf;
      return localazrf;
    }
    finally {}
  }
  
  protected static azrf a(String paramString)
  {
    try
    {
      azrf localazrf = new azrf();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localazrf;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        azrg localazrg = new azrg();
        localazrg.jdField_a_of_type_Int = paramString.getInt("id");
        localazrg.jdField_a_of_type_JavaLangString = paramString.getString("rank");
        localazrg.b = Color.parseColor(paramString.getString("bg"));
        localazrf.jdField_a_of_type_AndroidUtilSparseArray.put(localazrg.jdField_a_of_type_Int, localazrg);
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
    paramTextView.setBackgroundDrawable(banb.a(BaseApplication.getContext().getResources(), paramInt));
    if ((paramTextView instanceof ThemeLabelTextView)) {
      ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    axqy.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
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
      azrf localazrf = a(paramString);
      bool1 = bool2;
      if (localazrf != null)
      {
        jdField_a_of_type_Azrf = localazrf;
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
  
  protected static azrf b()
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
        localObject3 = new azrf();
        localObject1 = new azrg();
        ((azrg)localObject1).jdField_a_of_type_Int = 300;
        ((azrg)localObject1).jdField_a_of_type_JavaLangString = ajya.a(2131715741);
        ((azrg)localObject1).b = Color.parseColor("#F4BF20");
        azrg localazrg1 = new azrg();
        localazrg1.jdField_a_of_type_Int = 301;
        localazrg1.jdField_a_of_type_JavaLangString = ajya.a(2131715730);
        localazrg1.b = Color.parseColor("#6CD9A3");
        azrg localazrg2 = new azrg();
        localazrg2.jdField_a_of_type_Int = 302;
        localazrg2.jdField_a_of_type_JavaLangString = "";
        localazrg2.b = Color.parseColor("#B395EF");
        azrg localazrg3 = new azrg();
        localazrg3.jdField_a_of_type_Int = 303;
        localazrg3.jdField_a_of_type_JavaLangString = ajya.a(2131715731);
        localazrg3.b = Color.parseColor("#F4BF20");
        azrg localazrg4 = new azrg();
        localazrg4.jdField_a_of_type_Int = 304;
        localazrg4.jdField_a_of_type_JavaLangString = ajya.a(2131715738);
        localazrg4.b = Color.parseColor("#6CD9A3");
        azrg localazrg5 = new azrg();
        localazrg5.jdField_a_of_type_Int = 305;
        localazrg5.jdField_a_of_type_JavaLangString = ajya.a(2131715733);
        localazrg5.b = Color.parseColor("#FF988A");
        azrg localazrg6 = new azrg();
        localazrg6.jdField_a_of_type_Int = 306;
        localazrg6.jdField_a_of_type_JavaLangString = ajya.a(2131715740);
        localazrg6.b = Color.parseColor("#F4BF20");
        azrg localazrg7 = new azrg();
        localazrg7.jdField_a_of_type_Int = 307;
        localazrg7.jdField_a_of_type_JavaLangString = ajya.a(2131715735);
        localazrg7.b = Color.parseColor("#72CCE6");
        azrg localazrg8 = new azrg();
        localazrg8.jdField_a_of_type_Int = 308;
        localazrg8.jdField_a_of_type_JavaLangString = ajya.a(2131715739);
        localazrg8.b = Color.parseColor("#FF988A");
        azrg localazrg9 = new azrg();
        localazrg9.jdField_a_of_type_Int = 315;
        localazrg9.jdField_a_of_type_JavaLangString = "";
        localazrg9.b = Color.parseColor("#8EBDF9");
        azrg localazrg10 = new azrg();
        localazrg10.jdField_a_of_type_Int = 311;
        localazrg10.jdField_a_of_type_JavaLangString = ajya.a(2131715734);
        localazrg10.b = Color.parseColor("#F25D5D");
        azrg localazrg11 = new azrg();
        localazrg11.jdField_a_of_type_Int = 312;
        localazrg11.jdField_a_of_type_JavaLangString = ajya.a(2131715736);
        localazrg11.b = Color.parseColor("#F25D5D");
        azrg localazrg12 = new azrg();
        localazrg12.jdField_a_of_type_Int = 313;
        localazrg12.jdField_a_of_type_JavaLangString = ajya.a(2131715743);
        localazrg12.b = Color.parseColor("#FFA5BD");
        azrg localazrg13 = new azrg();
        localazrg13.jdField_a_of_type_Int = 314;
        localazrg13.jdField_a_of_type_JavaLangString = ajya.a(2131715732);
        localazrg13.b = Color.parseColor("#FFA5BD");
        azrg localazrg14 = new azrg();
        localazrg14.jdField_a_of_type_Int = 332;
        localazrg14.jdField_a_of_type_JavaLangString = ajya.a(2131715737);
        localazrg14.b = Color.parseColor("#F4C020");
        azrg localazrg15 = new azrg();
        localazrg15.jdField_a_of_type_Int = 333;
        localazrg15.jdField_a_of_type_JavaLangString = ajya.a(2131715742);
        localazrg15.b = Color.parseColor("#F4C020");
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(300, localObject1);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(301, localazrg1);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(302, localazrg2);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(303, localazrg3);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(304, localazrg4);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(305, localazrg5);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(306, localazrg6);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(307, localazrg7);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(308, localazrg8);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(311, localazrg10);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(312, localazrg11);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(313, localazrg12);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(314, localazrg13);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(315, localazrg9);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(332, localazrg14);
        ((azrf)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(333, localazrg15);
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
  
  public azrg a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (paramBoolean3) {
      return (azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    return (azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 10000);
  }
  
  protected azrg a(azrg paramazrg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramazrg == null) || (paramazrg.jdField_a_of_type_Int == 300) || (paramazrg.jdField_a_of_type_Int == 301)) {}
    azrg localazrg;
    do
    {
      return paramazrg;
      if ((paramBoolean1) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(300) != null))
      {
        if (paramBoolean3)
        {
          localazrg = new azrg();
          localazrg.jdField_a_of_type_Int = paramazrg.jdField_a_of_type_Int;
          localazrg.jdField_a_of_type_JavaLangString = paramazrg.jdField_a_of_type_JavaLangString;
          localazrg.b = ((azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
          return localazrg;
        }
        paramazrg.b = ((azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
        return paramazrg;
      }
    } while ((!paramBoolean2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(301) == null));
    if (paramBoolean3)
    {
      localazrg = new azrg();
      localazrg.jdField_a_of_type_Int = paramazrg.jdField_a_of_type_Int;
      localazrg.jdField_a_of_type_JavaLangString = paramazrg.jdField_a_of_type_JavaLangString;
      localazrg.b = ((azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
      return localazrg;
    }
    paramazrg.b = ((azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
    return paramazrg;
  }
  
  public azrg a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    azrg localazrg1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      localazrg1 = (azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((i != 302) || (localazrg1 == null)) {
        break;
      }
      paramTroopInfo = new azrg();
      paramTroopInfo.jdField_a_of_type_Int = localazrg1.jdField_a_of_type_Int;
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.b = localazrg1.b;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    azrg localazrg2;
    if (i == 315)
    {
      localazrg2 = new azrg();
      if (localazrg1 != null) {}
      for (localazrg2.b = localazrg1.b;; localazrg2.b = Color.parseColor("#8EBDF9"))
      {
        localazrg2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localazrg2.jdField_a_of_type_Int = i;
        return a(localazrg2, bool2, bool1, false);
      }
    }
    return a(localazrg1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(302);
      if (paramTroopInfo != null)
      {
        localazrg1 = new azrg();
        localazrg1.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_Int;
        localazrg1.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localazrg1.b = paramTroopInfo.b;
        return a(localazrg1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (bool1) {
      return (azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    if (i == 10315)
    {
      localazrg1 = (azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(315);
      localazrg2 = new azrg();
      if (localazrg1 != null) {}
      for (localazrg2.b = localazrg1.b;; localazrg2.b = Color.parseColor("#8EBDF9"))
      {
        localazrg2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localazrg2.jdField_a_of_type_Int = 315;
        return localazrg2;
      }
    }
    return (azrg)this.jdField_a_of_type_AndroidUtilSparseArray.get(i - 10000);
  }
  
  public azrg a(boolean paramBoolean1, boolean paramBoolean2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azrf
 * JD-Core Version:    0.7.0.1
 */