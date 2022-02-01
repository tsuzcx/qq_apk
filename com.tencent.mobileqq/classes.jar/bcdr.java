import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bcdr
  extends bcdg
{
  protected String c;
  private String d;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  
  public bcdr(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<String> paramArrayList, List<FTSMessage> paramList, String paramString3, CharSequence paramCharSequence)
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
      i = ((anws)paramQQAppInterface.getManager(53)).a(this.jdField_d_of_type_JavaLangString);
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
      this.jdField_a_of_type_JavaLangCharSequence = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public void a(View paramView)
  {
    Object localObject1;
    Object localObject2;
    JSONObject localJSONObject;
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      if (bbzx.b.containsKey(this))
      {
        localObject1 = (bbzy)bbzx.b.get(this);
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("project", bcjy.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", ((bbzy)localObject1).jdField_a_of_type_Int);
      localJSONObject.put("get_src", "native");
      bcjy.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((bbzy)localObject1).jdField_a_of_type_Long + "").obj2(((bbzy)localObject1).jdField_b_of_type_JavaLangString).ver1(((bbzy)localObject1).jdField_a_of_type_JavaLangString).ver2(bcjy.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
      bcjy.a(null, this.v, 0, "0X8009D4D", 0, 0, null, null);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_JavaLangCharSequence = bhut.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, this.jdField_e_of_type_JavaLangString);
      }
      localObject1 = (Integer)paramView.getTag(2131381110);
      localObject2 = (Integer)paramView.getTag(2131381108);
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (((Integer)localObject1).intValue() >= 0) && (((Integer)localObject2).intValue() >= 0))
      {
        bcni.a("all_result", "clk_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString, "" + localObject2, "" + (((Integer)localObject1).intValue() + 1) });
        if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
          break label699;
        }
        bhuu.f = 1;
        bhuu.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
        bhuu.g = this.jdField_e_of_type_Int;
        bhuu.h = this.jdField_b_of_type_Int;
        bhuu.i = this.jdField_c_of_type_Int;
        bhuu.j = this.jdField_d_of_type_Int;
        bhut.a(paramView);
        if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
          break label725;
        }
        alpb.jdField_a_of_type_Boolean = true;
        localObject1 = (FTSMessage)this.jdField_a_of_type_JavaUtilList.get(0);
        if (((FTSMessage)localObject1).msgExts != null)
        {
          if ((((FTSMessage)localObject1).istroop != 1) && (((FTSMessage)localObject1).istroop != 3000)) {
            break label706;
          }
          alpb.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)((FTSMessage)localObject1).msgExts).shmsgseq;
        }
        aoha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        alpb.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, (String)this.jdField_a_of_type_JavaLangCharSequence, false);
        bcni.a(this.jdField_a_of_type_JavaLangString, 40, paramView, false);
        bcni.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
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
          bcni.a("talk", "clk_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString, "" + localObject2, "" + (((Integer)localObject1).intValue() + 1) });
          continue;
          label699:
          bhuu.f = 2;
          continue;
          label706:
          alpb.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)((FTSMessage)localObject1).msgExts).time;
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
      return bcni.a(this.f);
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
        this.jdField_d_of_type_JavaLangCharSequence = bcni.a(((FTSEntity)this.jdField_a_of_type_JavaUtilList.get(0)).mContent, ((FTSEntity)this.jdField_a_of_type_JavaUtilList.get(0)).mProximityStart, this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    else
    {
      return this.jdField_d_of_type_JavaLangCharSequence;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(i + anzj.a(2131703851) + "\"");
    if ((this.jdField_c_of_type_JavaLangString != null) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))) {
      localSpannableStringBuilder.append(bcni.a(this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString));
    }
    for (;;)
    {
      localSpannableStringBuilder.append("\"").append("相关记录");
      this.jdField_d_of_type_JavaLangCharSequence = localSpannableStringBuilder;
      break;
      localSpannableStringBuilder.append(bcni.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
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
 * Qualified Name:     bcdr
 * JD-Core Version:    0.7.0.1
 */