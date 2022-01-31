import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController.1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class bbvg
{
  protected int a;
  protected long a;
  protected final aqxx a;
  public final bbvh a;
  protected Map<String, bbvi> a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  protected int d;
  protected int e = 3;
  protected int f = 3;
  protected int g = 3;
  protected int h = 30;
  
  public bbvg(QQAppInterface paramQQAppInterface, String paramString, long paramLong, bbvh parambbvh)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Aqxx = new aqxx(paramQQAppInterface, paramString);
    this.jdField_a_of_type_Bbvh = parambbvh;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public bbvg(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString, long paramLong, boolean paramBoolean, bbvh parambbvh)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Aqxx = new aqxx(paramQQAppInterface, paramList, paramString);
    if (paramBoolean) {
      this.jdField_a_of_type_Aqxx.a(true);
    }
    this.jdField_a_of_type_Bbvh = parambbvh;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    int i = 0;
    int j = 1;
    Object localObject1 = null;
    for (;;)
    {
      String str = this.jdField_a_of_type_Aqxx.a();
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_JavaUtilMap.put(str, new bbvi(this));
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = str;
        }
        bbvl.c("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] retryContrller init:" + str);
        localObject1 = localObject2;
        i += 1;
      }
      while ((j == 0) || (i >= 4))
      {
        return localObject1;
        j = 0;
      }
    }
  }
  
  protected String a(String paramString, int paramInt, boolean paramBoolean)
  {
    bbvi localbbvi;
    try
    {
      localbbvi = (bbvi)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localbbvi == null)
      {
        bbvl.a("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] selectUrl err. not find strErrUrl. urlCont:" + this.jdField_a_of_type_JavaUtilMap.size());
        paramString = null;
      }
      for (;;)
      {
        return paramString;
        if (((9056 != paramInt) && (!paramBoolean)) || (localbbvi.jdField_a_of_type_Int >= this.e)) {
          break;
        }
        a(localbbvi, paramInt, paramBoolean);
        bbvl.c("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] selectUrl:" + paramString + localbbvi.toString() + " eof err or serr, use cur errurl");
      }
      localObject1 = new bbvi(this);
    }
    finally {}
    Object localObject1;
    ((bbvi)localObject1).jdField_a_of_type_Int = 2147483647;
    ((bbvi)localObject1).jdField_b_of_type_Int = 2147483647;
    ((bbvi)localObject1).c = 2147483647;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    Object localObject2 = null;
    label216:
    Object localObject3;
    while (localIterator.hasNext())
    {
      Object localObject4 = (Map.Entry)localIterator.next();
      localObject3 = (String)((Map.Entry)localObject4).getKey();
      localObject4 = (bbvi)((Map.Entry)localObject4).getValue();
      bbvl.c("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "]" + (String)localObject3 + " <->" + ((bbvi)localObject4).toString());
      if (!paramString.equalsIgnoreCase((String)localObject3))
      {
        if (((bbvi)localObject4).jdField_a_of_type_Int >= ((bbvi)localObject1).jdField_a_of_type_Int) {
          break label580;
        }
        localObject2 = localObject4;
        localObject1 = localObject3;
        break label592;
      }
    }
    if ((localObject2 == null) || (((bbvi)localObject1).jdField_a_of_type_Int >= this.e)) {
      if (localObject2 == null)
      {
        bbvl.b("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] no next url use cur errurl");
        break label607;
      }
    }
    for (;;)
    {
      if (((bbvi)localObject1).jdField_a_of_type_Int < this.e)
      {
        a((bbvi)localObject1, paramInt, paramBoolean);
        bbvl.c("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] selectUrl:" + paramString + ((bbvi)localObject1).toString());
        break;
        bbvl.b("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] minurl retry over, use cur errurl. minRetryUrl:" + localObject2 + ((bbvi)localObject1).toString());
        break label607;
      }
      this.jdField_a_of_type_Boolean = true;
      bbvl.a("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] all retry over and fail");
      paramString = null;
      break;
      paramString = localObject2;
      continue;
      label580:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      label592:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label216;
      label607:
      localObject1 = localbbvi;
    }
  }
  
  public void a()
  {
    this.e = 3;
    this.f = 3;
    this.g = 0;
    this.h = 5;
  }
  
  protected void a(bbvi parambbvi, int paramInt, boolean paramBoolean)
  {
    if (9056 == paramInt)
    {
      if (parambbvi.jdField_b_of_type_Int < this.f)
      {
        parambbvi.jdField_b_of_type_Int += 1;
        return;
      }
      parambbvi.jdField_b_of_type_Int = 0;
      parambbvi.jdField_a_of_type_Int += 1;
      this.jdField_b_of_type_Int += 1;
      return;
    }
    if (paramBoolean)
    {
      if (parambbvi.c < this.g)
      {
        parambbvi.c += 1;
        return;
      }
      parambbvi.c = 0;
      parambbvi.jdField_a_of_type_Int += 1;
      this.jdField_b_of_type_Int += 1;
      return;
    }
    parambbvi.jdField_a_of_type_Int += 1;
    this.jdField_b_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      bbvi localbbvi;
      try
      {
        localbbvi = (bbvi)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if (localbbvi == null) {
          return;
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          localbbvi.a();
          this.jdField_a_of_type_JavaUtilMap.clear();
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localbbvi);
          bbvl.c("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] data conned. lockedUseThisUrl:" + paramString);
          continue;
        }
        if (this.d > this.h) {
          continue;
        }
      }
      finally {}
      localbbvi.a();
      this.d += 1;
      bbvl.c("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] data conned. resetRetryInfo. resetcount:" + this.d);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bbvh == null)
    {
      bbvl.a("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr fail. sink=null");
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      bbvl.a("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr fail. strErrUrl=null");
      return false;
    }
    String str = a(paramString, paramInt, paramBoolean);
    if (TextUtils.isEmpty(str))
    {
      bbvl.a("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr fail. all retry over or has err. errCode:" + paramInt + " bSvrErr:" + paramBoolean + " ReportR:" + this.jdField_a_of_type_Int + "UrlChgedT:" + this.c + " strErrUrl:" + paramString);
      return false;
    }
    long l = 100L;
    if (9056 != paramInt) {
      l = this.jdField_a_of_type_Bbvh.b();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new TroopFileTransferRetryController.1(this, str), l);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int += 1;
    if (!paramString.equalsIgnoreCase(str)) {
      this.c += 1;
    }
    bbvl.c("TroopFileTransferRetryController", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr suc, delay:" + l + " errCode:" + paramInt + " bSvrErr:" + paramBoolean + " strErrUrl:" + paramString + " selectUrl:" + str + " ReportR:" + this.jdField_a_of_type_Int + "UrlChgedT:" + this.c);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvg
 * JD-Core Version:    0.7.0.1
 */