import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

public class bhan
{
  private static bhan a;
  public bgxp<String> a;
  public bgxp<String> b = new bgxp(10);
  public bgxp<String> c = new bgxp(10);
  
  private bhan()
  {
    this.jdField_a_of_type_Bgxp = new bgxp(5);
  }
  
  public static bhan a()
  {
    try
    {
      if (jdField_a_of_type_Bhan == null) {
        jdField_a_of_type_Bhan = new bhan();
      }
      bhan localbhan = jdField_a_of_type_Bhan;
      return localbhan;
    }
    finally {}
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activityNameQueue:\n");
    if (this.jdField_a_of_type_Bgxp != null) {
      localStringBuilder.append(this.jdField_a_of_type_Bgxp).append("\n");
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
    if ((paramString != null) && (this.jdField_a_of_type_Bgxp != null))
    {
      if (this.jdField_a_of_type_Bgxp.a()) {
        this.jdField_a_of_type_Bgxp.a();
      }
      this.jdField_a_of_type_Bgxp.a(paramString);
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
 * Qualified Name:     bhan
 * JD-Core Version:    0.7.0.1
 */