import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import java.util.List;

public class bbkq
  extends bbkp
{
  private int a;
  
  public bbkq(List<bbmy> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return bbgu.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return anni.a(2131703739);
  }
  
  public void a(View paramView)
  {
    bbup.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      bbup.a("all_result", "more_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString });
      bbrf.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4F", 0, 0, null, null);
    }
    bgur.d = -1;
    bgur.f = 0;
    bgur.g = -1;
    bgur.h = -1;
    bgur.i = -1;
    bgur.j = -1;
    bguq.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkq
 * JD-Core Version:    0.7.0.1
 */