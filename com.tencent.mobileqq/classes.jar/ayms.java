import NearbyGroup.GroupLabel;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend.MayKnowRecommendLabel;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ayms
  extends aynv
{
  public int a;
  protected long a;
  Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  protected CharSequence a;
  protected String a;
  StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  public ArrayList<GroupLabel> a;
  public List<String> a;
  protected boolean a;
  public int[] a;
  public int b;
  public long b;
  protected CharSequence b;
  public String b;
  public List<RecommendLabel> b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  protected String d;
  public boolean d;
  public int e;
  protected String e;
  public boolean e;
  public int f;
  protected String f;
  public int g;
  protected String g;
  private boolean g;
  public int h;
  public String h;
  private boolean h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  private String n;
  public int o;
  public int p;
  public int q;
  private int t;
  private int u;
  private int v = 0;
  
  public ayms()
  {
    this.jdField_c_of_type_Int = 2131166978;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = -1;
  }
  
  public ayms(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, List<String> paramList, int paramInt)
  {
    this.jdField_c_of_type_Int = 2131166978;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.jdField_f_of_type_JavaLangString = paramString6;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 1;
    this.jdField_c_of_type_Long = 0L;
    a();
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "extension info:" + this.jdField_f_of_type_JavaLangString);
    }
    Object localObject3;
    label272:
    Object localObject2;
    label551:
    Object localObject1;
    int i1;
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      try
      {
        localObject3 = new JSONObject(this.jdField_f_of_type_JavaLangString);
        String str2 = ((JSONObject)localObject3).optString("thirdLineText");
        if (a(this.jdField_a_of_type_Long, (JSONObject)localObject3))
        {
          if (!QLog.isColorLevel()) {
            break label1202;
          }
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "child class has already parsed json data. groupMask=" + this.jdField_a_of_type_Long);
          return;
        }
        switch ((int)this.jdField_a_of_type_Long)
        {
        case 1001: 
          if (TextUtils.isEmpty(str2)) {
            break label1202;
          }
          this.jdField_b_of_type_JavaLangCharSequence = str2;
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        return;
      }
      this.jdField_g_of_type_JavaLangString = ("(" + this.jdField_b_of_type_JavaLangString + ")");
      this.jdField_d_of_type_Int = ((JSONObject)localObject3).optInt("gender");
      this.jdField_e_of_type_Int = ((JSONObject)localObject3).optInt("age");
      a(((JSONObject)localObject3).optString("college"), 1);
      if (((JSONObject)localObject3).optString("location").equals(((JSONObject)localObject3).optString("hometown")))
      {
        a(((JSONObject)localObject3).optString("location"), 4);
        a(((JSONObject)localObject3).optString("constellation"), 2);
        this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("location");
        this.jdField_i_of_type_JavaLangString = ((JSONObject)localObject3).optString("authIcon");
        this.jdField_m_of_type_JavaLangString = ((JSONObject)localObject3).optString("longnick");
        this.jdField_m_of_type_Int = ((JSONObject)localObject3).optInt("allow", -1);
      }
      for (;;)
      {
        try
        {
          this.jdField_i_of_type_Int = ((JSONObject)localObject3).optInt("cspecialflag");
          String str1 = ((JSONObject)localObject3).optString("qdmasteruin");
          localObject2 = ((JSONObject)localObject3).optString("qdemailuin");
          this.jdField_j_of_type_JavaLangString = ((JSONObject)localObject3).optString("kfaccount");
          localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bfyh.a((QQAppInterface)localObject3, this.jdField_i_of_type_Int, this.jdField_b_of_type_JavaLangString);
          bfyh.a((QQAppInterface)localObject3, this.jdField_b_of_type_JavaLangString, str1);
          if ((!bfyh.b(this.jdField_i_of_type_Int)) && (!bfyh.c(this.jdField_i_of_type_Int))) {
            break;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label551;
          }
          this.jdField_g_of_type_JavaLangString = "";
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json qdemailuin is empty ");
          if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
            break;
          }
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json kfaccount is empty ");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "Parse search qidian json fail: " + this.jdField_b_of_type_JavaLangString + " | " + localException.getMessage());
        break;
        a(((JSONObject)localObject3).optString("location"), 4);
        a(((JSONObject)localObject3).optString("hometown"), 4);
        break label272;
        this.jdField_g_of_type_JavaLangString = ("(" + (String)localObject2 + ")");
      }
      this.jdField_b_of_type_Long = ((JSONObject)localObject3).optLong("flag_ext");
      this.jdField_g_of_type_JavaLangString = "";
      localObject1 = ((JSONObject)localObject3).optJSONArray("label");
      if (localObject1 != null)
      {
        localObject2 = new ArrayList();
        i1 = 0;
        for (;;)
        {
          int i2 = ((JSONArray)localObject1).length();
          if (i1 < i2) {
            try
            {
              JSONObject localJSONObject1 = ((JSONArray)localObject1).getJSONObject(i1);
              GroupLabel localGroupLabel = new GroupLabel();
              NearbyGroup.Color localColor = new NearbyGroup.Color();
              JSONObject localJSONObject2 = localJSONObject1.optJSONObject("edging_color");
              localColor.R = localJSONObject2.optLong("r");
              localColor.G = localJSONObject2.optLong("g");
              localColor.B = localJSONObject2.optLong("b");
              localGroupLabel.edging_color = localColor;
              localColor = new NearbyGroup.Color();
              localJSONObject2 = localJSONObject1.optJSONObject("text_color");
              localColor.R = localJSONObject2.optLong("r");
              localColor.G = localJSONObject2.optLong("g");
              localColor.B = localJSONObject2.optLong("b");
              localGroupLabel.text_color = localColor;
              localGroupLabel.strWording = localJSONObject1.optString("name");
              localGroupLabel.type = localJSONObject1.optLong("attr");
              ((ArrayList)localObject2).add(localGroupLabel);
              i1 += 1;
            }
            catch (JSONException localJSONException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "parse extension JSONException:" + localJSONException2.toString());
                }
              }
            }
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
      }
      localObject2 = ((JSONObject)localObject3).optString("memo");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696622);
      }
      this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      long l1 = ((JSONObject)localObject3).optLong("active", 0L);
      long l2 = ((JSONObject)localObject3).optLong("join_group_flag", -1L);
      long l3 = ((JSONObject)localObject3).optLong("privilege_flag", 0L);
      this.jdField_l_of_type_JavaLangString = ((JSONObject)localObject3).optString("arithmetic");
      this.jdField_c_of_type_Long = l1;
      if (l2 <= -1L) {
        break label1206;
      }
      i1 = 0;
      label975:
      this.jdField_j_of_type_Int = i1;
      if ((0x200 & l3) == 0L) {
        break label1211;
      }
    }
    label1202:
    label1206:
    label1211:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_e_of_type_Boolean = bool;
      this.k = ((JSONObject)localObject3).optString("join_group_auth");
      this.jdField_m_of_type_Int = ((JSONObject)localObject3).optInt("allow", -1);
      this.jdField_n_of_type_Int = ((JSONObject)localObject3).optInt("invite_only", 0);
      break;
      this.jdField_b_of_type_Int = ((JSONObject)localObject3).optInt("video_or_music");
      localObject1 = ((JSONObject)localObject3).optString("busi_mask");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      if (Integer.parseInt((String)localObject1) == 2049) {
        this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("brief");
      }
      for (;;)
      {
        localObject1 = ((JSONObject)localObject3).optString("from");
        localObject2 = ayva.a(Long.parseLong(((JSONObject)localObject3).optString("create_time")));
        this.jdField_b_of_type_JavaLangCharSequence = ((String)localObject1 + (String)localObject2);
        this.jdField_a_of_type_Boolean = true;
        break;
        if (Integer.parseInt((String)localObject1) == 64) {
          this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("content");
        } else if (Integer.parseInt((String)localObject1) == 4096) {
          this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("description");
        }
      }
      return;
      break;
      i1 = 1;
      break label975;
    }
  }
  
  public int a()
  {
    return this.t;
  }
  
  public int a(int paramInt)
  {
    int i1 = -1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "getPosition(). type=" + paramInt + "  position=" + i1);
      }
      return i1;
      i1 = this.o;
      continue;
      i1 = this.p;
      continue;
      i1 = this.q;
    }
  }
  
  public CharSequence a()
  {
    boolean bool = true;
    if (d() == 268435456) {}
    Object localObject;
    do
    {
      try
      {
        CharSequence localCharSequence = ayvm.a(this.jdField_c_of_type_JavaLangString, a(), true);
        return localCharSequence;
      }
      catch (Exception localException)
      {
        QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, localException, new Object[0]);
        return this.jdField_c_of_type_JavaLangString;
      }
      localObject = new ayvb(this.jdField_a_of_type_JavaUtilList, a());
      if (d() != 1002) {
        break;
      }
      this.jdField_c_of_type_JavaLangString = ayvm.a(this.jdField_c_of_type_JavaLangString);
      localSpannableString = ((ayvb)localObject).a(this.jdField_c_of_type_JavaLangString, true);
      localObject = localSpannableString;
    } while (localSpannableString != null);
    return "";
    this.jdField_c_of_type_JavaLangString = ayvm.a(this.jdField_c_of_type_JavaLangString);
    SpannableString localSpannableString = ((ayvb)localObject).a(this.jdField_c_of_type_JavaLangString, true);
    if (((ayvb)localObject).jdField_a_of_type_Int > 0) {}
    for (;;)
    {
      this.jdField_g_of_type_Boolean = bool;
      if (localSpannableString != null) {
        break;
      }
      return "";
      bool = false;
    }
    return localSpannableString;
  }
  
  public Object a(String paramString)
  {
    int i2 = 0;
    boolean bool = false;
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramString))
    {
      paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699982);
      switch (this.jdField_j_of_type_Int)
      {
      default: 
        bool = true;
      }
      for (;;)
      {
        return new Pair(paramString, Boolean.valueOf(bool));
        paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699984);
        continue;
        paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699982);
        bool = true;
        continue;
        paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699983);
      }
    }
    if ("ActiveEntitySearchResultPresenter_pay_troop".equals(paramString)) {
      return Boolean.valueOf(this.jdField_e_of_type_Boolean);
    }
    int i1;
    if ("ActiveEntitySearchResultPresenter_hot_troop".equals(paramString))
    {
      i1 = (int)this.jdField_c_of_type_Long;
      if (i1 >= 0) {
        break label190;
      }
      i1 = i2;
    }
    label190:
    for (;;)
    {
      i2 = i1;
      if (i1 > 10) {
        i2 = 10;
      }
      return Integer.valueOf(i2);
      return super.a(paramString);
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.t = paramInt1;
    this.u = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b(2, paramInt1);
    b(1, paramInt2);
    b(3, paramInt3);
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "onAction(). jumpUrl = " + this.jdField_e_of_type_JavaLangString + "  id=" + this.jdField_b_of_type_JavaLangString);
    }
    Object localObject2;
    Object localObject3;
    switch (d())
    {
    default: 
      if (this.jdField_a_of_type_Long == 1002L) {
        ayvh.a(this);
      }
      localObject2 = paramView.getContext();
      if ((localObject2 instanceof ayhy))
      {
        localObject3 = (ayhy)localObject2;
        if (((ayhy)localObject3).b()) {}
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = ((ayhy)localObject3).a();
        if (!(localObject1 instanceof ayhx)) {
          break label2491;
        }
      }
      break;
    }
    label2485:
    label2491:
    for (Object localObject1 = (ayhx)localObject1;; localObject1 = null)
    {
      label204:
      Object localObject4;
      switch (((ayhy)localObject3).a())
      {
      default: 
        if (d() == 268435456)
        {
          ayvm.a("all_result", "clk_function", new String[] { "" + this.jdField_a_of_type_JavaLangString, "" + this.jdField_b_of_type_JavaLangString, "" + (this.jdField_g_of_type_Int + 1) });
          if (((paramView.getContext() instanceof UniteSearchActivity)) && (ayif.jdField_b_of_type_JavaUtilHashMap.containsKey(this)))
          {
            localObject1 = (ayig)ayif.jdField_b_of_type_JavaUtilHashMap.get(this);
            localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            localObject4 = new JSONObject();
          }
        }
        break;
      }
      label2015:
      do
      {
        try
        {
          for (;;)
          {
            ((JSONObject)localObject4).put("project", aysc.a());
            ((JSONObject)localObject4).put("event_src", "client");
            ((JSONObject)localObject4).put("obj_lct", ((ayig)localObject1).jdField_a_of_type_Int);
            ((JSONObject)localObject4).put("get_src", "native");
            aysc.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((ayig)localObject1).jdField_a_of_type_Long + "").obj2(((ayig)localObject1).jdField_b_of_type_JavaLangString).ver1(((ayig)localObject1).jdField_a_of_type_JavaLangString).ver2(aysc.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject4).toString()).session_id(((QQAppInterface)localObject3).getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
            if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
              break label2109;
            }
            if ((!this.jdField_e_of_type_JavaLangString.startsWith("http")) && (!this.jdField_e_of_type_JavaLangString.startsWith("https"))) {
              break label2015;
            }
            paramView = new Intent((Context)localObject2, QQBrowserActivity.class);
            paramView.putExtra("url", this.jdField_e_of_type_JavaLangString);
            ((Context)localObject2).startActivity(paramView);
            return;
            ayvm.a(this.jdField_a_of_type_JavaLangString, 70, 0, this.jdField_g_of_type_Int, paramView);
            if (this.jdField_l_of_type_Int == 1)
            {
              azqs.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 0, 0, "", "", "", "");
              azqs.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 2, 0, "", "", "", "");
              break;
            }
            azqs.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 0, 0, "", "", "", "");
            azqs.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 1, 0, "", "", "", "");
            break;
            ayvm.a(this.jdField_a_of_type_JavaLangString, 80, 0, this.jdField_g_of_type_Int, paramView);
            break;
            ayvm.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, e(), e());
            ayvm.a(this.jdField_a_of_type_JavaLangString, 120, 0, this.jdField_g_of_type_Int, paramView);
            if ((this.jdField_n_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)))
            {
              aysc.a(null, 0, this.jdField_a_of_type_Int, "0X8009D31", 4, 0, this.jdField_b_of_type_JavaLangString, null);
              break;
            }
            if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
            {
              aysc.a(null, 0, this.jdField_a_of_type_Int, "0X8009D35", 0, 0, this.jdField_b_of_type_JavaLangString, null);
              break;
            }
            aysc.a(null, 0, this.jdField_a_of_type_Int, "0X8009D49", 0, 0, this.jdField_b_of_type_JavaLangString, null);
            break;
            QQAppInterface localQQAppInterface;
            JSONObject localJSONObject;
            if ((ayif.jdField_b_of_type_JavaUtilHashMap.containsKey(this)) && (d() != 268435456))
            {
              localObject4 = (ayig)ayif.jdField_b_of_type_JavaUtilHashMap.get(this);
              localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
              localJSONObject = new JSONObject();
            }
            try
            {
              localJSONObject.put("project", aysc.a());
              localJSONObject.put("event_src", "client");
              localJSONObject.put("obj_lct", ((ayig)localObject4).jdField_a_of_type_Int);
              localJSONObject.put("get_src", "web");
              aysc.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(this.jdField_a_of_type_Long + "").obj2(((ayig)localObject4).jdField_b_of_type_JavaLangString).ver1(this.jdField_a_of_type_JavaLangString).ver2(aysc.a(this.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
              if (ayvm.a(this.jdField_a_of_type_Long)) {
                if (ayif.jdField_a_of_type_JavaUtilHashMap.containsKey(this))
                {
                  localObject4 = (ayig)ayif.jdField_a_of_type_JavaUtilHashMap.get(this);
                  if (((ayig)localObject4).jdField_b_of_type_Boolean)
                  {
                    i1 = 2;
                    ayvm.a("all_result", "clk_object", i1, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_Long, ((ayig)localObject4).jdField_b_of_type_JavaLangString + "", ((ayig)localObject4).jdField_a_of_type_Int + "" });
                  }
                }
                else
                {
                  if ((localObject1 == null) || (!((ayhx)localObject1).b())) {
                    break label204;
                  }
                  ((ayhx)localObject1).a(true);
                  ayvm.a("all_result", "clk_first_result", new String[] { ((ayhy)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(3), ayvm.a("dynamic_tab_search.1", ((ayhy)localObject3).a()) });
                }
              }
            }
            catch (JSONException localJSONException2)
            {
              for (;;)
              {
                QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "e = " + localJSONException2);
                continue;
                i1 = 1;
              }
              if (ayif.jdField_b_of_type_Boolean) {}
              for (i1 = 2;; i1 = 1)
              {
                ayvm.a("all_result", "clk_content", i1, 0, new String[] { ((ayhy)localObject3).a(), "" + this.jdField_a_of_type_Long, "", ayvm.a("dynamic_tab_search.1", ((ayhy)localObject3).a()) });
                if ((localObject1 == null) || (!((ayhx)localObject1).b())) {
                  break;
                }
                ((ayhx)localObject1).a(true);
                ayvm.a("all_result", "clk_first_result", new String[] { ((ayhy)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), ayvm.a("dynamic_tab_search.1", ((ayhy)localObject3).a()) });
                break;
              }
            }
          }
          if ((localObject1 != null) && (((ayhx)localObject1).b()))
          {
            ((ayhx)localObject1).a(true);
            ayvm.a("all_result", "clk_tab_first_result", new String[] { ((ayhy)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), ayvm.a("dynamic_tab_search.1", ((ayhy)localObject3).a()) });
          }
          ayvm.a("all_result", "clk_tab_result", new String[] { ((ayhy)localObject3).a(), "" + this.jdField_a_of_type_Long, "", ayvm.a("dynamic_tab_search.1", ((ayhy)localObject3).a()) });
          break label204;
          if ((localObject1 != null) && (((ayhx)localObject1).b()))
          {
            ((ayhx)localObject1).a(true);
            ayvm.a("sub_result", "clk_sub_first_result", new String[] { ((ayhy)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), ayvm.a("dynamic_tab_search.1", ((ayhy)localObject3).a()) });
          }
          ayvm.a("sub_result", "clk_result", new String[] { ((ayhy)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), ayvm.a("dynamic_tab_search.1", ((ayhy)localObject3).a()) });
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "e = " + localJSONException1);
          }
          if ((localObject2 instanceof BaseActivity))
          {
            paramView = bdib.a(((BaseActivity)paramView.getContext()).app, (Context)localObject2, this.jdField_e_of_type_JavaLangString);
            if (paramView != null)
            {
              paramView.c();
              return;
            }
            ((Context)localObject2).startActivity(new Intent((Context)localObject2, JumpActivity.class).setData(Uri.parse(this.jdField_e_of_type_JavaLangString)));
            return;
          }
          ((Context)localObject2).startActivity(new Intent((Context)localObject2, JumpActivity.class).setData(Uri.parse(this.jdField_e_of_type_JavaLangString)));
          return;
        }
        if (this.jdField_a_of_type_Long == 268435456L)
        {
          ayvm.a(paramView.getContext(), Integer.valueOf(this.jdField_b_of_type_JavaLangString).intValue(), this.jdField_a_of_type_Int);
          return;
        }
        if (this.jdField_a_of_type_Long == 1001L)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject2 = new SearchResultItem();
          ((SearchResultItem)localObject2).jdField_a_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
          try
          {
            if ((bfyh.b(this.jdField_i_of_type_Int)) || (bfyh.c(this.jdField_i_of_type_Int))) {
              ((SearchResultItem)localObject2).jdField_a_of_type_Long = Long.valueOf(this.jdField_j_of_type_JavaLangString).longValue();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.i("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "qidian corp jump error");
            }
            AddFriendActivity.a((Activity)paramView.getContext(), (SearchResultItem)localObject2, (QQAppInterface)localObject1, true, 3);
            return;
          }
          ((SearchResultItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          if (bclg.b((QQAppInterface)localObject1, this.jdField_b_of_type_JavaLangString))
          {
            bclg.a(paramView.getContext(), null, this.jdField_b_of_type_JavaLangString);
            return;
          }
        }
      } while (this.jdField_a_of_type_Long != 1002L);
      label2109:
      int i1 = 0;
      localObject1 = paramView.getContext();
      int i3 = i1;
      if ((localObject1 instanceof Activity))
      {
        Intent localIntent = ((Activity)localObject1).getIntent();
        i3 = i1;
        if (localIntent != null) {
          i3 = localIntent.getIntExtra("from_type_for_report", 0);
        }
      }
      i1 = 103;
      if (i3 == 9) {
        i1 = 112;
      }
      int i2 = i1;
      if (localObject1 != null)
      {
        i2 = i1;
        if ((localObject2 instanceof ActiveEntitySearchActivity))
        {
          localObject1 = ((Activity)localObject1).getIntent().getLongArrayExtra("group_mask_long_array");
          i2 = i1;
          if (localObject1 != null)
          {
            i2 = i1;
            if (localObject1.length == 1)
            {
              i2 = i1;
              if (localObject1[0] == 1002L) {
                if (i3 != 9) {
                  break label2485;
                }
              }
            }
          }
        }
      }
      for (i2 = 113;; i2 = 104)
      {
        localObject1 = TroopInfoActivity.a(this.jdField_b_of_type_JavaLangString, i2);
        ((Bundle)localObject1).putInt("exposureSource", 3);
        ((Bundle)localObject1).putInt("t_s_f", 1000);
        ((Bundle)localObject1).putString("authSig", this.k);
        bcpx.a(paramView.getContext(), (Bundle)localObject1, 2);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_n_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      if ((paramInt != 3) || (((this.jdField_b_of_type_JavaUtilList.size() <= 2) || ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 2))) && (this.jdField_b_of_type_JavaUtilList.size() <= 3))) {}
    }
    else
    {
      return;
    }
    MayKnowRecommend.MayKnowRecommendLabel localMayKnowRecommendLabel = new MayKnowRecommend.MayKnowRecommendLabel();
    localMayKnowRecommendLabel.text_color = -1;
    localMayKnowRecommendLabel.bytes_name = paramString;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilList.add(localMayKnowRecommendLabel);
      return;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#FF8A2D");
      continue;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#7373FF");
      continue;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#C573FF");
      continue;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#FFC619");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "JSONObject info:" + paramJSONObject);
    }
    if (paramJSONObject == null) {}
    return false;
  }
  
  public int b()
  {
    return this.u;
  }
  
  public CharSequence b()
  {
    Object localObject = new ayvb(this.jdField_a_of_type_JavaUtilList, a());
    this.jdField_g_of_type_JavaLangString = ayvm.a(this.jdField_g_of_type_JavaLangString);
    SpannableString localSpannableString = ((ayvb)localObject).a(this.jdField_g_of_type_JavaLangString);
    localObject = localSpannableString;
    if (localSpannableString == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.o = paramInt2;
      return;
    case 2: 
      this.p = paramInt2;
      return;
    }
    this.q = paramInt2;
  }
  
  public int c()
  {
    if (d() == 1001) {
      return 1;
    }
    if (d() == 1002) {
      return 4;
    }
    return 0;
  }
  
  public CharSequence c()
  {
    boolean bool = false;
    ayvb localayvb = new ayvb(this.jdField_a_of_type_JavaUtilList, a());
    this.jdField_a_of_type_JavaLangCharSequence = ayvm.a(this.jdField_a_of_type_JavaLangCharSequence);
    SpannableString localSpannableString = localayvb.a(this.jdField_a_of_type_JavaLangCharSequence, false, false, false);
    if (localayvb.jdField_a_of_type_Int > 0) {
      bool = true;
    }
    this.h = bool;
    if (localSpannableString == null) {
      return "";
    }
    return localSpannableString;
  }
  
  public String c()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public int d()
  {
    return (int)this.jdField_a_of_type_Long;
  }
  
  public CharSequence d()
  {
    Object localObject;
    if ((this.jdField_g_of_type_Boolean) || (this.h)) {
      localObject = this.jdField_b_of_type_JavaLangCharSequence;
    }
    SpannableString localSpannableString;
    do
    {
      return localObject;
      localSpannableString = new ayvb(this.jdField_a_of_type_JavaUtilList, a()).a(this.jdField_b_of_type_JavaLangCharSequence, false, this.jdField_a_of_type_Boolean);
      localObject = localSpannableString;
    } while (localSpannableString != null);
    return "";
  }
  
  public String d()
  {
    if (this.jdField_l_of_type_JavaLangString != null) {
      return this.jdField_l_of_type_JavaLangString;
    }
    return "";
  }
  
  public int e()
  {
    return this.v;
  }
  
  public String e()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayms
 * JD-Core Version:    0.7.0.1
 */