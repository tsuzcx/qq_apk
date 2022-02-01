package com.tencent.av.wtogether.util;

import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ChooseFileAssistant
{
  private static ChooseFileAssistant jdField_a_of_type_ComTencentAvWtogetherUtilChooseFileAssistant = null;
  private final HashMap<String, ChooseFileAssistant.ChatInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  
  public static ChooseFileAssistant a()
  {
    if (jdField_a_of_type_ComTencentAvWtogetherUtilChooseFileAssistant == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvWtogetherUtilChooseFileAssistant == null) {
        jdField_a_of_type_ComTencentAvWtogetherUtilChooseFileAssistant = new ChooseFileAssistant();
      }
      return jdField_a_of_type_ComTencentAvWtogetherUtilChooseFileAssistant;
    }
    finally {}
  }
  
  public ChooseFileInfo a(int paramInt, String paramString)
  {
    paramString = paramInt + "_" + paramString;
    paramString = (ChooseFileAssistant.ChatInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo;
    }
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    String str = paramInt + "_" + paramString;
    this.jdField_a_of_type_JavaUtilHashMap.put(str, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.ChooseFileAssistant", 4, "endOfStartWatchTogether, uinType[" + paramInt + "], uin[" + paramString + "]");
    }
  }
  
  public void a(int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo)
  {
    a(paramInt, paramString, paramChooseFileInfo, null);
  }
  
  public void a(int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo, SessionInfo paramSessionInfo)
  {
    String str = paramInt + "_" + paramString;
    ChooseFileAssistant.ChatInfo localChatInfo = (ChooseFileAssistant.ChatInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    if (localChatInfo != null) {
      localChatInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.ChooseFileAssistant", 4, "onChooseFile, uinType[" + paramInt + "], uin[" + paramString + "], file[" + paramChooseFileInfo + "]");
      }
      return;
      localChatInfo = new ChooseFileAssistant.ChatInfo(null);
      localChatInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
      if (paramSessionInfo != null)
      {
        localChatInfo.jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
        localChatInfo.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
        localChatInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localChatInfo);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.jdField_a_of_type_Int + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString;
    ChooseFileAssistant.ChatInfo localChatInfo = new ChooseFileAssistant.ChatInfo(null);
    localChatInfo.jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
    localChatInfo.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    localChatInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = null;
    localChatInfo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaUtilHashMap.put(str, localChatInfo);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.ChooseFileAssistant", 4, "onClickQavWatchTogether, chat[" + paramSessionInfo + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.util.ChooseFileAssistant
 * JD-Core Version:    0.7.0.1
 */