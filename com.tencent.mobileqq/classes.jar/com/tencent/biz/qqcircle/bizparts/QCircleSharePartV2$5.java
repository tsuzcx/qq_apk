package com.tencent.biz.qqcircle.bizparts;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.interfaces.QCircleAvatarUrlListener;

class QCircleSharePartV2$5
  implements QCircleAvatarUrlListener
{
  QCircleSharePartV2$5(QCircleSharePartV2 paramQCircleSharePartV2, String paramString1, String paramString2, PBStringField paramPBStringField) {}
  
  public void onAvatarUrl(String paramString)
  {
    Object localObject = new StringBuilder();
    String str = this.a;
    ((StringBuilder)localObject).append(str.substring(0, str.indexOf("\"iconUrl\":\"") + 11));
    ((StringBuilder)localObject).append(paramString);
    str = this.b;
    ((StringBuilder)localObject).append(str.substring(str.indexOf("\"")));
    localObject = ((StringBuilder)localObject).toString();
    this.c.set((String)localObject);
    QCircleSharePartV2.a(this.d, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2.5
 * JD-Core Version:    0.7.0.1
 */