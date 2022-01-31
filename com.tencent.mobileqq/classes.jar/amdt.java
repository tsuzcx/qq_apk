import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.qphone.base.util.QLog;

public class amdt
  extends amdl
{
  public amdt(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onModifyCard isSuccess=%s cardId=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    this.a.b();
    if (paramBoolean)
    {
      this.a.b(ajyc.a(2131701244));
      axqw.b(this.a.app, "CliOper", "", "", "0X8007748", "0X8007748", this.a.d, 0, "", "", "", "");
      return;
    }
    bcpw.a(this.a.getActivity(), 2, ajyc.a(2131701252), 0).b(this.a.getTitleBarHeight());
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
        this.a.jdField_a_of_type_Amdk.a(false);
      }
      if ((!this.a.jdField_a_of_type_Boolean) || (!this.a.b) || (this.a.isFinishing())) {
        break label190;
      }
      this.a.jdField_a_of_type_Amdk.a(paramString);
      QLog.i("BusinessCard_observer", 4, "after edit and require : cardId = " + paramString);
      this.a.finish();
    }
    label190:
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_Amdk.a(paramString);
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
      bcpw.a(this.a.getActivity(), 2, ajyc.a(2131701247), 0).b(this.a.getTitleBarHeight());
      this.a.finish();
      return;
    }
    bcpw.a(this.a.getActivity(), 1, ajyc.a(2131701242), 0).b(this.a.getTitleBarHeight());
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
      localObject = ((Resources)localObject).getString(2131698595);
      this.a.b((String)localObject);
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = paramString;
      }
      return;
    }
    paramString = ((Resources)localObject).getString(2131698593);
    if (paramInt == 66) {
      paramString = ((Resources)localObject).getString(2131698594);
    }
    bcpw.a(this.a.getActivity(), 2, paramString, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amdt
 * JD-Core Version:    0.7.0.1
 */