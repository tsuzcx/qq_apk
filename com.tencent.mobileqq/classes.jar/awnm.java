import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class awnm
  extends awoh
{
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  
  public awnm(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
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
    Bundle localBundle = TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get()), 2);
    localBundle.putInt("exposureSource", 3);
    bamn.a((Activity)paramView.getContext(), localBundle, 2);
    awvy.a(this.jdField_a_of_type_JavaLangString, 80, 0, paramView);
    awvy.a(this.jdField_a_of_type_JavaLangString, 80, paramView, false);
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
    return String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
  }
  
  public int c()
  {
    return 4;
  }
  
  public CharSequence c()
  {
    return ajyc.a(2131705340);
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnm
 * JD-Core Version:    0.7.0.1
 */