package camera.SHADOW_BACKEND_INTERFACE;

import camera.RECOMMEND_GENERAL_DATASTRUCT.BigShowRecommendInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetBigShowRecommendRsp
  extends JceStruct
{
  static ArrayList<BigShowRecommendInfo> cache_Materials = new ArrayList();
  public int Code = 0;
  public ArrayList<BigShowRecommendInfo> Materials = null;
  
  static
  {
    BigShowRecommendInfo localBigShowRecommendInfo = new BigShowRecommendInfo();
    cache_Materials.add(localBigShowRecommendInfo);
  }
  
  public GetBigShowRecommendRsp() {}
  
  public GetBigShowRecommendRsp(int paramInt, ArrayList<BigShowRecommendInfo> paramArrayList)
  {
    this.Code = paramInt;
    this.Materials = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Code = paramJceInputStream.read(this.Code, 0, false);
    this.Materials = ((ArrayList)paramJceInputStream.read(cache_Materials, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Code, 0);
    ArrayList localArrayList = this.Materials;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendRsp
 * JD-Core Version:    0.7.0.1
 */