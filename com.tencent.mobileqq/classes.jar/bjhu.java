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

public class bjhu
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile bjhu jdField_a_of_type_Bjhu;
  private int jdField_a_of_type_Int = 1;
  private bjhw jdField_a_of_type_Bjhw = new bjhw(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache2.dat", 50);
  private bjic jdField_a_of_type_Bjic = new bjic(this, ThreadManager.getFileThreadLooper());
  private bjjj jdField_a_of_type_Bjjj = new bjif(this, null);
  private HashMap<Integer, bjid> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bjid> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public bjhu()
  {
    QSecFramework.a(1L, this.jdField_a_of_type_Bjjj);
    bjkb.a("QSec.AVEng", new bjhv(this));
  }
  
  private int a(bjid parambjid)
  {
    int j = 16;
    parambjid = parambjid.jdField_a_of_type_Bjis;
    if (parambjid.jdField_a_of_type_JavaLangString != null) {
      j = 16 + parambjid.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (parambjid.jdField_b_of_type_JavaLangString != null) {
      i = j + parambjid.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (parambjid.jdField_c_of_type_JavaLangString != null) {
      j = i + parambjid.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (parambjid.d != null) {
      i = j + parambjid.d.length();
    }
    j = i;
    if (parambjid.e != null) {
      j = i + parambjid.e.length();
    }
    i = j;
    if (parambjid.jdField_a_of_type_ArrayOfByte != null) {
      i = j + parambjid.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  public static bjhu a()
  {
    if (jdField_a_of_type_Bjhu == null) {}
    try
    {
      if (jdField_a_of_type_Bjhu == null) {
        jdField_a_of_type_Bjhu = new bjhu();
      }
      return jdField_a_of_type_Bjhu;
    }
    finally {}
  }
  
  private bjid a(Object paramObject)
  {
    try
    {
      paramObject = (bjid)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<bjid> paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = bjhj.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bjid localbjid = (bjid)paramList.next();
        bjis localbjis = localbjid.jdField_a_of_type_Bjis;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localbjid.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.fileType.set(localbjis.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.scenarioType.set(localbjis.jdField_b_of_type_Int);
        localQSecCloudQueryEntry.fileSize.set(localbjis.jdField_c_of_type_Int);
        if (localbjis.jdField_c_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.packageName.set(localbjis.jdField_c_of_type_JavaLangString);
        }
        if (localbjis.jdField_a_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileName.set(localbjis.jdField_a_of_type_JavaLangString);
        }
        if (localbjis.d != null) {
          localQSecCloudQueryEntry.appName.set(localbjis.d);
        }
        if (localbjis.jdField_b_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileMd5.set(localbjis.jdField_b_of_type_JavaLangString);
        }
        if (localbjis.e != null) {
          localQSecCloudQueryEntry.certMd5.set(localbjis.e);
        }
        if (localbjis.jdField_a_of_type_ArrayOfByte != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localbjis.jdField_a_of_type_ArrayOfByte));
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
    bjhh.a(2, paramInt);
  }
  
  private void a(int paramInt, bjiu parambjiu)
  {
    bjid localbjid = (bjid)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + parambjiu.toString());
    }
    if (localbjid != null)
    {
      if ((parambjiu.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localbjid.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bjhw.a(localbjid.jdField_a_of_type_JavaLangString, parambjiu);
      }
      parambjiu.jdField_a_of_type_Boolean = false;
      a(localbjid, 3, parambjiu);
    }
  }
  
  private void a(bjid parambjid)
  {
    if (parambjid == null) {}
    String str;
    do
    {
      return;
      str = parambjid.jdField_a_of_type_Bjis.a();
      parambjid.jdField_a_of_type_Bjis.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { parambjid.jdField_a_of_type_Bjis.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(bjid parambjid, int paramInt, bjiu parambjiu)
  {
    if (parambjid.jdField_a_of_type_Bjit != null) {
      parambjid.jdField_a_of_type_Bjit.a(paramInt, parambjid.jdField_a_of_type_Bjis, parambjiu);
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
              bjiu localbjiu = new bjiu();
              localbjiu.jdField_a_of_type_Int = m;
              localbjiu.jdField_b_of_type_Int = n;
              localbjiu.jdField_c_of_type_Int = i1;
              localbjiu.d = j;
              if (i != 0) {
                localbjiu.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
              }
              localbjiu.jdField_a_of_type_ArrayOfByte = paramObject;
              a(k, localbjiu);
              break;
              this.jdField_a_of_type_Bjhw.a();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void a(List<bjid> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      bjid localbjid = (bjid)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localbjid.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localbjid.jdField_a_of_type_Int), localbjid);
      arrayOfInt[i] = localbjid.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Bjic.sendMessageDelayed(this.jdField_a_of_type_Bjic.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return bjkb.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
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
        localObject = (bjid)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((bjid)localObject).jdField_c_of_type_Int;
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
  
  private void b(bjid parambjid)
  {
    if (parambjid != null)
    {
      parambjid.jdField_a_of_type_JavaLangString = parambjid.jdField_a_of_type_Bjis.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + parambjid.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(parambjid.jdField_a_of_type_JavaLangString))
      {
        bjiu localbjiu = this.jdField_a_of_type_Bjhw.a(parambjid.jdField_a_of_type_JavaLangString);
        if (localbjiu != null)
        {
          localbjiu.jdField_a_of_type_Boolean = true;
          a(parambjid, 3, localbjiu);
        }
      }
    }
    else
    {
      return;
    }
    c(parambjid);
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
        bjid localbjid;
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
          localbjid = (bjid)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localbjid == null)
          {
            j += 1;
            continue;
          }
          if (localbjid.jdField_b_of_type_Int >= 1) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localbjid.jdField_b_of_type_Int += 1;
        e(localbjid);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localbjid, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(bjid parambjid)
  {
    if (parambjid != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      parambjid.jdField_a_of_type_Int = i;
      parambjid.jdField_b_of_type_Int = 0;
      e(parambjid);
    }
  }
  
  private void d(bjid parambjid)
  {
    if (parambjid == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { parambjid.toString() }));
    }
    if (TextUtils.isEmpty(parambjid.jdField_a_of_type_Bjis.jdField_b_of_type_JavaLangString))
    {
      a(parambjid);
      if (TextUtils.isEmpty(parambjid.jdField_a_of_type_Bjis.jdField_b_of_type_JavaLangString))
      {
        a(parambjid, 4, null);
        return;
      }
    }
    if (parambjid.jdField_a_of_type_Boolean)
    {
      b(parambjid);
      return;
    }
    c(parambjid);
  }
  
  private void e(bjid parambjid)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(parambjid, 1, null);
    }
    do
    {
      return;
      if (parambjid.jdField_c_of_type_Int == 0) {
        parambjid.jdField_c_of_type_Int = a(parambjid);
      }
      this.jdField_c_of_type_Int += parambjid.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(parambjid);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(parambjid.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((parambjid.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(bjis parambjis, boolean paramBoolean1, boolean paramBoolean2, bjit parambjit)
  {
    if (parambjis == null) {
      return 13;
    }
    bjid localbjid = new bjid(null);
    localbjid.jdField_a_of_type_Boolean = paramBoolean1;
    localbjid.jdField_b_of_type_Boolean = paramBoolean2;
    localbjid.jdField_a_of_type_Bjis = parambjis;
    localbjid.jdField_a_of_type_Bjit = parambjit;
    if ((parambjis.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(parambjis.jdField_a_of_type_JavaLangString))) {
      parambjis.jdField_c_of_type_Int = ((int)new File(parambjis.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Bjic.sendMessage(this.jdField_a_of_type_Bjic.obtainMessage(1, localbjid));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Bjic.sendMessage(this.jdField_a_of_type_Bjic.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjhu
 * JD-Core Version:    0.7.0.1
 */