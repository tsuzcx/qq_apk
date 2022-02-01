import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;

public class bpfd
  extends bpeu
{
  private static final String a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<bpbu> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = bpfd.class.getSimpleName();
  }
  
  public bpfd(String paramString, List<bpbu> paramList, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramList;
  }
  
  public bpez a(List<bpey> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (paramList = null;; paramList = (bpey)paramList.get(0))
    {
      return a(paramList);
      if (paramList.size() > 1) {
        bpam.d(jdField_a_of_type_JavaLangString, "single image but responseList != 1");
      }
    }
  }
  
  protected void a(Context paramContext, bpex parambpex)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 1;
    ThreadManager.excute(new SingleImageAIFilterProxy.1(this, localArrayList, paramContext, parambpex), 128, null, false);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfd
 * JD-Core Version:    0.7.0.1
 */