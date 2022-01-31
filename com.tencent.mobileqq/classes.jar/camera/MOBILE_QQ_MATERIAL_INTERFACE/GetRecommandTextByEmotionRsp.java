package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetRecommandTextByEmotionRsp
  extends JceStruct
{
  static ArrayList<String> cache_RecTexts = new ArrayList();
  public int Code;
  public String Emo = "";
  public ArrayList<String> RecTexts;
  public String UiNumConfig = "";
  
  static
  {
    cache_RecTexts.add("");
  }
  
  public GetRecommandTextByEmotionRsp() {}
  
  public GetRecommandTextByEmotionRsp(int paramInt, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    this.Code = paramInt;
    this.Emo = paramString1;
    this.RecTexts = paramArrayList;
    this.UiNumConfig = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Code = paramJceInputStream.read(this.Code, 0, false);
    this.Emo = paramJceInputStream.readString(1, false);
    this.RecTexts = ((ArrayList)paramJceInputStream.read(cache_RecTexts, 2, false));
    this.UiNumConfig = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Code, 0);
    if (this.Emo != null) {
      paramJceOutputStream.write(this.Emo, 1);
    }
    if (this.RecTexts != null) {
      paramJceOutputStream.write(this.RecTexts, 2);
    }
    if (this.UiNumConfig != null) {
      paramJceOutputStream.write(this.UiNumConfig, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionRsp
 * JD-Core Version:    0.7.0.1
 */