import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.4;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;

public class aygq
  implements baug
{
  public aygq(ScribbleResMgr.4 param4) {}
  
  public void onResp(bavf parambavf)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleResMgr", 2, "onResp  mResult: " + parambavf.jdField_a_of_type_Int + " url:" + this.a.a.sourceUrl);
    }
    int i = j;
    Object localObject;
    String str1;
    String str2;
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      localObject = "";
      if (this.a.a.resType == 1) {
        localObject = ScribbleResMgr.b(this.a.a.resType, this.a.a.sourceId);
      }
      if (this.a.a.resType == 2) {
        localObject = ScribbleResMgr.a(this.a.a.sourceId);
      }
      str1 = this.a.a.sourceMd5;
      str2 = bdhb.c((String)localObject);
      if ((TextUtils.isEmpty(str2)) || (!str2.equalsIgnoreCase(str1))) {
        break label348;
      }
      if (this.a.a.resType != 2) {
        break label438;
      }
      str1 = ScribbleResMgr.b(this.a.a.sourceId);
      i = ndr.a((String)localObject, str1);
      if (i == 0) {
        break label438;
      }
      QLog.e("ScribbleResMgr", 2, "unzip failed, filepath=" + (String)localObject + " destDir= " + str1 + " result: " + i);
    }
    label438:
    for (i = 0;; i = 1)
    {
      if (i != 0) {}
      for (i = 1;; i = 2)
      {
        j = i;
        localObject = (bbaa)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(193);
        i = j;
        if (((bbaa)localObject).a())
        {
          ((bbaa)localObject).a(this.a.a.sourceUrl, parambavf.jdField_a_of_type_Long);
          i = j;
        }
        if (parambavf.jdField_a_of_type_Int == 3) {
          i = 4;
        }
        ScribbleResMgr.a(this.a.this$0, this.a.a, i);
        return;
        label348:
        if (str2 == null) {}
        for (localObject = "";; localObject = str2)
        {
          if (str1 == null) {
            str1 = "";
          }
          for (;;)
          {
            QLog.e("ScribbleResMgr", 2, "onResp url: " + this.a.a.sourceUrl + "check wrong md5 =" + (String)localObject + " desMd5 = " + str1);
            break;
          }
        }
      }
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygq
 * JD-Core Version:    0.7.0.1
 */