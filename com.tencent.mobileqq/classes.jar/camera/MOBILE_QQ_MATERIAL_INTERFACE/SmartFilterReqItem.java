package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class SmartFilterReqItem
  extends JceStruct
{
  static ArrayList<FaceRects> cache_Faces;
  static byte[] cache_Rawdata = (byte[])new byte[1];
  public ArrayList<FaceRects> Faces = null;
  public byte[] Rawdata = null;
  
  static
  {
    ((byte[])cache_Rawdata)[0] = 0;
    cache_Faces = new ArrayList();
    FaceRects localFaceRects = new FaceRects();
    cache_Faces.add(localFaceRects);
  }
  
  public SmartFilterReqItem() {}
  
  public SmartFilterReqItem(byte[] paramArrayOfByte, ArrayList<FaceRects> paramArrayList)
  {
    this.Rawdata = paramArrayOfByte;
    this.Faces = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Rawdata = ((byte[])paramJceInputStream.read(cache_Rawdata, 0, false));
    this.Faces = ((ArrayList)paramJceInputStream.read(cache_Faces, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.Rawdata;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 0);
    }
    localObject = this.Faces;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem
 * JD-Core Version:    0.7.0.1
 */