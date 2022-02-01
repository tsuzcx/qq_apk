package camera.SHADOW_BACKEND_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetBigShowRecommendReq
  extends JceStruct
{
  static ArrayList<byte[]> cache_framePics = new ArrayList();
  public String SdkVersion = "";
  public ArrayList<byte[]> framePics = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_framePics.add(arrayOfByte);
  }
  
  public GetBigShowRecommendReq() {}
  
  public GetBigShowRecommendReq(ArrayList<byte[]> paramArrayList, String paramString)
  {
    this.framePics = paramArrayList;
    this.SdkVersion = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.framePics = ((ArrayList)paramJceInputStream.read(cache_framePics, 0, false));
    this.SdkVersion = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.framePics != null) {
      paramJceOutputStream.write(this.framePics, 0);
    }
    if (this.SdkVersion != null) {
      paramJceOutputStream.write(this.SdkVersion, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendReq
 * JD-Core Version:    0.7.0.1
 */