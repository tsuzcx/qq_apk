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

public class bfma
{
  protected int a;
  protected long a;
  protected final atmh a;
  public final bfmb a;
  protected Map<String, bfmc> a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  protected int d;
  protected int e = 3;
  protected int f = 3;
  protected int g = 3;
  protected int h = 30;
  
  public bfma(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString, long paramLong, boolean paramBoolean, bfmb parambfmb)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Atmh = new atmh(paramQQAppInterface, paramList, paramString);
    if (paramBoolean) {
      this.jdField_a_of_type_Atmh.a(true);
    }
    this.jdField_a_of_type_Bfmb = parambfmb;
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
      String str = this.jdField_a_of_type_Atmh.a();
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_JavaUtilMap.put(str, new bfmc(this));
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = str;
        }
        bfmf.c("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] retryContrller init:" + str);
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
    bfmc localbfmc;
    try
    {
      localbfmc = (bfmc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localbfmc == null)
      {
        bfmf.a("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] selectUrl err. not find strErrUrl. urlCont:" + this.jdField_a_of_type_JavaUtilMap.size());
        paramString = null;
      }
      for (;;)
      {
        return paramString;
        if (((9056 != paramInt) && (!paramBoolean)) || (localbfmc.jdField_a_of_type_Int >= this.e)) {
          break;
        }
        a(localbfmc, paramInt, paramBoolean);
        bfmf.c("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] selectUrl:" + paramString + localbfmc.toString() + " eof err or serr, use cur errurl");
      }
      localObject1 = new bfmc(this);
    }
    finally {}
    Object localObject1;
    ((bfmc)localObject1).jdField_a_of_type_Int = 2147483647;
    ((bfmc)localObject1).jdField_b_of_type_Int = 2147483647;
    ((bfmc)localObject1).c = 2147483647;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    Object localObject2 = null;
    label216:
    Object localObject3;
    while (localIterator.hasNext())
    {
      Object localObject4 = (Map.Entry)localIterator.next();
      localObject3 = (String)((Map.Entry)localObject4).getKey();
      localObject4 = (bfmc)((Map.Entry)localObject4).getValue();
      bfmf.c("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "]" + (String)localObject3 + " <->" + ((bfmc)localObject4).toString());
      if (!paramString.equalsIgnoreCase((String)localObject3))
      {
        if (((bfmc)localObject4).jdField_a_of_type_Int >= ((bfmc)localObject1).jdField_a_of_type_Int) {
          break label580;
        }
        localObject2 = localObject4;
        localObject1 = localObject3;
        break label592;
      }
    }
    if ((localObject2 == null) || (((bfmc)localObject1).jdField_a_of_type_Int >= this.e)) {
      if (localObject2 == null)
      {
        bfmf.b("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] no next url use cur errurl");
        break label607;
      }
    }
    for (;;)
    {
      if (((bfmc)localObject1).jdField_a_of_type_Int < this.e)
      {
        a((bfmc)localObject1, paramInt, paramBoolean);
        bfmf.c("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] selectUrl:" + paramString + ((bfmc)localObject1).toString());
        break;
        bfmf.b("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] minurl retry over, use cur errurl. minRetryUrl:" + localObject2 + ((bfmc)localObject1).toString());
        break label607;
      }
      this.jdField_a_of_type_Boolean = true;
      bfmf.a("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] all retry over and fail");
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
      localObject1 = localbfmc;
    }
  }
  
  public void a()
  {
    this.e = 3;
    this.f = 3;
    this.g = 0;
    this.h = 5;
  }
  
  protected void a(bfmc parambfmc, int paramInt, boolean paramBoolean)
  {
    if (9056 == paramInt)
    {
      if (parambfmc.jdField_b_of_type_Int < this.f)
      {
        parambfmc.jdField_b_of_type_Int += 1;
        return;
      }
      parambfmc.jdField_b_of_type_Int = 0;
      parambfmc.jdField_a_of_type_Int += 1;
      this.jdField_b_of_type_Int += 1;
      return;
    }
    if (paramBoolean)
    {
      if (parambfmc.c < this.g)
      {
        parambfmc.c += 1;
        return;
      }
      parambfmc.c = 0;
      parambfmc.jdField_a_of_type_Int += 1;
      this.jdField_b_of_type_Int += 1;
      return;
    }
    parambfmc.jdField_a_of_type_Int += 1;
    this.jdField_b_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      bfmc localbfmc;
      try
      {
        localbfmc = (bfmc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if (localbfmc == null) {
          return;
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          localbfmc.a();
          this.jdField_a_of_type_JavaUtilMap.clear();
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localbfmc);
          bfmf.c("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] data conned. lockedUseThisUrl:" + paramString);
          continue;
        }
        if (this.d > this.h) {
          continue;
        }
      }
      finally {}
      localbfmc.a();
      this.d += 1;
      bfmf.c("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] data conned. resetRetryInfo. resetcount:" + this.d);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bfmb == null)
    {
      bfmf.a("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr fail. sink=null");
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      bfmf.a("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr fail. strErrUrl=null");
      return false;
    }
    String str = a(paramString, paramInt, paramBoolean);
    if (TextUtils.isEmpty(str))
    {
      bfmf.a("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr fail. all retry over or has err. errCode:" + paramInt + " bSvrErr:" + paramBoolean + " ReportR:" + this.jdField_a_of_type_Int + "UrlChgedT:" + this.c + " strErrUrl:" + paramString);
      return false;
    }
    long l = 100L;
    if (9056 != paramInt) {
      l = this.jdField_a_of_type_Bfmb.b();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new TroopFileTransferRetryController.1(this, str), l);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int += 1;
    if (!paramString.equalsIgnoreCase(str)) {
      this.c += 1;
    }
    bfmf.c("TroopFileTransferRetryController", bfmf.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr suc, delay:" + l + " errCode:" + paramInt + " bSvrErr:" + paramBoolean + " strErrUrl:" + paramString + " selectUrl:" + str + " ReportR:" + this.jdField_a_of_type_Int + "UrlChgedT:" + this.c);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfma
 * JD-Core Version:    0.7.0.1
 */