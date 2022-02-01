package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetRecommandTextByEmotionRsp
  extends JceStruct
{
  static ArrayList<String> cache_RecTexts = new ArrayList();
  public int Code = 0;
  public String Emo = "";
  public ArrayList<String> RecTexts = null;
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
    Object localObject = this.Emo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.RecTexts;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.UiNumConfig;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionRsp
 * JD-Core Version:    0.7.0.1
 */