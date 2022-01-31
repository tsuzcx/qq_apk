import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;

public class blhe
  extends blgw
{
  private static final String a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<blgb> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = blhe.class.getSimpleName();
  }
  
  public blhe(String paramString, List<blgb> paramList, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramList;
  }
  
  public blhb a(List<blha> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (paramList = null;; paramList = (blha)paramList.get(0))
    {
      return a(paramList);
      if (paramList.size() > 1) {
        blfg.d(jdField_a_of_type_JavaLangString, "single image but responseList != 1");
      }
    }
  }
  
  protected void a(Context paramContext, blgz paramblgz)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 1;
    ThreadManager.excute(new SingleImageAIFilterProxy.1(this, localArrayList, paramContext, paramblgz), 128, null, false);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhe
 * JD-Core Version:    0.7.0.1
 */