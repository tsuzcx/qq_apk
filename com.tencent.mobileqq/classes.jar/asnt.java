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

public class asnt
  extends asls
{
  anxe jdField_a_of_type_Anxe = new asnv(this);
  ashl<CustomEmotionData> jdField_a_of_type_Ashl = new asnu(this);
  protected QQAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable = new EmoticonPanelFavHelper.3(this);
  
  public asnt(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  void a()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.b;
    int j = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g;
    if (localQQAppInterface != null)
    {
      askd localaskd = (askd)localQQAppInterface.getManager(43);
      if (!localaskd.e)
      {
        localaskd.e = true;
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "doSyncFavEmotion");
        }
        c();
      }
      if (!localaskd.d)
      {
        localObject = new ArrayList((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "newPanelDataList.size() = " + ((ArrayList)localObject).size());
        }
        localObject = ((ArrayList)localObject).iterator();
        int i = 0;
        while (((Iterator)localObject).hasNext())
        {
          EmoticonPackage localEmoticonPackage = ((aspt)((Iterator)localObject).next()).a;
          i += 1;
          if ((localEmoticonPackage != null) && ((localEmoticonPackage.jobType == 0) || (localEmoticonPackage.jobType == 4)) && (localEmoticonPackage.status != 2))
          {
            localaskd.d = true;
            if (i <= 10) {
              asos.a(localQQAppInterface, localEmoticonPackage, j);
            }
          }
        }
      }
    }
  }
  
  public int[] a()
  {
    return new int[] { 8, 9, 10, 1 };
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelFavHelper.1(this), 200L);
  }
  
  void c()
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
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public void i()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Anxe);
    }
    this.jdField_a_of_type_Ashl = null;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anxe);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anxe);
    }
  }
  
  public void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((!bhnv.d((Context)localObject)) || (localQQAppInterface == null)) {}
    asif localasif;
    do
    {
      return;
      localObject = (ashd)localQQAppInterface.getManager(103);
      localasif = (asif)localQQAppInterface.a(80);
    } while (!((ashd)localObject).a());
    localasif.a();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "comicHandler.GetMyComicFavorEmotIcons");
    }
    ((ashd)localObject).a(this.jdField_a_of_type_Ashl);
    ((ashd)localObject).c();
    this.jdField_a_of_type_JavaLangRunnable.run();
    bdll.b(localQQAppInterface, "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnt
 * JD-Core Version:    0.7.0.1
 */