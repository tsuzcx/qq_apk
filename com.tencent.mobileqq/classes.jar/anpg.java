import android.content.Context;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;

class anpg
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  anpg(anpd paramanpd, String paramString, Context paramContext) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.path != null)) {
      ArkAppCacheMgr.getAppIcon(this.jdField_a_of_type_JavaLangString, new anph(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpg
 * JD-Core Version:    0.7.0.1
 */