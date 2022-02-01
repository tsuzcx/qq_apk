import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class arrt
  extends arvd
{
  arrt(arrp paramarrp) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (!this.a.a.containsKey(paramEmoticonPackage.epId)) {
      return;
    }
    arup localarup = (arup)arrp.l(this.a).getManager(43);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onJsonComplete, start download fav emoticon: " + paramEmoticonPackage.epId);
      }
      paramInt = paramBundle.getInt("jsonType", arup.c);
      paramBundle = new File(arze.r.replace("[epId]", paramEmoticonPackage.epId));
      ArrayList localArrayList = new ArrayList();
      arvr localarvr = new arvr();
      if (paramBundle.exists()) {}
      for (paramBundle = bgmg.a(paramBundle);; paramBundle = null)
      {
        paramBundle = arve.a(arrp.m(this.a), paramEmoticonPackage, paramInt, paramBundle, localArrayList, localarvr);
        if (paramBundle == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "parse Json Error:" + paramBundle);
        }
        bhab.a("emotionType", "emotionActionFav", "2", paramEmoticonPackage.epId, "", "", paramBundle, "", "", "");
        return;
      }
      this.a.a(paramEmoticonPackage, localarup, localArrayList, localarvr);
      this.a.a(paramEmoticonPackage, localarup);
      return;
    }
    this.a.a(paramEmoticonPackage);
    bhab.a("emotionType", "emotionActionFav", "1", paramEmoticonPackage.epId, "", bgnt.b(arrp.n(this.a).getApplication()) + "", paramInt + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrt
 * JD-Core Version:    0.7.0.1
 */