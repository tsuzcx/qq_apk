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

public class bdzw
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile bdzw jdField_a_of_type_Bdzw;
  private int jdField_a_of_type_Int = 1;
  private bdzy jdField_a_of_type_Bdzy = new bdzy(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache2.dat", 50);
  private beae jdField_a_of_type_Beae = new beae(this, ThreadManager.getFileThreadLooper());
  private bebl jdField_a_of_type_Bebl = new beah(this, null);
  private HashMap<Integer, beaf> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<beaf> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public bdzw()
  {
    QSecFramework.a(1, this.jdField_a_of_type_Bebl);
    becd.a("QSec.AVEng", new bdzx(this));
  }
  
  private int a(beaf parambeaf)
  {
    int j = 16;
    parambeaf = parambeaf.jdField_a_of_type_Beau;
    if (parambeaf.jdField_a_of_type_JavaLangString != null) {
      j = 16 + parambeaf.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (parambeaf.jdField_b_of_type_JavaLangString != null) {
      i = j + parambeaf.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (parambeaf.jdField_c_of_type_JavaLangString != null) {
      j = i + parambeaf.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (parambeaf.d != null) {
      i = j + parambeaf.d.length();
    }
    j = i;
    if (parambeaf.e != null) {
      j = i + parambeaf.e.length();
    }
    i = j;
    if (parambeaf.jdField_a_of_type_ArrayOfByte != null) {
      i = j + parambeaf.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  public static bdzw a()
  {
    if (jdField_a_of_type_Bdzw == null) {}
    try
    {
      if (jdField_a_of_type_Bdzw == null) {
        jdField_a_of_type_Bdzw = new bdzw();
      }
      return jdField_a_of_type_Bdzw;
    }
    finally {}
  }
  
  private beaf a(Object paramObject)
  {
    try
    {
      paramObject = (beaf)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<beaf> paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = bdzl.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        beaf localbeaf = (beaf)paramList.next();
        beau localbeau = localbeaf.jdField_a_of_type_Beau;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localbeaf.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.fileType.set(localbeau.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.scenarioType.set(localbeau.jdField_b_of_type_Int);
        localQSecCloudQueryEntry.fileSize.set(localbeau.jdField_c_of_type_Int);
        if (localbeau.jdField_c_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.packageName.set(localbeau.jdField_c_of_type_JavaLangString);
        }
        if (localbeau.jdField_a_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileName.set(localbeau.jdField_a_of_type_JavaLangString);
        }
        if (localbeau.d != null) {
          localQSecCloudQueryEntry.appName.set(localbeau.d);
        }
        if (localbeau.jdField_b_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileMd5.set(localbeau.jdField_b_of_type_JavaLangString);
        }
        if (localbeau.e != null) {
          localQSecCloudQueryEntry.certMd5.set(localbeau.e);
        }
        if (localbeau.jdField_a_of_type_ArrayOfByte != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localbeau.jdField_a_of_type_ArrayOfByte));
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
    bdzj.a(2, paramInt);
  }
  
  private void a(int paramInt, beaw parambeaw)
  {
    beaf localbeaf = (beaf)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + parambeaw.toString());
    }
    if (localbeaf != null)
    {
      if ((parambeaw.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localbeaf.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bdzy.a(localbeaf.jdField_a_of_type_JavaLangString, parambeaw);
      }
      parambeaw.jdField_a_of_type_Boolean = false;
      a(localbeaf, 3, parambeaw);
    }
  }
  
  private void a(beaf parambeaf)
  {
    if (parambeaf == null) {}
    String str;
    do
    {
      return;
      str = parambeaf.jdField_a_of_type_Beau.a();
      parambeaf.jdField_a_of_type_Beau.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { parambeaf.jdField_a_of_type_Beau.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(beaf parambeaf, int paramInt, beaw parambeaw)
  {
    if (parambeaf.jdField_a_of_type_Beav != null) {
      parambeaf.jdField_a_of_type_Beav.a(paramInt, parambeaf.jdField_a_of_type_Beau, parambeaw);
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
              beaw localbeaw = new beaw();
              localbeaw.jdField_a_of_type_Int = m;
              localbeaw.jdField_b_of_type_Int = n;
              localbeaw.jdField_c_of_type_Int = i1;
              localbeaw.d = j;
              if (i != 0) {
                localbeaw.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
              }
              localbeaw.jdField_a_of_type_ArrayOfByte = paramObject;
              a(k, localbeaw);
              break;
              this.jdField_a_of_type_Bdzy.a();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void a(List<beaf> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      beaf localbeaf = (beaf)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localbeaf.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localbeaf.jdField_a_of_type_Int), localbeaf);
      arrayOfInt[i] = localbeaf.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Beae.sendMessageDelayed(this.jdField_a_of_type_Beae.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return becd.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
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
        localObject = (beaf)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((beaf)localObject).jdField_c_of_type_Int;
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
  
  private void b(beaf parambeaf)
  {
    if (parambeaf != null)
    {
      parambeaf.jdField_a_of_type_JavaLangString = parambeaf.jdField_a_of_type_Beau.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + parambeaf.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(parambeaf.jdField_a_of_type_JavaLangString))
      {
        beaw localbeaw = this.jdField_a_of_type_Bdzy.a(parambeaf.jdField_a_of_type_JavaLangString);
        if (localbeaw != null)
        {
          localbeaw.jdField_a_of_type_Boolean = true;
          a(parambeaf, 3, localbeaw);
        }
      }
    }
    else
    {
      return;
    }
    c(parambeaf);
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
        beaf localbeaf;
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
          localbeaf = (beaf)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localbeaf == null)
          {
            j += 1;
            continue;
          }
          if (localbeaf.jdField_b_of_type_Int >= 1) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localbeaf.jdField_b_of_type_Int += 1;
        e(localbeaf);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localbeaf, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(beaf parambeaf)
  {
    if (parambeaf != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      parambeaf.jdField_a_of_type_Int = i;
      parambeaf.jdField_b_of_type_Int = 0;
      e(parambeaf);
    }
  }
  
  private void d(beaf parambeaf)
  {
    if (parambeaf == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { parambeaf.toString() }));
    }
    if (TextUtils.isEmpty(parambeaf.jdField_a_of_type_Beau.jdField_b_of_type_JavaLangString))
    {
      a(parambeaf);
      if (TextUtils.isEmpty(parambeaf.jdField_a_of_type_Beau.jdField_b_of_type_JavaLangString))
      {
        a(parambeaf, 4, null);
        return;
      }
    }
    if (parambeaf.jdField_a_of_type_Boolean)
    {
      b(parambeaf);
      return;
    }
    c(parambeaf);
  }
  
  private void e(beaf parambeaf)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(parambeaf, 1, null);
    }
    do
    {
      return;
      if (parambeaf.jdField_c_of_type_Int == 0) {
        parambeaf.jdField_c_of_type_Int = a(parambeaf);
      }
      this.jdField_c_of_type_Int += parambeaf.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(parambeaf);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(parambeaf.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((parambeaf.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(beau parambeau, boolean paramBoolean1, boolean paramBoolean2, beav parambeav)
  {
    if (parambeau == null) {
      return 13;
    }
    beaf localbeaf = new beaf(null);
    localbeaf.jdField_a_of_type_Boolean = paramBoolean1;
    localbeaf.jdField_b_of_type_Boolean = paramBoolean2;
    localbeaf.jdField_a_of_type_Beau = parambeau;
    localbeaf.jdField_a_of_type_Beav = parambeav;
    if ((parambeau.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(parambeau.jdField_a_of_type_JavaLangString))) {
      parambeau.jdField_c_of_type_Int = ((int)new File(parambeau.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Beae.sendMessage(this.jdField_a_of_type_Beae.obtainMessage(1, localbeaf));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Beae.sendMessage(this.jdField_a_of_type_Beae.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdzw
 * JD-Core Version:    0.7.0.1
 */