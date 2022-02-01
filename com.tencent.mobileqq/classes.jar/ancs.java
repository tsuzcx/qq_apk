import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.2;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ancs
  implements ancm
{
  private ancc jdField_a_of_type_Ancc;
  private ancd jdField_a_of_type_Ancd;
  private ancg jdField_a_of_type_Ancg;
  private ancp jdField_a_of_type_Ancp;
  private String jdField_a_of_type_JavaLangString;
  
  public ancs(ancc paramancc, ancp paramancp, ancd paramancd, ancg paramancg)
  {
    this.jdField_a_of_type_Ancc = paramancc;
    this.jdField_a_of_type_Ancp = paramancp;
    this.jdField_a_of_type_Ancd = paramancd;
    this.jdField_a_of_type_Ancg = paramancg;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Ancc == null) || (this.jdField_a_of_type_Ancc.a() == null)) {}
    while (this.jdField_a_of_type_Ancg.a(paramInt1, paramInt2) == null) {
      return false;
    }
    return true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ancd.a();
  }
  
  public void a(ancc paramancc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if ((this.jdField_a_of_type_Ancd == null) || (paramancc == null) || (!paramancc.c())) {
      if (paramancc != null) {
        anis.a(paramancc.a(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    String str;
    anbt localanbt;
    do
    {
      do
      {
        return;
        if (a(0, -1)) {
          break;
        }
        QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
      } while (paramancc.e != 1);
      ThreadManager.getUIHandler().post(new SpriteDrawerInfoBridge.2(this, paramancc));
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str = this.jdField_a_of_type_Ancd.a();
        QLog.d("CmShowStatUtil", 1, "drawer get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        anis.a(paramancc.a(), 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "drawer spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      localanbt = (anbt)this.jdField_a_of_type_Ancg.a(0);
    } while (localanbt == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDrawerInfoSprite('").append(str).append("');");
    anis.a(this.jdField_a_of_type_Ancc.a(), 350);
    localanbt.a(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteDrawerInfoBridge.3(this, localanbt, paramancc));
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteDrawerInfoBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
  
  public void b() {}
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Ancd == null) || (this.jdField_a_of_type_Ancc == null) || (!this.jdField_a_of_type_Ancc.c())) {
      return;
    }
    this.jdField_a_of_type_Ancd.a(paramSpriteTaskParam);
    if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[playAction], fail to load script.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    Object localObject = this.jdField_a_of_type_Ancd.a(paramSpriteTaskParam);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    anbu localanbu = this.jdField_a_of_type_Ancg.a(paramSpriteTaskParam.jdField_c_of_type_Int);
    if (localanbu == null)
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "actionScript == null.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
    }
    paramSpriteTaskParam.jdField_b_of_type_Int = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playDrawerInfoAction ('").append((String)localObject).append("');");
    localanbu.a(localStringBuilder.toString());
    localanbu.a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    localanbu.a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    localObject = this.jdField_a_of_type_Ancc.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      anhm.a((QQAppInterface)localObject, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancs
 * JD-Core Version:    0.7.0.1
 */