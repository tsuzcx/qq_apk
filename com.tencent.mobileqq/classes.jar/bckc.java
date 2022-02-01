import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qphone.base.util.QLog;

public class bckc
  extends bckl
  implements bckd
{
  private static bcjt jdField_a_of_type_Bcjt = new bcjt();
  private int jdField_a_of_type_Int = 0;
  private bcjx jdField_a_of_type_Bcjx;
  private bcjy jdField_a_of_type_Bcjy;
  
  public bckc(bcjx parambcjx)
  {
    this.jdField_a_of_type_Bcjx = parambcjx;
    if ((this.jdField_a_of_type_Bcjx != null) && (QLog.isColorLevel())) {
      QLog.d("ArkRichNode", 2, "id:" + this.jdField_a_of_type_Bcjx.a() + " appname:" + this.jdField_a_of_type_Bcjx.b() + " viewname:" + this.jdField_a_of_type_Bcjx.d() + " miniversion:" + this.jdField_a_of_type_Bcjx.c() + " path：" + this.jdField_a_of_type_Bcjx.a());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bcjy a()
  {
    return this.jdField_a_of_type_Bcjy;
  }
  
  public bckg a(Context paramContext)
  {
    if (this.jdField_a_of_type_Bcjx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRichNode", 2, "onCreate config = null");
      }
      return null;
    }
    bcka localbcka = new bcka(this, paramContext);
    localbcka.a(this);
    localbcka.a(paramContext);
    jdField_a_of_type_Bcjt.a(this);
    this.jdField_a_of_type_Bcjy = new bcjy(jdField_a_of_type_Bcjt);
    String str = a();
    this.jdField_a_of_type_Bcjy.a(this.jdField_a_of_type_Bcjx, str, paramContext.getResources().getDisplayMetrics().scaledDensity);
    this.jdField_a_of_type_Bcjy.setFixSize(-1, -1);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Bcjy.setMaxSize(i, -1);
    this.jdField_a_of_type_Bcjy.setMinSize(i, -1);
    localbcka.a(this.jdField_a_of_type_Bcjy);
    this.jdField_a_of_type_Bcjy.activateView(true);
    return localbcka;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onDestroy");
    }
    if (jdField_a_of_type_Bcjt != null) {
      jdField_a_of_type_Bcjt.b(this);
    }
    if (this.jdField_a_of_type_Bcjy != null)
    {
      this.jdField_a_of_type_Bcjy.doOnEvent(2);
      this.jdField_a_of_type_Bcjy.a();
      this.jdField_a_of_type_Bcjy = null;
    }
    this.jdField_a_of_type_Bcjx = null;
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
      bckg localbckg;
      do
      {
        do
        {
          return;
          localbckg = a();
        } while (localbckg == null);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        paramString = localbckg.a();
        if (paramString != null) {
          paramString.setContentDescription(localStringBuilder);
        }
      } while (!(localbckg instanceof bcka));
      paramString = ((bcka)localbckg).b();
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
    if (this.jdField_a_of_type_Bcjy != null) {
      this.jdField_a_of_type_Bcjy.updateMetaData(a());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bcjy != null) {
      this.jdField_a_of_type_Bcjy.activateView(paramBoolean);
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bcjy != null) {
      this.jdField_a_of_type_Bcjy.doOnEvent(0);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Bcjy != null) {
      this.jdField_a_of_type_Bcjy.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckc
 * JD-Core Version:    0.7.0.1
 */