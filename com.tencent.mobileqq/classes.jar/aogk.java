import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import pb.unite.search.DynamicAssociationWord.SuggestUrlItem;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class aogk
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
  
  public void handleSearchDiscoveryResult(List<bcgq> paramList, int paramInt) {}
  
  public void handleSearchHippyDiscoveryResult(ToServiceMsg paramToServiceMsg, Integer paramInteger, Object paramObject) {}
  
  public void handleTabSearchError(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong) {}
  
  public void handleTabSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<bcfi> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt) {}
  
  public void handleUniteSearchError(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3) {}
  
  public void handleUniteSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<bcfd> paramList, List<bcfi> paramList1, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchObserver", 2, "UniteSearchObserver onUpdate type" + paramInt + " isSuccess=" + paramBoolean + " data=" + paramObject);
    }
    switch (paramInt)
    {
    }
    label962:
    do
    {
      Object localObject1;
      Object localObject2;
      Object localObject4;
      do
      {
        boolean bool;
        long[] arrayOfLong;
        do
        {
          return;
          if (paramBoolean)
          {
            paramObject = (Object[])paramObject;
            handleCompletedUrlResult((String)paramObject[0], (DynamicAssociationWord.SuggestUrlItem)paramObject[1], ((Integer)paramObject[2]).intValue());
            return;
          }
          paramObject = (Object[])paramObject;
          handleCompletedUrlError((String)paramObject[0], (Integer)paramObject[1], (String)paramObject[2]);
          return;
          if (paramBoolean)
          {
            paramObject = (Object[])paramObject;
            handleAssociateResult((String)paramObject[0], ((Integer)paramObject[1]).intValue(), (List)paramObject[2], (List)paramObject[3], (DynamicAssociationWord.SuggestUrlItem)paramObject[4]);
            return;
          }
          paramObject = (Object[])paramObject;
          handleAssociateResultError((String)paramObject[0], (Integer)paramObject[1], (String)paramObject[2]);
          return;
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
          if (!paramBoolean) {
            break;
          }
          paramObject = (Object[])paramObject;
          localObject1 = (String)paramObject[0];
          paramBoolean = ((Boolean)paramObject[1]).booleanValue();
          localObject2 = (String)paramObject[2];
          localObject3 = (byte[])paramObject[3];
          bool = ((Boolean)paramObject[4]).booleanValue();
          localObject4 = (List)paramObject[5];
          arrayOfLong = (long[])paramObject[6];
          handleTabSearchResult((String)localObject1, paramBoolean, (String)localObject2, (byte[])localObject3, bool, (List)localObject4, arrayOfLong, (String)paramObject[7], (List)paramObject[8], ((Boolean)paramObject[9]).booleanValue(), (String)paramObject[10], ((Integer)paramObject[11]).intValue());
        } while (!QLog.isColorLevel());
        QLog.i("Q.uniteSearch.UniteSearchObserver", 2, "handleTabSearchResult_NOTIFY_TYPE_TAB_SEARCH isEnd = " + bool + " mask;" + Arrays.toString(arrayOfLong) + " key=" + (String)localObject1 + " time=" + (String)localObject2);
        return;
        localObject4 = (Object[])paramObject;
        paramObject = (String)localObject4[0];
        paramBoolean = ((Boolean)localObject4[1]).booleanValue();
        localObject1 = (String)localObject4[2];
        localObject2 = (Integer)localObject4[3];
        Object localObject3 = (String)localObject4[4];
        localObject4 = (long[])localObject4[5];
        handleTabSearchError(paramObject, paramBoolean, (String)localObject1, ((Integer)localObject2).intValue(), (String)localObject3, (long[])localObject4);
      } while (!QLog.isColorLevel());
      QLog.w("Q.uniteSearch.UniteSearchObserver", 2, "handleTabSearchResult_NOTIFY_TYPE_TAB_SEARCH error!  mask;" + Arrays.toString((long[])localObject4) + " key=" + paramObject + " time=" + (String)localObject1);
      return;
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
      if (paramObject != null)
      {
        if (paramBoolean)
        {
          localObject1 = (Object[])paramObject;
          paramObject = (List)localObject1[0];
          localObject1 = (Integer)localObject1[1];
          if (localObject1 != null) {}
          for (paramInt = ((Integer)localObject1).intValue();; paramInt = -1)
          {
            handleSearchDiscoveryResult(paramObject, paramInt);
            return;
          }
        }
        localObject2 = (Object[])paramObject;
        paramObject = (Integer)localObject2[0];
        localObject1 = (String)localObject2[1];
        localObject2 = (Integer)localObject2[2];
        if (paramObject != null)
        {
          paramInt = paramObject.intValue();
          if (localObject2 == null) {
            break label962;
          }
        }
        for (int i = ((Integer)localObject2).intValue();; i = -1)
        {
          handleSearchDiscoveryError(paramInt, (String)localObject1, i);
          return;
          paramInt = -1;
          break;
        }
      }
      handleSearchDiscoveryError(-1, null, -1);
      return;
    } while (paramObject == null);
    paramObject = (Object[])paramObject;
    handleSearchHippyDiscoveryResult((ToServiceMsg)paramObject[0], (Integer)paramObject[1], paramObject[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogk
 * JD-Core Version:    0.7.0.1
 */