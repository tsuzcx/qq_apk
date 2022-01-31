package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class MetaMaterial
  extends JceStruct
{
  static Map<String, String> cache_additionalFields;
  static MetaSdkInfo cache_sdkInfo = new MetaSdkInfo();
  public Map<String, String> additionalFields;
  public String id = "";
  public String packageMd5 = "";
  public String packageUrl = "";
  public MetaSdkInfo sdkInfo;
  public int thumbHeight;
  public String thumbUrl = "";
  public int thumbWidth;
  
  static
  {
    cache_additionalFields = new HashMap();
    cache_additionalFields.put("", "");
  }
  
  public MetaMaterial() {}
  
  public MetaMaterial(String paramString1, MetaSdkInfo paramMetaSdkInfo, String paramString2, int paramInt1, int paramInt2, String paramString3, Map<String, String> paramMap, String paramString4)
  {
    this.id = paramString1;
    this.sdkInfo = paramMetaSdkInfo;
    this.thumbUrl = paramString2;
    this.thumbWidth = paramInt1;
    this.thumbHeight = paramInt2;
    this.packageUrl = paramString3;
    this.additionalFields = paramMap;
    this.packageMd5 = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.sdkInfo = ((MetaSdkInfo)paramJceInputStream.read(cache_sdkInfo, 1, false));
    this.thumbUrl = paramJceInputStream.readString(2, false);
    this.thumbWidth = paramJceInputStream.read(this.thumbWidth, 3, false);
    this.thumbHeight = paramJceInputStream.read(this.thumbHeight, 4, false);
    this.packageUrl = paramJceInputStream.readString(5, false);
    this.additionalFields = ((Map)paramJceInputStream.read(cache_additionalFields, 6, false));
    this.packageMd5 = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 0);
    }
    if (this.sdkInfo != null) {
      paramJceOutputStream.write(this.sdkInfo, 1);
    }
    if (this.thumbUrl != null) {
      paramJceOutputStream.write(this.thumbUrl, 2);
    }
    paramJceOutputStream.write(this.thumbWidth, 3);
    paramJceOutputStream.write(this.thumbHeight, 4);
    if (this.packageUrl != null) {
      paramJceOutputStream.write(this.packageUrl, 5);
    }
    if (this.additionalFields != null) {
      paramJceOutputStream.write(this.additionalFields, 6);
    }
    if (this.packageMd5 != null) {
      paramJceOutputStream.write(this.packageMd5, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial
 * JD-Core Version:    0.7.0.1
 */