import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class azxh
  extends akil
{
  public azxh(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(boolean paramBoolean, azvn paramazvn)
  {
    super.a(paramBoolean, paramazvn);
    this.a.n();
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("获取作业信息");
      if (!paramBoolean) {
        break label270;
      }
      localObject1 = "成功";
    }
    for (;;)
    {
      QLog.d("PublishHomeWorkFragment", 2, (String)localObject1);
      if ((paramBoolean) && (paramazvn != null) && (paramazvn.b != null))
      {
        this.a.jdField_a_of_type_Azvn = paramazvn;
        paramazvn = paramazvn.b;
      }
      try
      {
        paramazvn = new JSONObject(paramazvn).getJSONArray("c");
        int i = 0;
        for (;;)
        {
          if (i < paramazvn.length())
          {
            localObject1 = paramazvn.getJSONObject(i);
            if (localObject1 != null)
            {
              localObject2 = ((JSONObject)localObject1).optString("type");
              String str = ((JSONObject)localObject1).optString("exam_type");
              if ((((String)localObject2).equals("exam")) && (str != null) && (!str.equals("0"))) {
                this.a.a((JSONObject)localObject1);
              }
            }
          }
          else
          {
            paramazvn = new JSONObject().put("c", paramazvn).toString();
            this.a.a(paramazvn);
            if ((this.a.jdField_a_of_type_AndroidWidgetEditText != null) && (this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().isEmpty()))
            {
              this.a.jdField_a_of_type_AndroidWidgetEditText.setText(this.a.jdField_a_of_type_Azvn.jdField_a_of_type_JavaLangString);
              this.a.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
              this.a.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
            }
            return;
            label270:
            localObject1 = "失败";
            break;
          }
          i += 1;
        }
        this.a.getActivity().finish();
        return;
      }
      catch (Exception paramazvn) {}
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    super.a(paramBoolean, paramString1, paramString2, paramInt, paramString3, paramString4);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onGetHomeworkTroopIdentity: isSuccess:" + paramBoolean + ", identity:" + paramInt + ", course:" + paramString3);
    }
    if (!this.a.j)
    {
      if (!this.a.h) {
        this.a.b(paramString3);
      }
      switch (paramInt)
      {
      default: 
        this.a.d = "";
        this.a.k = false;
        this.a.e = paramString3;
        this.a.f = paramString4;
        if (this.a.b == null)
        {
          paramString2 = "";
          label172:
          String str = this.a.d;
          if (!this.a.k) {
            break label502;
          }
          if (this.a.e != null) {
            break label491;
          }
          paramString1 = "";
          label204:
          if (this.a.jdField_a_of_type_Int != 1) {
            break label529;
          }
          paramString4 = "1";
          label219:
          bbbp.a("Grp_edu", "homework", "CreateHw_Show", 0, 0, new String[] { paramString2, str, paramString1, paramString4 });
          if (!paramBoolean) {
            break label536;
          }
          this.a.jdField_a_of_type_JavaLangString = paramString3;
          if (this.a.jdField_a_of_type_JavaLangString == null) {
            this.a.jdField_a_of_type_JavaLangString = "";
          }
          if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PublishHomeWorkFragment", 2, "检测到你是" + this.a.jdField_a_of_type_JavaLangString + "老师，将按照需求定制入口");
            }
            paramString1 = this.a.a(this.a.jdField_a_of_type_JavaLangString);
            if (paramString1 != null)
            {
              this.a.jdField_a_of_type_JavaUtilList.clear();
              this.a.jdField_a_of_type_JavaUtilList.addAll(paramString1);
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      QLog.i("PublishHomeWorkFragment", 1, "init data success");
      this.a.e();
      return;
      this.a.d = "classteacher";
      this.a.k = true;
      break;
      this.a.d = "teacher";
      this.a.k = true;
      break;
      this.a.d = "parent";
      this.a.k = false;
      break;
      this.a.d = "student";
      this.a.k = false;
      break;
      paramString2 = this.a.b;
      break label172;
      label491:
      paramString1 = this.a.e;
      break label204;
      label502:
      if (this.a.f == null)
      {
        paramString1 = "";
        break label204;
      }
      paramString1 = this.a.f;
      break label204;
      label529:
      paramString4 = "2";
      break label219;
      label536:
      bcql.a(this.a.getActivity(), ajya.a(2131708837), 0).a();
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    super.b(paramBoolean, paramLong, paramInt);
    this.a.n();
    if (paramBoolean)
    {
      this.a.i();
      return;
    }
    if (paramInt == 10022)
    {
      this.a.a(1, null, null);
      return;
    }
    if (paramInt == 1002)
    {
      this.a.a(2, null, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: server error " + paramInt);
    }
    this.a.a(3, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azxh
 * JD-Core Version:    0.7.0.1
 */