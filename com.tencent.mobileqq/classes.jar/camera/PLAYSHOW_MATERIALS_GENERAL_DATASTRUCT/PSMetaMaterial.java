package camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class PSMetaMaterial
  extends JceStruct
{
  static Map<String, String> cache_additionalFields = new HashMap();
  public Map<String, String> additionalFields = null;
  public String id = "";
  public String name = "";
  public String packageMd5 = "";
  public String packageUrl = "";
  public String thumbMd5 = "";
  public String thumbUrl = "";
  public int type = 0;
  public int updateTime = 0;
  
  static
  {
    cache_additionalFields.put("", "");
  }
  
  public PSMetaMaterial() {}
  
  public PSMetaMaterial(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, Map<String, String> paramMap, int paramInt2)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.type = paramInt1;
    this.thumbUrl = paramString3;
    this.thumbMd5 = paramString4;
    this.packageUrl = paramString5;
    this.packageMd5 = paramString6;
    this.additionalFields = paramMap;
    this.updateTime = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.thumbUrl = paramJceInputStream.readString(3, false);
    this.thumbMd5 = paramJceInputStream.readString(4, false);
    this.packageUrl = paramJceInputStream.readString(5, false);
    this.packageMd5 = paramJceInputStream.readString(6, false);
    this.additionalFields = ((Map)paramJceInputStream.read(cache_additionalFields, 7, false));
    this.updateTime = paramJceInputStream.read(this.updateTime, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.type, 2);
    localObject = this.thumbUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.thumbMd5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.packageUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.packageMd5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.additionalFields;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 7);
    }
    paramJceOutputStream.write(this.updateTime, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaMaterial
 * JD-Core Version:    0.7.0.1
 */