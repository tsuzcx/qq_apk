import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyMiniCardReq;
import java.util.List;
import mqq.manager.Manager;

public class aydj
  implements Manager
{
  private static final QQLruCache<String, NowSummaryCard.MiniCard> a;
  public QQAppInterface a;
  
  static
  {
    jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(101020, 50, 10);
  }
  
  public aydj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static NowSummaryCard.MiniCard a(String paramString)
  {
    return (NowSummaryCard.MiniCard)jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.containsKey(paramString);
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
  }
  
  public void a(List<Long> paramList, int paramInt, aydl paramaydl)
  {
    NowSummaryCard.NearbyMiniCardReq localNearbyMiniCardReq = new NowSummaryCard.NearbyMiniCardReq();
    localNearbyMiniCardReq.target_id.set(paramList);
    localNearbyMiniCardReq.id_type.set(paramInt);
    ntb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aydk(this, false, paramaydl, paramList), localNearbyMiniCardReq.toByteArray(), "NowSummaryCard.NearbyMiniCardReq");
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydj
 * JD-Core Version:    0.7.0.1
 */