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

public class avnu
  extends avpv
{
  private avom a;
  public String a;
  public boolean a;
  private String jdField_b_of_type_JavaLangString = ajjy.a(2131639580);
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public avnu(avom paramavom)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Avom = paramavom;
    this.jdField_a_of_type_JavaLangString = paramavom.a();
    if (paramavom.a() != null) {
      if (paramavom.a().size() <= paramavom.a()) {
        break label70;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
      label70:
      bool = false;
    }
  }
  
  public avnu(avom paramavom, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Avom = paramavom;
    if (TextUtils.isEmpty(paramString)) {}
    for (this.jdField_a_of_type_JavaLangString = paramavom.a();; this.jdField_a_of_type_JavaLangString = paramString)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public avnu(avom paramavom, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Avom = paramavom;
    this.jdField_a_of_type_JavaLangString = paramavom.a();
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  public avnu(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.jdField_b_of_type_JavaLangString = ajjy.a(2131639585);
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
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
    if (this.jdField_a_of_type_Avom != null)
    {
      int i = avjb.a(this.jdField_a_of_type_Avom);
      if (i > 0) {
        return i;
      }
    }
    if ((this.jdField_a_of_type_Avom != null) && ((this.jdField_a_of_type_Avom instanceof avnk))) {
      return ((avnk)this.jdField_a_of_type_Avom).jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public avom a()
  {
    return this.jdField_a_of_type_Avom;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<avon> a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    aviu localaviu;
    Object localObject1;
    if ((localContext instanceof aviu))
    {
      localaviu = (aviu)localContext;
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    switch (localaviu.a())
    {
    default: 
      if (this.jdField_a_of_type_Avom != null) {
        this.jdField_a_of_type_Avom.a(paramView);
      }
      break;
    }
    label144:
    label421:
    while (!this.jdField_b_of_type_Boolean)
    {
      for (;;)
      {
        return;
        int i;
        Object localObject2;
        if (((this.jdField_a_of_type_Avom instanceof avnk)) && (avwf.a(((avnk)this.jdField_a_of_type_Avom).jdField_a_of_type_Long)))
        {
          if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || ((!this.jdField_c_of_type_JavaLangString.startsWith("http://")) && (!this.jdField_c_of_type_JavaLangString.startsWith("https://"))))
          {
            i = 1;
            localObject2 = localaviu.a();
            String str = "" + a();
            if (i == 0) {
              break label421;
            }
            localObject1 = "1";
            avwf.a("all_result", "more_object", new String[] { localObject2, str, localObject1 });
          }
        }
        else if (!avjb.jdField_a_of_type_Boolean) {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("project", avsv.a());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("get_src", "web");
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          avsv.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("clk_more").obj1(a() + "").ver1(localaviu.a()).ver2(avsv.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
          avwf.a("all_result", "clk_tab_more", new String[] { b(), avwf.a(localaviu.a()), "", avwf.a("dynamic_unite_search.1", localaviu.a()) });
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
          avwf.a("sub_result", "more_result", new String[] { localaviu.a(), "" + localaviu.a(), "" + a(1), avwf.a("dynamic_tab_search.1", localaviu.a()) });
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
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Avom instanceof avnk))
    {
      if (avwf.a(((avnk)this.jdField_a_of_type_Avom).jdField_a_of_type_Long)) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Avom != null) {
      return this.jdField_a_of_type_Avom.b();
    }
    return null;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public String c()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {
      return "";
    }
    return this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avnu
 * JD-Core Version:    0.7.0.1
 */