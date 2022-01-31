import QC.GetUsrKeyWordInfoRsp;
import QC.OneKeyWordItemClient;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopKeyWord;
import com.tencent.mobileqq.vas.troopkeyword.ExpireSet;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bbtc
{
  private static int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private aukn jdField_a_of_type_Aukn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, List<TroopKeyWord>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public bbtc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aukn = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = bbwv.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "troop_keyword_last_pull_timestamp", 0L);
    }
    return this.jdField_a_of_type_Long;
  }
  
  public static bbtc a(QQAppInterface paramQQAppInterface)
  {
    return ((bbqs)paramQQAppInterface.getManager(235)).a;
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "setPullTimestamp = " + paramLong);
    }
    this.jdField_a_of_type_Long = paramLong;
    bbwv.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "troop_keyword_last_pull_timestamp", paramLong);
  }
  
  private void a(HashMap<String, List<TroopKeyWord>> paramHashMap)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!paramHashMap.containsKey(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, "updateKeywords: " + paramHashMap);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(paramHashMap);
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  private static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "setEnable = " + paramBoolean);
    }
    bbwv.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "troop_keyword_open", paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (jdField_a_of_type_Int == 0) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (jdField_a_of_type_Int == 1);
    if (bbwv.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "troop_keyword_open", true)) {}
    for (int i = 1;; i = 0)
    {
      jdField_a_of_type_Int = i;
      if (QLog.isColorLevel()) {
        QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "isEnable = " + jdField_a_of_type_Int);
      }
      bool1 = bool2;
      if (jdField_a_of_type_Int == 1) {
        break;
      }
      return false;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramMessageRecord instanceof QQMessageFacade.Message))
    {
      bool1 = bool2;
      if (((QQMessageFacade.Message)paramMessageRecord).bizType == 16) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static long b()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_KeywordAIORefreshFrequency", 1) * 60L * 1000L;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    Object localObject2 = this.jdField_a_of_type_Aukn.a(TroopKeyWord.class);
    HashMap localHashMap = new HashMap();
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        TroopKeyWord localTroopKeyWord = (TroopKeyWord)localIterator.next();
        List localList = (List)localHashMap.get(localTroopKeyWord.troopUin);
        localObject2 = localList;
        if (localList == null)
        {
          localObject2 = new ArrayList();
          localHashMap.put(localTroopKeyWord.troopUin, localObject2);
        }
        ((List)localObject2).add(localTroopKeyWord);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, "syncLoad: " + localHashMap);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localHashMap);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void d()
  {
    ThreadManagerV2.excute(new TroopKeywordManager.1(this), 32, null, true);
  }
  
  public bbtb a(String paramString)
  {
    bbtb localbbtb = new bbtb();
    if ((TextUtils.isEmpty(paramString)) || (!a()))
    {
      localbbtb.jdField_a_of_type_JavaLangString = "";
      localbbtb.jdField_a_of_type_Boolean = false;
      localbbtb.c = 1;
      QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, new Object[] { "getTips error, troopUin=", paramString, " enable=", Boolean.valueOf(a()) });
      return localbbtb;
    }
    c();
    Object localObject1 = BaseApplicationImpl.getContext().getResources();
    List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    boolean bool;
    int i;
    if ((localList == null) || (localList.isEmpty()))
    {
      localObject1 = ((Resources)localObject1).getString(2131693065);
      if ((!bbwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_keyword_guide_clicked", false)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()))
      {
        bool = true;
        if (!bool) {
          break label245;
        }
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, new Object[] { "getTips, troopUin=", paramString, " tips=", localObject1, " red=", Boolean.valueOf(bool) });
      }
      localbbtb.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localbbtb.jdField_a_of_type_Boolean = bool;
      localbbtb.c = i;
      return localbbtb;
      bool = false;
      break;
      label245:
      i = 1;
      continue;
      ExpireSet localExpireSet = new ExpireSet();
      Object localObject2 = localList.iterator();
      int j = 0;
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        TroopKeyWord localTroopKeyWord = (TroopKeyWord)((Iterator)localObject2).next();
        if (localTroopKeyWord.expiredFlag == 3)
        {
          localExpireSet.add(Long.valueOf(localTroopKeyWord.wordId));
          j += 1;
        }
        for (;;)
        {
          break;
          int k = i;
          if (localTroopKeyWord.expiredFlag == 2)
          {
            k = i + 1;
            localExpireSet.add(Long.valueOf(localTroopKeyWord.wordId));
          }
          i = k;
        }
      }
      localbbtb.jdField_a_of_type_Int = j;
      localbbtb.jdField_b_of_type_Int = i;
      localbbtb.jdField_b_of_type_JavaLangString = localExpireSet.toJson();
      localObject2 = bbwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_keyword_expire_list_" + paramString, null);
      if (!ExpireSet.fromJson((String)localObject2).containsAll(localExpireSet))
      {
        bool = true;
        label429:
        if (!bool) {
          break label511;
        }
        QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "expireList hasNewExpiredId, last:" + (String)localObject2 + " now:" + localbbtb.jdField_b_of_type_JavaLangString);
      }
      for (;;)
      {
        if (j <= 0) {
          break label547;
        }
        localObject1 = ((Resources)localObject1).getString(2131699602, new Object[] { Integer.valueOf(j) });
        i = 5;
        break;
        bool = false;
        break label429;
        label511:
        bbwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_keyword_expire_list_" + paramString, localbbtb.jdField_b_of_type_JavaLangString);
      }
      label547:
      if (i > 0)
      {
        localObject1 = ((Resources)localObject1).getString(2131699607);
        i = 4;
      }
      else
      {
        localObject1 = ((Resources)localObject1).getString(2131699603, new Object[] { Integer.valueOf(localList.size()) });
        bool = false;
        i = 3;
      }
    }
  }
  
  public void a() {}
  
  public void a(GetUsrKeyWordInfoRsp paramGetUsrKeyWordInfoRsp)
  {
    QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeyworkRsp");
    if (paramGetUsrKeyWordInfoRsp == null)
    {
      QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "rsp == null");
      return;
    }
    boolean bool;
    HashMap localHashMap;
    ArrayList[] arrayOfArrayList;
    int j;
    int i;
    if (1 == paramGetUsrKeyWordInfoRsp.iShowEntry)
    {
      bool = true;
      a(bool);
      localHashMap = new HashMap();
      arrayOfArrayList = new ArrayList[2];
      arrayOfArrayList[0] = paramGetUsrKeyWordInfoRsp.vBaseWord;
      arrayOfArrayList[1] = paramGetUsrKeyWordInfoRsp.vVaWord;
      j = arrayOfArrayList.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label301;
      }
      paramGetUsrKeyWordInfoRsp = arrayOfArrayList[i];
      if (paramGetUsrKeyWordInfoRsp != null)
      {
        Iterator localIterator = paramGetUsrKeyWordInfoRsp.iterator();
        label96:
        if (localIterator.hasNext())
        {
          paramGetUsrKeyWordInfoRsp = (OneKeyWordItemClient)localIterator.next();
          TroopKeyWord localTroopKeyWord = new TroopKeyWord();
          localTroopKeyWord.wordId = paramGetUsrKeyWordInfoRsp.uWordId;
          localTroopKeyWord.keyword = paramGetUsrKeyWordInfoRsp.sKeyWordContent.toLowerCase();
          localTroopKeyWord.troopUin = String.valueOf(paramGetUsrKeyWordInfoRsp.uGroupNum);
          localTroopKeyWord.expiredFlag = ((int)paramGetUsrKeyWordInfoRsp.uWordExpiredFlag);
          if ((paramGetUsrKeyWordInfoRsp.uWordStatus == 2L) && ((paramGetUsrKeyWordInfoRsp.uWordExpiredFlag == 1L) || (paramGetUsrKeyWordInfoRsp.uWordExpiredFlag == 2L))) {}
          for (bool = true;; bool = false)
          {
            localTroopKeyWord.enable = bool;
            if (QLog.isColorLevel()) {
              QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, localTroopKeyWord.toString());
            }
            List localList = (List)localHashMap.get(localTroopKeyWord.troopUin);
            paramGetUsrKeyWordInfoRsp = localList;
            if (localList == null)
            {
              paramGetUsrKeyWordInfoRsp = new ArrayList();
              localHashMap.put(localTroopKeyWord.troopUin, paramGetUsrKeyWordInfoRsp);
            }
            paramGetUsrKeyWordInfoRsp.add(localTroopKeyWord);
            break label96;
            bool = false;
            break;
          }
        }
      }
      i += 1;
    }
    label301:
    a(localHashMap);
  }
  
  public void a(String paramString)
  {
    if (a(paramString))
    {
      long l = System.currentTimeMillis();
      if (Math.abs(l - a()) > b())
      {
        QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeywordTimeoutCheck");
        a(l);
        b();
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (!a()) {
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "hasKeyword, troopUin is empty");
      return false;
    }
    paramString = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((paramString != null) && (paramString.size() > 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (!a()) {}
    TroopKeyWord localTroopKeyWord;
    do
    {
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            return false;
          } while (TextUtils.isEmpty(paramString1));
          if (TextUtils.isEmpty(paramString2))
          {
            QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "containsKeyword, troopUin is empty");
            return false;
          }
          c();
          localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
        } while ((localObject == null) || (((List)localObject).isEmpty()));
        paramString1 = paramString1.toLowerCase();
        localObject = ((List)localObject).iterator();
      }
      localTroopKeyWord = (TroopKeyWord)((Iterator)localObject).next();
    } while ((!localTroopKeyWord.enable) || (!paramString1.contains(localTroopKeyWord.keyword)));
    if (QLog.isColorLevel()) {
      QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, "containsKeyword: " + localTroopKeyWord.keyword);
    }
    axqw.b(null, "dc00898", "", paramString2, "qq_vip", "0X800A8FD", 0, 1, 0, "", "", localTroopKeyWord.keyword, "");
    return true;
  }
  
  public void b()
  {
    QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeywordChangePush");
    ((akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(new bbtd(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbtc
 * JD-Core Version:    0.7.0.1
 */