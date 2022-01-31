import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.model.RecordVolume;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class arhf
  implements argo, arhu
{
  static final float[] jdField_a_of_type_ArrayOfFloat = { 1.4F, 1.5F, 1.6F, 1.7F, 1.8F, 1.9F, 2.0F, 2.1F, 2.2F, 2.3F };
  static final int[] jdField_a_of_type_ArrayOfInt = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
  public int a;
  long jdField_a_of_type_Long;
  public ajrw a;
  public argl a;
  public argn a;
  public argq a;
  public arhc a;
  arhj jdField_a_of_type_Arhj;
  arhk jdField_a_of_type_Arhk;
  arhl jdField_a_of_type_Arhl = new arhg(this);
  arhm jdField_a_of_type_Arhm;
  public arhn a;
  arho jdField_a_of_type_Arho;
  arhw jdField_a_of_type_Arhw;
  Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  public RecordVolume a;
  String jdField_a_of_type_JavaLangString;
  public List<argl> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  public volatile boolean b;
  int c;
  public volatile boolean c;
  
  public arhf(arhw paramarhw)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Argn = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Ajrw = new arhh(this);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume = new RecordVolume(new arhi(this));
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager begins");
    }
    this.jdField_a_of_type_Arhw = paramarhw;
    this.jdField_a_of_type_Argq = new argq();
    this.jdField_a_of_type_Arho = new arho();
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager ends");
    }
  }
  
  public static int a(Emoticon paramEmoticon, int paramInt)
  {
    arhc localarhc = new arhc(anjd.n.replace("[epId]", paramEmoticon.epId));
    paramEmoticon = null;
    if (paramInt == 0) {
      paramEmoticon = localarhc.a("send.xml");
    }
    for (;;)
    {
      return new argq().a(paramEmoticon);
      if (paramInt == 1) {
        paramEmoticon = localarhc.a("receive.xml");
      }
    }
  }
  
  public static argn a(Emoticon paramEmoticon, int paramInt)
  {
    return a(paramEmoticon, paramInt, 1);
  }
  
  public static argn a(Emoticon paramEmoticon, int paramInt1, int paramInt2)
  {
    return a(paramEmoticon, paramInt1, paramInt2, 0);
  }
  
  public static argn a(Emoticon paramEmoticon, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 1)
    {
      paramEmoticon = new arhc(anjd.n.replace("[epId]", paramEmoticon.epId));
      if (paramInt1 != 0) {
        break label161;
      }
      paramEmoticon = paramEmoticon.a("send.xml");
    }
    for (;;)
    {
      if (paramEmoticon == null)
      {
        return null;
        if (paramInt2 == 2)
        {
          if (paramInt3 == 1) {}
          for (paramEmoticon = anjd.m.replace("[epId]", paramEmoticon.epId + "_V");; paramEmoticon = anjd.m.replace("[epId]", paramEmoticon.epId + "_HD"))
          {
            paramEmoticon = new arhc(paramEmoticon, 2);
            break;
          }
        }
        if (paramInt2 == 3)
        {
          paramEmoticon = new arhc(anjd.n.replace("[epId]", paramEmoticon.epId), 3);
          break;
        }
        return null;
        label161:
        if (paramInt1 != 1) {
          break label188;
        }
        paramEmoticon = paramEmoticon.a("receive.xml");
        continue;
      }
      return new argq().a(paramEmoticon);
      label188:
      paramEmoticon = null;
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Argn != null) && (this.jdField_a_of_type_Argn.jdField_a_of_type_Argr != null)) {
      return this.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public List<argl> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      argl localargl;
      if (localIterator.hasNext())
      {
        localargl = (argl)localIterator.next();
        if (localargl == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localargl.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localargl);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localargl.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localargl);
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Argl != null)
    {
      this.jdField_a_of_type_Argl.c();
      this.jdField_a_of_type_Argl.d();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Argn != null) && (this.jdField_a_of_type_Arhm != null) && (this.jdField_a_of_type_Argn.e != null))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Argn.jdField_b_of_type_Int;
      this.jdField_a_of_type_Arhm.c(this.jdField_a_of_type_Argn.jdField_a_of_type_Argr.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Argn.jdField_a_of_type_Float));
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func initActionData begins.");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Arhn.a();
    if (paramInt == 1) {
      this.jdField_a_of_type_Arhc = new arhc(anjd.n.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId));
    }
    for (;;)
    {
      this.jdField_a_of_type_Arhn.a(this.jdField_a_of_type_Arhc);
      this.jdField_a_of_type_Arhn.a(this.jdField_a_of_type_Arho);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func initActionData ends.");
      }
      return;
      if (paramInt == 2) {
        this.jdField_a_of_type_Arhc = new arhc(anjd.m.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId), 2);
      } else if (paramInt == 3) {
        this.jdField_a_of_type_Arhc = new arhc(anjd.n.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId), 3);
      }
    }
  }
  
  public void a(argn paramargn)
  {
    if (paramargn == null) {
      QLog.e("MagicfaceActionManager", 1, "onStartMagicface error : actionGlobalData = null");
    }
    for (;;)
    {
      return;
      c(paramargn);
      if (this.jdField_a_of_type_Arhj != null) {
        this.jdField_a_of_type_Arhj.a(paramargn);
      }
      if (this.jdField_a_of_type_Arhm != null)
      {
        this.jdField_a_of_type_Arhm.a(paramargn.jdField_d_of_type_JavaLangString);
        if (this.jdField_a_of_type_Int == 1)
        {
          if (paramargn.f == null) {
            break label130;
          }
          this.jdField_a_of_type_Arhm.b(paramargn.f.replace("%param%", "" + paramargn.jdField_b_of_type_Int));
        }
      }
      while (paramargn.jdField_a_of_type_Argr != null)
      {
        paramargn.a(this);
        paramargn.a();
        return;
        label130:
        this.jdField_a_of_type_Arhm.b("");
      }
    }
  }
  
  public void a(arhj paramarhj)
  {
    this.jdField_a_of_type_Arhj = paramarhj;
  }
  
  public void a(arhk paramarhk)
  {
    if (paramarhk != null) {
      this.jdField_a_of_type_Arhk = paramarhk;
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Argl != null) {
      this.jdField_a_of_type_Argl.d();
    }
    if (this.jdField_a_of_type_Argn != null) {
      this.jdField_a_of_type_Argn.a(null);
    }
  }
  
  public void a(arhm paramarhm)
  {
    this.jdField_a_of_type_Arhm = paramarhm;
  }
  
  public void a(arhn paramarhn)
  {
    this.jdField_a_of_type_Arhn = paramarhn;
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    a(paramEmoticon, paramInt, paramString, 1);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func doAction begins. isStart:" + this.jdField_a_of_type_Boolean + ",isRelease:" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramEmoticon;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    ThreadManager.post(new MagicfaceActionManager.2(this, paramInt2, paramInt1), 8, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putBoolean("sendSound", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Argl != null) {
      this.jdField_a_of_type_Argl.b(paramInt, this.jdField_a_of_type_Arhl);
    }
    return false;
  }
  
  public int[] a(String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func splitVersion begins, version:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    int[] arrayOfInt;
    do
    {
      return paramString;
      arrayOfInt = new int[3];
      int i = 0;
      while (i < 3)
      {
        arrayOfInt[i] = 0;
        i += 1;
      }
      paramString = paramString.split("\\.");
      if ((paramString != null) && (paramString.length > 1))
      {
        i = j;
        try
        {
          while (i < arrayOfInt.length)
          {
            arrayOfInt[i] = Integer.valueOf(paramString[i]).intValue();
            if (QLog.isColorLevel()) {
              QLog.d("MagicfaceActionManager", 2, "func splitVersion, intVers[" + i + "],=" + arrayOfInt[i]);
            }
            i += 1;
          }
          paramString = arrayOfInt;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MagicfaceActionManager", 2, "func splitVersion ends");
    return arrayOfInt;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Argl == null) {}
    do
    {
      do
      {
        argp localargp;
        do
        {
          return;
          localargp = this.jdField_a_of_type_Argl.jdField_a_of_type_Argp;
        } while ((localargp == null) || (!"gravity".equalsIgnoreCase(localargp.jdField_b_of_type_JavaLangString)));
        if (!"record".equalsIgnoreCase(localargp.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (this.jdField_a_of_type_Arhm == null);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Argn.jdField_b_of_type_Int;
      this.jdField_a_of_type_Arhm.c(this.jdField_a_of_type_Argn.e);
      return;
    } while (this.jdField_a_of_type_Arhm == null);
    this.jdField_a_of_type_Arhm.c(this.jdField_a_of_type_Argn.jdField_a_of_type_Argr.a(1, this.jdField_a_of_type_Argn.jdField_a_of_type_Float));
  }
  
  public void b(argn paramargn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func onEndMagicface, 【magic end】");
    }
    if (this.jdField_a_of_type_Arhk != null) {
      this.jdField_a_of_type_Arhk.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramargn != null) {
      d(paramargn);
    }
    if (this.jdField_a_of_type_Arhj != null) {
      this.jdField_a_of_type_Arhj.b(paramargn);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putBoolean("receiveSound", paramBoolean).commit();
  }
  
  public boolean b()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("sendSound", false);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Arhw != null) && (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Argl != null) && (this.jdField_a_of_type_Argl.jdField_d_of_type_Boolean)) {
      this.jdField_a_of_type_Arhw.e();
    }
  }
  
  public void c(argn paramargn)
  {
    if ("mic".equalsIgnoreCase(paramargn.c)) {
      ThreadManager.executeOnNetWorkThread(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume);
    }
    do
    {
      return;
      if ("gravity".equalsIgnoreCase(paramargn.c))
      {
        paramargn = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
        paramargn.registerListener(this.jdField_a_of_type_Ajrw, paramargn.getDefaultSensor(1), 0);
        return;
      }
    } while (!"touch".equalsIgnoreCase(paramargn.c));
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Argn != null) {
      this.jdField_a_of_type_Argn.jdField_d_of_type_Boolean = true;
    }
  }
  
  public boolean c()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("receiveSound", false);
  }
  
  public void d()
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_Argn == null) || ("non-ver".equals(this.jdField_a_of_type_Argn.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("8.2.6");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_Argn.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func filterAction, qqver:" + arrayOfInt1 + ",magicVer:" + arrayOfInt2);
    }
    int i;
    boolean bool1;
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null) && (arrayOfInt1.length == arrayOfInt2.length))
    {
      i = 0;
      if (i < arrayOfInt2.length) {
        if (arrayOfInt1[i] > arrayOfInt2[i]) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      label142:
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func filterAction, isQQSupport:" + bool1);
      }
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.jdField_a_of_type_JavaUtilList = a(bool1);
        return;
        if (arrayOfInt1[i] < arrayOfInt2[i])
        {
          bool1 = false;
          break label142;
        }
        i += 1;
        break;
      }
      bool1 = true;
    }
  }
  
  public void d(argn paramargn)
  {
    if ("mic".equalsIgnoreCase(paramargn.c)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume.a();
    }
    while (!"gravity".equalsIgnoreCase(paramargn.c)) {
      return;
    }
    ((SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_Ajrw);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, magicValue:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue != null)
    {
      String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue.split("&");
      if ((arrayOfString.length >= 0) && (arrayOfString[0].contains("value")))
      {
        arrayOfString = arrayOfString[0].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          this.jdField_a_of_type_Argn.jdField_b_of_type_Int = Integer.parseInt(arrayOfString[1]);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, value:" + this.jdField_a_of_type_Argn.jdField_b_of_type_Int);
    }
  }
  
  public void f()
  {
    a(null);
  }
  
  public void g()
  {
    f();
    a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public void h()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Argn != null) {
      this.jdField_a_of_type_Argn.a(null);
    }
    if (this.jdField_a_of_type_Arhn != null)
    {
      this.jdField_a_of_type_Arhn.a(null);
      this.jdField_a_of_type_Arhn.c();
    }
    if (this.jdField_a_of_type_Arho != null)
    {
      this.jdField_a_of_type_Arho.a();
      this.jdField_a_of_type_Arho = null;
    }
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long > 0L))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        awqx.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbFasong", "MbZhizuoShichang", 0, 0, String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long), "", "", "");
      }
    }
    this.jdField_a_of_type_Arhw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arhf
 * JD-Core Version:    0.7.0.1
 */