import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import java.util.List;

public class awma
  extends awlz
{
  private int a;
  
  public awma(List<awoi> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return awin.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return ajya.a(2131704959);
  }
  
  public void a(View paramView)
  {
    awwa.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      awwa.a("all_result", "more_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString });
      awsq.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4F", 0, 0, null, null);
    }
    bbmp.d = -1;
    bbmp.f = 0;
    bbmp.g = -1;
    bbmp.h = -1;
    bbmp.i = -1;
    bbmp.j = -1;
    bbmo.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awma
 * JD-Core Version:    0.7.0.1
 */