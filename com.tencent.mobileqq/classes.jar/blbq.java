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

public class blbq
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile blbq jdField_a_of_type_Blbq;
  private int jdField_a_of_type_Int = 1;
  private blbs jdField_a_of_type_Blbs = new blbs(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache2.dat", 50);
  private blby jdField_a_of_type_Blby = new blby(this, ThreadManager.getFileThreadLooper());
  private bldf jdField_a_of_type_Bldf = new blcb(this, null);
  private HashMap<Integer, blbz> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<blbz> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public blbq()
  {
    QSecFramework.a(1L, this.jdField_a_of_type_Bldf);
    bldx.a("QSec.AVEng", new blbr(this));
  }
  
  private int a(blbz paramblbz)
  {
    int j = 16;
    paramblbz = paramblbz.jdField_a_of_type_Blco;
    if (paramblbz.jdField_a_of_type_JavaLangString != null) {
      j = 16 + paramblbz.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (paramblbz.jdField_b_of_type_JavaLangString != null) {
      i = j + paramblbz.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (paramblbz.jdField_c_of_type_JavaLangString != null) {
      j = i + paramblbz.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (paramblbz.d != null) {
      i = j + paramblbz.d.length();
    }
    j = i;
    if (paramblbz.e != null) {
      j = i + paramblbz.e.length();
    }
    i = j;
    if (paramblbz.jdField_a_of_type_ArrayOfByte != null) {
      i = j + paramblbz.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  public static blbq a()
  {
    if (jdField_a_of_type_Blbq == null) {}
    try
    {
      if (jdField_a_of_type_Blbq == null) {
        jdField_a_of_type_Blbq = new blbq();
      }
      return jdField_a_of_type_Blbq;
    }
    finally {}
  }
  
  private blbz a(Object paramObject)
  {
    try
    {
      paramObject = (blbz)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<blbz> paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = blbf.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        blbz localblbz = (blbz)paramList.next();
        blco localblco = localblbz.jdField_a_of_type_Blco;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localblbz.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.fileType.set(localblco.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.scenarioType.set(localblco.jdField_b_of_type_Int);
        localQSecCloudQueryEntry.fileSize.set(localblco.jdField_c_of_type_Int);
        if (localblco.jdField_c_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.packageName.set(localblco.jdField_c_of_type_JavaLangString);
        }
        if (localblco.jdField_a_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileName.set(localblco.jdField_a_of_type_JavaLangString);
        }
        if (localblco.d != null) {
          localQSecCloudQueryEntry.appName.set(localblco.d);
        }
        if (localblco.jdField_b_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileMd5.set(localblco.jdField_b_of_type_JavaLangString);
        }
        if (localblco.e != null) {
          localQSecCloudQueryEntry.certMd5.set(localblco.e);
        }
        if (localblco.jdField_a_of_type_ArrayOfByte != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localblco.jdField_a_of_type_ArrayOfByte));
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
    blbd.a(2, paramInt);
  }
  
  private void a(int paramInt, blcq paramblcq)
  {
    blbz localblbz = (blbz)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + paramblcq.toString());
    }
    if (localblbz != null)
    {
      if ((paramblcq.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localblbz.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Blbs.a(localblbz.jdField_a_of_type_JavaLangString, paramblcq);
      }
      paramblcq.jdField_a_of_type_Boolean = false;
      a(localblbz, 3, paramblcq);
    }
  }
  
  private void a(blbz paramblbz)
  {
    if (paramblbz == null) {}
    String str;
    do
    {
      return;
      str = paramblbz.jdField_a_of_type_Blco.a();
      paramblbz.jdField_a_of_type_Blco.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { paramblbz.jdField_a_of_type_Blco.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(blbz paramblbz, int paramInt, blcq paramblcq)
  {
    if (paramblbz.jdField_a_of_type_Blcp != null) {
      paramblbz.jdField_a_of_type_Blcp.a(paramInt, paramblbz.jdField_a_of_type_Blco, paramblcq);
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
              blcq localblcq = new blcq();
              localblcq.jdField_a_of_type_Int = m;
              localblcq.jdField_b_of_type_Int = n;
              localblcq.jdField_c_of_type_Int = i1;
              localblcq.d = j;
              if (i != 0) {
                localblcq.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
              }
              localblcq.jdField_a_of_type_ArrayOfByte = paramObject;
              a(k, localblcq);
              break;
              this.jdField_a_of_type_Blbs.a();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void a(List<blbz> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      blbz localblbz = (blbz)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localblbz.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localblbz.jdField_a_of_type_Int), localblbz);
      arrayOfInt[i] = localblbz.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Blby.sendMessageDelayed(this.jdField_a_of_type_Blby.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return bldx.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
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
        localObject = (blbz)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((blbz)localObject).jdField_c_of_type_Int;
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
  
  private void b(blbz paramblbz)
  {
    if (paramblbz != null)
    {
      paramblbz.jdField_a_of_type_JavaLangString = paramblbz.jdField_a_of_type_Blco.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + paramblbz.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramblbz.jdField_a_of_type_JavaLangString))
      {
        blcq localblcq = this.jdField_a_of_type_Blbs.a(paramblbz.jdField_a_of_type_JavaLangString);
        if (localblcq != null)
        {
          localblcq.jdField_a_of_type_Boolean = true;
          a(paramblbz, 3, localblcq);
        }
      }
    }
    else
    {
      return;
    }
    c(paramblbz);
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
        blbz localblbz;
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
          localblbz = (blbz)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localblbz == null)
          {
            j += 1;
            continue;
          }
          if (localblbz.jdField_b_of_type_Int >= 1) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localblbz.jdField_b_of_type_Int += 1;
        e(localblbz);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localblbz, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(blbz paramblbz)
  {
    if (paramblbz != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      paramblbz.jdField_a_of_type_Int = i;
      paramblbz.jdField_b_of_type_Int = 0;
      e(paramblbz);
    }
  }
  
  private void d(blbz paramblbz)
  {
    if (paramblbz == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { paramblbz.toString() }));
    }
    if (TextUtils.isEmpty(paramblbz.jdField_a_of_type_Blco.jdField_b_of_type_JavaLangString))
    {
      a(paramblbz);
      if (TextUtils.isEmpty(paramblbz.jdField_a_of_type_Blco.jdField_b_of_type_JavaLangString))
      {
        a(paramblbz, 4, null);
        return;
      }
    }
    if (paramblbz.jdField_a_of_type_Boolean)
    {
      b(paramblbz);
      return;
    }
    c(paramblbz);
  }
  
  private void e(blbz paramblbz)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(paramblbz, 1, null);
    }
    do
    {
      return;
      if (paramblbz.jdField_c_of_type_Int == 0) {
        paramblbz.jdField_c_of_type_Int = a(paramblbz);
      }
      this.jdField_c_of_type_Int += paramblbz.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(paramblbz);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(paramblbz.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((paramblbz.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(blco paramblco, boolean paramBoolean1, boolean paramBoolean2, blcp paramblcp)
  {
    if (paramblco == null) {
      return 13;
    }
    blbz localblbz = new blbz(null);
    localblbz.jdField_a_of_type_Boolean = paramBoolean1;
    localblbz.jdField_b_of_type_Boolean = paramBoolean2;
    localblbz.jdField_a_of_type_Blco = paramblco;
    localblbz.jdField_a_of_type_Blcp = paramblcp;
    if ((paramblco.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramblco.jdField_a_of_type_JavaLangString))) {
      paramblco.jdField_c_of_type_Int = ((int)new File(paramblco.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Blby.sendMessage(this.jdField_a_of_type_Blby.obtainMessage(1, localblbz));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Blby.sendMessage(this.jdField_a_of_type_Blby.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbq
 * JD-Core Version:    0.7.0.1
 */