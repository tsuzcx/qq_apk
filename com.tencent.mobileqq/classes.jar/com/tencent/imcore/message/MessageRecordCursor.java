package com.tencent.imcore.message;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class MessageRecordCursor
  implements Cursor
{
  public static MessageRecordCursor.Callback a;
  private int jdField_a_of_type_Int = -1;
  private MsgProxy jdField_a_of_type_ComTencentImcoreMessageMsgProxy;
  private List<MessageRecord> jdField_a_of_type_JavaUtilList;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "_id", "selfuin", "frienduin", "senderuin", "time", "msg", "msgtype", "isread", "issend", "msgseq", "shmsgseq", "istroop", "extraflag", "troopnick", "friendnick", "versionCode", "msgData", "vipBubbleID", "msgUid", "uniseq", "sendFailCode", "versionCode" };
  
  static
  {
    InitMsgModule.a();
    jdField_a_of_type_ComTencentImcoreMessageMessageRecordCursor$Callback = new MessageRecordCursor.1();
  }
  
  protected MessageRecordCursor(MsgProxy paramMsgProxy, List<MessageRecord> paramList)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageMsgProxy = paramMsgProxy;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private Object a(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(MessageRecordCursor.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentImcoreMessageMessageRecordCursor$Callback = paramCallback;
  }
  
  public void close() {}
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void deactivate() {}
  
  public byte[] getBlob(int paramInt)
  {
    Object localObject = a(paramInt);
    if ((localObject instanceof byte[])) {
      return (byte[])localObject;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      arrayOfByte1 = arrayOfByte2;
      localObjectOutputStream.writeObject(localObject);
      arrayOfByte1 = arrayOfByte2;
      localObjectOutputStream.flush();
      arrayOfByte1 = arrayOfByte2;
      arrayOfByte2 = localByteArrayOutputStream.toByteArray();
      arrayOfByte1 = arrayOfByte2;
      localObjectOutputStream.close();
      arrayOfByte1 = arrayOfByte2;
      localByteArrayOutputStream.close();
      return arrayOfByte2;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return arrayOfByte1;
  }
  
  public int getColumnCount()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString.length;
  }
  
  public int getColumnIndex(String paramString)
  {
    if ("_id".equalsIgnoreCase(paramString)) {
      return 1;
    }
    if ("selfuin".equals(paramString)) {
      return 2;
    }
    if ("frienduin".equals(paramString)) {
      return 3;
    }
    if ("senderuin".equals(paramString)) {
      return 4;
    }
    if ("time".equals(paramString)) {
      return 5;
    }
    if ("msg".equals(paramString)) {
      return 6;
    }
    if ("msgtype".equals(paramString)) {
      return 7;
    }
    if ("isread".equals(paramString)) {
      return 8;
    }
    if ("issend".equals(paramString)) {
      return 9;
    }
    if ("msgseq".equals(paramString)) {
      return 10;
    }
    if ("shmsgseq".equals(paramString)) {
      return 11;
    }
    if ("istroop".equals(paramString)) {
      return 12;
    }
    if ("extraflag".equals(paramString)) {
      return 13;
    }
    if ("troopnick".equals(paramString)) {
      return 14;
    }
    if ("friendnick".equals(paramString)) {
      return 15;
    }
    if ("friendstatus".equals(paramString)) {
      return 16;
    }
    if ("versionCode".equals(paramString)) {
      return 17;
    }
    if ("msgData".equals(paramString)) {
      return 18;
    }
    if ("vipBubbleID".equals(paramString)) {
      return 19;
    }
    if ("msgUid".equals(paramString)) {
      return 20;
    }
    if ("uniseq".equals(paramString)) {
      return 21;
    }
    if ("sendFailCode".equals(paramString)) {
      return 22;
    }
    if ("versionCode".equals(paramString)) {
      return 23;
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    if (getColumnIndex(paramString) >= 0) {
      return getColumnIndex(paramString);
    }
    throw new IllegalArgumentException();
  }
  
  public String getColumnName(int paramInt)
  {
    if (paramInt > 0)
    {
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (paramInt < arrayOfString.length) {
        return arrayOfString[paramInt];
      }
    }
    return null;
  }
  
  public String[] getColumnNames()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public double getDouble(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public Bundle getExtras()
  {
    throw new UnsupportedOperationException();
  }
  
  public float getFloat(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public int getInt(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return 0;
    }
    return ((Integer)localObject).intValue();
  }
  
  public long getLong(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return 0L;
    }
    return ((Long)localObject).longValue();
  }
  
  public Uri getNotificationUri()
  {
    throw new UnsupportedOperationException();
  }
  
  public int getPosition()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public short getShort(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return 0;
    }
    return ((Short)localObject).shortValue();
  }
  
  public String getString(int paramInt)
  {
    return String.valueOf(a(paramInt));
  }
  
  public int getType(int paramInt)
  {
    return 0;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isAfterLast()
  {
    if (getCount() == 0) {
      return true;
    }
    return this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public boolean isBeforeFirst()
  {
    return this.jdField_a_of_type_Int < 0;
  }
  
  public boolean isClosed()
  {
    return false;
  }
  
  public boolean isFirst()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public boolean isLast()
  {
    return this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size() - 1;
  }
  
  public boolean isNull(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean move(int paramInt)
  {
    if (this.jdField_a_of_type_Int + paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      int i = this.jdField_a_of_type_Int;
      if (i + paramInt >= 0)
      {
        this.jdField_a_of_type_Int = (i + paramInt);
        return true;
      }
    }
    return false;
  }
  
  public boolean moveToFirst()
  {
    boolean bool = false;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean moveToLast()
  {
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
    return true;
  }
  
  public boolean moveToNext()
  {
    if (this.jdField_a_of_type_Int <= this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      this.jdField_a_of_type_Int += 1;
      return true;
    }
    return false;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt >= 0))
    {
      this.jdField_a_of_type_Int = paramInt;
      return true;
    }
    return false;
  }
  
  public boolean moveToPrevious()
  {
    int i = this.jdField_a_of_type_Int;
    if (i > 0)
    {
      this.jdField_a_of_type_Int = (i - 1);
      return true;
    }
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public boolean requery()
  {
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setExtras(Bundle paramBundle) {}
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.MessageRecordCursor
 * JD-Core Version:    0.7.0.1
 */