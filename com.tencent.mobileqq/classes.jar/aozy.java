import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.1;
import com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate.2;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aozy
  implements aozx<FileManagerEntity>
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aozy(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, apad paramapad)
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
      a(paramList, paramapad);
      return;
    case 1: 
      b(paramList, paramapad);
      return;
    case 2: 
      c(paramList, paramapad);
      return;
    }
    d(paramList, paramapad);
  }
  
  protected void a(List<FileManagerEntity> paramList, apad paramapad)
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
      ThreadManager.post(new OfflineFileMultiOperate.1(this, localArrayList, paramList, paramapad), 8, null, true);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OfflineFileMultiOperate.2(this, paramList, paramapad));
  }
  
  protected void b(List<FileManagerEntity> paramList, apad paramapad)
  {
    if (!badq.d(BaseApplication.getContext())) {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2131629008, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
    }
    long l;
    do
    {
      return;
      l = 0L;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      apcb.a(2131626953);
    } while (paramapad == null);
    paramapad.a(1, 2);
    return;
    Object localObject = paramList.iterator();
    label90:
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!apbf.a(localFileManagerEntity).a(true)) {
        break label237;
      }
      l = localFileManagerEntity.fileSize + l;
    }
    label237:
    for (;;)
    {
      break label90;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((apck.a()) && (l > aonj.a()))
      {
        apck.a(false, this.jdField_a_of_type_AndroidAppActivity, new aozz(this, paramList, (aodw)localObject, paramapad));
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          ((aodw)localObject).b(localFileManagerEntity);
        }
      }
      if (paramapad == null) {
        break;
      }
      paramapad.a(1, 0);
      return;
    }
  }
  
  protected void c(List<FileManagerEntity> paramList, apad paramapad)
  {
    if (!badq.d(BaseApplication.getContext())) {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2131629008, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
    }
    do
    {
      return;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      apcb.a(2131626954);
    } while (paramapad == null);
    paramapad.a(2, 3);
    return;
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!apbf.a((FileManagerEntity)localIterator.next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        apbx.a(this.jdField_a_of_type_AndroidAppActivity, 2131627035, 2131627040, new apaa(this, paramList, paramapad));
        return;
      }
      apck.a(paramList, this.jdField_a_of_type_AndroidAppActivity);
      if (paramapad == null) {
        break;
      }
      paramapad.a(2, 0);
      return;
    }
  }
  
  protected void d(List<FileManagerEntity> paramList, apad paramapad)
  {
    Object localObject1 = (FileManagerEntity)paramList.get(0);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      apcb.a(2131626955);
      return;
    }
    Object localObject2 = paramList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!apbf.a((FileManagerEntity)((Iterator)localObject2).next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!bbrm.a(this.jdField_a_of_type_AndroidAppActivity, 5, new apab(this, paramList, (aodw)localObject1, paramapad))) {
          break;
        }
        apbx.a(this.jdField_a_of_type_AndroidAppActivity, 2131627035, 2131627038, new apac(this, paramList, (aodw)localObject1, paramapad));
        return;
      }
      apcb.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131627191));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (FileManagerEntity)paramList.next();
        if (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()) {
          if (bace.b(((FileManagerEntity)localObject2).getFilePath())) {
            ((aodw)localObject1).a(((FileManagerEntity)localObject2).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          } else {
            ((aodw)localObject1).a((FileManagerEntity)localObject2, String.valueOf(((FileManagerEntity)localObject2).peerUin));
          }
        }
      }
      if (paramapad == null) {
        break;
      }
      paramapad.a(4, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aozy
 * JD-Core Version:    0.7.0.1
 */