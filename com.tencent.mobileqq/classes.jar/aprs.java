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

public class aprs
  implements aprr<FileManagerEntity>
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aprs(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, aprx paramaprx)
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
      a(paramList, paramaprx);
      return;
    case 1: 
      b(paramList, paramaprx);
      return;
    case 2: 
      c(paramList, paramaprx);
      return;
    }
    d(paramList, paramaprx);
  }
  
  protected void a(List<FileManagerEntity> paramList, aprx paramaprx)
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
      ThreadManager.post(new OfflineFileMultiOperate.1(this, localArrayList, paramList, paramaprx), 8, null, true);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OfflineFileMultiOperate.2(this, paramList, paramaprx));
  }
  
  protected void b(List<FileManagerEntity> paramList, aprx paramaprx)
  {
    if (!bbev.d(BaseApplication.getContext())) {
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 2131694672, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
    }
    long l;
    do
    {
      return;
      l = 0L;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      aptv.a(2131692571);
    } while (paramaprx == null);
    paramaprx.a(1, 2);
    return;
    Object localObject = paramList.iterator();
    label90:
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!apsz.a(localFileManagerEntity).a(true)) {
        break label237;
      }
      l = localFileManagerEntity.fileSize + l;
    }
    label237:
    for (;;)
    {
      break label90;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((apue.a()) && (l > apee.a()))
      {
        apue.a(false, this.jdField_a_of_type_AndroidAppActivity, new aprt(this, paramList, (aouq)localObject, paramaprx));
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          ((aouq)localObject).b(localFileManagerEntity);
        }
      }
      if (paramaprx == null) {
        break;
      }
      paramaprx.a(1, 0);
      return;
    }
  }
  
  protected void c(List<FileManagerEntity> paramList, aprx paramaprx)
  {
    if (!bbev.d(BaseApplication.getContext())) {
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 2131694672, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
    }
    do
    {
      return;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      aptv.a(2131692572);
    } while (paramaprx == null);
    paramaprx.a(2, 3);
    return;
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!apsz.a((FileManagerEntity)localIterator.next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        aptr.a(this.jdField_a_of_type_AndroidAppActivity, 2131692672, 2131692677, new apru(this, paramList, paramaprx));
        return;
      }
      apue.a(paramList, this.jdField_a_of_type_AndroidAppActivity);
      if (paramaprx == null) {
        break;
      }
      paramaprx.a(2, 0);
      return;
    }
  }
  
  protected void d(List<FileManagerEntity> paramList, aprx paramaprx)
  {
    Object localObject1 = (FileManagerEntity)paramList.get(0);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      aptv.a(2131692573);
      return;
    }
    Object localObject2 = paramList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!apsz.a((FileManagerEntity)((Iterator)localObject2).next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!bcvm.a(this.jdField_a_of_type_AndroidAppActivity, 5, new aprv(this, paramList, (aouq)localObject1, paramaprx))) {
          break;
        }
        aptr.a(this.jdField_a_of_type_AndroidAppActivity, 2131692672, 2131692675, new aprw(this, paramList, (aouq)localObject1, paramaprx));
        return;
      }
      aptv.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692829));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (FileManagerEntity)paramList.next();
        if (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()) {
          if (bbdj.b(((FileManagerEntity)localObject2).getFilePath())) {
            ((aouq)localObject1).a(((FileManagerEntity)localObject2).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          } else {
            ((aouq)localObject1).a((FileManagerEntity)localObject2, String.valueOf(((FileManagerEntity)localObject2).peerUin));
          }
        }
      }
      if (paramaprx == null) {
        break;
      }
      paramaprx.a(4, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprs
 * JD-Core Version:    0.7.0.1
 */