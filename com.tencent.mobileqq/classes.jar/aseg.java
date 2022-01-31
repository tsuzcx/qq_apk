import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Rsp;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONObject;

public class aseg
  implements MiniAppCmdInterface
{
  public aseg(IntimatePlayTogetherMiniGameCardView paramIntimatePlayTogetherMiniGameCardView, MISC.StGetFriendPlayListV2Rsp paramStGetFriendPlayListV2Rsp) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("appInfo");
      if (paramJSONObject != null)
      {
        MiniAppController.preloadPackage(paramJSONObject);
        paramJSONObject = new MiniAppConfig(paramJSONObject);
        if (paramJSONObject.launchParam != null) {
          paramJSONObject.launchParam.scene = 2064;
        }
        MiniProgramLpReportDC04239.reportAsync(paramJSONObject, "page_view", "expo", null, String.valueOf(this.jdField_a_of_type_NS_MINI_APP_MISCMISC$StGetFriendPlayListV2Rsp.total.get()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aseg
 * JD-Core Version:    0.7.0.1
 */