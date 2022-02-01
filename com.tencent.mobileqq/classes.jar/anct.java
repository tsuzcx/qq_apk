import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class anct
{
  private anbt jdField_a_of_type_Anbt;
  private ancc jdField_a_of_type_Ancc;
  private ancd jdField_a_of_type_Ancd;
  private ancg jdField_a_of_type_Ancg;
  private ancs jdField_a_of_type_Ancs;
  private ancu jdField_a_of_type_Ancu;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public anct(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Ancc = new ancc(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Ancu = new ancu(this.jdField_a_of_type_Ancc);
    this.jdField_a_of_type_Ancg = new ancg(this.jdField_a_of_type_Ancc, this.jdField_a_of_type_Ancu);
    this.jdField_a_of_type_Ancd = new ancd(this.jdField_a_of_type_Ancc);
    this.jdField_a_of_type_Ancs = new ancs(this.jdField_a_of_type_Ancc, this.jdField_a_of_type_Ancu, this.jdField_a_of_type_Ancd, this.jdField_a_of_type_Ancg);
    this.jdField_a_of_type_Ancc.a(this.jdField_a_of_type_Ancd);
    paramQQAppInterface = anck.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public anbt a()
  {
    return this.jdField_a_of_type_Anbt;
  }
  
  public ancc a()
  {
    return this.jdField_a_of_type_Ancc;
  }
  
  public ancs a()
  {
    return this.jdField_a_of_type_Ancs;
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
    if (this.jdField_a_of_type_Ancs != null) {
      this.jdField_a_of_type_Ancs.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    amrl localamrl = new amrl(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_Ancc.a(localamrl);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Ancc == null) || (this.jdField_a_of_type_Ancs == null) || (this.jdField_a_of_type_Ancg == null)) {
      return;
    }
    this.jdField_a_of_type_Ancc.c(true);
    int i = anck.b(this.jdField_a_of_type_Ancc.e);
    this.jdField_a_of_type_Ancc.b(i);
    anis.a(i, 100, 0, new Object[] { "onSurfaceReady" });
    this.jdField_a_of_type_Ancc.a(-2, paramInt);
    anis.a(i, 200);
    this.jdField_a_of_type_Ancg.a();
    anis.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Ancc.b(true);
    anis.a(i, 300);
    this.jdField_a_of_type_Ancs.a(this.jdField_a_of_type_Ancc);
    anis.a(i, 300, 0, new Object[] { "initSprite done" });
    anis.a(i, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Anbt = ((anbt)this.jdField_a_of_type_Ancg.a(0));
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    anbt localanbt = a();
    if ((localanbt != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_Ancc.jdField_b_of_type_JavaLangString)) {
          localanbt.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      anis.a(anck.b(this.jdField_a_of_type_Ancc.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void a(ampv paramampv)
  {
    if (paramampv == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Ancc.a(paramampv);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramampv);
  }
  
  public void a(ancn paramancn)
  {
    if (paramancn != null) {
      this.jdField_a_of_type_Ancc.a(paramancn);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Ancc.a(paramString);
    this.jdField_a_of_type_Ancc.jdField_b_of_type_Int = amme.a(a(), paramString);
  }
  
  public void b()
  {
    if (!anck.e(a())) {
      return;
    }
    if (this.jdField_a_of_type_Anbt != null) {
      this.jdField_a_of_type_Anbt.c(1);
    }
    this.jdField_a_of_type_Ancc.a(-1);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Ancc != null) {
      this.jdField_a_of_type_Ancc.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!anck.e(a())) {}
    while (this.jdField_a_of_type_Anbt == null) {
      return;
    }
    this.jdField_a_of_type_Anbt.c(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ancd != null) {
      this.jdField_a_of_type_Ancd.a();
    }
    Object localObject = this.jdField_a_of_type_Ancc.a();
    if (localObject != null)
    {
      localObject = ((ampv)localObject).getRenderImpl();
      if (localObject != null) {
        ((amnw)localObject).c();
      }
    }
    anis.a(this.jdField_a_of_type_Ancc.a(), true);
    this.jdField_a_of_type_Ancu.a();
    this.jdField_a_of_type_Ancg.b();
    this.jdField_a_of_type_Ancc.c();
    this.jdField_a_of_type_Ancs.b();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anct
 * JD-Core Version:    0.7.0.1
 */