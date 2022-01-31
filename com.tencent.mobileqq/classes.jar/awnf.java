import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import java.util.List;

public class awnf
  implements awof
{
  private afgx jdField_a_of_type_Afgx;
  private String jdField_a_of_type_JavaLangString;
  private List<awog> jdField_a_of_type_JavaUtilList;
  private String b;
  
  public awnf(afgx paramafgx, List<awog> paramList, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Afgx = paramafgx;
    this.b = paramString2;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return ajyc.a(2131705347);
  }
  
  public List<awog> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    awvy.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    awng localawng = (awng)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localawng != null) && (!TextUtils.isEmpty(this.b)))
    {
      Object localObject = new Intent(paramView.getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.b);
      paramView.getContext().startActivity((Intent)localObject);
      if (localawng.a() != null)
      {
        localObject = localawng.a().hotword.get();
        int i = localawng.a().hotword_type.get();
        noo.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localawng.a(), (String)localObject, String.valueOf(i), "2");
      }
    }
    paramView.getContext();
    noo.a(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.jdField_a_of_type_JavaLangString, "0");
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnf
 * JD-Core Version:    0.7.0.1
 */