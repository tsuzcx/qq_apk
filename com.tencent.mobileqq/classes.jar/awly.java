import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import java.util.List;

public class awly
  extends awlx
{
  private int a;
  
  public awly(List<awog> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return awil.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return ajyc.a(2131704948);
  }
  
  public void a(View paramView)
  {
    awvy.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      awvy.a("all_result", "more_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString });
      awso.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4F", 0, 0, null, null);
    }
    bbmb.d = -1;
    bbmb.f = 0;
    bbmb.g = -1;
    bbmb.h = -1;
    bbmb.i = -1;
    bbmb.j = -1;
    bbma.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awly
 * JD-Core Version:    0.7.0.1
 */