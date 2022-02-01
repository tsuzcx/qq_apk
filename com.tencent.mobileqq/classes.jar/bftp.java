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

public class bftp
{
  private static bftp a;
  public int a;
  protected SparseArray<bftq> a;
  
  private bftp()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = BaseApplication.getContext().getResources().getColor(2131166223);
  }
  
  public static bftp a()
  {
    try
    {
      if (jdField_a_of_type_Bftp == null) {
        jdField_a_of_type_Bftp = b();
      }
      bftp localbftp = jdField_a_of_type_Bftp;
      return localbftp;
    }
    finally {}
  }
  
  protected static bftp a(String paramString)
  {
    try
    {
      bftp localbftp = new bftp();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("rankMap");
      int j = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localbftp;
        if (i >= j) {
          break;
        }
        paramString = localJSONArray.getJSONObject(i);
        bftq localbftq = new bftq();
        localbftq.jdField_a_of_type_Int = paramString.getInt("id");
        localbftq.jdField_a_of_type_JavaLangString = paramString.getString("rank");
        localbftq.b = Color.parseColor(paramString.getString("bg"));
        localbftp.jdField_a_of_type_AndroidUtilSparseArray.put(localbftq.jdField_a_of_type_Int, localbftq);
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
    paramTextView.setBackgroundDrawable(bguq.a(BaseApplication.getContext().getResources(), paramInt));
    if ((paramTextView instanceof ThemeLabelTextView)) {
      ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bdll.b(null, "dc00899", "Grp_title", "", paramString1, paramString2, 0, 0, "", "", "", "");
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
      bftp localbftp = a(paramString);
      bool1 = bool2;
      if (localbftp != null)
      {
        jdField_a_of_type_Bftp = localbftp;
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
  
  protected static bftp b()
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
        localObject3 = new bftp();
        localObject1 = new bftq();
        ((bftq)localObject1).jdField_a_of_type_Int = 300;
        ((bftq)localObject1).jdField_a_of_type_JavaLangString = anzj.a(2131714515);
        ((bftq)localObject1).b = Color.parseColor("#F4BF20");
        bftq localbftq1 = new bftq();
        localbftq1.jdField_a_of_type_Int = 301;
        localbftq1.jdField_a_of_type_JavaLangString = anzj.a(2131714504);
        localbftq1.b = Color.parseColor("#6CD9A3");
        bftq localbftq2 = new bftq();
        localbftq2.jdField_a_of_type_Int = 302;
        localbftq2.jdField_a_of_type_JavaLangString = "";
        localbftq2.b = Color.parseColor("#B395EF");
        bftq localbftq3 = new bftq();
        localbftq3.jdField_a_of_type_Int = 303;
        localbftq3.jdField_a_of_type_JavaLangString = anzj.a(2131714505);
        localbftq3.b = Color.parseColor("#F4BF20");
        bftq localbftq4 = new bftq();
        localbftq4.jdField_a_of_type_Int = 304;
        localbftq4.jdField_a_of_type_JavaLangString = anzj.a(2131714512);
        localbftq4.b = Color.parseColor("#6CD9A3");
        bftq localbftq5 = new bftq();
        localbftq5.jdField_a_of_type_Int = 305;
        localbftq5.jdField_a_of_type_JavaLangString = anzj.a(2131714507);
        localbftq5.b = Color.parseColor("#FF988A");
        bftq localbftq6 = new bftq();
        localbftq6.jdField_a_of_type_Int = 306;
        localbftq6.jdField_a_of_type_JavaLangString = anzj.a(2131714514);
        localbftq6.b = Color.parseColor("#F4BF20");
        bftq localbftq7 = new bftq();
        localbftq7.jdField_a_of_type_Int = 307;
        localbftq7.jdField_a_of_type_JavaLangString = anzj.a(2131714509);
        localbftq7.b = Color.parseColor("#72CCE6");
        bftq localbftq8 = new bftq();
        localbftq8.jdField_a_of_type_Int = 308;
        localbftq8.jdField_a_of_type_JavaLangString = anzj.a(2131714513);
        localbftq8.b = Color.parseColor("#FF988A");
        bftq localbftq9 = new bftq();
        localbftq9.jdField_a_of_type_Int = 315;
        localbftq9.jdField_a_of_type_JavaLangString = "";
        localbftq9.b = Color.parseColor("#8EBDF9");
        bftq localbftq10 = new bftq();
        localbftq10.jdField_a_of_type_Int = 311;
        localbftq10.jdField_a_of_type_JavaLangString = anzj.a(2131714508);
        localbftq10.b = Color.parseColor("#F25D5D");
        bftq localbftq11 = new bftq();
        localbftq11.jdField_a_of_type_Int = 312;
        localbftq11.jdField_a_of_type_JavaLangString = anzj.a(2131714510);
        localbftq11.b = Color.parseColor("#F25D5D");
        bftq localbftq12 = new bftq();
        localbftq12.jdField_a_of_type_Int = 313;
        localbftq12.jdField_a_of_type_JavaLangString = anzj.a(2131714517);
        localbftq12.b = Color.parseColor("#FFA5BD");
        bftq localbftq13 = new bftq();
        localbftq13.jdField_a_of_type_Int = 314;
        localbftq13.jdField_a_of_type_JavaLangString = anzj.a(2131714506);
        localbftq13.b = Color.parseColor("#FFA5BD");
        bftq localbftq14 = new bftq();
        localbftq14.jdField_a_of_type_Int = 332;
        localbftq14.jdField_a_of_type_JavaLangString = anzj.a(2131714511);
        localbftq14.b = Color.parseColor("#F4C020");
        bftq localbftq15 = new bftq();
        localbftq15.jdField_a_of_type_Int = 333;
        localbftq15.jdField_a_of_type_JavaLangString = anzj.a(2131714516);
        localbftq15.b = Color.parseColor("#F4C020");
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(300, localObject1);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(301, localbftq1);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(302, localbftq2);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(303, localbftq3);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(304, localbftq4);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(305, localbftq5);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(306, localbftq6);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(307, localbftq7);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(308, localbftq8);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(311, localbftq10);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(312, localbftq11);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(313, localbftq12);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(314, localbftq13);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(315, localbftq9);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(332, localbftq14);
        ((bftp)localObject3).jdField_a_of_type_AndroidUtilSparseArray.put(333, localbftq15);
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
  
  public bftq a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 10000) && (paramInt > 0)) {
      return a((bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean1) {
      return a((bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(302), paramBoolean2, paramBoolean3, true);
    }
    if (paramBoolean2) {
      return (bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (paramBoolean3) {
      return (bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    return (bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 10000);
  }
  
  protected bftq a(bftq parambftq, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((parambftq == null) || (parambftq.jdField_a_of_type_Int == 300) || (parambftq.jdField_a_of_type_Int == 301)) {}
    bftq localbftq;
    do
    {
      return parambftq;
      if ((paramBoolean1) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(300) != null))
      {
        if (paramBoolean3)
        {
          localbftq = new bftq();
          localbftq.jdField_a_of_type_Int = parambftq.jdField_a_of_type_Int;
          localbftq.jdField_a_of_type_JavaLangString = parambftq.jdField_a_of_type_JavaLangString;
          localbftq.b = ((bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
          return localbftq;
        }
        parambftq.b = ((bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(300)).b;
        return parambftq;
      }
    } while ((!paramBoolean2) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(301) == null));
    if (paramBoolean3)
    {
      localbftq = new bftq();
      localbftq.jdField_a_of_type_Int = parambftq.jdField_a_of_type_Int;
      localbftq.jdField_a_of_type_JavaLangString = parambftq.jdField_a_of_type_JavaLangString;
      localbftq.b = ((bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
      return localbftq;
    }
    parambftq.b = ((bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(301)).b;
    return parambftq;
  }
  
  public bftq a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return null;
    }
    boolean bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
    if ((paramTroopInfo.Administrator != null) && (paramTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
    int i;
    bftq localbftq1;
    for (boolean bool1 = true;; bool1 = false)
    {
      i = paramTroopMemberInfo.level;
      if ((i >= 10000) || (i <= 0)) {
        break label232;
      }
      localbftq1 = (bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((i != 302) || (localbftq1 == null)) {
        break;
      }
      paramTroopInfo = new bftq();
      paramTroopInfo.jdField_a_of_type_Int = localbftq1.jdField_a_of_type_Int;
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
      paramTroopInfo.b = localbftq1.b;
      return a(paramTroopInfo, bool2, bool1, false);
    }
    bftq localbftq2;
    if (i == 315)
    {
      localbftq2 = new bftq();
      if (localbftq1 != null) {}
      for (localbftq2.b = localbftq1.b;; localbftq2.b = Color.parseColor("#8EBDF9"))
      {
        localbftq2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbftq2.jdField_a_of_type_Int = i;
        return a(localbftq2, bool2, bool1, false);
      }
    }
    return a(localbftq1, bool2, bool1, true);
    label232:
    if (!TextUtils.isEmpty(paramTroopMemberInfo.mUniqueTitle))
    {
      paramTroopInfo = (bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(302);
      if (paramTroopInfo != null)
      {
        localbftq1 = new bftq();
        localbftq1.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_Int;
        localbftq1.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.mUniqueTitle;
        localbftq1.b = paramTroopInfo.b;
        return a(localbftq1, bool2, bool1, false);
      }
      return null;
    }
    if (bool2) {
      return (bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(300);
    }
    if (bool1) {
      return (bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(301);
    }
    if (i == 10315)
    {
      localbftq1 = (bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(315);
      localbftq2 = new bftq();
      if (localbftq1 != null) {}
      for (localbftq2.b = localbftq1.b;; localbftq2.b = Color.parseColor("#8EBDF9"))
      {
        localbftq2.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberInfo.realLevel)));
        localbftq2.jdField_a_of_type_Int = 315;
        return localbftq2;
      }
    }
    return (bftq)this.jdField_a_of_type_AndroidUtilSparseArray.get(i - 10000);
  }
  
  public bftq a(boolean paramBoolean1, boolean paramBoolean2)
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
 * Qualified Name:     bftp
 * JD-Core Version:    0.7.0.1
 */