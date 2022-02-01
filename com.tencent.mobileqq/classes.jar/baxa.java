import android.app.Activity;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class baxa
  extends bayp
{
  private long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  List<bayp> jdField_a_of_type_JavaUtilList;
  
  public baxa(QQAppInterface paramQQAppInterface, int paramInt, String paramString, List<bayp> paramList)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private CharSequence f()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append("邀请:");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (i != 0) {
        localSpannableStringBuilder.append("、");
      }
      localSpannableStringBuilder.append(((bayp)this.jdField_a_of_type_JavaUtilList.get(i)).e());
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  protected long a(String paramString)
  {
    return 0L;
  }
  
  public CharSequence a()
  {
    return f();
  }
  
  public Object a()
  {
    return Integer.valueOf(9889987);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1500L) {
      return;
    }
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      bbgk.a("all_result", "clk_discuss", new String[] { "" + this.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Long = l;
    Intent localIntent = new Intent(paramView.getContext(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_entrance", 28);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    Object localObject;
    String str1;
    String str2;
    int i;
    if (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (bayp)this.jdField_a_of_type_JavaUtilList.get(j);
      str1 = ((bayp)localObject).b();
      str2 = ((bayp)localObject).e().toString();
      if ((localObject instanceof baxd))
      {
        localObject = ((baxd)localObject).e();
        i = 2;
      }
    }
    for (;;)
    {
      localArrayList.add(SelectMemberActivity.constructAResultRecord(str1, str2, i, (String)localObject));
      j += 1;
      break;
      if ((localObject instanceof baxk))
      {
        localObject = ((baxk)localObject).jdField_a_of_type_JavaLangString;
        i = 2;
      }
      else if ((localObject instanceof baxe))
      {
        localObject = "-1";
        i = 0;
        continue;
        localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718085));
        localIntent.putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718086));
        localIntent.putExtra("param_title", amtj.a(2131701678));
        localIntent.putExtra("param_selected_records_for_create_discussion", localArrayList);
        ((Activity)paramView.getContext()).startActivityForResult(localIntent, 1300);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800635F", "0X800635F", 0, 0, "", "", "", "");
      }
      else
      {
        localObject = "-1";
        i = 0;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return "";
  }
  
  public String b()
  {
    return String.valueOf(9889987);
  }
  
  public int c()
  {
    return 9889987;
  }
  
  public CharSequence c()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      localSpannableStringBuilder.append("已选择").append("" + i).append("人");
      return localSpannableStringBuilder;
    }
  }
  
  public String c()
  {
    return f().toString();
  }
  
  public int d()
  {
    return 9889987;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxa
 * JD-Core Version:    0.7.0.1
 */