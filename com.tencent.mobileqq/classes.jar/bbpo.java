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

public class bbpo
{
  private static bbpo a;
  public int a;
  protected SparseArray<bbpp> a;
  
  private bbpo()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = BaseApplication.getContext().getResources().getColor(2131166167);
  }
  
  public static bbpo a()
  {
    try
    {
      if (jdField_a_of_type_Bbpo == null) {
        jdField_a_of_type_Bbpo = b();
      }
      bbpo localbbpo = jdField_a_of_type_Bbpo;
      return localbbpo;
    }
    finally {}
  }
  
  protected static bbpo a(String paramString)
  {
    try
    {
      bbpo localbbpo = new bbpo();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localbbpo;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        bbpp localbbpp = new bbpp();
        localbbpp.jdField_a_of_type_Int = paramString.getInt("id");
        localbbpp.jdField_a_of_type_JavaLangString = paramString.getString("rank");
        localbbpp.b = Color.parseColor(paramString.getString("bg"));
        localbbpo.jdField_a_of_type_AndroidUtilSparseArray.put(localbbpp.jdField_a_of_type_Int, localbbpp);
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
    paramTextView.setBackgroundDrawable(bclo.a(BaseApplication.getContext().getResources(), paramInt));
    if ((paramTextView instanceof ThemeLabelTextView)) {
      ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    azmj.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
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
      bbpo localbbpo = a(paramString);
      bool1 = bool2;
      if (localbbpo != null)
      {
        jdField_a_of_type_Bbpo = localbbpo;
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
  
  protected static bbpo b()
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
        localObject3 = new bbpo();
        localObject1 = new bbpp();
        ((bbpp)localObject1).jdField_a_of_type_Int = 300;
        ((bbpp)localObject1).jdField_a_of_type_JavaLangString = alpo.a(2131716113);
        ((bbpp)localObject1).b = Color.parseColor("#F4BF20");
        bbpp localbbpp1 = new bbpp();
        localbbpp1.jdField_a_of_type_Int = 301;
        localbbpp1.jdField_a_of_type_JavaLangString = alpo.a(2131716102);
        localbbpp1.b = Color.parseColor("#6CD9A3");
        bbpp localbbpp2 = new bbpp();
        localbbpp2.jdField_a_of_type_Int = 302;
        localbbpp2.jdField_a_of_type_JavaLangString = "";
        localbbpp2.b = Color.parseColor("#B395EF");
        bbpp localbbpp3 = new bbpp();
        localbbpp3.jdField_a_of_type_Int = 303;
        localbbpp3.jdField_a_of_type_JavaLangString = alpo.a(2131716103);
        localbbpp3.b = Color.parseColor("#F4BF20");
        bbpp localbbpp4 = new bbpp();
        localbbpp4.jdField_a_of_type_Int = 304;
        localbbpp4.jdField_a_of_type_JavaLangString = alpo.a(2131716110);
        localbbpp4.b = Color.parseColor("#6CD9A3");
        bbpp localbbpp5 = new bbpp();
        localbbpp5.jdField_a_of_type_Int = 305;
        localbbpp5.jdField_a_of_type_JavaLangString = alpo.a(2131716105);
        localbbpp5.b = Color.parseColor("#FF988A");
        bbpp localbbpp6 = new bbpp();
        localbbpp6.jdField_a_of_type_Int = 306;
        localbbpp6.jdField_a_of_type_JavaLangString = alpo.a(2131716112);
        localbbpp6.b = Color.parseColor("#F4BF20");
        bbpp localbbpp7 = new bbpp();
        localbbpp7.jdField_a_of_type_Int = 307;
        localbbpp7.jdField_a_of_type_JavaLangString = alpo.a(2131716107);
        localbbpp7.b = Color.parseColor("#72CCE6");
        bbpp localbbpp8 = new bbpp();
        localbbpp8.jdField_a_of_type_Int = 308;
        localbbpp8.jdField_a_of_type_JavaLangString = alpo.a(2131716111);
        localbbpp8.b = Color.parseColor("#FF988A");
        bbpp localbbpp9 = new bbpp();
        localbbpp9.jdField_a_of_type_Int = 315;
        localbbpp9.jdField_a_of_type_JavaLangString = "";
        localbbpp9.b = Color.parseColor("#8EBDF9");
        bbpp localbbpp10 = new bbpp();
        localbbpp10.jdField_a_of_type_Int = 311;
        localbbpp10.jdField_a_of_type_JavaLangString = alpo.a(2131716106);
        localbbpp10.b = Color.parseColor("#F25D5D");
        bbpp localbbpp11 = new bbpp();
        localbbpp11.jdField_a_of_type_Int = 312;
        localbbpp11.jdField_a_of_type_JavaLangString = alpo.a(2131716108);
        localbbpp11.b = Color.parseColor("#F25D5D");
        bbpp localbbpp12 = new bbpp();
        localbbpp12.jdField_a_of_type_Int = 313;
        localbbpp12.jdField_a_of_type_JavaLangString = alpo.a(2131716115);
        localbbpp12.b = Color.parseColor("#FFA5BD");
        bbpp localbbpp13 = new bbpp();
        localbbpp13.jdField_a_of_type_Int = 314;
        localbbpp13.jdField_a_of_type_JavaLangString = alpo.a(2131716104);
        localbbpp13.b = Color.parseColor("#FFA5BD");
        bbpp localbbpp14 = new bbpp();
        localbbpp14.jdField_a_of_type_Int = 332;
        localbbpp14.jdField_a_of_type_JavaLangString = alpo.a(2131716109);
        localbbpp14.b = Color.parseColor("#F4C020");
        bbpp localbbpp15 = new bbpp();
        localbbpp15.jdField_a_of_type_Int = 333;
        localbbpp15.jdField_a_of_type_JavaLangString = alpo.a(2131716114);
        localbbpp15.b = Color.parseColor("#F4C020");
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(300, localObject1);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(301, localbbpp1);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(302, localbbpp2);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(303, localbbpp3);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(304, localbbpp4);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(305, localbbpp5);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(306, localbbpp6);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(307, localbbpp7);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(308, localbbpp8);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(311, localbbpp10);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(312, localbbpp11);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(313, localbbpp12);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(314, localbbpp13);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(315, localbbpp9);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(332, localbbpp14);
        ((bbpo)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(333, localbbpp15);
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
  
  public bbpp a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (paramBoolean3) {
      return (bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    return (bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 10000);
  }
  
  protected bbpp a(bbpp parambbpp, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((parambbpp == null) || (parambbpp.jdField_a_of_type_Int == 300) || (parambbpp.jdField_a_of_type_Int == 301)) {}
    bbpp localbbpp;
    do
    {
      return parambbpp;
      if ((paramBoolean1) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(300) != null))
      {
        if (paramBoolean3)
        {
          localbbpp = new bbpp();
          localbbpp.jdField_a_of_type_Int = parambbpp.jdField_a_of_type_Int;
          localbbpp.jdField_a_of_type_JavaLangString = parambbpp.jdField_a_of_type_JavaLangString;
          localbbpp.b = ((bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
          return localbbpp;
        }
        parambbpp.b = ((bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
        return parambbpp;
      }
    } while ((!paramBoolean2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(301) == null));
    if (paramBoolean3)
    {
      localbbpp = new bbpp();
      localbbpp.jdField_a_of_type_Int = parambbpp.jdField_a_of_type_Int;
      localbbpp.jdField_a_of_type_JavaLangString = parambbpp.jdField_a_of_type_JavaLangString;
      localbbpp.b = ((bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
      return localbbpp;
    }
    parambbpp.b = ((bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
    return parambbpp;
  }
  
  public bbpp a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    bbpp localbbpp1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      localbbpp1 = (bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((i != 302) || (localbbpp1 == null)) {
        break;
      }
      paramTroopInfo = new bbpp();
      paramTroopInfo.jdField_a_of_type_Int = localbbpp1.jdField_a_of_type_Int;
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.b = localbbpp1.b;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    bbpp localbbpp2;
    if (i == 315)
    {
      localbbpp2 = new bbpp();
      if (localbbpp1 != null) {}
      for (localbbpp2.b = localbbpp1.b;; localbbpp2.b = Color.parseColor("#8EBDF9"))
      {
        localbbpp2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbbpp2.jdField_a_of_type_Int = i;
        return a(localbbpp2, bool2, bool1, false);
      }
    }
    return a(localbbpp1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(302);
      if (paramTroopInfo != null)
      {
        localbbpp1 = new bbpp();
        localbbpp1.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_Int;
        localbbpp1.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localbbpp1.b = paramTroopInfo.b;
        return a(localbbpp1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (bool1) {
      return (bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    if (i == 10315)
    {
      localbbpp1 = (bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(315);
      localbbpp2 = new bbpp();
      if (localbbpp1 != null) {}
      for (localbbpp2.b = localbbpp1.b;; localbbpp2.b = Color.parseColor("#8EBDF9"))
      {
        localbbpp2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbbpp2.jdField_a_of_type_Int = 315;
        return localbbpp2;
      }
    }
    return (bbpp)this.jdField_a_of_type_AndroidUtilSparseArray.get(i - 10000);
  }
  
  public bbpp a(boolean paramBoolean1, boolean paramBoolean2)
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
 * Qualified Name:     bbpo
 * JD-Core Version:    0.7.0.1
 */