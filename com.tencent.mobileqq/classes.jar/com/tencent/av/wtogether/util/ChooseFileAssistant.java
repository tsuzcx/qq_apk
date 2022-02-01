package com.tencent.av.wtogether.util;

import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ChooseFileAssistant
{
  private static ChooseFileAssistant jdField_a_of_type_ComTencentAvWtogetherUtilChooseFileAssistant;
  private final HashMap<String, ChooseFileAssistant.ChatInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  
  public static ChooseFileAssistant a()
  {
    if (jdField_a_of_type_ComTencentAvWtogetherUtilChooseFileAssistant == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvWtogetherUtilChooseFileAssistant == null) {
          jdField_a_of_type_ComTencentAvWtogetherUtilChooseFileAssistant = new ChooseFileAssistant();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvWtogetherUtilChooseFileAssistant;
  }
  
  public ChooseFileInfo a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    paramString = (ChooseFileAssistant.ChatInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo;
    }
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_JavaUtilHashMap.put(localObject, null);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endOfStartWatchTogether, uinType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], uin[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.ChooseFileAssistant", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo)
  {
    a(paramInt, paramString, paramChooseFileInfo, null);
  }
  
  public void a(int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo, SessionInfo paramSessionInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    ChooseFileAssistant.ChatInfo localChatInfo = (ChooseFileAssistant.ChatInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localChatInfo != null)
    {
      localChatInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
    }
    else
    {
      localChatInfo = new ChooseFileAssistant.ChatInfo(null);
      localChatInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
      if (paramSessionInfo != null)
      {
        localChatInfo.jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
        localChatInfo.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
        localChatInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject, localChatInfo);
    }
    if (QLog.isDevelopLevel())
    {
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("onChooseFile, uinType[");
      paramSessionInfo.append(paramInt);
      paramSessionInfo.append("], uin[");
      paramSessionInfo.append(paramString);
      paramSessionInfo.append("], file[");
      paramSessionInfo.append(paramChooseFileInfo);
      paramSessionInfo.append("]");
      QLog.i("WTogether.ChooseFileAssistant", 4, paramSessionInfo.toString());
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramSessionInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramSessionInfo.jdField_a_of_type_JavaLangString);
    localObject = ((StringBuilder)localObject).toString();
    ChooseFileAssistant.ChatInfo localChatInfo = new ChooseFileAssistant.ChatInfo(null);
    localChatInfo.jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
    localChatInfo.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    localChatInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = null;
    localChatInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaUtilHashMap.put(localObject, localChatInfo);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClickQavWatchTogether, chat[");
      ((StringBuilder)localObject).append(paramSessionInfo);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.ChooseFileAssistant", 4, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.ChooseFileAssistant
 * JD-Core Version:    0.7.0.1
 */