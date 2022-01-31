import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.3.1;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.3.2;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class auvv
  extends autc
{
  public auvv(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  protected void a(boolean paramBoolean, ArrayList<UpdatePhotoList.HeadInfo> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new NearbyGuideActivity.3.1(this, paramBoolean, paramInt1, paramArrayList));
  }
  
  protected void b(boolean paramBoolean, ArrayList<UpdatePhotoList.HeadInfo> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new NearbyGuideActivity.3.2(this, paramBoolean, paramInt1, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auvv
 * JD-Core Version:    0.7.0.1
 */