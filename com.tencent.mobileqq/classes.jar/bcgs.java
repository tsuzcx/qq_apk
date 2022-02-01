import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bcgs
  extends bcfk
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public bcgs(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public bcgs(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.d = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
    a();
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchResultModelForEntrance", 2, "extension info:" + this.d);
    }
    if (!TextUtils.isEmpty(this.d)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.d);
      if (localJSONObject.getInt("hideArrow") == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.e = localJSONObject.optString("title1");
        this.jdField_a_of_type_JavaLangString = localJSONObject.optString("title2");
        this.f = localJSONObject.optString("title3");
        this.g = localJSONObject.optString("secondLine");
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public CharSequence a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case -3: 
    case -2: 
    default: 
      return anvx.a(2131713117);
    case -4: 
      return this.e;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (this.jdField_a_of_type_Int)
    {
    case -2: 
    default: 
      localObject1 = this.jdField_b_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = bhey.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), (String)localObject1);
        if (localObject2 == null) {
          break label825;
        }
        ((bheh)localObject2).a();
      }
    case -1: 
      do
      {
        return;
        ActiveEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, anvx.a(2131713102), new long[] { 1001L, 1002L });
        bcnc.a("all_result", "clk_people_group", new String[] { this.jdField_a_of_type_JavaLangString });
        bcnc.a("all_search", "all_result", "clk_user_grp", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, "" });
      } while (!(paramView.getContext() instanceof UniteSearchActivity));
      if (bbzq.b.containsKey(this))
      {
        paramView = (bbzr)bbzq.b.get(this);
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject2 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject2).put("project", bcjs.a());
        ((JSONObject)localObject2).put("event_src", "client");
        ((JSONObject)localObject2).put("obj_lct", paramView.jdField_a_of_type_Int);
        ((JSONObject)localObject2).put("get_src", "native");
        bcjs.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(paramView.jdField_a_of_type_Long + "").obj2(paramView.jdField_b_of_type_JavaLangString).ver1(paramView.jdField_a_of_type_JavaLangString).ver2(bcjs.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject2).toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
        bcjs.a(null, this.v, 0, "0X8009D3F", 0, 0, null, null);
        return;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, "e = " + localJSONException1);
        }
      }
    }
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      switch (((UniteSearchActivity)paramView.getContext()).jdField_a_of_type_Int)
      {
      }
    }
    for (int i = 0;; i = 0)
    {
      for (;;)
      {
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          localObject1 = bcmz.a(this.jdField_a_of_type_JavaLangString, i, "group");
          label480:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            ((Intent)localObject2).putExtra("search_title", this.jdField_a_of_type_JavaLangString);
            paramView.getContext().startActivity((Intent)localObject2);
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break label787;
          }
          localObject1 = this.jdField_a_of_type_JavaLangString;
          bcnc.a("all_result", "clk_net_search", new String[] { localObject1 });
          if ((!(paramView.getContext() instanceof UniteSearchActivity)) || (!bbzq.b.containsKey(this))) {
            break;
          }
          paramView = (bbzr)bbzq.b.get(this);
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject2 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject2).put("project", bcjs.a());
          ((JSONObject)localObject2).put("event_src", "client");
          ((JSONObject)localObject2).put("obj_lct", paramView.jdField_a_of_type_Int);
          ((JSONObject)localObject2).put("get_src", "web");
          bcjs.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(paramView.jdField_a_of_type_Long + "").obj2(paramView.jdField_b_of_type_JavaLangString).ver1(paramView.jdField_a_of_type_JavaLangString).ver2(bcjs.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject2).toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
          return;
          i = 1;
          continue;
          i = 2;
          continue;
          i = 3;
          continue;
          localObject1 = this.jdField_b_of_type_JavaLangString;
          break label480;
          label787:
          localObject1 = "";
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, "e = " + localJSONException2);
          }
        }
      }
      label825:
      if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://"))) {
        break;
      }
      paramView = paramView.getContext();
      localObject2 = new Intent(paramView, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.startActivity((Intent)localObject2);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public CharSequence b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public int c()
  {
    return 0;
  }
  
  public CharSequence c()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case -3: 
    case -2: 
    default: 
      return "";
    case -1: 
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      return bbzh.a(BaseApplicationImpl.getContext(), localQQAppInterface.getCurrentUin());
    }
    return this.g;
  }
  
  public int d()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case -2: 
    case -1: 
    default: 
      return 2131559854;
    }
    return 2131559847;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgs
 * JD-Core Version:    0.7.0.1
 */