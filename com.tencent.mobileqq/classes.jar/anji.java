import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;

class anji
  implements bkik
{
  anji(aniz paramaniz) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("ark.download.module", 1, "ark.dctrl.onQueryCallback:" + paramArrayList.toString());
    }
    if (aniz.a(this.a) != null)
    {
      aahi.a(paramArrayList);
      aniz.a(this.a).a(paramArrayList);
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("ark.download.module", 1, "ark.dctrl.onQueryCallbackVia:" + paramArrayList.toString());
    }
    if (aniz.a(this.a) != null)
    {
      aahi.a(paramArrayList);
      aniz.a(this.a).a(paramArrayList);
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if (aniz.a(this.a) != null)
    {
      aahi.a(paramWadlResult);
      aniz.a(this.a).a(paramWadlResult);
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
        azqs.a(null, "dc00898", "", "", "0X8009E14", "0X8009E14", 0, 0, "", "", str, "");
        return;
      }
    }
    azqs.a(null, "dc00898", "", "", "0X8009E15", "0X8009E15", 0, 0, "", "", str, "");
    return;
    azqs.a(null, "dc00898", "", "", "0X8009E17", "0X8009E17", 0, 0, "", "", str, "");
    return;
    azqs.a(null, "dc00898", "", "", "0X8009E18", "0X8009E18", 0, 0, "", "", str, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anji
 * JD-Core Version:    0.7.0.1
 */