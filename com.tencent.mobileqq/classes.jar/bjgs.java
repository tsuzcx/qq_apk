import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

public class bjgs
{
  private static bjgs a;
  public bjdk<String> a;
  public bjdk<String> b = new bjdk(10);
  public bjdk<String> c = new bjdk(10);
  
  private bjgs()
  {
    this.jdField_a_of_type_Bjdk = new bjdk(5);
  }
  
  public static bjgs a()
  {
    try
    {
      if (jdField_a_of_type_Bjgs == null) {
        jdField_a_of_type_Bjgs = new bjgs();
      }
      bjgs localbjgs = jdField_a_of_type_Bjgs;
      return localbjgs;
    }
    finally {}
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activityNameQueue:\n");
    if (this.jdField_a_of_type_Bjdk != null) {
      localStringBuilder.append(this.jdField_a_of_type_Bjdk).append("\n");
    }
    localStringBuilder.append(" \n activityEventQueue:\n");
    if (this.b != null) {
      localStringBuilder.append(this.b);
    }
    localStringBuilder.append(" \n userActionQueue:\n");
    if (this.c != null) {
      localStringBuilder.append(this.c);
    }
    return localStringBuilder.toString();
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_Bjdk != null))
    {
      if (this.jdField_a_of_type_Bjdk.a()) {
        this.jdField_a_of_type_Bjdk.a();
      }
      this.jdField_a_of_type_Bjdk.a(paramString);
    }
  }
  
  public void a(String paramString, View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity] ").append(paramString);
    if (paramView != null) {
      localStringBuilder.append("  click view  id:0x").append(Integer.toHexString(paramView.getId()));
    }
    c(localStringBuilder.toString());
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, View paramView, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity] ").append(paramString);
    if (paramViewGroup != null) {
      localStringBuilder.append("parent id: ").append(paramViewGroup.getId());
    }
    if (paramView != null) {
      localStringBuilder.append("view id: ").append(paramView.getId());
    }
    localStringBuilder.append(" onItemclick view  position:0x").append(Integer.toHexString(paramInt));
    localStringBuilder.append(" id").append(paramLong);
    a().c(localStringBuilder.toString());
  }
  
  public void b(String paramString)
  {
    if ((paramString != null) && (this.b != null))
    {
      if (this.b.a()) {
        this.b.a();
      }
      this.b.a(paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (this.c != null)
      {
        if (this.c.a()) {
          this.c.a();
        }
        this.c.a(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("RDMEtraMsgCollector", 2, "", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjgs
 * JD-Core Version:    0.7.0.1
 */