package com.tencent.biz.qqcircle.publish.model;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QZonePreUploadInfo
  implements SmartParcelable
{
  @NeedParcel
  public String[] a;
  public int b = 0;
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.a == null) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      Object localObject = this.a;
      if (i >= localObject.length) {
        break;
      }
      if (paramString.equals(localObject[i]))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("命中预上传");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("QZonePreUploadInfo", 1, ((StringBuilder)localObject).toString());
        paramString = new ArrayList(Arrays.asList(this.a));
        paramString.remove(i);
        if (paramString.size() > 0)
        {
          this.a = new String[paramString.size()];
          this.a = ((String[])paramString.toArray(this.a));
          return true;
        }
        this.a = null;
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.QZonePreUploadInfo
 * JD-Core Version:    0.7.0.1
 */