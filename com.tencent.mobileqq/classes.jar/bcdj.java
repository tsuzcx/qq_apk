import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import java.util.List;

public class bcdj
  extends bcdi
{
  private int a;
  
  public bcdj(List<bcfr> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return bbzo.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return anzj.a(2131703846);
  }
  
  public void a(View paramView)
  {
    bcni.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      bcni.a("all_result", "more_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString });
      bcjy.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4F", 0, 0, null, null);
    }
    bhuu.d = -1;
    bhuu.f = 0;
    bhuu.g = -1;
    bhuu.h = -1;
    bhuu.i = -1;
    bhuu.j = -1;
    bhut.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdj
 * JD-Core Version:    0.7.0.1
 */