import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/studymode/ModeSwitchManager$simpleUIObserver$1", "Lcom/tencent/mobileqq/simpleui/SimpleUIObserver;", "onReqGetSimpleUISwitch", "", "isSuccess", "", "bSwitch", "sStudySwitch", "bPref", "", "uin", "", "onSwitchSimpleUICallback", "isSuc", "bChangeTheme", "bSwitchElsePref", "statusCode", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class baba
  extends azmj
{
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    this.a.a(false);
    if (babd.b())
    {
      this.a.a(paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
      return;
    }
    Iterator localIterator = ((Iterable)baau.a(this.a)).iterator();
    while (localIterator.hasNext()) {
      ((baav)localIterator.next()).a(paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString)
  {
    Iterator localIterator = ((Iterable)baau.a(this.a)).iterator();
    while (localIterator.hasNext()) {
      ((baav)localIterator.next()).a(paramBoolean1, paramBoolean2, paramBoolean3, paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baba
 * JD-Core Version:    0.7.0.1
 */