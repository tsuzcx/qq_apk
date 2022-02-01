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
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  
  public FileAssistantChatHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((paramBaseChatPie instanceof DatalineChatPie)) {
      paramHelperProvider.a(this);
    }
  }
  
  private void c(Intent paramIntent)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    QLog.i("DatalineChatPie<FileAssistant>", 1, "--DatalineChatPie sendByFile--");
    if (56 == paramIntent.getIntExtra(AlbumConstants.h, -1))
    {
      Object localObject = paramIntent.getExtras().getString("file_send_path");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((String)localObject, localSessionInfo.b, localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sessionInfo.troopUin： ");
      ((StringBuilder)localObject).append(localSessionInfo.b);
      ((StringBuilder)localObject).append("； sessionInfo.curFriendUin： ");
      ((StringBuilder)localObject).append(localSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.i("DatalineChatPie<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    b(paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    String str = paramIntent.getExtras().getString("file_send_path");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    DatalineDeviceChooseModel.a(localArrayList).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new FileAssistantChatHelper.1(this, paramIntent));
  }
  
  public void b(Intent paramIntent)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(str, localSessionInfo.b, localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, true);
          }
        }
      }
      if (paramIntent.getExtras().containsKey("file_send_path"))
      {
        localObject = paramIntent.getExtras().getString("file_send_path");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((String)localObject, localSessionInfo.b, localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, true);
      }
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getIntent().removeExtra("PhotoConst.SEND_FLAG");
      paramIntent = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          localObject = (String)paramIntent.next();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((String)localObject, localSessionInfo.b, localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, true);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new FileAssistantChatHelper.MyFMObserver(this, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FileAssistantChatHelper
 * JD-Core Version:    0.7.0.1
 */