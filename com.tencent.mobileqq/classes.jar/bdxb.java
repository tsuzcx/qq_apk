import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@bdcu(a="RuntimeInitTask")
public class bdxb
  extends bdyb
{
  private bduj jdField_a_of_type_Bduj;
  private boolean jdField_a_of_type_Boolean;
  
  public bdxb(Context paramContext, bdlq parambdlq)
  {
    super(paramContext, parambdlq);
  }
  
  public void a()
  {
    bdsc.a(202, "", a().getMiniAppInfoForReport());
    MiniAppInfo localMiniAppInfo = a().getMiniAppInfo();
    if (a() != null)
    {
      localObject = (bdxc)a().getTask(bdxc.class);
      if (localObject == null) {
        break label115;
      }
    }
    label115:
    for (Object localObject = ((bdxc)localObject).a();; localObject = null)
    {
      bdxa localbdxa = (bdxa)a().getTask(bdxa.class);
      if (localbdxa != null)
      {
        this.jdField_a_of_type_Bduj = localbdxa.a();
        this.jdField_a_of_type_Bduj.a((bdwp)localObject);
      }
      if ((this.jdField_a_of_type_Bduj != null) && (localMiniAppInfo != null))
      {
        this.jdField_a_of_type_Bduj.a(localMiniAppInfo, null);
        c();
        return;
      }
      f();
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
    bdsc.a(203, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdxb
 * JD-Core Version:    0.7.0.1
 */