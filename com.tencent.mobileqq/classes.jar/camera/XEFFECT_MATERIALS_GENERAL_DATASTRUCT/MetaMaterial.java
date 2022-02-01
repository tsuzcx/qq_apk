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
  static MetaAdditionalPackage cache_additionalPackage = new MetaAdditionalPackage();
  static MetaSdkInfo cache_sdkInfo = new MetaSdkInfo();
  public Map<String, String> additionalFields = null;
  public MetaAdditionalPackage additionalPackage = null;
  public String id = "";
  public String packageMd5 = "";
  public String packageUrl = "";
  public MetaSdkInfo sdkInfo = null;
  public int thumbHeight = 0;
  public String thumbUrl = "";
  public int thumbWidth = 0;
  
  static
  {
    cache_additionalFields = new HashMap();
    cache_additionalFields.put("", "");
  }
  
  public MetaMaterial() {}
  
  public MetaMaterial(String paramString1, MetaSdkInfo paramMetaSdkInfo, String paramString2, int paramInt1, int paramInt2, String paramString3, Map<String, String> paramMap, String paramString4, MetaAdditionalPackage paramMetaAdditionalPackage)
  {
    this.id = paramString1;
    this.sdkInfo = paramMetaSdkInfo;
    this.thumbUrl = paramString2;
    this.thumbWidth = paramInt1;
    this.thumbHeight = paramInt2;
    this.packageUrl = paramString3;
    this.additionalFields = paramMap;
    this.packageMd5 = paramString4;
    this.additionalPackage = paramMetaAdditionalPackage;
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
    this.additionalPackage = ((MetaAdditionalPackage)paramJceInputStream.read(cache_additionalPackage, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.sdkInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.thumbUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.thumbWidth, 3);
    paramJceOutputStream.write(this.thumbHeight, 4);
    localObject = this.packageUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.additionalFields;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
    localObject = this.packageMd5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.additionalPackage;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial
 * JD-Core Version:    0.7.0.1
 */