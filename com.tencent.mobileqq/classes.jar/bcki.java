import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qphone.base.util.QLog;

public class bcki
  extends bckr
  implements bckj
{
  private static bcjz jdField_a_of_type_Bcjz = new bcjz();
  private int jdField_a_of_type_Int = 0;
  private bckd jdField_a_of_type_Bckd;
  private bcke jdField_a_of_type_Bcke;
  
  public bcki(bckd parambckd)
  {
    this.jdField_a_of_type_Bckd = parambckd;
    if ((this.jdField_a_of_type_Bckd != null) && (QLog.isColorLevel())) {
      QLog.d("ArkRichNode", 2, "id:" + this.jdField_a_of_type_Bckd.a() + " appname:" + this.jdField_a_of_type_Bckd.b() + " viewname:" + this.jdField_a_of_type_Bckd.d() + " miniversion:" + this.jdField_a_of_type_Bckd.c() + " path：" + this.jdField_a_of_type_Bckd.a());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bcke a()
  {
    return this.jdField_a_of_type_Bcke;
  }
  
  public bckm a(Context paramContext)
  {
    if (this.jdField_a_of_type_Bckd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRichNode", 2, "onCreate config = null");
      }
      return null;
    }
    bckg localbckg = new bckg(this, paramContext);
    localbckg.a(this);
    localbckg.a(paramContext);
    jdField_a_of_type_Bcjz.a(this);
    this.jdField_a_of_type_Bcke = new bcke(jdField_a_of_type_Bcjz);
    String str = a();
    this.jdField_a_of_type_Bcke.a(this.jdField_a_of_type_Bckd, str, paramContext.getResources().getDisplayMetrics().scaledDensity);
    this.jdField_a_of_type_Bcke.setFixSize(-1, -1);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Bcke.setMaxSize(i, -1);
    this.jdField_a_of_type_Bcke.setMinSize(i, -1);
    localbckg.a(this.jdField_a_of_type_Bcke);
    this.jdField_a_of_type_Bcke.activateView(true);
    return localbckg;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onDestroy");
    }
    if (jdField_a_of_type_Bcjz != null) {
      jdField_a_of_type_Bcjz.b(this);
    }
    if (this.jdField_a_of_type_Bcke != null)
    {
      this.jdField_a_of_type_Bcke.doOnEvent(2);
      this.jdField_a_of_type_Bcke.a();
      this.jdField_a_of_type_Bcke = null;
    }
    this.jdField_a_of_type_Bckd = null;
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
      bckm localbckm;
      do
      {
        do
        {
          return;
          localbckm = a();
        } while (localbckm == null);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        paramString = localbckm.a();
        if (paramString != null) {
          paramString.setContentDescription(localStringBuilder);
        }
      } while (!(localbckm instanceof bckg));
      paramString = ((bckg)localbckm).b();
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
    if (this.jdField_a_of_type_Bcke != null) {
      this.jdField_a_of_type_Bcke.updateMetaData(a());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bcke != null) {
      this.jdField_a_of_type_Bcke.activateView(paramBoolean);
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bcke != null) {
      this.jdField_a_of_type_Bcke.doOnEvent(0);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Bcke != null) {
      this.jdField_a_of_type_Bcke.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcki
 * JD-Core Version:    0.7.0.1
 */