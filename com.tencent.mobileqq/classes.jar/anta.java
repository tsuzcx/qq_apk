import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class anta
  extends anwk
{
  anta(ansx paramansx) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    super.a(paramEmoticonPackage, paramInt);
    anvw.a().b(this.a.a);
    Object localObject = (answ)ansx.i(this.a).getManager(149);
    askf localaskf = (askf)ansx.j(this.a).getManager(14);
    List localList = ((answ)localObject).c(paramEmoticonPackage.epId);
    if ((localList == null) || (localList.size() <= 0)) {}
    do
    {
      return;
      paramEmoticonPackage = new ArrayList();
      int i = 0;
      if (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if (localaskf.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId) == null)
        {
          localCustomEmotionData.RomaingType = "needDel";
          ((answ)localObject).b(localCustomEmotionData);
          if (!TextUtils.isEmpty(localCustomEmotionData.resid)) {
            paramEmoticonPackage.add(localCustomEmotionData.resid);
          }
        }
        ansx localansx = this.a;
        if (paramInt == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localansx.a(localCustomEmotionData, bool);
          i += 1;
          break;
        }
      }
      localObject = (ajvy)ansx.k(this.a).a(72);
    } while ((localObject == null) || (paramEmoticonPackage.size() <= 0));
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "delResId: " + paramEmoticonPackage);
    }
    ((ajvy)localObject).a(paramEmoticonPackage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anta
 * JD-Core Version:    0.7.0.1
 */