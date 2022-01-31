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

public class bfid
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile bfid jdField_a_of_type_Bfid;
  private int jdField_a_of_type_Int = 1;
  private bfif jdField_a_of_type_Bfif = new bfif(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache2.dat", 50);
  private bfil jdField_a_of_type_Bfil = new bfil(this, ThreadManager.getFileThreadLooper());
  private bfjs jdField_a_of_type_Bfjs = new bfio(this, null);
  private HashMap<Integer, bfim> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bfim> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public bfid()
  {
    QSecFramework.a(1L, this.jdField_a_of_type_Bfjs);
    bfkk.a("QSec.AVEng", new bfie(this));
  }
  
  private int a(bfim parambfim)
  {
    int j = 16;
    parambfim = parambfim.jdField_a_of_type_Bfjb;
    if (parambfim.jdField_a_of_type_JavaLangString != null) {
      j = 16 + parambfim.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (parambfim.jdField_b_of_type_JavaLangString != null) {
      i = j + parambfim.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (parambfim.jdField_c_of_type_JavaLangString != null) {
      j = i + parambfim.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (parambfim.d != null) {
      i = j + parambfim.d.length();
    }
    j = i;
    if (parambfim.e != null) {
      j = i + parambfim.e.length();
    }
    i = j;
    if (parambfim.jdField_a_of_type_ArrayOfByte != null) {
      i = j + parambfim.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  public static bfid a()
  {
    if (jdField_a_of_type_Bfid == null) {}
    try
    {
      if (jdField_a_of_type_Bfid == null) {
        jdField_a_of_type_Bfid = new bfid();
      }
      return jdField_a_of_type_Bfid;
    }
    finally {}
  }
  
  private bfim a(Object paramObject)
  {
    try
    {
      paramObject = (bfim)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<bfim> paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = bfhs.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bfim localbfim = (bfim)paramList.next();
        bfjb localbfjb = localbfim.jdField_a_of_type_Bfjb;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localbfim.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.fileType.set(localbfjb.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.scenarioType.set(localbfjb.jdField_b_of_type_Int);
        localQSecCloudQueryEntry.fileSize.set(localbfjb.jdField_c_of_type_Int);
        if (localbfjb.jdField_c_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.packageName.set(localbfjb.jdField_c_of_type_JavaLangString);
        }
        if (localbfjb.jdField_a_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileName.set(localbfjb.jdField_a_of_type_JavaLangString);
        }
        if (localbfjb.d != null) {
          localQSecCloudQueryEntry.appName.set(localbfjb.d);
        }
        if (localbfjb.jdField_b_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileMd5.set(localbfjb.jdField_b_of_type_JavaLangString);
        }
        if (localbfjb.e != null) {
          localQSecCloudQueryEntry.certMd5.set(localbfjb.e);
        }
        if (localbfjb.jdField_a_of_type_ArrayOfByte != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localbfjb.jdField_a_of_type_ArrayOfByte));
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
    bfhq.a(2, paramInt);
  }
  
  private void a(int paramInt, bfjd parambfjd)
  {
    bfim localbfim = (bfim)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + parambfjd.toString());
    }
    if (localbfim != null)
    {
      if ((parambfjd.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localbfim.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bfif.a(localbfim.jdField_a_of_type_JavaLangString, parambfjd);
      }
      parambfjd.jdField_a_of_type_Boolean = false;
      a(localbfim, 3, parambfjd);
    }
  }
  
  private void a(bfim parambfim)
  {
    if (parambfim == null) {}
    String str;
    do
    {
      return;
      str = parambfim.jdField_a_of_type_Bfjb.a();
      parambfim.jdField_a_of_type_Bfjb.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { parambfim.jdField_a_of_type_Bfjb.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(bfim parambfim, int paramInt, bfjd parambfjd)
  {
    if (parambfim.jdField_a_of_type_Bfjc != null) {
      parambfim.jdField_a_of_type_Bfjc.a(paramInt, parambfim.jdField_a_of_type_Bfjb, parambfjd);
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
              bfjd localbfjd = new bfjd();
              localbfjd.jdField_a_of_type_Int = m;
              localbfjd.jdField_b_of_type_Int = n;
              localbfjd.jdField_c_of_type_Int = i1;
              localbfjd.d = j;
              if (i != 0) {
                localbfjd.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
              }
              localbfjd.jdField_a_of_type_ArrayOfByte = paramObject;
              a(k, localbfjd);
              break;
              this.jdField_a_of_type_Bfif.a();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void a(List<bfim> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      bfim localbfim = (bfim)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localbfim.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localbfim.jdField_a_of_type_Int), localbfim);
      arrayOfInt[i] = localbfim.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Bfil.sendMessageDelayed(this.jdField_a_of_type_Bfil.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return bfkk.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
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
        localObject = (bfim)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((bfim)localObject).jdField_c_of_type_Int;
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
  
  private void b(bfim parambfim)
  {
    if (parambfim != null)
    {
      parambfim.jdField_a_of_type_JavaLangString = parambfim.jdField_a_of_type_Bfjb.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + parambfim.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(parambfim.jdField_a_of_type_JavaLangString))
      {
        bfjd localbfjd = this.jdField_a_of_type_Bfif.a(parambfim.jdField_a_of_type_JavaLangString);
        if (localbfjd != null)
        {
          localbfjd.jdField_a_of_type_Boolean = true;
          a(parambfim, 3, localbfjd);
        }
      }
    }
    else
    {
      return;
    }
    c(parambfim);
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
        bfim localbfim;
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
          localbfim = (bfim)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localbfim == null)
          {
            j += 1;
            continue;
          }
          if (localbfim.jdField_b_of_type_Int >= 1) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localbfim.jdField_b_of_type_Int += 1;
        e(localbfim);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localbfim, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(bfim parambfim)
  {
    if (parambfim != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      parambfim.jdField_a_of_type_Int = i;
      parambfim.jdField_b_of_type_Int = 0;
      e(parambfim);
    }
  }
  
  private void d(bfim parambfim)
  {
    if (parambfim == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { parambfim.toString() }));
    }
    if (TextUtils.isEmpty(parambfim.jdField_a_of_type_Bfjb.jdField_b_of_type_JavaLangString))
    {
      a(parambfim);
      if (TextUtils.isEmpty(parambfim.jdField_a_of_type_Bfjb.jdField_b_of_type_JavaLangString))
      {
        a(parambfim, 4, null);
        return;
      }
    }
    if (parambfim.jdField_a_of_type_Boolean)
    {
      b(parambfim);
      return;
    }
    c(parambfim);
  }
  
  private void e(bfim parambfim)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(parambfim, 1, null);
    }
    do
    {
      return;
      if (parambfim.jdField_c_of_type_Int == 0) {
        parambfim.jdField_c_of_type_Int = a(parambfim);
      }
      this.jdField_c_of_type_Int += parambfim.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(parambfim);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(parambfim.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((parambfim.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(bfjb parambfjb, boolean paramBoolean1, boolean paramBoolean2, bfjc parambfjc)
  {
    if (parambfjb == null) {
      return 13;
    }
    bfim localbfim = new bfim(null);
    localbfim.jdField_a_of_type_Boolean = paramBoolean1;
    localbfim.jdField_b_of_type_Boolean = paramBoolean2;
    localbfim.jdField_a_of_type_Bfjb = parambfjb;
    localbfim.jdField_a_of_type_Bfjc = parambfjc;
    if ((parambfjb.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(parambfjb.jdField_a_of_type_JavaLangString))) {
      parambfjb.jdField_c_of_type_Int = ((int)new File(parambfjb.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Bfil.sendMessage(this.jdField_a_of_type_Bfil.obtainMessage(1, localbfim));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Bfil.sendMessage(this.jdField_a_of_type_Bfil.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfid
 * JD-Core Version:    0.7.0.1
 */