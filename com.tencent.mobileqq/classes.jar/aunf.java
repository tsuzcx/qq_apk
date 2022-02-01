import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.channel.model.CardCoverData;
import com.tencent.mobileqq.flutter.channel.relation.ZanRankingChannel.2;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class aunf
  extends aumo
  implements auns
{
  public static final AtomicInteger a;
  private Map<Integer, MethodChannel.Result> a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  }
  
  public aunf(String paramString, BinaryMessenger paramBinaryMessenger)
  {
    super(paramString, paramBinaryMessenger);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    aunp.a().a();
    aunp.a().a(this);
  }
  
  public MethodChannel.MethodCallHandler a()
  {
    return new aung(this);
  }
  
  public MethodCodec a()
  {
    return aunh.a;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilMap.clear();
    aunp.a().b();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean, CardCoverData paramCardCoverData)
  {
    QLog.d("ZanRankingChannel", 1, String.format("onGetCardCover seq=%d uin=%s fromCache=%b data=%s", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean), paramCardCoverData }));
    paramString = (MethodChannel.Result)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
    if (paramString == null) {
      return;
    }
    paramString = new ZanRankingChannel.2(this, paramString, paramCardCoverData);
    ThreadManager.getUIHandlerV2().post(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunf
 * JD-Core Version:    0.7.0.1
 */