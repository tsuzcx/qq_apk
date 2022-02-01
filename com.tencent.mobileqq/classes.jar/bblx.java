import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import java.util.List;

public class bblx
  implements bbmx
{
  private aitt jdField_a_of_type_Aitt;
  private String jdField_a_of_type_JavaLangString;
  private List<bbmy> jdField_a_of_type_JavaUtilList;
  private String b;
  
  public bblx(aitt paramaitt, List<bbmy> paramList, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Aitt = paramaitt;
    this.b = paramString2;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return anni.a(2131704143);
  }
  
  public List<bbmy> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    bbup.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    bbly localbbly = (bbly)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localbbly != null) && (!TextUtils.isEmpty(this.b)))
    {
      Object localObject = new Intent(paramView.getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.b);
      paramView.getContext().startActivity((Intent)localObject);
      if (localbbly.a() != null)
      {
        localObject = localbbly.a().hotword.get();
        int i = localbbly.a().hotword_type.get();
        oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localbbly.a(), (String)localObject, String.valueOf(i), "2");
      }
    }
    paramView.getContext();
    oat.a(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.jdField_a_of_type_JavaLangString, "0");
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblx
 * JD-Core Version:    0.7.0.1
 */