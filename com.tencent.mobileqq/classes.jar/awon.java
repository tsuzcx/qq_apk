import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class awon
  extends awoe
{
  public MiniAppLocalSearchEntity a;
  protected String a;
  public int[] a;
  
  public awon(QQAppInterface paramQQAppInterface, int paramInt, MiniAppLocalSearchEntity paramMiniAppLocalSearchEntity, String paramString)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity = paramMiniAppLocalSearchEntity;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected long a(String paramString)
  {
    return 0L;
  }
  
  public CharSequence a()
  {
    return awwa.b(this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appName, this.jdField_a_of_type_JavaLangString, 10, true);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    if ((MiniAppLocalSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(310) != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.showMask != 0) {
        break label314;
      }
      MiniAppLauncher.launchMiniAppById((Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId, null, null, null, null, 1005);
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface;
      JSONObject localJSONObject;
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (awiw.b.containsKey(this))
        {
          paramView = (awix)awiw.b.get(this);
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("project", awsq.a());
        localJSONObject.put("event_src", "client");
        localJSONObject.put("obj_lct", paramView.jdField_a_of_type_Int);
        localJSONObject.put("get_src", "native");
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item").obj1(paramView.jdField_a_of_type_Long + "").obj2(this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId).ver1(paramView.jdField_a_of_type_JavaLangString).ver2(awsq.a(UniteSearchActivity.d));
        if (c())
        {
          paramView = "1";
          awsq.a(null, localReportModelDC02528.ver3(paramView).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
          awwa.b(localQQAppInterface, this.jdField_a_of_type_JavaLangString, this.i, e(), e());
          if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
            break label379;
          }
          awsq.a(null, 0, this.b, "0X8009D31", 3, 0, null, null);
          return;
          label314:
          MiniAppLauncher.launchMiniAppById((Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId, null, null, null, null, 1027);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e(h, 2, "e = " + localJSONException);
          continue;
          paramView = "0";
        }
        label379:
        if ((this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appName != null) && (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appName.equals(this.jdField_a_of_type_JavaLangString)))
        {
          awsq.a(null, 0, this.b, "0X8009D33", 0, 0, this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId, null);
          return;
        }
        awsq.a(null, 0, this.b, "0X8009D45", 0, 0, this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId, null);
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId;
  }
  
  public int c()
  {
    return 0;
  }
  
  public CharSequence c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.desc;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appName;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.showMask & 0x1) != 0;
  }
  
  public int d()
  {
    return 0;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
  
  public int e()
  {
    return 6;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.appId;
  }
  
  public String g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppLocalSearchEntity.iconUrl;
  }
  
  public String h()
  {
    return "https://qzonestyle.gtimg.cn/aoi/sola/20190108152813_orkMRcBegl.png";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awon
 * JD-Core Version:    0.7.0.1
 */