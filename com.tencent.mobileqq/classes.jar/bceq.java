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

public class bceq
  extends bcgr
{
  private bcfi a;
  public String a;
  public boolean a;
  private String b = anvx.a(2131704849);
  public boolean b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public bceq(bcfi parambcfi)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bcfi = parambcfi;
    this.jdField_a_of_type_JavaLangString = parambcfi.a();
    if (parambcfi.a() != null) {
      if (parambcfi.a().size() <= parambcfi.a()) {
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
  
  public bceq(bcfi parambcfi, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bcfi = parambcfi;
    if (TextUtils.isEmpty(paramString)) {}
    for (this.jdField_a_of_type_JavaLangString = parambcfi.a();; this.jdField_a_of_type_JavaLangString = paramString)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public bceq(bcfi parambcfi, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bcfi = parambcfi;
    this.jdField_a_of_type_JavaLangString = parambcfi.a();
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public bceq(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.b = anvx.a(2131704854);
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
    if (this.jdField_a_of_type_Bcfi != null)
    {
      int i = bbzq.a(this.jdField_a_of_type_Bcfi);
      if (i > 0) {
        return i;
      }
    }
    if ((this.jdField_a_of_type_Bcfi != null) && ((this.jdField_a_of_type_Bcfi instanceof bceg))) {
      return ((bceg)this.jdField_a_of_type_Bcfi).jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public bcfi a()
  {
    return this.jdField_a_of_type_Bcfi;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<bcfj> a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    bbzj localbbzj;
    Object localObject1;
    if ((localContext instanceof bbzj))
    {
      localbbzj = (bbzj)localContext;
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    switch (localbbzj.a())
    {
    default: 
      if (this.jdField_a_of_type_Bcfi != null) {
        this.jdField_a_of_type_Bcfi.a(paramView);
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
        if (((this.jdField_a_of_type_Bcfi instanceof bceg)) && (bcnc.a(((bceg)this.jdField_a_of_type_Bcfi).jdField_a_of_type_Long)))
        {
          if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || ((!this.jdField_c_of_type_JavaLangString.startsWith("http://")) && (!this.jdField_c_of_type_JavaLangString.startsWith("https://"))))
          {
            i = 1;
            localObject2 = localbbzj.a();
            String str = "" + a();
            if (i == 0) {
              break label421;
            }
            localObject1 = "1";
            bcnc.a("all_result", "more_object", new String[] { localObject2, str, localObject1 });
          }
        }
        else if (!bbzq.jdField_a_of_type_Boolean) {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("project", bcjs.a());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("get_src", "web");
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bcjs.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("clk_more").obj1(a() + "").ver1(localbbzj.a()).ver2(bcjs.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
          bcnc.a("all_result", "clk_tab_more", new String[] { b(), bcnc.a(localbbzj.a()), "", bcnc.a("dynamic_unite_search.1", localbbzj.a()) });
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
          bcnc.a("sub_result", "more_result", new String[] { localbbzj.a(), "" + localbbzj.a(), "" + a(1), bcnc.a("dynamic_tab_search.1", localbbzj.a()) });
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
    if ((this.jdField_a_of_type_Bcfi instanceof bceg))
    {
      if (bcnc.a(((bceg)this.jdField_a_of_type_Bcfi).jdField_a_of_type_Long)) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Bcfi != null) {
      return this.jdField_a_of_type_Bcfi.b();
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
 * Qualified Name:     bceq
 * JD-Core Version:    0.7.0.1
 */