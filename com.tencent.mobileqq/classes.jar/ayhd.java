import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import java.util.List;

public class ayhd
  extends ayhc
{
  private int a;
  
  public ayhd(List<ayjl> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return aydn.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return alpo.a(2131705331);
  }
  
  public void a(View paramView)
  {
    ayrd.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      ayrd.a("all_result", "more_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString });
      aynt.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4F", 0, 0, null, null);
    }
    bdlj.d = -1;
    bdlj.f = 0;
    bdlj.g = -1;
    bdlj.h = -1;
    bdlj.i = -1;
    bdlj.j = -1;
    bdli.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhd
 * JD-Core Version:    0.7.0.1
 */