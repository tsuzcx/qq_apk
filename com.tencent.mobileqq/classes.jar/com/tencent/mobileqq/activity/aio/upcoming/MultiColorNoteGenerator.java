package com.tencent.mobileqq.activity.aio.upcoming;

import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;
import mqq.app.MobileQQ;

public class MultiColorNoteGenerator
  extends ColorNoteGenerator
{
  public MultiColorNoteGenerator(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private String a(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return "";
    }
    return new QQText(paramString, 5).toPlainText(false);
  }
  
  int a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    int i = 4;
    if (paramSessionInfo != null) {
      i = ((Integer)RecentFaceDecoder.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString).first).intValue();
    }
    return i;
  }
  
  public ColorNote a(List<MessageRecord> paramList, long paramLong, int paramInt, SessionInfo paramSessionInfo)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramSessionInfo == null)) {
      return null;
    }
    String str3;
    Object localObject;
    String str1;
    if (paramLong != -1L)
    {
      str3 = this.a.getApplication().getString(2131690054) + ": " + DateUtils.a(paramLong);
      localObject = (MessageRecord)paramList.get(0);
      str1 = ((MessageRecord)localObject).frienduin;
      if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
        break label489;
      }
    }
    label137:
    label180:
    label226:
    label489:
    for (int i = 0;; i = 1)
    {
      String str2;
      if ((i != 0) && (a(paramList)))
      {
        str2 = ((MessageRecord)paramList.get(0)).selfuin;
        if (!TextUtils.equals(paramSessionInfo.jdField_a_of_type_JavaLangString, QFileAssistantUtils.a(this.a))) {
          break label482;
        }
      }
      for (String str4 = QFileAssistantUtils.a(this.a);; str4 = str2)
      {
        if (i != 0)
        {
          str2 = ContactUtils.j(this.a, str4);
          if (paramList.size() == 1) {
            break label405;
          }
          str2 = str2 + "的" + paramList.size() + "条消息";
        }
        for (;;)
        {
          if (paramSessionInfo.d == null)
          {
            label234:
            str1 = a(paramSessionInfo, str1);
            localObject = new Uri.Builder().scheme("uindrawable");
            if (i == 0) {
              break label464;
            }
          }
          for (i = 1;; i = a(paramSessionInfo, this.a))
          {
            str4 = ((Uri.Builder)localObject).appendQueryParameter("type", String.valueOf(i)).appendQueryParameter("uin", str4).toString();
            localObject = new ColorNote.Builder();
            ((ColorNote.Builder)localObject).a(17235968).a(UpComingMsgUtil.a(paramLong)).b(0).b(str2).c(str3).d(str4).a(a(paramList, paramInt, str1, paramSessionInfo.b));
            return ((ColorNote.Builder)localObject).a();
            str3 = this.a.getApplication().getString(2131690053);
            break;
            str2 = str1;
            break label137;
            if (paramSessionInfo.d == null)
            {
              str2 = str1;
              break label180;
            }
            str2 = paramSessionInfo.d;
            break label180;
            str2 = a(((MessageRecord)localObject).msg);
            if ((!TextUtils.isEmpty(str2)) && (((localObject instanceof MessageForText)) || ((localObject instanceof MessageForLongMsg)))) {
              break label479;
            }
            str2 = UpComingMsgUtil.a(this.a, (MessageRecord)localObject);
            break label226;
            str1 = paramSessionInfo.d;
            break label234;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.MultiColorNoteGenerator
 * JD-Core Version:    0.7.0.1
 */