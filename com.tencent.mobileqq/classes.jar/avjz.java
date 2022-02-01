import android.os.Handler.Callback;
import android.os.Message;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontSoLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;
import mqq.app.AppRuntime;

public class avjz
  implements Handler.Callback
{
  private static avjz jdField_a_of_type_Avjz;
  public static final String a;
  private static ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, avkb>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static final String b;
  public static final String c;
  public static final String d;
  public ETEngine a;
  public AtomicBoolean a;
  public ETEngine b;
  public AtomicBoolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".hiboom_font/");
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "font/";
    c = jdField_a_of_type_JavaLangString + "config/";
    d = jdField_a_of_type_JavaLangString + "tags/";
  }
  
  private avjz()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static avjz a()
  {
    if (jdField_a_of_type_Avjz == null) {
      jdField_a_of_type_Avjz = new avjz();
    }
    return jdField_a_of_type_Avjz;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = new File(jdField_b_of_type_JavaLangString + paramInt);
    boolean bool1 = bool2;
    if (((File)localObject).exists())
    {
      bool1 = bool2;
      if (((File)localObject).isDirectory())
      {
        localObject = ((File)localObject).list(ChatFontJsPlugin.mHiBoomFontFilter);
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (localObject.length > 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private avkb b(int paramInt1, int paramInt2, avka paramavka)
  {
    paramavka = new avkb(paramInt1, paramavka);
    ((ConcurrentHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2))).put(Integer.valueOf(paramInt1), paramavka);
    return paramavka;
  }
  
  public avkb a(int paramInt1, int paramInt2, @Nonnull avka paramavka)
  {
    try
    {
      if ((ConcurrentHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2)) == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt2), new ConcurrentHashMap());
      }
      avkb localavkb2 = (avkb)((ConcurrentHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt2))).get(Integer.valueOf(paramInt1));
      avkb localavkb1 = localavkb2;
      if (localavkb2 == null) {
        localavkb1 = b(paramInt1, paramInt2, paramavka);
      }
      return localavkb1;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "onEngineReady");
    }
    Iterator localIterator1 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ConcurrentHashMap)((Map.Entry)localIterator1.next()).getValue()).entrySet().iterator();
      while (localIterator2.hasNext()) {
        ((avkb)((Map.Entry)localIterator2.next()).getValue()).a(false);
      }
    }
  }
  
  public void b()
  {
    int j = 1048576;
    for (;;)
    {
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont", 2, "initHYEngine");
        }
        if ((!FontSoLoader.isVipFontSoLoaded()) && (ETEngine.getInstanceForAnimation().isEngineInited.compareAndSet(false, true)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont", 2, "initHYEngine load so");
          }
          FontSoLoader.loadSoLib();
        }
        if (FontSoLoader.isVipFontSoLoaded())
        {
          this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
          this.jdField_b_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstanceForAnimation();
        }
        try
        {
          if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            break label314;
          }
          i = ChatTextSizeSettingActivity.a(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp());
          i = i * i * 240 * 18 * 2;
        }
        catch (Exception localException)
        {
          boolean bool2;
          boolean bool1;
          boolean bool3;
          AtomicBoolean localAtomicBoolean;
          QLog.e("HiBoomFont", 1, "initEngine error", localException);
          continue;
        }
        bool2 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.get();
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(18, j);
          this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.set(bool1);
        }
        bool3 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.get();
        bool2 = bool3;
        if (!bool3)
        {
          bool2 = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.initEngine(10, 3145728);
          this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.set(bool2);
        }
        localAtomicBoolean = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if ((bool1) && (bool2))
        {
          bool3 = true;
          localAtomicBoolean.set(bool3);
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont", 2, "initHYEngine ret = " + bool1 + " ret2=" + bool2);
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          return;
        }
        bool3 = false;
        continue;
        i = 0;
      }
      finally {}
      label314:
      if (i > 1048576) {
        j = i;
      }
    }
  }
  
  public void c()
  {
    for (;;)
    {
      int i;
      try
      {
        boolean bool = l.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
        if (bool) {
          return;
        }
        l.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        i = bhiw.a(bhiw.a(), "libFounderColorFont_818.so");
        if (!QLog.isColorLevel()) {
          break label131;
        }
        QLog.d("HiBoomFont", 2, "tryInitFZEngine: loadSoRes=" + i);
      }
      finally {}
      l.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      continue;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        ((VasQuickUpdateManager)localAppRuntime.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).downloadItem(1004L, "libColorFont_818", "HiBoomFont_initFZEngine");
        continue;
        label131:
        switch (i)
        {
        }
      }
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont", 2, "clearCache");
    }
    BaseApplicationImpl.getApplication().waitAppRuntime(null);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont", 2, "clearCache clearHY Engine");
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_resetEngine();
      this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_resetEngine();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    HiBoomTextView.e();
    l.a().a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((paramMessage.obj instanceof HiBoomTextView)) {
        ((HiBoomTextView)paramMessage.obj).invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjz
 * JD-Core Version:    0.7.0.1
 */