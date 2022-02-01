import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bclz
  extends bcmb
{
  public bclz(GroupSearchEngine paramGroupSearchEngine, bcmc parambcmc, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambcmc, paramString, paramInt);
  }
  
  public bcfq a(List<bcfr> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new bcfb(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<bcfq> a(bcmq parambcmq)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(parambcmq);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (parambcmq.a == null) {
        parambcmq.a = new Bundle();
      }
      parambcmq.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((bcfq)localList.get(1)).a().size());
        }
        parambcmq.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((bcfq)localList.get(1)).a().size());
      }
      return localList;
    }
    parambcmq.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  protected bcfq b(List<bcfr> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bcfr localbcfr = (bcfr)paramList.next();
      if (!bcni.a(localbcfr)) {
        localArrayList.add(localbcfr);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new bcfb(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
  
  protected bcfq c(List<bcfr> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bcfr localbcfr = (bcfr)paramList.next();
      if (bcni.a(localbcfr)) {
        localArrayList.add(localbcfr);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new bcfd(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclz
 * JD-Core Version:    0.7.0.1
 */