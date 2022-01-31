import android.text.TextUtils;
import com.tencent.ims.QQProtectCommon.QQProtectQueryHead;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQuery;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQueryBody;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQueryEntry;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespBody;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespEntry;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.ICloudAVEngine;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;

public class bhne
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile bhne jdField_a_of_type_Bhne;
  private int jdField_a_of_type_Int = 1;
  private bhng jdField_a_of_type_Bhng = new bhng(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache2.dat", 50);
  private bhnm jdField_a_of_type_Bhnm = new bhnm(this, ThreadManager.getFileThreadLooper());
  private bhot jdField_a_of_type_Bhot = new bhnp(this, null);
  private HashMap<Integer, bhnn> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bhnn> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public bhne()
  {
    QSecFramework.a(1L, this.jdField_a_of_type_Bhot);
    bhpl.a("QSec.AVEng", new bhnf(this));
  }
  
  private int a(bhnn parambhnn)
  {
    int j = 16;
    parambhnn = parambhnn.jdField_a_of_type_Bhoc;
    if (parambhnn.jdField_a_of_type_JavaLangString != null) {
      j = 16 + parambhnn.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (parambhnn.jdField_b_of_type_JavaLangString != null) {
      i = j + parambhnn.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (parambhnn.jdField_c_of_type_JavaLangString != null) {
      j = i + parambhnn.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (parambhnn.d != null) {
      i = j + parambhnn.d.length();
    }
    j = i;
    if (parambhnn.e != null) {
      j = i + parambhnn.e.length();
    }
    i = j;
    if (parambhnn.jdField_a_of_type_ArrayOfByte != null) {
      i = j + parambhnn.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  public static bhne a()
  {
    if (jdField_a_of_type_Bhne == null) {}
    try
    {
      if (jdField_a_of_type_Bhne == null) {
        jdField_a_of_type_Bhne = new bhne();
      }
      return jdField_a_of_type_Bhne;
    }
    finally {}
  }
  
  private bhnn a(Object paramObject)
  {
    try
    {
      paramObject = (bhnn)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<bhnn> paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = bhmt.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bhnn localbhnn = (bhnn)paramList.next();
        bhoc localbhoc = localbhnn.jdField_a_of_type_Bhoc;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localbhnn.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.fileType.set(localbhoc.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.scenarioType.set(localbhoc.jdField_b_of_type_Int);
        localQSecCloudQueryEntry.fileSize.set(localbhoc.jdField_c_of_type_Int);
        if (localbhoc.jdField_c_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.packageName.set(localbhoc.jdField_c_of_type_JavaLangString);
        }
        if (localbhoc.jdField_a_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileName.set(localbhoc.jdField_a_of_type_JavaLangString);
        }
        if (localbhoc.d != null) {
          localQSecCloudQueryEntry.appName.set(localbhoc.d);
        }
        if (localbhoc.jdField_b_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileMd5.set(localbhoc.jdField_b_of_type_JavaLangString);
        }
        if (localbhoc.e != null) {
          localQSecCloudQueryEntry.certMd5.set(localbhoc.e);
        }
        if (localbhoc.jdField_a_of_type_ArrayOfByte != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localbhoc.jdField_a_of_type_ArrayOfByte));
        }
        localQSecCloudQueryBody.queryEntry.add(localQSecCloudQueryEntry);
      }
      paramList = new QSecCloudAVEngineMsg.QSecCloudQuery();
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    paramList.head.set(localQQProtectQueryHead);
    paramList.body.set(localQSecCloudQueryBody);
    return paramList;
  }
  
  private void a()
  {
    this.d += 1;
    if (this.d >= 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Rpt to %d", new Object[] { Integer.valueOf(this.d) }));
      }
      this.d = 0;
      a(1);
    }
  }
  
  private void a(int paramInt)
  {
    bhmr.a(2, paramInt);
  }
  
  private void a(int paramInt, bhoe parambhoe)
  {
    bhnn localbhnn = (bhnn)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + parambhoe.toString());
    }
    if (localbhnn != null)
    {
      if ((parambhoe.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localbhnn.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bhng.a(localbhnn.jdField_a_of_type_JavaLangString, parambhoe);
      }
      parambhoe.jdField_a_of_type_Boolean = false;
      a(localbhnn, 3, parambhoe);
    }
  }
  
  private void a(bhnn parambhnn)
  {
    if (parambhnn == null) {}
    String str;
    do
    {
      return;
      str = parambhnn.jdField_a_of_type_Bhoc.a();
      parambhnn.jdField_a_of_type_Bhoc.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { parambhnn.jdField_a_of_type_Bhoc.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(bhnn parambhnn, int paramInt, bhoe parambhoe)
  {
    if (parambhnn.jdField_a_of_type_Bhod != null) {
      parambhnn.jdField_a_of_type_Bhod.a(paramInt, parambhnn.jdField_a_of_type_Bhoc, parambhoe);
    }
  }
  
  private void a(Object paramObject)
  {
    int i;
    label398:
    do
    {
      int j;
      try
      {
        paramObject = (QSecCloudAVEngineMsg.QSecCloudRespBody)paramObject;
        j = -1;
        i = j;
        if (paramObject.status == null) {
          continue;
        }
        i = j;
        if (!paramObject.status.has()) {
          continue;
        }
        i = paramObject.status.get();
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if ((paramObject.version != null) && (paramObject.version.has())) {}
      for (i = paramObject.version.get(); (i == 1) && (paramObject.respEntry != null); i = 0)
      {
        paramObject = paramObject.respEntry.get();
        if (paramObject == null) {
          break;
        }
        Iterator localIterator = paramObject.iterator();
        int k;
        int m;
        int n;
        int i1;
        while (localIterator.hasNext())
        {
          paramObject = (QSecCloudAVEngineMsg.QSecCloudRespEntry)localIterator.next();
          if ((paramObject.entryId != null) && (paramObject.entryId.has()))
          {
            k = paramObject.entryId.get();
            if ((paramObject.attrType != null) && (paramObject.attrType.has()))
            {
              m = paramObject.attrType.get();
              if ((paramObject.category != null) && (paramObject.category.has()))
              {
                n = paramObject.category.get();
                if ((paramObject.subCategory != null) && (paramObject.subCategory.has()))
                {
                  i1 = paramObject.subCategory.get();
                  if ((paramObject.timeToLive == null) || (!paramObject.timeToLive.has())) {
                    break label398;
                  }
                }
              }
            }
          }
        }
        for (i = paramObject.timeToLive.get();; i = 0)
        {
          if ((paramObject.actionType != null) && (paramObject.actionType.has())) {}
          for (j = paramObject.actionType.get();; j = 0)
          {
            if (paramObject.extraInfo != null)
            {
              paramObject = paramObject.extraInfo.get();
              if (paramObject == null) {}
            }
            for (paramObject = paramObject.toByteArray();; paramObject = null)
            {
              bhoe localbhoe = new bhoe();
              localbhoe.jdField_a_of_type_Int = m;
              localbhoe.jdField_b_of_type_Int = n;
              localbhoe.jdField_c_of_type_Int = i1;
              localbhoe.d = j;
              if (i != 0) {
                localbhoe.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
              }
              localbhoe.jdField_a_of_type_ArrayOfByte = paramObject;
              a(k, localbhoe);
              break;
              this.jdField_a_of_type_Bhng.a();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void a(List<bhnn> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      bhnn localbhnn = (bhnn)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localbhnn.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localbhnn.jdField_a_of_type_Int), localbhnn);
      arrayOfInt[i] = localbhnn.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Bhnm.sendMessageDelayed(this.jdField_a_of_type_Bhnm.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return bhpl.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
  }
  
  private void b()
  {
    LinkedList localLinkedList = new LinkedList();
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i < k) {}
      try
      {
        localObject = (bhnn)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((bhnn)localObject).jdField_c_of_type_Int;
        if (m + j > 1000)
        {
          localObject = a(localLinkedList);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QSec.AVEngine", 2, String.format("Pack size: %d, count: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localLinkedList.size()) }));
            }
            a(localLinkedList);
            a((QSecCloudAVEngineMsg.QSecCloudQuery)localObject);
          }
          this.jdField_c_of_type_Int -= j;
          this.jdField_b_of_type_Int -= localLinkedList.size();
          localLinkedList.clear();
          i -= 1;
          j = 0;
        }
        else
        {
          localLinkedList.add(localObject);
          j += m;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_Int = 0;
        localException.printStackTrace();
        return;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      if (localLinkedList.size() == 0) {
        break;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, String.format("Commit Left (%d:%d)", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) }));
        }
        localObject = a(localLinkedList);
        if (localObject != null)
        {
          a(localLinkedList);
          a((QSecCloudAVEngineMsg.QSecCloudQuery)localObject);
        }
        this.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_Int = 0;
        return;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(localLinkedList);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QSec.AVEngine", 2, String.format("Has %d(count: %d) left.", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(localLinkedList.size()) }));
      return;
      i += 1;
    }
  }
  
  private void b(bhnn parambhnn)
  {
    if (parambhnn != null)
    {
      parambhnn.jdField_a_of_type_JavaLangString = parambhnn.jdField_a_of_type_Bhoc.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + parambhnn.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(parambhnn.jdField_a_of_type_JavaLangString))
      {
        bhoe localbhoe = this.jdField_a_of_type_Bhng.a(parambhnn.jdField_a_of_type_JavaLangString);
        if (localbhoe != null)
        {
          localbhoe.jdField_a_of_type_Boolean = true;
          a(parambhnn, 3, localbhoe);
        }
      }
    }
    else
    {
      return;
    }
    c(parambhnn);
  }
  
  private void b(Object paramObject)
  {
    if (paramObject == null) {}
    int i;
    label133:
    do
    {
      return;
      for (;;)
      {
        int m;
        bhnn localbhnn;
        try
        {
          paramObject = (int[])paramObject;
          int k = paramObject.length;
          int j = 0;
          i = 0;
          if (j >= k) {
            break;
          }
          m = paramObject[j];
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Timeout entry id:" + m);
          }
          localbhnn = (bhnn)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localbhnn == null)
          {
            j += 1;
            continue;
          }
          if (localbhnn.jdField_b_of_type_Int >= 1) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localbhnn.jdField_b_of_type_Int += 1;
        e(localbhnn);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localbhnn, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(bhnn parambhnn)
  {
    if (parambhnn != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      parambhnn.jdField_a_of_type_Int = i;
      parambhnn.jdField_b_of_type_Int = 0;
      e(parambhnn);
    }
  }
  
  private void d(bhnn parambhnn)
  {
    if (parambhnn == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { parambhnn.toString() }));
    }
    if (TextUtils.isEmpty(parambhnn.jdField_a_of_type_Bhoc.jdField_b_of_type_JavaLangString))
    {
      a(parambhnn);
      if (TextUtils.isEmpty(parambhnn.jdField_a_of_type_Bhoc.jdField_b_of_type_JavaLangString))
      {
        a(parambhnn, 4, null);
        return;
      }
    }
    if (parambhnn.jdField_a_of_type_Boolean)
    {
      b(parambhnn);
      return;
    }
    c(parambhnn);
  }
  
  private void e(bhnn parambhnn)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(parambhnn, 1, null);
    }
    do
    {
      return;
      if (parambhnn.jdField_c_of_type_Int == 0) {
        parambhnn.jdField_c_of_type_Int = a(parambhnn);
      }
      this.jdField_c_of_type_Int += parambhnn.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(parambhnn);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(parambhnn.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((parambhnn.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(bhoc parambhoc, boolean paramBoolean1, boolean paramBoolean2, bhod parambhod)
  {
    if (parambhoc == null) {
      return 13;
    }
    bhnn localbhnn = new bhnn(null);
    localbhnn.jdField_a_of_type_Boolean = paramBoolean1;
    localbhnn.jdField_b_of_type_Boolean = paramBoolean2;
    localbhnn.jdField_a_of_type_Bhoc = parambhoc;
    localbhnn.jdField_a_of_type_Bhod = parambhod;
    if ((parambhoc.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(parambhoc.jdField_a_of_type_JavaLangString))) {
      parambhoc.jdField_c_of_type_Int = ((int)new File(parambhoc.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Bhnm.sendMessage(this.jdField_a_of_type_Bhnm.obtainMessage(1, localbhnn));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Bhnm.sendMessage(this.jdField_a_of_type_Bhnm.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhne
 * JD-Core Version:    0.7.0.1
 */