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

public class awnp
  extends awpq
{
  private awoh a;
  public String a;
  public boolean a;
  private String b = ajya.a(2131705376);
  public boolean b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public awnp(awoh paramawoh)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Awoh = paramawoh;
    this.jdField_a_of_type_JavaLangString = paramawoh.a();
    if (paramawoh.a() != null) {
      if (paramawoh.a().size() <= paramawoh.a()) {
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
  
  public awnp(awoh paramawoh, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Awoh = paramawoh;
    if (TextUtils.isEmpty(paramString)) {}
    for (this.jdField_a_of_type_JavaLangString = paramawoh.a();; this.jdField_a_of_type_JavaLangString = paramString)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public awnp(awoh paramawoh, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Awoh = paramawoh;
    this.jdField_a_of_type_JavaLangString = paramawoh.a();
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public awnp(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    if (TextUtils.isEmpty(paramString2)) {
      this.b = ajya.a(2131705381);
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
    if (this.jdField_a_of_type_Awoh != null)
    {
      int i = awiw.a(this.jdField_a_of_type_Awoh);
      if (i > 0) {
        return i;
      }
    }
    if ((this.jdField_a_of_type_Awoh != null) && ((this.jdField_a_of_type_Awoh instanceof awnf))) {
      return ((awnf)this.jdField_a_of_type_Awoh).jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public awoh a()
  {
    return this.jdField_a_of_type_Awoh;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<awoi> a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    awip localawip;
    Object localObject1;
    if ((localContext instanceof awip))
    {
      localawip = (awip)localContext;
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    switch (localawip.a())
    {
    default: 
      if (this.jdField_a_of_type_Awoh != null) {
        this.jdField_a_of_type_Awoh.a(paramView);
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
        if (((this.jdField_a_of_type_Awoh instanceof awnf)) && (awwa.a(((awnf)this.jdField_a_of_type_Awoh).jdField_a_of_type_Long)))
        {
          if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || ((!this.jdField_c_of_type_JavaLangString.startsWith("http://")) && (!this.jdField_c_of_type_JavaLangString.startsWith("https://"))))
          {
            i = 1;
            localObject2 = localawip.a();
            String str = "" + a();
            if (i == 0) {
              break label421;
            }
            localObject1 = "1";
            awwa.a("all_result", "more_object", new String[] { localObject2, str, localObject1 });
          }
        }
        else if (!awiw.jdField_a_of_type_Boolean) {
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("project", awsq.a());
          ((JSONObject)localObject1).put("event_src", "client");
          ((JSONObject)localObject1).put("get_src", "web");
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          awsq.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("clk_more").obj1(a() + "").ver1(localawip.a()).ver2(awsq.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
          awwa.a("all_result", "clk_tab_more", new String[] { b(), awwa.a(localawip.a()), "", awwa.a("dynamic_unite_search.1", localawip.a()) });
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
          awwa.a("sub_result", "more_result", new String[] { localawip.a(), "" + localawip.a(), "" + a(1), awwa.a("dynamic_tab_search.1", localawip.a()) });
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
    if ((this.jdField_a_of_type_Awoh instanceof awnf))
    {
      if (awwa.a(((awnf)this.jdField_a_of_type_Awoh).jdField_a_of_type_Long)) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Awoh != null) {
      return this.jdField_a_of_type_Awoh.b();
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
 * Qualified Name:     awnp
 * JD-Core Version:    0.7.0.1
 */