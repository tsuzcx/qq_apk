import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeLabelTextView;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class bfkd
{
  private static bfkd a;
  public int a;
  protected SparseArray<bfke> a;
  
  private bfkd()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = BaseApplication.getContext().getResources().getColor(2131166251);
  }
  
  public static bfkd a()
  {
    try
    {
      if (jdField_a_of_type_Bfkd == null) {
        jdField_a_of_type_Bfkd = b();
      }
      bfkd localbfkd = jdField_a_of_type_Bfkd;
      return localbfkd;
    }
    finally {}
  }
  
  protected static bfkd a(String paramString)
  {
    try
    {
      bfkd localbfkd = new bfkd();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localbfkd;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        bfke localbfke = new bfke();
        localbfke.jdField_a_of_type_Int = paramString.getInt("id");
        localbfke.jdField_a_of_type_JavaLangString = paramString.getString("rank");
        localbfke.b = Color.parseColor(paramString.getString("bg"));
        localbfkd.jdField_a_of_type_AndroidUtilSparseArray.put(localbfke.jdField_a_of_type_Int, localbfke);
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
    paramTextView.setBackgroundDrawable(TroopUtils.getTroopLevelBgDrawable(BaseApplication.getContext().getResources(), paramInt));
    if ((paramTextView instanceof ThemeLabelTextView)) {
      ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bdla.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
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
      bfkd localbfkd = a(paramString);
      bool1 = bool2;
      if (localbfkd != null)
      {
        jdField_a_of_type_Bfkd = localbfkd;
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
  
  protected static bfkd b()
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
        localObject3 = new bfkd();
        localObject1 = new bfke();
        ((bfke)localObject1).jdField_a_of_type_Int = 300;
        ((bfke)localObject1).jdField_a_of_type_JavaLangString = anvx.a(2131715095);
        ((bfke)localObject1).b = Color.parseColor("#F4BF20");
        bfke localbfke1 = new bfke();
        localbfke1.jdField_a_of_type_Int = 301;
        localbfke1.jdField_a_of_type_JavaLangString = anvx.a(2131715084);
        localbfke1.b = Color.parseColor("#6CD9A3");
        bfke localbfke2 = new bfke();
        localbfke2.jdField_a_of_type_Int = 302;
        localbfke2.jdField_a_of_type_JavaLangString = "";
        localbfke2.b = Color.parseColor("#B395EF");
        bfke localbfke3 = new bfke();
        localbfke3.jdField_a_of_type_Int = 303;
        localbfke3.jdField_a_of_type_JavaLangString = anvx.a(2131715085);
        localbfke3.b = Color.parseColor("#F4BF20");
        bfke localbfke4 = new bfke();
        localbfke4.jdField_a_of_type_Int = 304;
        localbfke4.jdField_a_of_type_JavaLangString = anvx.a(2131715092);
        localbfke4.b = Color.parseColor("#6CD9A3");
        bfke localbfke5 = new bfke();
        localbfke5.jdField_a_of_type_Int = 305;
        localbfke5.jdField_a_of_type_JavaLangString = anvx.a(2131715087);
        localbfke5.b = Color.parseColor("#FF988A");
        bfke localbfke6 = new bfke();
        localbfke6.jdField_a_of_type_Int = 306;
        localbfke6.jdField_a_of_type_JavaLangString = anvx.a(2131715094);
        localbfke6.b = Color.parseColor("#F4BF20");
        bfke localbfke7 = new bfke();
        localbfke7.jdField_a_of_type_Int = 307;
        localbfke7.jdField_a_of_type_JavaLangString = anvx.a(2131715089);
        localbfke7.b = Color.parseColor("#72CCE6");
        bfke localbfke8 = new bfke();
        localbfke8.jdField_a_of_type_Int = 308;
        localbfke8.jdField_a_of_type_JavaLangString = anvx.a(2131715093);
        localbfke8.b = Color.parseColor("#FF988A");
        bfke localbfke9 = new bfke();
        localbfke9.jdField_a_of_type_Int = 315;
        localbfke9.jdField_a_of_type_JavaLangString = "";
        localbfke9.b = Color.parseColor("#8EBDF9");
        bfke localbfke10 = new bfke();
        localbfke10.jdField_a_of_type_Int = 311;
        localbfke10.jdField_a_of_type_JavaLangString = anvx.a(2131715088);
        localbfke10.b = Color.parseColor("#F25D5D");
        bfke localbfke11 = new bfke();
        localbfke11.jdField_a_of_type_Int = 312;
        localbfke11.jdField_a_of_type_JavaLangString = anvx.a(2131715090);
        localbfke11.b = Color.parseColor("#F25D5D");
        bfke localbfke12 = new bfke();
        localbfke12.jdField_a_of_type_Int = 313;
        localbfke12.jdField_a_of_type_JavaLangString = anvx.a(2131715097);
        localbfke12.b = Color.parseColor("#FFA5BD");
        bfke localbfke13 = new bfke();
        localbfke13.jdField_a_of_type_Int = 314;
        localbfke13.jdField_a_of_type_JavaLangString = anvx.a(2131715086);
        localbfke13.b = Color.parseColor("#FFA5BD");
        bfke localbfke14 = new bfke();
        localbfke14.jdField_a_of_type_Int = 332;
        localbfke14.jdField_a_of_type_JavaLangString = anvx.a(2131715091);
        localbfke14.b = Color.parseColor("#F4C020");
        bfke localbfke15 = new bfke();
        localbfke15.jdField_a_of_type_Int = 333;
        localbfke15.jdField_a_of_type_JavaLangString = anvx.a(2131715096);
        localbfke15.b = Color.parseColor("#F4C020");
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(300, localObject1);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(301, localbfke1);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(302, localbfke2);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(303, localbfke3);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(304, localbfke4);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(305, localbfke5);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(306, localbfke6);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(307, localbfke7);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(308, localbfke8);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(311, localbfke10);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(312, localbfke11);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(313, localbfke12);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(314, localbfke13);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(315, localbfke9);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(332, localbfke14);
        ((bfkd)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(333, localbfke15);
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
  
  public bfke a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (paramBoolean3) {
      return (bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    return (bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 10000);
  }
  
  protected bfke a(bfke parambfke, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((parambfke == null) || (parambfke.jdField_a_of_type_Int == 300) || (parambfke.jdField_a_of_type_Int == 301)) {}
    bfke localbfke;
    do
    {
      return parambfke;
      if ((paramBoolean1) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(300) != null))
      {
        if (paramBoolean3)
        {
          localbfke = new bfke();
          localbfke.jdField_a_of_type_Int = parambfke.jdField_a_of_type_Int;
          localbfke.jdField_a_of_type_JavaLangString = parambfke.jdField_a_of_type_JavaLangString;
          localbfke.b = ((bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
          return localbfke;
        }
        parambfke.b = ((bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
        return parambfke;
      }
    } while ((!paramBoolean2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(301) == null));
    if (paramBoolean3)
    {
      localbfke = new bfke();
      localbfke.jdField_a_of_type_Int = parambfke.jdField_a_of_type_Int;
      localbfke.jdField_a_of_type_JavaLangString = parambfke.jdField_a_of_type_JavaLangString;
      localbfke.b = ((bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
      return localbfke;
    }
    parambfke.b = ((bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
    return parambfke;
  }
  
  public bfke a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    bfke localbfke1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      localbfke1 = (bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((i != 302) || (localbfke1 == null)) {
        break;
      }
      paramTroopInfo = new bfke();
      paramTroopInfo.jdField_a_of_type_Int = localbfke1.jdField_a_of_type_Int;
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.b = localbfke1.b;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    bfke localbfke2;
    if (i == 315)
    {
      localbfke2 = new bfke();
      if (localbfke1 != null) {}
      for (localbfke2.b = localbfke1.b;; localbfke2.b = Color.parseColor("#8EBDF9"))
      {
        localbfke2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbfke2.jdField_a_of_type_Int = i;
        return a(localbfke2, bool2, bool1, false);
      }
    }
    return a(localbfke1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(302);
      if (paramTroopInfo != null)
      {
        localbfke1 = new bfke();
        localbfke1.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_Int;
        localbfke1.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localbfke1.b = paramTroopInfo.b;
        return a(localbfke1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (bool1) {
      return (bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    if (i == 10315)
    {
      localbfke1 = (bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(315);
      localbfke2 = new bfke();
      if (localbfke1 != null) {}
      for (localbfke2.b = localbfke1.b;; localbfke2.b = Color.parseColor("#8EBDF9"))
      {
        localbfke2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbfke2.jdField_a_of_type_Int = 315;
        return localbfke2;
      }
    }
    return (bfke)this.jdField_a_of_type_AndroidUtilSparseArray.get(i - 10000);
  }
  
  public bfke a(boolean paramBoolean1, boolean paramBoolean2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkd
 * JD-Core Version:    0.7.0.1
 */