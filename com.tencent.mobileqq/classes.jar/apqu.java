import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.1;
import com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.2;
import com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class apqu
  extends apou
{
  alnn jdField_a_of_type_Alnn = new apqw(this);
  apkn<CustomEmotionData> jdField_a_of_type_Apkn = new apqv(this);
  protected QQAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable = new EmoticonPanelFavHelper.3(this);
  
  public apqu(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public int[] a()
  {
    return new int[] { 8, 9, 10, 1 };
  }
  
  public void f()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Alnn);
    }
    this.jdField_a_of_type_Apkn = null;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alnn);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alnn);
    }
  }
  
  void i()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.b;
    int j = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g;
    if (localQQAppInterface != null)
    {
      apnf localapnf = (apnf)localQQAppInterface.getManager(43);
      if (!localapnf.e)
      {
        localapnf.e = true;
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "doSyncFavEmotion");
        }
        k();
      }
      if (!localapnf.d)
      {
        localObject = new ArrayList((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "newPanelDataList.size() = " + ((ArrayList)localObject).size());
        }
        localObject = ((ArrayList)localObject).iterator();
        int i = 0;
        while (((Iterator)localObject).hasNext())
        {
          EmoticonPackage localEmoticonPackage = ((apsm)((Iterator)localObject).next()).a;
          i += 1;
          if ((localEmoticonPackage != null) && ((localEmoticonPackage.jobType == 0) || (localEmoticonPackage.jobType == 4)) && (localEmoticonPackage.status != 2))
          {
            localapnf.d = true;
            if (i <= 10) {
              apro.a(localQQAppInterface, localEmoticonPackage, j);
            }
          }
        }
      }
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelFavHelper.1(this), 200L);
  }
  
  void k()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext;
    if (localQQAppInterface == null) {
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences("mobileQQ", 0);
    String str = localQQAppInterface.c();
    boolean bool = ((SharedPreferences)localObject).getBoolean("local_overflow" + str, false);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "isDelOverflow=" + bool);
    }
    ThreadManager.post(new EmoticonPanelFavHelper.2(this, localQQAppInterface, bool, (SharedPreferences)localObject, str), 5, null, false);
  }
  
  public void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((!bdee.d((Context)localObject)) || (localQQAppInterface == null)) {}
    aplh localaplh;
    do
    {
      return;
      localObject = (apkf)localQQAppInterface.getManager(103);
      localaplh = (aplh)localQQAppInterface.a(80);
    } while (!((apkf)localObject).a());
    localaplh.a();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "comicHandler.GetMyComicFavorEmotIcons");
    }
    ((apkf)localObject).a(this.jdField_a_of_type_Apkn);
    ((apkf)localObject).c();
    this.jdField_a_of_type_JavaLangRunnable.run();
    azmj.b(localQQAppInterface, "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqu
 * JD-Core Version:    0.7.0.1
 */