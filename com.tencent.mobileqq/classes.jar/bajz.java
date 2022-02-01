import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.ReqSetSettingItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/CardSettingObserver;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "()V", "handleGetCardDisplaySettingNotify", "", "isSuccess", "", "data", "", "handleSetCardDisplaySettingNotify", "onGetCardDisplaySetting", "uin", "", "card", "Lcom/tencent/mobileqq/data/Card;", "onSetCardDisplaySetting", "items", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/profilesetting/ReqSetSettingItem;", "Lkotlin/collections/ArrayList;", "onUpdate", "type", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class bajz
  implements anui
{
  public static final baka a = new baka(null);
  
  private final void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      a(paramBoolean, (String)((Object[])paramObject)[0], (Card)((Object[])paramObject)[1]);
    }
  }
  
  private final void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      a(paramBoolean, (String)((Object[])paramObject)[0], (Card)((Object[])paramObject)[1], (ArrayList)((Object[])paramObject)[2]);
    }
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable Card paramCard) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable Card paramCard, @Nullable ArrayList<ReqSetSettingItem> paramArrayList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, paramObject);
      return;
    }
    b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajz
 * JD-Core Version:    0.7.0.1
 */