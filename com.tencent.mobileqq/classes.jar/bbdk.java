import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qphone.base.util.QLog;

public class bbdk
  extends bbdt
  implements bbdl
{
  private static bbdb jdField_a_of_type_Bbdb = new bbdb();
  private int jdField_a_of_type_Int = 0;
  private bbdf jdField_a_of_type_Bbdf;
  private bbdg jdField_a_of_type_Bbdg;
  
  public bbdk(bbdf parambbdf)
  {
    this.jdField_a_of_type_Bbdf = parambbdf;
    if ((this.jdField_a_of_type_Bbdf != null) && (QLog.isColorLevel())) {
      QLog.d("ArkRichNode", 2, "id:" + this.jdField_a_of_type_Bbdf.a() + " appname:" + this.jdField_a_of_type_Bbdf.b() + " viewname:" + this.jdField_a_of_type_Bbdf.d() + " miniversion:" + this.jdField_a_of_type_Bbdf.c() + " path：" + this.jdField_a_of_type_Bbdf.a());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bbdg a()
  {
    return this.jdField_a_of_type_Bbdg;
  }
  
  public bbdo a(Context paramContext)
  {
    if (this.jdField_a_of_type_Bbdf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRichNode", 2, "onCreate config = null");
      }
      return null;
    }
    bbdi localbbdi = new bbdi(this, paramContext);
    localbbdi.a(this);
    localbbdi.a(paramContext);
    jdField_a_of_type_Bbdb.a(this);
    this.jdField_a_of_type_Bbdg = new bbdg(jdField_a_of_type_Bbdb);
    String str = a();
    this.jdField_a_of_type_Bbdg.a(this.jdField_a_of_type_Bbdf, str, paramContext.getResources().getDisplayMetrics().scaledDensity);
    this.jdField_a_of_type_Bbdg.setFixSize(-1, -1);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Bbdg.setMaxSize(i, -1);
    this.jdField_a_of_type_Bbdg.setMinSize(i, -1);
    localbbdi.a(this.jdField_a_of_type_Bbdg);
    this.jdField_a_of_type_Bbdg.activateView(true);
    return localbbdi;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onDestroy");
    }
    if (jdField_a_of_type_Bbdb != null) {
      jdField_a_of_type_Bbdb.b(this);
    }
    if (this.jdField_a_of_type_Bbdg != null)
    {
      this.jdField_a_of_type_Bbdg.doOnEvent(2);
      this.jdField_a_of_type_Bbdg.a();
      this.jdField_a_of_type_Bbdg = null;
    }
    this.jdField_a_of_type_Bbdf = null;
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
      bbdo localbbdo;
      do
      {
        do
        {
          return;
          localbbdo = a();
        } while (localbbdo == null);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        paramString = localbbdo.a();
        if (paramString != null) {
          paramString.setContentDescription(localStringBuilder);
        }
      } while (!(localbbdo instanceof bbdi));
      paramString = ((bbdi)localbbdo).b();
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
    if (this.jdField_a_of_type_Bbdg != null) {
      this.jdField_a_of_type_Bbdg.updateMetaData(a());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bbdg != null) {
      this.jdField_a_of_type_Bbdg.activateView(paramBoolean);
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Bbdg != null) {
      this.jdField_a_of_type_Bbdg.doOnEvent(0);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Bbdg != null) {
      this.jdField_a_of_type_Bbdg.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdk
 * JD-Core Version:    0.7.0.1
 */