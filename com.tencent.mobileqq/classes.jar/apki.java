import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class apki
  extends apns
{
  apki(apkf paramapkf) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    super.a(paramEmoticonPackage, paramInt);
    apne.a().b(this.a.a);
    Object localObject = (apke)apkf.i(this.a).getManager(149);
    aube localaube = (aube)apkf.j(this.a).getManager(14);
    List localList = ((apke)localObject).c(paramEmoticonPackage.epId);
    if ((localList == null) || (localList.size() <= 0)) {}
    do
    {
      return;
      paramEmoticonPackage = new ArrayList();
      int i = 0;
      if (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if (localaube.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId) == null)
        {
          localCustomEmotionData.RomaingType = "needDel";
          ((apke)localObject).b(localCustomEmotionData);
          if (!TextUtils.isEmpty(localCustomEmotionData.resid)) {
            paramEmoticonPackage.add(localCustomEmotionData.resid);
          }
        }
        apkf localapkf = this.a;
        if (paramInt == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localapkf.a(localCustomEmotionData, bool);
          i += 1;
          break;
        }
      }
      localObject = (alnm)apkf.k(this.a).a(72);
    } while ((localObject == null) || (paramEmoticonPackage.size() <= 0));
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "delResId: " + paramEmoticonPackage);
    }
    ((alnm)localObject).a(paramEmoticonPackage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apki
 * JD-Core Version:    0.7.0.1
 */