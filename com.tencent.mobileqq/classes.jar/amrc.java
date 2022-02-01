import QQService.RespAddDiscussMember;
import QQService.RespGetDiscussInfo;
import android.util.Pair;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlResponse;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeResponse;
import com.tencent.protofile.discuss.FlyTicket.RetInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class amrc
  implements BusinessObserver
{
  private void handleNotify_AddDiscMember(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (!(paramArrayOfObject[1] instanceof Integer)) {
      return;
    }
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    if (paramBoolean)
    {
      paramArrayOfObject = (RespAddDiscussMember)paramArrayOfObject[2];
      Map localMap = paramArrayOfObject.AddResult;
      Object localObject = localMap.keySet();
      ArrayList localArrayList = new ArrayList();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        if (((Integer)localMap.get(localLong)).intValue() == 0) {
          localArrayList.add(String.valueOf(localLong));
        }
      }
      onAddDiscussionMember(true, i, paramArrayOfObject.DiscussUin, localArrayList);
      return;
    }
    onAddDiscussionMember(false, i, Long.valueOf((String)paramArrayOfObject[0]).longValue(), null);
  }
  
  private void handleNotify_CreateDisc(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      i = ((Integer)paramArrayOfObject[2]).intValue();
      if (paramArrayOfObject[0] != null) {
        break label44;
      }
    }
    label44:
    for (long l = 0L;; l = ((Long)paramArrayOfObject[0]).longValue())
    {
      onCreateDiscussion(paramBoolean, i, l, (String)paramArrayOfObject[1]);
      return;
    }
  }
  
  private void handleNotify_DecFlyTicket(boolean paramBoolean, FlyTicket.DiscussSigDecodeResponse paramDiscussSigDecodeResponse)
  {
    if ((paramDiscussSigDecodeResponse != null) && (((FlyTicket.RetInfo)paramDiscussSigDecodeResponse.ret_info.get()).ret_code.get() == 0))
    {
      onDecodeFlyTicket(paramBoolean, paramDiscussSigDecodeResponse.sig.get());
      return;
    }
    onDecodeFlyTicket(false, null);
  }
  
  private void handleNotify_GetAtAllCount(boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = false;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      String str = (String)paramObject[0];
      boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
      int i = ((Integer)paramObject[2]).intValue();
      int j = ((Integer)paramObject[3]).intValue();
      if (paramObject.length >= 5) {
        bool1 = ((Boolean)paramObject[4]).booleanValue();
      }
      onGetDiscAtAllRemianCount(paramBoolean, str, bool2, i, j, bool1);
    }
  }
  
  private void handleNotify_GetFlyTicket(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = Integer.parseInt((String)paramArrayOfObject[0]);
    FlyTicket.DiscussGetUrlResponse localDiscussGetUrlResponse = (FlyTicket.DiscussGetUrlResponse)paramArrayOfObject[1];
    long l = ((Long)paramArrayOfObject[2]).longValue();
    if ((localDiscussGetUrlResponse != null) && (i == 0))
    {
      String str = localDiscussGetUrlResponse.url.get();
      paramArrayOfObject = str;
      if (str != null)
      {
        paramArrayOfObject = str;
        if (!localDiscussGetUrlResponse.url.get().endsWith("#flyticket"))
        {
          paramArrayOfObject = str;
          if (!str.endsWith(localDiscussGetUrlResponse.sig.get())) {
            paramArrayOfObject = str + localDiscussGetUrlResponse.sig.get();
          }
        }
      }
      str = "";
      if (localDiscussGetUrlResponse.short_url.get() != null) {
        str = localDiscussGetUrlResponse.short_url.get();
      }
      onGetFlyTicket(paramBoolean, i, localDiscussGetUrlResponse.v_time.get(), paramArrayOfObject, str, l);
      return;
    }
    onGetFlyTicket(false, i, 0L, null, "", l);
  }
  
  protected void onAddDiscussionMember(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList) {}
  
  protected void onChangeDiscussionName(boolean paramBoolean, String paramString) {}
  
  protected void onCollectDiscussion(boolean paramBoolean, Long paramLong) {}
  
  protected void onCreateDiscussion(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  protected void onDecodeFlyTicket(boolean paramBoolean, String paramString) {}
  
  protected void onDelDiscussion() {}
  
  protected void onGetDiscAtAllRemianCount(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3) {}
  
  protected void onGetDiscussionInfoByFlyTicket(boolean paramBoolean, int paramInt, RespGetDiscussInfo paramRespGetDiscussInfo) {}
  
  protected void onGetFlyTicket(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2) {}
  
  protected void onHeaderFailed(Object[] paramArrayOfObject) {}
  
  protected void onJoinDiscussionByFlyTicket(boolean paramBoolean, long paramLong, int paramInt) {}
  
  protected void onKickoutDiscussionMember(boolean paramBoolean, Long paramLong1, Long paramLong2) {}
  
  protected void onQuitDiscussion(boolean paramBoolean, String paramString) {}
  
  protected void onUncollectDiscussion(boolean paramBoolean, Long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Discussion", 2, "Discussion DiscussObserver onUpdate type" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      updateDiscussionList(paramBoolean);
      return;
    case 1001: 
      updateDiscussionInfo(paramBoolean, paramObject);
      return;
    case 1003: 
      handleNotify_AddDiscMember(paramBoolean, (Object[])paramObject);
      return;
    case 1005: 
      onChangeDiscussionName(paramBoolean, (String)paramObject);
      return;
    case 1002: 
      handleNotify_CreateDisc(paramBoolean, (Object[])paramObject);
      return;
    case 1004: 
      lzb.a("deleteDiscuss_onQuitDiscussion");
      onQuitDiscussion(paramBoolean, (String)paramObject);
      return;
    case 1007: 
      paramObject = (Pair)paramObject;
      onUpdateDiscussionFaceIcon(paramBoolean, ((Boolean)paramObject.first).booleanValue(), (String)paramObject.second);
      return;
    case 2000: 
      onHeaderFailed((Object[])paramObject);
      return;
    case 1008: 
      onDelDiscussion();
      return;
    case 1009: 
      onUpdateAllDiscussionIcon();
      return;
    case 1010: 
      onUpdateDiscussionInteRemark(paramBoolean, ((Long)paramObject).longValue());
      return;
    case 1011: 
      handleNotify_GetFlyTicket(paramBoolean, (Object[])paramObject);
      return;
    case 1012: 
      handleNotify_DecFlyTicket(paramBoolean, (FlyTicket.DiscussSigDecodeResponse)paramObject);
      return;
    case 1013: 
      paramObject = (Object[])paramObject;
      onGetDiscussionInfoByFlyTicket(paramBoolean, Integer.parseInt((String)paramObject[0]), (RespGetDiscussInfo)paramObject[1]);
      return;
    case 1014: 
      paramObject = (Long[])paramObject;
      onJoinDiscussionByFlyTicket(paramBoolean, paramObject[1].longValue(), paramObject[0].intValue());
      return;
    case 1015: 
      paramObject = (long[])paramObject;
      onKickoutDiscussionMember(paramBoolean, Long.valueOf(paramObject[0]), Long.valueOf(paramObject[1]));
      return;
    case 1016: 
      onCollectDiscussion(paramBoolean, (Long)paramObject);
      return;
    case 1017: 
      onUncollectDiscussion(paramBoolean, (Long)paramObject);
      return;
    }
    handleNotify_GetAtAllCount(paramBoolean, paramObject);
  }
  
  protected void onUpdateAllDiscussionIcon() {}
  
  protected void onUpdateDiscussionFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  protected void onUpdateDiscussionInteRemark(boolean paramBoolean, long paramLong) {}
  
  protected void updateDiscussionInfo(boolean paramBoolean, Object paramObject) {}
  
  protected void updateDiscussionList(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amrc
 * JD-Core Version:    0.7.0.1
 */