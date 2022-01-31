import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.3.1;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.3.2;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class asiq
  extends asfx
{
  public asiq(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  protected void a(boolean paramBoolean, ArrayList<UpdatePhotoList.HeadInfo> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new NearbyGuideActivity.3.1(this, paramBoolean, paramInt1, paramArrayList));
  }
  
  protected void b(boolean paramBoolean, ArrayList<UpdatePhotoList.HeadInfo> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new NearbyGuideActivity.3.2(this, paramBoolean, paramInt1, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asiq
 * JD-Core Version:    0.7.0.1
 */