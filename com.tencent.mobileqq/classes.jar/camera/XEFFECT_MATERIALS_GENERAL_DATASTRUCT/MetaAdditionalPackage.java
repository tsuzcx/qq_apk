package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MetaAdditionalPackage
  extends JceStruct
{
  public String highPackageMd5 = "";
  public String highPackageUrl = "";
  public String lowPackageMd5 = "";
  public String lowPackageUrl = "";
  public String midPackageMd5 = "";
  public String midPackageUrl = "";
  public String superLowPackageMd5 = "";
  public String superLowPackageUrl = "";
  
  public MetaAdditionalPackage() {}
  
  public MetaAdditionalPackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.lowPackageUrl = paramString1;
    this.lowPackageMd5 = paramString2;
    this.superLowPackageUrl = paramString3;
    this.superLowPackageMd5 = paramString4;
    this.midPackageUrl = paramString5;
    this.midPackageMd5 = paramString6;
    this.highPackageUrl = paramString7;
    this.highPackageMd5 = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lowPackageUrl = paramJceInputStream.readString(0, false);
    this.lowPackageMd5 = paramJceInputStream.readString(1, false);
    this.superLowPackageUrl = paramJceInputStream.readString(2, false);
    this.superLowPackageMd5 = paramJceInputStream.readString(3, false);
    this.midPackageUrl = paramJceInputStream.readString(4, false);
    this.midPackageMd5 = paramJceInputStream.readString(5, false);
    this.highPackageUrl = paramJceInputStream.readString(6, false);
    this.highPackageMd5 = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.lowPackageUrl != null) {
      paramJceOutputStream.write(this.lowPackageUrl, 0);
    }
    if (this.lowPackageMd5 != null) {
      paramJceOutputStream.write(this.lowPackageMd5, 1);
    }
    if (this.superLowPackageUrl != null) {
      paramJceOutputStream.write(this.superLowPackageUrl, 2);
    }
    if (this.superLowPackageMd5 != null) {
      paramJceOutputStream.write(this.superLowPackageMd5, 3);
    }
    if (this.midPackageUrl != null) {
      paramJceOutputStream.write(this.midPackageUrl, 4);
    }
    if (this.midPackageMd5 != null) {
      paramJceOutputStream.write(this.midPackageMd5, 5);
    }
    if (this.highPackageUrl != null) {
      paramJceOutputStream.write(this.highPackageUrl, 6);
    }
    if (this.highPackageMd5 != null) {
      paramJceOutputStream.write(this.highPackageMd5, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaAdditionalPackage
 * JD-Core Version:    0.7.0.1
 */