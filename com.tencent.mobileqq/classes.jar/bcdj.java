import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bcdj
  extends bccy
{
  protected String c;
  private String d;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  
  public bcdj(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<String> paramArrayList, List<FTSMessage> paramList, String paramString3, CharSequence paramCharSequence)
  {
    super(paramQQAppInterface, paramString1, paramString2, paramArrayList, paramList);
    paramString1 = (FTSMessage)paramList.get(0);
    this.jdField_d_of_type_JavaLangString = String.valueOf(paramString1.uin);
    this.jdField_e_of_type_JavaLangString = paramString1.senderuin;
    this.jdField_e_of_type_Int = paramString1.istroop;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    int i;
    if (this.jdField_e_of_type_Int == 3000)
    {
      i = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.jdField_d_of_type_JavaLangString);
      if (i <= 0) {
        this.f = "";
      }
    }
    else
    {
      return;
    }
    this.f = String.valueOf(i);
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = ContactUtils.getNick(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public void a(View paramView)
  {
    Object localObject1;
    Object localObject2;
    JSONObject localJSONObject;
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      if (bbzq.b.containsKey(this))
      {
        localObject1 = (bbzr)bbzq.b.get(this);
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("project", bcjs.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", ((bbzr)localObject1).jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      bcjs.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((bbzr)localObject1).jdField_a_of_type_Long + "").obj2(((bbzr)localObject1).jdField_b_of_type_JavaLangString).ver1(((bbzr)localObject1).jdField_a_of_type_JavaLangString).ver2(bcjs.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + bbzq.jdField_a_of_type_Long));
      bcjs.a(null, this.v, 0, "0X8009D4D", 0, 0, null, null);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_JavaLangCharSequence = bhkf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, this.jdField_e_of_type_JavaLangString);
      }
      localObject1 = (Integer)paramView.getTag(2131381184);
      localObject2 = (Integer)paramView.getTag(2131381182);
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (((Integer)localObject1).intValue() >= 0) && (((Integer)localObject2).intValue() >= 0))
      {
        bcnc.a("all_result", "clk_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString, "" + localObject2, "" + (((Integer)localObject1).intValue() + 1) });
        if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
          break label699;
        }
        bhkg.f = 1;
        bhkg.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
        bhkg.g = this.jdField_e_of_type_Int;
        bhkg.h = this.jdField_b_of_type_Int;
        bhkg.i = this.jdField_c_of_type_Int;
        bhkg.j = this.jdField_d_of_type_Int;
        bhkf.a(paramView);
        if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
          break label725;
        }
        alik.jdField_a_of_type_Boolean = true;
        localObject1 = (FTSMessage)this.jdField_a_of_type_JavaUtilList.get(0);
        if (((FTSMessage)localObject1).msgExts != null)
        {
          if ((((FTSMessage)localObject1).istroop != 1) && (((FTSMessage)localObject1).istroop != 3000)) {
            break label706;
          }
          alik.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)((FTSMessage)localObject1).msgExts).shmsgseq;
        }
        aode.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        alik.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, (String)this.jdField_a_of_type_JavaLangCharSequence, false);
        bcnc.a(this.jdField_a_of_type_JavaLangString, 40, paramView, false);
        bcnc.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("FTSMessageSearchResultModel", 2, "e = " + localJSONException);
        continue;
        if ((paramView.getContext() instanceof FTSEntitySearchDetailActivity))
        {
          bcnc.a("talk", "clk_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString, "" + localObject2, "" + (((Integer)localObject1).intValue() + 1) });
          continue;
          label699:
          bhkg.f = 2;
          continue;
          label706:
          alik.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)((FTSMessage)localObject1).msgExts).time;
          continue;
          label725:
          FTSEntitySearchDetailActivity.a(paramView.getContext(), a(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_JavaUtilList, 1, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int);
        }
      }
    }
  }
  
  public CharSequence b()
  {
    if ((this.jdField_e_of_type_Int == 3000) && (!TextUtils.isEmpty(this.f))) {
      return bcnc.a(this.f);
    }
    return "";
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public int c()
  {
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("FTSMessageSearchResultModel", 2, "Face type is illegal. type = " + this.jdField_e_of_type_Int);
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
    if (this.jdField_d_of_type_JavaLangCharSequence == null)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i == 1) {
        this.jdField_d_of_type_JavaLangCharSequence = bcnc.a(((FTSEntity)this.jdField_a_of_type_JavaUtilList.get(0)).mContent, ((FTSEntity)this.jdField_a_of_type_JavaUtilList.get(0)).mProximityStart, this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    else
    {
      return this.jdField_d_of_type_JavaLangCharSequence;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(i + anvx.a(2131704431) + "\"");
    if ((this.jdField_c_of_type_JavaLangString != null) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))) {
      localSpannableStringBuilder.append(bcnc.a(this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString));
    }
    for (;;)
    {
      localSpannableStringBuilder.append("\"").append("相关记录");
      this.jdField_d_of_type_JavaLangCharSequence = localSpannableStringBuilder;
      break;
      localSpannableStringBuilder.append(bcnc.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public CharSequence e()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_b_of_type_JavaLangCharSequence == null) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof FTSMessage)))
    {
      CharSequence localCharSequence = ((FTSMessage)this.jdField_a_of_type_JavaUtilList.get(0)).matchTitle;
      if (localCharSequence != null) {
        this.jdField_b_of_type_JavaLangCharSequence = localCharSequence;
      }
    }
    return this.jdField_b_of_type_JavaLangCharSequence;
  }
  
  public CharSequence f()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_c_of_type_JavaLangCharSequence == null) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof FTSMessage)))
    {
      CharSequence localCharSequence = ((FTSMessage)this.jdField_a_of_type_JavaUtilList.get(0)).matchSecondTitle;
      if (localCharSequence != null) {
        this.jdField_c_of_type_JavaLangCharSequence = localCharSequence;
      }
    }
    return this.jdField_c_of_type_JavaLangCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdj
 * JD-Core Version:    0.7.0.1
 */