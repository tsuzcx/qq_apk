import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class bcer
  extends bcfs
{
  private AccountSearchPb.hotwordrecord jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private String jdField_b_of_type_JavaLangString;
  
  public bcer(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = paramhotwordrecord;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence2;
  }
  
  public bcer(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public AccountSearchPb.hotwordrecord a()
  {
    return this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
  }
  
  public AccountSearchPb.record a()
  {
    return this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
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
    bcni.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    Intent localIntent = new Intent(paramView.getContext(), PublicAccountBrowser.class);
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null)
    {
      localIntent.putExtra("url", this.jdField_b_of_type_JavaLangString);
      ocd.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, a(), this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "1");
    }
    for (;;)
    {
      paramView.getContext().startActivity(localIntent);
      if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) {
        ocd.a(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_id.get()));
      }
      return;
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_short_url.get());
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    return anzj.a(2131704251);
  }
  
  public String b()
  {
    return null;
  }
  
  public int c()
  {
    return 0;
  }
  
  public CharSequence c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.has()) {
        localObject1 = this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
      }
    }
    return localObject1;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
      return this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
    }
    return this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.title_image.get();
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcer
 * JD-Core Version:    0.7.0.1
 */