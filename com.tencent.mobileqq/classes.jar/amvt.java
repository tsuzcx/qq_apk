import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.dressChangeListener.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext$dressChangeListener$2$1", "Lcom/tencent/mobileqq/vas/VasExtensionObserver;", "onApolloDressChange", "", "result", "", "data", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amvt
  extends bhow
{
  protected void onApolloDressChange(boolean paramBoolean, @Nullable Object paramObject)
  {
    super.onApolloDressChange(paramBoolean, paramObject);
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "onApolloDressChange, result:" + paramBoolean + ", data:" + paramObject + ", cacheUins:" + this.a.this$0.a());
    if ((!paramBoolean) || (paramObject == null)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (ArrayList)paramObject;
        if (((ArrayList)localObject).size() != 0)
        {
          paramObject = this.a.this$0.a().a().a(0);
          if (paramObject != null)
          {
            localObject = ((Iterable)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              if ((this.a.this$0.a().contains(str)) && (amme.a(amve.a.a(), str) == 1))
              {
                QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "onApolloDressChange, checkDressRec for " + str);
                paramObject.a(str, true);
              }
            }
            return;
          }
        }
      }
      catch (Exception paramObject) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvt
 * JD-Core Version:    0.7.0.1
 */