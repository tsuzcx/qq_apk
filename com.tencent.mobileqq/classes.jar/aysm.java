import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qphone.base.util.QLog;

public class aysm
  extends aysv
  implements aysn
{
  private static aysd jdField_a_of_type_Aysd = new aysd();
  private int jdField_a_of_type_Int = 0;
  private aysh jdField_a_of_type_Aysh;
  private aysi jdField_a_of_type_Aysi;
  
  public aysm(aysh paramaysh)
  {
    this.jdField_a_of_type_Aysh = paramaysh;
    if ((this.jdField_a_of_type_Aysh != null) && (QLog.isColorLevel())) {
      QLog.d("ArkRichNode", 2, "id:" + this.jdField_a_of_type_Aysh.a() + " appname:" + this.jdField_a_of_type_Aysh.b() + " viewname:" + this.jdField_a_of_type_Aysh.d() + " miniversion:" + this.jdField_a_of_type_Aysh.c() + " path：" + this.jdField_a_of_type_Aysh.a());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aysi a()
  {
    return this.jdField_a_of_type_Aysi;
  }
  
  public aysq a(Context paramContext)
  {
    if (this.jdField_a_of_type_Aysh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRichNode", 2, "onCreate config = null");
      }
      return null;
    }
    aysk localaysk = new aysk(this, paramContext);
    localaysk.a(this);
    localaysk.a(paramContext);
    jdField_a_of_type_Aysd.a(this);
    this.jdField_a_of_type_Aysi = new aysi(jdField_a_of_type_Aysd);
    String str = a();
    this.jdField_a_of_type_Aysi.a(this.jdField_a_of_type_Aysh, str, paramContext.getResources().getDisplayMetrics().scaledDensity);
    this.jdField_a_of_type_Aysi.setFixSize(-1, -1);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Aysi.setMaxSize(i, -1);
    this.jdField_a_of_type_Aysi.setMinSize(i, -1);
    localaysk.a(this.jdField_a_of_type_Aysi);
    this.jdField_a_of_type_Aysi.activateView(true);
    return localaysk;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onDestroy");
    }
    if (jdField_a_of_type_Aysd != null) {
      jdField_a_of_type_Aysd.b(this);
    }
    if (this.jdField_a_of_type_Aysi != null)
    {
      this.jdField_a_of_type_Aysi.doOnEvent(2);
      this.jdField_a_of_type_Aysi.a();
      this.jdField_a_of_type_Aysi = null;
    }
    this.jdField_a_of_type_Aysh = null;
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
      aysq localaysq;
      do
      {
        do
        {
          return;
          localaysq = a();
        } while (localaysq == null);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        paramString = localaysq.a();
        if (paramString != null) {
          paramString.setContentDescription(localStringBuilder);
        }
      } while (!(localaysq instanceof aysk));
      paramString = ((aysk)localaysq).b();
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
    if (this.jdField_a_of_type_Aysi != null) {
      this.jdField_a_of_type_Aysi.updateMetaData(a());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aysi != null) {
      this.jdField_a_of_type_Aysi.activateView(paramBoolean);
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Aysi != null) {
      this.jdField_a_of_type_Aysi.doOnEvent(0);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Aysi != null) {
      this.jdField_a_of_type_Aysi.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysm
 * JD-Core Version:    0.7.0.1
 */