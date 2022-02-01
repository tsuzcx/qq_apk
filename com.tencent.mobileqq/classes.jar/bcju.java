import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.search.rich.ArkAppModule.1;
import com.tencent.mobileqq.search.rich.ArkAppModule.2;
import java.lang.ref.WeakReference;

public class bcju
  extends apsl
{
  private WeakReference<bcjv> a;
  
  public bcju(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
  }
  
  private int a(ark.VariantWrapper paramVariantWrapper, int paramInt)
  {
    if (paramVariantWrapper == null) {}
    int i;
    do
    {
      return paramInt;
      i = paramVariantWrapper.GetType();
      if (i == 4) {
        return (int)paramVariantWrapper.GetDouble();
      }
    } while (i != 3);
    return paramVariantWrapper.GetInt();
  }
  
  private long a(ark.VariantWrapper paramVariantWrapper, long paramLong)
  {
    if (paramVariantWrapper == null) {}
    int i;
    do
    {
      return paramLong;
      i = paramVariantWrapper.GetType();
      if (i == 4) {
        return paramVariantWrapper.GetDouble();
      }
    } while (i != 3);
    return paramVariantWrapper.GetInt();
  }
  
  private String a(ark.VariantWrapper paramVariantWrapper, String paramString)
  {
    if (paramVariantWrapper == null) {}
    int i;
    do
    {
      return paramString;
      i = paramVariantWrapper.GetType();
      if (i == 5) {
        return paramVariantWrapper.GetString();
      }
    } while (i != 6);
    return paramVariantWrapper.GetTableAsJsonString();
  }
  
  public void Destruct()
  {
    super.Destruct();
  }
  
  public String GetTypeName()
  {
    return "QQSearch";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("Report")) {}
    do
    {
      return true;
      if (paramString.equals("GetContainerInfo")) {
        return false;
      }
    } while ((paramString.equals("SetTalkBackText")) || (paramString.equals("Notify")));
    return false;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!a(paramString)) {}
    do
    {
      return false;
      if (paramString.equals("Report")) {
        return a(paramArrayOfVariantWrapper, paramVariantWrapper);
      }
      if (paramString.equals("SetTalkBackText")) {
        return b(paramArrayOfVariantWrapper, paramVariantWrapper);
      }
    } while (!paramString.equals("Notify"));
    return c(paramArrayOfVariantWrapper, paramVariantWrapper);
  }
  
  public void a(bcjv parambcjv)
  {
    this.a = new WeakReference(parambcjv);
  }
  
  protected boolean a(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return false;
    }
    String str = localQQAppInterface.getCurrentAccountUin();
    paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
    Object localObject1 = paramArrayOfVariantWrapper[1].GetString();
    int i = 0;
    int j = 0;
    long l1 = 0L;
    long l2 = 0L;
    Object localObject3 = "";
    Object localObject2 = "";
    int k = 0;
    Object localObject4;
    int m;
    long l3;
    if (k < paramArrayOfVariantWrapper.length) {
      if (k == 0)
      {
        localObject4 = paramArrayOfVariantWrapper[0].GetString();
        m = j;
        paramVariantWrapper = (ark.VariantWrapper)localObject1;
        localObject1 = localObject4;
        l3 = l2;
        l2 = l1;
        l1 = l3;
        j = i;
        i = m;
      }
    }
    for (;;)
    {
      m = k + 1;
      l3 = l2;
      k = i;
      i = j;
      localObject4 = paramVariantWrapper;
      paramVariantWrapper = (ark.VariantWrapper)localObject1;
      localObject1 = localObject4;
      j = k;
      l2 = l1;
      l1 = l3;
      k = m;
      break;
      if (k == 1)
      {
        localObject1 = paramArrayOfVariantWrapper[1].GetString();
        m = i;
        localObject4 = paramVariantWrapper;
        l3 = l1;
        i = j;
        j = m;
        l1 = l2;
        l2 = l3;
        paramVariantWrapper = (ark.VariantWrapper)localObject1;
        localObject1 = localObject4;
      }
      else if (k == 2)
      {
        m = a(paramArrayOfVariantWrapper[2], 0);
        i = j;
        j = m;
        localObject4 = paramVariantWrapper;
        l3 = l1;
        l1 = l2;
        l2 = l3;
        paramVariantWrapper = (ark.VariantWrapper)localObject1;
        localObject1 = localObject4;
      }
      else if (k == 3)
      {
        m = a(paramArrayOfVariantWrapper[3], 0);
        j = i;
        localObject4 = paramVariantWrapper;
        l3 = l1;
        i = m;
        l1 = l2;
        l2 = l3;
        paramVariantWrapper = (ark.VariantWrapper)localObject1;
        localObject1 = localObject4;
      }
      else if (k == 4)
      {
        l3 = a(paramArrayOfVariantWrapper[4], 0L);
        m = i;
        localObject4 = paramVariantWrapper;
        l1 = l2;
        i = j;
        j = m;
        l2 = l3;
        paramVariantWrapper = (ark.VariantWrapper)localObject1;
        localObject1 = localObject4;
      }
      else if (k == 5)
      {
        l3 = a(paramArrayOfVariantWrapper[5], 0L);
        m = i;
        l2 = l1;
        localObject4 = paramVariantWrapper;
        l1 = l3;
        i = j;
        j = m;
        paramVariantWrapper = (ark.VariantWrapper)localObject1;
        localObject1 = localObject4;
      }
      else if (k == 6)
      {
        localObject4 = paramArrayOfVariantWrapper[6].GetString();
        m = i;
        localObject3 = paramVariantWrapper;
        l3 = l1;
        i = j;
        j = m;
        l1 = l2;
        l2 = l3;
        paramVariantWrapper = (ark.VariantWrapper)localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
      }
      else if (k == 7)
      {
        localObject4 = paramArrayOfVariantWrapper[7].GetString();
        m = i;
        localObject2 = paramVariantWrapper;
        l3 = l1;
        i = j;
        j = m;
        l1 = l2;
        l2 = l3;
        paramVariantWrapper = (ark.VariantWrapper)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        continue;
        bdla.b(localQQAppInterface, "CliOper", "", str, paramVariantWrapper, (String)localObject1, i, j, String.valueOf(l1), String.valueOf(l2), (String)localObject3, (String)localObject2);
        return true;
      }
      else
      {
        m = i;
        localObject4 = paramVariantWrapper;
        l3 = l1;
        i = j;
        j = m;
        l1 = l2;
        l2 = l3;
        paramVariantWrapper = (ark.VariantWrapper)localObject1;
        localObject1 = localObject4;
      }
    }
  }
  
  protected apsr[] a()
  {
    return null;
  }
  
  protected boolean b(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && (paramArrayOfVariantWrapper[1].IsView()))
    {
      paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
      long l = paramArrayOfVariantWrapper[1].GetView();
      ArkAppCenter.a().postToMainThread(new ArkAppModule.1(this, l, paramVariantWrapper));
    }
    return true;
  }
  
  protected boolean c(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length > 3) && (paramArrayOfVariantWrapper[1].IsString()) && (paramArrayOfVariantWrapper[3].IsView()))
    {
      paramVariantWrapper = paramArrayOfVariantWrapper[1].GetString();
      String str = a(paramArrayOfVariantWrapper[2], null);
      long l = paramArrayOfVariantWrapper[3].GetView();
      ArkAppCenter.a().postToMainThread(new ArkAppModule.2(this, l, paramVariantWrapper, str));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcju
 * JD-Core Version:    0.7.0.1
 */