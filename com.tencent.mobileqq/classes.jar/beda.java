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

public class beda
{
  private static beda a;
  public int a;
  protected SparseArray<bedb> a;
  
  private beda()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = BaseApplication.getContext().getResources().getColor(2131166242);
  }
  
  public static beda a()
  {
    try
    {
      if (jdField_a_of_type_Beda == null) {
        jdField_a_of_type_Beda = b();
      }
      beda localbeda = jdField_a_of_type_Beda;
      return localbeda;
    }
    finally {}
  }
  
  protected static beda a(String paramString)
  {
    try
    {
      beda localbeda = new beda();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localbeda;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        bedb localbedb = new bedb();
        localbedb.jdField_a_of_type_Int = paramString.getInt("id");
        localbedb.jdField_a_of_type_JavaLangString = paramString.getString("rank");
        localbedb.b = Color.parseColor(paramString.getString("bg"));
        localbeda.jdField_a_of_type_AndroidUtilSparseArray.put(localbedb.jdField_a_of_type_Int, localbedb);
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
    bcef.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
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
      beda localbeda = a(paramString);
      bool1 = bool2;
      if (localbeda != null)
      {
        jdField_a_of_type_Beda = localbeda;
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
  
  protected static beda b()
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
        localObject3 = new beda();
        localObject1 = new bedb();
        ((bedb)localObject1).jdField_a_of_type_Int = 300;
        ((bedb)localObject1).jdField_a_of_type_JavaLangString = amtj.a(2131714747);
        ((bedb)localObject1).b = Color.parseColor("#F4BF20");
        bedb localbedb1 = new bedb();
        localbedb1.jdField_a_of_type_Int = 301;
        localbedb1.jdField_a_of_type_JavaLangString = amtj.a(2131714736);
        localbedb1.b = Color.parseColor("#6CD9A3");
        bedb localbedb2 = new bedb();
        localbedb2.jdField_a_of_type_Int = 302;
        localbedb2.jdField_a_of_type_JavaLangString = "";
        localbedb2.b = Color.parseColor("#B395EF");
        bedb localbedb3 = new bedb();
        localbedb3.jdField_a_of_type_Int = 303;
        localbedb3.jdField_a_of_type_JavaLangString = amtj.a(2131714737);
        localbedb3.b = Color.parseColor("#F4BF20");
        bedb localbedb4 = new bedb();
        localbedb4.jdField_a_of_type_Int = 304;
        localbedb4.jdField_a_of_type_JavaLangString = amtj.a(2131714744);
        localbedb4.b = Color.parseColor("#6CD9A3");
        bedb localbedb5 = new bedb();
        localbedb5.jdField_a_of_type_Int = 305;
        localbedb5.jdField_a_of_type_JavaLangString = amtj.a(2131714739);
        localbedb5.b = Color.parseColor("#FF988A");
        bedb localbedb6 = new bedb();
        localbedb6.jdField_a_of_type_Int = 306;
        localbedb6.jdField_a_of_type_JavaLangString = amtj.a(2131714746);
        localbedb6.b = Color.parseColor("#F4BF20");
        bedb localbedb7 = new bedb();
        localbedb7.jdField_a_of_type_Int = 307;
        localbedb7.jdField_a_of_type_JavaLangString = amtj.a(2131714741);
        localbedb7.b = Color.parseColor("#72CCE6");
        bedb localbedb8 = new bedb();
        localbedb8.jdField_a_of_type_Int = 308;
        localbedb8.jdField_a_of_type_JavaLangString = amtj.a(2131714745);
        localbedb8.b = Color.parseColor("#FF988A");
        bedb localbedb9 = new bedb();
        localbedb9.jdField_a_of_type_Int = 315;
        localbedb9.jdField_a_of_type_JavaLangString = "";
        localbedb9.b = Color.parseColor("#8EBDF9");
        bedb localbedb10 = new bedb();
        localbedb10.jdField_a_of_type_Int = 311;
        localbedb10.jdField_a_of_type_JavaLangString = amtj.a(2131714740);
        localbedb10.b = Color.parseColor("#F25D5D");
        bedb localbedb11 = new bedb();
        localbedb11.jdField_a_of_type_Int = 312;
        localbedb11.jdField_a_of_type_JavaLangString = amtj.a(2131714742);
        localbedb11.b = Color.parseColor("#F25D5D");
        bedb localbedb12 = new bedb();
        localbedb12.jdField_a_of_type_Int = 313;
        localbedb12.jdField_a_of_type_JavaLangString = amtj.a(2131714749);
        localbedb12.b = Color.parseColor("#FFA5BD");
        bedb localbedb13 = new bedb();
        localbedb13.jdField_a_of_type_Int = 314;
        localbedb13.jdField_a_of_type_JavaLangString = amtj.a(2131714738);
        localbedb13.b = Color.parseColor("#FFA5BD");
        bedb localbedb14 = new bedb();
        localbedb14.jdField_a_of_type_Int = 332;
        localbedb14.jdField_a_of_type_JavaLangString = amtj.a(2131714743);
        localbedb14.b = Color.parseColor("#F4C020");
        bedb localbedb15 = new bedb();
        localbedb15.jdField_a_of_type_Int = 333;
        localbedb15.jdField_a_of_type_JavaLangString = amtj.a(2131714748);
        localbedb15.b = Color.parseColor("#F4C020");
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(300, localObject1);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(301, localbedb1);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(302, localbedb2);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(303, localbedb3);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(304, localbedb4);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(305, localbedb5);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(306, localbedb6);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(307, localbedb7);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(308, localbedb8);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(311, localbedb10);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(312, localbedb11);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(313, localbedb12);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(314, localbedb13);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(315, localbedb9);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(332, localbedb14);
        ((beda)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(333, localbedb15);
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
  
  public bedb a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (paramBoolean3) {
      return (bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    return (bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 10000);
  }
  
  protected bedb a(bedb parambedb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((parambedb == null) || (parambedb.jdField_a_of_type_Int == 300) || (parambedb.jdField_a_of_type_Int == 301)) {}
    bedb localbedb;
    do
    {
      return parambedb;
      if ((paramBoolean1) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(300) != null))
      {
        if (paramBoolean3)
        {
          localbedb = new bedb();
          localbedb.jdField_a_of_type_Int = parambedb.jdField_a_of_type_Int;
          localbedb.jdField_a_of_type_JavaLangString = parambedb.jdField_a_of_type_JavaLangString;
          localbedb.b = ((bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
          return localbedb;
        }
        parambedb.b = ((bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
        return parambedb;
      }
    } while ((!paramBoolean2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(301) == null));
    if (paramBoolean3)
    {
      localbedb = new bedb();
      localbedb.jdField_a_of_type_Int = parambedb.jdField_a_of_type_Int;
      localbedb.jdField_a_of_type_JavaLangString = parambedb.jdField_a_of_type_JavaLangString;
      localbedb.b = ((bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
      return localbedb;
    }
    parambedb.b = ((bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
    return parambedb;
  }
  
  public bedb a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    bedb localbedb1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      localbedb1 = (bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((i != 302) || (localbedb1 == null)) {
        break;
      }
      paramTroopInfo = new bedb();
      paramTroopInfo.jdField_a_of_type_Int = localbedb1.jdField_a_of_type_Int;
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.b = localbedb1.b;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    bedb localbedb2;
    if (i == 315)
    {
      localbedb2 = new bedb();
      if (localbedb1 != null) {}
      for (localbedb2.b = localbedb1.b;; localbedb2.b = Color.parseColor("#8EBDF9"))
      {
        localbedb2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbedb2.jdField_a_of_type_Int = i;
        return a(localbedb2, bool2, bool1, false);
      }
    }
    return a(localbedb1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(302);
      if (paramTroopInfo != null)
      {
        localbedb1 = new bedb();
        localbedb1.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_Int;
        localbedb1.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localbedb1.b = paramTroopInfo.b;
        return a(localbedb1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (bool1) {
      return (bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    if (i == 10315)
    {
      localbedb1 = (bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(315);
      localbedb2 = new bedb();
      if (localbedb1 != null) {}
      for (localbedb2.b = localbedb1.b;; localbedb2.b = Color.parseColor("#8EBDF9"))
      {
        localbedb2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbedb2.jdField_a_of_type_Int = 315;
        return localbedb2;
      }
    }
    return (bedb)this.jdField_a_of_type_AndroidUtilSparseArray.get(i - 10000);
  }
  
  public bedb a(boolean paramBoolean1, boolean paramBoolean2)
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
 * Qualified Name:     beda
 * JD-Core Version:    0.7.0.1
 */