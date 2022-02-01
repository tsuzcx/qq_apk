package com.tencent.mobileqq.activity.aio.tips;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class HongbaoKeywordGrayTips
  implements GrayTipsTask
{
  private AIOContext a;
  private QQAppInterface b;
  private BaseSessionInfo c;
  private TipsManager d;
  private Time e;
  private final String[] f = { HardCodeUtil.a(2131903500), HardCodeUtil.a(2131903501), HardCodeUtil.a(2131903502) };
  private volatile long g = -1L;
  
  public HongbaoKeywordGrayTips(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext.a();
    this.c = paramAIOContext.O();
    this.d = paramAIOContext.c();
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    boolean bool1 = paramChatMessage instanceof MessageForText;
    boolean bool2 = false;
    if (!bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "match : not MessageForText");
      }
      return false;
    }
    bool1 = bool2;
    if (!TextUtils.isEmpty(paramChatMessage.msg))
    {
      String[] arrayOfString = this.f;
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= j) {
          break;
        }
        String str = arrayOfString[i];
        if (paramChatMessage.msg.contains(str))
        {
          bool1 = true;
          break;
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("match : ret=");
      paramChatMessage.append(bool1);
      QLog.d("HongbaoKeywordGrayTips", 2, paramChatMessage.toString());
    }
    return bool1;
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    boolean bool = a(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("detect : matchKeywords=");
      paramChatMessage.append(bool);
      QLog.d("HongbaoKeywordGrayTips", 2, paramChatMessage.toString());
    }
    if (bool)
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("key_hongbao_keyword_gray_tips");
      paramChatMessage.append(this.b.getCurrentAccountUin());
      paramChatMessage = paramChatMessage.toString();
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
      Object localObject = localSharedPreferences.getString(paramChatMessage, "");
      long l1 = MessageCache.c() * 1000L;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        long l2 = Long.parseLong((String)localObject);
        this.e.set(l2);
        int i = this.e.year;
        int j = this.e.month;
        int k = this.e.monthDay;
        int m = this.e.hour;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("lastShowDate :");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" - ");
          ((StringBuilder)localObject).append(j + 1);
          ((StringBuilder)localObject).append(" - ");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(" - ");
          ((StringBuilder)localObject).append(m);
          QLog.d("HongbaoKeywordGrayTips", 2, ((StringBuilder)localObject).toString());
        }
        if (l1 - l2 <= 86400000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HongbaoKeywordGrayTips", 2, "has show in a day, just return;");
          }
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("HongbaoKeywordGrayTips", 2, "GrayTips show time interval > 1day, can show.");
        }
        if (this.d.a(this, new Object[0])) {
          localSharedPreferences.edit().putString(paramChatMessage, String.valueOf(l1)).commit();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("HongbaoKeywordGrayTips", 2, "GrayTips has never been shown, can show.");
        }
        if (this.d.a(this, new Object[0])) {
          localSharedPreferences.edit().putString(paramChatMessage, String.valueOf(l1)).commit();
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((this.c.a != 0) && (this.c.a != 3000) && (this.c.a != 1)) {
      return;
    }
    if (this.c.a == 1)
    {
      paramVarArgs = (HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((paramVarArgs != null) && (paramVarArgs.b(this.c.b))) {
        return;
      }
    }
    if ((paramInt != 1000) && (paramInt != 1001)) {
      return;
    }
    int j = 0;
    if (paramInt == 1000) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    long l = MessageCache.c();
    if (this.e == null) {
      this.e = new Time();
    }
    this.e.set(l * 1000L);
    int i = this.e.year;
    int k = this.e.month + 1;
    int m = this.e.monthDay;
    int n = this.e.hour;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAIOEvent() :");
      if (paramInt != 0) {
        paramVarArgs = " TYPE_ON_SHOW ";
      } else {
        paramVarArgs = " TYPE_ON_MSG_SENT_RECV";
      }
      ((StringBuilder)localObject).append(paramVarArgs);
      ((StringBuilder)localObject).append(", curDate :");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(n);
      QLog.d("HongbaoKeywordGrayTips", 2, ((StringBuilder)localObject).toString());
    }
    if ((i == 2015) && (k == 2) && (m <= 21) && (m >= 18)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "time not match, just return");
      }
      return;
    }
    if (paramInt != 0)
    {
      ThreadManager.getSubThreadHandler().post(new HongbaoKeywordGrayTips.1(this));
      return;
    }
    paramInt = j;
    if (this.c.a == 0) {
      paramInt = 1;
    }
    l = this.g;
    paramVarArgs = this.a.e().b().d();
    i = paramVarArgs.size();
    if (i > 0)
    {
      i -= 1;
      while (i >= 0)
      {
        localObject = (ChatMessage)paramVarArgs.get(i);
        if (paramInt != 0)
        {
          if (((ChatMessage)localObject).time <= l) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : new message =====>");
          }
          if ((((ChatMessage)localObject).isSendFromLocal()) && (((ChatMessage)localObject).extraflag != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : msg send not success");
            }
          }
          else
          {
            b((ChatMessage)localObject);
            if (((ChatMessage)localObject).time > this.g) {
              this.g = ((ChatMessage)localObject).time;
            }
          }
        }
        else
        {
          if (((ChatMessage)localObject).shmsgseq <= l) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : new message =====>");
          }
          b((ChatMessage)localObject);
          if (((ChatMessage)localObject).shmsgseq > this.g) {
            this.g = ((ChatMessage)localObject).shmsgseq;
          }
        }
        i -= 1;
      }
    }
  }
  
  public MessageRecord a_(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-1045);
    long l = MessageCache.c();
    String str = this.b.getCurrentAccountUin();
    paramVarArgs.init(str, this.c.b, str, "", l, -1045, this.c.a, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public int b()
  {
    return 1004;
  }
  
  public int[] c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips
 * JD-Core Version:    0.7.0.1
 */