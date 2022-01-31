import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class aymw
  extends aynv
{
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  
  public aymw(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    AddFriendActivity.a((Activity)paramView.getContext(), new SearchResultItem(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record), ((BaseActivity)paramView.getContext()).app, true, 1);
    ayvm.a(this.jdField_a_of_type_JavaLangString, 70, 0, paramView);
    ayvm.a(this.jdField_a_of_type_JavaLangString, 70, paramView, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    StringBuilder localStringBuilder;
    if (this.b == null)
    {
      localStringBuilder = new StringBuilder().append("(");
      if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() == 0L) {
        break label78;
      }
    }
    label78:
    for (String str = String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());; str = this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get())
    {
      this.b = ayvm.a(str + ")", this.jdField_a_of_type_JavaLangString);
      return this.b;
    }
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L) {
      return String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
    }
    return this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L) {
      return 1;
    }
    return 11;
  }
  
  public CharSequence c()
  {
    return alud.a(2131705740);
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymw
 * JD-Core Version:    0.7.0.1
 */