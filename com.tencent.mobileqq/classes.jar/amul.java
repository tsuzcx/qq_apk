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

public class amul
  implements Manager
{
  private amtw jdField_a_of_type_Amtw;
  private amuc jdField_a_of_type_Amuc;
  private amud jdField_a_of_type_Amud;
  private amug jdField_a_of_type_Amug;
  private amuh jdField_a_of_type_Amuh;
  private amuk jdField_a_of_type_Amuk;
  private amum jdField_a_of_type_Amum;
  private amzu jdField_a_of_type_Amzu;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<WeakReference<amux>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public amul(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_Amug = new amug(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_Amug);
    this.jdField_a_of_type_Amum = new amum(this.jdField_a_of_type_Amug, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_Amuk = new amuk(this.jdField_a_of_type_Amug, this.jdField_a_of_type_Amum);
    this.jdField_a_of_type_Amuh = new amuh(this.jdField_a_of_type_Amug);
    this.jdField_a_of_type_Amud = new amud(this.jdField_a_of_type_Amug, this.jdField_a_of_type_Amum, this.jdField_a_of_type_Amuh);
    this.jdField_a_of_type_Amug.a(this.jdField_a_of_type_Amuh);
  }
  
  public amtw a()
  {
    return this.jdField_a_of_type_Amtw;
  }
  
  public amuc a()
  {
    return this.jdField_a_of_type_Amuc;
  }
  
  public amud a()
  {
    return this.jdField_a_of_type_Amud;
  }
  
  public amug a()
  {
    return this.jdField_a_of_type_Amug;
  }
  
  public amuh a()
  {
    return this.jdField_a_of_type_Amuh;
  }
  
  public amuk a()
  {
    return this.jdField_a_of_type_Amuk;
  }
  
  public amum a()
  {
    return this.jdField_a_of_type_Amum;
  }
  
  public amzu a()
  {
    return this.jdField_a_of_type_Amzu;
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
    if (this.jdField_a_of_type_Amud != null) {
      this.jdField_a_of_type_Amud.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!amuo.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = amuo.a(a());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.jdField_a_of_type_Amuc == null);
    this.jdField_a_of_type_Amuc.c();
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = amuo.a(a());
    if (localObject != null) {
      ((amtx)localObject).a(paramInt, paramArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      amux localamux = (amux)((WeakReference)((Iterator)localObject).next()).get();
      if (localamux != null) {
        localamux.a(paramInt, paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (!this.jdField_a_of_type_Boolean) {
      anaw.a(amuo.b(this.jdField_a_of_type_Amug.e), 1, paramInt, 0L, paramVarArgs);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      amux localamux = (amux)((WeakReference)localIterator.next()).get();
      if (localamux != null) {
        localamux.a(paramInt, paramVarArgs);
      }
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
  
  public void a(amux paramamux)
  {
    if (paramamux != null)
    {
      paramamux = new WeakReference(paramamux);
      this.jdField_a_of_type_JavaUtilList.add(paramamux);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Amug.a(paramBaseChatPie);
    paramBaseChatPie = a();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (amis)paramBaseChatPie.getManager(232);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_Amzu == null) {
      this.jdField_a_of_type_Amzu = new amzu(this.jdField_a_of_type_Amug);
    }
    if (this.jdField_a_of_type_Amtw == null) {
      this.jdField_a_of_type_Amtw = new amtw(this.jdField_a_of_type_Amug);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.jdField_a_of_type_Amug.a(paramSessionInfo.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Amug.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_Amuc = new amuc(this.jdField_a_of_type_Amug, paramApolloTextureView);
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.d(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_Amug == null) || (this.jdField_a_of_type_Amud == null) || (this.jdField_a_of_type_Amuk == null)) {
      return;
    }
    this.jdField_a_of_type_Amug.c(true);
    int i = amuo.b(this.jdField_a_of_type_Amug.e);
    this.jdField_a_of_type_Amug.b(i);
    if (!this.jdField_a_of_type_Amug.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_Amug.a(paramInt, 0);
    this.jdField_a_of_type_Amug.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Amug.b();
    this.jdField_a_of_type_Amug.a();
    if (!amuo.b(a(), paramInt, paramString))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    anaw.a(i, 200);
    this.jdField_a_of_type_Amud.a(this.jdField_a_of_type_Amzu);
    this.jdField_a_of_type_Amuk.a();
    anaw.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Amug.b(true);
    String str1;
    if (!this.jdField_a_of_type_Amum.b(null))
    {
      anaw.a(i, 300);
      this.jdField_a_of_type_Amud.a(this.jdField_a_of_type_Amug);
      anaw.a(i, 300, 0, new Object[] { "initSprite done" });
      anaw.a(i, 1, 0, new Object[] { "terminal all done" });
      anaw.a(i, null, new int[] { anav.a(i, false, this.jdField_a_of_type_Amug.b, paramInt, true) });
      this.jdField_a_of_type_Boolean = true;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (paramInt != 0)) {
        break label487;
      }
      i = amzq.a(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c(), (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      str1 = String.valueOf(amzq.a(paramString, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
    }
    for (String str2 = String.valueOf(i);; str2 = "")
    {
      QQAppInterface localQQAppInterface = a();
      if (this.jdField_a_of_type_Amug.d == 1) {}
      for (i = 1;; i = 0)
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ApolloUtil.h(this.jdField_a_of_type_Amug.b), new String[] { Integer.toString(ApolloUtil.b(paramInt)), str2, str1, paramString });
        return;
        anaw.a(i, null, new int[] { anav.a(i, true, this.jdField_a_of_type_Amug.b, paramInt, true) });
        break;
      }
      label487:
      str1 = "";
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!amuo.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = amuo.a(a());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.jdField_a_of_type_Amuc == null);
    this.jdField_a_of_type_Amuc.d();
  }
  
  public void onDestroy()
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
    if (this.jdField_a_of_type_Amzu != null)
    {
      this.jdField_a_of_type_Amzu.a();
      this.jdField_a_of_type_Amzu = null;
    }
    if (this.jdField_a_of_type_Amtw != null)
    {
      this.jdField_a_of_type_Amtw.a();
      this.jdField_a_of_type_Amtw = null;
    }
    if (this.jdField_a_of_type_Amuc != null)
    {
      this.jdField_a_of_type_Amuc.f();
      this.jdField_a_of_type_Amuc = null;
    }
    this.jdField_a_of_type_Amum.a();
    this.jdField_a_of_type_Amuk.b();
    this.jdField_a_of_type_Amud.b();
    this.jdField_a_of_type_Amug.c();
    this.jdField_a_of_type_Boolean = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = a();
    if (localObject == null) {}
    while (this.jdField_a_of_type_Amug.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Amug.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amul
 * JD-Core Version:    0.7.0.1
 */