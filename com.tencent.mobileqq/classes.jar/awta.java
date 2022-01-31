import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qphone.base.util.QLog;

public class awta
  extends awtj
  implements awtb
{
  private static awsr jdField_a_of_type_Awsr = new awsr();
  private int jdField_a_of_type_Int = 0;
  private awsv jdField_a_of_type_Awsv;
  private awsw jdField_a_of_type_Awsw;
  
  public awta(awsv paramawsv)
  {
    this.jdField_a_of_type_Awsv = paramawsv;
    if ((this.jdField_a_of_type_Awsv != null) && (QLog.isColorLevel())) {
      QLog.d("ArkRichNode", 2, "id:" + this.jdField_a_of_type_Awsv.a() + " appname:" + this.jdField_a_of_type_Awsv.b() + " viewname:" + this.jdField_a_of_type_Awsv.d() + " miniversion:" + this.jdField_a_of_type_Awsv.c() + " path：" + this.jdField_a_of_type_Awsv.a());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public awsw a()
  {
    return this.jdField_a_of_type_Awsw;
  }
  
  public awte a(Context paramContext)
  {
    if (this.jdField_a_of_type_Awsv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRichNode", 2, "onCreate config = null");
      }
      return null;
    }
    awsy localawsy = new awsy(this, paramContext);
    localawsy.a(this);
    localawsy.a(paramContext);
    jdField_a_of_type_Awsr.a(this);
    this.jdField_a_of_type_Awsw = new awsw(jdField_a_of_type_Awsr);
    String str = a();
    this.jdField_a_of_type_Awsw.a(this.jdField_a_of_type_Awsv, str, paramContext.getResources().getDisplayMetrics().scaledDensity);
    this.jdField_a_of_type_Awsw.setFixSize(-1, -1);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Awsw.setMaxSize(i, -1);
    this.jdField_a_of_type_Awsw.setMinSize(i, -1);
    localawsy.a(this.jdField_a_of_type_Awsw);
    this.jdField_a_of_type_Awsw.activateView(true);
    return localawsy;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onDestroy");
    }
    if (jdField_a_of_type_Awsr != null) {
      jdField_a_of_type_Awsr.b(this);
    }
    if (this.jdField_a_of_type_Awsw != null)
    {
      this.jdField_a_of_type_Awsw.doOnEvent(2);
      this.jdField_a_of_type_Awsw.a();
      this.jdField_a_of_type_Awsw = null;
    }
    this.jdField_a_of_type_Awsv = null;
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
      awte localawte;
      do
      {
        do
        {
          return;
          localawte = a();
        } while (localawte == null);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        paramString = localawte.a();
        if (paramString != null) {
          paramString.setContentDescription(localStringBuilder);
        }
      } while (!(localawte instanceof awsy));
      paramString = ((awsy)localawte).b();
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
    if (this.jdField_a_of_type_Awsw != null) {
      this.jdField_a_of_type_Awsw.updateMetaData(a());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Awsw != null) {
      this.jdField_a_of_type_Awsw.activateView(paramBoolean);
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Awsw != null) {
      this.jdField_a_of_type_Awsw.doOnEvent(0);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Awsw != null) {
      this.jdField_a_of_type_Awsw.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awta
 * JD-Core Version:    0.7.0.1
 */