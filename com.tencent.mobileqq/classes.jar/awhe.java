import android.text.TextUtils;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.5;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;

public class awhe
  implements aysc
{
  public awhe(ScribbleResMgr.5 param5) {}
  
  public void onResp(aysz paramaysz)
  {
    int j = 2;
    QLog.i("ScribbleResMgr", 2, "DownloadResIcon onResp resp.mResult:  " + paramaysz.a);
    int i = j;
    Object localObject;
    String str1;
    String str2;
    if (paramaysz.a == 0)
    {
      localObject = "";
      str1 = "";
      if (this.a.a == 3)
      {
        localObject = ScribbleResMgr.a(this.a.this$0);
        str1 = ScribbleResMgr.b(this.a.this$0);
      }
      if (this.a.a == 4)
      {
        localObject = ScribbleResMgr.c(this.a.this$0);
        str1 = ScribbleResMgr.d(this.a.this$0);
      }
      str2 = bbdx.c((String)localObject);
      if ((TextUtils.isEmpty(str2)) || (!str2.equalsIgnoreCase(str1))) {
        break label259;
      }
      str1 = ScribbleResMgr.a;
      i = nav.a((String)localObject, str1);
      if (i == 0) {
        break label334;
      }
      QLog.e("ScribbleResMgr", 2, "unZipFolder  failed, filepath=" + (String)localObject + " destDir= " + str1 + " result: " + i);
    }
    label259:
    label334:
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        i = 1;
      }
      for (;;)
      {
        if (paramaysz.a == 3) {
          i = 4;
        }
        paramaysz = new ScribbleResMgr.ResInfo();
        paramaysz.resType = this.a.a;
        paramaysz.sourceId = 0;
        ScribbleResMgr.a(this.a.this$0, paramaysz, i);
        return;
        if (str2 == null) {}
        for (localObject = "";; localObject = str2)
        {
          str2 = str1;
          if (str1 == null) {
            str2 = "";
          }
          QLog.e("ScribbleResMgr", 2, "check wrong md5 =" + (String)localObject + " desMd5 = " + str2);
          i = j;
          break;
        }
        i = 2;
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awhe
 * JD-Core Version:    0.7.0.1
 */