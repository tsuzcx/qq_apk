import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class anus
  extends anuk
{
  public anus(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onModifyCard isSuccess=%s cardId=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    this.a.b();
    if (paramBoolean)
    {
      this.a.b(alpo.a(2131701624));
      azmj.b(this.a.app, "CliOper", "", "", "0X8007748", "0X8007748", this.a.d, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.a.getActivity(), 2, alpo.a(2131701632), 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onGetCardInfo isSuccess=%s cardId=%s queryType=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    this.a.b();
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_JavaLangString)))
    {
      if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Int == 2) && (this.a.c == 1))
      {
        this.a.c = 0;
        this.a.jdField_a_of_type_Anuj.a(false);
      }
      if ((!this.a.jdField_a_of_type_Boolean) || (!this.a.b) || (this.a.isFinishing())) {
        break label190;
      }
      this.a.jdField_a_of_type_Anuj.a(paramString);
      QLog.i("BusinessCard_observer", 4, "after edit and require : cardId = " + paramString);
      this.a.finish();
    }
    label190:
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_Anuj.a(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = paramString;
    BusinessCardEditActivity.a(this.a, false, true, true);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onDelCard isSuccess=%s cardId=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    this.a.b();
    if (paramBoolean)
    {
      QQToast.a(this.a.getActivity(), 2, alpo.a(2131701627), 0).b(this.a.getTitleBarHeight());
      this.a.finish();
      return;
    }
    QQToast.a(this.a.getActivity(), 1, alpo.a(2131701622), 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onAddCard isSuccess=%s cardId=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    this.a.b();
    Object localObject = this.a.getResources();
    if (paramBoolean)
    {
      localObject = ((Resources)localObject).getString(2131698902);
      this.a.b((String)localObject);
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = paramString;
      }
      return;
    }
    paramString = ((Resources)localObject).getString(2131698900);
    if (paramInt == 66) {
      paramString = ((Resources)localObject).getString(2131698901);
    }
    QQToast.a(this.a.getActivity(), 2, paramString, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anus
 * JD-Core Version:    0.7.0.1
 */