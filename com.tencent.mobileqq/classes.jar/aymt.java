import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import java.util.List;

public class aymt
  implements aynt
{
  private ahip jdField_a_of_type_Ahip;
  private String jdField_a_of_type_JavaLangString;
  private List<aynu> jdField_a_of_type_JavaUtilList;
  private String b;
  
  public aymt(ahip paramahip, List<aynu> paramList, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Ahip = paramahip;
    this.b = paramString2;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return alud.a(2131705742);
  }
  
  public List<aynu> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    ayvm.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    aymu localaymu = (aymu)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localaymu != null) && (!TextUtils.isEmpty(this.b)))
    {
      Object localObject = new Intent(paramView.getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.b);
      paramView.getContext().startActivity((Intent)localObject);
      if (localaymu.a() != null)
      {
        localObject = localaymu.a().hotword.get();
        int i = localaymu.a().hotword_type.get();
        nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localaymu.a(), (String)localObject, String.valueOf(i), "2");
      }
    }
    paramView.getContext();
    nrt.a(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.jdField_a_of_type_JavaLangString, "0");
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymt
 * JD-Core Version:    0.7.0.1
 */