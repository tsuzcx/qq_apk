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

public class ayqn
{
  private static ayqn a;
  public int a;
  protected SparseArray<ayqo> a;
  
  private ayqn()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = BaseApplication.getContext().getResources().getColor(2131100538);
  }
  
  public static ayqn a()
  {
    try
    {
      if (jdField_a_of_type_Ayqn == null) {
        jdField_a_of_type_Ayqn = b();
      }
      ayqn localayqn = jdField_a_of_type_Ayqn;
      return localayqn;
    }
    finally {}
  }
  
  protected static ayqn a(String paramString)
  {
    try
    {
      ayqn localayqn = new ayqn();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localayqn;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        ayqo localayqo = new ayqo();
        localayqo.jdField_a_of_type_Int = paramString.getInt("id");
        localayqo.jdField_a_of_type_JavaLangString = paramString.getString("rank");
        localayqo.b = Color.parseColor(paramString.getString("bg"));
        localayqn.jdField_a_of_type_AndroidUtilSparseArray.put(localayqo.jdField_a_of_type_Int, localayqo);
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
    paramTextView.setBackgroundDrawable(azlj.a(BaseApplication.getContext().getResources(), paramInt));
    if ((paramTextView instanceof ThemeLabelTextView)) {
      ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    awqx.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
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
      ayqn localayqn = a(paramString);
      bool1 = bool2;
      if (localayqn != null)
      {
        jdField_a_of_type_Ayqn = localayqn;
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
  
  protected static ayqn b()
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
        localObject3 = new ayqn();
        localObject1 = new ayqo();
        ((ayqo)localObject1).jdField_a_of_type_Int = 300;
        ((ayqo)localObject1).jdField_a_of_type_JavaLangString = ajjy.a(2131649939);
        ((ayqo)localObject1).b = Color.parseColor("#F4BF20");
        ayqo localayqo1 = new ayqo();
        localayqo1.jdField_a_of_type_Int = 301;
        localayqo1.jdField_a_of_type_JavaLangString = ajjy.a(2131649928);
        localayqo1.b = Color.parseColor("#6CD9A3");
        ayqo localayqo2 = new ayqo();
        localayqo2.jdField_a_of_type_Int = 302;
        localayqo2.jdField_a_of_type_JavaLangString = "";
        localayqo2.b = Color.parseColor("#B395EF");
        ayqo localayqo3 = new ayqo();
        localayqo3.jdField_a_of_type_Int = 303;
        localayqo3.jdField_a_of_type_JavaLangString = ajjy.a(2131649929);
        localayqo3.b = Color.parseColor("#F4BF20");
        ayqo localayqo4 = new ayqo();
        localayqo4.jdField_a_of_type_Int = 304;
        localayqo4.jdField_a_of_type_JavaLangString = ajjy.a(2131649936);
        localayqo4.b = Color.parseColor("#6CD9A3");
        ayqo localayqo5 = new ayqo();
        localayqo5.jdField_a_of_type_Int = 305;
        localayqo5.jdField_a_of_type_JavaLangString = ajjy.a(2131649931);
        localayqo5.b = Color.parseColor("#FF988A");
        ayqo localayqo6 = new ayqo();
        localayqo6.jdField_a_of_type_Int = 306;
        localayqo6.jdField_a_of_type_JavaLangString = ajjy.a(2131649938);
        localayqo6.b = Color.parseColor("#F4BF20");
        ayqo localayqo7 = new ayqo();
        localayqo7.jdField_a_of_type_Int = 307;
        localayqo7.jdField_a_of_type_JavaLangString = ajjy.a(2131649933);
        localayqo7.b = Color.parseColor("#72CCE6");
        ayqo localayqo8 = new ayqo();
        localayqo8.jdField_a_of_type_Int = 308;
        localayqo8.jdField_a_of_type_JavaLangString = ajjy.a(2131649937);
        localayqo8.b = Color.parseColor("#FF988A");
        ayqo localayqo9 = new ayqo();
        localayqo9.jdField_a_of_type_Int = 315;
        localayqo9.jdField_a_of_type_JavaLangString = "";
        localayqo9.b = Color.parseColor("#8EBDF9");
        ayqo localayqo10 = new ayqo();
        localayqo10.jdField_a_of_type_Int = 311;
        localayqo10.jdField_a_of_type_JavaLangString = ajjy.a(2131649932);
        localayqo10.b = Color.parseColor("#F25D5D");
        ayqo localayqo11 = new ayqo();
        localayqo11.jdField_a_of_type_Int = 312;
        localayqo11.jdField_a_of_type_JavaLangString = ajjy.a(2131649934);
        localayqo11.b = Color.parseColor("#F25D5D");
        ayqo localayqo12 = new ayqo();
        localayqo12.jdField_a_of_type_Int = 313;
        localayqo12.jdField_a_of_type_JavaLangString = ajjy.a(2131649941);
        localayqo12.b = Color.parseColor("#FFA5BD");
        ayqo localayqo13 = new ayqo();
        localayqo13.jdField_a_of_type_Int = 314;
        localayqo13.jdField_a_of_type_JavaLangString = ajjy.a(2131649930);
        localayqo13.b = Color.parseColor("#FFA5BD");
        ayqo localayqo14 = new ayqo();
        localayqo14.jdField_a_of_type_Int = 332;
        localayqo14.jdField_a_of_type_JavaLangString = ajjy.a(2131649935);
        localayqo14.b = Color.parseColor("#F4C020");
        ayqo localayqo15 = new ayqo();
        localayqo15.jdField_a_of_type_Int = 333;
        localayqo15.jdField_a_of_type_JavaLangString = ajjy.a(2131649940);
        localayqo15.b = Color.parseColor("#F4C020");
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(300, localObject1);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(301, localayqo1);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(302, localayqo2);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(303, localayqo3);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(304, localayqo4);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(305, localayqo5);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(306, localayqo6);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(307, localayqo7);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(308, localayqo8);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(311, localayqo10);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(312, localayqo11);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(313, localayqo12);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(314, localayqo13);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(315, localayqo9);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(332, localayqo14);
        ((ayqn)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(333, localayqo15);
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
  
  public ayqo a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (paramBoolean3) {
      return (ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    return (ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 10000);
  }
  
  protected ayqo a(ayqo paramayqo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramayqo == null) || (paramayqo.jdField_a_of_type_Int == 300) || (paramayqo.jdField_a_of_type_Int == 301)) {}
    ayqo localayqo;
    do
    {
      return paramayqo;
      if ((paramBoolean1) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(300) != null))
      {
        if (paramBoolean3)
        {
          localayqo = new ayqo();
          localayqo.jdField_a_of_type_Int = paramayqo.jdField_a_of_type_Int;
          localayqo.jdField_a_of_type_JavaLangString = paramayqo.jdField_a_of_type_JavaLangString;
          localayqo.b = ((ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
          return localayqo;
        }
        paramayqo.b = ((ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
        return paramayqo;
      }
    } while ((!paramBoolean2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(301) == null));
    if (paramBoolean3)
    {
      localayqo = new ayqo();
      localayqo.jdField_a_of_type_Int = paramayqo.jdField_a_of_type_Int;
      localayqo.jdField_a_of_type_JavaLangString = paramayqo.jdField_a_of_type_JavaLangString;
      localayqo.b = ((ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
      return localayqo;
    }
    paramayqo.b = ((ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
    return paramayqo;
  }
  
  public ayqo a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    ayqo localayqo1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      localayqo1 = (ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((i != 302) || (localayqo1 == null)) {
        break;
      }
      paramTroopInfo = new ayqo();
      paramTroopInfo.jdField_a_of_type_Int = localayqo1.jdField_a_of_type_Int;
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.b = localayqo1.b;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    ayqo localayqo2;
    if (i == 315)
    {
      localayqo2 = new ayqo();
      if (localayqo1 != null) {}
      for (localayqo2.b = localayqo1.b;; localayqo2.b = Color.parseColor("#8EBDF9"))
      {
        localayqo2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localayqo2.jdField_a_of_type_Int = i;
        return a(localayqo2, bool2, bool1, false);
      }
    }
    return a(localayqo1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(302);
      if (paramTroopInfo != null)
      {
        localayqo1 = new ayqo();
        localayqo1.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_Int;
        localayqo1.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localayqo1.b = paramTroopInfo.b;
        return a(localayqo1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (bool1) {
      return (ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    if (i == 10315)
    {
      localayqo1 = (ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(315);
      localayqo2 = new ayqo();
      if (localayqo1 != null) {}
      for (localayqo2.b = localayqo1.b;; localayqo2.b = Color.parseColor("#8EBDF9"))
      {
        localayqo2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localayqo2.jdField_a_of_type_Int = 315;
        return localayqo2;
      }
    }
    return (ayqo)this.jdField_a_of_type_AndroidUtilSparseArray.get(i - 10000);
  }
  
  public ayqo a(boolean paramBoolean1, boolean paramBoolean2)
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
 * Qualified Name:     ayqn
 * JD-Core Version:    0.7.0.1
 */