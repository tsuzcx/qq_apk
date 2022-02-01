import kotlin.Metadata;
import kotlin.text.Charsets;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/VasAdvWebPlugin$handleRewardVideo$rewardCallback$1", "Lcooperation/vip/reward/VasRewardAdCallback;", "onReward", "", "retCode", "", "requestBizBuff", "", "reportBizBuff", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmko
  implements bmoj
{
  bmko(String paramString) {}
  
  public void onReward(int paramInt, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("returnCode", paramInt);
    JSONObject localJSONObject2 = new JSONObject();
    if (paramArrayOfByte1 != null) {
      localJSONObject2.put("request_busi_buff", new String(paramArrayOfByte1, Charsets.UTF_8));
    }
    if (paramArrayOfByte2 != null) {
      localJSONObject2.put("report_busi_buff", new String(paramArrayOfByte2, Charsets.UTF_8));
    }
    localJSONObject1.put("data", localJSONObject2);
    this.jdField_a_of_type_Bmkm.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject1.toString(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmko
 * JD-Core Version:    0.7.0.1
 */