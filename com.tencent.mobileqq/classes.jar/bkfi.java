import android.content.Context;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.app.QQAppInterface;

public class bkfi
  extends ApolloLottieAnim
{
  private Downloader a;
  
  public bkfi(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(paramContext).getCommonDownloader();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    paramString3 = new bkfj(this, paramString2, paramString3);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(paramString1, paramString2, false, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfi
 * JD-Core Version:    0.7.0.1
 */