import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;

public class aywg
{
  private static final ConnectionPool jdField_a_of_type_Okhttp3ConnectionPool = new ConnectionPool(10, 60L, TimeUnit.SECONDS);
  private static final Dispatcher jdField_a_of_type_Okhttp3Dispatcher = new Dispatcher();
  private static volatile OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  
  static
  {
    jdField_a_of_type_Okhttp3Dispatcher.setMaxRequests(64);
    jdField_a_of_type_Okhttp3Dispatcher.setMaxRequestsPerHost(8);
    a(30000L);
  }
  
  private static OkHttpClient.Builder a(long paramLong, boolean paramBoolean)
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    if (paramBoolean) {}
    for (List localList = Arrays.asList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 });; localList = Arrays.asList(new Protocol[] { Protocol.HTTP_1_1 })) {
      return localBuilder.protocols(localList).connectTimeout(paramLong, TimeUnit.MILLISECONDS).readTimeout(paramLong, TimeUnit.MILLISECONDS).writeTimeout(paramLong, TimeUnit.MILLISECONDS).connectionPool(jdField_a_of_type_Okhttp3ConnectionPool).dispatcher(jdField_a_of_type_Okhttp3Dispatcher);
    }
  }
  
  public static OkHttpClient a()
  {
    if (jdField_a_of_type_Okhttp3OkHttpClient == null) {
      a(30000L);
    }
    return jdField_a_of_type_Okhttp3OkHttpClient;
  }
  
  private static void a(long paramLong)
  {
    jdField_a_of_type_Okhttp3OkHttpClient = a(paramLong, GameWnsUtils.enableHttp2()).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywg
 * JD-Core Version:    0.7.0.1
 */