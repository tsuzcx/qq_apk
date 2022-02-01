import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ashg
  extends askq
{
  ashg(ashd paramashd) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    super.a(paramEmoticonPackage, paramInt);
    askc.a().b(this.a.a);
    Object localObject = (ashc)ashd.i(this.a).getManager(149);
    axfj localaxfj = (axfj)ashd.j(this.a).getManager(14);
    List localList = ((ashc)localObject).c(paramEmoticonPackage.epId);
    if ((localList == null) || (localList.size() <= 0)) {}
    do
    {
      return;
      paramEmoticonPackage = new ArrayList();
      int i = 0;
      if (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if (localaxfj.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId) == null)
        {
          localCustomEmotionData.RomaingType = "needDel";
          ((ashc)localObject).b(localCustomEmotionData);
          if (!TextUtils.isEmpty(localCustomEmotionData.resid)) {
            paramEmoticonPackage.add(localCustomEmotionData.resid);
          }
        }
        ashd localashd = this.a;
        if (paramInt == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localashd.a(localCustomEmotionData, bool);
          i += 1;
          break;
        }
      }
      localObject = (anxd)ashd.k(this.a).a(72);
    } while ((localObject == null) || (paramEmoticonPackage.size() <= 0));
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "delResId: " + paramEmoticonPackage);
    }
    ((anxd)localObject).a(paramEmoticonPackage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashg
 * JD-Core Version:    0.7.0.1
 */