import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;

public class ayip
  extends ayjm
{
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  
  public ayip(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public CharSequence a()
  {
    return ayrd.a(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get(), this.jdField_a_of_type_JavaLangString);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((localContext != null) && ((localContext instanceof BaseActivity)))
    {
      PublicView.a((QQAppInterface)((BaseActivity)localContext).getAppRuntime(), localContext, this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.class_index.get(), String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get()), String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get()), this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_flag.get(), this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get(), 4);
      ayrd.a(this.jdField_a_of_type_JavaLangString, 70, 0, paramView);
      ayrd.a(this.jdField_a_of_type_JavaLangString, 70, paramView, false);
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
    return String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
  }
  
  public boolean b()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("name = ").append(this.jdField_a_of_type_JavaLangCharSequence).append(", isCert = ");
      if ((!this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.has()) || (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.flag.get() != 1L)) {
        break label102;
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("GroupNetSearchModelPublicAcntItem", 2, bool);
      if ((!this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.flag.has()) || (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.flag.get() != 1L)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    return alpo.a(2131705729);
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayip
 * JD-Core Version:    0.7.0.1
 */