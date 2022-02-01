package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.widget.QQToast;

public class FileSaveHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private BaseChatPie a;
  
  public FileSaveHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null)) {
      ((MultiRichMediaSaveManager)this.a.d.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER)).onDestroy();
    }
  }
  
  private void b()
  {
    Object localObject = this.a.d;
    if (((QQAppInterface)localObject).getFileManagerProxy() != null) {
      ((QQAppInterface)localObject).getFileManagerProxy().e();
    }
    SessionInfo localSessionInfo = this.a.ah;
    if (!TextUtils.isEmpty(localSessionInfo.b))
    {
      FileManagerDataCenter.b((QQAppInterface)localObject, localSessionInfo.b, localSessionInfo.a, -3010);
      FileManagerDataCenter.b((QQAppInterface)localObject, localSessionInfo.b, localSessionInfo.a, -4020);
    }
    localObject = FileTransferManager.a((QQAppInterface)localObject);
    if (localObject != null) {
      ((FileTransferManager)localObject).b();
    }
  }
  
  public String getTag()
  {
    return "FileSaveHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 16711683) {
      QQToast.makeText(this.a.e, 2131916243, 1).show(this.a.A());
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 15) {
      return;
    }
    b();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FileSaveHelper
 * JD-Core Version:    0.7.0.1
 */