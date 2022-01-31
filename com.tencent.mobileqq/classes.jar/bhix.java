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

public class bhix
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile bhix jdField_a_of_type_Bhix;
  private int jdField_a_of_type_Int = 1;
  private bhiz jdField_a_of_type_Bhiz = new bhiz(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache2.dat", 50);
  private bhjf jdField_a_of_type_Bhjf = new bhjf(this, ThreadManager.getFileThreadLooper());
  private bhkm jdField_a_of_type_Bhkm = new bhji(this, null);
  private HashMap<Integer, bhjg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bhjg> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public bhix()
  {
    QSecFramework.a(1L, this.jdField_a_of_type_Bhkm);
    bhle.a("QSec.AVEng", new bhiy(this));
  }
  
  private int a(bhjg parambhjg)
  {
    int j = 16;
    parambhjg = parambhjg.jdField_a_of_type_Bhjv;
    if (parambhjg.jdField_a_of_type_JavaLangString != null) {
      j = 16 + parambhjg.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (parambhjg.jdField_b_of_type_JavaLangString != null) {
      i = j + parambhjg.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (parambhjg.jdField_c_of_type_JavaLangString != null) {
      j = i + parambhjg.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (parambhjg.d != null) {
      i = j + parambhjg.d.length();
    }
    j = i;
    if (parambhjg.e != null) {
      j = i + parambhjg.e.length();
    }
    i = j;
    if (parambhjg.jdField_a_of_type_ArrayOfByte != null) {
      i = j + parambhjg.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  public static bhix a()
  {
    if (jdField_a_of_type_Bhix == null) {}
    try
    {
      if (jdField_a_of_type_Bhix == null) {
        jdField_a_of_type_Bhix = new bhix();
      }
      return jdField_a_of_type_Bhix;
    }
    finally {}
  }
  
  private bhjg a(Object paramObject)
  {
    try
    {
      paramObject = (bhjg)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<bhjg> paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = bhim.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bhjg localbhjg = (bhjg)paramList.next();
        bhjv localbhjv = localbhjg.jdField_a_of_type_Bhjv;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localbhjg.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.fileType.set(localbhjv.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.scenarioType.set(localbhjv.jdField_b_of_type_Int);
        localQSecCloudQueryEntry.fileSize.set(localbhjv.jdField_c_of_type_Int);
        if (localbhjv.jdField_c_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.packageName.set(localbhjv.jdField_c_of_type_JavaLangString);
        }
        if (localbhjv.jdField_a_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileName.set(localbhjv.jdField_a_of_type_JavaLangString);
        }
        if (localbhjv.d != null) {
          localQSecCloudQueryEntry.appName.set(localbhjv.d);
        }
        if (localbhjv.jdField_b_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileMd5.set(localbhjv.jdField_b_of_type_JavaLangString);
        }
        if (localbhjv.e != null) {
          localQSecCloudQueryEntry.certMd5.set(localbhjv.e);
        }
        if (localbhjv.jdField_a_of_type_ArrayOfByte != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localbhjv.jdField_a_of_type_ArrayOfByte));
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
    bhik.a(2, paramInt);
  }
  
  private void a(int paramInt, bhjx parambhjx)
  {
    bhjg localbhjg = (bhjg)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + parambhjx.toString());
    }
    if (localbhjg != null)
    {
      if ((parambhjx.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localbhjg.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bhiz.a(localbhjg.jdField_a_of_type_JavaLangString, parambhjx);
      }
      parambhjx.jdField_a_of_type_Boolean = false;
      a(localbhjg, 3, parambhjx);
    }
  }
  
  private void a(bhjg parambhjg)
  {
    if (parambhjg == null) {}
    String str;
    do
    {
      return;
      str = parambhjg.jdField_a_of_type_Bhjv.a();
      parambhjg.jdField_a_of_type_Bhjv.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { parambhjg.jdField_a_of_type_Bhjv.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(bhjg parambhjg, int paramInt, bhjx parambhjx)
  {
    if (parambhjg.jdField_a_of_type_Bhjw != null) {
      parambhjg.jdField_a_of_type_Bhjw.a(paramInt, parambhjg.jdField_a_of_type_Bhjv, parambhjx);
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
              bhjx localbhjx = new bhjx();
              localbhjx.jdField_a_of_type_Int = m;
              localbhjx.jdField_b_of_type_Int = n;
              localbhjx.jdField_c_of_type_Int = i1;
              localbhjx.d = j;
              if (i != 0) {
                localbhjx.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
              }
              localbhjx.jdField_a_of_type_ArrayOfByte = paramObject;
              a(k, localbhjx);
              break;
              this.jdField_a_of_type_Bhiz.a();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void a(List<bhjg> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      bhjg localbhjg = (bhjg)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localbhjg.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localbhjg.jdField_a_of_type_Int), localbhjg);
      arrayOfInt[i] = localbhjg.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Bhjf.sendMessageDelayed(this.jdField_a_of_type_Bhjf.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return bhle.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
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
        localObject = (bhjg)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((bhjg)localObject).jdField_c_of_type_Int;
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
  
  private void b(bhjg parambhjg)
  {
    if (parambhjg != null)
    {
      parambhjg.jdField_a_of_type_JavaLangString = parambhjg.jdField_a_of_type_Bhjv.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + parambhjg.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(parambhjg.jdField_a_of_type_JavaLangString))
      {
        bhjx localbhjx = this.jdField_a_of_type_Bhiz.a(parambhjg.jdField_a_of_type_JavaLangString);
        if (localbhjx != null)
        {
          localbhjx.jdField_a_of_type_Boolean = true;
          a(parambhjg, 3, localbhjx);
        }
      }
    }
    else
    {
      return;
    }
    c(parambhjg);
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
        bhjg localbhjg;
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
          localbhjg = (bhjg)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localbhjg == null)
          {
            j += 1;
            continue;
          }
          if (localbhjg.jdField_b_of_type_Int >= 1) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localbhjg.jdField_b_of_type_Int += 1;
        e(localbhjg);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localbhjg, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(bhjg parambhjg)
  {
    if (parambhjg != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      parambhjg.jdField_a_of_type_Int = i;
      parambhjg.jdField_b_of_type_Int = 0;
      e(parambhjg);
    }
  }
  
  private void d(bhjg parambhjg)
  {
    if (parambhjg == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { parambhjg.toString() }));
    }
    if (TextUtils.isEmpty(parambhjg.jdField_a_of_type_Bhjv.jdField_b_of_type_JavaLangString))
    {
      a(parambhjg);
      if (TextUtils.isEmpty(parambhjg.jdField_a_of_type_Bhjv.jdField_b_of_type_JavaLangString))
      {
        a(parambhjg, 4, null);
        return;
      }
    }
    if (parambhjg.jdField_a_of_type_Boolean)
    {
      b(parambhjg);
      return;
    }
    c(parambhjg);
  }
  
  private void e(bhjg parambhjg)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(parambhjg, 1, null);
    }
    do
    {
      return;
      if (parambhjg.jdField_c_of_type_Int == 0) {
        parambhjg.jdField_c_of_type_Int = a(parambhjg);
      }
      this.jdField_c_of_type_Int += parambhjg.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(parambhjg);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(parambhjg.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((parambhjg.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(bhjv parambhjv, boolean paramBoolean1, boolean paramBoolean2, bhjw parambhjw)
  {
    if (parambhjv == null) {
      return 13;
    }
    bhjg localbhjg = new bhjg(null);
    localbhjg.jdField_a_of_type_Boolean = paramBoolean1;
    localbhjg.jdField_b_of_type_Boolean = paramBoolean2;
    localbhjg.jdField_a_of_type_Bhjv = parambhjv;
    localbhjg.jdField_a_of_type_Bhjw = parambhjw;
    if ((parambhjv.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(parambhjv.jdField_a_of_type_JavaLangString))) {
      parambhjv.jdField_c_of_type_Int = ((int)new File(parambhjv.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Bhjf.sendMessage(this.jdField_a_of_type_Bhjf.obtainMessage(1, localbhjg));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Bhjf.sendMessage(this.jdField_a_of_type_Bhjf.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhix
 * JD-Core Version:    0.7.0.1
 */