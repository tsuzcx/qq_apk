import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;

public class blln
  extends blle
{
  private static final String a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<blki> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = blln.class.getSimpleName();
  }
  
  public blln(String paramString, List<blki> paramList, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramList;
  }
  
  public bllj a(List<blli> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (paramList = null;; paramList = (blli)paramList.get(0))
    {
      return a(paramList);
      if (paramList.size() > 1) {
        bljn.d(jdField_a_of_type_JavaLangString, "single image but responseList != 1");
      }
    }
  }
  
  protected void a(Context paramContext, bllh parambllh)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 1;
    ThreadManager.excute(new SingleImageAIFilterProxy.1(this, localArrayList, paramContext, parambllh), 128, null, false);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blln
 * JD-Core Version:    0.7.0.1
 */