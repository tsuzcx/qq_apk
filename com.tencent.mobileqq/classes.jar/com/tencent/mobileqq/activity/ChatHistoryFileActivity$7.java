package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ChatHistoryFileActivity$7
  implements Runnable
{
  ChatHistoryFileActivity$7(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList1, List paramList2, boolean paramBoolean, List paramList3) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      this.this$0.app.getMessageFacade().a((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
    } else if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
      this.this$0.app.getMessageFacade().a(this.jdField_a_of_type_JavaUtilList, false);
    }
    Object localObject1 = this.b;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        ((FileManagerEntity)localObject2).bDelInAio = true;
        if (QLog.isDevelopLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("ChatHistory entity[");
          ((StringBuilder)localObject3).append(((FileManagerEntity)localObject2).getId());
          ((StringBuilder)localObject3).append("] del File:");
          ((StringBuilder)localObject3).append(((FileManagerEntity)localObject2).nSessionId);
          QLog.d("ChatHistoryFIleActivity", 1, ((StringBuilder)localObject3).toString());
        }
        this.this$0.app.getFileManagerEngine().b(((FileManagerEntity)localObject2).nSessionId);
      }
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = new JSONObject();
        localObject2 = new JSONArray();
        ((JSONObject)localObject1).put("recent_file_list", localObject2);
        localObject3 = this.c.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((JSONArray)localObject2).put(((TencentDocData)((Iterator)localObject3).next()).translate2JsonObject());
        }
        localObject2 = ((ITeamWorkHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).delRecentFilesByHttp((JSONObject)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryFIleActivity", 1, ((JSONObject)localObject1).toString());
        }
        if (((JSONObject)localObject2).getInt("retcode") == 0) {
          FileManagerReporter.a("0X8009AA0");
        } else {
          FMToastUtil.a(((JSONObject)localObject2).getString("msg"));
        }
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryFIleActivity", 1, localJSONException.getMessage());
      }
    }
    this.this$0.a.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.7
 * JD-Core Version:    0.7.0.1
 */