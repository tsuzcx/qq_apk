package camera.SHADOW_BACKEND_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetBigShowRecommendReq
  extends JceStruct
{
  static ArrayList<byte[]> cache_framePics = new ArrayList();
  public int MediaType = 0;
  public String SdkVersion = "";
  public ArrayList<byte[]> framePics = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_framePics.add(arrayOfByte);
  }
  
  public GetBigShowRecommendReq() {}
  
  public GetBigShowRecommendReq(ArrayList<byte[]> paramArrayList, String paramString, int paramInt)
  {
    this.framePics = paramArrayList;
    this.SdkVersion = paramString;
    this.MediaType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.framePics = ((ArrayList)paramJceInputStream.read(cache_framePics, 0, false));
    this.SdkVersion = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.framePics;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.SdkVersion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.MediaType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendReq
 * JD-Core Version:    0.7.0.1
 */