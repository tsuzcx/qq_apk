import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipProxyPreLoadComicProcess;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;

public class blqi
  extends blqa
{
  public final blpz a;
  private boolean c;
  private String d;
  private int e = 0;
  
  blqi(int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Blpz = new blpz(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    if (paramInt == 6) {
      this.jdField_a_of_type_Blpz.jdField_a_of_type_Avlg = new avlg("comic_leba_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        this.jdField_a_of_type_Blpz.jdField_a_of_type_Avlg = new avlg("comic_activity_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        return;
      }
    } while (paramInt != 9999);
    this.jdField_a_of_type_Blpz.jdField_a_of_type_Avlg = new avlg("comic_web_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
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
    blsf.a(BaseApplicationImpl.getApplication().getRuntime(), 1, 1, 0L);
    blsg.a(localIntent);
    if ((bhnp.a() instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)bhnp.a());
    }
    blwh localblwh = new blwh(0);
    localblwh.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    localblwh.jdField_d_of_type_JavaLangString = "comic_plugin";
    localblwh.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localblwh.e = "com.qqcomic.app.VipPreloadComicProcess";
    this.jdField_a_of_type_Blpz.a(this.e, a(), this.jdField_d_of_type_Int);
    localblwh.jdField_a_of_type_Avlg = this.jdField_a_of_type_Blpz.jdField_a_of_type_Avlg;
    localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
    blvy.b(BaseApplicationImpl.getContext(), localblwh);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload end");
    }
  }
  
  public void a(blqg paramblqg)
  {
    if (paramblqg == null) {
      return;
    }
    this.e = paramblqg.jdField_a_of_type_Int;
    this.jdField_d_of_type_JavaLangString = paramblqg.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(blqg paramblqg)
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|24|0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 4) {}
    }
    for (boolean bool = "1".equals(localObject[2]);; bool = false)
    {
      if (paramblqg != null)
      {
        paramblqg.jdField_a_of_type_Int = 2;
        if (!bool) {
          break label132;
        }
      }
      label132:
      for (localObject = "preload:ok:dpc";; localObject = "preload:fail:dpc")
      {
        paramblqg.jdField_a_of_type_JavaLangString = ((String)localObject);
        paramblqg = (blqh)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QQCOMIC_PRELOAD_MANAGER);
        if (paramblqg != null)
        {
          paramblqg.a();
          if (paramblqg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null)
          {
            this.jdField_a_of_type_Int = ((blqd)paramblqg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Int;
            this.jdField_c_of_type_Boolean = ((blqd)paramblqg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Boolean;
          }
        }
        return bool;
      }
    }
  }
  
  protected boolean b(blqg paramblqg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramblqg == null) {
      paramblqg = new blqg();
    }
    for (;;)
    {
      blqh localblqh = (blqh)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QQCOMIC_PRELOAD_MANAGER);
      int i;
      if (localblqh != null) {
        if ((localblqh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (((blqd)localblqh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_a_of_type_Boolean))
        {
          i = 1;
          if (this.jdField_c_of_type_Int != 5) {
            break label218;
          }
          if ((i != 0) && (localblqh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
            break label164;
          }
          paramblqg.jdField_a_of_type_Int = 1;
          paramblqg.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          label105:
          bool2 = bool1;
          if (localblqh.b.get() != null) {
            this.jdField_d_of_type_Int = ((blqc)localblqh.b.get()).jdField_a_of_type_Int;
          }
        }
      }
      for (bool2 = bool1;; bool2 = false)
      {
        this.e = paramblqg.jdField_a_of_type_Int;
        this.jdField_d_of_type_JavaLangString = paramblqg.jdField_a_of_type_JavaLangString;
        return bool2;
        i = 0;
        break;
        label164:
        if (localblqh.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          if (!bool1) {
            break label203;
          }
          paramblqg.jdField_a_of_type_Int = 2;
          paramblqg.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          break;
        }
        label203:
        paramblqg.jdField_a_of_type_Int = 2;
        paramblqg.jdField_a_of_type_JavaLangString = "preload:fail:publicaccount";
        break label105;
        label218:
        if (this.jdField_c_of_type_Int == 6)
        {
          if ((i != 0) && (localblqh.b.get() != null))
          {
            bool1 = a((blqc)localblqh.b.get(), String.valueOf(1113), localblqh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.android.animation", localblqh.a(), localblqh.a(), localblqh.a(), paramblqg);
            break label105;
          }
          paramblqg.jdField_a_of_type_Int = 1;
          paramblqg.jdField_a_of_type_JavaLangString = "preload:fail:normal";
          bool1 = false;
          break label105;
        }
        if (this.jdField_c_of_type_Int == 9999)
        {
          paramblqg.jdField_a_of_type_Int = 1;
          paramblqg.jdField_a_of_type_JavaLangString = "preload:ok:web";
          break label105;
        }
        paramblqg.jdField_a_of_type_Int = 1;
        paramblqg.jdField_a_of_type_JavaLangString = "preload:fail:unknownentry";
        bool1 = false;
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqi
 * JD-Core Version:    0.7.0.1
 */