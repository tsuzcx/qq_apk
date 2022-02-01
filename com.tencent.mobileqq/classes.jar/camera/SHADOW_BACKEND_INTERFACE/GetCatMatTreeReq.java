package camera.SHADOW_BACKEND_INTERFACE;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetCatMatTreeReq
  extends JceStruct
{
  static ArrayList<MetaSdkInfo> cache_SdkInfos = new ArrayList();
  public String ETag = "";
  public String GroupId = "";
  public int ReqType = 0;
  public ArrayList<MetaSdkInfo> SdkInfos = null;
  public String ServiceId = "";
  
  static
  {
    MetaSdkInfo localMetaSdkInfo = new MetaSdkInfo();
    cache_SdkInfos.add(localMetaSdkInfo);
  }
  
  public GetCatMatTreeReq() {}
  
  public GetCatMatTreeReq(String paramString1, String paramString2, String paramString3, ArrayList<MetaSdkInfo> paramArrayList, int paramInt)
  {
    this.ETag = paramString1;
    this.GroupId = paramString2;
    this.ServiceId = paramString3;
    this.SdkInfos = paramArrayList;
    this.ReqType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ETag = paramJceInputStream.readString(0, false);
    this.GroupId = paramJceInputStream.readString(1, false);
    this.ServiceId = paramJceInputStream.readString(2, false);
    this.SdkInfos = ((ArrayList)paramJceInputStream.read(cache_SdkInfos, 3, false));
    this.ReqType = paramJceInputStream.read(this.ReqType, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.ETag;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.GroupId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.ServiceId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.SdkInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    paramJceOutputStream.write(this.ReqType, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeReq
 * JD-Core Version:    0.7.0.1
 */