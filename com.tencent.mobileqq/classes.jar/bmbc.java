import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipProxyPreLoadComicProcess;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;

public class bmbc
  extends bmau
{
  public final bmat a;
  private boolean c;
  private String d;
  private int e = 0;
  
  bmbc(int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bmat = new bmat(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    if (paramInt == 6) {
      this.jdField_a_of_type_Bmat.jdField_a_of_type_Avsk = new avsk("comic_leba_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        this.jdField_a_of_type_Bmat.jdField_a_of_type_Avsk = new avsk("comic_activity_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        return;
      }
    } while (paramInt != 9999);
    this.jdField_a_of_type_Bmat.jdField_a_of_type_Avsk = new avsk("comic_web_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
  
  private String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload start");
    }
    if (!QIPCServerHelper.getInstance().isModuleRunning(this.jdField_c_of_type_JavaLangString)) {
      VasWebviewUtil.reportVasStatus("qqcomic", "launch_plugin_action", "0", 0, 201);
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), VipProxyPreLoadComicProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("isPreloadProcess", true);
    localIntent.putExtra("preloadEntry", this.jdField_c_of_type_Int);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    bmcw.a(BaseApplicationImpl.getApplication().getRuntime(), 1, 1, 0L);
    bmcx.a(localIntent);
    if ((bhyk.a() instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)bhyk.a());
    }
    bmgt localbmgt = new bmgt(0);
    localbmgt.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    localbmgt.jdField_d_of_type_JavaLangString = "comic_plugin";
    localbmgt.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localbmgt.e = "com.qqcomic.app.VipPreloadComicProcess";
    this.jdField_a_of_type_Bmat.a(this.e, a(), this.jdField_d_of_type_Int);
    localbmgt.jdField_a_of_type_Avsk = this.jdField_a_of_type_Bmat.jdField_a_of_type_Avsk;
    localbmgt.jdField_a_of_type_AndroidContentIntent = localIntent;
    bmgk.b(BaseApplicationImpl.getContext(), localbmgt);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload end");
    }
  }
  
  public void a(bmba parambmba)
  {
    if (parambmba == null) {
      return;
    }
    this.e = parambmba.jdField_a_of_type_Int;
    this.jdField_d_of_type_JavaLangString = parambmba.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(bmba parambmba)
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|24|0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 4) {}
    }
    for (boolean bool = "1".equals(localObject[2]);; bool = false)
    {
      if (parambmba != null)
      {
        parambmba.jdField_a_of_type_Int = 2;
        if (!bool) {
          break label132;
        }
      }
      label132:
      for (localObject = "preload:ok:dpc";; localObject = "preload:fail:dpc")
      {
        parambmba.jdField_a_of_type_JavaLangString = ((String)localObject);
        parambmba = (bmbb)BaseApplicationImpl.getApplication().getRuntime().getManager(142);
        if (parambmba != null)
        {
          parambmba.a();
          if (parambmba.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null)
          {
            this.jdField_a_of_type_Int = ((bmax)parambmba.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Int;
            this.jdField_c_of_type_Boolean = ((bmax)parambmba.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Boolean;
          }
        }
        return bool;
      }
    }
  }
  
  protected boolean b(bmba parambmba)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambmba == null) {
      parambmba = new bmba();
    }
    for (;;)
    {
      bmbb localbmbb = (bmbb)BaseApplicationImpl.getApplication().getRuntime().getManager(142);
      int i;
      if (localbmbb != null) {
        if ((localbmbb.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (((bmax)localbmbb.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_a_of_type_Boolean))
        {
          i = 1;
          if (this.jdField_c_of_type_Int != 5) {
            break label218;
          }
          if ((i != 0) && (localbmbb.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
            break label164;
          }
          parambmba.jdField_a_of_type_Int = 1;
          parambmba.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          label105:
          bool2 = bool1;
          if (localbmbb.b.get() != null) {
            this.jdField_d_of_type_Int = ((bmaw)localbmbb.b.get()).jdField_a_of_type_Int;
          }
        }
      }
      for (bool2 = bool1;; bool2 = false)
      {
        this.e = parambmba.jdField_a_of_type_Int;
        this.jdField_d_of_type_JavaLangString = parambmba.jdField_a_of_type_JavaLangString;
        return bool2;
        i = 0;
        break;
        label164:
        if (localbmbb.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          if (!bool1) {
            break label203;
          }
          parambmba.jdField_a_of_type_Int = 2;
          parambmba.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          break;
        }
        label203:
        parambmba.jdField_a_of_type_Int = 2;
        parambmba.jdField_a_of_type_JavaLangString = "preload:fail:publicaccount";
        break label105;
        label218:
        if (this.jdField_c_of_type_Int == 6)
        {
          if ((i != 0) && (localbmbb.b.get() != null))
          {
            bool1 = a((bmaw)localbmbb.b.get(), String.valueOf(1113), localbmbb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.android.animation", localbmbb.a(), localbmbb.a(), localbmbb.a(), parambmba);
            break label105;
          }
          parambmba.jdField_a_of_type_Int = 1;
          parambmba.jdField_a_of_type_JavaLangString = "preload:fail:normal";
          bool1 = false;
          break label105;
        }
        if (this.jdField_c_of_type_Int == 9999)
        {
          parambmba.jdField_a_of_type_Int = 1;
          parambmba.jdField_a_of_type_JavaLangString = "preload:ok:web";
          break label105;
        }
        parambmba.jdField_a_of_type_Int = 1;
        parambmba.jdField_a_of_type_JavaLangString = "preload:fail:unknownentry";
        bool1 = false;
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbc
 * JD-Core Version:    0.7.0.1
 */