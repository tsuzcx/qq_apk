import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bmgt
  extends bmgg
{
  private static final String a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<bmde> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = bmgt.class.getSimpleName();
  }
  
  public bmgt(String paramString, List<bmde> paramList, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramList;
  }
  
  public bmgl a(List<bmgk> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (paramList = null;; paramList = (bmgk)paramList.get(0))
    {
      return a(paramList);
      if (paramList.size() > 1) {
        bmbx.d(jdField_a_of_type_JavaLangString, "single image but responseList != 1");
      }
    }
  }
  
  protected void a(Context paramContext, bmgj parambmgj)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 1;
    ThreadManager.getSubThreadHandler().post(new SingleImageAIFilterProxy.1(this, localArrayList, paramContext, parambmgj));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgt
 * JD-Core Version:    0.7.0.1
 */