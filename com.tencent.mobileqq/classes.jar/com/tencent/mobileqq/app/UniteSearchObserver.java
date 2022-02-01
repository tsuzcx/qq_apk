package com.tencent.mobileqq.app;

import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.model.GroupTabModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import tencent.im.oidb.search.DynamicAssociationWord.SuggestUrlItem;
import tencent.im.oidb.search.DynamicTabSearch.SubHotWord;

public class UniteSearchObserver
  implements BusinessObserver
{
  private static final String TAG = "Q.uniteSearch.UniteSearchObserver";
  
  public void handleAssociateResult(String paramString, int paramInt, List<AssociateSearchWordsFragment.AssociateItem> paramList, List<DynamicAssociationWord.SuggestUrlItem> paramList1, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem) {}
  
  public void handleAssociateResultError(String paramString1, Integer paramInteger, String paramString2) {}
  
  public void handleAssociateWordResult(String paramString, List<String> paramList1, List<String> paramList2, int paramInt) {}
  
  public void handleBusiHotWordError(int paramInt, String paramString) {}
  
  public void handleBusiHotWordResult(int paramInt, List<BusinessGroupWord> paramList) {}
  
  public void handleCompletedUrlError(String paramString1, Integer paramInteger, String paramString2) {}
  
  public void handleCompletedUrlResult(String paramString, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem, int paramInt) {}
  
  public void handleSearchDiscoveryError(int paramInt1, String paramString, int paramInt2) {}
  
  public void handleSearchDiscoveryResult(List<SearchEntryDataModel> paramList, int paramInt) {}
  
  public void handleSearchHippyDiscoveryResult(ToServiceMsg paramToServiceMsg, Integer paramInteger, Object paramObject) {}
  
  public void handleTabSearchError(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong) {}
  
  public void handleTabSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<ISearchResultGroupModel> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt) {}
  
  public void handleUniteSearchError(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3) {}
  
  public void handleUniteSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<GroupTabModel> paramList, List<ISearchResultGroupModel> paramList1, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("UniteSearchObserver onUpdate type");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" isSuccess=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" data=");
      ((StringBuilder)localObject1).append(paramObject);
      QLog.d("Q.uniteSearch.UniteSearchObserver", 2, ((StringBuilder)localObject1).toString());
    }
    int i = -1;
    Object localObject2;
    Object localObject3;
    switch (paramInt)
    {
    case 1001: 
    case 1003: 
    default: 
    case 1008: 
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        handleSearchHippyDiscoveryResult((ToServiceMsg)paramObject[0], (Integer)paramObject[1], paramObject[2]);
        return;
      }
      break;
    case 1007: 
      if (paramObject != null)
      {
        if (paramBoolean)
        {
          localObject1 = (Object[])paramObject;
          paramObject = (List)localObject1[0];
          localObject1 = (Integer)localObject1[1];
          if (localObject1 != null) {
            i = ((Integer)localObject1).intValue();
          }
          handleSearchDiscoveryResult(paramObject, i);
          return;
        }
        localObject2 = (Object[])paramObject;
        paramObject = (Integer)localObject2[0];
        localObject1 = (String)localObject2[1];
        localObject2 = (Integer)localObject2[2];
        if (paramObject != null) {
          paramInt = paramObject.intValue();
        } else {
          paramInt = -1;
        }
        if (localObject2 != null) {
          i = ((Integer)localObject2).intValue();
        }
        handleSearchDiscoveryError(paramInt, (String)localObject1, i);
        return;
      }
      handleSearchDiscoveryError(-1, null, -1);
      return;
    case 1006: 
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        handleAssociateResult((String)paramObject[0], ((Integer)paramObject[1]).intValue(), (List)paramObject[2], (List)paramObject[3], (DynamicAssociationWord.SuggestUrlItem)paramObject[4]);
        return;
      }
      paramObject = (Object[])paramObject;
      handleAssociateResultError((String)paramObject[0], (Integer)paramObject[1], (String)paramObject[2]);
      return;
    case 1005: 
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        handleCompletedUrlResult((String)paramObject[0], (DynamicAssociationWord.SuggestUrlItem)paramObject[1], ((Integer)paramObject[2]).intValue());
        return;
      }
      paramObject = (Object[])paramObject;
      handleCompletedUrlError((String)paramObject[0], (Integer)paramObject[1], (String)paramObject[2]);
      return;
    case 1004: 
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        handleUniteSearchResult((String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2], (byte[])paramObject[3], ((Boolean)paramObject[4]).booleanValue(), (List)paramObject[5], (List)paramObject[6], ((Integer)paramObject[7]).intValue());
        return;
      }
      localObject3 = (Object[])paramObject;
      paramObject = (String)localObject3[0];
      paramBoolean = ((Boolean)localObject3[1]).booleanValue();
      localObject1 = (String)localObject3[2];
      localObject2 = (Integer)localObject3[3];
      localObject3 = (String)localObject3[4];
      handleUniteSearchError(paramObject, paramBoolean, (String)localObject1, ((Integer)localObject2).intValue(), (String)localObject3);
      return;
    case 1002: 
      if (paramObject != null)
      {
        if (paramBoolean)
        {
          localObject1 = (Object[])paramObject;
          paramObject = (Integer)localObject1[0];
          localObject1 = (List)localObject1[1];
          handleBusiHotWordResult(paramObject.intValue(), (List)localObject1);
          return;
        }
        localObject1 = (Object[])paramObject;
        paramObject = (Integer)localObject1[0];
        localObject1 = (String)localObject1[1];
        handleBusiHotWordError(paramObject.intValue(), (String)localObject1);
        return;
      }
      handleBusiHotWordError(-1, "");
      return;
    case 1000: 
      Object localObject4;
      if (paramBoolean)
      {
        localObject3 = (Object[])paramObject;
        paramObject = (String)localObject3[0];
        paramBoolean = ((Boolean)localObject3[1]).booleanValue();
        localObject1 = (String)localObject3[2];
        localObject4 = (byte[])localObject3[3];
        boolean bool = ((Boolean)localObject3[4]).booleanValue();
        List localList = (List)localObject3[5];
        localObject2 = (long[])localObject3[6];
        handleTabSearchResult(paramObject, paramBoolean, (String)localObject1, (byte[])localObject4, bool, localList, (long[])localObject2, (String)localObject3[7], (List)localObject3[8], ((Boolean)localObject3[9]).booleanValue(), (String)localObject3[10], ((Integer)localObject3[11]).intValue());
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("handleTabSearchResult_NOTIFY_TYPE_TAB_SEARCH isEnd = ");
          ((StringBuilder)localObject3).append(bool);
          ((StringBuilder)localObject3).append(" mask;");
          ((StringBuilder)localObject3).append(Arrays.toString((long[])localObject2));
          ((StringBuilder)localObject3).append(" key=");
          ((StringBuilder)localObject3).append(paramObject);
          ((StringBuilder)localObject3).append(" time=");
          ((StringBuilder)localObject3).append((String)localObject1);
          QLog.i("Q.uniteSearch.UniteSearchObserver", 2, ((StringBuilder)localObject3).toString());
        }
      }
      else
      {
        localObject4 = (Object[])paramObject;
        paramObject = (String)localObject4[0];
        paramBoolean = ((Boolean)localObject4[1]).booleanValue();
        localObject1 = (String)localObject4[2];
        localObject2 = (Integer)localObject4[3];
        localObject3 = (String)localObject4[4];
        localObject4 = (long[])localObject4[5];
        handleTabSearchError(paramObject, paramBoolean, (String)localObject1, ((Integer)localObject2).intValue(), (String)localObject3, (long[])localObject4);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleTabSearchResult_NOTIFY_TYPE_TAB_SEARCH error!  mask;");
          ((StringBuilder)localObject2).append(Arrays.toString((long[])localObject4));
          ((StringBuilder)localObject2).append(" key=");
          ((StringBuilder)localObject2).append(paramObject);
          ((StringBuilder)localObject2).append(" time=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.w("Q.uniteSearch.UniteSearchObserver", 2, ((StringBuilder)localObject2).toString());
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.UniteSearchObserver
 * JD-Core Version:    0.7.0.1
 */