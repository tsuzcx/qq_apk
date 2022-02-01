package com.tencent.biz.qqcircle.polylike;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleGetPolyLikeInfoRequest;
import com.tencent.biz.qqcircle.widgets.AnimationView.AnimationInfo;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePolyLikeInfoManger
{
  static HashMap<String, AnimationView.AnimationInfo> a = new HashMap();
  private static String b = "QCirclePolyLikeInfoManger";
  private static QCirclePolyLikeInfoManger d;
  private List<QQCircleFeedBase.StPolyLike> c = new ArrayList();
  private float e = 0.0F;
  
  public static QCirclePolyLikeInfoManger a()
  {
    try
    {
      if (d == null) {
        d = new QCirclePolyLikeInfoManger();
      }
      QCirclePolyLikeInfoManger localQCirclePolyLikeInfoManger = d;
      return localQCirclePolyLikeInfoManger;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    QCirclePolyLikeInfoManger.1 local1 = new QCirclePolyLikeInfoManger.1(this, paramBoolean);
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetPolyLikeInfoRequest(), local1);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      this.e = 0.0F;
    } else {
      this.e = paramFloat;
    }
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateCurrentMoney result: ");
    localStringBuilder.append(this.e);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public void a(List<QQCircleFeedBase.StPolyLike> paramList)
  {
    this.c.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramList != null)
    {
      int i = 0;
      Object localObject;
      while (i < paramList.size())
      {
        localObject = (QQCircleFeedBase.StPolyLike)paramList.get(i);
        QQCircleFeedBase.StPolyLike localStPolyLike = QCirclePluginUtil.a((QQCircleFeedBase.StPolyLike)localObject);
        this.c.add(localStPolyLike);
        localStringBuilder.append(new String(((QQCircleFeedBase.StPolyLike)localObject).toByteArray()));
        localStringBuilder.append("#");
        i += 1;
      }
      if (!TextUtils.isEmpty(localStringBuilder.toString()))
      {
        paramList = b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("set poly success:");
        ((StringBuilder)localObject).append(this.c.size());
        QLog.d(paramList, 4, ((StringBuilder)localObject).toString());
        SharePreferenceUtils.a(QCircleApplication.APP, "qcircle_stpoly_key", localStringBuilder.toString());
      }
    }
  }
  
  public List<QQCircleFeedBase.StPolyLike> b()
  {
    if (this.c.isEmpty())
    {
      Object localObject = SharePreferenceUtils.a(QCircleApplication.APP, "qcircle_stpoly_key");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("#");
        if (localObject.length > 0)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            QQCircleFeedBase.StPolyLike localStPolyLike = localObject[i];
            try
            {
              localStPolyLike = (QQCircleFeedBase.StPolyLike)new QQCircleFeedBase.StPolyLike().mergeFrom(localStPolyLike.getBytes());
              this.c.add(localStPolyLike);
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              QLog.d(b, 4, localInvalidProtocolBufferMicroException, new Object[0]);
            }
            i += 1;
          }
          localObject = b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get poly success from share:");
          localStringBuilder.append(this.c.size());
          QLog.d((String)localObject, 4, localStringBuilder.toString());
        }
      }
    }
    if (this.c.isEmpty())
    {
      QCircleToast.a(QCircleToast.b, 2131895889, 0);
      a(false);
    }
    return this.c;
  }
  
  public float c()
  {
    return this.e;
  }
  
  public void d()
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeInfoManger
 * JD-Core Version:    0.7.0.1
 */