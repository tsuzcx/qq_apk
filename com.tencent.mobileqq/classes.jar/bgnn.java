import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteDatabase;

public class bgnn
{
  public static StringBuilder a(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, SQLiteDatabase paramSQLiteDatabase, String paramString3)
  {
    Object localObject = null;
    int i = 0;
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if (paramInt1 <= 0) {
      bool1 = false;
    }
    long l = paramLong2;
    if (paramLong2 < 0L) {
      l = 9223372036854775807L;
    }
    String str;
    if (paramString3 != null)
    {
      str = paramString3;
      if (paramString3.length() != 0) {}
    }
    else
    {
      str = "";
    }
    if ((bool1) && (bool2))
    {
      paramString3 = new StringBuilder("select ");
      paramString3.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString3.append(" , time as _index from ( select * from ");
      paramString3.append(paramString2);
      paramString3.append(" where time<");
      paramString3.append(l);
      paramString3.append(str);
      paramString3.append(") order by time desc, _id desc");
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString3.toString(), null);
      if (paramSQLiteDatabase == null)
      {
        paramInt1 = i;
        if (paramInt1 < paramInt2) {
          break label233;
        }
        paramString3.append(" limit ");
        paramString3.append(paramInt2);
        paramString1 = new StringBuilder("select * from ( ");
        paramString1.append(paramString3);
        paramString1.append(") order by time desc, _id desc");
      }
    }
    label233:
    do
    {
      return paramString1;
      paramInt1 = paramSQLiteDatabase.getCount();
      paramSQLiteDatabase.close();
      break;
      paramSQLiteDatabase = new StringBuilder("select * from ( ");
      paramSQLiteDatabase.append("select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id<=( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where time<( select time from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by time asc limit 1) order by time desc limit 1) ");
      paramSQLiteDatabase.append(str);
      paramSQLiteDatabase.append("order by _id desc limit ");
      paramSQLiteDatabase.append(paramInt2 - paramInt1);
      paramSQLiteDatabase.append(") ");
      paramSQLiteDatabase.append("union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , time as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" where time<");
      paramSQLiteDatabase.append(l);
      paramSQLiteDatabase.append(str);
      paramSQLiteDatabase.append(") order by _index desc, _id desc)");
      return paramSQLiteDatabase;
      if (bool2)
      {
        paramString2 = new StringBuilder("select * from ( select ");
        paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
        paramString2.append(" , -1 as _index from ");
        paramString2.append(paramString1);
        paramString2.append(" where _id<");
        paramString2.append(paramLong1);
        paramString2.append(str);
        paramString2.append(" order by _id desc limit ");
        paramString2.append(paramInt2);
        paramString2.append(") order by _id desc");
        return paramString2;
      }
      paramString1 = localObject;
    } while (!bool1);
    paramString1 = new StringBuilder("select * from ( select ");
    paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
    paramString1.append(" , isValid, time as _index from ");
    paramString1.append(paramString2);
    paramString1.append(" where time<");
    paramString1.append(l);
    paramString1.append(str);
    paramString1.append(") order by time desc, _id desc");
    paramString1.append(" limit ");
    paramString1.append(paramInt2);
    return paramString1;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, String paramString3, int paramInt2, SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = null;
    int i = 0;
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if (paramInt1 <= 0) {
      bool1 = false;
    }
    String str;
    if (paramString3 != null)
    {
      str = paramString3;
      if (paramString3.length() != 0) {}
    }
    else
    {
      str = "";
    }
    if ((bool1) && (bool2))
    {
      paramString3 = new StringBuilder("select ");
      paramString3.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString3.append(" , shmsgseq as _index from ( select * from ");
      paramString3.append(paramString2);
      paramString3.append(" where shmsgseq<=");
      paramString3.append(paramLong2);
      paramString3.append(str);
      paramString3.append(") order by shmsgseq desc , _id desc");
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString3.toString(), null);
      if (paramSQLiteDatabase == null)
      {
        paramInt1 = i;
        if (paramInt1 < paramInt2) {
          break label224;
        }
        paramString3.append(" limit ");
        paramString3.append(paramInt2);
        paramString1 = new StringBuilder("select * from ( ");
        paramString1.append(paramString3);
        paramString1.append(") ");
        paramString1.append(" order by shmsgseq desc , _id desc");
      }
    }
    label224:
    do
    {
      return paramString1;
      paramInt1 = paramSQLiteDatabase.getCount();
      paramSQLiteDatabase.close();
      break;
      paramString3 = new StringBuilder("select * from ( select ");
      paramString3.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString3.append(" , -1 as _index from ( select * from ");
      paramString3.append(paramString1);
      paramString3.append(" where _id<=( select _id from ");
      paramString3.append(paramString1);
      paramString3.append(" where shmsgseq<( select shmsgseq from ");
      paramString3.append(paramString2);
      paramString3.append(" order by shmsgseq asc limit 1) and shmsgseq>0 order by shmsgseq desc , _id desc limit 1) ");
      paramString3.append(str);
      paramString3.append(" order by _id desc limit ");
      paramString3.append(paramInt2 - paramInt1);
      paramString3.append(") union select ");
      paramString3.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString3.append(" , shmsgseq as _index from ( select * from ");
      paramString3.append(paramString2);
      paramString3.append(" where shmsgseq<=");
      paramString3.append(paramLong2);
      paramString3.append(str);
      paramString3.append(") order by _index asc, _id asc)");
      return paramString3;
      if (bool2)
      {
        paramString2 = new StringBuilder("select * from ( select ");
        paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
        paramString2.append(" , -1 as _index from ");
        paramString2.append(paramString1);
        paramString2.append(" where _id<");
        paramString2.append(paramLong1);
        paramString2.append(str);
        paramString2.append(" order by _id desc limit ");
        paramString2.append(paramInt2);
        paramString2.append(") ");
        paramString2.append(" order by _id asc");
        return paramString2;
      }
      paramString1 = localObject;
    } while (!bool1);
    paramString1 = new StringBuilder("select * from ( select ");
    paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
    paramString1.append(" , shmsgseq as _index from ");
    paramString1.append(paramString2);
    paramString1.append(" where shmsgseq<=");
    paramString1.append(paramLong2);
    paramString1.append(str);
    paramString1.append(" order by shmsgseq desc , _id desc limit ");
    paramString1.append(paramInt2);
    paramString1.append(") ");
    paramString1.append(" order by shmsgseq asc , _id asc");
    return paramString1;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if ((bool1) && (bool2))
    {
      paramSQLiteDatabase = new StringBuilder("select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id<=( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where shmsgseq<( select shmsgseq from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by shmsgseq asc limit 1) and shmsgseq>0 order by shmsgseq desc , _id desc limit 1)) union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , shmsgseq as _index from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by _index asc, _id asc)");
      return paramSQLiteDatabase;
    }
    if (bool2)
    {
      paramString2 = new StringBuilder("select * from ( select ");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString2.append(" , -1 as _index from ");
      paramString2.append(paramString1);
      paramString2.append(" order by _id asc)");
      return paramString2;
    }
    if (bool1)
    {
      paramString1 = new StringBuilder("select * from ( select ");
      paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString1.append(" , shmsgseq as _index from ");
      paramString1.append(paramString2);
      paramString1.append(" order by shmsgseq asc , _id asc)");
      return paramString1;
    }
    return null;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, String paramString3)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if ((bool1) && (bool2))
    {
      paramSQLiteDatabase = new StringBuilder("select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id<=( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where shmsgseq<( select shmsgseq from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by shmsgseq asc limit 1)  and shmsgseq>0 order by shmsgseq desc , _id desc limit 1)) union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , shmsgseq as _index from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by _index asc, _id asc)");
      paramSQLiteDatabase.append(paramString3);
      return paramSQLiteDatabase;
    }
    if (bool2)
    {
      paramString2 = new StringBuilder("select ");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString2.append(" , -1 as _index from ");
      paramString2.append(paramString1);
      paramString2.append(paramString3);
      paramString2.append(" order by _id asc");
      return paramString2;
    }
    if (bool1)
    {
      paramString1 = new StringBuilder("select ");
      paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString1.append(" , shmsgseq as _index from ");
      paramString1.append(paramString2);
      paramString1.append(paramString3);
      paramString1.append(" order by shmsgseq asc");
      return paramString1;
    }
    return null;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, String paramString3, String paramString4)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if ((bool1) && (bool2))
    {
      paramSQLiteDatabase = new StringBuilder("select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id <= ( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where time < ( select time from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by time asc limit 1 ) order by time desc limit 1 ) ) union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , time as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by time asc )  order by _index ) ");
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        paramSQLiteDatabase.append(" where ");
        paramSQLiteDatabase.append(paramString3);
      }
      paramString1 = paramSQLiteDatabase;
      if (paramString4 != null)
      {
        paramString1 = paramSQLiteDatabase;
        if (paramString4.length() > 0)
        {
          paramSQLiteDatabase.append(" order by ");
          paramSQLiteDatabase.append(paramString4);
          paramString1 = paramSQLiteDatabase;
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramString1;
            if (!bool2) {
              break;
            }
            paramString2 = new StringBuilder("select t.");
            paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
            paramString2.append(" , -1 as _index from ");
            paramString2.append(paramString1);
            paramString2.append(" t");
            if ((paramString3 != null) && (paramString3.length() > 0))
            {
              paramString2.append(" where ");
              paramString2.append(paramString3);
            }
            paramString2.append(" order by _id asc");
            paramString1 = paramString2;
          } while (paramString4 == null);
          paramString1 = paramString2;
        } while (paramString4.length() <= 0);
        paramString2.append(",");
        paramString2.append(paramString4);
        return paramString2;
        if (!bool1) {
          break;
        }
        paramSQLiteDatabase = new StringBuilder("select t.");
        paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
        paramSQLiteDatabase.append(" , time as _index from ");
        paramSQLiteDatabase.append(paramString2);
        paramSQLiteDatabase.append(" t");
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          paramSQLiteDatabase.append(" where ");
          paramSQLiteDatabase.append(paramString3);
        }
        paramString1 = paramSQLiteDatabase;
      } while (paramString4 == null);
      paramString1 = paramSQLiteDatabase;
    } while (paramString4.length() <= 0);
    paramSQLiteDatabase.append(",");
    paramSQLiteDatabase.append(paramString4);
    return paramSQLiteDatabase;
    return null;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, String paramString3, String paramString4, String paramString5)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if ((bool1) && (bool2))
    {
      paramSQLiteDatabase = new StringBuilder("select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id <= ( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where time < ( select time from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by time asc limit 1 ) order by time desc limit 1 ) ) union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , time as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by time asc )  order by _index ) ");
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        paramSQLiteDatabase.append(paramString3);
      }
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        paramSQLiteDatabase.append(" where ");
        paramSQLiteDatabase.append(paramString4);
      }
      paramString1 = paramSQLiteDatabase;
      if (paramString5 != null)
      {
        paramString1 = paramSQLiteDatabase;
        if (paramString5.length() > 0)
        {
          paramSQLiteDatabase.append(" order by ");
          paramSQLiteDatabase.append(paramString5);
          paramString1 = paramSQLiteDatabase;
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramString1;
            if (!bool2) {
              break;
            }
            paramString2 = new StringBuilder("select ");
            paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
            paramString2.append(" , 1 as isValid, -1 as _index from ");
            paramString2.append(paramString1);
            if ((paramString3 != null) && (paramString3.length() > 0)) {
              paramString2.append(paramString3);
            }
            if ((paramString4 != null) && (paramString4.length() > 0))
            {
              paramString2.append(" where ");
              paramString2.append(paramString4);
            }
            paramString2.append(" order by _id asc");
            paramString1 = paramString2;
          } while (paramString5 == null);
          paramString1 = paramString2;
        } while (paramString5.length() <= 0);
        paramString2.append(",");
        paramString2.append(paramString5);
        return paramString2;
        if (!bool1) {
          break;
        }
        paramSQLiteDatabase = new StringBuilder("select ");
        paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
        paramSQLiteDatabase.append(" , time as _index from ");
        paramSQLiteDatabase.append(paramString2);
        if ((paramString3 != null) && (paramString3.length() > 0)) {
          paramSQLiteDatabase.append(paramString3);
        }
        if ((paramString4 != null) && (paramString4.length() > 0))
        {
          paramSQLiteDatabase.append(" where ");
          paramSQLiteDatabase.append(paramString4);
        }
        paramSQLiteDatabase.append(" order by time asc");
        paramString1 = paramSQLiteDatabase;
      } while (paramString5 == null);
      paramString1 = paramSQLiteDatabase;
    } while (paramString5.length() <= 0);
    paramSQLiteDatabase.append(",");
    paramSQLiteDatabase.append(paramString5);
    return paramSQLiteDatabase;
    return null;
  }
  
  public static boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramString == null) {}
    for (;;)
    {
      return bool2;
      if ("Sqlite_master".equalsIgnoreCase(paramString)) {
        return true;
      }
      String str = null;
      try
      {
        paramString = paramSQLiteDatabase.rawQuery("select count(*) as c from Sqlite_master  where type ='table' and name =? ", new String[] { paramString.trim() });
        bool1 = bool3;
        str = paramString;
      }
      catch (Exception paramString)
      {
        boolean bool1;
        int i;
        paramString = paramString;
        paramString = null;
        return false;
      }
      finally
      {
        if (str != null) {
          str.close();
        }
      }
    }
  }
  
  public static StringBuilder b(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, String paramString3)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if ((bool1) && (bool2))
    {
      paramSQLiteDatabase = new StringBuilder("select * from ( select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id<=( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where shmsgseq<( select shmsgseq from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by shmsgseq asc limit 1)  and shmsgseq>0 order by shmsgseq desc , _id desc limit 1)) union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , shmsgseq as _index from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by _index asc, _id asc)");
      paramSQLiteDatabase.append(paramString3);
      paramSQLiteDatabase.append(" )");
      return paramSQLiteDatabase;
    }
    if (bool2)
    {
      paramString2 = new StringBuilder("select * from ( select * from ( select ");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString2.append(" , -1 as _index from ");
      paramString2.append(paramString1);
      paramString2.append(" order by _id asc)");
      paramString2.append(paramString3);
      paramString2.append(" )");
      return paramString2;
    }
    if (bool1)
    {
      paramString1 = new StringBuilder("select * from ( select ");
      paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString1.append(" , shmsgseq as _index from ");
      paramString1.append(paramString2);
      paramString1.append(paramString3);
      paramString1.append(" )");
      return paramString1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnn
 * JD-Core Version:    0.7.0.1
 */