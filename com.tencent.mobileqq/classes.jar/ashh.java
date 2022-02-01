import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class ashh
  extends askr
{
  ashh(ashd paramashd) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (!this.a.a.containsKey(paramEmoticonPackage.epId)) {
      return;
    }
    askd localaskd = (askd)ashd.l(this.a).getManager(43);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onJsonComplete, start download fav emoticon: " + paramEmoticonPackage.epId);
      }
      paramInt = paramBundle.getInt("jsonType", askd.c);
      paramBundle = new File(asos.r.replace("[epId]", paramEmoticonPackage.epId));
      ArrayList localArrayList = new ArrayList();
      aslf localaslf = new aslf();
      if (paramBundle.exists()) {}
      for (paramBundle = bhmi.a(paramBundle);; paramBundle = null)
      {
        paramBundle = asks.a(ashd.m(this.a), paramEmoticonPackage, paramInt, paramBundle, localArrayList, localaslf);
        if (paramBundle == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "parse Json Error:" + paramBundle);
        }
        biah.a("emotionType", "emotionActionFav", "2", paramEmoticonPackage.epId, "", "", paramBundle, "", "", "");
        return;
      }
      this.a.a(paramEmoticonPackage, localaskd, localArrayList, localaslf);
      this.a.a(paramEmoticonPackage, localaskd);
      return;
    }
    this.a.a(paramEmoticonPackage);
    biah.a("emotionType", "emotionActionFav", "1", paramEmoticonPackage.epId, "", bhnv.b(ashd.n(this.a).getApplication()) + "", paramInt + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashh
 * JD-Core Version:    0.7.0.1
 */