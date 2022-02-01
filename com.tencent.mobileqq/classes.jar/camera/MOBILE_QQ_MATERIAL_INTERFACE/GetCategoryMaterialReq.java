package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetCategoryMaterialReq
  extends JceStruct
{
  static ArrayList<MetaSdkInfo> cache_SdkInfos = new ArrayList();
  public String ETag = "";
  public ArrayList<MetaSdkInfo> SdkInfos = null;
  public String ServiceId = "";
  
  static
  {
    MetaSdkInfo localMetaSdkInfo = new MetaSdkInfo();
    cache_SdkInfos.add(localMetaSdkInfo);
  }
  
  public GetCategoryMaterialReq() {}
  
  public GetCategoryMaterialReq(String paramString1, String paramString2, ArrayList<MetaSdkInfo> paramArrayList)
  {
    this.ETag = paramString1;
    this.ServiceId = paramString2;
    this.SdkInfos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ETag = paramJceInputStream.readString(0, false);
    this.ServiceId = paramJceInputStream.readString(1, false);
    this.SdkInfos = ((ArrayList)paramJceInputStream.read(cache_SdkInfos, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.ETag;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.ServiceId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.SdkInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialReq
 * JD-Core Version:    0.7.0.1
 */