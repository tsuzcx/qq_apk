import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import java.util.List;

public class bcei
  implements bcfi
{
  private aiuk jdField_a_of_type_Aiuk;
  private String jdField_a_of_type_JavaLangString;
  private List<bcfj> jdField_a_of_type_JavaUtilList;
  private String b;
  
  public bcei(aiuk paramaiuk, List<bcfj> paramList, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Aiuk = paramaiuk;
    this.b = paramString2;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return anvx.a(2131704831);
  }
  
  public List<bcfj> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    bcnc.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    bcej localbcej = (bcej)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localbcej != null) && (!TextUtils.isEmpty(this.b)))
    {
      Object localObject = new Intent(paramView.getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.b);
      paramView.getContext().startActivity((Intent)localObject);
      if (localbcej.a() != null)
      {
        localObject = localbcej.a().hotword.get();
        int i = localbcej.a().hotword_type.get();
        olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localbcej.a(), (String)localObject, String.valueOf(i), "2");
      }
    }
    paramView.getContext();
    olh.a(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.jdField_a_of_type_JavaLangString, "0");
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcei
 * JD-Core Version:    0.7.0.1
 */