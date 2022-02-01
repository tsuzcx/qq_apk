import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class asfo
  extends asiu
{
  asfo(asfl paramasfl) {}
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    super.onPackageEnd(paramEmoticonPackage, paramInt);
    asig.a().b(this.a.a);
    Object localObject = (asfk)asfl.i(this.a).getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    awyr localawyr = (awyr)asfl.j(this.a).getManager(QQManagerFactory.EMOTICON_MANAGER);
    List localList = ((asfk)localObject).c(paramEmoticonPackage.epId);
    if ((localList == null) || (localList.size() <= 0)) {}
    do
    {
      return;
      paramEmoticonPackage = new ArrayList();
      int i = 0;
      if (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if (localawyr.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId) == null)
        {
          localCustomEmotionData.RomaingType = "needDel";
          ((asfk)localObject).b(localCustomEmotionData);
          if (!TextUtils.isEmpty(localCustomEmotionData.resid)) {
            paramEmoticonPackage.add(localCustomEmotionData.resid);
          }
        }
        asfl localasfl = this.a;
        if (paramInt == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localasfl.a(localCustomEmotionData, bool);
          i += 1;
          break;
        }
      }
      localObject = (anua)asfl.k(this.a).getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER);
    } while ((localObject == null) || (paramEmoticonPackage.size() <= 0));
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "delResId: " + paramEmoticonPackage);
    }
    ((anua)localObject).a(paramEmoticonPackage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfo
 * JD-Core Version:    0.7.0.1
 */