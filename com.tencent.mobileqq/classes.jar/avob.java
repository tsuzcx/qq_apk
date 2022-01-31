import android.view.View;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import java.util.List;

public class avob
  implements avom
{
  protected int a;
  private String a;
  public List<avon> a;
  
  public avob(List<avon> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 3;
  }
  
  public String a()
  {
    return ajjy.a(2131639600);
  }
  
  public List<avon> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    avsv.a(null, 0, this.jdField_a_of_type_Int, "0X8009D47", 0, 0, null, null);
    String str = avwf.a("pages/search-results/search-results?mode=search&q=" + this.jdField_a_of_type_JavaLangString);
    str = avwf.a("https://m.q.qq.com/a/p/1108291530?via=2005_2&referer=2005&s=" + str);
    str = "mqqapi://microapp/open?url=" + str;
    MiniAppLauncher.startMiniApp(paramView.getContext(), str, 2005, null);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avob
 * JD-Core Version:    0.7.0.1
 */