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

public class aprw
  implements aprv<FileManagerEntity>
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aprw(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, apsb paramapsb)
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
      a(paramList, paramapsb);
      return;
    case 1: 
      b(paramList, paramapsb);
      return;
    case 2: 
      c(paramList, paramapsb);
      return;
    }
    d(paramList, paramapsb);
  }
  
  protected void a(List<FileManagerEntity> paramList, apsb paramapsb)
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
      ThreadManager.post(new OfflineFileMultiOperate.1(this, localArrayList, paramList, paramapsb), 8, null, true);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OfflineFileMultiOperate.2(this, paramList, paramapsb));
  }
  
  protected void b(List<FileManagerEntity> paramList, apsb paramapsb)
  {
    if (!bbfj.d(BaseApplication.getContext())) {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, 2131694673, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
    }
    long l;
    do
    {
      return;
      l = 0L;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      aptx.a(2131692572);
    } while (paramapsb == null);
    paramapsb.a(1, 2);
    return;
    Object localObject = paramList.iterator();
    label90:
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!aptd.a(localFileManagerEntity).a(true)) {
        break label237;
      }
      l = localFileManagerEntity.fileSize + l;
    }
    label237:
    for (;;)
    {
      break label90;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((apug.a()) && (l > apei.a()))
      {
        apug.a(false, this.jdField_a_of_type_AndroidAppActivity, new aprx(this, paramList, (aouu)localObject, paramapsb));
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          ((aouu)localObject).b(localFileManagerEntity);
        }
      }
      if (paramapsb == null) {
        break;
      }
      paramapsb.a(1, 0);
      return;
    }
  }
  
  protected void c(List<FileManagerEntity> paramList, apsb paramapsb)
  {
    if (!bbfj.d(BaseApplication.getContext())) {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, 2131694673, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
    }
    do
    {
      return;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      aptx.a(2131692573);
    } while (paramapsb == null);
    paramapsb.a(2, 3);
    return;
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!aptd.a((FileManagerEntity)localIterator.next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        aptt.a(this.jdField_a_of_type_AndroidAppActivity, 2131692673, 2131692678, new apry(this, paramList, paramapsb));
        return;
      }
      apug.a(paramList, this.jdField_a_of_type_AndroidAppActivity);
      if (paramapsb == null) {
        break;
      }
      paramapsb.a(2, 0);
      return;
    }
  }
  
  protected void d(List<FileManagerEntity> paramList, apsb paramapsb)
  {
    Object localObject1 = (FileManagerEntity)paramList.get(0);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      aptx.a(2131692574);
      return;
    }
    Object localObject2 = paramList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!aptd.a((FileManagerEntity)((Iterator)localObject2).next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!bcwb.a(this.jdField_a_of_type_AndroidAppActivity, 5, new aprz(this, paramList, (aouu)localObject1, paramapsb))) {
          break;
        }
        aptt.a(this.jdField_a_of_type_AndroidAppActivity, 2131692673, 2131692676, new apsa(this, paramList, (aouu)localObject1, paramapsb));
        return;
      }
      aptx.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692830));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (FileManagerEntity)paramList.next();
        if (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()) {
          if (bbdx.b(((FileManagerEntity)localObject2).getFilePath())) {
            ((aouu)localObject1).a(((FileManagerEntity)localObject2).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          } else {
            ((aouu)localObject1).a((FileManagerEntity)localObject2, String.valueOf(((FileManagerEntity)localObject2).peerUin));
          }
        }
      }
      if (paramapsb == null) {
        break;
      }
      paramapsb.a(4, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprw
 * JD-Core Version:    0.7.0.1
 */