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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aukz
  implements auky<FileManagerEntity>
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aukz(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void e(List<FileManagerEntity> paramList, aule paramaule)
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
      paramaule = (FileManagerEntity)paramList.next();
      if (bmko.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramaule, null, true)) {
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
        aunj.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131697475));
        return;
      }
      auna.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131718463));
      return;
    }
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, aule paramaule)
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
      a(paramList, paramaule);
      return;
    case 1: 
      b(paramList, paramaule);
      return;
    case 2: 
      c(paramList, paramaule);
      return;
    case 4: 
      d(paramList, paramaule);
      return;
    }
    e(paramList, paramaule);
  }
  
  protected void a(List<FileManagerEntity> paramList, aule paramaule)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FileManagerEntity)localIterator.next();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
      if (localObject != null) {
        localArrayList.add((ChatMessage)localObject);
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.post(new OfflineFileMultiOperate.1(this, localArrayList, paramList, paramaule), 8, null, true);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OfflineFileMultiOperate.2(this, paramList, paramaule));
  }
  
  protected void b(List<FileManagerEntity> paramList, aule paramaule)
  {
    if (!bhnv.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694008, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011));
    }
    long l;
    do
    {
      return;
      l = 0L;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      auna.a(2131692241);
    } while (paramaule == null);
    paramaule.a(1, 2);
    return;
    Object localObject = paramList.iterator();
    label90:
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!aumg.a(localFileManagerEntity).a(true)) {
        break label237;
      }
      l = localFileManagerEntity.fileSize + l;
    }
    label237:
    for (;;)
    {
      break label90;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((aunj.a()) && (l > atyt.a()))
      {
        aunj.a(false, this.jdField_a_of_type_AndroidAppActivity, new aula(this, paramList, (atqx)localObject, paramaule));
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          ((atqx)localObject).b(localFileManagerEntity);
        }
      }
      if (paramaule == null) {
        break;
      }
      paramaule.a(1, 0);
      return;
    }
  }
  
  protected void c(List<FileManagerEntity> paramList, aule paramaule)
  {
    if (!bhnv.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694008, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011));
    }
    do
    {
      return;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      auna.a(2131692242);
    } while (paramaule == null);
    paramaule.a(2, 3);
    return;
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!aumg.a((FileManagerEntity)localIterator.next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        aumw.a(this.jdField_a_of_type_AndroidAppActivity, 2131692326, 2131692331, new aulb(this, paramList, paramaule));
        return;
      }
      aunj.a(paramList, this.jdField_a_of_type_AndroidAppActivity);
      if (paramaule == null) {
        break;
      }
      paramaule.a(2, 0);
      return;
    }
  }
  
  protected void d(List<FileManagerEntity> paramList, aule paramaule)
  {
    Object localObject1 = (FileManagerEntity)paramList.get(0);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      auna.a(2131692243);
      return;
    }
    Object localObject2 = paramList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!aumg.a((FileManagerEntity)((Iterator)localObject2).next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!bjhk.a(this.jdField_a_of_type_AndroidAppActivity, 5, new aulc(this, paramList, (atqx)localObject1, paramaule))) {
          break;
        }
        aumw.a(this.jdField_a_of_type_AndroidAppActivity, 2131692326, 2131692329, new auld(this, paramList, (atqx)localObject1, paramaule));
        return;
      }
      auna.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692445));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (FileManagerEntity)paramList.next();
        if (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()) {
          if (bhmi.b(((FileManagerEntity)localObject2).getFilePath())) {
            ((atqx)localObject1).a(((FileManagerEntity)localObject2).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          } else {
            ((atqx)localObject1).a((FileManagerEntity)localObject2, String.valueOf(((FileManagerEntity)localObject2).peerUin));
          }
        }
      }
      if (paramaule == null) {
        break;
      }
      paramaule.a(4, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukz
 * JD-Core Version:    0.7.0.1
 */