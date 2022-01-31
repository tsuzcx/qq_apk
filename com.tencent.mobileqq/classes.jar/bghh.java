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

public class bghh
  extends bggz
{
  public final bggy a;
  private boolean c;
  private String d;
  private int e = 0;
  
  bghh(int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bggy = new bggy(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    if (paramInt == 6) {
      this.jdField_a_of_type_Bggy.jdField_a_of_type_Aqyd = new aqyd("comic_leba_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        this.jdField_a_of_type_Bggy.jdField_a_of_type_Aqyd = new aqyd("comic_activity_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        return;
      }
    } while (paramInt != 9999);
    this.jdField_a_of_type_Bggy.jdField_a_of_type_Aqyd = new aqyd("comic_web_preload", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
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
    bgiz.a(BaseApplicationImpl.getApplication().getRuntime(), 1, 1, 0L);
    bgja.a(localIntent);
    if ((bbqd.a() instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)bbqd.a());
    }
    bglq localbglq = new bglq(0);
    localbglq.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    localbglq.jdField_d_of_type_JavaLangString = "comic_plugin";
    localbglq.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localbglq.e = "com.qqcomic.app.VipPreloadComicProcess";
    this.jdField_a_of_type_Bggy.a(this.e, a(), this.jdField_d_of_type_Int);
    localbglq.jdField_a_of_type_Aqyd = this.jdField_a_of_type_Bggy.jdField_a_of_type_Aqyd;
    localbglq.jdField_a_of_type_AndroidContentIntent = localIntent;
    bglh.b(BaseApplicationImpl.getContext(), localbglq);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "doPreload end");
    }
  }
  
  public void a(bghf parambghf)
  {
    if (parambghf == null) {
      return;
    }
    this.e = parambghf.jdField_a_of_type_Int;
    this.jdField_d_of_type_JavaLangString = parambghf.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(bghf parambghf)
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|24|0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 4) {}
    }
    for (boolean bool = "1".equals(localObject[2]);; bool = false)
    {
      if (parambghf != null)
      {
        parambghf.jdField_a_of_type_Int = 2;
        if (!bool) {
          break label132;
        }
      }
      label132:
      for (localObject = "preload:ok:dpc";; localObject = "preload:fail:dpc")
      {
        parambghf.jdField_a_of_type_JavaLangString = ((String)localObject);
        parambghf = (bghg)BaseApplicationImpl.getApplication().getRuntime().getManager(142);
        if (parambghf != null)
        {
          parambghf.a();
          if (parambghf.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null)
          {
            this.jdField_a_of_type_Int = ((bghc)parambghf.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Int;
            this.jdField_c_of_type_Boolean = ((bghc)parambghf.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Boolean;
          }
        }
        return bool;
      }
    }
  }
  
  protected boolean b(bghf parambghf)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambghf == null) {
      parambghf = new bghf();
    }
    for (;;)
    {
      bghg localbghg = (bghg)BaseApplicationImpl.getApplication().getRuntime().getManager(142);
      int i;
      if (localbghg != null) {
        if ((localbghg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (((bghc)localbghg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_a_of_type_Boolean))
        {
          i = 1;
          if (this.jdField_c_of_type_Int != 5) {
            break label218;
          }
          if ((i != 0) && (localbghg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
            break label164;
          }
          parambghf.jdField_a_of_type_Int = 1;
          parambghf.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          label105:
          bool2 = bool1;
          if (localbghg.b.get() != null) {
            this.jdField_d_of_type_Int = ((bghb)localbghg.b.get()).jdField_a_of_type_Int;
          }
        }
      }
      for (bool2 = bool1;; bool2 = false)
      {
        this.e = parambghf.jdField_a_of_type_Int;
        this.jdField_d_of_type_JavaLangString = parambghf.jdField_a_of_type_JavaLangString;
        return bool2;
        i = 0;
        break;
        label164:
        if (localbghg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          if (!bool1) {
            break label203;
          }
          parambghf.jdField_a_of_type_Int = 2;
          parambghf.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          break;
        }
        label203:
        parambghf.jdField_a_of_type_Int = 2;
        parambghf.jdField_a_of_type_JavaLangString = "preload:fail:publicaccount";
        break label105;
        label218:
        if (this.jdField_c_of_type_Int == 6)
        {
          if ((i != 0) && (localbghg.b.get() != null))
          {
            bool1 = a((bghb)localbghg.b.get(), String.valueOf(1113), localbghg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.android.animation", localbghg.a(), localbghg.a(), localbghg.a(), parambghf);
            break label105;
          }
          parambghf.jdField_a_of_type_Int = 1;
          parambghf.jdField_a_of_type_JavaLangString = "preload:fail:normal";
          bool1 = false;
          break label105;
        }
        if (this.jdField_c_of_type_Int == 9999)
        {
          parambghf.jdField_a_of_type_Int = 1;
          parambghf.jdField_a_of_type_JavaLangString = "preload:ok:web";
          break label105;
        }
        parambghf.jdField_a_of_type_Int = 1;
        parambghf.jdField_a_of_type_JavaLangString = "preload:fail:unknownentry";
        bool1 = false;
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghh
 * JD-Core Version:    0.7.0.1
 */