import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.1.1;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class avcr
  extends bhow
{
  public avcr(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  protected void onGetGameCenterPubAccountFeeds(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountFeeds(paramBoolean, paramObject);
    Object localObject2;
    long l;
    Object localObject1;
    String str1;
    if ((paramBoolean) && (paramObject != null))
    {
      localObject2 = (Object[])paramObject;
      l = ((Long)localObject2[0]).longValue();
      localObject1 = (String)localObject2[5];
      str1 = (String)localObject2[6];
      paramBoolean = ((Boolean)localObject2[1]).booleanValue();
      paramObject = (List)localObject2[2];
      JSONObject localJSONObject = (JSONObject)localObject2[3];
      if (localJSONObject != null)
      {
        aveq.a = localJSONObject.optInt("video_count");
        aveq.b = localJSONObject.optInt("video_time") * 1000;
        aveq.c = localJSONObject.optInt("layer_duration") * 1000;
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
        String str2 = "sp_key_game_center_feeds_float_condition" + QQGamePubAccountFragment.a(this.a).getCurrentAccountUin();
        localSharedPreferences.edit().putString(str2, localJSONObject.toString()).commit();
      }
      localObject2 = (FeedsItemData.TopCardInfo)localObject2[4];
      if (paramBoolean) {
        if (paramObject.size() == 0)
        {
          abuf.a(amwn.a(), "769", "205353", str1, "76901", "1", "160", new String[] { localObject1, "", "20" });
          QQGamePubAccountFragment.a(this.a).a(false, false);
        }
      }
    }
    for (;;)
    {
      QQGamePubAccountFragment.a(this.a, false);
      return;
      localObject1 = (List)QQGamePubAccountFragment.a(this.a).get(Long.valueOf(l));
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        ((List)localObject1).addAll(paramObject);
        QQGamePubAccountFragment.a(this.a).put(Long.valueOf(l), localObject1);
      }
      for (;;)
      {
        i = QQGamePubAccountFragment.a(this.a).getCurrentItem();
        if ((QQGamePubAccountFragment.a(this.a) == null) || (i >= QQGamePubAccountFragment.a(this.a).size()) || (((MessageRecord)QQGamePubAccountFragment.a(this.a).get(i)).uniseq != l)) {
          break;
        }
        QQGamePubAccountFragment.a(this.a).c();
        QQGamePubAccountFragment.a(this.a).a(paramObject);
        break;
        QQGamePubAccountFragment.a(this.a).put(Long.valueOf(l), paramObject);
      }
      QQGamePubAccountFragment.b(this.a).put(Long.valueOf(l), localObject2);
      int i = QQGamePubAccountFragment.a(this.a).getCurrentItem();
      if (paramObject.size() == 0) {
        if (localObject2 == null)
        {
          this.a.a(true);
          label495:
          QQGamePubAccountFragment.a(this.a).a(false, false);
          QQGamePubAccountFragment.c(this.a).put(Long.valueOf(l), aver.b);
          abuf.a(amwn.a(), "769", "205353", str1, "76901", "1", "160", new String[] { localObject1, "", "20" });
        }
      }
      for (;;)
      {
        QQGamePubAccountFragment.a(this.a).put(Long.valueOf(l), paramObject);
        if ((QQGamePubAccountFragment.a(this.a) == null) || (i >= QQGamePubAccountFragment.a(this.a).size()) || (((MessageRecord)QQGamePubAccountFragment.a(this.a).get(i)).uniseq != l)) {
          break;
        }
        QQGamePubAccountFragment.a(this.a).a(paramObject, (FeedsItemData.TopCardInfo)localObject2);
        ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.1.1(this, (FeedsItemData.TopCardInfo)localObject2));
        break;
        this.a.a(false);
        break label495;
        QQGamePubAccountFragment.c(this.a).put(Long.valueOf(l), aver.a);
        QQGamePubAccountFragment.a(this.a).a(false, false);
      }
      if (paramObject != null)
      {
        localObject1 = (Object[])paramObject;
        l = ((Long)localObject1[0]).longValue();
        paramObject = (String)localObject1[5];
        localObject1 = (String)localObject1[6];
        abuf.a(amwn.a(), "769", "205353", (String)localObject1, "76901", "1", "160", new String[] { paramObject, "", "20" });
        QLog.e("QQGamePubAccountFragment", 1, "[onGetGameCenterPubAccountFeeds] get feeds fail.");
        i = QQGamePubAccountFragment.a(this.a).getCurrentItem();
        if ((i < QQGamePubAccountFragment.a(this.a).size()) && (((MessageRecord)QQGamePubAccountFragment.a(this.a).get(i)).uniseq == l))
        {
          QQGamePubAccountFragment.a(this.a).a(false, false);
          QQGamePubAccountFragment.c(this.a).put(Long.valueOf(l), aver.b);
          this.a.a(false);
        }
      }
      if (this.a.getActivity() != null) {
        QQToast.a(this.a.getActivity(), anvx.a(2131709759), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcr
 * JD-Core Version:    0.7.0.1
 */