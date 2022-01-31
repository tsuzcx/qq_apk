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

public class azrd
{
  private static azrd a;
  public int a;
  protected SparseArray<azre> a;
  
  private azrd()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = BaseApplication.getContext().getResources().getColor(2131166128);
  }
  
  public static azrd a()
  {
    try
    {
      if (jdField_a_of_type_Azrd == null) {
        jdField_a_of_type_Azrd = b();
      }
      azrd localazrd = jdField_a_of_type_Azrd;
      return localazrd;
    }
    finally {}
  }
  
  protected static azrd a(String paramString)
  {
    try
    {
      azrd localazrd = new azrd();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localazrd;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        azre localazre = new azre();
        localazre.jdField_a_of_type_Int = paramString.getInt("id");
        localazre.jdField_a_of_type_JavaLangString = paramString.getString("rank");
        localazre.b = Color.parseColor(paramString.getString("bg"));
        localazrd.jdField_a_of_type_AndroidUtilSparseArray.put(localazre.jdField_a_of_type_Int, localazre);
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
    paramTextView.setBackgroundDrawable(bamn.a(BaseApplication.getContext().getResources(), paramInt));
    if ((paramTextView instanceof ThemeLabelTextView)) {
      ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    axqw.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
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
      azrd localazrd = a(paramString);
      bool1 = bool2;
      if (localazrd != null)
      {
        jdField_a_of_type_Azrd = localazrd;
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
  
  protected static azrd b()
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
        localObject3 = new azrd();
        localObject1 = new azre();
        ((azre)localObject1).jdField_a_of_type_Int = 300;
        ((azre)localObject1).jdField_a_of_type_JavaLangString = ajyc.a(2131715730);
        ((azre)localObject1).b = Color.parseColor("#F4BF20");
        azre localazre1 = new azre();
        localazre1.jdField_a_of_type_Int = 301;
        localazre1.jdField_a_of_type_JavaLangString = ajyc.a(2131715719);
        localazre1.b = Color.parseColor("#6CD9A3");
        azre localazre2 = new azre();
        localazre2.jdField_a_of_type_Int = 302;
        localazre2.jdField_a_of_type_JavaLangString = "";
        localazre2.b = Color.parseColor("#B395EF");
        azre localazre3 = new azre();
        localazre3.jdField_a_of_type_Int = 303;
        localazre3.jdField_a_of_type_JavaLangString = ajyc.a(2131715720);
        localazre3.b = Color.parseColor("#F4BF20");
        azre localazre4 = new azre();
        localazre4.jdField_a_of_type_Int = 304;
        localazre4.jdField_a_of_type_JavaLangString = ajyc.a(2131715727);
        localazre4.b = Color.parseColor("#6CD9A3");
        azre localazre5 = new azre();
        localazre5.jdField_a_of_type_Int = 305;
        localazre5.jdField_a_of_type_JavaLangString = ajyc.a(2131715722);
        localazre5.b = Color.parseColor("#FF988A");
        azre localazre6 = new azre();
        localazre6.jdField_a_of_type_Int = 306;
        localazre6.jdField_a_of_type_JavaLangString = ajyc.a(2131715729);
        localazre6.b = Color.parseColor("#F4BF20");
        azre localazre7 = new azre();
        localazre7.jdField_a_of_type_Int = 307;
        localazre7.jdField_a_of_type_JavaLangString = ajyc.a(2131715724);
        localazre7.b = Color.parseColor("#72CCE6");
        azre localazre8 = new azre();
        localazre8.jdField_a_of_type_Int = 308;
        localazre8.jdField_a_of_type_JavaLangString = ajyc.a(2131715728);
        localazre8.b = Color.parseColor("#FF988A");
        azre localazre9 = new azre();
        localazre9.jdField_a_of_type_Int = 315;
        localazre9.jdField_a_of_type_JavaLangString = "";
        localazre9.b = Color.parseColor("#8EBDF9");
        azre localazre10 = new azre();
        localazre10.jdField_a_of_type_Int = 311;
        localazre10.jdField_a_of_type_JavaLangString = ajyc.a(2131715723);
        localazre10.b = Color.parseColor("#F25D5D");
        azre localazre11 = new azre();
        localazre11.jdField_a_of_type_Int = 312;
        localazre11.jdField_a_of_type_JavaLangString = ajyc.a(2131715725);
        localazre11.b = Color.parseColor("#F25D5D");
        azre localazre12 = new azre();
        localazre12.jdField_a_of_type_Int = 313;
        localazre12.jdField_a_of_type_JavaLangString = ajyc.a(2131715732);
        localazre12.b = Color.parseColor("#FFA5BD");
        azre localazre13 = new azre();
        localazre13.jdField_a_of_type_Int = 314;
        localazre13.jdField_a_of_type_JavaLangString = ajyc.a(2131715721);
        localazre13.b = Color.parseColor("#FFA5BD");
        azre localazre14 = new azre();
        localazre14.jdField_a_of_type_Int = 332;
        localazre14.jdField_a_of_type_JavaLangString = ajyc.a(2131715726);
        localazre14.b = Color.parseColor("#F4C020");
        azre localazre15 = new azre();
        localazre15.jdField_a_of_type_Int = 333;
        localazre15.jdField_a_of_type_JavaLangString = ajyc.a(2131715731);
        localazre15.b = Color.parseColor("#F4C020");
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(300, localObject1);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(301, localazre1);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(302, localazre2);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(303, localazre3);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(304, localazre4);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(305, localazre5);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(306, localazre6);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(307, localazre7);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(308, localazre8);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(311, localazre10);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(312, localazre11);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(313, localazre12);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(314, localazre13);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(315, localazre9);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(332, localazre14);
        ((azrd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(333, localazre15);
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
  
  public azre a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (paramBoolean3) {
      return (azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    return (azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 10000);
  }
  
  protected azre a(azre paramazre, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramazre == null) || (paramazre.jdField_a_of_type_Int == 300) || (paramazre.jdField_a_of_type_Int == 301)) {}
    azre localazre;
    do
    {
      return paramazre;
      if ((paramBoolean1) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(300) != null))
      {
        if (paramBoolean3)
        {
          localazre = new azre();
          localazre.jdField_a_of_type_Int = paramazre.jdField_a_of_type_Int;
          localazre.jdField_a_of_type_JavaLangString = paramazre.jdField_a_of_type_JavaLangString;
          localazre.b = ((azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
          return localazre;
        }
        paramazre.b = ((azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
        return paramazre;
      }
    } while ((!paramBoolean2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(301) == null));
    if (paramBoolean3)
    {
      localazre = new azre();
      localazre.jdField_a_of_type_Int = paramazre.jdField_a_of_type_Int;
      localazre.jdField_a_of_type_JavaLangString = paramazre.jdField_a_of_type_JavaLangString;
      localazre.b = ((azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
      return localazre;
    }
    paramazre.b = ((azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
    return paramazre;
  }
  
  public azre a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    azre localazre1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      localazre1 = (azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((i != 302) || (localazre1 == null)) {
        break;
      }
      paramTroopInfo = new azre();
      paramTroopInfo.jdField_a_of_type_Int = localazre1.jdField_a_of_type_Int;
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.b = localazre1.b;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    azre localazre2;
    if (i == 315)
    {
      localazre2 = new azre();
      if (localazre1 != null) {}
      for (localazre2.b = localazre1.b;; localazre2.b = Color.parseColor("#8EBDF9"))
      {
        localazre2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localazre2.jdField_a_of_type_Int = i;
        return a(localazre2, bool2, bool1, false);
      }
    }
    return a(localazre1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(302);
      if (paramTroopInfo != null)
      {
        localazre1 = new azre();
        localazre1.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_Int;
        localazre1.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localazre1.b = paramTroopInfo.b;
        return a(localazre1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (bool1) {
      return (azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    if (i == 10315)
    {
      localazre1 = (azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(315);
      localazre2 = new azre();
      if (localazre1 != null) {}
      for (localazre2.b = localazre1.b;; localazre2.b = Color.parseColor("#8EBDF9"))
      {
        localazre2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localazre2.jdField_a_of_type_Int = 315;
        return localazre2;
      }
    }
    return (azre)this.jdField_a_of_type_AndroidUtilSparseArray.get(i - 10000);
  }
  
  public azre a(boolean paramBoolean1, boolean paramBoolean2)
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
 * Qualified Name:     azrd
 * JD-Core Version:    0.7.0.1
 */