import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@bghi(a="RuntimeInitTask")
public class bheb
  extends bhhp
{
  private bhar jdField_a_of_type_Bhar;
  private boolean jdField_a_of_type_Boolean;
  
  public bheb(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  public void a()
  {
    bgxl.a(202, "", a().getMiniAppInfoForReport());
    MiniAppInfo localMiniAppInfo = a().getMiniAppInfo();
    Object localObject2;
    if (a() != null)
    {
      localObject2 = a();
      if (!this.jdField_a_of_type_Boolean) {
        break label121;
      }
      localObject1 = bheh.class;
      localObject1 = (bhee)((bgqg)localObject2).getTask((Class)localObject1);
      if (localObject1 == null) {
        break label132;
      }
    }
    label132:
    for (Object localObject1 = ((bhee)localObject1).a();; localObject1 = null)
    {
      localObject2 = (bhea)a().getTask(bhea.class);
      if (localObject2 != null)
      {
        this.jdField_a_of_type_Bhar = ((bhea)localObject2).a();
        this.jdField_a_of_type_Bhar.a((bhdj)localObject1);
      }
      if ((this.jdField_a_of_type_Bhar != null) && (localMiniAppInfo != null))
      {
        this.jdField_a_of_type_Bhar.a(localMiniAppInfo, null);
        c();
        return;
        label121:
        localObject1 = bhee.class;
        break;
      }
      e();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    super.c();
    bgxl.a(203, "", a().getMiniAppInfoForReport());
  }
  
  public void d()
  {
    bgxl.a(222, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bheb
 * JD-Core Version:    0.7.0.1
 */