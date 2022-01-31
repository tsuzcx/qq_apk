import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qphone.base.util.QLog;

public class avtf
  extends avto
  implements avtg
{
  private static avsw jdField_a_of_type_Avsw = new avsw();
  private int jdField_a_of_type_Int = 0;
  private avta jdField_a_of_type_Avta;
  private avtb jdField_a_of_type_Avtb;
  
  public avtf(avta paramavta)
  {
    this.jdField_a_of_type_Avta = paramavta;
    if ((this.jdField_a_of_type_Avta != null) && (QLog.isColorLevel())) {
      QLog.d("ArkRichNode", 2, "id:" + this.jdField_a_of_type_Avta.a() + " appname:" + this.jdField_a_of_type_Avta.b() + " viewname:" + this.jdField_a_of_type_Avta.d() + " miniversion:" + this.jdField_a_of_type_Avta.c() + " path：" + this.jdField_a_of_type_Avta.a());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public avtb a()
  {
    return this.jdField_a_of_type_Avtb;
  }
  
  public avtj a(Context paramContext)
  {
    if (this.jdField_a_of_type_Avta == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRichNode", 2, "onCreate config = null");
      }
      return null;
    }
    avtd localavtd = new avtd(this, paramContext);
    localavtd.a(this);
    localavtd.a(paramContext);
    jdField_a_of_type_Avsw.a(this);
    this.jdField_a_of_type_Avtb = new avtb(jdField_a_of_type_Avsw);
    String str = a();
    this.jdField_a_of_type_Avtb.a(this.jdField_a_of_type_Avta, str, paramContext.getResources().getDisplayMetrics().scaledDensity);
    this.jdField_a_of_type_Avtb.setFixSize(-1, -1);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Avtb.setMaxSize(i, -1);
    this.jdField_a_of_type_Avtb.setMinSize(i, -1);
    localavtd.a(this.jdField_a_of_type_Avtb);
    this.jdField_a_of_type_Avtb.activateView(true);
    return localavtd;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onDestroy");
    }
    if (jdField_a_of_type_Avsw != null) {
      jdField_a_of_type_Avsw.b(this);
    }
    if (this.jdField_a_of_type_Avtb != null)
    {
      this.jdField_a_of_type_Avtb.doOnEvent(2);
      this.jdField_a_of_type_Avtb.a();
      this.jdField_a_of_type_Avtb = null;
    }
    this.jdField_a_of_type_Avta = null;
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
      avtj localavtj;
      do
      {
        do
        {
          return;
          localavtj = a();
        } while (localavtj == null);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        paramString = localavtj.a();
        if (paramString != null) {
          paramString.setContentDescription(localStringBuilder);
        }
      } while (!(localavtj instanceof avtd));
      paramString = ((avtd)localavtj).b();
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
    if (this.jdField_a_of_type_Avtb != null) {
      this.jdField_a_of_type_Avtb.updateMetaData(a());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Avtb != null) {
      this.jdField_a_of_type_Avtb.activateView(paramBoolean);
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Avtb != null) {
      this.jdField_a_of_type_Avtb.doOnEvent(0);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Avtb != null) {
      this.jdField_a_of_type_Avtb.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtf
 * JD-Core Version:    0.7.0.1
 */