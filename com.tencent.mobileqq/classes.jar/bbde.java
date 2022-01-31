import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

public class bbde
  implements TVK_SDKMgr.OnLogListener
{
  public bbde(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public int d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, paramString1 + " " + paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TribeVideoListPlayerFragment", 2, paramString1 + " " + paramString2);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TribeVideoListPlayerFragment", 2, paramString1 + " " + paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, paramString1 + " " + paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TribeVideoListPlayerFragment", 2, paramString1 + " " + paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbde
 * JD-Core Version:    0.7.0.1
 */