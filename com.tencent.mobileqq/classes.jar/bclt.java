import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bclt
  extends bclv
{
  public bclt(GroupSearchEngine paramGroupSearchEngine, bclw parambclw, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, parambclw, paramString, paramInt);
  }
  
  public bcfi a(List<bcfj> paramList, String paramString)
  {
    if (SearchConfigManager.needSeparate) {
      return null;
    }
    return new bcet(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List<bcfi> a(bcmk parambcmk)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(parambcmk);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (parambcmk.a == null) {
        parambcmk.a = new Bundle();
      }
      parambcmk.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((bcfi)localList.get(1)).a().size());
        }
        parambcmk.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((bcfi)localList.get(1)).a().size());
      }
      return localList;
    }
    parambcmk.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
  
  protected bcfi b(List<bcfj> paramList, String paramString)
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
      bcfj localbcfj = (bcfj)paramList.next();
      if (!bcnc.a(localbcfj)) {
        localArrayList.add(localbcfj);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new bcet(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
  
  protected bcfi c(List<bcfj> paramList, String paramString)
  {
    if (!SearchConfigManager.needSeparate) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bcfj localbcfj = (bcfj)paramList.next();
      if (bcnc.a(localbcfj)) {
        localArrayList.add(localbcfj);
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new bcev(localArrayList, paramString, GroupSearchEngine.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclt
 * JD-Core Version:    0.7.0.1
 */