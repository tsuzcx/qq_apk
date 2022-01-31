import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qapmsdk.base.listener.IMonitorListener;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;
import com.tencent.qapmsdk.base.meta.LooperMeta;
import com.tencent.qapmsdk.base.meta.MonitorMeta;
import com.tencent.qapmsdk.base.meta.SceneMeta;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class aztu
  implements IMonitorListener
{
  public void onMetaGet(@NotNull MonitorMeta paramMonitorMeta)
  {
    if ((paramMonitorMeta instanceof SceneMeta))
    {
      paramMonitorMeta = (SceneMeta)paramMonitorMeta;
      double d = 100.0D * paramMonitorMeta.cpu;
      if (QLog.isColorLevel()) {
        QLog.i("QAPM_QQ_Impl", 2, "reportToDenta" + paramMonitorMeta.stage + " " + d + " " + paramMonitorMeta.memory + " " + paramMonitorMeta.duration);
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("cpuUsage", String.valueOf(d));
      ((HashMap)localObject).put("memory", String.valueOf(paramMonitorMeta.memory));
      ((HashMap)localObject).put("scene", String.valueOf(paramMonitorMeta.stage));
      ((HashMap)localObject).put("duration", String.valueOf(paramMonitorMeta.duration));
      azri.a(BaseApplicationImpl.getContext()).a("", "actScenePerf", true, 0L, 0L, (HashMap)localObject, "");
    }
    do
    {
      return;
      if ((paramMonitorMeta instanceof DropFrameResultMeta))
      {
        paramMonitorMeta = (DropFrameResultMeta)paramMonitorMeta;
        abvl.a(paramMonitorMeta.scene, (paramMonitorMeta.duration / 1000000.0F), paramMonitorMeta.dropCount, paramMonitorMeta.dropIntervals);
        return;
      }
    } while (!(paramMonitorMeta instanceof LooperMeta));
    Object localObject = (LooperMeta)paramMonitorMeta;
    paramMonitorMeta = new HashMap();
    localObject = ((LooperMeta)localObject).getLooperParams();
    try
    {
      Iterator localIterator = ((JSONObject)localObject).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramMonitorMeta.put(str, ((JSONObject)localObject).getString(str));
      }
      i = aztr.a();
    }
    catch (Exception paramMonitorMeta)
    {
      QLog.e("QAPMMonitorListener", 1, "onMetaGet looper", paramMonitorMeta);
      return;
    }
    int i;
    int j = ((JSONObject)localObject).getInt("cost_time");
    UnifiedMonitor.a().addEvent(i, "LooperSingle", j, 0, paramMonitorMeta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztu
 * JD-Core Version:    0.7.0.1
 */