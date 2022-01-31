import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@behk(a="RuntimeInitTask")
public class bfeg
  extends bffk
{
  private bfbi jdField_a_of_type_Bfbi;
  private boolean jdField_a_of_type_Boolean;
  
  public bfeg(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  public void a()
  {
    beyq.a(202, "", a().getMiniAppInfoForReport());
    MiniAppInfo localMiniAppInfo = a().getMiniAppInfo();
    Object localObject2;
    if (a() != null)
    {
      localObject2 = a();
      if (!this.jdField_a_of_type_Boolean) {
        break label121;
      }
      localObject1 = bfel.class;
      localObject1 = (bfej)((beqm)localObject2).getTask((Class)localObject1);
      if (localObject1 == null) {
        break label132;
      }
    }
    label132:
    for (Object localObject1 = ((bfej)localObject1).a();; localObject1 = null)
    {
      localObject2 = (bfef)a().getTask(bfef.class);
      if (localObject2 != null)
      {
        this.jdField_a_of_type_Bfbi = ((bfef)localObject2).a();
        this.jdField_a_of_type_Bfbi.a((bfdt)localObject1);
      }
      if ((this.jdField_a_of_type_Bfbi != null) && (localMiniAppInfo != null))
      {
        this.jdField_a_of_type_Bfbi.a(localMiniAppInfo, null);
        c();
        return;
        label121:
        localObject1 = bfej.class;
        break;
      }
      f();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void aU_()
  {
    beyq.a(222, "", a().getMiniAppInfoForReport());
  }
  
  public void c()
  {
    super.c();
    beyq.a(203, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfeg
 * JD-Core Version:    0.7.0.1
 */