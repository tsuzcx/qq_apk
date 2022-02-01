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

public class bktf
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile bktf jdField_a_of_type_Bktf;
  private int jdField_a_of_type_Int = 1;
  private bkth jdField_a_of_type_Bkth = new bkth(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache2.dat", 50);
  private bktn jdField_a_of_type_Bktn = new bktn(this, ThreadManager.getFileThreadLooper());
  private bkuu jdField_a_of_type_Bkuu = new bktq(this, null);
  private HashMap<Integer, bkto> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bkto> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public bktf()
  {
    QSecFramework.a(1L, this.jdField_a_of_type_Bkuu);
    bkvm.a("QSec.AVEng", new bktg(this));
  }
  
  private int a(bkto parambkto)
  {
    int j = 16;
    parambkto = parambkto.jdField_a_of_type_Bkud;
    if (parambkto.jdField_a_of_type_JavaLangString != null) {
      j = 16 + parambkto.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (parambkto.jdField_b_of_type_JavaLangString != null) {
      i = j + parambkto.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (parambkto.jdField_c_of_type_JavaLangString != null) {
      j = i + parambkto.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (parambkto.d != null) {
      i = j + parambkto.d.length();
    }
    j = i;
    if (parambkto.e != null) {
      j = i + parambkto.e.length();
    }
    i = j;
    if (parambkto.jdField_a_of_type_ArrayOfByte != null) {
      i = j + parambkto.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  public static bktf a()
  {
    if (jdField_a_of_type_Bktf == null) {}
    try
    {
      if (jdField_a_of_type_Bktf == null) {
        jdField_a_of_type_Bktf = new bktf();
      }
      return jdField_a_of_type_Bktf;
    }
    finally {}
  }
  
  private bkto a(Object paramObject)
  {
    try
    {
      paramObject = (bkto)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<bkto> paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = bksu.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bkto localbkto = (bkto)paramList.next();
        bkud localbkud = localbkto.jdField_a_of_type_Bkud;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localbkto.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.fileType.set(localbkud.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.scenarioType.set(localbkud.jdField_b_of_type_Int);
        localQSecCloudQueryEntry.fileSize.set(localbkud.jdField_c_of_type_Int);
        if (localbkud.jdField_c_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.packageName.set(localbkud.jdField_c_of_type_JavaLangString);
        }
        if (localbkud.jdField_a_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileName.set(localbkud.jdField_a_of_type_JavaLangString);
        }
        if (localbkud.d != null) {
          localQSecCloudQueryEntry.appName.set(localbkud.d);
        }
        if (localbkud.jdField_b_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileMd5.set(localbkud.jdField_b_of_type_JavaLangString);
        }
        if (localbkud.e != null) {
          localQSecCloudQueryEntry.certMd5.set(localbkud.e);
        }
        if (localbkud.jdField_a_of_type_ArrayOfByte != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localbkud.jdField_a_of_type_ArrayOfByte));
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
    bkss.a(2, paramInt);
  }
  
  private void a(int paramInt, bkuf parambkuf)
  {
    bkto localbkto = (bkto)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + parambkuf.toString());
    }
    if (localbkto != null)
    {
      if ((parambkuf.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localbkto.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bkth.a(localbkto.jdField_a_of_type_JavaLangString, parambkuf);
      }
      parambkuf.jdField_a_of_type_Boolean = false;
      a(localbkto, 3, parambkuf);
    }
  }
  
  private void a(bkto parambkto)
  {
    if (parambkto == null) {}
    String str;
    do
    {
      return;
      str = parambkto.jdField_a_of_type_Bkud.a();
      parambkto.jdField_a_of_type_Bkud.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { parambkto.jdField_a_of_type_Bkud.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(bkto parambkto, int paramInt, bkuf parambkuf)
  {
    if (parambkto.jdField_a_of_type_Bkue != null) {
      parambkto.jdField_a_of_type_Bkue.a(paramInt, parambkto.jdField_a_of_type_Bkud, parambkuf);
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
              bkuf localbkuf = new bkuf();
              localbkuf.jdField_a_of_type_Int = m;
              localbkuf.jdField_b_of_type_Int = n;
              localbkuf.jdField_c_of_type_Int = i1;
              localbkuf.d = j;
              if (i != 0) {
                localbkuf.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
              }
              localbkuf.jdField_a_of_type_ArrayOfByte = paramObject;
              a(k, localbkuf);
              break;
              this.jdField_a_of_type_Bkth.a();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void a(List<bkto> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      bkto localbkto = (bkto)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localbkto.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localbkto.jdField_a_of_type_Int), localbkto);
      arrayOfInt[i] = localbkto.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Bktn.sendMessageDelayed(this.jdField_a_of_type_Bktn.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return bkvm.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
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
        localObject = (bkto)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((bkto)localObject).jdField_c_of_type_Int;
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
  
  private void b(bkto parambkto)
  {
    if (parambkto != null)
    {
      parambkto.jdField_a_of_type_JavaLangString = parambkto.jdField_a_of_type_Bkud.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + parambkto.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(parambkto.jdField_a_of_type_JavaLangString))
      {
        bkuf localbkuf = this.jdField_a_of_type_Bkth.a(parambkto.jdField_a_of_type_JavaLangString);
        if (localbkuf != null)
        {
          localbkuf.jdField_a_of_type_Boolean = true;
          a(parambkto, 3, localbkuf);
        }
      }
    }
    else
    {
      return;
    }
    c(parambkto);
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
        bkto localbkto;
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
          localbkto = (bkto)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localbkto == null)
          {
            j += 1;
            continue;
          }
          if (localbkto.jdField_b_of_type_Int >= 1) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localbkto.jdField_b_of_type_Int += 1;
        e(localbkto);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localbkto, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(bkto parambkto)
  {
    if (parambkto != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      parambkto.jdField_a_of_type_Int = i;
      parambkto.jdField_b_of_type_Int = 0;
      e(parambkto);
    }
  }
  
  private void d(bkto parambkto)
  {
    if (parambkto == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { parambkto.toString() }));
    }
    if (TextUtils.isEmpty(parambkto.jdField_a_of_type_Bkud.jdField_b_of_type_JavaLangString))
    {
      a(parambkto);
      if (TextUtils.isEmpty(parambkto.jdField_a_of_type_Bkud.jdField_b_of_type_JavaLangString))
      {
        a(parambkto, 4, null);
        return;
      }
    }
    if (parambkto.jdField_a_of_type_Boolean)
    {
      b(parambkto);
      return;
    }
    c(parambkto);
  }
  
  private void e(bkto parambkto)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(parambkto, 1, null);
    }
    do
    {
      return;
      if (parambkto.jdField_c_of_type_Int == 0) {
        parambkto.jdField_c_of_type_Int = a(parambkto);
      }
      this.jdField_c_of_type_Int += parambkto.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(parambkto);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(parambkto.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((parambkto.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(bkud parambkud, boolean paramBoolean1, boolean paramBoolean2, bkue parambkue)
  {
    if (parambkud == null) {
      return 13;
    }
    bkto localbkto = new bkto(null);
    localbkto.jdField_a_of_type_Boolean = paramBoolean1;
    localbkto.jdField_b_of_type_Boolean = paramBoolean2;
    localbkto.jdField_a_of_type_Bkud = parambkud;
    localbkto.jdField_a_of_type_Bkue = parambkue;
    if ((parambkud.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(parambkud.jdField_a_of_type_JavaLangString))) {
      parambkud.jdField_c_of_type_Int = ((int)new File(parambkud.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Bktn.sendMessage(this.jdField_a_of_type_Bktn.obtainMessage(1, localbkto));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Bktn.sendMessage(this.jdField_a_of_type_Bktn.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktf
 * JD-Core Version:    0.7.0.1
 */