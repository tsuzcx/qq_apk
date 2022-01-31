import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qphone.base.util.QLog;

public class ayod
  extends ayom
  implements ayoe
{
  private static aynu jdField_a_of_type_Aynu = new aynu();
  private int jdField_a_of_type_Int = 0;
  private ayny jdField_a_of_type_Ayny;
  private aynz jdField_a_of_type_Aynz;
  
  public ayod(ayny paramayny)
  {
    this.jdField_a_of_type_Ayny = paramayny;
    if ((this.jdField_a_of_type_Ayny != null) && (QLog.isColorLevel())) {
      QLog.d("ArkRichNode", 2, "id:" + this.jdField_a_of_type_Ayny.a() + " appname:" + this.jdField_a_of_type_Ayny.b() + " viewname:" + this.jdField_a_of_type_Ayny.d() + " miniversion:" + this.jdField_a_of_type_Ayny.c() + " path：" + this.jdField_a_of_type_Ayny.a());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aynz a()
  {
    return this.jdField_a_of_type_Aynz;
  }
  
  public ayoh a(Context paramContext)
  {
    if (this.jdField_a_of_type_Ayny == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRichNode", 2, "onCreate config = null");
      }
      return null;
    }
    ayob localayob = new ayob(this, paramContext);
    localayob.a(this);
    localayob.a(paramContext);
    jdField_a_of_type_Aynu.a(this);
    this.jdField_a_of_type_Aynz = new aynz(jdField_a_of_type_Aynu);
    String str = a();
    this.jdField_a_of_type_Aynz.a(this.jdField_a_of_type_Ayny, str, paramContext.getResources().getDisplayMetrics().scaledDensity);
    this.jdField_a_of_type_Aynz.setFixSize(-1, -1);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Aynz.setMaxSize(i, -1);
    this.jdField_a_of_type_Aynz.setMinSize(i, -1);
    localayob.a(this.jdField_a_of_type_Aynz);
    this.jdField_a_of_type_Aynz.activateView(true);
    return localayob;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onDestroy");
    }
    if (jdField_a_of_type_Aynu != null) {
      jdField_a_of_type_Aynu.b(this);
    }
    if (this.jdField_a_of_type_Aynz != null)
    {
      this.jdField_a_of_type_Aynz.doOnEvent(2);
      this.jdField_a_of_type_Aynz.a();
      this.jdField_a_of_type_Aynz = null;
    }
    this.jdField_a_of_type_Ayny = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    e();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onSetTalkBackText:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    StringBuilder localStringBuilder;
    do
    {
      ayoh localayoh;
      do
      {
        do
        {
          return;
          localayoh = a();
        } while (localayoh == null);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        paramString = localayoh.a();
        if (paramString != null) {
          paramString.setContentDescription(localStringBuilder);
        }
      } while (!(localayoh instanceof ayob));
      paramString = ((ayob)localayoh).b();
    } while (!(paramString instanceof ArkAppView));
    ((ArkAppView)paramString).setContentDescription(localStringBuilder);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onNotifyEvent, key:" + paramString1 + " value:" + paramString2);
    }
    b(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    super.a(paramString1, paramString2, paramString3);
    if (this.jdField_a_of_type_Aynz != null) {
      this.jdField_a_of_type_Aynz.updateMetaData(a());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aynz != null) {
      this.jdField_a_of_type_Aynz.activateView(paramBoolean);
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Aynz != null) {
      this.jdField_a_of_type_Aynz.doOnEvent(0);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Aynz != null) {
      this.jdField_a_of_type_Aynz.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayod
 * JD-Core Version:    0.7.0.1
 */