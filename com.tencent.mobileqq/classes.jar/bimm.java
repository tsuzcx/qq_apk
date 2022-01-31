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

public class bimm
  extends bime
{
  public final bimd a;
  private boolean c;
  private String d;
  private int e = 0;
  
  bimm(int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bimd = new bimd(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    if (paramInt == 6) {
      this.jdField_a_of_type_Bimd.jdField_a_of_type_Asta = new asta("comic_leba_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        this.jdField_a_of_type_Bimd.jdField_a_of_type_Asta = new asta("comic_activity_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        return;
      }
    } while (paramInt != 9999);
    this.jdField_a_of_type_Bimd.jdField_a_of_type_Asta = new asta("comic_web_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
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
    bioe.a(BaseApplicationImpl.getApplication().getRuntime(), 1, 1, 0L);
    biof.a(localIntent);
    if ((bdtg.a() instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)bdtg.a());
    }
    biqw localbiqw = new biqw(0);
    localbiqw.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    localbiqw.jdField_d_of_type_JavaLangString = "comic_plugin";
    localbiqw.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localbiqw.e = "com.qqcomic.app.VipPreloadComicProcess";
    this.jdField_a_of_type_Bimd.a(this.e, a(), this.jdField_d_of_type_Int);
    localbiqw.jdField_a_of_type_Asta = this.jdField_a_of_type_Bimd.jdField_a_of_type_Asta;
    localbiqw.jdField_a_of_type_AndroidContentIntent = localIntent;
    biqn.b(BaseApplicationImpl.getContext(), localbiqw);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload end");
    }
  }
  
  public void a(bimk parambimk)
  {
    if (parambimk == null) {
      return;
    }
    this.e = parambimk.jdField_a_of_type_Int;
    this.jdField_d_of_type_JavaLangString = parambimk.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(bimk parambimk)
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|24|0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 4) {}
    }
    for (boolean bool = "1".equals(localObject[2]);; bool = false)
    {
      if (parambimk != null)
      {
        parambimk.jdField_a_of_type_Int = 2;
        if (!bool) {
          break label132;
        }
      }
      label132:
      for (localObject = "preload:ok:dpc";; localObject = "preload:fail:dpc")
      {
        parambimk.jdField_a_of_type_JavaLangString = ((String)localObject);
        parambimk = (biml)BaseApplicationImpl.getApplication().getRuntime().getManager(142);
        if (parambimk != null)
        {
          parambimk.a();
          if (parambimk.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null)
          {
            this.jdField_a_of_type_Int = ((bimh)parambimk.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Int;
            this.jdField_c_of_type_Boolean = ((bimh)parambimk.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Boolean;
          }
        }
        return bool;
      }
    }
  }
  
  protected boolean b(bimk parambimk)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambimk == null) {
      parambimk = new bimk();
    }
    for (;;)
    {
      biml localbiml = (biml)BaseApplicationImpl.getApplication().getRuntime().getManager(142);
      int i;
      if (localbiml != null) {
        if ((localbiml.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (((bimh)localbiml.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_a_of_type_Boolean))
        {
          i = 1;
          if (this.jdField_c_of_type_Int != 5) {
            break label218;
          }
          if ((i != 0) && (localbiml.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
            break label164;
          }
          parambimk.jdField_a_of_type_Int = 1;
          parambimk.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          label105:
          bool2 = bool1;
          if (localbiml.b.get() != null) {
            this.jdField_d_of_type_Int = ((bimg)localbiml.b.get()).jdField_a_of_type_Int;
          }
        }
      }
      for (bool2 = bool1;; bool2 = false)
      {
        this.e = parambimk.jdField_a_of_type_Int;
        this.jdField_d_of_type_JavaLangString = parambimk.jdField_a_of_type_JavaLangString;
        return bool2;
        i = 0;
        break;
        label164:
        if (localbiml.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          if (!bool1) {
            break label203;
          }
          parambimk.jdField_a_of_type_Int = 2;
          parambimk.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          break;
        }
        label203:
        parambimk.jdField_a_of_type_Int = 2;
        parambimk.jdField_a_of_type_JavaLangString = "preload:fail:publicaccount";
        break label105;
        label218:
        if (this.jdField_c_of_type_Int == 6)
        {
          if ((i != 0) && (localbiml.b.get() != null))
          {
            bool1 = a((bimg)localbiml.b.get(), String.valueOf(1113), localbiml.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.android.animation", localbiml.a(), localbiml.a(), localbiml.a(), parambimk);
            break label105;
          }
          parambimk.jdField_a_of_type_Int = 1;
          parambimk.jdField_a_of_type_JavaLangString = "preload:fail:normal";
          bool1 = false;
          break label105;
        }
        if (this.jdField_c_of_type_Int == 9999)
        {
          parambimk.jdField_a_of_type_Int = 1;
          parambimk.jdField_a_of_type_JavaLangString = "preload:ok:web";
          break label105;
        }
        parambimk.jdField_a_of_type_Int = 1;
        parambimk.jdField_a_of_type_JavaLangString = "preload:fail:unknownentry";
        bool1 = false;
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimm
 * JD-Core Version:    0.7.0.1
 */