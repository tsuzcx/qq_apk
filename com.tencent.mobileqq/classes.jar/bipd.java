import NS_QQ_STORY_CLIENT.CLIENT.StGetWatermarkDictRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StWatermarkDict;
import android.util.Log;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class bipd
  implements xgx<CLIENT.StGetWatermarkDictRsp>
{
  bipd(bipb parambipb) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StGetWatermarkDictRsp paramStGetWatermarkDictRsp)
  {
    if (paramBoolean)
    {
      paramString = paramStGetWatermarkDictRsp.extInfo;
      paramStGetWatermarkDictRsp = paramStGetWatermarkDictRsp.vecWatermarkDict.get();
      paramString = new HashMap();
      paramStGetWatermarkDictRsp = paramStGetWatermarkDictRsp.iterator();
      while (paramStGetWatermarkDictRsp.hasNext())
      {
        CLIENT.StWatermarkDict localStWatermarkDict = (CLIENT.StWatermarkDict)paramStGetWatermarkDictRsp.next();
        paramString.put(localStWatermarkDict.key.get(), localStWatermarkDict.value.get());
      }
      bipb.a(this.a, paramString);
      return;
    }
    Log.d(bipb.a(), "retCode:" + paramLong + " errMSg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipd
 * JD-Core Version:    0.7.0.1
 */