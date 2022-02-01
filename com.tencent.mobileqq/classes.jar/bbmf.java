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

public class bbmf
  extends bbog
{
  private bbmx a;
  public String a;
  public boolean a;
  private String b = anni.a(2131704161);
  public boolean b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public bbmf(bbmx parambbmx)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bbmx = parambbmx;
    this.jdField_a_of_type_JavaLangString = parambbmx.a();
    if (parambbmx.a() != null) {
      if (parambbmx.a().size() <= parambbmx.a()) {
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
  
  public bbmf(bbmx parambbmx, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bbmx = parambbmx;
    if (TextUtils.isEmpty(paramString)) {}
    for (this.jdField_a_of_type_JavaLangString = parambbmx.a();; this.jdField_a_of_type_JavaLangString = paramString)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public bbmf(bbmx parambbmx, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bbmx = parambbmx;
    this.jdField_a_of_type_JavaLangString = parambbmx.a();
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public bbmf(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.b = anni.a(2131704166);
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
    if (this.jdField_a_of_type_Bbmx != null)
    {
      int i = bbhd.a(this.jdField_a_of_type_Bbmx);
      if (i > 0) {
        return i;
      }
    }
    if ((this.jdField_a_of_type_Bbmx != null) && ((this.jdField_a_of_type_Bbmx instanceof bblv))) {
      return ((bblv)this.jdField_a_of_type_Bbmx).jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public bbmx a()
  {
    return this.jdField_a_of_type_Bbmx;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<bbmy> a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    bbgw localbbgw;
    Object localObject1;
    if ((localContext instanceof bbgw))
    {
      localbbgw = (bbgw)localContext;
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    switch (localbbgw.a())
    {
    default: 
      if (this.jdField_a_of_type_Bbmx != null) {
        this.jdField_a_of_type_Bbmx.a(paramView);
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
        if (((this.jdField_a_of_type_Bbmx instanceof bblv)) && (bbup.a(((bblv)this.jdField_a_of_type_Bbmx).jdField_a_of_type_Long)))
        {
          if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || ((!this.jdField_c_of_type_JavaLangString.startsWith("http://")) && (!this.jdField_c_of_type_JavaLangString.startsWith("https://"))))
          {
            i = 1;
            localObject2 = localbbgw.a();
            String str = "" + a();
            if (i == 0) {
              break label421;
            }
            localObject1 = "1";
            bbup.a("all_result", "more_object", new String[] { localObject2, str, localObject1 });
          }
        }
        else if (!bbhd.jdField_a_of_type_Boolean) {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("project", bbrf.a());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("get_src", "web");
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bbrf.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("clk_more").obj1(a() + "").ver1(localbbgw.a()).ver2(bbrf.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + bbhd.jdField_a_of_type_Long));
          bbup.a("all_result", "clk_tab_more", new String[] { b(), bbup.a(localbbgw.a()), "", bbup.a("dynamic_unite_search.1", localbbgw.a()) });
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
          bbup.a("sub_result", "more_result", new String[] { localbbgw.a(), "" + localbbgw.a(), "" + a(1), bbup.a("dynamic_tab_search.1", localbbgw.a()) });
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
    if ((this.jdField_a_of_type_Bbmx instanceof bblv))
    {
      if (bbup.a(((bblv)this.jdField_a_of_type_Bbmx).jdField_a_of_type_Long)) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Bbmx != null) {
      return this.jdField_a_of_type_Bbmx.b();
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
 * Qualified Name:     bbmf
 * JD-Core Version:    0.7.0.1
 */