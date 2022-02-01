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
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class bcfs
  extends bcfk
{
  public static final String c;
  private int jdField_a_of_type_Int;
  public long a;
  public bcft a;
  public bcmr a;
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
    jdField_c_of_type_JavaLangString = "Q.uniteSearch." + bcfs.class.getName();
  }
  
  public bcfs(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
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
    this.jdField_a_of_type_Bcmr = new bcmr(paramList, a());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public bcfs(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
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
    this.jdField_a_of_type_Bcmr = new bcmr(paramList, a());
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
    bbzr localbbzr;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (bbzq.b.containsKey(this))
    {
      localbbzr = (bbzr)bbzq.b.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", bcjs.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localbbzr.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "web");
      localJSONObject.put("tepl", this.f);
      Object localObject1 = "clk_item";
      if ((this instanceof bcgg)) {
        localObject1 = "clk_more";
      }
      bcjs.a(null, new ReportModelDC02528().module("all_result").action((String)localObject1).obj1(this.jdField_a_of_type_Long + "").obj2(localbbzr.jdField_b_of_type_JavaLangString).ver1(this.g).ver2(bcjs.a(this.jdField_c_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
      if (bbzq.jdField_a_of_type_JavaUtilHashMap.containsKey(this))
      {
        localObject1 = (bbzr)bbzq.jdField_a_of_type_JavaUtilHashMap.get(this);
        if (((bbzr)localObject1).jdField_b_of_type_Boolean)
        {
          j = 2;
          bcnc.a("all_result", "clk_object", j, 0, new String[] { this.g, "" + this.jdField_a_of_type_Long, ((bbzr)localObject1).jdField_b_of_type_JavaLangString + "", ((bbzr)localObject1).jdField_a_of_type_Int + "" });
        }
      }
      else
      {
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label561;
        }
        localObject1 = bhey.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), (String)localObject3);
        if (localObject1 == null) {
          break label437;
        }
        ((bheh)localObject1).a();
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
          QZoneHelper.reportIfIsFromQZone((String)localObject3);
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
          bcnc.a(paramView.getContext(), Integer.valueOf(this.d).intValue(), -1);
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
            weg.a(paramView.getContext(), 24, l1);
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
      TroopUtils.openTroopInfoActivity(paramView.getContext(), localBundle, 2);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    this.jdField_a_of_type_Bcft = new bcft(this);
    int j = paramJSONObject.optInt("imageType");
    this.jdField_a_of_type_Bcft.jdField_a_of_type_JavaLangString = paramJSONObject.optString("imageUrl");
    this.jdField_a_of_type_Bcft.jdField_a_of_type_Int = a(j);
    this.jdField_a_of_type_Bcft.jdField_b_of_type_Int = paramJSONObject.optInt("cornerRadius");
    bcft localbcft = this.jdField_a_of_type_Bcft;
    if (paramJSONObject.optInt("needPlayIcon") == 1) {}
    for (;;)
    {
      localbcft.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Bcft.jdField_a_of_type_JavaLangCharSequence = paramJSONObject.optString("topLeftTagText");
      this.jdField_a_of_type_Bcft.jdField_b_of_type_JavaLangString = paramJSONObject.optString("topLeftTagColor");
      this.jdField_a_of_type_Bcft.jdField_b_of_type_JavaLangCharSequence = paramJSONObject.optString("bottomRightText");
      this.jdField_a_of_type_Bcft.jdField_c_of_type_JavaLangString = paramJSONObject.optString("bottomRightIconUrl");
      this.jdField_a_of_type_Bcft.jdField_c_of_type_JavaLangCharSequence = paramJSONObject.optString("bottomRightIconText");
      this.jdField_a_of_type_Bcft.d = paramJSONObject.optInt("imageHeight");
      this.jdField_a_of_type_Bcft.jdField_c_of_type_Int = paramJSONObject.optInt("imageWidth");
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
      return 2131559867;
    case 3: 
      return 2131559883;
    case 4: 
      return 2131559868;
    case 6: 
      return 2131559882;
    case 7: 
      return 2131559871;
    case 8: 
      return 2131559879;
    case 9: 
      return 2131559880;
    case 11: 
      return 2131559870;
    case 12: 
      return 2131559869;
    case 13: 
      return 2131559873;
    case 14: 
      return 2131559881;
    case 15: 
      return 2131559877;
    case 16: 
      return 2131559858;
    case 17: 
      return 2131561472;
    }
    return 2131562820;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfs
 * JD-Core Version:    0.7.0.1
 */