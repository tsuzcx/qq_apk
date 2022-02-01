import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.2;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class angq
  implements angk
{
  private anga jdField_a_of_type_Anga;
  private angb jdField_a_of_type_Angb;
  private ange jdField_a_of_type_Ange;
  private angn jdField_a_of_type_Angn;
  private String jdField_a_of_type_JavaLangString;
  
  public angq(anga paramanga, angn paramangn, angb paramangb, ange paramange)
  {
    this.jdField_a_of_type_Anga = paramanga;
    this.jdField_a_of_type_Angn = paramangn;
    this.jdField_a_of_type_Angb = paramangb;
    this.jdField_a_of_type_Ange = paramange;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Anga.a() == null)) {}
    while (this.jdField_a_of_type_Ange.a(paramInt1, paramInt2) == null) {
      return false;
    }
    return true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Angb.a();
  }
  
  public void a(anga paramanga)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if ((this.jdField_a_of_type_Angb == null) || (paramanga == null) || (!paramanga.c())) {
      if (paramanga != null) {
        anmq.a(paramanga.a(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    String str;
    anfr localanfr;
    do
    {
      do
      {
        return;
        if (a(0, -1)) {
          break;
        }
        QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
      } while (paramanga.e != 1);
      ThreadManager.getUIHandler().post(new SpriteDrawerInfoBridge.2(this, paramanga));
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str = this.jdField_a_of_type_Angb.a();
        QLog.d("CmShowStatUtil", 1, "drawer get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        anmq.a(paramanga.a(), 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "drawer spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      localanfr = (anfr)this.jdField_a_of_type_Ange.a(0);
    } while (localanfr == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDrawerInfoSprite('").append(str).append("');");
    anmq.a(this.jdField_a_of_type_Anga.a(), 350);
    localanfr.a(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteDrawerInfoBridge.3(this, localanfr, paramanga));
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
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Angb == null) || (this.jdField_a_of_type_Anga == null) || (!this.jdField_a_of_type_Anga.c())) {
      return;
    }
    this.jdField_a_of_type_Angb.a(paramSpriteTaskParam);
    if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[playAction], fail to load script.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    Object localObject = this.jdField_a_of_type_Angb.a(paramSpriteTaskParam);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    anfs localanfs = this.jdField_a_of_type_Ange.a(paramSpriteTaskParam.jdField_c_of_type_Int);
    if (localanfs == null)
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
    localanfs.a(localStringBuilder.toString());
    localanfs.a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    localanfs.a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    localObject = this.jdField_a_of_type_Anga.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      anlk.a((QQAppInterface)localObject, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angq
 * JD-Core Version:    0.7.0.1
 */