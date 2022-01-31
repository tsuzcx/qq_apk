import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@begt(a="RuntimeInitTask")
public class bfdp
  extends bfet
{
  private bfar jdField_a_of_type_Bfar;
  private boolean jdField_a_of_type_Boolean;
  
  public bfdp(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
  }
  
  public void a()
  {
    bexz.a(202, "", a().getMiniAppInfoForReport());
    MiniAppInfo localMiniAppInfo = a().getMiniAppInfo();
    Object localObject2;
    if (a() != null)
    {
      localObject2 = a();
      if (!this.jdField_a_of_type_Boolean) {
        break label121;
      }
      localObject1 = bfdu.class;
      localObject1 = (bfds)((bepv)localObject2).getTask((Class)localObject1);
      if (localObject1 == null) {
        break label132;
      }
    }
    label132:
    for (Object localObject1 = ((bfds)localObject1).a();; localObject1 = null)
    {
      localObject2 = (bfdo)a().getTask(bfdo.class);
      if (localObject2 != null)
      {
        this.jdField_a_of_type_Bfar = ((bfdo)localObject2).a();
        this.jdField_a_of_type_Bfar.a((bfdc)localObject1);
      }
      if ((this.jdField_a_of_type_Bfar != null) && (localMiniAppInfo != null))
      {
        this.jdField_a_of_type_Bfar.a(localMiniAppInfo, null);
        c();
        return;
        label121:
        localObject1 = bfds.class;
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
  
  public void c()
  {
    super.c();
    bexz.a(203, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdp
 * JD-Core Version:    0.7.0.1
 */