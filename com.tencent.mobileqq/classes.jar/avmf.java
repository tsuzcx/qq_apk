import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import java.util.List;

public class avmf
  extends avme
{
  private int a;
  
  public avmf(List<avon> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return avis.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return ajjy.a(2131639163);
  }
  
  public void a(View paramView)
  {
    avwf.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      avwf.a("all_result", "more_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString });
      avsv.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4F", 0, 0, null, null);
    }
    bakr.d = -1;
    bakr.f = 0;
    bakr.g = -1;
    bakr.h = -1;
    bakr.i = -1;
    bakr.j = -1;
    bakq.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmf
 * JD-Core Version:    0.7.0.1
 */