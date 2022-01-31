import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import java.util.List;

public class aylm
  extends ayll
{
  private int a;
  
  public aylm(List<aynu> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return ayhw.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return alud.a(2131705343);
  }
  
  public void a(View paramView)
  {
    ayvm.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      ayvm.a("all_result", "more_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString });
      aysc.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4F", 0, 0, null, null);
    }
    bdps.d = -1;
    bdps.f = 0;
    bdps.g = -1;
    bdps.h = -1;
    bdps.i = -1;
    bdps.j = -1;
    bdpr.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylm
 * JD-Core Version:    0.7.0.1
 */