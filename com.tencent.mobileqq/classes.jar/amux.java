import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class amux
{
  private amtx jdField_a_of_type_Amtx;
  private amug jdField_a_of_type_Amug;
  private amuh jdField_a_of_type_Amuh;
  private amuk jdField_a_of_type_Amuk;
  private amuw jdField_a_of_type_Amuw;
  private amuy jdField_a_of_type_Amuy;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public amux(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Amug = new amug(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Amuy = new amuy(this.jdField_a_of_type_Amug);
    this.jdField_a_of_type_Amuk = new amuk(this.jdField_a_of_type_Amug, this.jdField_a_of_type_Amuy);
    this.jdField_a_of_type_Amuh = new amuh(this.jdField_a_of_type_Amug);
    this.jdField_a_of_type_Amuw = new amuw(this.jdField_a_of_type_Amug, this.jdField_a_of_type_Amuy, this.jdField_a_of_type_Amuh, this.jdField_a_of_type_Amuk);
    this.jdField_a_of_type_Amug.a(this.jdField_a_of_type_Amuh);
    paramQQAppInterface = amuo.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public amtx a()
  {
    return this.jdField_a_of_type_Amtx;
  }
  
  public amug a()
  {
    return this.jdField_a_of_type_Amug;
  }
  
  public amuw a()
  {
    return this.jdField_a_of_type_Amuw;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Amuw != null) {
      this.jdField_a_of_type_Amuw.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    amlw localamlw = new amlw(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_Amug.a(localamlw);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Amug == null) || (this.jdField_a_of_type_Amuw == null) || (this.jdField_a_of_type_Amuk == null)) {
      return;
    }
    this.jdField_a_of_type_Amug.c(true);
    int i = amuo.b(this.jdField_a_of_type_Amug.e);
    this.jdField_a_of_type_Amug.b(i);
    anaw.a(i, 100, 0, new Object[] { "onSurfaceReady" });
    this.jdField_a_of_type_Amug.a(-2, paramInt);
    anaw.a(i, 200);
    this.jdField_a_of_type_Amuk.a();
    anaw.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Amug.b(true);
    anaw.a(i, 300);
    this.jdField_a_of_type_Amuw.a(this.jdField_a_of_type_Amug);
    anaw.a(i, 300, 0, new Object[] { "initSprite done" });
    anaw.a(i, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Amtx = ((amtx)this.jdField_a_of_type_Amuk.a(0));
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    amtx localamtx = a();
    if ((localamtx != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_Amug.jdField_b_of_type_JavaLangString)) {
          localamtx.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      anaw.a(amuo.b(this.jdField_a_of_type_Amug.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void a(amkg paramamkg)
  {
    if (paramamkg == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Amug.a(paramamkg);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Amug.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramamkg);
  }
  
  public void a(amur paramamur)
  {
    if (paramamur != null) {
      this.jdField_a_of_type_Amug.a(paramamur);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Amug.a(paramString);
    this.jdField_a_of_type_Amug.jdField_b_of_type_Int = amhd.a(a(), paramString);
  }
  
  public void b()
  {
    if (!amuo.d(a())) {
      return;
    }
    if (this.jdField_a_of_type_Amtx != null) {
      this.jdField_a_of_type_Amtx.c(1);
    }
    this.jdField_a_of_type_Amug.a(-1);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Amug != null) {
      this.jdField_a_of_type_Amug.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!amuo.d(a())) {}
    while (this.jdField_a_of_type_Amtx == null) {
      return;
    }
    this.jdField_a_of_type_Amtx.c(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Amuh != null) {
      this.jdField_a_of_type_Amuh.a();
    }
    Object localObject = this.jdField_a_of_type_Amug.a();
    if (localObject != null)
    {
      localObject = ((amkg)localObject).getRenderImpl();
      if (localObject != null) {
        ((amir)localObject).c();
      }
    }
    anaw.a(this.jdField_a_of_type_Amug.a(), true);
    this.jdField_a_of_type_Amuy.a();
    this.jdField_a_of_type_Amuk.b();
    this.jdField_a_of_type_Amug.c();
    this.jdField_a_of_type_Amuw.b();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amux
 * JD-Core Version:    0.7.0.1
 */