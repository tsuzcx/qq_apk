package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileAssistantChatHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  private QQAppInterface a;
  private BaseChatPie b;
  private FMObserver c;
  
  public FileAssistantChatHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
    this.a = paramBaseChatPie.d;
    if ((paramBaseChatPie instanceof DatalineChatPie)) {
      paramHelperProvider.a(this);
    }
  }
  
  private void c(Intent paramIntent)
  {
    SessionInfo localSessionInfo = this.b.aE();
    QLog.i("DatalineChatPie<FileAssistant>", 1, "--DatalineChatPie sendByFile--");
    if (56 == paramIntent.getIntExtra(AlbumConstants.h, -1))
    {
      Object localObject = paramIntent.getExtras().getString("file_send_path");
      this.a.getFileManagerEngine().a((String)localObject, localSessionInfo.c, localSessionInfo.b, localSessionInfo.a, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sessionInfo.troopUin： ");
      ((StringBuilder)localObject).append(localSessionInfo.c);
      ((StringBuilder)localObject).append("； sessionInfo.curFriendUin： ");
      ((StringBuilder)localObject).append(localSessionInfo.b);
      QLog.i("DatalineChatPie<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    b(paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    String str = paramIntent.getExtras().getString("file_send_path");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    DatalineDeviceChooseModel.a(localArrayList).a(this.b.e, this.a, new FileAssistantChatHelper.1(this, paramIntent));
  }
  
  public void b(Intent paramIntent)
  {
    SessionInfo localSessionInfo = this.b.aE();
    QLog.i("DatalineChatPie<FileAssistant>", 1, "--DatalineChatPie internalSendByFile--");
    Object localObject;
    if (2 == paramIntent.getIntExtra(AlbumConstants.h, -1))
    {
      if (paramIntent.getExtras().containsKey("PhotoConst.PHOTO_PATHS"))
      {
        localObject = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            this.a.getFileManagerEngine().a(str, localSessionInfo.c, localSessionInfo.b, localSessionInfo.a, true);
          }
        }
      }
      if (paramIntent.getExtras().containsKey("file_send_path"))
      {
        localObject = paramIntent.getExtras().getString("file_send_path");
        this.a.getFileManagerEngine().a((String)localObject, localSessionInfo.c, localSessionInfo.b, localSessionInfo.a, true);
      }
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      this.b.aX().getIntent().removeExtra("PhotoConst.SEND_FLAG");
      paramIntent = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          localObject = (String)paramIntent.next();
          this.a.getFileManagerEngine().a((String)localObject, localSessionInfo.c, localSessionInfo.b, localSessionInfo.a, true);
        }
      }
    }
  }
  
  public String getTag()
  {
    return "FileAssistantChatHelper<FileAssistant>";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 1, 15 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramInt1 == 2)
      {
        a(paramIntent);
        return;
      }
      if ((paramInt1 == 10004) && (paramIntent.getIntExtra(AlbumConstants.h, -1) == 2)) {
        a(paramIntent);
      }
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 15) {
        return;
      }
      this.a.getFileManagerNotifyCenter().deleteObserver(this.c);
      return;
    }
    if (this.c == null) {
      this.c = new FileAssistantChatHelper.MyFMObserver(this, null);
    }
    this.a.getFileManagerNotifyCenter().addObserver(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FileAssistantChatHelper
 * JD-Core Version:    0.7.0.1
 */