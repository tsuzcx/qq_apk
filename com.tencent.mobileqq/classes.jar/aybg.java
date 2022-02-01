import android.database.Cursor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGEntityManager;
import java.util.Iterator;
import java.util.List;

public class aybg
  extends OGEntityManager
{
  public aybg(SQLiteOpenHelper paramSQLiteOpenHelper, String paramString)
  {
    super(paramSQLiteOpenHelper, paramString);
  }
  
  public List<MessageRecord> a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, QQAppInterface paramQQAppInterface)
  {
    paramString1 = rawQuery(MessageRecord.class, paramString1, paramString2, paramString3, paramArrayOfString);
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      paramString2 = paramString1.iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (MessageRecord)paramString2.next();
        paramQQAppInterface.getMessageFacade().tryUpdateUniseqByID(paramString3.frienduin, paramString3.istroop, paramString3);
      }
    }
    return paramString1;
  }
  
  public List<MessageRecord> a(String paramString, String[] paramArrayOfString, QQAppInterface paramQQAppInterface)
  {
    paramString = rawQuery(MessageRecord.class, paramString, paramArrayOfString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramArrayOfString = paramString.iterator();
      while (paramArrayOfString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayOfString.next();
        paramQQAppInterface.getMessageFacade().tryUpdateUniseqByID(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord);
      }
    }
    return paramString;
  }
  
  public Entity cursor2Entity(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    long l2 = -1L;
    long l1 = l2;
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {
        l1 = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      }
    }
    catch (Exception paramNoColumnErrorHandler)
    {
      try
      {
        if (paramClass.getName().equals(MessageRecord.class.getName()))
        {
          int i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
          paramClass = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
          int j = paramCursor.getInt(paramCursor.getColumnIndex("extLong"));
          paramNoColumnErrorHandler = paramCursor.getString(paramCursor.getColumnIndex("extStr"));
          int k = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
          MessageRecord localMessageRecord = bbli.a(i, paramClass, j, paramNoColumnErrorHandler, k);
          localMessageRecord.msgData = paramClass;
          localMessageRecord._id = l1;
          localMessageRecord.extLong = j;
          localMessageRecord.extStr = paramNoColumnErrorHandler;
          localMessageRecord.istroop = k;
          localMessageRecord.selfuin = paramCursor.getString(paramCursor.getColumnIndex("selfuin"));
          localMessageRecord.frienduin = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
          localMessageRecord.senderuin = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
          localMessageRecord.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
          localMessageRecord.msgtype = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
          if (paramCursor.getInt(paramCursor.getColumnIndex("isread")) != 0)
          {
            bool = true;
            localMessageRecord.isread = bool;
            localMessageRecord.issend = paramCursor.getInt(paramCursor.getColumnIndex("issend"));
            localMessageRecord.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
            localMessageRecord.shmsgseq = paramCursor.getLong(paramCursor.getColumnIndex("shmsgseq"));
            localMessageRecord.extraflag = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
            localMessageRecord.sendFailCode = paramCursor.getInt(paramCursor.getColumnIndex("sendFailCode"));
            localMessageRecord.msgId = paramCursor.getLong(paramCursor.getColumnIndex("msgId"));
            localMessageRecord.longMsgIndex = paramCursor.getInt(paramCursor.getColumnIndex("longMsgIndex"));
            localMessageRecord.longMsgId = paramCursor.getInt(paramCursor.getColumnIndex("longMsgId"));
            localMessageRecord.longMsgCount = paramCursor.getInt(paramCursor.getColumnIndex("longMsgCount"));
            localMessageRecord.msgUid = paramCursor.getLong(paramCursor.getColumnIndex("msgUid"));
            localMessageRecord.uniseq = paramCursor.getLong(paramCursor.getColumnIndex("uniseq"));
            localMessageRecord.extInt = paramCursor.getInt(paramCursor.getColumnIndex("extInt"));
            if (paramCursor.getInt(paramCursor.getColumnIndex("isValid")) == 0) {
              break label708;
            }
            bool = true;
            localMessageRecord.isValid = bool;
            localMessageRecord.versionCode = paramCursor.getInt(paramCursor.getColumnIndex("versionCode"));
            localMessageRecord.vipBubbleID = paramCursor.getLong(paramCursor.getColumnIndex("vipBubbleID"));
            if (localMessageRecord.versionCode <= 0) {
              localMessageRecord.msg = paramCursor.getString(paramCursor.getColumnIndex("msg"));
            }
            if ((l1 != -1L) && (paramString != null)) {}
            for (localMessageRecord._status = 1001;; localMessageRecord._status = 1002)
            {
              localMessageRecord.postRead();
              return localMessageRecord;
            }
          }
        }
        else
        {
          paramClass = super.cursor2Entity(paramClass, paramString, paramCursor, null);
          return paramClass;
        }
      }
      catch (OutOfMemoryError paramClass)
      {
        return null;
      }
      catch (VerifyError paramClass)
      {
        for (;;)
        {
          return null;
          paramNoColumnErrorHandler = paramNoColumnErrorHandler;
          l1 = l2;
          continue;
          boolean bool = false;
          continue;
          label708:
          bool = false;
        }
      }
      catch (Exception paramClass) {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aybg
 * JD-Core Version:    0.7.0.1
 */