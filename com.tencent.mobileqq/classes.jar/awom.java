import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.activity.MessageSearchDetailActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class awom
  extends awoj
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FullMessageSearchResult.SearchResultItem jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private String jdField_b_of_type_JavaLangString;
  
  public awom(QQAppInterface paramQQAppInterface, String paramString, FullMessageSearchResult.SearchResultItem paramSearchResultItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem = paramSearchResultItem;
    int i;
    if (paramSearchResultItem.user.getType() == 3000)
    {
      i = ((ajvi)paramQQAppInterface.getManager(53)).a(paramSearchResultItem.user.uin);
      if (i <= 0) {
        this.jdField_b_of_type_JavaLangString = "";
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_JavaLangString = String.valueOf(i);
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.uin, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType());
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    awix localawix;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (awiw.b.containsKey(this)))
    {
      localawix = (awix)awiw.b.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", awsq.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", localawix.jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      awsq.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(localawix.jdField_a_of_type_Long + "").obj2(localawix.jdField_b_of_type_JavaLangString).ver1(localawix.jdField_a_of_type_JavaLangString).ver2(awsq.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
      if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageMessageUniseq.size() == 1)
      {
        ahpd.jdField_a_of_type_Boolean = true;
        ahpd.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageList.get(0);
        ahpd.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.uin, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType(), bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.uin, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType()), false);
        akgb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        awwa.a(this.jdField_a_of_type_JavaLangString, 40, paramView, false);
        awwa.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("MessageSearchResultModel", 2, "e = " + localJSONException);
        continue;
        MessageSearchDetailActivity.a(paramView.getContext(), a(), this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem);
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType() == 3000) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      return awwa.a(this.jdField_b_of_type_JavaLangString);
    }
    return "";
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.uin;
  }
  
  public int c()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("MessageSearchResultModel", 2, "Face type is illegal. type = " + this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.user.getType());
      }
    case 0: 
      return 1;
    case 1: 
      return 4;
    }
    return 101;
  }
  
  public CharSequence c()
  {
    int i;
    if (this.jdField_b_of_type_JavaLangCharSequence == null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageMessageUniseq.size();
      if (i != 1) {
        break label60;
      }
    }
    label60:
    SpannableStringBuilder localSpannableStringBuilder;
    for (this.jdField_b_of_type_JavaLangCharSequence = awwa.a(((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem.secondPageList.get(0)).msg, this.jdField_a_of_type_JavaLangString);; this.jdField_b_of_type_JavaLangCharSequence = localSpannableStringBuilder)
    {
      return this.jdField_b_of_type_JavaLangCharSequence;
      localSpannableStringBuilder = new SpannableStringBuilder(i + ajya.a(2131706673) + "\"");
      localSpannableStringBuilder.append(awwa.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      localSpannableStringBuilder.append("\"").append("相关记录");
    }
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awom
 * JD-Core Version:    0.7.0.1
 */