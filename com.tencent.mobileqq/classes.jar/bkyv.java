import NS_QQ_STORY_CLIENT.CLIENT.StGetWatermarkDictRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StWatermarkDict;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class bkyv
  implements zac<CLIENT.StGetWatermarkDictRsp>
{
  bkyv(bkyt parambkyt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StGetWatermarkDictRsp paramStGetWatermarkDictRsp)
  {
    if (paramBoolean)
    {
      bljn.b(bkyt.a(), "[onReceive]:");
      paramString = paramStGetWatermarkDictRsp.extInfo;
      paramStGetWatermarkDictRsp = paramStGetWatermarkDictRsp.vecWatermarkDict.get();
      paramString = new HashMap();
      paramStGetWatermarkDictRsp = paramStGetWatermarkDictRsp.iterator();
      while (paramStGetWatermarkDictRsp.hasNext())
      {
        CLIENT.StWatermarkDict localStWatermarkDict = (CLIENT.StWatermarkDict)paramStGetWatermarkDictRsp.next();
        paramString.put(localStWatermarkDict.key.get(), localStWatermarkDict.value.get());
      }
      bljn.b(bkyt.a(), "[onReceive] watermarkDict.size:" + paramString.size());
      bkyt.a(this.a, paramString);
      return;
    }
    bljn.d(bkyt.a(), "retCode:" + paramLong + " errMSg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyv
 * JD-Core Version:    0.7.0.1
 */