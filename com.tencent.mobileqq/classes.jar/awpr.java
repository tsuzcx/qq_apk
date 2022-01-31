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

public class awpr
  extends awoj
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
  
  public awpr(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public awpr(String paramString1, String paramString2, int paramInt, String paramString3)
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
      return ajya.a(2131713666);
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
        localObject2 = bbex.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), (String)localObject1);
        if (localObject2 == null) {
          break label825;
        }
        ((bbeg)localObject2).c();
      }
    case -1: 
      do
      {
        return;
        ActiveEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, ajya.a(2131713651), new long[] { 1001L, 1002L });
        awwa.a("all_result", "clk_people_group", new String[] { this.jdField_a_of_type_JavaLangString });
        awwa.a("all_search", "all_result", "clk_user_grp", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, "" });
      } while (!(paramView.getContext() instanceof UniteSearchActivity));
      if (awiw.b.containsKey(this))
      {
        paramView = (awix)awiw.b.get(this);
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject2 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject2).put("project", awsq.a());
        ((JSONObject)localObject2).put("event_src", "client");
        ((JSONObject)localObject2).put("obj_lct", paramView.jdField_a_of_type_Int);
        ((JSONObject)localObject2).put("get_src", "native");
        awsq.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(paramView.jdField_a_of_type_Long + "").obj2(paramView.jdField_b_of_type_JavaLangString).ver1(paramView.jdField_a_of_type_JavaLangString).ver2(awsq.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject2).toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
        awsq.a(null, this.s, 0, "0X8009D3F", 0, 0, null, null);
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
          localObject1 = awvx.a(this.jdField_a_of_type_JavaLangString, i, "group");
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
          awwa.a("all_result", "clk_net_search", new String[] { localObject1 });
          if ((!(paramView.getContext() instanceof UniteSearchActivity)) || (!awiw.b.containsKey(this))) {
            break;
          }
          paramView = (awix)awiw.b.get(this);
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject2 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject2).put("project", awsq.a());
          ((JSONObject)localObject2).put("event_src", "client");
          ((JSONObject)localObject2).put("obj_lct", paramView.jdField_a_of_type_Int);
          ((JSONObject)localObject2).put("get_src", "web");
          awsq.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(paramView.jdField_a_of_type_Long + "").obj2(paramView.jdField_b_of_type_JavaLangString).ver1(paramView.jdField_a_of_type_JavaLangString).ver2(awsq.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject2).toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
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
      return awin.a(BaseApplicationImpl.getContext(), localQQAppInterface.c());
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
      return 2131559613;
    }
    return 2131559606;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpr
 * JD-Core Version:    0.7.0.1
 */