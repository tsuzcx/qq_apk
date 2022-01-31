import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavUtil.1;
import cooperation.qqfav.QfavUtil.2;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class birl
{
  private static final Map<String, List<Field>> a = new HashMap();
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 1: 
      return 2;
    case 3000: 
      return 3;
    }
    return 5;
  }
  
  public static long a(List<byte[]> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1L;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      long l = a((byte[])paramList.next());
      if (l > 0L) {
        return l;
      }
    }
    return -1L;
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 16)) {}
    while (a(paramArrayOfByte, 8) != 5L) {
      return -1L;
    }
    return a(paramArrayOfByte, 16);
  }
  
  private static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l = l << 8 | paramArrayOfByte[(i + paramInt)] & 0xFF;
      i += 1;
    }
    return l;
  }
  
  static ContentValues a(awbv paramawbv, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = a(paramawbv).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Field)localIterator.next();
      String str = paramString + ((Field)localObject1).getName();
      if (!((Field)localObject1).isAccessible()) {
        ((Field)localObject1).setAccessible(true);
      }
      Object localObject3;
      try
      {
        localObject1 = ((Field)localObject1).get(paramawbv);
        if ((localObject1 instanceof awbv)) {
          localContentValues.putAll(a((awbv)localObject1, str + "."));
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
          Object localObject2 = null;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
          localObject3 = null;
        }
        if ((localObject3 instanceof Integer))
        {
          localContentValues.put(str, (Integer)localObject3);
          continue;
        }
        if ((localObject3 instanceof Long))
        {
          localContentValues.put(str, (Long)localObject3);
          continue;
        }
        if ((localObject3 instanceof String))
        {
          localContentValues.put(str, (String)localObject3);
          continue;
        }
        if ((localObject3 instanceof byte[]))
        {
          localContentValues.put(str, (byte[])localObject3);
          continue;
        }
        if ((localObject3 instanceof Short))
        {
          localContentValues.put(str, (Short)localObject3);
          continue;
        }
        if ((localObject3 instanceof Boolean))
        {
          localContentValues.put(str, (Boolean)localObject3);
          continue;
        }
        if ((localObject3 instanceof Double))
        {
          localContentValues.put(str, (Double)localObject3);
          continue;
        }
        if ((localObject3 instanceof Float))
        {
          localContentValues.put(str, (Float)localObject3);
          continue;
        }
        if ((localObject3 instanceof Byte))
        {
          localContentValues.put(str, (Byte)localObject3);
          continue;
        }
        if ((localObject3 instanceof Boolean)) {
          localContentValues.put(str, (Boolean)localObject3);
        }
      }
      if ((localObject3 instanceof List)) {
        try
        {
          localContentValues.putAll(a((List)localObject3, str + "."));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return localContentValues;
  }
  
  private static ContentValues a(List<awbv> paramList, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    if ((paramList != null) && (paramList.size() > 0))
    {
      localContentValues.put(paramString + "n", Integer.valueOf(paramList.size()));
      int i = 0;
      while (i < paramList.size())
      {
        localContentValues.put(paramString + i + ".-", ((awbv)paramList.get(i)).getClass().getName());
        localContentValues.putAll(a((awbv)paramList.get(i), paramString + i + "."));
        i += 1;
      }
    }
    return localContentValues;
  }
  
  public static ContentValues a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 16)) {}
    do
    {
      return null;
      if (a(paramArrayOfByte, 8) == 3L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("qqfav", 2, "unParcelStructMsg, is not structMsg");
    return null;
    return a(paramArrayOfByte, 16, paramArrayOfByte.length - 16);
  }
  
  public static ContentValues a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, paramInt1, paramInt2);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (ContentValues)ContentValues.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public static awbv a(ContentValues paramContentValues, String paramString)
  {
    return a(paramContentValues, paramString, "");
  }
  
  private static awbv a(ContentValues paramContentValues, String paramString1, String paramString2)
  {
    try
    {
      awbv localawbv = (awbv)Class.forName(paramString1).newInstance();
      paramString1 = localawbv;
      if (localawbv != null)
      {
        paramString1 = a(localawbv).iterator();
        while (paramString1.hasNext())
        {
          Field localField = (Field)paramString1.next();
          Object localObject1 = paramString2 + localField.getName();
          Object localObject2 = localField.getType();
          if (awbv.class.isAssignableFrom((Class)localObject2))
          {
            localObject1 = a(paramContentValues, ((Class)localObject2).getName(), (String)localObject1 + ".");
            localawbv.setStatus(1002);
            localField.set(localawbv, localObject1);
          }
          else if (localObject2 == List.class)
          {
            int j = paramContentValues.getAsInteger((String)localObject1 + ".n").intValue();
            localObject2 = new ArrayList();
            int i = 0;
            while (i < j)
            {
              ((ArrayList)localObject2).add(a(paramContentValues, paramContentValues.getAsString((String)localObject1 + "." + i + ".-"), (String)localObject1 + "." + i + "."));
              i += 1;
            }
            localField.set(localawbv, localObject2);
          }
          else if (localObject2 == Long.TYPE)
          {
            localField.set(localawbv, paramContentValues.getAsLong((String)localObject1));
          }
          else if (localObject2 == Integer.TYPE)
          {
            localField.set(localawbv, paramContentValues.getAsInteger((String)localObject1));
          }
          else if (localObject2 == String.class)
          {
            localField.set(localawbv, paramContentValues.getAsString((String)localObject1));
          }
          else if (localObject2 == Byte.TYPE)
          {
            localField.set(localawbv, paramContentValues.getAsByte((String)localObject1));
          }
          else if (localObject2 == [B.class)
          {
            localField.set(localawbv, paramContentValues.getAsByteArray((String)localObject1));
          }
          else if (localObject2 == Short.TYPE)
          {
            localField.set(localawbv, paramContentValues.getAsShort((String)localObject1));
          }
          else if (localObject2 == Boolean.TYPE)
          {
            localField.set(localawbv, paramContentValues.getAsBoolean((String)localObject1));
          }
          else if (localObject2 == Float.TYPE)
          {
            localField.set(localawbv, paramContentValues.getAsFloat((String)localObject1));
          }
          else if (localObject2 == Double.TYPE)
          {
            localField.set(localawbv, paramContentValues.getAsDouble((String)localObject1));
          }
        }
        if (localawbv.getId() != -1L)
        {
          localawbv.setStatus(1001);
          return localawbv;
        }
        localawbv.setStatus(1002);
        return localawbv;
      }
    }
    catch (Exception paramContentValues)
    {
      paramString1 = null;
    }
    return paramString1;
  }
  
  public static azsp a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare.getItemCount() > 0)
    {
      paramStructMsgForImageShare = paramStructMsgForImageShare.getItemByIndex(0);
      if ((paramStructMsgForImageShare instanceof azui))
      {
        paramStructMsgForImageShare = (azui)paramStructMsgForImageShare;
        if ((paramStructMsgForImageShare.a.size() > 0) && ((paramStructMsgForImageShare.a.get(0) instanceof azsp))) {
          return (azsp)paramStructMsgForImageShare.a.get(0);
        }
      }
    }
    return null;
  }
  
  public static birg a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 16)) {
      return null;
    }
    if (a(paramArrayOfByte, 8) != 1L) {
      return null;
    }
    Object localObject2 = Parcel.obtain();
    ((Parcel)localObject2).unmarshall(paramArrayOfByte, 16, paramArrayOfByte.length - 16);
    ((Parcel)localObject2).setDataPosition(0);
    Object localObject1 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)localObject2);
    ((Parcel)localObject2).recycle();
    paramArrayOfByte = ((Bundle)localObject1).getString("entityNickName");
    localObject2 = ((Bundle)localObject1).getString("sEntityClassName");
    localObject2 = a((ContentValues)((Bundle)localObject1).getParcelable("cvEntityContents"), (String)localObject2);
    if ((localObject2 instanceof ChatMessage))
    {
      if ((localObject2 instanceof MessageForStructing))
      {
        localObject1 = ((Bundle)localObject1).getByteArray("sEntityData");
        if (localObject1 != null)
        {
          localObject1 = azqu.a((byte[])localObject1);
          ((MessageForStructing)localObject2).structingMsg = ((AbsStructMsg)localObject1);
        }
        return new birg((ChatMessage)localObject2, paramArrayOfByte);
      }
      return new birg((ChatMessage)localObject2, paramArrayOfByte);
    }
    return null;
  }
  
  public static AbsStructMsg a(List<byte[]> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AbsStructMsg localAbsStructMsg = a((byte[])paramList.next());
      if (localAbsStructMsg != null) {
        return localAbsStructMsg;
      }
    }
    return null;
  }
  
  public static AbsStructMsg a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 16)) {}
    do
    {
      return null;
      if (a(paramArrayOfByte, 8) == 2L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("qqfav", 2, "unParcelStructMsg, is not structMsg");
    return null;
    byte[] arrayOfByte = new byte[paramArrayOfByte.length - 16];
    System.arraycopy(paramArrayOfByte, 16, arrayOfByte, 0, paramArrayOfByte.length - 16);
    return azqu.a(arrayOfByte);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  private static String a(Node paramNode)
  {
    if (paramNode.getNodeType() == 3) {}
    Object localObject;
    for (paramNode = paramNode.getNodeValue();; paramNode = ((StringBuilder)localObject).toString())
    {
      localObject = paramNode;
      if (paramNode == null) {
        localObject = "";
      }
      return localObject;
      localObject = new StringBuilder();
      int j = paramNode.getChildNodes().getLength();
      int i = 0;
      if (i < j)
      {
        Node localNode = paramNode.getChildNodes().item(i);
        if (localNode == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localNode.getNodeType() == 3) {
            ((StringBuilder)localObject).append(localNode.getNodeValue());
          }
        }
      }
    }
  }
  
  private static List<Field> a(awbv paramawbv)
  {
    Class localClass = paramawbv.getClass();
    Object localObject1 = (List)a.get(localClass);
    paramawbv = (awbv)localObject1;
    if (localObject1 == null)
    {
      paramawbv = new ArrayList();
      localObject1 = localClass.getFields();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!Modifier.isStatic(localObject2.getModifiers())) {
          paramawbv.add(localObject2);
        }
        i += 1;
      }
      a.put(localClass.getName(), paramawbv);
    }
    return paramawbv;
  }
  
  public static List<birf> a(List<byte[]> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (byte[])paramList.next();
      long l1 = a((byte[])localObject, 8);
      if (l1 != 2L)
      {
        long l2;
        if (l1 == 1L)
        {
          l2 = a((byte[])localObject, 0);
          localObject = a((byte[])localObject);
          if (localObject != null) {
            localArrayList.add(new birf(l2, l1, ((birg)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage, ((birg)localObject).jdField_a_of_type_JavaLangString));
          } else if (QLog.isColorLevel()) {
            QLog.i("qqfav", 2, "unparcelMergeMsg is null");
          }
        }
        else if (l1 == 3L)
        {
          l2 = a((byte[])localObject, 0);
          localObject = a((byte[])localObject);
          if (localObject != null) {
            localArrayList.add(new birf(l2, l1, (ContentValues)localObject));
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static Map<String, String> a(List<byte[]> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Map localMap = a((byte[])paramList.next());
      if (localMap != null) {
        return localMap;
      }
    }
    return null;
  }
  
  public static Map<String, String> a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 16)) {
      return null;
    }
    if (a(paramArrayOfByte, 8) != 4L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "unParcelStructMsg, is not structMsg");
      }
      return null;
    }
    Object localObject = Parcel.obtain();
    ((Parcel)localObject).unmarshall(paramArrayOfByte, 16, paramArrayOfByte.length - 16);
    ((Parcel)localObject).setDataPosition(0);
    paramArrayOfByte = (ContentValues)ContentValues.CREATOR.createFromParcel((Parcel)localObject);
    ((Parcel)localObject).recycle();
    if (paramArrayOfByte == null) {
      return null;
    }
    localObject = new HashMap();
    Iterator localIterator = paramArrayOfByte.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Map)localObject).put(str, paramArrayOfByte.getAsString(str));
    }
    return localObject;
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqfav", 2, "dumpFileInfo，cloudtype:" + paramInt1 + " bid:" + paramInt2 + " uuid：" + paramString1 + " troopfilepath:" + paramString2 + " name:" + paramString5 + " size:" + paramLong + " md5:" + paramString6 + " path:" + paramString7);
    }
  }
  
  public static void a(long paramLong, List<birf> paramList1, List<birf> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {}
    for (;;)
    {
      return;
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        birf localbirf = (birf)paramList1.next();
        if (localbirf.b == paramLong) {
          paramList2.add(localbirf);
        }
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast localQQToast = QQToast.a(paramContext, paramInt2, paramInt1, 2000);
    paramInt1 = paramContext.getResources().getDimensionPixelSize(2131298914) - (int)bdcq.a(paramContext, 5.0F);
    paramContext = Looper.getMainLooper();
    if (Thread.currentThread() != paramContext.getThread())
    {
      new Handler(paramContext).post(new QfavUtil.1(localQQToast, paramInt1));
      return;
    }
    localQQToast.b(paramInt1);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramString = QQToast.a(paramContext, paramInt, paramString, 2000);
    paramInt = paramContext.getResources().getDimensionPixelSize(2131298914) - (int)bdcq.a(paramContext, 5.0F);
    paramContext = Looper.getMainLooper();
    if (Thread.currentThread() != paramContext.getThread())
    {
      new Handler(paramContext).post(new QfavUtil.2(paramString, paramInt));
      return;
    }
    paramString.b(paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, List<ChatMessage> paramList, Map<String, String> paramMap, ArrayList<byte[]> paramArrayList)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      label18:
      if (paramList == null) {
        break label159;
      }
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if (paramMap == null) {
          break label161;
        }
        paramList = (String)paramMap.get(abot.c(localChatMessage));
        paramArrayList.add(a(paramQQAppInterface, paramMessageForStructing.uniseq, localChatMessage, paramList));
        if (!a(localChatMessage)) {
          continue;
        }
        a(paramQQAppInterface, (MessageForStructing)localChatMessage, null, null, paramArrayList);
        continue;
        paramList = aukx.a().a(paramQQAppInterface, paramMessageForStructing.uniseq);
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        QLog.e("qqfav", 2, "parcelMergeMsg exception:" + paramQQAppInterface);
        return;
      }
      paramMap = null;
      break label18;
      label159:
      break;
      label161:
      paramList = null;
    }
  }
  
  private static void a(MessageForFile paramMessageForFile)
  {
    if (paramMessageForFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "dumpFileInfo， messageforfile is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqfav", 2, "dumpFileInfo， MessageForFile:");
    }
    a(paramMessageForFile.fileName, paramMessageForFile.filePath, paramMessageForFile.fileSize, paramMessageForFile.extStr);
  }
  
  private static void a(MessageForTroopFile paramMessageForTroopFile)
  {
    if (paramMessageForTroopFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "dumpFileInfo， messageforfile is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqfav", 2, "dumpFileInfo， MessageForTroopFile:");
    }
    a(paramMessageForTroopFile.fileName, paramMessageForTroopFile.uuid, paramMessageForTroopFile.fileSize, paramMessageForTroopFile.extStr);
  }
  
  private static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "dumpFileInfo， entity is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqfav", 2, "dumpFileInfo， entity");
    }
    a(arni.a(paramFileManagerEntity), paramFileManagerEntity.busId, paramFileManagerEntity.Uuid, paramFileManagerEntity.strTroopFilePath, paramFileManagerEntity.WeiYunDirKey, paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.strFileMd5, paramFileManagerEntity.getFilePath());
  }
  
  public static void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("mobileQQ", i);
      String str = "qfav_click_red_point_" + paramString;
      if (!((SharedPreferences)localObject).getBoolean(str, false)) {
        ((SharedPreferences)localObject).edit().putBoolean(str, true).commit();
      }
      paramString = "favorites_entry_red_point_" + paramString;
      if (!((SharedPreferences)localObject).getBoolean(paramString, false)) {
        ((SharedPreferences)localObject).edit().putBoolean(paramString, true).commit();
      }
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqfav", 2, "dumpFileInfo， name:" + paramString1 + " size:" + paramLong + " strExtInfo:" + paramString3 + " path or uuid:" + paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("QfavEdit", i);
      if (localObject != null)
      {
        boolean bool = ((SharedPreferences)localObject).edit().putBoolean(BaseApplicationImpl.sApplication.getRuntime().getAccount() + "QfavEdit", paramBoolean).commit();
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "setEditFlag:" + paramBoolean + ",suc:" + bool);
        }
      }
      return;
    }
  }
  
  public static boolean a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("QfavEdit", i);
      if (localObject == null) {
        break;
      }
      return ((SharedPreferences)localObject).getBoolean(BaseApplicationImpl.sApplication.getRuntime().getAccount() + "QfavEdit", false);
    }
    return true;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (!bdag.a())
    {
      a(paramActivity, 2131694073, 1);
      return false;
    }
    if (bdag.a() < 500L)
    {
      a(paramActivity, 2131694072, 1);
      return false;
    }
    return true;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    return ((paramChatMessage instanceof MessageForStructing)) && (((MessageForStructing)paramChatMessage).structingMsg != null) && (((MessageForStructing)paramChatMessage).structingMsg.mMsgServiceID == 35);
  }
  
  public static boolean a(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0) {
      return localBaseApplicationImpl.getSharedPreferences("mobileQQ", i).getBoolean("qfav_unsupport_msg_dialog_flag_" + paramString, false);
    }
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramString != null)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = new File(paramString).length();
      }
    }
    return (paramString != null) && (l > 10485760L);
  }
  
  private static byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >> 64 - (i + 1) * 8 & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong1, long paramLong2)
  {
    return a(paramLong1, 5L, a(paramLong2));
  }
  
  private static byte[] a(long paramLong1, long paramLong2, Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      return a(paramLong1, paramLong2, (byte[])null);
    }
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return a(paramLong1, paramLong2, paramParcelable);
  }
  
  private static byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    int i;
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length == 0) {
        i = 16;
      }
    }
    for (;;)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(a(paramLong1), 0, arrayOfByte, 0, 8);
      System.arraycopy(a(paramLong2), 0, arrayOfByte, 8, 8);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 16, paramArrayOfByte.length);
      }
      return arrayOfByte;
      i = paramArrayOfByte.length + 16;
      continue;
      i = 16;
    }
  }
  
  public static byte[] a(long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg == null) {
      return null;
    }
    return a(paramLong, 2L, paramAbsStructMsg.getBytes());
  }
  
  public static byte[] a(long paramLong, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    ContentValues localContentValues = new ContentValues();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localContentValues.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return a(paramLong, 4L, localContentValues);
  }
  
  public static byte[] a(ContentValues paramContentValues)
  {
    if (paramContentValues == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    paramContentValues.writeToParcel(localParcel, 0);
    paramContentValues = localParcel.marshall();
    localParcel.recycle();
    return paramContentValues;
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, long paramLong, ChatMessage paramChatMessage, String paramString)
  {
    if (paramChatMessage == null) {
      return null;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = afar.a(paramQQAppInterface, paramChatMessage);
    }
    if (((paramChatMessage instanceof MessageForFile)) || ((paramChatMessage instanceof MessageForTroopFile))) {
      return b(paramQQAppInterface, paramLong, paramChatMessage, str);
    }
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putParcelable("cvEntityContents", a(paramChatMessage, ""));
    paramQQAppInterface.putString("sEntityClassName", paramChatMessage.getClass().getName());
    paramQQAppInterface.putString("entityNickName", str);
    if (((paramChatMessage instanceof MessageForStructing)) && (((MessageForStructing)paramChatMessage).structingMsg != null)) {
      paramQQAppInterface.putByteArray("sEntityData", ((MessageForStructing)paramChatMessage).structingMsg.getBytes());
    }
    return a(paramLong, 1L, paramQQAppInterface);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    int i;
    byte[] arrayOfByte;
    do
    {
      return paramArrayOfByte;
      i = paramArrayOfByte[0];
      arrayOfByte = new byte[paramArrayOfByte.length - 1];
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, arrayOfByte.length);
      paramArrayOfByte = arrayOfByte;
    } while (i != 1);
    return azsd.a(arrayOfByte);
  }
  
  /* Error */
  public static String[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 847	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   6: astore 5
    //   8: aload 5
    //   10: invokevirtual 851	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   13: new 853	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 856	java/io/ByteArrayInputStream:<init>	([B)V
    //   21: invokevirtual 862	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   24: invokeinterface 868 1 0
    //   29: astore 5
    //   31: aload 4
    //   33: astore_0
    //   34: aconst_null
    //   35: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +14 -> 52
    //   41: aload 5
    //   43: ldc_w 870
    //   46: invokeinterface 875 2 0
    //   51: astore_0
    //   52: aload 5
    //   54: invokeinterface 876 1 0
    //   59: astore 26
    //   61: aload 26
    //   63: invokeinterface 410 1 0
    //   68: istore_3
    //   69: iconst_0
    //   70: istore_1
    //   71: aconst_null
    //   72: astore 4
    //   74: aconst_null
    //   75: astore 5
    //   77: aconst_null
    //   78: astore 6
    //   80: aconst_null
    //   81: astore 8
    //   83: aconst_null
    //   84: astore 7
    //   86: iload_1
    //   87: iload_3
    //   88: if_icmpge +1688 -> 1776
    //   91: aload 4
    //   93: astore 16
    //   95: aload 5
    //   97: astore 10
    //   99: aload 6
    //   101: astore 13
    //   103: aload 7
    //   105: astore 19
    //   107: aload 4
    //   109: astore 17
    //   111: aload 5
    //   113: astore 11
    //   115: aload 6
    //   117: astore 14
    //   119: aload 7
    //   121: astore 20
    //   123: aload 4
    //   125: astore 18
    //   127: aload 5
    //   129: astore 12
    //   131: aload 6
    //   133: astore 15
    //   135: aload 7
    //   137: astore 21
    //   139: aload 26
    //   141: iload_1
    //   142: invokeinterface 414 2 0
    //   147: astore 27
    //   149: aload 4
    //   151: astore 16
    //   153: aload 5
    //   155: astore 10
    //   157: aload 6
    //   159: astore 13
    //   161: aload 7
    //   163: astore 19
    //   165: aload 4
    //   167: astore 17
    //   169: aload 5
    //   171: astore 11
    //   173: aload 6
    //   175: astore 14
    //   177: aload 7
    //   179: astore 20
    //   181: aload 4
    //   183: astore 18
    //   185: aload 5
    //   187: astore 12
    //   189: aload 6
    //   191: astore 15
    //   193: aload 7
    //   195: astore 21
    //   197: aload 27
    //   199: invokeinterface 879 1 0
    //   204: astore 28
    //   206: aload 4
    //   208: astore 16
    //   210: aload 5
    //   212: astore 10
    //   214: aload 6
    //   216: astore 13
    //   218: aload 7
    //   220: astore 19
    //   222: aload 4
    //   224: astore 17
    //   226: aload 5
    //   228: astore 11
    //   230: aload 6
    //   232: astore 14
    //   234: aload 7
    //   236: astore 20
    //   238: aload 4
    //   240: astore 18
    //   242: aload 5
    //   244: astore 12
    //   246: aload 6
    //   248: astore 15
    //   250: aload 7
    //   252: astore 21
    //   254: aload 28
    //   256: ldc_w 880
    //   259: invokevirtual 883	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifeq +1246 -> 1508
    //   265: aload 4
    //   267: astore 16
    //   269: aload 5
    //   271: astore 10
    //   273: aload 6
    //   275: astore 13
    //   277: aload 7
    //   279: astore 19
    //   281: aload 4
    //   283: astore 17
    //   285: aload 5
    //   287: astore 11
    //   289: aload 6
    //   291: astore 14
    //   293: aload 7
    //   295: astore 20
    //   297: aload 4
    //   299: astore 18
    //   301: aload 5
    //   303: astore 12
    //   305: aload 6
    //   307: astore 15
    //   309: aload 7
    //   311: astore 21
    //   313: aload 27
    //   315: invokeinterface 405 1 0
    //   320: astore 27
    //   322: iconst_0
    //   323: istore_2
    //   324: aload 4
    //   326: astore 22
    //   328: aload 5
    //   330: astore 23
    //   332: aload 6
    //   334: astore 24
    //   336: aload 8
    //   338: astore 25
    //   340: aload 7
    //   342: astore 9
    //   344: aload 4
    //   346: astore 16
    //   348: aload 5
    //   350: astore 10
    //   352: aload 6
    //   354: astore 13
    //   356: aload 7
    //   358: astore 19
    //   360: aload 4
    //   362: astore 17
    //   364: aload 5
    //   366: astore 11
    //   368: aload 6
    //   370: astore 14
    //   372: aload 7
    //   374: astore 20
    //   376: aload 4
    //   378: astore 18
    //   380: aload 5
    //   382: astore 12
    //   384: aload 6
    //   386: astore 15
    //   388: aload 7
    //   390: astore 21
    //   392: iload_2
    //   393: aload 27
    //   395: invokeinterface 410 1 0
    //   400: if_icmpge +1349 -> 1749
    //   403: aload 4
    //   405: astore 16
    //   407: aload 5
    //   409: astore 10
    //   411: aload 6
    //   413: astore 13
    //   415: aload 7
    //   417: astore 19
    //   419: aload 4
    //   421: astore 17
    //   423: aload 5
    //   425: astore 11
    //   427: aload 6
    //   429: astore 14
    //   431: aload 7
    //   433: astore 20
    //   435: aload 4
    //   437: astore 18
    //   439: aload 5
    //   441: astore 12
    //   443: aload 6
    //   445: astore 15
    //   447: aload 7
    //   449: astore 21
    //   451: aload 27
    //   453: iload_2
    //   454: invokeinterface 414 2 0
    //   459: astore 9
    //   461: aload 4
    //   463: astore 16
    //   465: aload 5
    //   467: astore 10
    //   469: aload 6
    //   471: astore 13
    //   473: aload 7
    //   475: astore 19
    //   477: aload 4
    //   479: astore 17
    //   481: aload 5
    //   483: astore 11
    //   485: aload 6
    //   487: astore 14
    //   489: aload 7
    //   491: astore 20
    //   493: aload 4
    //   495: astore 18
    //   497: aload 5
    //   499: astore 12
    //   501: aload 6
    //   503: astore 15
    //   505: aload 7
    //   507: astore 21
    //   509: aload 9
    //   511: invokeinterface 879 1 0
    //   516: ldc_w 885
    //   519: invokevirtual 883	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   522: ifeq +160 -> 682
    //   525: aload 4
    //   527: astore 16
    //   529: aload 5
    //   531: astore 10
    //   533: aload 6
    //   535: astore 13
    //   537: aload 7
    //   539: astore 19
    //   541: aload 4
    //   543: astore 17
    //   545: aload 5
    //   547: astore 11
    //   549: aload 6
    //   551: astore 14
    //   553: aload 7
    //   555: astore 20
    //   557: aload 4
    //   559: astore 18
    //   561: aload 5
    //   563: astore 12
    //   565: aload 6
    //   567: astore 15
    //   569: aload 7
    //   571: astore 21
    //   573: aload 4
    //   575: astore 23
    //   577: aload 5
    //   579: astore 22
    //   581: aload 6
    //   583: astore 24
    //   585: aload 7
    //   587: astore 25
    //   589: aload 5
    //   591: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   594: ifeq +1463 -> 2057
    //   597: aload 4
    //   599: astore 16
    //   601: aload 5
    //   603: astore 10
    //   605: aload 6
    //   607: astore 13
    //   609: aload 7
    //   611: astore 19
    //   613: aload 4
    //   615: astore 17
    //   617: aload 5
    //   619: astore 11
    //   621: aload 6
    //   623: astore 14
    //   625: aload 7
    //   627: astore 20
    //   629: aload 4
    //   631: astore 18
    //   633: aload 5
    //   635: astore 12
    //   637: aload 6
    //   639: astore 15
    //   641: aload 7
    //   643: astore 21
    //   645: aload 9
    //   647: invokeinterface 889 1 0
    //   652: ldc_w 891
    //   655: invokeinterface 897 2 0
    //   660: invokeinterface 401 1 0
    //   665: astore 22
    //   667: aload 4
    //   669: astore 23
    //   671: aload 6
    //   673: astore 24
    //   675: aload 7
    //   677: astore 25
    //   679: goto +1378 -> 2057
    //   682: aload 4
    //   684: astore 16
    //   686: aload 5
    //   688: astore 10
    //   690: aload 6
    //   692: astore 13
    //   694: aload 7
    //   696: astore 19
    //   698: aload 4
    //   700: astore 17
    //   702: aload 5
    //   704: astore 11
    //   706: aload 6
    //   708: astore 14
    //   710: aload 7
    //   712: astore 20
    //   714: aload 4
    //   716: astore 18
    //   718: aload 5
    //   720: astore 12
    //   722: aload 6
    //   724: astore 15
    //   726: aload 7
    //   728: astore 21
    //   730: aload 9
    //   732: invokeinterface 879 1 0
    //   737: ldc_w 899
    //   740: invokevirtual 883	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   743: ifeq +145 -> 888
    //   746: aload 4
    //   748: astore 16
    //   750: aload 5
    //   752: astore 10
    //   754: aload 6
    //   756: astore 13
    //   758: aload 7
    //   760: astore 19
    //   762: aload 4
    //   764: astore 17
    //   766: aload 5
    //   768: astore 11
    //   770: aload 6
    //   772: astore 14
    //   774: aload 7
    //   776: astore 20
    //   778: aload 4
    //   780: astore 18
    //   782: aload 5
    //   784: astore 12
    //   786: aload 6
    //   788: astore 15
    //   790: aload 7
    //   792: astore 21
    //   794: aload 4
    //   796: astore 23
    //   798: aload 5
    //   800: astore 22
    //   802: aload 6
    //   804: astore 24
    //   806: aload 7
    //   808: astore 25
    //   810: aload 7
    //   812: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   815: ifeq +1242 -> 2057
    //   818: aload 4
    //   820: astore 16
    //   822: aload 5
    //   824: astore 10
    //   826: aload 6
    //   828: astore 13
    //   830: aload 7
    //   832: astore 19
    //   834: aload 4
    //   836: astore 17
    //   838: aload 5
    //   840: astore 11
    //   842: aload 6
    //   844: astore 14
    //   846: aload 7
    //   848: astore 20
    //   850: aload 4
    //   852: astore 18
    //   854: aload 5
    //   856: astore 12
    //   858: aload 6
    //   860: astore 15
    //   862: aload 7
    //   864: astore 21
    //   866: aload 9
    //   868: invokestatic 901	birl:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   871: astore 25
    //   873: aload 4
    //   875: astore 23
    //   877: aload 5
    //   879: astore 22
    //   881: aload 6
    //   883: astore 24
    //   885: goto +1172 -> 2057
    //   888: aload 4
    //   890: astore 16
    //   892: aload 5
    //   894: astore 10
    //   896: aload 6
    //   898: astore 13
    //   900: aload 7
    //   902: astore 19
    //   904: aload 4
    //   906: astore 17
    //   908: aload 5
    //   910: astore 11
    //   912: aload 6
    //   914: astore 14
    //   916: aload 7
    //   918: astore 20
    //   920: aload 4
    //   922: astore 18
    //   924: aload 5
    //   926: astore 12
    //   928: aload 6
    //   930: astore 15
    //   932: aload 7
    //   934: astore 21
    //   936: aload 9
    //   938: invokeinterface 879 1 0
    //   943: ldc_w 903
    //   946: invokevirtual 883	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   949: ifeq +145 -> 1094
    //   952: aload 4
    //   954: astore 16
    //   956: aload 5
    //   958: astore 10
    //   960: aload 6
    //   962: astore 13
    //   964: aload 7
    //   966: astore 19
    //   968: aload 4
    //   970: astore 17
    //   972: aload 5
    //   974: astore 11
    //   976: aload 6
    //   978: astore 14
    //   980: aload 7
    //   982: astore 20
    //   984: aload 4
    //   986: astore 18
    //   988: aload 5
    //   990: astore 12
    //   992: aload 6
    //   994: astore 15
    //   996: aload 7
    //   998: astore 21
    //   1000: aload 4
    //   1002: astore 23
    //   1004: aload 5
    //   1006: astore 22
    //   1008: aload 6
    //   1010: astore 24
    //   1012: aload 7
    //   1014: astore 25
    //   1016: aload 6
    //   1018: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1021: ifeq +1036 -> 2057
    //   1024: aload 4
    //   1026: astore 16
    //   1028: aload 5
    //   1030: astore 10
    //   1032: aload 6
    //   1034: astore 13
    //   1036: aload 7
    //   1038: astore 19
    //   1040: aload 4
    //   1042: astore 17
    //   1044: aload 5
    //   1046: astore 11
    //   1048: aload 6
    //   1050: astore 14
    //   1052: aload 7
    //   1054: astore 20
    //   1056: aload 4
    //   1058: astore 18
    //   1060: aload 5
    //   1062: astore 12
    //   1064: aload 6
    //   1066: astore 15
    //   1068: aload 7
    //   1070: astore 21
    //   1072: aload 9
    //   1074: invokestatic 901	birl:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   1077: astore 24
    //   1079: aload 4
    //   1081: astore 23
    //   1083: aload 5
    //   1085: astore 22
    //   1087: aload 7
    //   1089: astore 25
    //   1091: goto +966 -> 2057
    //   1094: aload 4
    //   1096: astore 16
    //   1098: aload 5
    //   1100: astore 10
    //   1102: aload 6
    //   1104: astore 13
    //   1106: aload 7
    //   1108: astore 19
    //   1110: aload 4
    //   1112: astore 17
    //   1114: aload 5
    //   1116: astore 11
    //   1118: aload 6
    //   1120: astore 14
    //   1122: aload 7
    //   1124: astore 20
    //   1126: aload 4
    //   1128: astore 18
    //   1130: aload 5
    //   1132: astore 12
    //   1134: aload 6
    //   1136: astore 15
    //   1138: aload 7
    //   1140: astore 21
    //   1142: aload 4
    //   1144: astore 23
    //   1146: aload 5
    //   1148: astore 22
    //   1150: aload 6
    //   1152: astore 24
    //   1154: aload 7
    //   1156: astore 25
    //   1158: aload 9
    //   1160: invokeinterface 879 1 0
    //   1165: ldc_w 905
    //   1168: invokevirtual 883	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1171: ifeq +886 -> 2057
    //   1174: aload 4
    //   1176: astore 16
    //   1178: aload 5
    //   1180: astore 10
    //   1182: aload 6
    //   1184: astore 13
    //   1186: aload 7
    //   1188: astore 19
    //   1190: aload 4
    //   1192: astore 17
    //   1194: aload 5
    //   1196: astore 11
    //   1198: aload 6
    //   1200: astore 14
    //   1202: aload 7
    //   1204: astore 20
    //   1206: aload 4
    //   1208: astore 18
    //   1210: aload 5
    //   1212: astore 12
    //   1214: aload 6
    //   1216: astore 15
    //   1218: aload 7
    //   1220: astore 21
    //   1222: aload 9
    //   1224: invokeinterface 889 1 0
    //   1229: astore 28
    //   1231: aload 5
    //   1233: astore 9
    //   1235: aload 4
    //   1237: astore 16
    //   1239: aload 5
    //   1241: astore 10
    //   1243: aload 6
    //   1245: astore 13
    //   1247: aload 7
    //   1249: astore 19
    //   1251: aload 4
    //   1253: astore 17
    //   1255: aload 5
    //   1257: astore 11
    //   1259: aload 6
    //   1261: astore 14
    //   1263: aload 7
    //   1265: astore 20
    //   1267: aload 4
    //   1269: astore 18
    //   1271: aload 5
    //   1273: astore 12
    //   1275: aload 6
    //   1277: astore 15
    //   1279: aload 7
    //   1281: astore 21
    //   1283: aload 5
    //   1285: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1288: ifeq +68 -> 1356
    //   1291: aload 4
    //   1293: astore 16
    //   1295: aload 5
    //   1297: astore 10
    //   1299: aload 6
    //   1301: astore 13
    //   1303: aload 7
    //   1305: astore 19
    //   1307: aload 4
    //   1309: astore 17
    //   1311: aload 5
    //   1313: astore 11
    //   1315: aload 6
    //   1317: astore 14
    //   1319: aload 7
    //   1321: astore 20
    //   1323: aload 4
    //   1325: astore 18
    //   1327: aload 5
    //   1329: astore 12
    //   1331: aload 6
    //   1333: astore 15
    //   1335: aload 7
    //   1337: astore 21
    //   1339: aload 28
    //   1341: ldc_w 891
    //   1344: invokeinterface 897 2 0
    //   1349: invokeinterface 401 1 0
    //   1354: astore 9
    //   1356: aload 4
    //   1358: astore 16
    //   1360: aload 9
    //   1362: astore 10
    //   1364: aload 6
    //   1366: astore 13
    //   1368: aload 7
    //   1370: astore 19
    //   1372: aload 4
    //   1374: astore 17
    //   1376: aload 9
    //   1378: astore 11
    //   1380: aload 6
    //   1382: astore 14
    //   1384: aload 7
    //   1386: astore 20
    //   1388: aload 4
    //   1390: astore 18
    //   1392: aload 9
    //   1394: astore 12
    //   1396: aload 6
    //   1398: astore 15
    //   1400: aload 7
    //   1402: astore 21
    //   1404: aload 4
    //   1406: astore 23
    //   1408: aload 9
    //   1410: astore 22
    //   1412: aload 6
    //   1414: astore 24
    //   1416: aload 7
    //   1418: astore 25
    //   1420: aload 4
    //   1422: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1425: ifeq +632 -> 2057
    //   1428: aload 4
    //   1430: astore 16
    //   1432: aload 9
    //   1434: astore 10
    //   1436: aload 6
    //   1438: astore 13
    //   1440: aload 7
    //   1442: astore 19
    //   1444: aload 4
    //   1446: astore 17
    //   1448: aload 9
    //   1450: astore 11
    //   1452: aload 6
    //   1454: astore 14
    //   1456: aload 7
    //   1458: astore 20
    //   1460: aload 4
    //   1462: astore 18
    //   1464: aload 9
    //   1466: astore 12
    //   1468: aload 6
    //   1470: astore 15
    //   1472: aload 7
    //   1474: astore 21
    //   1476: aload 28
    //   1478: ldc_w 907
    //   1481: invokeinterface 897 2 0
    //   1486: invokeinterface 401 1 0
    //   1491: astore 23
    //   1493: aload 9
    //   1495: astore 22
    //   1497: aload 6
    //   1499: astore 24
    //   1501: aload 7
    //   1503: astore 25
    //   1505: goto +552 -> 2057
    //   1508: aload 4
    //   1510: astore 22
    //   1512: aload 5
    //   1514: astore 23
    //   1516: aload 6
    //   1518: astore 24
    //   1520: aload 8
    //   1522: astore 25
    //   1524: aload 7
    //   1526: astore 9
    //   1528: aload 4
    //   1530: astore 16
    //   1532: aload 5
    //   1534: astore 10
    //   1536: aload 6
    //   1538: astore 13
    //   1540: aload 7
    //   1542: astore 19
    //   1544: aload 4
    //   1546: astore 17
    //   1548: aload 5
    //   1550: astore 11
    //   1552: aload 6
    //   1554: astore 14
    //   1556: aload 7
    //   1558: astore 20
    //   1560: aload 4
    //   1562: astore 18
    //   1564: aload 5
    //   1566: astore 12
    //   1568: aload 6
    //   1570: astore 15
    //   1572: aload 7
    //   1574: astore 21
    //   1576: aload 28
    //   1578: ldc_w 909
    //   1581: invokevirtual 883	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1584: ifeq +165 -> 1749
    //   1587: aload 4
    //   1589: astore 22
    //   1591: aload 5
    //   1593: astore 23
    //   1595: aload 6
    //   1597: astore 24
    //   1599: aload 8
    //   1601: astore 25
    //   1603: aload 7
    //   1605: astore 9
    //   1607: aload 4
    //   1609: astore 16
    //   1611: aload 5
    //   1613: astore 10
    //   1615: aload 6
    //   1617: astore 13
    //   1619: aload 7
    //   1621: astore 19
    //   1623: aload 4
    //   1625: astore 17
    //   1627: aload 5
    //   1629: astore 11
    //   1631: aload 6
    //   1633: astore 14
    //   1635: aload 7
    //   1637: astore 20
    //   1639: aload 4
    //   1641: astore 18
    //   1643: aload 5
    //   1645: astore 12
    //   1647: aload 6
    //   1649: astore 15
    //   1651: aload 7
    //   1653: astore 21
    //   1655: aload 8
    //   1657: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1660: ifeq +89 -> 1749
    //   1663: aload 4
    //   1665: astore 16
    //   1667: aload 5
    //   1669: astore 10
    //   1671: aload 6
    //   1673: astore 13
    //   1675: aload 7
    //   1677: astore 19
    //   1679: aload 4
    //   1681: astore 17
    //   1683: aload 5
    //   1685: astore 11
    //   1687: aload 6
    //   1689: astore 14
    //   1691: aload 7
    //   1693: astore 20
    //   1695: aload 4
    //   1697: astore 18
    //   1699: aload 5
    //   1701: astore 12
    //   1703: aload 6
    //   1705: astore 15
    //   1707: aload 7
    //   1709: astore 21
    //   1711: aload 27
    //   1713: invokeinterface 889 1 0
    //   1718: ldc_w 911
    //   1721: invokeinterface 897 2 0
    //   1726: invokeinterface 401 1 0
    //   1731: astore 25
    //   1733: aload 7
    //   1735: astore 9
    //   1737: aload 6
    //   1739: astore 24
    //   1741: aload 5
    //   1743: astore 23
    //   1745: aload 4
    //   1747: astore 22
    //   1749: iload_1
    //   1750: iconst_1
    //   1751: iadd
    //   1752: istore_1
    //   1753: aload 22
    //   1755: astore 4
    //   1757: aload 23
    //   1759: astore 5
    //   1761: aload 24
    //   1763: astore 6
    //   1765: aload 25
    //   1767: astore 8
    //   1769: aload 9
    //   1771: astore 7
    //   1773: goto -1687 -> 86
    //   1776: aload_0
    //   1777: astore 9
    //   1779: aload 6
    //   1781: astore_0
    //   1782: bipush 6
    //   1784: anewarray 120	java/lang/String
    //   1787: dup
    //   1788: iconst_0
    //   1789: aload 7
    //   1791: aastore
    //   1792: dup
    //   1793: iconst_1
    //   1794: aload 9
    //   1796: aastore
    //   1797: dup
    //   1798: iconst_2
    //   1799: aload 8
    //   1801: aastore
    //   1802: dup
    //   1803: iconst_3
    //   1804: aload_0
    //   1805: aastore
    //   1806: dup
    //   1807: iconst_4
    //   1808: aload 5
    //   1810: aastore
    //   1811: dup
    //   1812: iconst_5
    //   1813: aload 4
    //   1815: aastore
    //   1816: areturn
    //   1817: astore 9
    //   1819: aconst_null
    //   1820: astore 4
    //   1822: aconst_null
    //   1823: astore 5
    //   1825: aconst_null
    //   1826: astore_0
    //   1827: aconst_null
    //   1828: astore 8
    //   1830: aconst_null
    //   1831: astore 6
    //   1833: aconst_null
    //   1834: astore 7
    //   1836: aload 9
    //   1838: invokevirtual 912	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1841: aload 6
    //   1843: astore 9
    //   1845: goto -63 -> 1782
    //   1848: astore 9
    //   1850: aconst_null
    //   1851: astore 4
    //   1853: aconst_null
    //   1854: astore 5
    //   1856: aconst_null
    //   1857: astore_0
    //   1858: aconst_null
    //   1859: astore 8
    //   1861: aconst_null
    //   1862: astore 6
    //   1864: aconst_null
    //   1865: astore 7
    //   1867: aload 9
    //   1869: invokevirtual 913	org/xml/sax/SAXException:printStackTrace	()V
    //   1872: aload 6
    //   1874: astore 9
    //   1876: goto -94 -> 1782
    //   1879: astore 9
    //   1881: aconst_null
    //   1882: astore 4
    //   1884: aconst_null
    //   1885: astore 5
    //   1887: aconst_null
    //   1888: astore_0
    //   1889: aconst_null
    //   1890: astore 8
    //   1892: aconst_null
    //   1893: astore 6
    //   1895: aconst_null
    //   1896: astore 7
    //   1898: aload 9
    //   1900: invokevirtual 914	java/io/IOException:printStackTrace	()V
    //   1903: aload 6
    //   1905: astore 9
    //   1907: goto -125 -> 1782
    //   1910: astore 9
    //   1912: aconst_null
    //   1913: astore 4
    //   1915: aconst_null
    //   1916: astore 5
    //   1918: aconst_null
    //   1919: astore 10
    //   1921: aconst_null
    //   1922: astore 8
    //   1924: aload_0
    //   1925: astore 6
    //   1927: aconst_null
    //   1928: astore 7
    //   1930: aload 10
    //   1932: astore_0
    //   1933: goto -35 -> 1898
    //   1936: astore 9
    //   1938: aload 19
    //   1940: astore 7
    //   1942: aload_0
    //   1943: astore 6
    //   1945: aload 16
    //   1947: astore 4
    //   1949: aload 10
    //   1951: astore 5
    //   1953: aload 13
    //   1955: astore_0
    //   1956: goto -58 -> 1898
    //   1959: astore 9
    //   1961: aconst_null
    //   1962: astore 4
    //   1964: aconst_null
    //   1965: astore 5
    //   1967: aconst_null
    //   1968: astore 10
    //   1970: aconst_null
    //   1971: astore 8
    //   1973: aload_0
    //   1974: astore 6
    //   1976: aconst_null
    //   1977: astore 7
    //   1979: aload 10
    //   1981: astore_0
    //   1982: goto -115 -> 1867
    //   1985: astore 9
    //   1987: aload 20
    //   1989: astore 7
    //   1991: aload_0
    //   1992: astore 6
    //   1994: aload 17
    //   1996: astore 4
    //   1998: aload 11
    //   2000: astore 5
    //   2002: aload 14
    //   2004: astore_0
    //   2005: goto -138 -> 1867
    //   2008: astore 9
    //   2010: aconst_null
    //   2011: astore 4
    //   2013: aconst_null
    //   2014: astore 5
    //   2016: aconst_null
    //   2017: astore 10
    //   2019: aconst_null
    //   2020: astore 8
    //   2022: aload_0
    //   2023: astore 6
    //   2025: aconst_null
    //   2026: astore 7
    //   2028: aload 10
    //   2030: astore_0
    //   2031: goto -195 -> 1836
    //   2034: astore 9
    //   2036: aload 21
    //   2038: astore 7
    //   2040: aload_0
    //   2041: astore 6
    //   2043: aload 18
    //   2045: astore 4
    //   2047: aload 12
    //   2049: astore 5
    //   2051: aload 15
    //   2053: astore_0
    //   2054: goto -218 -> 1836
    //   2057: iload_2
    //   2058: iconst_1
    //   2059: iadd
    //   2060: istore_2
    //   2061: aload 23
    //   2063: astore 4
    //   2065: aload 22
    //   2067: astore 5
    //   2069: aload 24
    //   2071: astore 6
    //   2073: aload 25
    //   2075: astore 7
    //   2077: goto -1753 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2080	0	paramArrayOfByte	byte[]
    //   70	1683	1	i	int
    //   323	1738	2	j	int
    //   68	21	3	k	int
    //   1	2063	4	localObject1	Object
    //   6	2062	5	localObject2	Object
    //   78	1994	6	localObject3	Object
    //   84	1992	7	localObject4	Object
    //   81	1940	8	localObject5	Object
    //   342	1453	9	localObject6	Object
    //   1817	20	9	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   1843	1	9	localObject7	Object
    //   1848	20	9	localSAXException1	org.xml.sax.SAXException
    //   1874	1	9	localObject8	Object
    //   1879	20	9	localIOException1	java.io.IOException
    //   1905	1	9	localObject9	Object
    //   1910	1	9	localIOException2	java.io.IOException
    //   1936	1	9	localIOException3	java.io.IOException
    //   1959	1	9	localSAXException2	org.xml.sax.SAXException
    //   1985	1	9	localSAXException3	org.xml.sax.SAXException
    //   2008	1	9	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   2034	1	9	localParserConfigurationException3	javax.xml.parsers.ParserConfigurationException
    //   97	1932	10	localObject10	Object
    //   113	1886	11	localObject11	Object
    //   129	1919	12	localObject12	Object
    //   101	1853	13	localObject13	Object
    //   117	1886	14	localObject14	Object
    //   133	1919	15	localObject15	Object
    //   93	1853	16	localObject16	Object
    //   109	1886	17	localObject17	Object
    //   125	1919	18	localObject18	Object
    //   105	1834	19	localObject19	Object
    //   121	1867	20	localObject20	Object
    //   137	1900	21	localObject21	Object
    //   326	1740	22	localObject22	Object
    //   330	1732	23	localObject23	Object
    //   334	1736	24	localObject24	Object
    //   338	1736	25	localObject25	Object
    //   59	81	26	localNodeList	NodeList
    //   147	1565	27	localObject26	Object
    //   204	1373	28	localObject27	Object
    // Exception table:
    //   from	to	target	type
    //   8	31	1817	javax/xml/parsers/ParserConfigurationException
    //   34	52	1817	javax/xml/parsers/ParserConfigurationException
    //   8	31	1848	org/xml/sax/SAXException
    //   34	52	1848	org/xml/sax/SAXException
    //   8	31	1879	java/io/IOException
    //   34	52	1879	java/io/IOException
    //   52	69	1910	java/io/IOException
    //   139	149	1936	java/io/IOException
    //   197	206	1936	java/io/IOException
    //   254	265	1936	java/io/IOException
    //   313	322	1936	java/io/IOException
    //   392	403	1936	java/io/IOException
    //   451	461	1936	java/io/IOException
    //   509	525	1936	java/io/IOException
    //   589	597	1936	java/io/IOException
    //   645	667	1936	java/io/IOException
    //   730	746	1936	java/io/IOException
    //   810	818	1936	java/io/IOException
    //   866	873	1936	java/io/IOException
    //   936	952	1936	java/io/IOException
    //   1016	1024	1936	java/io/IOException
    //   1072	1079	1936	java/io/IOException
    //   1158	1174	1936	java/io/IOException
    //   1222	1231	1936	java/io/IOException
    //   1283	1291	1936	java/io/IOException
    //   1339	1356	1936	java/io/IOException
    //   1420	1428	1936	java/io/IOException
    //   1476	1493	1936	java/io/IOException
    //   1576	1587	1936	java/io/IOException
    //   1655	1663	1936	java/io/IOException
    //   1711	1733	1936	java/io/IOException
    //   52	69	1959	org/xml/sax/SAXException
    //   139	149	1985	org/xml/sax/SAXException
    //   197	206	1985	org/xml/sax/SAXException
    //   254	265	1985	org/xml/sax/SAXException
    //   313	322	1985	org/xml/sax/SAXException
    //   392	403	1985	org/xml/sax/SAXException
    //   451	461	1985	org/xml/sax/SAXException
    //   509	525	1985	org/xml/sax/SAXException
    //   589	597	1985	org/xml/sax/SAXException
    //   645	667	1985	org/xml/sax/SAXException
    //   730	746	1985	org/xml/sax/SAXException
    //   810	818	1985	org/xml/sax/SAXException
    //   866	873	1985	org/xml/sax/SAXException
    //   936	952	1985	org/xml/sax/SAXException
    //   1016	1024	1985	org/xml/sax/SAXException
    //   1072	1079	1985	org/xml/sax/SAXException
    //   1158	1174	1985	org/xml/sax/SAXException
    //   1222	1231	1985	org/xml/sax/SAXException
    //   1283	1291	1985	org/xml/sax/SAXException
    //   1339	1356	1985	org/xml/sax/SAXException
    //   1420	1428	1985	org/xml/sax/SAXException
    //   1476	1493	1985	org/xml/sax/SAXException
    //   1576	1587	1985	org/xml/sax/SAXException
    //   1655	1663	1985	org/xml/sax/SAXException
    //   1711	1733	1985	org/xml/sax/SAXException
    //   52	69	2008	javax/xml/parsers/ParserConfigurationException
    //   139	149	2034	javax/xml/parsers/ParserConfigurationException
    //   197	206	2034	javax/xml/parsers/ParserConfigurationException
    //   254	265	2034	javax/xml/parsers/ParserConfigurationException
    //   313	322	2034	javax/xml/parsers/ParserConfigurationException
    //   392	403	2034	javax/xml/parsers/ParserConfigurationException
    //   451	461	2034	javax/xml/parsers/ParserConfigurationException
    //   509	525	2034	javax/xml/parsers/ParserConfigurationException
    //   589	597	2034	javax/xml/parsers/ParserConfigurationException
    //   645	667	2034	javax/xml/parsers/ParserConfigurationException
    //   730	746	2034	javax/xml/parsers/ParserConfigurationException
    //   810	818	2034	javax/xml/parsers/ParserConfigurationException
    //   866	873	2034	javax/xml/parsers/ParserConfigurationException
    //   936	952	2034	javax/xml/parsers/ParserConfigurationException
    //   1016	1024	2034	javax/xml/parsers/ParserConfigurationException
    //   1072	1079	2034	javax/xml/parsers/ParserConfigurationException
    //   1158	1174	2034	javax/xml/parsers/ParserConfigurationException
    //   1222	1231	2034	javax/xml/parsers/ParserConfigurationException
    //   1283	1291	2034	javax/xml/parsers/ParserConfigurationException
    //   1339	1356	2034	javax/xml/parsers/ParserConfigurationException
    //   1420	1428	2034	javax/xml/parsers/ParserConfigurationException
    //   1476	1493	2034	javax/xml/parsers/ParserConfigurationException
    //   1576	1587	2034	javax/xml/parsers/ParserConfigurationException
    //   1655	1663	2034	javax/xml/parsers/ParserConfigurationException
    //   1711	1733	2034	javax/xml/parsers/ParserConfigurationException
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 1: 
      return 4;
    }
    return 5;
  }
  
  public static void b(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("mobileQQ", i);
      paramString = "qfav_unsupport_msg_dialog_flag_" + paramString;
      if (!((SharedPreferences)localObject).getBoolean(paramString, false)) {
        ((SharedPreferences)localObject).edit().putBoolean(paramString, true).commit();
      }
      return;
    }
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    return ((paramChatMessage instanceof MessageForStructing)) && (((MessageForStructing)paramChatMessage).structingMsg != null) && (((MessageForStructing)paramChatMessage).structingMsg.mMsgServiceID == 14);
  }
  
  public static byte[] b(QQAppInterface paramQQAppInterface, long paramLong, ChatMessage paramChatMessage, String paramString)
  {
    Object localObject = null;
    biqt localbiqt;
    if (((paramChatMessage instanceof MessageForTroopFile)) || ((paramChatMessage instanceof MessageForFile)))
    {
      localbiqt = new biqt(3);
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label237;
      }
      a((MessageForFile)paramChatMessage);
      if (!paramChatMessage.isMultiMsg) {
        break label191;
      }
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "parcelFileMsg create new entity");
      }
      localObject = afar.a(paramQQAppInterface, paramChatMessage);
      a((FileManagerEntity)localObject);
      if (localObject == null) {
        break label219;
      }
      localbiqt.a(paramQQAppInterface, null, (FileManagerEntity)localObject, paramChatMessage, true);
    }
    for (;;)
    {
      paramQQAppInterface = new ContentValues();
      localObject = (ContentValues)localbiqt.a().getExtras().getParcelable("fileContents");
      if (localObject != null) {
        paramQQAppInterface.put("fileContents", a((ContentValues)localObject));
      }
      localObject = abot.c(paramChatMessage);
      long l = paramChatMessage.time;
      paramQQAppInterface.put("sUin", (String)localObject);
      paramQQAppInterface.put("time", Long.valueOf(l));
      paramQQAppInterface.put("entityNickName", paramString);
      localObject = a(paramLong, 3L, paramQQAppInterface);
      return localObject;
      label191:
      if (QLog.isColorLevel()) {
        QLog.d("qqfav", 2, "parcelFileMsg get entity from db");
      }
      localObject = arni.a(paramQQAppInterface, (MessageForFile)paramChatMessage);
      break;
      label219:
      label483:
      if (QLog.isColorLevel())
      {
        QLog.d("qqfav", 2, "entity == null");
        continue;
        label237:
        if ((paramChatMessage instanceof MessageForTroopFile))
        {
          MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
          a(localMessageForTroopFile);
          if (paramChatMessage.isMultiMsg)
          {
            if (QLog.isColorLevel()) {
              QLog.d("qqfav", 2, "parcelFileMsg, isMultiMsg T, create new entity");
            }
            localObject = afar.a(paramQQAppInterface, paramChatMessage);
          }
          for (;;)
          {
            a((FileManagerEntity)localObject);
            afar.a((FileManagerEntity)localObject, localMessageForTroopFile);
            if (localObject == null) {
              break label483;
            }
            localbiqt.a(paramQQAppInterface, null, (FileManagerEntity)localObject, localMessageForTroopFile, true);
            break;
            if (QLog.isColorLevel()) {
              QLog.d("qqfav", 2, "parcelFileMsg, isMultiMsg T, find in db");
            }
            localObject = bcjk.a(paramQQAppInterface, localMessageForTroopFile);
            if (localObject != null)
            {
              FileManagerEntity localFileManagerEntity = afar.a((bbpe)localObject);
              localObject = bcil.a(paramQQAppInterface, ((bbpe)localObject).b);
              if ((localObject != null) && (localFileManagerEntity != null) && (!TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)))
              {
                bbnr localbbnr = ((bcil)localObject).a(localFileManagerEntity.strTroopFilePath);
                localObject = localFileManagerEntity;
                if (localbbnr != null)
                {
                  localFileManagerEntity.lastTime = localbbnr.c;
                  localFileManagerEntity.selfUin = String.valueOf(localbbnr.b);
                  localObject = localFileManagerEntity;
                }
              }
              else
              {
                localObject = localFileManagerEntity;
                if (QLog.isColorLevel())
                {
                  QLog.d("qqfav", 2, "troopFileManager != null or fileManagerEntity4Favorite.strTroopFilePath == null");
                  localObject = localFileManagerEntity;
                }
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("qqfav", 2, "info == null");
              }
              localObject = null;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("qqfav", 2, "fileManagerEntity4Favorite == null");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     birl
 * JD-Core Version:    0.7.0.1
 */