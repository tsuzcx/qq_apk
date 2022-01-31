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

public class bbtx
{
  private static bbtx a;
  public int a;
  protected SparseArray<bbty> a;
  
  private bbtx()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = BaseApplication.getContext().getResources().getColor(2131166167);
  }
  
  public static bbtx a()
  {
    try
    {
      if (jdField_a_of_type_Bbtx == null) {
        jdField_a_of_type_Bbtx = b();
      }
      bbtx localbbtx = jdField_a_of_type_Bbtx;
      return localbbtx;
    }
    finally {}
  }
  
  protected static bbtx a(String paramString)
  {
    try
    {
      bbtx localbbtx = new bbtx();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localbbtx;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        bbty localbbty = new bbty();
        localbbty.jdField_a_of_type_Int = paramString.getInt("id");
        localbbty.jdField_a_of_type_JavaLangString = paramString.getString("rank");
        localbbty.b = Color.parseColor(paramString.getString("bg"));
        localbbtx.jdField_a_of_type_AndroidUtilSparseArray.put(localbbty.jdField_a_of_type_Int, localbbty);
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
    paramTextView.setBackgroundDrawable(bcpx.a(BaseApplication.getContext().getResources(), paramInt));
    if ((paramTextView instanceof ThemeLabelTextView)) {
      ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    azqs.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
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
      bbtx localbbtx = a(paramString);
      bool1 = bool2;
      if (localbbtx != null)
      {
        jdField_a_of_type_Bbtx = localbbtx;
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
  
  protected static bbtx b()
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
        localObject3 = new bbtx();
        localObject1 = new bbty();
        ((bbty)localObject1).jdField_a_of_type_Int = 300;
        ((bbty)localObject1).jdField_a_of_type_JavaLangString = alud.a(2131716125);
        ((bbty)localObject1).b = Color.parseColor("#F4BF20");
        bbty localbbty1 = new bbty();
        localbbty1.jdField_a_of_type_Int = 301;
        localbbty1.jdField_a_of_type_JavaLangString = alud.a(2131716114);
        localbbty1.b = Color.parseColor("#6CD9A3");
        bbty localbbty2 = new bbty();
        localbbty2.jdField_a_of_type_Int = 302;
        localbbty2.jdField_a_of_type_JavaLangString = "";
        localbbty2.b = Color.parseColor("#B395EF");
        bbty localbbty3 = new bbty();
        localbbty3.jdField_a_of_type_Int = 303;
        localbbty3.jdField_a_of_type_JavaLangString = alud.a(2131716115);
        localbbty3.b = Color.parseColor("#F4BF20");
        bbty localbbty4 = new bbty();
        localbbty4.jdField_a_of_type_Int = 304;
        localbbty4.jdField_a_of_type_JavaLangString = alud.a(2131716122);
        localbbty4.b = Color.parseColor("#6CD9A3");
        bbty localbbty5 = new bbty();
        localbbty5.jdField_a_of_type_Int = 305;
        localbbty5.jdField_a_of_type_JavaLangString = alud.a(2131716117);
        localbbty5.b = Color.parseColor("#FF988A");
        bbty localbbty6 = new bbty();
        localbbty6.jdField_a_of_type_Int = 306;
        localbbty6.jdField_a_of_type_JavaLangString = alud.a(2131716124);
        localbbty6.b = Color.parseColor("#F4BF20");
        bbty localbbty7 = new bbty();
        localbbty7.jdField_a_of_type_Int = 307;
        localbbty7.jdField_a_of_type_JavaLangString = alud.a(2131716119);
        localbbty7.b = Color.parseColor("#72CCE6");
        bbty localbbty8 = new bbty();
        localbbty8.jdField_a_of_type_Int = 308;
        localbbty8.jdField_a_of_type_JavaLangString = alud.a(2131716123);
        localbbty8.b = Color.parseColor("#FF988A");
        bbty localbbty9 = new bbty();
        localbbty9.jdField_a_of_type_Int = 315;
        localbbty9.jdField_a_of_type_JavaLangString = "";
        localbbty9.b = Color.parseColor("#8EBDF9");
        bbty localbbty10 = new bbty();
        localbbty10.jdField_a_of_type_Int = 311;
        localbbty10.jdField_a_of_type_JavaLangString = alud.a(2131716118);
        localbbty10.b = Color.parseColor("#F25D5D");
        bbty localbbty11 = new bbty();
        localbbty11.jdField_a_of_type_Int = 312;
        localbbty11.jdField_a_of_type_JavaLangString = alud.a(2131716120);
        localbbty11.b = Color.parseColor("#F25D5D");
        bbty localbbty12 = new bbty();
        localbbty12.jdField_a_of_type_Int = 313;
        localbbty12.jdField_a_of_type_JavaLangString = alud.a(2131716127);
        localbbty12.b = Color.parseColor("#FFA5BD");
        bbty localbbty13 = new bbty();
        localbbty13.jdField_a_of_type_Int = 314;
        localbbty13.jdField_a_of_type_JavaLangString = alud.a(2131716116);
        localbbty13.b = Color.parseColor("#FFA5BD");
        bbty localbbty14 = new bbty();
        localbbty14.jdField_a_of_type_Int = 332;
        localbbty14.jdField_a_of_type_JavaLangString = alud.a(2131716121);
        localbbty14.b = Color.parseColor("#F4C020");
        bbty localbbty15 = new bbty();
        localbbty15.jdField_a_of_type_Int = 333;
        localbbty15.jdField_a_of_type_JavaLangString = alud.a(2131716126);
        localbbty15.b = Color.parseColor("#F4C020");
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(300, localObject1);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(301, localbbty1);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(302, localbbty2);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(303, localbbty3);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(304, localbbty4);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(305, localbbty5);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(306, localbbty6);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(307, localbbty7);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(308, localbbty8);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(311, localbbty10);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(312, localbbty11);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(313, localbbty12);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(314, localbbty13);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(315, localbbty9);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(332, localbbty14);
        ((bbtx)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(333, localbbty15);
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
  
  public bbty a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (paramBoolean3) {
      return (bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    return (bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 10000);
  }
  
  protected bbty a(bbty parambbty, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((parambbty == null) || (parambbty.jdField_a_of_type_Int == 300) || (parambbty.jdField_a_of_type_Int == 301)) {}
    bbty localbbty;
    do
    {
      return parambbty;
      if ((paramBoolean1) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(300) != null))
      {
        if (paramBoolean3)
        {
          localbbty = new bbty();
          localbbty.jdField_a_of_type_Int = parambbty.jdField_a_of_type_Int;
          localbbty.jdField_a_of_type_JavaLangString = parambbty.jdField_a_of_type_JavaLangString;
          localbbty.b = ((bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
          return localbbty;
        }
        parambbty.b = ((bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
        return parambbty;
      }
    } while ((!paramBoolean2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(301) == null));
    if (paramBoolean3)
    {
      localbbty = new bbty();
      localbbty.jdField_a_of_type_Int = parambbty.jdField_a_of_type_Int;
      localbbty.jdField_a_of_type_JavaLangString = parambbty.jdField_a_of_type_JavaLangString;
      localbbty.b = ((bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
      return localbbty;
    }
    parambbty.b = ((bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
    return parambbty;
  }
  
  public bbty a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    bbty localbbty1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      localbbty1 = (bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((i != 302) || (localbbty1 == null)) {
        break;
      }
      paramTroopInfo = new bbty();
      paramTroopInfo.jdField_a_of_type_Int = localbbty1.jdField_a_of_type_Int;
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.b = localbbty1.b;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    bbty localbbty2;
    if (i == 315)
    {
      localbbty2 = new bbty();
      if (localbbty1 != null) {}
      for (localbbty2.b = localbbty1.b;; localbbty2.b = Color.parseColor("#8EBDF9"))
      {
        localbbty2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbbty2.jdField_a_of_type_Int = i;
        return a(localbbty2, bool2, bool1, false);
      }
    }
    return a(localbbty1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(302);
      if (paramTroopInfo != null)
      {
        localbbty1 = new bbty();
        localbbty1.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_Int;
        localbbty1.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localbbty1.b = paramTroopInfo.b;
        return a(localbbty1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (bool1) {
      return (bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    if (i == 10315)
    {
      localbbty1 = (bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(315);
      localbbty2 = new bbty();
      if (localbbty1 != null) {}
      for (localbbty2.b = localbbty1.b;; localbbty2.b = Color.parseColor("#8EBDF9"))
      {
        localbbty2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbbty2.jdField_a_of_type_Int = 315;
        return localbbty2;
      }
    }
    return (bbty)this.jdField_a_of_type_AndroidUtilSparseArray.get(i - 10000);
  }
  
  public bbty a(boolean paramBoolean1, boolean paramBoolean2)
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
 * Qualified Name:     bbtx
 * JD-Core Version:    0.7.0.1
 */