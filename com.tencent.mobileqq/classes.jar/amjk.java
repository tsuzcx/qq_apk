import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicHelper;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicJumpActivity.ComicParam;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.comic.utils.QQComicPluginBridge.PluginInstallObserver;
import java.lang.ref.WeakReference;

public class amjk
  extends amjo
{
  public amjk(VipComicJumpActivity paramVipComicJumpActivity, QQAppInterface paramQQAppInterface, VipComicJumpActivity.ComicParam paramComicParam)
  {
    super(paramQQAppInterface);
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    if (QQComicPluginBridge.a(localQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "plugin is installed.");
      }
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity.b(this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "wait for plugin installation...");
    }
    QQComicPluginBridge.PluginInstallObserver localPluginInstallObserver = new QQComicPluginBridge.PluginInstallObserver();
    localPluginInstallObserver.jdField_a_of_type_CooperationComicUtilsQQComicPluginBridge$PluginInstallCallback = new amjl(this);
    VipComicHelper.a(2, localQQAppInterface);
    boolean bool = QQComicPluginBridge.a(localQQAppInterface, true, localPluginInstallObserver);
    this.jdField_a_of_type_CooperationComicVipComicJumpActivity.jdField_a_of_type_Long = localPluginInstallObserver.jdField_a_of_type_Long;
    this.jdField_a_of_type_CooperationComicVipComicJumpActivity.b = localPluginInstallObserver.b;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "plugin install failed.");
      }
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity.a(this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam, localPluginInstallObserver.jdField_a_of_type_Int);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "plugin is installed now.");
    }
    this.jdField_a_of_type_CooperationComicVipComicJumpActivity.b(this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjk
 * JD-Core Version:    0.7.0.1
 */