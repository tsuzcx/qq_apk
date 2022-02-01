import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class angf
  implements Manager
{
  private anfq jdField_a_of_type_Anfq;
  private anfw jdField_a_of_type_Anfw;
  private anfx jdField_a_of_type_Anfx;
  private anga jdField_a_of_type_Anga;
  private angb jdField_a_of_type_Angb;
  private ange jdField_a_of_type_Ange;
  private angg jdField_a_of_type_Angg;
  private anlo jdField_a_of_type_Anlo;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<angr>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public angf(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_Anga = new anga(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_Anga);
    this.jdField_a_of_type_Angg = new angg(this.jdField_a_of_type_Anga, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_Ange = new ange(this.jdField_a_of_type_Anga, this.jdField_a_of_type_Angg);
    this.jdField_a_of_type_Angb = new angb(this.jdField_a_of_type_Anga);
    this.jdField_a_of_type_Anfx = new anfx(this.jdField_a_of_type_Anga, this.jdField_a_of_type_Angg, this.jdField_a_of_type_Angb);
    this.jdField_a_of_type_Anga.a(this.jdField_a_of_type_Angb);
  }
  
  public anfq a()
  {
    return this.jdField_a_of_type_Anfq;
  }
  
  public anfw a()
  {
    return this.jdField_a_of_type_Anfw;
  }
  
  public anfx a()
  {
    return this.jdField_a_of_type_Anfx;
  }
  
  public anga a()
  {
    return this.jdField_a_of_type_Anga;
  }
  
  public angb a()
  {
    return this.jdField_a_of_type_Angb;
  }
  
  public ange a()
  {
    return this.jdField_a_of_type_Ange;
  }
  
  public angg a()
  {
    return this.jdField_a_of_type_Angg;
  }
  
  public anlo a()
  {
    return this.jdField_a_of_type_Anlo;
  }
  
  public SpriteUIHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
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
    if (this.jdField_a_of_type_Anfx != null) {
      this.jdField_a_of_type_Anfx.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!angi.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = angi.a(a());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.jdField_a_of_type_Anfw == null);
    this.jdField_a_of_type_Anfw.c();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = angi.a(a());
    if (localObject != null) {
      ((anfr)localObject).a(paramInt, paramArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      angr localangr = (angr)((WeakReference)((Iterator)localObject).next()).get();
      if (localangr != null) {
        localangr.a(paramInt, paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      anmq.a(angi.b(this.jdField_a_of_type_Anga.e), 1, paramInt, 0L, paramVarArgs);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      angr localangr = (angr)((WeakReference)localIterator.next()).get();
      if (localangr != null) {
        localangr.a(paramInt, paramVarArgs);
      }
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
  
  public void a(angr paramangr)
  {
    if (paramangr != null)
    {
      paramangr = new WeakReference(paramangr);
      this.jdField_a_of_type_JavaUtilList.add(paramangr);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Anga.a(paramBaseChatPie);
    paramBaseChatPie = a();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (amum)paramBaseChatPie.getManager(232);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_Anlo == null) {
      this.jdField_a_of_type_Anlo = new anlo(this.jdField_a_of_type_Anga);
    }
    if (this.jdField_a_of_type_Anfq == null) {
      this.jdField_a_of_type_Anfq = new anfq(this.jdField_a_of_type_Anga);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.jdField_a_of_type_Anga.a(paramSessionInfo.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Anga.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_Anfw = new anfw(this.jdField_a_of_type_Anga, paramApolloTextureView);
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.d(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Anfx == null) || (this.jdField_a_of_type_Ange == null)) {
      return;
    }
    this.jdField_a_of_type_Anga.c(true);
    int i = angi.b(this.jdField_a_of_type_Anga.e);
    this.jdField_a_of_type_Anga.b(i);
    if (!this.jdField_a_of_type_Anga.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_Anga.a(paramInt, 0);
    this.jdField_a_of_type_Anga.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Anga.b();
    this.jdField_a_of_type_Anga.a();
    if (!angi.b(a(), paramInt, paramString))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    anmq.a(i, 200);
    this.jdField_a_of_type_Anfx.a(this.jdField_a_of_type_Anlo);
    this.jdField_a_of_type_Ange.a();
    anmq.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Anga.b(true);
    String str1;
    if (!this.jdField_a_of_type_Angg.b(null))
    {
      anmq.a(i, 300);
      this.jdField_a_of_type_Anfx.a(this.jdField_a_of_type_Anga);
      anmq.a(i, 300, 0, new Object[] { "initSprite done" });
      anmq.a(i, 1, 0, new Object[] { "terminal all done" });
      anmq.a(i, null, new int[] { anmp.a(i, false, this.jdField_a_of_type_Anga.b, paramInt, true) });
      this.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (paramInt != 0)) {
        break label487;
      }
      i = anlk.a(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c(), (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      str1 = String.valueOf(anlk.a(paramString, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
    }
    for (String str2 = String.valueOf(i);; str2 = "")
    {
      QQAppInterface localQQAppInterface = a();
      if (this.jdField_a_of_type_Anga.d == 1) {}
      for (i = 1;; i = 0)
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ApolloUtil.h(this.jdField_a_of_type_Anga.b), new String[] { Integer.toString(ApolloUtil.b(paramInt)), str2, str1, paramString });
        return;
        anmq.a(i, null, new int[] { anmp.a(i, true, this.jdField_a_of_type_Anga.b, paramInt, true) });
        break;
      }
      label487:
      str1 = "";
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!angi.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = angi.a(a());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.jdField_a_of_type_Anfw == null);
    this.jdField_a_of_type_Anfw.d();
  }
  
  public void onDestroy()
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
    if (this.jdField_a_of_type_Anlo != null)
    {
      this.jdField_a_of_type_Anlo.a();
      this.jdField_a_of_type_Anlo = null;
    }
    if (this.jdField_a_of_type_Anfq != null)
    {
      this.jdField_a_of_type_Anfq.a();
      this.jdField_a_of_type_Anfq = null;
    }
    if (this.jdField_a_of_type_Anfw != null)
    {
      this.jdField_a_of_type_Anfw.f();
      this.jdField_a_of_type_Anfw = null;
    }
    this.jdField_a_of_type_Angg.a();
    this.jdField_a_of_type_Ange.b();
    this.jdField_a_of_type_Anfx.b();
    this.jdField_a_of_type_Anga.c();
    this.jdField_a_of_type_Boolean = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = a();
    if (localObject == null) {}
    while (this.jdField_a_of_type_Anga.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Anga.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angf
 * JD-Core Version:    0.7.0.1
 */