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

public class bfhm
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile bfhm jdField_a_of_type_Bfhm;
  private int jdField_a_of_type_Int = 1;
  private bfho jdField_a_of_type_Bfho = new bfho(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache2.dat", 50);
  private bfhu jdField_a_of_type_Bfhu = new bfhu(this, ThreadManager.getFileThreadLooper());
  private bfjb jdField_a_of_type_Bfjb = new bfhx(this, null);
  private HashMap<Integer, bfhv> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bfhv> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public bfhm()
  {
    QSecFramework.a(1L, this.jdField_a_of_type_Bfjb);
    bfjt.a("QSec.AVEng", new bfhn(this));
  }
  
  private int a(bfhv parambfhv)
  {
    int j = 16;
    parambfhv = parambfhv.jdField_a_of_type_Bfik;
    if (parambfhv.jdField_a_of_type_JavaLangString != null) {
      j = 16 + parambfhv.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (parambfhv.jdField_b_of_type_JavaLangString != null) {
      i = j + parambfhv.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (parambfhv.jdField_c_of_type_JavaLangString != null) {
      j = i + parambfhv.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (parambfhv.d != null) {
      i = j + parambfhv.d.length();
    }
    j = i;
    if (parambfhv.e != null) {
      j = i + parambfhv.e.length();
    }
    i = j;
    if (parambfhv.jdField_a_of_type_ArrayOfByte != null) {
      i = j + parambfhv.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  public static bfhm a()
  {
    if (jdField_a_of_type_Bfhm == null) {}
    try
    {
      if (jdField_a_of_type_Bfhm == null) {
        jdField_a_of_type_Bfhm = new bfhm();
      }
      return jdField_a_of_type_Bfhm;
    }
    finally {}
  }
  
  private bfhv a(Object paramObject)
  {
    try
    {
      paramObject = (bfhv)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<bfhv> paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = bfhb.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bfhv localbfhv = (bfhv)paramList.next();
        bfik localbfik = localbfhv.jdField_a_of_type_Bfik;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localbfhv.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.fileType.set(localbfik.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.scenarioType.set(localbfik.jdField_b_of_type_Int);
        localQSecCloudQueryEntry.fileSize.set(localbfik.jdField_c_of_type_Int);
        if (localbfik.jdField_c_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.packageName.set(localbfik.jdField_c_of_type_JavaLangString);
        }
        if (localbfik.jdField_a_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileName.set(localbfik.jdField_a_of_type_JavaLangString);
        }
        if (localbfik.d != null) {
          localQSecCloudQueryEntry.appName.set(localbfik.d);
        }
        if (localbfik.jdField_b_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileMd5.set(localbfik.jdField_b_of_type_JavaLangString);
        }
        if (localbfik.e != null) {
          localQSecCloudQueryEntry.certMd5.set(localbfik.e);
        }
        if (localbfik.jdField_a_of_type_ArrayOfByte != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localbfik.jdField_a_of_type_ArrayOfByte));
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
    bfgz.a(2, paramInt);
  }
  
  private void a(int paramInt, bfim parambfim)
  {
    bfhv localbfhv = (bfhv)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + parambfim.toString());
    }
    if (localbfhv != null)
    {
      if ((parambfim.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localbfhv.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bfho.a(localbfhv.jdField_a_of_type_JavaLangString, parambfim);
      }
      parambfim.jdField_a_of_type_Boolean = false;
      a(localbfhv, 3, parambfim);
    }
  }
  
  private void a(bfhv parambfhv)
  {
    if (parambfhv == null) {}
    String str;
    do
    {
      return;
      str = parambfhv.jdField_a_of_type_Bfik.a();
      parambfhv.jdField_a_of_type_Bfik.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { parambfhv.jdField_a_of_type_Bfik.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(bfhv parambfhv, int paramInt, bfim parambfim)
  {
    if (parambfhv.jdField_a_of_type_Bfil != null) {
      parambfhv.jdField_a_of_type_Bfil.a(paramInt, parambfhv.jdField_a_of_type_Bfik, parambfim);
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
              bfim localbfim = new bfim();
              localbfim.jdField_a_of_type_Int = m;
              localbfim.jdField_b_of_type_Int = n;
              localbfim.jdField_c_of_type_Int = i1;
              localbfim.d = j;
              if (i != 0) {
                localbfim.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
              }
              localbfim.jdField_a_of_type_ArrayOfByte = paramObject;
              a(k, localbfim);
              break;
              this.jdField_a_of_type_Bfho.a();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void a(List<bfhv> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      bfhv localbfhv = (bfhv)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localbfhv.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localbfhv.jdField_a_of_type_Int), localbfhv);
      arrayOfInt[i] = localbfhv.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Bfhu.sendMessageDelayed(this.jdField_a_of_type_Bfhu.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return bfjt.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
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
        localObject = (bfhv)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((bfhv)localObject).jdField_c_of_type_Int;
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
  
  private void b(bfhv parambfhv)
  {
    if (parambfhv != null)
    {
      parambfhv.jdField_a_of_type_JavaLangString = parambfhv.jdField_a_of_type_Bfik.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + parambfhv.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(parambfhv.jdField_a_of_type_JavaLangString))
      {
        bfim localbfim = this.jdField_a_of_type_Bfho.a(parambfhv.jdField_a_of_type_JavaLangString);
        if (localbfim != null)
        {
          localbfim.jdField_a_of_type_Boolean = true;
          a(parambfhv, 3, localbfim);
        }
      }
    }
    else
    {
      return;
    }
    c(parambfhv);
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
        bfhv localbfhv;
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
          localbfhv = (bfhv)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localbfhv == null)
          {
            j += 1;
            continue;
          }
          if (localbfhv.jdField_b_of_type_Int >= 1) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localbfhv.jdField_b_of_type_Int += 1;
        e(localbfhv);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localbfhv, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(bfhv parambfhv)
  {
    if (parambfhv != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      parambfhv.jdField_a_of_type_Int = i;
      parambfhv.jdField_b_of_type_Int = 0;
      e(parambfhv);
    }
  }
  
  private void d(bfhv parambfhv)
  {
    if (parambfhv == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { parambfhv.toString() }));
    }
    if (TextUtils.isEmpty(parambfhv.jdField_a_of_type_Bfik.jdField_b_of_type_JavaLangString))
    {
      a(parambfhv);
      if (TextUtils.isEmpty(parambfhv.jdField_a_of_type_Bfik.jdField_b_of_type_JavaLangString))
      {
        a(parambfhv, 4, null);
        return;
      }
    }
    if (parambfhv.jdField_a_of_type_Boolean)
    {
      b(parambfhv);
      return;
    }
    c(parambfhv);
  }
  
  private void e(bfhv parambfhv)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(parambfhv, 1, null);
    }
    do
    {
      return;
      if (parambfhv.jdField_c_of_type_Int == 0) {
        parambfhv.jdField_c_of_type_Int = a(parambfhv);
      }
      this.jdField_c_of_type_Int += parambfhv.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(parambfhv);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(parambfhv.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((parambfhv.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(bfik parambfik, boolean paramBoolean1, boolean paramBoolean2, bfil parambfil)
  {
    if (parambfik == null) {
      return 13;
    }
    bfhv localbfhv = new bfhv(null);
    localbfhv.jdField_a_of_type_Boolean = paramBoolean1;
    localbfhv.jdField_b_of_type_Boolean = paramBoolean2;
    localbfhv.jdField_a_of_type_Bfik = parambfik;
    localbfhv.jdField_a_of_type_Bfil = parambfil;
    if ((parambfik.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(parambfik.jdField_a_of_type_JavaLangString))) {
      parambfik.jdField_c_of_type_Int = ((int)new File(parambfik.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Bfhu.sendMessage(this.jdField_a_of_type_Bfhu.obtainMessage(1, localbfhv));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Bfhu.sendMessage(this.jdField_a_of_type_Bfhu.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfhm
 * JD-Core Version:    0.7.0.1
 */