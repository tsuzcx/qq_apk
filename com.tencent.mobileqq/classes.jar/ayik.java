import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import java.util.List;

public class ayik
  implements ayjk
{
  private ahea jdField_a_of_type_Ahea;
  private String jdField_a_of_type_JavaLangString;
  private List<ayjl> jdField_a_of_type_JavaUtilList;
  private String b;
  
  public ayik(ahea paramahea, List<ayjl> paramList, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Ahea = paramahea;
    this.b = paramString2;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return alpo.a(2131705730);
  }
  
  public List<ayjl> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    ayrd.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    ayil localayil = (ayil)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localayil != null) && (!TextUtils.isEmpty(this.b)))
    {
      Object localObject = new Intent(paramView.getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.b);
      paramView.getContext().startActivity((Intent)localObject);
      if (localayil.a() != null)
      {
        localObject = localayil.a().hotword.get();
        int i = localayil.a().hotword_type.get();
        nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localayil.a(), (String)localObject, String.valueOf(i), "2");
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
 * Qualified Name:     ayik
 * JD-Core Version:    0.7.0.1
 */