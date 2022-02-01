import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQTextEjectaFilter;
import com.tencent.mobileqq.shortvideo.filter.QQTextEjectaFilter.EjectaTextureCallBack;
import com.tencent.qg.StoryQGSurfaceView;

class bqaw
  implements QQTextEjectaFilter.EjectaTextureCallBack
{
  bqaw(bqav parambqav) {}
  
  public int[] onDrawFrame()
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp5_4 = arrayOfInt1;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    int[] arrayOfInt2 = new int[2];
    int[] tmp19_18 = arrayOfInt2;
    tmp19_18[0] = 0;
    int[] tmp23_19 = tmp19_18;
    tmp23_19[1] = 0;
    tmp23_19;
    if (!this.a.b) {
      return new int[0];
    }
    arrayOfInt1[0] = bqav.a(this.a).getCanvasTexture("offscreen_richard");
    if (((bqav.a(this.a) != null) || (bqav.a(this.a).f)) && (!bqav.a(this.a)))
    {
      if (bqav.a(this.a) == 0) {
        bqav.a(this.a, GlUtil.createTexture(3553, bqav.a(this.a)));
      }
      arrayOfInt1[1] = bqav.a(this.a);
      arrayOfInt2[1] = 1;
    }
    bqav.a(this.a).setIsNeedReverseTexture(arrayOfInt2);
    return arrayOfInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqaw
 * JD-Core Version:    0.7.0.1
 */