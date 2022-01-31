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

public class bggq
  extends bggi
{
  public final bggh a;
  private boolean c;
  private String d;
  private int e = 0;
  
  bggq(int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bggh = new bggh(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    if (paramInt == 6) {
      this.jdField_a_of_type_Bggh.jdField_a_of_type_Aqyb = new aqyb("comic_leba_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        this.jdField_a_of_type_Bggh.jdField_a_of_type_Aqyb = new aqyb("comic_activity_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        return;
      }
    } while (paramInt != 9999);
    this.jdField_a_of_type_Bggh.jdField_a_of_type_Aqyb = new aqyb("comic_web_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
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
    bgii.a(BaseApplicationImpl.getApplication().getRuntime(), 1, 1, 0L);
    bgij.a(localIntent);
    if ((bbpp.a() instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)bbpp.a());
    }
    bgkz localbgkz = new bgkz(0);
    localbgkz.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    localbgkz.jdField_d_of_type_JavaLangString = "comic_plugin";
    localbgkz.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localbgkz.e = "com.qqcomic.app.VipPreloadComicProcess";
    this.jdField_a_of_type_Bggh.a(this.e, a(), this.jdField_d_of_type_Int);
    localbgkz.jdField_a_of_type_Aqyb = this.jdField_a_of_type_Bggh.jdField_a_of_type_Aqyb;
    localbgkz.jdField_a_of_type_AndroidContentIntent = localIntent;
    bgkq.b(BaseApplicationImpl.getContext(), localbgkz);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload end");
    }
  }
  
  public void a(bggo parambggo)
  {
    if (parambggo == null) {
      return;
    }
    this.e = parambggo.jdField_a_of_type_Int;
    this.jdField_d_of_type_JavaLangString = parambggo.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(bggo parambggo)
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|24|0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 4) {}
    }
    for (boolean bool = "1".equals(localObject[2]);; bool = false)
    {
      if (parambggo != null)
      {
        parambggo.jdField_a_of_type_Int = 2;
        if (!bool) {
          break label132;
        }
      }
      label132:
      for (localObject = "preload:ok:dpc";; localObject = "preload:fail:dpc")
      {
        parambggo.jdField_a_of_type_JavaLangString = ((String)localObject);
        parambggo = (bggp)BaseApplicationImpl.getApplication().getRuntime().getManager(142);
        if (parambggo != null)
        {
          parambggo.a();
          if (parambggo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null)
          {
            this.jdField_a_of_type_Int = ((bggl)parambggo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Int;
            this.jdField_c_of_type_Boolean = ((bggl)parambggo.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Boolean;
          }
        }
        return bool;
      }
    }
  }
  
  protected boolean b(bggo parambggo)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambggo == null) {
      parambggo = new bggo();
    }
    for (;;)
    {
      bggp localbggp = (bggp)BaseApplicationImpl.getApplication().getRuntime().getManager(142);
      int i;
      if (localbggp != null) {
        if ((localbggp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (((bggl)localbggp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_a_of_type_Boolean))
        {
          i = 1;
          if (this.jdField_c_of_type_Int != 5) {
            break label218;
          }
          if ((i != 0) && (localbggp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
            break label164;
          }
          parambggo.jdField_a_of_type_Int = 1;
          parambggo.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          label105:
          bool2 = bool1;
          if (localbggp.b.get() != null) {
            this.jdField_d_of_type_Int = ((bggk)localbggp.b.get()).jdField_a_of_type_Int;
          }
        }
      }
      for (bool2 = bool1;; bool2 = false)
      {
        this.e = parambggo.jdField_a_of_type_Int;
        this.jdField_d_of_type_JavaLangString = parambggo.jdField_a_of_type_JavaLangString;
        return bool2;
        i = 0;
        break;
        label164:
        if (localbggp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          if (!bool1) {
            break label203;
          }
          parambggo.jdField_a_of_type_Int = 2;
          parambggo.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          break;
        }
        label203:
        parambggo.jdField_a_of_type_Int = 2;
        parambggo.jdField_a_of_type_JavaLangString = "preload:fail:publicaccount";
        break label105;
        label218:
        if (this.jdField_c_of_type_Int == 6)
        {
          if ((i != 0) && (localbggp.b.get() != null))
          {
            bool1 = a((bggk)localbggp.b.get(), String.valueOf(1113), localbggp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.android.animation", localbggp.a(), localbggp.a(), localbggp.a(), parambggo);
            break label105;
          }
          parambggo.jdField_a_of_type_Int = 1;
          parambggo.jdField_a_of_type_JavaLangString = "preload:fail:normal";
          bool1 = false;
          break label105;
        }
        if (this.jdField_c_of_type_Int == 9999)
        {
          parambggo.jdField_a_of_type_Int = 1;
          parambggo.jdField_a_of_type_JavaLangString = "preload:ok:web";
          break label105;
        }
        parambggo.jdField_a_of_type_Int = 1;
        parambggo.jdField_a_of_type_JavaLangString = "preload:fail:unknownentry";
        bool1 = false;
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggq
 * JD-Core Version:    0.7.0.1
 */