import android.database.Cursor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ayuy
{
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static MessageRecord a(Entity paramEntity)
  {
    if (paramEntity != null) {}
    try
    {
      paramEntity.postRead();
      paramEntity = (MessageRecord)paramEntity;
      return paramEntity;
    }
    catch (Exception paramEntity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Cursor2EntityConvert", 2, "postRead exception = " + paramEntity.getMessage());
      }
      return null;
    }
    catch (OutOfMemoryError paramEntity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Cursor2EntityConvert", 2, "postRead OutOfMemoryError");
        }
      }
    }
    catch (VerifyError paramEntity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Cursor2EntityConvert", 2, "postRead VerifyError");
        }
      }
    }
  }
  
  private void a(List<Field> paramList, Cursor paramCursor)
  {
    if ((paramList == null) || (paramCursor == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = ((Field)paramList.next()).getName();
        int i = paramCursor.getColumnIndex(str);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Integer.valueOf(i));
      }
    }
  }
  
  public Entity a(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor)
  {
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {}
      for (l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));; l = -1L)
      {
        try
        {
          if (paramClass.getName().equals(MessageRecord.class.getName()))
          {
            int i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
            byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
            int j = paramCursor.getInt(paramCursor.getColumnIndex("extLong"));
            String str = paramCursor.getString(paramCursor.getColumnIndex("extStr"));
            int k = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
            paramClass = bbzh.a(i, arrayOfByte, j, str, k);
            paramClass.msgData = arrayOfByte;
            paramClass._id = l;
            paramClass.extLong = j;
            paramClass.extStr = str;
            paramClass.istroop = k;
            if (!this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = true;
              a(TableBuilder.getAllField(paramClass), paramCursor);
            }
            paramClass.selfuin = paramCursor.getString(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("selfuin")).intValue());
            paramClass.frienduin = paramCursor.getString(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("frienduin")).intValue());
            paramClass.senderuin = paramCursor.getString(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("senderuin")).intValue());
            paramClass.time = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("time")).intValue());
            paramClass.msgtype = paramCursor.getInt(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("msgtype")).intValue());
            paramClass.issend = paramCursor.getInt(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("issend")).intValue());
            paramClass.msgseq = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("msgseq")).intValue());
            paramClass.shmsgseq = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("shmsgseq")).intValue());
            paramClass.msgId = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("msgId")).intValue());
            paramClass.msgUid = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("msgUid")).intValue());
            paramClass.uniseq = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("uniseq")).intValue());
            paramClass.versionCode = paramCursor.getInt(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("versionCode")).intValue());
            if (paramClass.versionCode <= 0) {
              paramClass.msg = paramCursor.getString(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("msg")).intValue());
            }
            if ((l != -1L) && (paramString != null)) {
              paramClass._status = 1001;
            } else {
              paramClass._status = 1002;
            }
          }
        }
        catch (Exception paramClass)
        {
          a();
          return null;
        }
        catch (VerifyError paramClass)
        {
          a();
          return null;
        }
        catch (OutOfMemoryError paramClass)
        {
          return null;
        }
        paramClass = null;
        break;
      }
      return paramClass;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = -1L;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayuy
 * JD-Core Version:    0.7.0.1
 */