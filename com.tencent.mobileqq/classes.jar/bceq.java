import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import java.util.List;

public class bceq
  implements bcfq
{
  private ajfc jdField_a_of_type_Ajfc;
  private String jdField_a_of_type_JavaLangString;
  private List<bcfr> jdField_a_of_type_JavaUtilList;
  private String b;
  
  public bceq(ajfc paramajfc, List<bcfr> paramList, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Ajfc = paramajfc;
    this.b = paramString2;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return anzj.a(2131704250);
  }
  
  public List<bcfr> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    bcni.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    bcer localbcer = (bcer)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localbcer != null) && (!TextUtils.isEmpty(this.b)))
    {
      Object localObject = new Intent(paramView.getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.b);
      paramView.getContext().startActivity((Intent)localObject);
      if (localbcer.a() != null)
      {
        localObject = localbcer.a().hotword.get();
        int i = localbcer.a().hotword_type.get();
        ocd.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localbcer.a(), (String)localObject, String.valueOf(i), "2");
      }
    }
    paramView.getContext();
    ocd.a(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.jdField_a_of_type_JavaLangString, "0");
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bceq
 * JD-Core Version:    0.7.0.1
 */