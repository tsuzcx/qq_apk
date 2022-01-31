import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.1;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.2;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.3;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.4;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ammn
  implements ammj, ammk, Manager
{
  private long jdField_a_of_type_Long;
  private agki jdField_a_of_type_Agki;
  private ammg jdField_a_of_type_Ammg;
  private amml jdField_a_of_type_Amml;
  private ammo jdField_a_of_type_Ammo;
  public PeakAppInterface a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private List<ammf> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<String, List<String>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap;
  private ConcurrentHashMap<String, MessageRecord> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  private volatile boolean d;
  private volatile boolean e;
  
  public ammn()
  {
    c();
  }
  
  private long a(String paramString)
  {
    long l1 = 0L;
    long l3 = l1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break label25;
      }
      l3 = l1;
    }
    label25:
    long l2;
    do
    {
      do
      {
        do
        {
          return l3;
          ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_Ammg.a();
          Object localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          l2 = l1;
          if (localObject != null)
          {
            l2 = l1;
            if (((List)localObject).size() > 0)
            {
              localObject = ((List)localObject).iterator();
              for (;;)
              {
                l2 = l1;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                String str = (String)((Iterator)localObject).next();
                ammi localammi = (ammi)localConcurrentHashMap.get(str);
                l2 = l1;
                if (localammi != null)
                {
                  l2 = l1 + localammi.jdField_a_of_type_Long;
                  localammi.b += 1;
                  this.jdField_a_of_type_Ammg.a(str, localammi);
                }
                l1 = l2;
              }
            }
          }
          l3 = l2;
        } while (this.jdField_b_of_type_JavaUtilHashMap == null);
        l3 = l2;
      } while (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString));
      l3 = l2;
    } while (((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue() <= 0);
    return l2 + ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue() * 200;
  }
  
  private Pair<String, List<String>> a(String paramString, List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return new Pair(paramString, localArrayList);
    }
    Iterator localIterator = paramList.iterator();
    label327:
    label344:
    label345:
    for (;;)
    {
      int i;
      if (localIterator.hasNext())
      {
        paramList = (MessageRecord)localIterator.next();
        i = paramList.msgtype;
        if (ammq.a(i))
        {
          paramList = awfx.a(paramList);
          if ((paramList == null) || (!(paramList instanceof MessageForPic))) {
            break label327;
          }
          paramList = ((MessageForPic)paramList).getBiggestFilePath();
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(paramList)) || (localArrayList.contains(paramList))) {
          break label345;
        }
        localArrayList.add(new File(paramList).getName());
        break;
        if (ammq.b(i))
        {
          paramList = awfx.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForShortVideo)))
          {
            MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramList;
            paramList = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
            if (!TextUtils.isEmpty(paramList)) {
              break label344;
            }
            paramList = ShortVideoUtils.b(localMessageForShortVideo);
          }
        }
        else if (ammq.c(i))
        {
          paramList = awfx.a(paramList);
          if (paramList != null) {
            paramList = arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface, paramList);
          }
        }
        else if (ammq.d(i))
        {
          paramList = awfx.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForMixedMsg)))
          {
            b(paramString, ((MessageForMixedMsg)paramList).getPicMsgList());
            paramList = "";
          }
        }
        else if (ammq.e(i))
        {
          paramList = awfx.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForStructing)) && (aupn.a((MessageForStructing)paramList))) {
            b(paramString, this.jdField_a_of_type_Ammo.c(MessageRecord.class, "select * from mr_multimessage where msgseq=?", "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramList.uniseq) }));
          }
        }
        paramList = "";
        continue;
        return new Pair(paramString, localArrayList);
      }
    }
  }
  
  private Pair<Integer, List<MessageRecord>> a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord instanceof MessageForText)) {
        i += 1;
      }
      for (;;)
      {
        break;
        localArrayList.add(localMessageRecord);
      }
    }
    return new Pair(Integer.valueOf(i), localArrayList);
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    String str1 = "";
    String str2;
    if ((paramMessageRecord == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      str2 = "";
      return str2;
    }
    switch (paramMessageRecord.istroop)
    {
    }
    for (;;)
    {
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      return paramMessageRecord.frienduin;
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord.frienduin + 0);
      continue;
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord.frienduin + 1);
      continue;
      str1 = this.jdField_a_of_type_Ammo.a(paramMessageRecord.frienduin);
      continue;
      if (this.jdField_a_of_type_Agki != null)
      {
        str1 = this.jdField_a_of_type_Agki.a(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
        continue;
        str1 = this.jdField_a_of_type_Ammo.a(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_b_of_type_JavaUtilHashMap != null))
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        int i = ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue();
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i + paramInt));
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.c);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 1000) || (paramInt == 1004);
  }
  
  private boolean a(ammf paramammf)
  {
    if ((paramammf == null) || (this.jdField_a_of_type_Agki == null)) {}
    String str;
    do
    {
      return true;
      str = MessageRecord.getTableName(paramammf.jdField_a_of_type_JavaLangString, paramammf.jdField_a_of_type_Int);
    } while (TextUtils.isEmpty(str));
    b(str);
    if (this.jdField_a_of_type_Agki != null) {
      this.jdField_a_of_type_Agki.b(paramammf.jdField_a_of_type_JavaLangString, paramammf.jdField_a_of_type_Int);
    }
    a(str);
    return true;
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
    {
      Object localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramString = new ArrayList();
        ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_Ammg.a();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          ammi localammi = (ammi)localConcurrentHashMap.get(str1);
          if (localammi != null)
          {
            localammi.b -= 1;
            if (localammi.b == 0)
            {
              String str2 = this.jdField_a_of_type_Ammg.a(localammi);
              if (!TextUtils.isEmpty(str2))
              {
                this.jdField_a_of_type_Long += localammi.jdField_a_of_type_Long;
                paramString.add(str2);
              }
              this.jdField_a_of_type_Ammg.a(str1);
            }
            else
            {
              this.jdField_a_of_type_Ammg.a(str1, localammi);
            }
          }
        }
        this.jdField_a_of_type_Ammg.a(paramString);
      }
    }
  }
  
  private void b(String paramString, List<MessageRecord> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        paramList = a(paramList);
      } while (paramList == null);
      a(paramString, ((Integer)paramList.first).intValue());
      paramString = a(paramString, (List)paramList.second);
    } while (paramString == null);
    c((String)paramString.first, (List)paramString.second);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Ammg != null) && (this.jdField_a_of_type_Ammg.a());
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ammo = new ammo();
    AppInterface localAppInterface = this.jdField_a_of_type_Ammo.a();
    if ((localAppInterface instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)localAppInterface);
    }
  }
  
  private void c(String paramString, List<String> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        String str = (String)paramList.get(i);
        if (!localList.contains(str)) {
          localList.add(str);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localList);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramList);
  }
  
  private void d()
  {
    this.d = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Ammo.a(this);
    this.jdField_a_of_type_Ammg = new ammg(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Ammo.a(0, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Ammo.b(1, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadNameList finish");
    }
    h();
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord");
    }
    Object localObject = this.jdField_a_of_type_Ammo.a();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadMessageRecord tableNames is empty");
      }
      this.jdField_b_of_type_Boolean = true;
      h();
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.format("select * from %s", new Object[] { str1 });
      b(str1, this.jdField_a_of_type_Ammo.a(MessageRecord.class, str2, str1, null, null));
    }
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord finish");
    }
    h();
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord");
    }
    Object localObject = this.jdField_a_of_type_Ammo.b();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord tableNames is empty");
      }
      this.c = true;
      h();
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.format("select * from %s", new Object[] { str1 });
      b(str1, this.jdField_a_of_type_Ammo.b(MessageRecord.class, str2, str1, null, null));
    }
    this.c = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord finish");
    }
    h();
  }
  
  private void h()
  {
    if ((a()) && (b()))
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 0)) {
        break label288;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        ammf localammf = new ammf();
        localObject = (MessageRecord)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if ((localObject != null) && (a(((MessageRecord)localObject).istroop)))
        {
          localammf.jdField_a_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
          localammf.jdField_b_of_type_JavaLangString = a((MessageRecord)localObject);
          localammf.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
          localammf.jdField_b_of_type_Long = ((MessageRecord)localObject).time;
          localammf.jdField_a_of_type_Long = a(MessageRecord.getTableName(localammf.jdField_a_of_type_JavaLangString, ((MessageRecord)localObject).istroop));
          if ((localammf.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_JavaUtilList != null))
          {
            localammf.c = ammh.a(localammf.jdField_a_of_type_Long);
            this.jdField_a_of_type_JavaUtilList.add(localammf);
          }
        }
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      if (this.jdField_b_of_type_JavaUtilHashMap != null) {
        this.jdField_b_of_type_JavaUtilHashMap.clear();
      }
      if (this.jdField_a_of_type_Amml != null)
      {
        a(1);
        if (QLog.isColorLevel()) {
          QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish");
        }
        this.jdField_a_of_type_Amml.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      this.e = false;
      return;
      label288:
      if (this.jdField_a_of_type_Amml != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish cleanMessageList is empty");
        }
        this.jdField_a_of_type_Amml.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
  
  private void i()
  {
    this.e = false;
    this.d = true;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_b_of_type_JavaUtilHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      this.jdField_b_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_a_of_type_Ammo != null) {
      this.jdField_a_of_type_Ammo.a();
    }
    if (this.jdField_a_of_type_Ammg != null) {
      this.jdField_a_of_type_Ammg.b();
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public List<ammf> a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new amme(paramInt));
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<ammf> a(List<ammf> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_Agki == null)) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "deleteMessages");
    }
    ThreadManager.getFileThreadHandler().post(new MessageCleanManager.4(this, paramList));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ammf localammf = (ammf)paramList.next();
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(localammf);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "onScanFinish");
    }
    h();
  }
  
  public void a(agki paramagki)
  {
    this.jdField_a_of_type_Agki = paramagki;
  }
  
  public void a(amml paramamml)
  {
    this.jdField_a_of_type_Amml = paramamml;
  }
  
  public void a(String paramString, awge paramawge)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramawge == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "onNotifyLastMsg tableName or entity is null");
      }
    }
    while ((!(paramawge instanceof MessageRecord)) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (MessageRecord)paramawge);
  }
  
  public void a(String paramString, List<? extends awge> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "onNotifyMessageData messageRecordList is empty");
      }
    }
    while (!(paramList.get(0) instanceof MessageRecord)) {
      return;
    }
    b(paramString, paramList);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadAllMessageRecord");
    }
    if (this.e) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadAllMessageRecord isLoadingData");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_Amml != null) {
          this.jdField_a_of_type_Amml.a();
        }
        i();
        d();
        try
        {
          this.e = true;
          this.jdField_a_of_type_Ammg.a();
          ThreadManager.getSubThreadHandler().post(new MessageCleanManager.1(this));
          ThreadManager.getFileThreadHandler().post(new MessageCleanManager.2(this));
          ThreadManager.getFileThreadHandler().post(new MessageCleanManager.3(this));
          return;
        }
        catch (Exception localException)
        {
          if (this.jdField_a_of_type_Amml != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MessageCleanManager", 2, "loadAllMessageRecord exception = " + localException.getMessage());
            }
            this.jdField_a_of_type_Amml.a(this.jdField_a_of_type_JavaUtilList);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
    } while (this.jdField_a_of_type_Amml == null);
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadAllMessageRecord OutOfMemoryError");
    }
    this.jdField_a_of_type_Amml.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void onDestroy()
  {
    i();
    this.jdField_a_of_type_Amml = null;
    this.jdField_a_of_type_Agki = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ammn
 * JD-Core Version:    0.7.0.1
 */