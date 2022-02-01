import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager.1;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager.3;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class asmn
  implements Manager
{
  private static final HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  public List<EmosmPb.SmallYellowItem> a;
  private boolean jdField_a_of_type_Boolean;
  public int[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(217), Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(223), Integer.valueOf(3));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(168), Integer.valueOf(8));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(219), Integer.valueOf(10));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(212), Integer.valueOf(12));
  }
  
  public asmn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[] { 128525, 13, 128532, 5, 6, 14, 3, 20, 109, 28, 127874, 63, 9, 1, 49, 22, 128557, 11, 128169, 128163, 98, 27, 35, 2 };
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(List<EmosmPb.SmallYellowItem> paramList1, List<EmosmPb.SmallYellowItem> paramList2)
  {
    int j = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("mergeAndSortSystemEmojiInfo:");
      int i;
      if (paramList1 != null)
      {
        localStringBuilder.append("befor sort list1 : ");
        i = 0;
        while (i < paramList1.size())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList1.get(i);
          localStringBuilder.append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
          i += 1;
        }
      }
      if (paramList2 != null)
      {
        localStringBuilder.append("befor sort list2 : ");
        i = j;
        while (i < paramList2.size())
        {
          paramList1 = (EmosmPb.SmallYellowItem)paramList2.get(i);
          localStringBuilder.append("type = " + paramList1.type.get()).append(";id = " + paramList1.id.get()).append(";ts = " + paramList1.ts.get());
          i += 1;
        }
      }
      QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo merge:" + localStringBuilder.toString());
    }
  }
  
  private void c(List<EmosmPb.SmallYellowItem> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      File localFile = new File(BaseApplicationImpl.sApplication.getFilesDir(), "commonusedSystemEmojiInfoFile_v3_" + BaseApplicationImpl.sApplication.getRuntime().getAccount());
      EmosmPb.SubCmd0x13Rsp localSubCmd0x13Rsp = new EmosmPb.SubCmd0x13Rsp();
      localSubCmd0x13Rsp.itemlist.set(paramList);
      bhmi.a(localFile.getAbsolutePath(), localSubCmd0x13Rsp.toByteArray(), false);
      return;
    }
  }
  
  private void d(List<EmosmPb.SmallYellowItem> paramList)
  {
    if (paramList == null) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("mergeAndSortSystemEmojiInfo:");
    localStringBuilder.append("after sort ,mergeList:");
    int i = 0;
    while (i < paramList.size())
    {
      EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList.get(i);
      localStringBuilder.append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
      i += 1;
    }
    QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo merge:" + localStringBuilder.toString());
  }
  
  public List<EmosmPb.SmallYellowItem> a()
  {
    Object localObject2;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1))
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "getCommonUsedSystemEmojiInfo  useDefaultinfo");
      a();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        localObject2 = new EmosmPb.SmallYellowItem();
        int j = this.jdField_a_of_type_ArrayOfInt[i];
        int k;
        if (j > asle.a())
        {
          ((EmosmPb.SmallYellowItem)localObject2).type.set(2);
          k = askx.b(j);
          j = k;
          if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(k)))
          {
            QLog.d("CommonUsedSystemEmojiManager", 2, "getCommonUsedSystemEmojiInfo dedault before EMOTIONPANEL_EMOJI_MAP index = " + k);
            j = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k))).intValue();
            QLog.d("CommonUsedSystemEmojiManager", 2, "getCommonUsedSystemEmojiInfo dedault after EMOTIONPANEL_EMOJI_MAP index = " + j);
          }
          ((EmosmPb.SmallYellowItem)localObject2).id.set(j);
          label180:
          if (!asky.a().a(((EmosmPb.SmallYellowItem)localObject2).type.get()).b(((EmosmPb.SmallYellowItem)localObject2).id.get())) {
            break label307;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CommonUsedSystemEmojiManager", 2, new Object[] { "emo should be hided:", Integer.valueOf(((EmosmPb.SmallYellowItem)localObject2).id.get()), " ,type:", Integer.valueOf(((EmosmPb.SmallYellowItem)localObject2).type.get()) });
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ((EmosmPb.SmallYellowItem)localObject2).type.set(1);
          k = asle.b(j);
          j = k;
          if (k == 250) {
            j = 10;
          }
          ((EmosmPb.SmallYellowItem)localObject2).id.set(j);
          break label180;
          label307:
          ((EmosmPb.SmallYellowItem)localObject2).ts.set(0L);
          localArrayList.add(localObject2);
        }
      }
      try
      {
        this.jdField_a_of_type_JavaUtilList = localArrayList;
        return b();
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getCommonUsedSystemEmojiInfo ");
    }
    List localList = b();
    if ((!this.jdField_a_of_type_Boolean) && (localList != null))
    {
      localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((Iterator)localObject2).next();
        if (asky.a().a(localSmallYellowItem.type.get()).b(localSmallYellowItem.id.get())) {
          ((Iterator)localObject2).remove();
        }
      }
    }
    return localList;
  }
  
  public List<EmosmPb.SmallYellowItem> a(List<EmosmPb.SmallYellowItem> paramList)
  {
    int i = 21;
    new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      paramList = a(paramList, b());
    }
    while (paramList.size() > 21)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManager", 2, "before remove size = " + paramList.size());
      }
      localObject = new ArrayList();
      for (;;)
      {
        if (i < paramList.size())
        {
          ((List)localObject).add(paramList.get(i));
          i += 1;
          continue;
          paramList = a(null, paramList);
          break;
        }
      }
      paramList.removeAll((Collection)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManager", 2, "after remove size = " + paramList.size());
      }
    }
    Object localObject = b(paramList);
    if (localObject != null) {
      paramList.addAll((Collection)localObject);
    }
    return paramList;
  }
  
  public List<EmosmPb.SmallYellowItem> a(List<EmosmPb.SmallYellowItem> paramList1, List<EmosmPb.SmallYellowItem> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo");
    }
    if ((paramList1 == null) && (paramList2 == null))
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo list IS null");
      return null;
    }
    if (paramList1 == null) {
      QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo  list1 = NULL");
    }
    for (List<EmosmPb.SmallYellowItem> localList = paramList2;; localList = null)
    {
      if (paramList2 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo  list2 = NULL");
        localList = paramList1;
      }
      if (localList == null)
      {
        paramList1.addAll(paramList2);
        localList = paramList1;
      }
      for (;;)
      {
        a(paramList1, paramList2);
        Collections.sort(localList, new asmo(this));
        d(localList);
        paramList1 = new HashSet();
        paramList2 = localList.iterator();
        while (paramList2.hasNext())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList2.next();
          String str = localSmallYellowItem.type.get() + "-" + localSmallYellowItem.id.get();
          if ((paramList1.contains(str)) || (asky.a().a(localSmallYellowItem.type.get()).b(localSmallYellowItem.id.get()))) {
            paramList2.remove();
          } else {
            paramList1.add(str);
          }
        }
        d(localList);
        return localList;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "updateCacheFromFile");
    }
    ThreadManager.getFileThreadHandler().post(new CommonUsedSystemEmojiManager.1(this));
  }
  
  public void a(EmosmPb.SmallYellowItem paramSmallYellowItem)
  {
    int i = 0;
    if (paramSmallYellowItem == null)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "saveSystemEmojiInfoToCahce info = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "saveSystemEmojiInfoToCahce id = " + paramSmallYellowItem.id.get() + ";type = " + paramSmallYellowItem.type.get() + ";ts = " + paramSmallYellowItem.ts.get());
    }
    int j = paramSmallYellowItem.type.get();
    int k = paramSmallYellowItem.id.get();
    for (;;)
    {
      EmosmPb.SmallYellowItem localSmallYellowItem;
      try
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label330;
        }
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label355;
        }
        localSmallYellowItem = (EmosmPb.SmallYellowItem)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localSmallYellowItem.type.get() == j) && (localSmallYellowItem.id.get() == k))
        {
          localSmallYellowItem = null;
          if (i < 0) {
            break label288;
          }
          localSmallYellowItem = (EmosmPb.SmallYellowItem)this.jdField_a_of_type_JavaUtilList.remove(i);
          if ((QLog.isColorLevel()) && (localSmallYellowItem != null)) {
            QLog.d("CommonUsedSystemEmojiManager", 2, "saveSystemEmojiInfoToCahce removeInfo : type =" + localSmallYellowItem.type.get() + ";id = " + localSmallYellowItem.id.get() + ";ts = " + localSmallYellowItem.ts.get());
          }
          this.jdField_a_of_type_JavaUtilList.add(0, paramSmallYellowItem);
          return;
        }
      }
      finally {}
      i += 1;
      continue;
      label288:
      if (this.jdField_a_of_type_JavaUtilList.size() >= 21)
      {
        localSmallYellowItem = (EmosmPb.SmallYellowItem)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
        continue;
        label330:
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(paramSmallYellowItem);
        continue;
        label355:
        i = -1;
      }
    }
  }
  
  public void a(File paramFile1, File paramFile2)
  {
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = bhmi.a(paramFile1);
      if (localObject2 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "Can not translate pb file to byte");
        return;
      }
    }
    paramFile1 = new EmosmPb.SubCmd0x13Rsp();
    for (;;)
    {
      int i;
      try
      {
        paramFile1.mergeFrom((byte[])localObject2);
        ??? = paramFile1.itemlist.get();
        localObject2 = ((List)???).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((Iterator)localObject2).next();
          i = 0;
          if (i >= begd.c.length) {
            continue;
          }
          if (localSmallYellowItem.id.get() == begd.c[i]) {
            ((Iterator)localObject2).remove();
          }
        }
        else
        {
          paramFile1.itemlist.set((List)???);
          bhmi.a(paramFile2.getAbsolutePath(), paramFile1.toByteArray(), false);
          return;
        }
      }
      catch (Exception paramFile1)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile mergeFromBody exception e = " + paramFile1.getMessage());
        return;
      }
      i += 1;
    }
  }
  
  public void a(List<EmosmPb.SmallYellowItem> paramList)
  {
    if (paramList == null)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo info = null");
      return;
    }
    this.jdField_a_of_type_Boolean = assp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("updateItemInfo backList size = ");
      localStringBuilder.append(paramList.size());
      if (paramList != null)
      {
        localStringBuilder.append(", before convert: ");
        int i = 0;
        while (i < paramList.size())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList.get(i);
          localStringBuilder.append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
          i += 1;
        }
      }
      QLog.d("CommonUsedSystemEmojiManager", 2, localStringBuilder.toString());
    }
    b(paramList);
    if (paramList.size() < 1)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo itemInfos size < 1");
      return;
    }
    paramList = a(paramList);
    try
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      c(paramList);
      return;
    }
    finally {}
  }
  
  public List<EmosmPb.SmallYellowItem> b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getCacheInfo");
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManager", 2, "getCacheInfo is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((EmosmPb.SmallYellowItem)localIterator.next());
      }
    }
    finally {}
    return localList;
  }
  
  public List<EmosmPb.SmallYellowItem> b(List<EmosmPb.SmallYellowItem> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramList = null;
    int i;
    int k;
    int m;
    int j;
    if (((List)localObject).size() < 21)
    {
      i = ((List)localObject).size();
      paramList = new ArrayList();
      if (21 - i < 0)
      {
        k = 0;
        m = 0;
        if (k < this.jdField_a_of_type_ArrayOfInt.length)
        {
          i = this.jdField_a_of_type_ArrayOfInt[k];
          if (i < asle.a())
          {
            j = asle.b(i);
            if (j != 250) {
              break label420;
            }
            i = 1;
            j = 10;
          }
        }
      }
    }
    for (;;)
    {
      if (asky.a().a(i).b(j))
      {
        n = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CommonUsedSystemEmojiManager", 2, new Object[] { "emo should be hided:", Integer.valueOf(j), " ,type:", Integer.valueOf(i) });
          n = m;
        }
        k += 1;
        m = n;
        break;
        j = askx.b(i);
        i = j;
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(j)))
        {
          QLog.d("CommonUsedSystemEmojiManager", 2, "paddedData dedault before EMOTIONPANEL_EMOJI_MAP index = " + j);
          i = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j))).intValue();
          QLog.d("CommonUsedSystemEmojiManager", 2, "paddedData dedault after EMOTIONPANEL_EMOJI_MAP index = " + i);
        }
        n = 2;
        j = i;
        i = n;
        continue;
      }
      int n = 0;
      label279:
      EmosmPb.SmallYellowItem localSmallYellowItem;
      if (n < ((List)localObject).size())
      {
        localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)localObject).get(n);
        i1 = localSmallYellowItem.type.get();
        int i2 = localSmallYellowItem.id.get();
        if ((i1 != i) || (i2 != j)) {}
      }
      for (int i1 = 1;; i1 = 0)
      {
        n = m;
        if (i1 != 0) {
          break;
        }
        n = m + 1;
        localSmallYellowItem = new EmosmPb.SmallYellowItem();
        localSmallYellowItem.type.set(i);
        localSmallYellowItem.id.set(j);
        localSmallYellowItem.ts.set(0L);
        paramList.add(localSmallYellowItem);
        break;
        n += 1;
        break label279;
        return paramList;
      }
      label420:
      i = 1;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "saveSystemEmojiInfoToFile");
    }
    ThreadManager.getFileThreadHandler().post(new CommonUsedSystemEmojiManager.3(this));
  }
  
  public void b(List<EmosmPb.SmallYellowItem> paramList)
  {
    if (paramList == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList.size())
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList.get(i);
        int j = localSmallYellowItem.type.get();
        int m = localSmallYellowItem.id.get();
        int k;
        if (j == 1)
        {
          k = asle.b(m);
          if (k != -1)
          {
            j = k;
            if (k == 250) {
              j = 10;
            }
            if (asle.c(j)) {
              localSmallYellowItem.id.set(j);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(localSmallYellowItem);
          QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo system id overflow index = " + m + ";emId = " + j);
          continue;
          localArrayList.add(localSmallYellowItem);
          QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo system id overflow index = " + m);
          continue;
          if (j == 2)
          {
            k = askx.b(m);
            j = k;
            if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(k)))
            {
              QLog.d("CommonUsedSystemEmojiManager", 2, "updateItemInfo before EMOTIONPANEL_EMOJI_MAP index = " + k);
              j = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k))).intValue();
              QLog.d("CommonUsedSystemEmojiManager", 2, "updateItemInfo after EMOTIONPANEL_EMOJI_MAP index = " + j);
            }
            if (j < 0)
            {
              localArrayList.add(localSmallYellowItem);
              QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo emoji id overflow index = " + m + ";localIndex = " + j);
            }
            else
            {
              localSmallYellowItem.id.set(j);
            }
          }
        }
      }
    } while (localArrayList.size() <= 0);
    paramList.removeAll(localArrayList);
  }
  
  public List<EmosmPb.SmallYellowItem> c()
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject3 = new File(BaseApplicationImpl.sApplication.getFilesDir(), "commonusedSystemEmojiInfoFile_v3_" + BaseApplicationImpl.sApplication.getRuntime().getAccount());
      if (!((File)localObject3).exists())
      {
        QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile file not exists");
        return null;
      }
      localObject3 = bhmi.a((File)localObject3);
      if (localObject3 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "Can not translate pb file to byte");
        return null;
      }
    }
    ??? = new EmosmPb.SubCmd0x13Rsp();
    List localList;
    Object localObject4;
    int j;
    EmosmPb.SmallYellowItem localSmallYellowItem;
    int m;
    label315:
    int i;
    for (;;)
    {
      int n;
      try
      {
        ((EmosmPb.SubCmd0x13Rsp)???).mergeFrom(arrayOfByte);
        localList = ((EmosmPb.SubCmd0x13Rsp)???).itemlist.get();
        localObject4 = new ArrayList();
        ??? = new ArrayList();
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        j = 0;
        if (j >= localList.size()) {
          break;
        }
        localObject5 = (EmosmPb.SmallYellowItem)localList.get(j);
        localSmallYellowItem = new EmosmPb.SmallYellowItem();
        localSmallYellowItem.ts.set(((EmosmPb.SmallYellowItem)localObject5).ts.get());
        localSmallYellowItem.type.set(((EmosmPb.SmallYellowItem)localObject5).type.get());
        n = ((EmosmPb.SmallYellowItem)localObject5).type.get();
        m = ((EmosmPb.SmallYellowItem)localObject5).id.get();
        if (n != 1) {
          break label371;
        }
        if (asle.c(m)) {
          break label756;
        }
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile type = system, id error, id = " + m);
      }
      catch (Exception localException)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile mergeFromBody exception e = " + localException.getMessage());
        return null;
      }
      localSmallYellowItem.id.set(i);
      ((List)localObject4).add(localSmallYellowItem);
      break label749;
      label371:
      i = m;
      if (n == 2)
      {
        if (!askx.a(m))
        {
          QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile type = emoji, id error, id = " + m);
          break label749;
        }
        i = m;
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(m)))
        {
          QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile before EMOTIONPANEL_EMOJI_MAP index = " + m);
          i = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m))).intValue();
          QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile after EMOTIONPANEL_EMOJI_MAP index = " + i);
        }
      }
    }
    Object localObject5 = b();
    if ((localList != null) && (localList.size() > 0)) {
      i = k;
    }
    for (;;)
    {
      if (i < localList.size())
      {
        localSmallYellowItem = (EmosmPb.SmallYellowItem)localList.get(i);
        k = localSmallYellowItem.type.get();
        j = localSmallYellowItem.id.get();
        if (k == 1)
        {
          k = asle.a(j);
          if (k >= 0)
          {
            if (j == 10) {}
            localSmallYellowItem.id.set(k);
          }
        }
        for (;;)
        {
          localException.add(localSmallYellowItem);
          break label773;
          QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile system error localId = " + j);
          break label773;
          k = askx.a(j);
          if (k == -1) {
            break;
          }
          localSmallYellowItem.id.set(k);
        }
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile emoji error localId = " + j);
      }
      else
      {
        localList = a((List)localObject4, (List)localObject5);
        localObject4 = b(localList);
        if (localObject4 != null) {
          localList.addAll((Collection)localObject4);
        }
        try
        {
          this.jdField_a_of_type_JavaUtilList = localList;
          return localException;
        }
        finally {}
        label749:
        j += 1;
        break;
        label756:
        i = m;
        if (m != 250) {
          break label315;
        }
        i = 10;
        break label315;
      }
      label773:
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmn
 * JD-Core Version:    0.7.0.1
 */