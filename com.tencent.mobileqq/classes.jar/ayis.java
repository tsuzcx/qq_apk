import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ayis
  extends aykt
{
  private ayjk a;
  public String a;
  public boolean a;
  private String b = alpo.a(2131705748);
  public boolean b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public ayis(ayjk paramayjk)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ayjk = paramayjk;
    this.jdField_a_of_type_JavaLangString = paramayjk.a();
    if (paramayjk.a() != null) {
      if (paramayjk.a().size() <= paramayjk.a()) {
        break label70;
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      label70:
      bool = false;
    }
  }
  
  public ayis(ayjk paramayjk, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ayjk = paramayjk;
    if (TextUtils.isEmpty(paramString)) {}
    for (this.jdField_a_of_type_JavaLangString = paramayjk.a();; this.jdField_a_of_type_JavaLangString = paramString)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public ayis(ayjk paramayjk, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ayjk = paramayjk;
    this.jdField_a_of_type_JavaLangString = paramayjk.a();
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public ayis(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.b = alpo.a(2131705753);
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Ayjk != null)
    {
      int i = aydw.a(this.jdField_a_of_type_Ayjk);
      if (i > 0) {
        return i;
      }
    }
    if ((this.jdField_a_of_type_Ayjk != null) && ((this.jdField_a_of_type_Ayjk instanceof ayii))) {
      return ((ayii)this.jdField_a_of_type_Ayjk).jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public ayjk a()
  {
    return this.jdField_a_of_type_Ayjk;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<ayjl> a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    aydp localaydp;
    Object localObject1;
    if ((localContext instanceof aydp))
    {
      localaydp = (aydp)localContext;
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    switch (localaydp.a())
    {
    default: 
      if (this.jdField_a_of_type_Ayjk != null) {
        this.jdField_a_of_type_Ayjk.a(paramView);
      }
      break;
    }
    label144:
    label421:
    while (!this.jdField_c_of_type_Boolean)
    {
      for (;;)
      {
        return;
        int i;
        Object localObject2;
        if (((this.jdField_a_of_type_Ayjk instanceof ayii)) && (ayrd.a(((ayii)this.jdField_a_of_type_Ayjk).jdField_a_of_type_Long)))
        {
          if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || ((!this.jdField_c_of_type_JavaLangString.startsWith("http://")) && (!this.jdField_c_of_type_JavaLangString.startsWith("https://"))))
          {
            i = 1;
            localObject2 = localaydp.a();
            String str = "" + a();
            if (i == 0) {
              break label421;
            }
            localObject1 = "1";
            ayrd.a("all_result", "more_object", new String[] { localObject2, str, localObject1 });
          }
        }
        else if (!aydw.jdField_a_of_type_Boolean) {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("project", aynt.a());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("get_src", "web");
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          aynt.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("clk_more").obj1(a() + "").ver1(localaydp.a()).ver2(aynt.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
          ayrd.a("all_result", "clk_tab_more", new String[] { b(), ayrd.a(localaydp.a()), "", ayrd.a("dynamic_unite_search.1", localaydp.a()) });
          break;
          i = 0;
          break label144;
          localObject1 = "0";
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.SearchResultGroupModelImpl", 2, "e = " + localJSONException);
          }
          ayrd.a("sub_result", "more_result", new String[] { localaydp.a(), "" + localaydp.a(), "" + a(1), ayrd.a("dynamic_tab_search.1", localaydp.a()) });
        }
      }
      break;
    }
    localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse(this.jdField_c_of_type_JavaLangString)));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Ayjk instanceof ayii))
    {
      if (ayrd.a(((ayii)this.jdField_a_of_type_Ayjk).jdField_a_of_type_Long)) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Ayjk != null) {
      return this.jdField_a_of_type_Ayjk.b();
    }
    return null;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public String c()
  {
    if (this.b == null) {
      return "";
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayis
 * JD-Core Version:    0.7.0.1
 */