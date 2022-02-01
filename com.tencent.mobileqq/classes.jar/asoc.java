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
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class asoc
  extends asls
  implements askp
{
  private int jdField_a_of_type_Int;
  public AdapterView.OnItemClickListener a;
  askq jdField_a_of_type_Askq = new asof(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public asoc(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new asog(this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, List<aspt> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {}
    label154:
    label158:
    for (;;)
    {
      return 0;
      if (paramList != null)
      {
        paramQQAppInterface = ((axfj)paramQQAppInterface.getManager(14)).a(paramString);
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
          paramQQAppInterface = (aspt)paramList.get(i);
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
  
  public int a(String paramString, List<aspt> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (aspt)paramList.get(i);
      if (((aspt)localObject).jdField_a_of_type_Int == 6)
      {
        localObject = ((aspt)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
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
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelMallHelper.2(this), 200L);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList.size())) {}
    while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(12) != paramInt) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)
    {
      aslt localaslt = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a((aspt)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList.get(paramInt));
      if ((localaslt instanceof aspa)) {
        ((aspa)localaslt).d();
      }
    }
    if ((this.jdField_a_of_type_Boolean) || (this.b))
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPageSelected position: " + paramInt);
    }
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
    a((aspt)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList.get(paramInt), false);
  }
  
  public void a(aspt paramaspt, boolean paramBoolean)
  {
    String str;
    boolean bool;
    if (paramaspt != null)
    {
      str = "";
      if (paramaspt.jdField_a_of_type_Int != 7) {
        break label99;
      }
      paramaspt = "0X800AE07";
      bool = true;
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(bool);
      QQAppInterface localQQAppInterface;
      if ((!TextUtils.isEmpty(paramaspt)) && (i != 0))
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!paramBoolean) {
          break label223;
        }
      }
      label223:
      for (str = "3";; str = "2")
      {
        bdll.b(localQQAppInterface, "dc00898", "", "", paramaspt, paramaspt, i, 0, str, "", "", "");
        if (paramBoolean)
        {
          this.b = true;
          this.jdField_a_of_type_Int = 0;
        }
        return;
        label99:
        if ((paramaspt.jdField_a_of_type_Int == 5) || (paramaspt.jdField_a_of_type_Int == 4))
        {
          paramaspt = "0X800AE08";
          bool = true;
          break;
        }
        if (paramaspt.jdField_a_of_type_Int == 11)
        {
          paramaspt = "0X800AE0A";
          bool = true;
          break;
        }
        if (paramaspt.jdField_a_of_type_Int == 8)
        {
          paramaspt = "0X800AE0B";
          bool = false;
          break;
        }
        if (paramaspt.jdField_a_of_type_Int == 9)
        {
          paramaspt = "0X800AE0D";
          bool = false;
          break;
        }
        if (paramaspt.jdField_a_of_type_Int == 12)
        {
          paramaspt = "0X800AE09";
          bool = true;
          break;
        }
        if ((paramaspt.jdField_a_of_type_Int != 6) && (paramaspt.jdField_a_of_type_Int != 10)) {
          break label230;
        }
        paramaspt = "0X800AE0C";
        bool = false;
        break;
      }
      label230:
      bool = true;
      paramaspt = str;
    }
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
        Object localObject = (aspt)localList.get(i);
        k = j;
        if (localObject != null) {
          if (((aspt)localObject).jdField_a_of_type_Int != 6)
          {
            k = j;
            if (((aspt)localObject).jdField_a_of_type_Int != 10) {}
          }
          else
          {
            localObject = ((aspt)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
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
  
  public void a(boolean paramBoolean, asno paramasno)
  {
    QLog.d("EmoticonPanelMallHelper", 1, "asyncInitPanelDataList begin");
    ThreadManager.post(new EmoticonPanelMallHelper.1(this, paramBoolean, paramasno), 5, null, true);
  }
  
  public int[] a()
  {
    return new int[] { 6, 7, 8, 1, 3 };
  }
  
  public void b()
  {
    ThreadManager.getSubThreadHandler().post(new EmoticonPanelMallHelper.3(this));
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
  
  public void c()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a().isShown()) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelMallHelper.5(this), 200L);
  }
  
  public void d()
  {
    askc.a().a(this);
    askc.a().a(this.jdField_a_of_type_Askq);
  }
  
  public void g()
  {
    askc.a().a(this.jdField_a_of_type_Askq);
  }
  
  public void h()
  {
    askc.a().b(this.jdField_a_of_type_Askq);
  }
  
  public void i()
  {
    askc.a().b(this);
    askc.a().b(this.jdField_a_of_type_Askq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoc
 * JD-Core Version:    0.7.0.1
 */