import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class avow
  extends avoo
{
  public static final String c;
  private int jdField_a_of_type_Int;
  public long a;
  public avox a;
  public avvu a;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private List<Object> jdField_a_of_type_JavaUtilList;
  public boolean a;
  public List<String> b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  static
  {
    jdField_c_of_type_JavaLangString = "Q.uniteSearch." + avow.class.getName();
  }
  
  public avow(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    if (paramResultItem != null)
    {
      this.d = paramResultItem.result_id.get().toStringUtf8();
      this.jdField_a_of_type_Int = paramResultItem.layout_id.get();
      this.h = paramResultItem.extension.get().toStringUtf8();
      this.jdField_a_of_type_JavaLangString = paramResultItem.layout_content.get().toStringUtf8();
      this.e = paramResultItem.jmp_url.get().toStringUtf8();
      if (paramResultItem.group_mask.has()) {
        paramLong = paramResultItem.group_mask.get();
      }
      this.jdField_a_of_type_Long = paramLong;
      if (paramResultItem.sub_result_items.has())
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.addAll(paramResultItem.sub_result_items.get());
      }
      this.f = paramResultItem.report_ext_data.get().toStringUtf8();
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangObject = paramResultItem;
    this.b = paramList;
    this.g = paramString;
    this.jdField_a_of_type_Avvu = new avvu(paramList, a());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public avow(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    if (paramResultItem != null)
    {
      this.d = paramResultItem.result_id.get().toStringUtf8();
      this.jdField_a_of_type_Int = paramResultItem.layout_id.get();
      this.h = paramResultItem.extension.get().toStringUtf8();
      this.jdField_a_of_type_JavaLangString = paramResultItem.layout_content.get().toStringUtf8();
      this.e = paramResultItem.jmp_url.get().toStringUtf8();
      if (paramResultItem.group_mask.has()) {
        paramLong = paramResultItem.group_mask.get();
      }
      this.jdField_a_of_type_Long = paramLong;
      if (paramResultItem.sub_result_items.has())
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.addAll(paramResultItem.sub_result_items.get());
      }
      this.f = paramResultItem.report_ext_data.get().toStringUtf8();
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangObject = paramResultItem;
    this.b = paramList;
    this.g = paramString;
    this.jdField_a_of_type_Avvu = new avvu(paramList, a());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  public CharSequence a()
  {
    return null;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.g;
  }
  
  public void a(View paramView)
  {
    Object localObject3 = this.e;
    avjc localavjc;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (avjb.b.containsKey(this))
    {
      localavjc = (avjc)avjb.b.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", avsv.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localavjc.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      localJSONObject.put("tepl", this.f);
      Object localObject1 = "clk_item";
      if ((this instanceof avpk)) {
        localObject1 = "clk_more";
      }
      avsv.a(null, new ReportModelDC02528().module("all_result").action((String)localObject1).obj1(this.jdField_a_of_type_Long + "").obj2(localavjc.jdField_b_of_type_JavaLangString).ver1(this.g).ver2(avsv.a(this.jdField_c_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + avjb.jdField_a_of_type_Long));
      if (avjb.jdField_a_of_type_JavaUtilHashMap.containsKey(this))
      {
        localObject1 = (avjc)avjb.jdField_a_of_type_JavaUtilHashMap.get(this);
        if (((avjc)localObject1).jdField_b_of_type_Boolean)
        {
          j = 2;
          avwf.a("all_result", "clk_object", j, 0, new String[] { this.g, "" + this.jdField_a_of_type_Long, ((avjc)localObject1).jdField_b_of_type_JavaLangString + "", ((avjc)localObject1).jdField_a_of_type_Int + "" });
        }
      }
      else
      {
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label561;
        }
        localObject1 = bade.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), (String)localObject3);
        if (localObject1 == null) {
          break label437;
        }
        ((bacn)localObject1).c();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      label437:
      do
      {
        for (;;)
        {
          QLog.e(jdField_c_of_type_JavaLangString, 2, "e = " + localJSONException);
          continue;
          int j = 1;
        }
        Object localObject2;
        if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
        {
          bfpr.a((String)localObject3);
          paramView = paramView.getContext();
          localObject2 = new Intent(paramView, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject3);
          paramView.startActivity((Intent)localObject2);
          return;
        }
        if (((String)localObject3).startsWith("tel://"))
        {
          localObject2 = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((String)localObject3).substring(6)));
          paramView.getContext().startActivity((Intent)localObject2);
        }
        if (this.jdField_a_of_type_Long == 268435456L)
        {
          avwf.a(paramView.getContext(), Integer.valueOf(this.d).intValue(), -1);
          return;
        }
        if (this.jdField_a_of_type_Long == 1001L)
        {
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject3 = new SearchResultItem();
          ((SearchResultItem)localObject3).jdField_a_of_type_Long = Long.valueOf(this.d).longValue();
          ((SearchResultItem)localObject3).jdField_a_of_type_JavaLangString = a().toString();
          AddFriendActivity.a((Activity)paramView.getContext(), (SearchResultItem)localObject3, (QQAppInterface)localObject2, true, 1);
          return;
        }
        if (this.jdField_a_of_type_Long == 536870912L)
        {
          long l2 = 0L;
          try
          {
            l1 = Long.valueOf(new JSONObject(this.h).optString("proid")).longValue();
            skt.a(paramView.getContext(), 24, l1);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.e(jdField_c_of_type_JavaLangString, 2, localException, new Object[0]);
                l1 = l2;
              }
            }
          }
        }
      } while (this.jdField_a_of_type_Long != 1002L);
      label561:
      Bundle localBundle = TroopInfoActivity.a(this.d, 2);
      localBundle.putInt("exposureSource", 3);
      localBundle.putInt("t_s_f", 1000);
      azlj.a(paramView.getContext(), localBundle, 2);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    this.jdField_a_of_type_Avox = new avox(this);
    int j = paramJSONObject.optInt("imageType");
    this.jdField_a_of_type_Avox.jdField_a_of_type_JavaLangString = paramJSONObject.optString("imageUrl");
    this.jdField_a_of_type_Avox.jdField_a_of_type_Int = a(j);
    this.jdField_a_of_type_Avox.jdField_b_of_type_Int = paramJSONObject.optInt("cornerRadius");
    avox localavox = this.jdField_a_of_type_Avox;
    if (paramJSONObject.optInt("needPlayIcon") == 1) {}
    for (;;)
    {
      localavox.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Avox.jdField_a_of_type_JavaLangCharSequence = paramJSONObject.optString("topLeftTagText");
      this.jdField_a_of_type_Avox.jdField_b_of_type_JavaLangString = paramJSONObject.optString("topLeftTagColor");
      this.jdField_a_of_type_Avox.jdField_b_of_type_JavaLangCharSequence = paramJSONObject.optString("bottomRightText");
      this.jdField_a_of_type_Avox.jdField_c_of_type_JavaLangString = paramJSONObject.optString("bottomRightIconUrl");
      this.jdField_a_of_type_Avox.jdField_c_of_type_JavaLangCharSequence = paramJSONObject.optString("bottomRightIconText");
      this.jdField_a_of_type_Avox.d = paramJSONObject.optInt("imageHeight");
      this.jdField_a_of_type_Avox.jdField_c_of_type_Int = paramJSONObject.optInt("imageWidth");
      return;
      bool = false;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return null;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    return null;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public int e()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 5: 
    case 10: 
    default: 
      throw new RuntimeException(this.jdField_a_of_type_Int + "in NetSearchTemplateBaseItem.getLayoutId() is not supported!!!");
    case 2: 
      return 2131494055;
    case 3: 
      return 2131494071;
    case 4: 
      return 2131494056;
    case 6: 
      return 2131494070;
    case 7: 
      return 2131494059;
    case 8: 
      return 2131494067;
    case 9: 
      return 2131494068;
    case 11: 
      return 2131494058;
    case 12: 
      return 2131494057;
    case 13: 
      return 2131494061;
    case 14: 
      return 2131494069;
    case 15: 
      return 2131494065;
    case 16: 
      return 2131494045;
    case 17: 
      return 2131495471;
    }
    return 2131496776;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avow
 * JD-Core Version:    0.7.0.1
 */