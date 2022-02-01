import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aobf
  implements aobj
{
  aobf(aobd paramaobd, Activity paramActivity, long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.d("AVGameShareUtil", 1, "getShareLinkCallback isSuccess: " + paramBoolean + " shareUrl: " + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      new aoba(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(this.jdField_a_of_type_Long), paramString, this.jdField_b_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString).c();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131690386, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobf
 * JD-Core Version:    0.7.0.1
 */