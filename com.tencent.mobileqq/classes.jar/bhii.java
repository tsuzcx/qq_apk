import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@bglp(a="RuntimeInitTask")
public class bhii
  extends bhlw
{
  private bhey jdField_a_of_type_Bhey;
  private boolean jdField_a_of_type_Boolean;
  
  public bhii(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
  }
  
  public void a()
  {
    bhbs.a(202, "", a().getMiniAppInfoForReport());
    MiniAppInfo localMiniAppInfo = a().getMiniAppInfo();
    Object localObject2;
    if (a() != null)
    {
      localObject2 = a();
      if (!this.jdField_a_of_type_Boolean) {
        break label121;
      }
      localObject1 = bhio.class;
      localObject1 = (bhil)((bgun)localObject2).getTask((Class)localObject1);
      if (localObject1 == null) {
        break label132;
      }
    }
    label132:
    for (Object localObject1 = ((bhil)localObject1).a();; localObject1 = null)
    {
      localObject2 = (bhih)a().getTask(bhih.class);
      if (localObject2 != null)
      {
        this.jdField_a_of_type_Bhey = ((bhih)localObject2).a();
        this.jdField_a_of_type_Bhey.a((bhhq)localObject1);
      }
      if ((this.jdField_a_of_type_Bhey != null) && (localMiniAppInfo != null))
      {
        this.jdField_a_of_type_Bhey.a(localMiniAppInfo, null);
        c();
        return;
        label121:
        localObject1 = bhil.class;
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
    bhbs.a(203, "", a().getMiniAppInfoForReport());
  }
  
  public void d()
  {
    bhbs.a(222, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhii
 * JD-Core Version:    0.7.0.1
 */