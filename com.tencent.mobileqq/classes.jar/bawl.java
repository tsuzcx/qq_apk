import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import java.util.List;

public class bawl
  extends bawk
{
  private int a;
  
  public bawl(List<bayt> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return bass.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return amtj.a(2131704075);
  }
  
  public void a(View paramView)
  {
    bbgk.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      bbgk.a("all_result", "more_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString });
      bbda.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4F", 0, 0, null, null);
    }
    bgbp.d = -1;
    bgbp.f = 0;
    bgbp.g = -1;
    bgbp.h = -1;
    bgbp.i = -1;
    bgbp.j = -1;
    bgbo.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawl
 * JD-Core Version:    0.7.0.1
 */