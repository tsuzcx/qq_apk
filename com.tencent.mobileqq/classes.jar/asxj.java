import android.app.Activity;
import android.content.res.Resources;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.1;
import com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.2;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class asxj
  implements asxi<FileManagerEntity>
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public asxj(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void e(List<FileManagerEntity> paramList, asxo paramasxo)
  {
    if (paramList == null)
    {
      QLog.w("OfflineFileMultiOperate", 1, "fileList == null");
      return;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      paramasxo = (FileManagerEntity)paramList.next();
      if (bkov.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramasxo, null, true)) {
        break label96;
      }
      i = 1;
    }
    label96:
    for (;;)
    {
      break;
      if (i != 0)
      {
        aszt.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131697621));
        return;
      }
      aszk.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131718711));
      return;
    }
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, asxo paramasxo)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("OfflineFileMultiOperate", 1, "doFileMultiOperate no any file");
      return;
    }
    switch (paramInt)
    {
    default: 
      QLog.e("OfflineFileMultiOperate", 1, "doFileMultiOperate unkonw optype:" + paramInt);
      return;
    case 3: 
      a(paramList, paramasxo);
      return;
    case 1: 
      b(paramList, paramasxo);
      return;
    case 2: 
      c(paramList, paramasxo);
      return;
    case 4: 
      d(paramList, paramasxo);
      return;
    }
    e(paramList, paramasxo);
  }
  
  protected void a(List<FileManagerEntity> paramList, asxo paramasxo)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FileManagerEntity)localIterator.next();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
      if (localObject != null) {
        localArrayList.add((ChatMessage)localObject);
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.post(new OfflineFileMultiOperate.1(this, localArrayList, paramList, paramasxo), 8, null, true);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OfflineFileMultiOperate.2(this, paramList, paramasxo));
  }
  
  protected void b(List<FileManagerEntity> paramList, asxo paramasxo)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694108, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076));
    }
    long l;
    do
    {
      return;
      l = 0L;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      aszk.a(2131692289);
    } while (paramasxo == null);
    paramasxo.a(1, 2);
    return;
    Object localObject = paramList.iterator();
    label90:
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!asyq.a(localFileManagerEntity).a(true)) {
        break label237;
      }
      l = localFileManagerEntity.fileSize + l;
    }
    label237:
    for (;;)
    {
      break label90;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
      if ((aszt.a()) && (l > asld.a()))
      {
        aszt.a(false, this.jdField_a_of_type_AndroidAppActivity, new asxk(this, paramList, (asdg)localObject, paramasxo));
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          ((asdg)localObject).b(localFileManagerEntity);
        }
      }
      if (paramasxo == null) {
        break;
      }
      paramasxo.a(1, 0);
      return;
    }
  }
  
  protected void c(List<FileManagerEntity> paramList, asxo paramasxo)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694108, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076));
    }
    do
    {
      return;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      aszk.a(2131692290);
    } while (paramasxo == null);
    paramasxo.a(2, 3);
    return;
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!asyq.a((FileManagerEntity)localIterator.next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        aszg.a(this.jdField_a_of_type_AndroidAppActivity, 2131692374, 2131692379, new asxl(this, paramList, paramasxo));
        return;
      }
      aszt.a(paramList, this.jdField_a_of_type_AndroidAppActivity);
      if (paramasxo == null) {
        break;
      }
      paramasxo.a(2, 0);
      return;
    }
  }
  
  protected void d(List<FileManagerEntity> paramList, asxo paramasxo)
  {
    Object localObject1 = (FileManagerEntity)paramList.get(0);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      aszk.a(2131692291);
      return;
    }
    Object localObject2 = paramList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!asyq.a((FileManagerEntity)((Iterator)localObject2).next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!bhnb.a(this.jdField_a_of_type_AndroidAppActivity, 5, new asxm(this, paramList, (asdg)localObject1, paramasxo))) {
          break;
        }
        aszg.a(this.jdField_a_of_type_AndroidAppActivity, 2131692374, 2131692377, new asxn(this, paramList, (asdg)localObject1, paramasxo));
        return;
      }
      aszk.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692493));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (FileManagerEntity)paramList.next();
        if (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()) {
          if (FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject2).getFilePath())) {
            ((asdg)localObject1).a(((FileManagerEntity)localObject2).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          } else {
            ((asdg)localObject1).a((FileManagerEntity)localObject2, String.valueOf(((FileManagerEntity)localObject2).peerUin));
          }
        }
      }
      if (paramasxo == null) {
        break;
      }
      paramasxo.a(4, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxj
 * JD-Core Version:    0.7.0.1
 */