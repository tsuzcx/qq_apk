import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aywm
  extends ajuc
{
  public aywm(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    super.a(paramBoolean, paramString1, paramString2, paramInt, paramString3, paramString4);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onGetHomeworkTroopIdentity: isSuccess:" + paramBoolean + ", identity:" + paramInt + ", course:" + paramString3);
    }
    if (!this.a.j)
    {
      if (!this.a.h) {
        this.a.a(paramString3);
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
          paramString4 = this.a.d;
          if (!this.a.k) {
            break label482;
          }
          if (this.a.e != null) {
            break label471;
          }
          paramString1 = "";
          label204:
          azzx.a("Grp_edu", "homework", "CreateHw_Show", 0, 0, new String[] { paramString2, paramString4, paramString1 });
          if (!paramBoolean) {
            break label509;
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
      label471:
      paramString1 = this.a.e;
      break label204;
      label482:
      if (this.a.f == null)
      {
        paramString1 = "";
        break label204;
      }
      paramString1 = this.a.f;
      break label204;
      label509:
      bbmy.a(this.a.getActivity(), ajjy.a(2131643041), 0).a();
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
 * Qualified Name:     aywm
 * JD-Core Version:    0.7.0.1
 */