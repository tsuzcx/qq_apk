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

public class bkam
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile bkam jdField_a_of_type_Bkam;
  private int jdField_a_of_type_Int = 1;
  private bkao jdField_a_of_type_Bkao = new bkao(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache2.dat", 50);
  private bkau jdField_a_of_type_Bkau = new bkau(this, ThreadManager.getFileThreadLooper());
  private bkcb jdField_a_of_type_Bkcb = new bkax(this, null);
  private HashMap<Integer, bkav> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bkav> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public bkam()
  {
    QSecFramework.a(1L, this.jdField_a_of_type_Bkcb);
    bkct.a("QSec.AVEng", new bkan(this));
  }
  
  private int a(bkav parambkav)
  {
    int j = 16;
    parambkav = parambkav.jdField_a_of_type_Bkbk;
    if (parambkav.jdField_a_of_type_JavaLangString != null) {
      j = 16 + parambkav.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (parambkav.jdField_b_of_type_JavaLangString != null) {
      i = j + parambkav.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (parambkav.jdField_c_of_type_JavaLangString != null) {
      j = i + parambkav.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (parambkav.d != null) {
      i = j + parambkav.d.length();
    }
    j = i;
    if (parambkav.e != null) {
      j = i + parambkav.e.length();
    }
    i = j;
    if (parambkav.jdField_a_of_type_ArrayOfByte != null) {
      i = j + parambkav.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  public static bkam a()
  {
    if (jdField_a_of_type_Bkam == null) {}
    try
    {
      if (jdField_a_of_type_Bkam == null) {
        jdField_a_of_type_Bkam = new bkam();
      }
      return jdField_a_of_type_Bkam;
    }
    finally {}
  }
  
  private bkav a(Object paramObject)
  {
    try
    {
      paramObject = (bkav)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<bkav> paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = bkab.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bkav localbkav = (bkav)paramList.next();
        bkbk localbkbk = localbkav.jdField_a_of_type_Bkbk;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localbkav.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.fileType.set(localbkbk.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.scenarioType.set(localbkbk.jdField_b_of_type_Int);
        localQSecCloudQueryEntry.fileSize.set(localbkbk.jdField_c_of_type_Int);
        if (localbkbk.jdField_c_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.packageName.set(localbkbk.jdField_c_of_type_JavaLangString);
        }
        if (localbkbk.jdField_a_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileName.set(localbkbk.jdField_a_of_type_JavaLangString);
        }
        if (localbkbk.d != null) {
          localQSecCloudQueryEntry.appName.set(localbkbk.d);
        }
        if (localbkbk.jdField_b_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileMd5.set(localbkbk.jdField_b_of_type_JavaLangString);
        }
        if (localbkbk.e != null) {
          localQSecCloudQueryEntry.certMd5.set(localbkbk.e);
        }
        if (localbkbk.jdField_a_of_type_ArrayOfByte != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localbkbk.jdField_a_of_type_ArrayOfByte));
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
    bjzz.a(2, paramInt);
  }
  
  private void a(int paramInt, bkbm parambkbm)
  {
    bkav localbkav = (bkav)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + parambkbm.toString());
    }
    if (localbkav != null)
    {
      if ((parambkbm.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localbkav.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bkao.a(localbkav.jdField_a_of_type_JavaLangString, parambkbm);
      }
      parambkbm.jdField_a_of_type_Boolean = false;
      a(localbkav, 3, parambkbm);
    }
  }
  
  private void a(bkav parambkav)
  {
    if (parambkav == null) {}
    String str;
    do
    {
      return;
      str = parambkav.jdField_a_of_type_Bkbk.a();
      parambkav.jdField_a_of_type_Bkbk.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { parambkav.jdField_a_of_type_Bkbk.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(bkav parambkav, int paramInt, bkbm parambkbm)
  {
    if (parambkav.jdField_a_of_type_Bkbl != null) {
      parambkav.jdField_a_of_type_Bkbl.a(paramInt, parambkav.jdField_a_of_type_Bkbk, parambkbm);
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
              bkbm localbkbm = new bkbm();
              localbkbm.jdField_a_of_type_Int = m;
              localbkbm.jdField_b_of_type_Int = n;
              localbkbm.jdField_c_of_type_Int = i1;
              localbkbm.d = j;
              if (i != 0) {
                localbkbm.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
              }
              localbkbm.jdField_a_of_type_ArrayOfByte = paramObject;
              a(k, localbkbm);
              break;
              this.jdField_a_of_type_Bkao.a();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void a(List<bkav> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      bkav localbkav = (bkav)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localbkav.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localbkav.jdField_a_of_type_Int), localbkav);
      arrayOfInt[i] = localbkav.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Bkau.sendMessageDelayed(this.jdField_a_of_type_Bkau.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return bkct.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
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
        localObject = (bkav)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((bkav)localObject).jdField_c_of_type_Int;
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
  
  private void b(bkav parambkav)
  {
    if (parambkav != null)
    {
      parambkav.jdField_a_of_type_JavaLangString = parambkav.jdField_a_of_type_Bkbk.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + parambkav.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(parambkav.jdField_a_of_type_JavaLangString))
      {
        bkbm localbkbm = this.jdField_a_of_type_Bkao.a(parambkav.jdField_a_of_type_JavaLangString);
        if (localbkbm != null)
        {
          localbkbm.jdField_a_of_type_Boolean = true;
          a(parambkav, 3, localbkbm);
        }
      }
    }
    else
    {
      return;
    }
    c(parambkav);
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
        bkav localbkav;
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
          localbkav = (bkav)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localbkav == null)
          {
            j += 1;
            continue;
          }
          if (localbkav.jdField_b_of_type_Int >= 1) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localbkav.jdField_b_of_type_Int += 1;
        e(localbkav);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localbkav, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(bkav parambkav)
  {
    if (parambkav != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      parambkav.jdField_a_of_type_Int = i;
      parambkav.jdField_b_of_type_Int = 0;
      e(parambkav);
    }
  }
  
  private void d(bkav parambkav)
  {
    if (parambkav == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { parambkav.toString() }));
    }
    if (TextUtils.isEmpty(parambkav.jdField_a_of_type_Bkbk.jdField_b_of_type_JavaLangString))
    {
      a(parambkav);
      if (TextUtils.isEmpty(parambkav.jdField_a_of_type_Bkbk.jdField_b_of_type_JavaLangString))
      {
        a(parambkav, 4, null);
        return;
      }
    }
    if (parambkav.jdField_a_of_type_Boolean)
    {
      b(parambkav);
      return;
    }
    c(parambkav);
  }
  
  private void e(bkav parambkav)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(parambkav, 1, null);
    }
    do
    {
      return;
      if (parambkav.jdField_c_of_type_Int == 0) {
        parambkav.jdField_c_of_type_Int = a(parambkav);
      }
      this.jdField_c_of_type_Int += parambkav.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(parambkav);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(parambkav.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((parambkav.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(bkbk parambkbk, boolean paramBoolean1, boolean paramBoolean2, bkbl parambkbl)
  {
    if (parambkbk == null) {
      return 13;
    }
    bkav localbkav = new bkav(null);
    localbkav.jdField_a_of_type_Boolean = paramBoolean1;
    localbkav.jdField_b_of_type_Boolean = paramBoolean2;
    localbkav.jdField_a_of_type_Bkbk = parambkbk;
    localbkav.jdField_a_of_type_Bkbl = parambkbl;
    if ((parambkbk.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(parambkbk.jdField_a_of_type_JavaLangString))) {
      parambkbk.jdField_c_of_type_Int = ((int)new File(parambkbk.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Bkau.sendMessage(this.jdField_a_of_type_Bkau.obtainMessage(1, localbkav));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Bkau.sendMessage(this.jdField_a_of_type_Bkau.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkam
 * JD-Core Version:    0.7.0.1
 */