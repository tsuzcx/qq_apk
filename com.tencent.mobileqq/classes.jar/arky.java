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

public class arky
  implements arkx<FileManagerEntity>
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public arky(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, arld paramarld)
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
      a(paramList, paramarld);
      return;
    case 1: 
      b(paramList, paramarld);
      return;
    case 2: 
      c(paramList, paramarld);
      return;
    }
    d(paramList, paramarld);
  }
  
  protected void a(List<FileManagerEntity> paramList, arld paramarld)
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
      ThreadManager.post(new OfflineFileMultiOperate.1(this, localArrayList, paramList, paramarld), 8, null, true);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OfflineFileMultiOperate.2(this, paramList, paramarld));
  }
  
  protected void b(List<FileManagerEntity> paramList, arld paramarld)
  {
    if (!bdee.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694829, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
    }
    long l;
    do
    {
      return;
      l = 0L;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      armz.a(2131692648);
    } while (paramarld == null);
    paramarld.a(1, 2);
    return;
    Object localObject = paramList.iterator();
    label90:
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!armf.a(localFileManagerEntity).a(true)) {
        break label237;
      }
      l = localFileManagerEntity.fileSize + l;
    }
    label237:
    for (;;)
    {
      break label90;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((arni.a()) && (l > aqxg.a()))
      {
        arni.a(false, this.jdField_a_of_type_AndroidAppActivity, new arkz(this, paramList, (aqns)localObject, paramarld));
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          ((aqns)localObject).b(localFileManagerEntity);
        }
      }
      if (paramarld == null) {
        break;
      }
      paramarld.a(1, 0);
      return;
    }
  }
  
  protected void c(List<FileManagerEntity> paramList, arld paramarld)
  {
    if (!bdee.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694829, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
    }
    do
    {
      return;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      armz.a(2131692649);
    } while (paramarld == null);
    paramarld.a(2, 3);
    return;
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!armf.a((FileManagerEntity)localIterator.next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        armv.a(this.jdField_a_of_type_AndroidAppActivity, 2131692752, 2131692757, new arla(this, paramList, paramarld));
        return;
      }
      arni.a(paramList, this.jdField_a_of_type_AndroidAppActivity);
      if (paramarld == null) {
        break;
      }
      paramarld.a(2, 0);
      return;
    }
  }
  
  protected void d(List<FileManagerEntity> paramList, arld paramarld)
  {
    Object localObject1 = (FileManagerEntity)paramList.get(0);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      armz.a(2131692650);
      return;
    }
    Object localObject2 = paramList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!armf.a((FileManagerEntity)((Iterator)localObject2).next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!bevd.a(this.jdField_a_of_type_AndroidAppActivity, 5, new arlb(this, paramList, (aqns)localObject1, paramarld))) {
          break;
        }
        armv.a(this.jdField_a_of_type_AndroidAppActivity, 2131692752, 2131692755, new arlc(this, paramList, (aqns)localObject1, paramarld));
        return;
      }
      armz.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692912));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (FileManagerEntity)paramList.next();
        if (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()) {
          if (bdcs.b(((FileManagerEntity)localObject2).getFilePath())) {
            ((aqns)localObject1).a(((FileManagerEntity)localObject2).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          } else {
            ((aqns)localObject1).a((FileManagerEntity)localObject2, String.valueOf(((FileManagerEntity)localObject2).peerUin));
          }
        }
      }
      if (paramarld == null) {
        break;
      }
      paramarld.a(4, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arky
 * JD-Core Version:    0.7.0.1
 */