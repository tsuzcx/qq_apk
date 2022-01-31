import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopAioKeyBlackRule;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeywordInfo;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeywordRuleInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bblc
{
  public static TroopAioKeywordTipInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramString = (TroopAioKeywordTipInfo)paramQQAppInterface.a(TroopAioKeywordTipInfo.class, paramString);
      paramQQAppInterface.a();
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    if (paramString == null)
    {
      QLog.i("TroopAioKeywordHelper", 2, "getLocalTipInfo, tipInfo = null");
      return paramString;
    }
    QLog.i("TroopAioKeywordHelper", 2, "getLocalTipInfo, tipInfo = " + paramString.toString());
    return paramString;
  }
  
  public static oidb_0x496.AioKeyword a()
  {
    byte[] arrayOfByte = bdcs.a(BaseApplication.getContext().getFileStreamPath("0x496_aio_keyword"));
    oidb_0x496.AioKeyword localAioKeyword = new oidb_0x496.AioKeyword();
    if (arrayOfByte == null) {}
    do
    {
      return localAioKeyword;
      try
      {
        localAioKeyword.mergeFrom(arrayOfByte);
        return localAioKeyword;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException) {}
    } while (!QLog.isColorLevel());
    QLog.i("TroopAioKeywordHelper", 2, "get0x496AioKeyword," + localInvalidProtocolBufferMicroException.toString());
    return localAioKeyword;
  }
  
  public static List<String> a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = paramQQAppInterface.a(TroopAioKeyBlackRule.class);
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((TroopAioKeyBlackRule)((Iterator)localObject).next()).mBlackUinKeywordRuleId);
    }
    paramQQAppInterface.a();
    return localArrayList;
  }
  
  public static List<TroopAioKeywordTipInfo> a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList(15);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return localArrayList;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)paramQQAppInterface.a(TroopAioKeywordTipInfo.class, paramArrayOfString[i]);
      if (localTroopAioKeywordTipInfo != null) {
        localArrayList.add(localTroopAioKeywordTipInfo);
      }
      i += 1;
    }
    paramQQAppInterface.a();
    if (QLog.isColorLevel()) {
      QLog.i("TroopAioKeywordHelper", 2, "getLocalTipInfo, tipInfos=" + localArrayList.toString());
    }
    return localArrayList;
  }
  
  public static List<bbld> a(oidb_0x496.AioKeyword paramAioKeyword)
  {
    if ((paramAioKeyword == null) || (!paramAioKeyword.has()) || (!paramAioKeyword.keywords.has())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramAioKeyword = paramAioKeyword.keywords.get().iterator();
    while (paramAioKeyword.hasNext())
    {
      oidb_0x496.AioKeywordInfo localAioKeywordInfo = (oidb_0x496.AioKeywordInfo)paramAioKeyword.next();
      bbld localbbld = new bbld();
      localbbld.jdField_a_of_type_JavaLangString = localAioKeywordInfo.word.get();
      localbbld.jdField_a_of_type_JavaUtilList = localAioKeywordInfo.rule_id.get();
      localArrayList.add(localbbld);
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, oidb_0x496.AioKeyword paramAioKeyword)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = BaseApplication.getContext().openFileOutput("0x496_aio_keyword", 0);
        localObject1 = localFileOutputStream;
        localObject2 = localFileOutputStream;
        localFileOutputStream.write(paramAioKeyword.toByteArray());
        localObject1 = localFileOutputStream;
        localObject2 = localFileOutputStream;
        localFileOutputStream.flush();
        localObject1 = localFileOutputStream;
        localObject2 = localFileOutputStream;
        localFileOutputStream.close();
        localObject1 = localFileOutputStream;
        localObject2 = localFileOutputStream;
        bdiv.P(BaseApplicationImpl.getApplication(), paramQQAppInterface.getCurrentAccountUin(), paramAioKeyword.version.get());
      }
      catch (IOException paramQQAppInterface)
      {
        FileOutputStream localFileOutputStream;
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localObject1;
        QLog.e("TroopAioKeywordHelper", 2, "saveFile=" + paramQQAppInterface.toString());
        if (localObject1 == null) {
          continue;
        }
        try
        {
          localObject1.close();
          return;
        }
        catch (IOException paramQQAppInterface) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TroopAioKeywordHelper", 2, "saveFile=" + paramQQAppInterface.toString());
        return;
      }
      finally
      {
        if (localObject2 == null) {
          break label215;
        }
      }
      try
      {
        localFileOutputStream.close();
        return;
      }
      catch (IOException paramQQAppInterface)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("TroopAioKeywordHelper", 2, "saveFile=" + paramQQAppInterface.toString());
          return;
        }
      }
    }
    try
    {
      localObject2.close();
      label215:
      throw paramQQAppInterface;
    }
    catch (IOException paramAioKeyword)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAioKeywordHelper", 2, "saveFile=" + paramAioKeyword.toString());
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    TroopAioKeyBlackRule localTroopAioKeyBlackRule = new TroopAioKeyBlackRule();
    localTroopAioKeyBlackRule.mBlackUinKeywordRuleId = paramString;
    paramQQAppInterface.b(localTroopAioKeyBlackRule);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<TroopAioKeywordTipInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramQQAppInterface.b((TroopAioKeywordTipInfo)paramList.next());
    }
    paramQQAppInterface.a();
  }
  
  public static List<bble> b(oidb_0x496.AioKeyword paramAioKeyword)
  {
    if ((paramAioKeyword == null) || (!paramAioKeyword.has()) || (!paramAioKeyword.rules.has())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramAioKeyword = paramAioKeyword.rules.get().iterator();
    while (paramAioKeyword.hasNext())
    {
      oidb_0x496.AioKeywordRuleInfo localAioKeywordRuleInfo = (oidb_0x496.AioKeywordRuleInfo)paramAioKeyword.next();
      bble localbble = new bble();
      localbble.jdField_a_of_type_Int = localAioKeywordRuleInfo.rule_id.get();
      localbble.b = localAioKeywordRuleInfo.start_time.get();
      localbble.c = localAioKeywordRuleInfo.end_time.get();
      localbble.d = localAioKeywordRuleInfo.postion_flag.get();
      localbble.jdField_a_of_type_JavaUtilList = localAioKeywordRuleInfo.match_group_class.get();
      localbble.e = localAioKeywordRuleInfo.version.get();
      localArrayList.add(localbble);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblc
 * JD-Core Version:    0.7.0.1
 */