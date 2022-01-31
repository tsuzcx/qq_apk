import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import java.util.List;

class ayzq
  implements ayzy
{
  ayzq(ayzp paramayzp) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadConfigNoLogin onConfigResult | result=").append(paramInt1).append("serverError=").append(paramInt2);
    VideoEnvironment.a(ayzp.a(this.a), ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a(ayzp.a(this.a), "startDownloadConfigNoLogin onConfigResult| uncompress config error=" + paramInt2, null);
        ayzp.a(this.a);
        return;
      }
      localObject = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(ayzp.a(this.a), (List)localObject);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a(ayzp.a(this.a), "startDownloadConfigNoLogin onConfigResult| check config success...", null);
        ayzp.a(this.a).a();
        aste.a().a();
        return;
      }
      VideoEnvironment.a(ayzp.a(this.a), "startDownloadConfigNoLogin onConfigResult| check config error=" + paramInt1, null);
      ayzp.a(this.a);
      return;
    }
    VideoEnvironment.a(ayzp.a(this.a), "startDownloadConfigNoLogin onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
    ayzp.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzq
 * JD-Core Version:    0.7.0.1
 */