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

public class asdj
  implements ascs, asdy
{
  static final float[] jdField_a_of_type_ArrayOfFloat = { 1.4F, 1.5F, 1.6F, 1.7F, 1.8F, 1.9F, 2.0F, 2.1F, 2.2F, 2.3F };
  static final int[] jdField_a_of_type_ArrayOfInt = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
  public int a;
  long jdField_a_of_type_Long;
  public akgf a;
  public ascp a;
  public ascr a;
  public ascu a;
  public asdg a;
  asdn jdField_a_of_type_Asdn;
  asdo jdField_a_of_type_Asdo;
  asdp jdField_a_of_type_Asdp = new asdk(this);
  asdq jdField_a_of_type_Asdq;
  public asdr a;
  asds jdField_a_of_type_Asds;
  asea jdField_a_of_type_Asea;
  Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  public RecordVolume a;
  String jdField_a_of_type_JavaLangString;
  public List<ascp> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  public volatile boolean b;
  int c;
  public volatile boolean c;
  
  public asdj(asea paramasea)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Ascr = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Akgf = new asdl(this);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume = new RecordVolume(new asdm(this));
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager begins");
    }
    this.jdField_a_of_type_Asea = paramasea;
    this.jdField_a_of_type_Ascu = new ascu();
    this.jdField_a_of_type_Asds = new asds();
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func MagicfaceActionManager ends");
    }
  }
  
  public static int a(Emoticon paramEmoticon, int paramInt)
  {
    asdg localasdg = new asdg(anzr.n.replace("[epId]", paramEmoticon.epId));
    paramEmoticon = null;
    if (paramInt == 0) {
      paramEmoticon = localasdg.a("send.xml");
    }
    for (;;)
    {
      return new ascu().a(paramEmoticon);
      if (paramInt == 1) {
        paramEmoticon = localasdg.a("receive.xml");
      }
    }
  }
  
  public static ascr a(Emoticon paramEmoticon, int paramInt)
  {
    return a(paramEmoticon, paramInt, 1);
  }
  
  public static ascr a(Emoticon paramEmoticon, int paramInt1, int paramInt2)
  {
    return a(paramEmoticon, paramInt1, paramInt2, 0);
  }
  
  public static ascr a(Emoticon paramEmoticon, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 1)
    {
      paramEmoticon = new asdg(anzr.n.replace("[epId]", paramEmoticon.epId));
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
          for (paramEmoticon = anzr.m.replace("[epId]", paramEmoticon.epId + "_V");; paramEmoticon = anzr.m.replace("[epId]", paramEmoticon.epId + "_HD"))
          {
            paramEmoticon = new asdg(paramEmoticon, 2);
            break;
          }
        }
        if (paramInt2 == 3)
        {
          paramEmoticon = new asdg(anzr.n.replace("[epId]", paramEmoticon.epId), 3);
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
      return new ascu().a(paramEmoticon);
      label188:
      paramEmoticon = null;
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Ascr != null) && (this.jdField_a_of_type_Ascr.jdField_a_of_type_Ascv != null)) {
      return this.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public List<ascp> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      ascp localascp;
      if (localIterator.hasNext())
      {
        localascp = (ascp)localIterator.next();
        if (localascp == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localascp.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localascp);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localascp.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localascp);
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ascp != null)
    {
      this.jdField_a_of_type_Ascp.c();
      this.jdField_a_of_type_Ascp.d();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Ascr != null) && (this.jdField_a_of_type_Asdq != null) && (this.jdField_a_of_type_Ascr.e != null))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Ascr.jdField_b_of_type_Int;
      this.jdField_a_of_type_Asdq.c(this.jdField_a_of_type_Ascr.jdField_a_of_type_Ascv.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Ascr.jdField_a_of_type_Float));
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func initActionData begins.");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Asdr.a();
    if (paramInt == 1) {
      this.jdField_a_of_type_Asdg = new asdg(anzr.n.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId));
    }
    for (;;)
    {
      this.jdField_a_of_type_Asdr.a(this.jdField_a_of_type_Asdg);
      this.jdField_a_of_type_Asdr.a(this.jdField_a_of_type_Asds);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func initActionData ends.");
      }
      return;
      if (paramInt == 2) {
        this.jdField_a_of_type_Asdg = new asdg(anzr.m.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId), 2);
      } else if (paramInt == 3) {
        this.jdField_a_of_type_Asdg = new asdg(anzr.n.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId), 3);
      }
    }
  }
  
  public void a(ascr paramascr)
  {
    if (paramascr == null) {
      QLog.e("MagicfaceActionManager", 1, "onStartMagicface error : actionGlobalData = null");
    }
    for (;;)
    {
      return;
      c(paramascr);
      if (this.jdField_a_of_type_Asdn != null) {
        this.jdField_a_of_type_Asdn.a(paramascr);
      }
      if (this.jdField_a_of_type_Asdq != null)
      {
        this.jdField_a_of_type_Asdq.a(paramascr.jdField_d_of_type_JavaLangString);
        if (this.jdField_a_of_type_Int == 1)
        {
          if (paramascr.f == null) {
            break label130;
          }
          this.jdField_a_of_type_Asdq.b(paramascr.f.replace("%param%", "" + paramascr.jdField_b_of_type_Int));
        }
      }
      while (paramascr.jdField_a_of_type_Ascv != null)
      {
        paramascr.a(this);
        paramascr.a();
        return;
        label130:
        this.jdField_a_of_type_Asdq.b("");
      }
    }
  }
  
  public void a(asdn paramasdn)
  {
    this.jdField_a_of_type_Asdn = paramasdn;
  }
  
  public void a(asdo paramasdo)
  {
    if (paramasdo != null) {
      this.jdField_a_of_type_Asdo = paramasdo;
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ascp != null) {
      this.jdField_a_of_type_Ascp.d();
    }
    if (this.jdField_a_of_type_Ascr != null) {
      this.jdField_a_of_type_Ascr.a(null);
    }
  }
  
  public void a(asdq paramasdq)
  {
    this.jdField_a_of_type_Asdq = paramasdq;
  }
  
  public void a(asdr paramasdr)
  {
    this.jdField_a_of_type_Asdr = paramasdr;
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
    if (this.jdField_a_of_type_Ascp != null) {
      this.jdField_a_of_type_Ascp.b(paramInt, this.jdField_a_of_type_Asdp);
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
    if (this.jdField_a_of_type_Ascp == null) {}
    do
    {
      do
      {
        asct localasct;
        do
        {
          return;
          localasct = this.jdField_a_of_type_Ascp.jdField_a_of_type_Asct;
        } while ((localasct == null) || (!"gravity".equalsIgnoreCase(localasct.jdField_b_of_type_JavaLangString)));
        if (!"record".equalsIgnoreCase(localasct.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (this.jdField_a_of_type_Asdq == null);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Ascr.jdField_b_of_type_Int;
      this.jdField_a_of_type_Asdq.c(this.jdField_a_of_type_Ascr.e);
      return;
    } while (this.jdField_a_of_type_Asdq == null);
    this.jdField_a_of_type_Asdq.c(this.jdField_a_of_type_Ascr.jdField_a_of_type_Ascv.a(1, this.jdField_a_of_type_Ascr.jdField_a_of_type_Float));
  }
  
  public void b(ascr paramascr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func onEndMagicface, 【magic end】");
    }
    if (this.jdField_a_of_type_Asdo != null) {
      this.jdField_a_of_type_Asdo.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramascr != null) {
      d(paramascr);
    }
    if (this.jdField_a_of_type_Asdn != null) {
      this.jdField_a_of_type_Asdn.b(paramascr);
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
    if ((this.jdField_a_of_type_Asea != null) && (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Ascp != null) && (this.jdField_a_of_type_Ascp.jdField_d_of_type_Boolean)) {
      this.jdField_a_of_type_Asea.e();
    }
  }
  
  public void c(ascr paramascr)
  {
    if ("mic".equalsIgnoreCase(paramascr.c)) {
      ThreadManager.executeOnNetWorkThread(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume);
    }
    do
    {
      return;
      if ("gravity".equalsIgnoreCase(paramascr.c))
      {
        paramascr = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
        paramascr.registerListener(this.jdField_a_of_type_Akgf, paramascr.getDefaultSensor(1), 0);
        return;
      }
    } while (!"touch".equalsIgnoreCase(paramascr.c));
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ascr != null) {
      this.jdField_a_of_type_Ascr.jdField_d_of_type_Boolean = true;
    }
  }
  
  public boolean c()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("receiveSound", false);
  }
  
  public void d()
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_Ascr == null) || ("non-ver".equals(this.jdField_a_of_type_Ascr.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("8.3.0");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_Ascr.jdField_b_of_type_JavaLangString);
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
  
  public void d(ascr paramascr)
  {
    if ("mic".equalsIgnoreCase(paramascr.c)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume.a();
    }
    while (!"gravity".equalsIgnoreCase(paramascr.c)) {
      return;
    }
    ((SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_Akgf);
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
          this.jdField_a_of_type_Ascr.jdField_b_of_type_Int = Integer.parseInt(arrayOfString[1]);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, value:" + this.jdField_a_of_type_Ascr.jdField_b_of_type_Int);
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
    if (this.jdField_a_of_type_Ascr != null) {
      this.jdField_a_of_type_Ascr.a(null);
    }
    if (this.jdField_a_of_type_Asdr != null)
    {
      this.jdField_a_of_type_Asdr.a(null);
      this.jdField_a_of_type_Asdr.c();
    }
    if (this.jdField_a_of_type_Asds != null)
    {
      this.jdField_a_of_type_Asds.a();
      this.jdField_a_of_type_Asds = null;
    }
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long > 0L))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        axqy.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbFasong", "MbZhizuoShichang", 0, 0, String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long), "", "", "");
      }
    }
    this.jdField_a_of_type_Asea = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asdj
 * JD-Core Version:    0.7.0.1
 */