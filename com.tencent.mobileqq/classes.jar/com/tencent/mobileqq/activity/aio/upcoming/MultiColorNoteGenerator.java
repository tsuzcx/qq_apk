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
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    return new QQText(paramString, 5).toPlainText(false);
  }
  
  int a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (paramSessionInfo != null) {
      return ((Integer)RecentFaceDecoder.a(paramQQAppInterface, paramSessionInfo.a, paramSessionInfo.b).first).intValue();
    }
    return 4;
  }
  
  public ColorNote a(List<MessageRecord> paramList, long paramLong, int paramInt, SessionInfo paramSessionInfo)
  {
    if ((paramList != null) && (paramList.size() != 0) && (paramSessionInfo != null))
    {
      String str;
      if (paramLong != -1L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.a.getApplication().getString(2131886610));
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append(DateUtils.a(paramLong));
        str = ((StringBuilder)localObject1).toString();
      }
      else
      {
        str = this.a.getApplication().getString(2131886609);
      }
      Object localObject4 = (MessageRecord)paramList.get(0);
      Object localObject1 = ((MessageRecord)localObject4).frienduin;
      int i = paramSessionInfo.a;
      int j = 1;
      if ((i != 1) && (paramSessionInfo.a != 3000)) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject2;
      if ((i != 0) && (a(paramList))) {
        localObject2 = ((MessageRecord)paramList.get(0)).selfuin;
      } else {
        localObject2 = localObject1;
      }
      Object localObject3 = localObject2;
      if (TextUtils.equals(paramSessionInfo.b, QFileAssistantUtils.b(this.a))) {
        localObject3 = QFileAssistantUtils.b(this.a);
      }
      if (i != 0) {
        localObject2 = ContactUtils.d(this.a, (String)localObject3);
      } else if (paramSessionInfo.e == null) {
        localObject2 = localObject1;
      } else {
        localObject2 = paramSessionInfo.e;
      }
      if (paramList.size() != 1)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append("的");
        ((StringBuilder)localObject4).append(paramList.size());
        ((StringBuilder)localObject4).append("条消息");
        localObject2 = ((StringBuilder)localObject4).toString();
      }
      else
      {
        localObject2 = a(((MessageRecord)localObject4).msg);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((localObject4 instanceof MessageForText)) || ((localObject4 instanceof MessageForLongMsg)))) {
          break label380;
        }
        localObject2 = UpComingMsgUtil.a(this.a, (MessageRecord)localObject4);
      }
      label380:
      if (paramSessionInfo.e != null) {
        localObject1 = paramSessionInfo.e;
      }
      localObject1 = a(paramSessionInfo, (String)localObject1);
      localObject4 = new Uri.Builder().scheme("uindrawable");
      if (i != 0) {
        i = j;
      } else {
        i = a(paramSessionInfo, this.a);
      }
      localObject3 = ((Uri.Builder)localObject4).appendQueryParameter("type", String.valueOf(i)).appendQueryParameter("uin", (String)localObject3).toString();
      localObject4 = new ColorNote.Builder();
      ((ColorNote.Builder)localObject4).a(17235968).a(UpComingMsgUtil.a(paramLong)).b(0).b((String)localObject2).c(str).d((String)localObject3).a(a(paramList, paramInt, (String)localObject1, paramSessionInfo.c));
      return ((ColorNote.Builder)localObject4).a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.MultiColorNoteGenerator
 * JD-Core Version:    0.7.0.1
 */