import android.view.View;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import java.util.List;

public class bcdb
  extends bcda
{
  private int a;
  
  public bcdb(List<bcfj> paramList, String paramString, int paramInt)
  {
    super(paramList, paramString);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return bbzh.a("fts_native_chathistory_maxnum", 3);
  }
  
  public String a()
  {
    return anvx.a(2131704426);
  }
  
  public void a(View paramView)
  {
    bcnc.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      bcnc.a("all_result", "more_talk", new String[] { "" + this.jdField_a_of_type_JavaLangString });
      bcjs.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4F", 0, 0, null, null);
    }
    bhkg.d = -1;
    bhkg.f = 0;
    bhkg.g = -1;
    bhkg.h = -1;
    bhkg.i = -1;
    bhkg.j = -1;
    bhkf.a(paramView);
    FTSEntitySearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdb
 * JD-Core Version:    0.7.0.1
 */