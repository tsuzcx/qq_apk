package com.tencent.mobileqq.activity;

import aqns;
import armz;
import arng;
import badd;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
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
      this.this$0.app.a().a((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
    }
    Object localObject1;
    Object localObject2;
    while ((this.b != null) && (this.b.size() > 0))
    {
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        ((FileManagerEntity)localObject2).bDelInAio = true;
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatHistoryFIleActivity", 1, "ChatHistory entity[" + ((FileManagerEntity)localObject2).getId() + "] del File:" + ((FileManagerEntity)localObject2).nSessionId);
        }
        this.this$0.app.a().b(((FileManagerEntity)localObject2).nSessionId);
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
        this.this$0.app.a().a(this.jdField_a_of_type_JavaUtilList, false);
      }
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = new JSONObject();
        localObject2 = new JSONArray();
        ((JSONObject)localObject1).put("recent_file_list", localObject2);
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
          ((JSONArray)localObject2).put(((TencentDocData)localIterator.next()).translate2JsonObject());
        }
      }
      this.this$0.a.sendEmptyMessage(2);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryFIleActivity", 1, localJSONException.getMessage());
      }
    }
    for (;;)
    {
      return;
      localObject2 = ((badd)this.this$0.app.a(122)).a(localJSONException);
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryFIleActivity", 1, localJSONException.toString());
      }
      if (((JSONObject)localObject2).getInt("retcode") == 0) {
        arng.a("0X8009AA0");
      } else {
        armz.a(((JSONObject)localObject2).getString("msg"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity.7
 * JD-Core Version:    0.7.0.1
 */