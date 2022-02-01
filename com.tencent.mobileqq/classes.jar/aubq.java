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

public class aubq
  implements aubp<FileManagerEntity>
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aubq(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void e(List<FileManagerEntity> paramList, aubv paramaubv)
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
      paramaubv = (FileManagerEntity)paramList.next();
      if (bmad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramaubv, null, true)) {
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
        auea.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131697901));
        return;
      }
      audr.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131719100));
      return;
    }
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, aubv paramaubv)
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
      a(paramList, paramaubv);
      return;
    case 1: 
      b(paramList, paramaubv);
      return;
    case 2: 
      c(paramList, paramaubv);
      return;
    case 4: 
      d(paramList, paramaubv);
      return;
    }
    e(paramList, paramaubv);
  }
  
  protected void a(List<FileManagerEntity> paramList, aubv paramaubv)
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
      ThreadManager.post(new OfflineFileMultiOperate.1(this, localArrayList, paramList, paramaubv), 8, null, true);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OfflineFileMultiOperate.2(this, paramList, paramaubv));
  }
  
  protected void b(List<FileManagerEntity> paramList, aubv paramaubv)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694305, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
    }
    long l;
    do
    {
      return;
      l = 0L;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      audr.a(2131692379);
    } while (paramaubv == null);
    paramaubv.a(1, 2);
    return;
    Object localObject = paramList.iterator();
    label90:
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!aucx.a(localFileManagerEntity).a(true)) {
        break label237;
      }
      l = localFileManagerEntity.fileSize + l;
    }
    label237:
    for (;;)
    {
      break label90;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
      if ((auea.a()) && (l > atpj.a()))
      {
        auea.a(false, this.jdField_a_of_type_AndroidAppActivity, new aubr(this, paramList, (athn)localObject, paramaubv));
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          ((athn)localObject).b(localFileManagerEntity);
        }
      }
      if (paramaubv == null) {
        break;
      }
      paramaubv.a(1, 0);
      return;
    }
  }
  
  protected void c(List<FileManagerEntity> paramList, aubv paramaubv)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694305, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299080));
    }
    do
    {
      return;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      audr.a(2131692380);
    } while (paramaubv == null);
    paramaubv.a(2, 3);
    return;
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!aucx.a((FileManagerEntity)localIterator.next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        audn.a(this.jdField_a_of_type_AndroidAppActivity, 2131692476, 2131692481, new aubs(this, paramList, paramaubv));
        return;
      }
      auea.a(paramList, this.jdField_a_of_type_AndroidAppActivity);
      if (paramaubv == null) {
        break;
      }
      paramaubv.a(2, 0);
      return;
    }
  }
  
  protected void d(List<FileManagerEntity> paramList, aubv paramaubv)
  {
    Object localObject1 = (FileManagerEntity)paramList.get(0);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      audr.a(2131692381);
      return;
    }
    Object localObject2 = paramList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!aucx.a((FileManagerEntity)((Iterator)localObject2).next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!bixr.a(this.jdField_a_of_type_AndroidAppActivity, 5, new aubt(this, paramList, (athn)localObject1, paramaubv))) {
          break;
        }
        audn.a(this.jdField_a_of_type_AndroidAppActivity, 2131692476, 2131692479, new aubu(this, paramList, (athn)localObject1, paramaubv));
        return;
      }
      audr.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692595));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (FileManagerEntity)paramList.next();
        if (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()) {
          if (FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject2).getFilePath())) {
            ((athn)localObject1).a(((FileManagerEntity)localObject2).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          } else {
            ((athn)localObject1).a((FileManagerEntity)localObject2, String.valueOf(((FileManagerEntity)localObject2).peerUin));
          }
        }
      }
      if (paramaubv == null) {
        break;
      }
      paramaubv.a(4, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubq
 * JD-Core Version:    0.7.0.1
 */