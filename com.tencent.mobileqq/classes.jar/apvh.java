import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;

class apvh
  implements bnym
{
  apvh(apuy paramapuy) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("ark.download.module", 1, "ark.dctrl.onQueryCallback:" + paramArrayList.toString());
    }
    if (apuy.a(this.a) != null)
    {
      acik.a(paramArrayList);
      apuy.a(this.a).a(paramArrayList);
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("ark.download.module", 1, "ark.dctrl.onQueryCallbackVia:" + paramArrayList.toString());
    }
    if (apuy.a(this.a) != null)
    {
      acik.a(paramArrayList);
      apuy.a(this.a).a(paramArrayList);
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if (apuy.a(this.a) != null)
    {
      acik.a(paramWadlResult);
      apuy.a(this.a).a(paramWadlResult);
      if (paramWadlResult != null) {}
    }
    else
    {
      return;
    }
    QLog.i("ark.download.module", 1, "ark.dctrl.onWadlTaskStatusChanged:" + paramWadlResult.toString());
    if (paramWadlResult.a != null) {}
    for (String str = paramWadlResult.a.a;; str = "") {
      switch (paramWadlResult.b)
      {
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        return;
      case 6: 
        bdll.a(null, "dc00898", "", "", "0X8009E14", "0X8009E14", 0, 0, "", "", str, "");
        return;
      }
    }
    bdll.a(null, "dc00898", "", "", "0X8009E15", "0X8009E15", 0, 0, "", "", str, "");
    return;
    bdll.a(null, "dc00898", "", "", "0X8009E17", "0X8009E17", 0, 0, "", "", str, "");
    return;
    bdll.a(null, "dc00898", "", "", "0X8009E18", "0X8009E18", 0, 0, "", "", str, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvh
 * JD-Core Version:    0.7.0.1
 */