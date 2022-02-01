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

public class bcey
  extends bcgz
{
  private bcfq a;
  public String a;
  public boolean a;
  private String b = anzj.a(2131704268);
  public boolean b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public bcey(bcfq parambcfq)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bcfq = parambcfq;
    this.jdField_a_of_type_JavaLangString = parambcfq.a();
    if (parambcfq.a() != null) {
      if (parambcfq.a().size() <= parambcfq.a()) {
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
  
  public bcey(bcfq parambcfq, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bcfq = parambcfq;
    if (TextUtils.isEmpty(paramString)) {}
    for (this.jdField_a_of_type_JavaLangString = parambcfq.a();; this.jdField_a_of_type_JavaLangString = paramString)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public bcey(bcfq parambcfq, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bcfq = parambcfq;
    this.jdField_a_of_type_JavaLangString = parambcfq.a();
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public bcey(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.b = anzj.a(2131704273);
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
    if (this.jdField_a_of_type_Bcfq != null)
    {
      int i = bbzx.a(this.jdField_a_of_type_Bcfq);
      if (i > 0) {
        return i;
      }
    }
    if ((this.jdField_a_of_type_Bcfq != null) && ((this.jdField_a_of_type_Bcfq instanceof bceo))) {
      return ((bceo)this.jdField_a_of_type_Bcfq).jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public bcfq a()
  {
    return this.jdField_a_of_type_Bcfq;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<bcfr> a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    bbzq localbbzq;
    Object localObject1;
    if ((localContext instanceof bbzq))
    {
      localbbzq = (bbzq)localContext;
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    switch (localbbzq.a())
    {
    default: 
      if (this.jdField_a_of_type_Bcfq != null) {
        this.jdField_a_of_type_Bcfq.a(paramView);
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
        if (((this.jdField_a_of_type_Bcfq instanceof bceo)) && (bcni.a(((bceo)this.jdField_a_of_type_Bcfq).jdField_a_of_type_Long)))
        {
          if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || ((!this.jdField_c_of_type_JavaLangString.startsWith("http://")) && (!this.jdField_c_of_type_JavaLangString.startsWith("https://"))))
          {
            i = 1;
            localObject2 = localbbzq.a();
            String str = "" + a();
            if (i == 0) {
              break label421;
            }
            localObject1 = "1";
            bcni.a("all_result", "more_object", new String[] { localObject2, str, localObject1 });
          }
        }
        else if (!bbzx.jdField_a_of_type_Boolean) {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("project", bcjy.a());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("get_src", "web");
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bcjy.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("clk_more").obj1(a() + "").ver1(localbbzq.a()).ver2(bcjy.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
          bcni.a("all_result", "clk_tab_more", new String[] { b(), bcni.a(localbbzq.a()), "", bcni.a("dynamic_unite_search.1", localbbzq.a()) });
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
          bcni.a("sub_result", "more_result", new String[] { localbbzq.a(), "" + localbbzq.a(), "" + a(1), bcni.a("dynamic_tab_search.1", localbbzq.a()) });
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
    if ((this.jdField_a_of_type_Bcfq instanceof bceo))
    {
      if (bcni.a(((bceo)this.jdField_a_of_type_Bcfq).jdField_a_of_type_Long)) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Bcfq != null) {
      return this.jdField_a_of_type_Bcfq.b();
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
 * Qualified Name:     bcey
 * JD-Core Version:    0.7.0.1
 */