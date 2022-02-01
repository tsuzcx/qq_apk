import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class asfp
  extends asiv
{
  asfp(asfl paramasfl) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (!this.a.a.containsKey(paramEmoticonPackage.epId)) {
      return;
    }
    asih localasih = (asih)asfl.l(this.a).getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onJsonComplete, start download fav emoticon: " + paramEmoticonPackage.epId);
      }
      paramInt = paramBundle.getInt("jsonType", asih.c);
      paramBundle = new File(EmoticonUtils.emoticonJsonFilePath.replace("[epId]", paramEmoticonPackage.epId));
      ArrayList localArrayList = new ArrayList();
      asjh localasjh = new asjh();
      if (paramBundle.exists()) {}
      for (paramBundle = FileUtils.fileToBytes(paramBundle);; paramBundle = null)
      {
        paramBundle = asiw.a(asfl.m(this.a), paramEmoticonPackage, paramInt, paramBundle, localArrayList, localasjh);
        if (paramBundle == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "parse Json Error:" + paramBundle);
        }
        bhpl.a("emotionType", "emotionActionFav", "2", paramEmoticonPackage.epId, "", "", paramBundle, "", "", "");
        return;
      }
      this.a.a(paramEmoticonPackage, localasih, localArrayList, localasjh);
      this.a.a(paramEmoticonPackage, localasih);
      return;
    }
    this.a.a(paramEmoticonPackage);
    bhpl.a("emotionType", "emotionActionFav", "1", paramEmoticonPackage.epId, "", NetworkUtil.getNetworkType(asfl.n(this.a).getApplication()) + "", paramInt + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfp
 * JD-Core Version:    0.7.0.1
 */