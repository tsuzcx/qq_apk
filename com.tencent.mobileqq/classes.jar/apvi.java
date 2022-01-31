import android.os.Handler;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.1;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.2;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.3;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.5;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.7;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class apvi
  extends aptd
  implements apsa
{
  public AdapterView.OnItemClickListener a;
  apsb a;
  
  public apvi(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
    this.jdField_a_of_type_Apsb = new apvl(this);
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new apvm(this);
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, List<apwv> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {}
    label154:
    label158:
    for (;;)
    {
      return 0;
      if (paramList != null)
      {
        paramQQAppInterface = ((aufn)paramQQAppInterface.getManager(14)).a(paramString);
        int j;
        int i;
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.jobType == 3) || (paramQQAppInterface.jobType == 5)))
        {
          j = 1;
          int k = paramList.size();
          i = 0;
          label65:
          if (i >= k) {
            break label154;
          }
          paramQQAppInterface = (apwv)paramList.get(i);
          if ((paramQQAppInterface == null) || (paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (!paramString.equals(paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
            break label124;
          }
        }
        for (;;)
        {
          if (i == -1) {
            break label158;
          }
          return i;
          j = 0;
          break;
          label124:
          if ((j == 0) || (paramQQAppInterface == null) || (paramQQAppInterface.jdField_a_of_type_Int != 9))
          {
            i += 1;
            break label65;
            i = -1;
          }
        }
      }
    }
  }
  
  public int a(String paramString, List<apwv> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (apwv)paramList.get(i);
      if (((apwv)localObject).jdField_a_of_type_Int == 6)
      {
        localObject = ((apwv)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
        if ((localObject != null) && (paramString.equals(((EmoticonPackage)localObject).epId)))
        {
          if (paramBoolean) {
            return i - 3;
          }
          return i - 2;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public void a()
  {
    aprn.a().a(this);
    aprn.a().a(this.jdField_a_of_type_Apsb);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageDeleted");
    }
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    List localList;
    int j;
    do
    {
      return;
      localList = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList;
      int i = 0;
      int k;
      for (j = -1; i < localList.size(); j = k)
      {
        Object localObject = (apwv)localList.get(i);
        k = j;
        if (localObject != null)
        {
          k = j;
          if (((apwv)localObject).jdField_a_of_type_Int == 6)
          {
            localObject = ((apwv)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
            k = j;
            if (localObject != null)
            {
              k = j;
              if (paramEmoticonPackage.epId.equals(((EmoticonPackage)localObject).epId)) {
                k = i;
              }
            }
          }
        }
        i += 1;
      }
    } while (j == -1);
    if (j < EmoticonPanelController.jdField_b_of_type_Int) {
      paramEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController;
    }
    for (paramEmoticonPackage.jdField_a_of_type_Int += 1;; this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Int = (localList.size() - 1)) {
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.c = true;
        return;
      } while ((j != EmoticonPanelController.jdField_b_of_type_Int) || (j != localList.size() - 1));
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageMoved");
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.c = true;
  }
  
  public void a(boolean paramBoolean, apuy paramapuy)
  {
    QLog.d("EmoticonPanelMallHelper", 1, "asyncInitPanelDataList begin");
    ThreadManager.post(new EmoticonPanelMallHelper.1(this, paramBoolean, paramapuy), 5, null, true);
  }
  
  public int[] a()
  {
    return new int[] { 6, 7, 8, 1 };
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      QLog.e("EmoticonPanelMallHelper", 1, "onPackageAdded: ep = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageAdded: ep = " + paramEmoticonPackage);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.c = true;
    ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.7(this, paramEmoticonPackage));
  }
  
  public void d()
  {
    aprn.a().a(this.jdField_a_of_type_Apsb);
  }
  
  public void e()
  {
    aprn.a().b(this.jdField_a_of_type_Apsb);
  }
  
  public void f()
  {
    aprn.a().b(this);
    aprn.a().b(this.jdField_a_of_type_Apsb);
  }
  
  public void i()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelMallHelper.2(this), 200L);
  }
  
  public void j()
  {
    ThreadManager.getSubThreadHandler().post(new EmoticonPanelMallHelper.3(this));
  }
  
  public void k()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a().isShown()) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelMallHelper.5(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvi
 * JD-Core Version:    0.7.0.1
 */