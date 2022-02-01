import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class arbf
  extends arep
{
  arbf(arbb paramarbb) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (!this.a.a.containsKey(paramEmoticonPackage.epId)) {
      return;
    }
    areb localareb = (areb)arbb.l(this.a).getManager(43);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onJsonComplete, start download fav emoticon: " + paramEmoticonPackage.epId);
      }
      paramInt = paramBundle.getInt("jsonType", areb.c);
      paramBundle = new File(EmoticonUtils.emoticonJsonFilePath.replace("[epId]", paramEmoticonPackage.epId));
      ArrayList localArrayList = new ArrayList();
      arfb localarfb = new arfb();
      if (paramBundle.exists()) {}
      for (paramBundle = FileUtils.fileToBytes(paramBundle);; paramBundle = null)
      {
        paramBundle = areq.a(arbb.m(this.a), paramEmoticonPackage, paramInt, paramBundle, localArrayList, localarfb);
        if (paramBundle == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "parse Json Error:" + paramBundle);
        }
        bggr.a("emotionType", "emotionActionFav", "2", paramEmoticonPackage.epId, "", "", paramBundle, "", "", "");
        return;
      }
      this.a.a(paramEmoticonPackage, localareb, localArrayList, localarfb);
      this.a.a(paramEmoticonPackage, localareb);
      return;
    }
    this.a.a(paramEmoticonPackage);
    bggr.a("emotionType", "emotionActionFav", "1", paramEmoticonPackage.epId, "", NetworkUtil.getNetworkType(arbb.n(this.a).getApplication()) + "", paramInt + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbf
 * JD-Core Version:    0.7.0.1
 */