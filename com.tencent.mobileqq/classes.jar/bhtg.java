import QC.UniBusinessItem;
import QC.UniCheckReq;
import QC.UniCheckRsp;
import android.content.Context;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopnick/shop/adapter/TroopNickAuthRequest;", "Lcom/tencent/mobileqq/vas/troopnick/shop/adapter/IAuthRequest;", "()V", "localAuth", "", "authType", "", "requestAuth", "", "appId", "itemId", "feeType", "listener", "Lcom/tencent/mobileqq/vas/troopnick/shop/adapter/AuthRequest$AuthListener;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhtg
{
  public static final bhth a = new bhth(null);
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext)
  {
    a.a(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, @Nullable bhte parambhte)
  {
    if ((a(paramInt3)) && (parambhte != null))
    {
      parambhte.a(true, null);
      return;
    }
    bhyv localbhyv = new bhyv("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.uniCheck", "stReq", "rsp");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new UniBusinessItem(paramInt1, paramInt2, ""));
    localbhyv.a("uniCheck", (JceStruct)new UniCheckReq(bhyv.a(), localArrayList), (JceStruct)new UniCheckRsp(), (BusinessObserver)new bhti(parambhte), false);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (QQAppInterface)localObject;
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
    case 1: 
      return true;
    case 4: 
      return VipUtils.c((QQAppInterface)localObject);
    case 5: 
      return VipUtils.b((QQAppInterface)localObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtg
 * JD-Core Version:    0.7.0.1
 */