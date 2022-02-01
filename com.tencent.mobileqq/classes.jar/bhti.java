import QC.UniBusinessCheckItem;
import QC.UniCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class bhti
  implements BusinessObserver
{
  bhti(bhte parambhte) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (this.a != null)
    {
      if (!(paramObject instanceof UniCheckRsp)) {
        break label98;
      }
      localObject = (Collection)((UniCheckRsp)paramObject).uniBusinessItemList;
      if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
        break label88;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label98;
      }
      localObject = this.a;
      if (((UniBusinessCheckItem)((UniCheckRsp)paramObject).uniBusinessItemList.get(0)).ret != 0) {
        break label93;
      }
    }
    label88:
    label93:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((bhte)localObject).a(paramBoolean, (UniCheckRsp)paramObject);
      return;
      paramInt = 0;
      break;
    }
    label98:
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhti
 * JD-Core Version:    0.7.0.1
 */