import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class angr
{
  private anfr jdField_a_of_type_Anfr;
  private anga jdField_a_of_type_Anga;
  private angb jdField_a_of_type_Angb;
  private ange jdField_a_of_type_Ange;
  private angq jdField_a_of_type_Angq;
  private angs jdField_a_of_type_Angs;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public angr(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Anga = new anga(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Angs = new angs(this.jdField_a_of_type_Anga);
    this.jdField_a_of_type_Ange = new ange(this.jdField_a_of_type_Anga, this.jdField_a_of_type_Angs);
    this.jdField_a_of_type_Angb = new angb(this.jdField_a_of_type_Anga);
    this.jdField_a_of_type_Angq = new angq(this.jdField_a_of_type_Anga, this.jdField_a_of_type_Angs, this.jdField_a_of_type_Angb, this.jdField_a_of_type_Ange);
    this.jdField_a_of_type_Anga.a(this.jdField_a_of_type_Angb);
    paramQQAppInterface = angi.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this);
    }
  }
  
  public anfr a()
  {
    return this.jdField_a_of_type_Anfr;
  }
  
  public anga a()
  {
    return this.jdField_a_of_type_Anga;
  }
  
  public angq a()
  {
    return this.jdField_a_of_type_Angq;
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
    if (this.jdField_a_of_type_Angq != null) {
      this.jdField_a_of_type_Angq.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    amxq localamxq = new amxq(paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_Anga.a(localamxq);
  }
  
  public void a(int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteDrawerInfoManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Angq == null) || (this.jdField_a_of_type_Ange == null)) {
      return;
    }
    this.jdField_a_of_type_Anga.c(true);
    int i = angi.b(this.jdField_a_of_type_Anga.e);
    this.jdField_a_of_type_Anga.b(i);
    anmq.a(i, 100, 0, new Object[] { "onSurfaceReady" });
    this.jdField_a_of_type_Anga.a(-2, paramInt);
    anmq.a(i, 200);
    this.jdField_a_of_type_Ange.a();
    anmq.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Anga.b(true);
    anmq.a(i, 300);
    this.jdField_a_of_type_Angq.a(this.jdField_a_of_type_Anga);
    anmq.a(i, 300, 0, new Object[] { "initSprite done" });
    anmq.a(i, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Anfr = ((anfr)this.jdField_a_of_type_Ange.a(0));
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    anfr localanfr = a();
    if ((localanfr != null) && (paramArrayList != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(this.jdField_a_of_type_Anga.jdField_b_of_type_JavaLangString)) {
          localanfr.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      anmq.a(angi.b(this.jdField_a_of_type_Anga.e), 1, paramInt, 0L, paramVarArgs);
    }
  }
  
  public void a(amwa paramamwa)
  {
    if (paramamwa == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Anga.a(paramamwa);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Anga.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramamwa);
  }
  
  public void a(angl paramangl)
  {
    if (paramangl != null) {
      this.jdField_a_of_type_Anga.a(paramangl);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Anga.a(paramString);
    this.jdField_a_of_type_Anga.jdField_b_of_type_Int = amsx.a(a(), paramString);
  }
  
  public void b()
  {
    if (!angi.d(a())) {
      return;
    }
    if (this.jdField_a_of_type_Anfr != null) {
      this.jdField_a_of_type_Anfr.c(1);
    }
    this.jdField_a_of_type_Anga.a(-1);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Anga != null) {
      this.jdField_a_of_type_Anga.a(-2, paramInt);
    }
  }
  
  public void c()
  {
    if (!angi.d(a())) {}
    while (this.jdField_a_of_type_Anfr == null) {
      return;
    }
    this.jdField_a_of_type_Anfr.c(2);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Angb != null) {
      this.jdField_a_of_type_Angb.a();
    }
    Object localObject = this.jdField_a_of_type_Anga.a();
    if (localObject != null)
    {
      localObject = ((amwa)localObject).getRenderImpl();
      if (localObject != null) {
        ((amul)localObject).c();
      }
    }
    anmq.a(this.jdField_a_of_type_Anga.a(), true);
    this.jdField_a_of_type_Angs.a();
    this.jdField_a_of_type_Ange.b();
    this.jdField_a_of_type_Anga.c();
    this.jdField_a_of_type_Angq.b();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angr
 * JD-Core Version:    0.7.0.1
 */