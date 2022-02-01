import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class anch
  implements Manager
{
  private anbs jdField_a_of_type_Anbs;
  private anby jdField_a_of_type_Anby;
  private anbz jdField_a_of_type_Anbz;
  private ancc jdField_a_of_type_Ancc;
  private ancd jdField_a_of_type_Ancd;
  private ancg jdField_a_of_type_Ancg;
  private anci jdField_a_of_type_Anci;
  private anhq jdField_a_of_type_Anhq;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<anct>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public anch(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_Ancc = new ancc(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_Ancc);
    this.jdField_a_of_type_Anci = new anci(this.jdField_a_of_type_Ancc, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_Ancg = new ancg(this.jdField_a_of_type_Ancc, this.jdField_a_of_type_Anci);
    this.jdField_a_of_type_Ancd = new ancd(this.jdField_a_of_type_Ancc);
    this.jdField_a_of_type_Anbz = new anbz(this.jdField_a_of_type_Ancc, this.jdField_a_of_type_Anci, this.jdField_a_of_type_Ancd, this.jdField_a_of_type_Ancg);
    this.jdField_a_of_type_Ancc.a(this.jdField_a_of_type_Ancd);
  }
  
  public anbs a()
  {
    return this.jdField_a_of_type_Anbs;
  }
  
  public anby a()
  {
    return this.jdField_a_of_type_Anby;
  }
  
  public anbz a()
  {
    return this.jdField_a_of_type_Anbz;
  }
  
  public ancc a()
  {
    return this.jdField_a_of_type_Ancc;
  }
  
  public ancd a()
  {
    return this.jdField_a_of_type_Ancd;
  }
  
  public ancg a()
  {
    return this.jdField_a_of_type_Ancg;
  }
  
  public anci a()
  {
    return this.jdField_a_of_type_Anci;
  }
  
  public anhq a()
  {
    return this.jdField_a_of_type_Anhq;
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
    if (this.jdField_a_of_type_Anbz != null) {
      this.jdField_a_of_type_Anbz.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!anck.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = anck.a(a());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.jdField_a_of_type_Anby == null);
    this.jdField_a_of_type_Anby.c();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = anck.a(a());
    if (localObject != null) {
      ((anbt)localObject).a(paramInt, paramArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      anct localanct = (anct)((WeakReference)((Iterator)localObject).next()).get();
      if (localanct != null) {
        localanct.a(paramInt, paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      anis.a(anck.b(this.jdField_a_of_type_Ancc.e), 1, paramInt, 0L, paramVarArgs);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      anct localanct = (anct)((WeakReference)localIterator.next()).get();
      if (localanct != null) {
        localanct.a(paramInt, paramVarArgs);
      }
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
  
  public void a(anct paramanct)
  {
    if (paramanct != null)
    {
      paramanct = new WeakReference(paramanct);
      this.jdField_a_of_type_JavaUtilList.add(paramanct);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.jdField_a_of_type_Ancc.a(paramSessionInfo.curType, 0);
      this.jdField_a_of_type_Ancc.jdField_a_of_type_JavaLangString = paramSessionInfo.curFriendUin;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Ancc.a(paramBaseChatPie);
    paramBaseChatPie = a();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (amog)paramBaseChatPie.getManager(QQManagerFactory.APOLLO_RESPONSE_MANAGER);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_Anhq == null) {
      this.jdField_a_of_type_Anhq = new anhq(this.jdField_a_of_type_Ancc);
    }
    if (this.jdField_a_of_type_Anbs == null) {
      this.jdField_a_of_type_Anbs = new anbs(this.jdField_a_of_type_Ancc);
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_Anby = new anby(this.jdField_a_of_type_Ancc, paramApolloTextureView);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, false);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.d(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_Ancc == null) || (this.jdField_a_of_type_Anbz == null) || (this.jdField_a_of_type_Ancg == null)) {
      return;
    }
    this.jdField_a_of_type_Ancc.c(true);
    int i = anck.b(this.jdField_a_of_type_Ancc.e);
    this.jdField_a_of_type_Ancc.b(i);
    if (!this.jdField_a_of_type_Ancc.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_Ancc.a(paramInt, 0);
    this.jdField_a_of_type_Ancc.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ancc.b();
    this.jdField_a_of_type_Ancc.a();
    if ((!paramBoolean) && (!anck.b(a(), paramInt, paramString)))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    anis.a(i, 200);
    this.jdField_a_of_type_Anbz.a(this.jdField_a_of_type_Anhq);
    this.jdField_a_of_type_Ancg.a();
    anis.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Ancc.b(true);
    String str1;
    if (!this.jdField_a_of_type_Anci.b(null))
    {
      anis.a(i, 300);
      this.jdField_a_of_type_Anbz.a(this.jdField_a_of_type_Ancc);
      anis.a(i, 300, 0, new Object[] { "initSprite done" });
      anis.a(i, 1, 0, new Object[] { "terminal all done" });
      anis.a(i, null, new int[] { anir.a(i, false, this.jdField_a_of_type_Ancc.b, paramInt, true) });
      this.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (paramInt != 0)) {
        break label508;
      }
      i = anhm.a(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentUin(), (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      str1 = String.valueOf(anhm.a(paramString, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
    }
    for (String str2 = String.valueOf(i);; str2 = "")
    {
      QQAppInterface localQQAppInterface = a();
      if (this.jdField_a_of_type_Ancc.d == 1) {}
      for (i = 1;; i = 0)
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ApolloUtil.h(this.jdField_a_of_type_Ancc.b), new String[] { Integer.toString(ApolloUtil.b(paramInt)), str2, str1, paramString });
        return;
        anis.a(i, null, new int[] { anir.a(i, true, this.jdField_a_of_type_Ancc.b, paramInt, true) });
        break;
      }
      label508:
      str1 = "";
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!anck.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = anck.a(a());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.jdField_a_of_type_Anby == null);
    this.jdField_a_of_type_Anby.d();
  }
  
  public void onDestroy()
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
    if (this.jdField_a_of_type_Anhq != null)
    {
      this.jdField_a_of_type_Anhq.a();
      this.jdField_a_of_type_Anhq = null;
    }
    if (this.jdField_a_of_type_Anbs != null)
    {
      this.jdField_a_of_type_Anbs.a();
      this.jdField_a_of_type_Anbs = null;
    }
    if (this.jdField_a_of_type_Anby != null)
    {
      this.jdField_a_of_type_Anby.f();
      this.jdField_a_of_type_Anby = null;
    }
    this.jdField_a_of_type_Anci.a();
    this.jdField_a_of_type_Ancg.b();
    this.jdField_a_of_type_Anbz.b();
    this.jdField_a_of_type_Ancc.c();
    this.jdField_a_of_type_Boolean = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = a();
    if (localObject == null) {}
    while (this.jdField_a_of_type_Ancc.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Ancc.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anch
 * JD-Core Version:    0.7.0.1
 */