package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toRIJXTabRedDotInfo", "Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabRedDotInfo;", "Lcom/tencent/mobileqq/data/MessageRecord;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class RIJXTabRedDotInfoKt
{
  @Nullable
  public static final RIJXTabRedDotInfo a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "$this$toRIJXTabRedDotInfo");
    if (!(paramMessageRecord instanceof MessageForStructing)) {}
    for (Object localObject1 = null;; localObject1 = paramMessageRecord)
    {
      localObject1 = (MessageForStructing)localObject1;
      Object localObject2;
      JSONObject localJSONObject;
      String str1;
      label87:
      String str2;
      if (localObject1 != null)
      {
        localObject2 = ((MessageForStructing)localObject1).structingMsg;
        if (localObject2 != null)
        {
          localObject1 = ((AbsStructMsg)localObject2).mMsgActionData;
          if (localObject1 != null)
          {
            localJSONObject = new JSONObject((String)localObject1);
            localObject1 = ((AbsStructMsg)localObject2).mAlgorithmIds;
            if (localObject1 == null) {
              break label133;
            }
            str1 = ((AbsStructMsg)localObject2).mStrategyIds;
            if (str1 == null) {
              break label140;
            }
            str2 = ((AbsStructMsg)localObject2).reportEventFolderStatusValue;
            if (str2 == null) {
              break label147;
            }
            label99:
            localObject2 = ((AbsStructMsg)localObject2).mArticleIds;
            if (localObject2 == null) {
              break label154;
            }
          }
        }
      }
      long l1;
      long l2;
      for (;;)
      {
        l1 = paramMessageRecord.time;
        l2 = 1000;
        if (localJSONObject.has("cid")) {
          break label161;
        }
        return null;
        label133:
        localObject1 = "";
        break;
        label140:
        str1 = "";
        break label87;
        label147:
        str2 = "";
        break label99;
        label154:
        localObject2 = "";
      }
      label161:
      return new RIJXTabRedDotInfo((String)localObject1, str1, str2, (String)localObject2, l2 * l1, localJSONObject.optInt("cid", -1), localJSONObject.optInt("pcid", -1), 0L, 128, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabRedDotInfoKt
 * JD-Core Version:    0.7.0.1
 */