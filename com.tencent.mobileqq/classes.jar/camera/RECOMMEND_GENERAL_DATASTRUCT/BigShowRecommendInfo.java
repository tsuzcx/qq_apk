package camera.RECOMMEND_GENERAL_DATASTRUCT;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BigShowRecommendInfo
  extends JceStruct
{
  static MetaMaterial cache_MaterialInfo = new MetaMaterial();
  public int Confidence = 0;
  public MetaMaterial MaterialInfo = null;
  public String Reason = "";
  
  public BigShowRecommendInfo() {}
  
  public BigShowRecommendInfo(MetaMaterial paramMetaMaterial, String paramString, int paramInt)
  {
    this.MaterialInfo = paramMetaMaterial;
    this.Reason = paramString;
    this.Confidence = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MaterialInfo = ((MetaMaterial)paramJceInputStream.read(cache_MaterialInfo, 0, false));
    this.Reason = paramJceInputStream.readString(1, false);
    this.Confidence = paramJceInputStream.read(this.Confidence, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.MaterialInfo != null) {
      paramJceOutputStream.write(this.MaterialInfo, 0);
    }
    if (this.Reason != null) {
      paramJceOutputStream.write(this.Reason, 1);
    }
    paramJceOutputStream.write(this.Confidence, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     camera.RECOMMEND_GENERAL_DATASTRUCT.BigShowRecommendInfo
 * JD-Core Version:    0.7.0.1
 */