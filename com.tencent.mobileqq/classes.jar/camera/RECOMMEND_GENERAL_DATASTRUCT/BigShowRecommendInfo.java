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
    Object localObject = this.MaterialInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.Reason;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.Confidence, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.RECOMMEND_GENERAL_DATASTRUCT.BigShowRecommendInfo
 * JD-Core Version:    0.7.0.1
 */