import GROUP.MessageRemindRsp;
import MQQ.GetRoamToastRsp;
import QC.BubbleRecommendRsp;
import QC.FaceRsp;
import QC.FontRecommendRsp;
import QC.SetFontBubbleRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class aogx
  implements anui
{
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(Bundle paramBundle) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, MessageRemindRsp paramMessageRemindRsp) {}
  
  public void a(boolean paramBoolean, GetRoamToastRsp paramGetRoamToastRsp) {}
  
  public void a(boolean paramBoolean, BubbleRecommendRsp paramBubbleRecommendRsp) {}
  
  public void a(boolean paramBoolean, FaceRsp paramFaceRsp) {}
  
  public void a(boolean paramBoolean, FontRecommendRsp paramFontRecommendRsp) {}
  
  public void a(boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public void d(boolean paramBoolean, Object paramObject) {}
  
  public void e(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 101: 
      do
      {
        return;
        if ((paramObject instanceof Integer))
        {
          a(((Integer)paramObject).intValue());
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SVIPObserver", 2, "NOTIFY_TYPE_SVIP_BUBBLE_CHANGE param error");
      return;
    case 100: 
      a();
      return;
    case 102: 
      b(paramBoolean, paramObject);
      return;
    case 103: 
      c(paramBoolean, paramObject);
      return;
    case 104: 
      d(paramBoolean, paramObject);
      return;
    case 105: 
      a(paramBoolean, paramObject);
      return;
    case 106: 
      e(paramBoolean, paramObject);
      return;
    case 113: 
      a(paramBoolean, (MessageRemindRsp)paramObject);
      return;
    case 107: 
      a(paramBoolean, (FontRecommendRsp)paramObject);
      return;
    case 108: 
      a(paramBoolean, (BubbleRecommendRsp)paramObject);
      return;
    case 109: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (SetFontBubbleRsp)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 110: 
      a((Bundle)paramObject);
      return;
    case 111: 
      a(paramBoolean, (GetRoamToastRsp)paramObject);
      return;
    case 112: 
      a(paramBoolean, (FaceRsp)paramObject);
      return;
    }
    paramObject = (Object[])paramObject;
    a((String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogx
 * JD-Core Version:    0.7.0.1
 */