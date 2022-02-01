package com.tencent.biz.qqcircle.bizparts.danmaku;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.FunctionIdConstant;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleCommentItemInfo;
import com.tencent.biz.qqcircle.bizparts.danmaku.config.PhotoDanmakuConfig;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.IDanmakuLisener;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDataSource;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuFactory;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuManager;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuManager.TouchPoint;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.PhotoDanmakuModel;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.R2LPhotoDanmaku;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.R2LPhotoDanmaku.IR2LDanmakuInterface;
import com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData.BarrageEffectInfo;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QCircleDanmakuSmartView
  extends FrameLayout
  implements IDanmakuLisener
{
  private long a = 0L;
  private List<FeedCloudMeta.StComment> b;
  private QCircleDanmakuSmartView.DanmakuAnimationTask c;
  private ViewGroup d = null;
  private TextureView e;
  private PhotoDanmakuManager f;
  private PhotoDanmakuDataSource g;
  private PhotoDanmakuFactory h;
  private QCircleCommentInfo i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private QCircleDanmakuSmartView.OnDanmakuSmartCallback m;
  private ArrayList<PhotoDanmakuModel> n;
  
  public QCircleDanmakuSmartView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleDanmakuSmartView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleDanmakuSmartView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt)
  {
    int i1 = paramInt + 1;
    paramInt = i1;
    if (i1 >= 2) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private long a(AbsDanmaku paramAbsDanmaku)
  {
    float f1 = paramAbsDanmaku.T();
    f1 = 8160.0F * f1 / (DisplayUtil.d() + f1);
    return paramAbsDanmaku.r() + (int)(f1 + 1000.0F);
  }
  
  private AbsDanmaku a(QCircleDanmakuSmartView.DanmakuItemShowParam paramDanmakuItemShowParam, PhotoDanmakuModel paramPhotoDanmakuModel)
  {
    Object localObject1 = RichTextAtParser.a(paramPhotoDanmakuModel.c);
    int i1 = getContext().getResources().getColor(2131167659);
    int i2 = getContext().getResources().getColor(2131167658);
    localObject1 = this.h.a(1, paramDanmakuItemShowParam.a, "", (CharSequence)localObject1, i1, 10.0F, i2);
    Object localObject2 = new QCircleDanmakuSmartView.IR2LDanmakuHandler(this, b(this.i));
    ((R2LPhotoDanmaku)localObject1).a((R2LPhotoDanmaku.IR2LDanmakuInterface)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((AbsDanmaku)localObject1).ah);
    ((StringBuilder)localObject2).append("=mCommentIndex  ");
    ((StringBuilder)localObject2).append(((AbsDanmaku)localObject1).aj);
    ((StringBuilder)localObject2).append("=isreply   ");
    ((StringBuilder)localObject2).append(((AbsDanmaku)localObject1).ad);
    ((StringBuilder)localObject2).append("=mPerferredLine  ");
    ((StringBuilder)localObject2).append(((AbsDanmaku)localObject1).r());
    ((StringBuilder)localObject2).append("=time");
    QLog.e("Refactor-QCircleDanmakuSmartView", 2, ((StringBuilder)localObject2).toString());
    a(paramDanmakuItemShowParam.b, paramPhotoDanmakuModel, (AbsDanmaku)localObject1);
    a(paramPhotoDanmakuModel, (AbsDanmaku)localObject1);
    this.h.a((AbsDanmaku)localObject1);
    return localObject1;
  }
  
  private AbsDanmaku a(ArrayList<PhotoDanmakuModel> paramArrayList, ArrayList<AbsDanmaku> paramArrayList1, int paramInt)
  {
    QCircleDanmakuSmartView.DanmakuItemShowParam localDanmakuItemShowParam = new QCircleDanmakuSmartView.DanmakuItemShowParam();
    paramArrayList = (PhotoDanmakuModel)paramArrayList.get(paramInt);
    if ((paramInt < 2) && (!paramArrayList.i)) {
      localDanmakuItemShowParam.b += 1;
    } else {
      a(paramArrayList1, paramInt, localDanmakuItemShowParam, paramArrayList);
    }
    return a(localDanmakuItemShowParam, paramArrayList);
  }
  
  private PhotoDanmakuModel a(List<QCircleCommentItemInfo> paramList, int paramInt)
  {
    paramList = (QCircleCommentItemInfo)b(paramList, paramInt);
    if (paramList == null)
    {
      QLog.w("Refactor-QCircleDanmakuSmartView", 2, "[createDanmakuModel] item info is null.");
      return null;
    }
    PhotoDanmakuModel localPhotoDanmakuModel = new PhotoDanmakuModel(paramList.a.postUser.nick.get(), paramList.a.postUser, paramList.a.content.get(), null, null, null, null);
    localPhotoDanmakuModel.g = paramList.a.likeInfo.count.get();
    int i1 = paramList.a.likeInfo.status.get();
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    localPhotoDanmakuModel.h = bool;
    localPhotoDanmakuModel.j = paramInt;
    return localPhotoDanmakuModel;
  }
  
  private void a(int paramInt1, int paramInt2, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 1, "[addDanmakuReplyModeToList] reply not is null.");
      return;
    }
    Object localObject = paramStReply.postUser.nick.get();
    FeedCloudMeta.StUser localStUser = paramStReply.postUser;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131895817));
    localStringBuilder.append(":");
    localStringBuilder.append(paramStReply.content.get());
    localObject = new PhotoDanmakuModel((String)localObject, localStUser, localStringBuilder.toString(), null, null, null, null);
    ((PhotoDanmakuModel)localObject).g = paramStReply.likeInfo.count.get();
    boolean bool;
    if (paramStReply.likeInfo.status.get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((PhotoDanmakuModel)localObject).h = bool;
    ((PhotoDanmakuModel)localObject).i = true;
    ((PhotoDanmakuModel)localObject).j = paramInt1;
    ((PhotoDanmakuModel)localObject).k = paramInt2;
    this.n.add(localObject);
  }
  
  private void a(int paramInt, QCircleCommentItemInfo paramQCircleCommentItemInfo)
  {
    FeedCloudMeta.StUser localStUser = getHostUser();
    if ((localStUser != null) && (localStUser.id != null))
    {
      if (TextUtils.isEmpty(localStUser.id.get())) {
        return;
      }
      Object localObject2 = null;
      Object localObject1;
      if (paramQCircleCommentItemInfo == null) {
        localObject1 = null;
      } else {
        localObject1 = paramQCircleCommentItemInfo.a;
      }
      paramQCircleCommentItemInfo = localObject2;
      if (localObject1 != null) {
        if (((FeedCloudMeta.StComment)localObject1).vecReply == null) {
          paramQCircleCommentItemInfo = localObject2;
        } else {
          paramQCircleCommentItemInfo = ((FeedCloudMeta.StComment)localObject1).vecReply.get();
        }
      }
      if (paramQCircleCommentItemInfo != null)
      {
        if (paramQCircleCommentItemInfo.isEmpty()) {
          return;
        }
        int i1 = 0;
        while (i1 < paramQCircleCommentItemInfo.size())
        {
          localObject1 = (FeedCloudMeta.StReply)paramQCircleCommentItemInfo.get(i1);
          if ((localObject1 != null) && (((FeedCloudMeta.StReply)localObject1).postUser.id.get().equals(localStUser.id.get())))
          {
            a(paramInt, i1, (FeedCloudMeta.StReply)localObject1);
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, PhotoDanmakuModel paramPhotoDanmakuModel, AbsDanmaku paramAbsDanmaku)
  {
    paramAbsDanmaku.af = paramPhotoDanmakuModel.g;
    paramAbsDanmaku.ag = paramPhotoDanmakuModel.h;
    paramAbsDanmaku.ad = paramInt;
    paramAbsDanmaku.ah = paramPhotoDanmakuModel.j;
    paramAbsDanmaku.ai = paramPhotoDanmakuModel.k;
    paramAbsDanmaku.aj = paramPhotoDanmakuModel.i;
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView == null)
    {
      QLog.w("Refactor-QCircleDanmakuSmartView", 1, "[loadFlashAnimation] view not is null.");
      return;
    }
    paramImageView.setBackgroundResource(2130845070);
    paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    ObjectAnimator.ofFloat(paramImageView, "alpha", new float[] { 0.0F, 1.0F, 0.0F }).setDuration(600L).start();
  }
  
  private void a(QCircleDanmakuSmartView.DoLikeSuccessParam paramDoLikeSuccessParam)
  {
    QCircleDanmakuSmartView.OnDanmakuSmartCallback localOnDanmakuSmartCallback = this.m;
    if (localOnDanmakuSmartCallback == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "notifyDoLikeSuccess danmaku option listener is null.");
      return;
    }
    localOnDanmakuSmartCallback.a(paramDoLikeSuccessParam);
  }
  
  private void a(AbsDanmaku paramAbsDanmaku, ImageView paramImageView1, ImageView paramImageView2)
  {
    c();
    c(paramImageView1);
    c(paramImageView2);
    ApngImage.pauseByTag(33);
    if ((paramAbsDanmaku != null) && (!paramAbsDanmaku.ad()))
    {
      paramAbsDanmaku.k(paramAbsDanmaku.af + 1);
      paramAbsDanmaku.ag = true;
    }
  }
  
  private void a(AbsDanmaku paramAbsDanmaku, QCircleDanmakuSmartView.LikeRequestParam paramLikeRequestParam)
  {
    int i2 = 2;
    if (paramAbsDanmaku == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "[handlerRequestLikeSuccess] danmaku == null.");
      return;
    }
    if (paramLikeRequestParam == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "handlerRequestLikeSuccess param not is null.");
      return;
    }
    FeedCloudMeta.StComment localStComment = paramLikeRequestParam.a;
    FeedCloudMeta.StReply localStReply = paramLikeRequestParam.b;
    Object localObject = "";
    String str;
    if ((localStComment != null) && (localStComment.id != null)) {
      str = localStComment.id.get();
    } else {
      str = "";
    }
    if ((localStReply != null) && (localStReply.id != null)) {
      paramLikeRequestParam = localStReply.id.get();
    } else {
      paramLikeRequestParam = "";
    }
    int i3 = 0;
    int i1;
    if ((!paramAbsDanmaku.aj) && (localStComment != null))
    {
      localStComment.likeInfo.status.set(1);
      localStComment.likeInfo.count.set(localStComment.likeInfo.count.get() + 1);
      i1 = localStComment.likeInfo.count.get();
    }
    else
    {
      i1 = i3;
      if (paramAbsDanmaku.aj)
      {
        i1 = i3;
        if (localStReply != null)
        {
          i1 = i3;
          if (localStReply.likeInfo != null)
          {
            localStReply.likeInfo.status.set(1);
            localStReply.likeInfo.count.set(localStReply.likeInfo.count.get() + 1);
            i1 = localStReply.likeInfo.count.get();
          }
        }
      }
    }
    if (!paramAbsDanmaku.aj) {
      i2 = 1;
    }
    if (paramAbsDanmaku.aj) {
      localObject = paramLikeRequestParam;
    }
    paramAbsDanmaku = new QCircleDanmakuSmartView.DoLikeSuccessParam();
    paramAbsDanmaku.a = i2;
    paramAbsDanmaku.b = ((String)localObject);
    paramAbsDanmaku.c = str;
    paramAbsDanmaku.b = ((String)localObject);
    paramAbsDanmaku.d = i1;
    a(paramAbsDanmaku);
  }
  
  private void a(PhotoDanmakuModel paramPhotoDanmakuModel, AbsDanmaku paramAbsDanmaku)
  {
    if (paramPhotoDanmakuModel.l != null)
    {
      Object localObject = paramPhotoDanmakuModel.l.k;
      String str = paramPhotoDanmakuModel.l.j;
      paramAbsDanmaku.a((String)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(str);
      paramAbsDanmaku.b(Color.parseColor(((StringBuilder)localObject).toString()));
    }
    try
    {
      if ((paramPhotoDanmakuModel.d == null) || (TextUtils.isEmpty(paramPhotoDanmakuModel.d))) {
        break label126;
      }
      paramAbsDanmaku.i(Integer.parseInt(paramPhotoDanmakuModel.d));
      paramAbsDanmaku.j(Integer.parseInt(paramPhotoDanmakuModel.e));
      paramAbsDanmaku.f(paramPhotoDanmakuModel.f);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label117:
      label126:
      break label117;
    }
    QLog.e("Refactor-QCircleDanmakuSmartView", 2, "Integer.parseInt(curDanmakuModel.fontId) - NumberFormatException");
    paramAbsDanmaku.a("    https://sola.gtimg.cn/aoi/sola/20200526154505_NHZGxe56vT.png");
    paramAbsDanmaku.a(TypedValue.applyDimension(2, 14.0F, getContext().getResources().getDisplayMetrics()));
    paramAbsDanmaku.a(paramPhotoDanmakuModel.b);
    paramAbsDanmaku.c(1);
    paramAbsDanmaku.g(60.0F);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleDanmakuSmartView.OnDanmakuSmartCallback localOnDanmakuSmartCallback = this.m;
    if (localOnDanmakuSmartCallback == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "notifyDanmakuClick danmaku option listener is null.");
      return;
    }
    localOnDanmakuSmartCallback.a(paramStFeed);
  }
  
  private void a(ArrayList<PhotoDanmakuModel> paramArrayList)
  {
    paramArrayList = new HashSet(paramArrayList).iterator();
    while (paramArrayList.hasNext()) {
      HostFaceUtils.getFaceDrawable(1, 4, String.valueOf(((PhotoDanmakuModel)paramArrayList.next()).b.id.get()));
    }
  }
  
  private void a(ArrayList<AbsDanmaku> paramArrayList, int paramInt, QCircleDanmakuSmartView.DanmakuItemShowParam paramDanmakuItemShowParam)
  {
    if (paramInt > 2)
    {
      paramArrayList = (AbsDanmaku)paramArrayList.get(paramInt - 2 - 1);
      paramDanmakuItemShowParam.b = a(paramDanmakuItemShowParam.b);
      paramDanmakuItemShowParam.a = a(paramArrayList);
      return;
    }
    paramDanmakuItemShowParam.b = a(paramDanmakuItemShowParam.b);
    paramDanmakuItemShowParam.a = 0L;
  }
  
  private void a(ArrayList<AbsDanmaku> paramArrayList, int paramInt, QCircleDanmakuSmartView.DanmakuItemShowParam paramDanmakuItemShowParam, PhotoDanmakuModel paramPhotoDanmakuModel)
  {
    AbsDanmaku localAbsDanmaku = (AbsDanmaku)paramArrayList.get(paramInt - 1);
    if (paramPhotoDanmakuModel.i)
    {
      paramDanmakuItemShowParam.b = localAbsDanmaku.ad;
      paramDanmakuItemShowParam.a = a(localAbsDanmaku);
      return;
    }
    if (localAbsDanmaku.aj)
    {
      a(paramArrayList, paramInt, paramDanmakuItemShowParam);
      return;
    }
    paramArrayList = (AbsDanmaku)paramArrayList.get(paramInt - 2);
    paramDanmakuItemShowParam.b = a(paramDanmakuItemShowParam.b);
    paramDanmakuItemShowParam.a = a(paramArrayList);
  }
  
  private FeedCloudMeta.StFeed b(QCircleCommentInfo paramQCircleCommentInfo)
  {
    if ((paramQCircleCommentInfo != null) && (paramQCircleCommentInfo.b == null)) {
      return new FeedCloudMeta.StFeed();
    }
    if (paramQCircleCommentInfo != null) {
      return paramQCircleCommentInfo.b;
    }
    return null;
  }
  
  private <T> T b(List<T> paramList, int paramInt)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramInt < -1)
      {
        QLog.w("Refactor-QCircleDanmakuSmartView", 2, "[getArrayItem] position == -1.");
        return null;
      }
      if (paramInt > paramList.size())
      {
        QLog.w("Refactor-QCircleDanmakuSmartView", 2, "[getArrayItem] position is not greater than comment size.");
        return null;
      }
      return paramList.get(paramInt);
    }
    QLog.w("Refactor-QCircleDanmakuSmartView", 2, "[getArrayItem] list is empty.");
    return null;
  }
  
  private void b(ImageView paramImageView)
  {
    ApngImage.playByTag(33);
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    paramImageView.setImageDrawable(QCircleFuelAnimationManager.a("https://sola.gtimg.cn/aoi/sola/20200527150248_LGSXZNEfOh.png", new int[] { 33 }, localColorDrawable, 1));
    paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  private void b(AbsDanmaku paramAbsDanmaku)
  {
    if (paramAbsDanmaku == null)
    {
      QLog.w("Refactor-QCircleDanmakuSmartView", 1, "[doCommentLikeRequest] danmaku not is null.");
      return;
    }
    if (paramAbsDanmaku.ad())
    {
      QLog.w("Refactor-QCircleDanmakuSmartView", 2, "[doCommentLikeRequest] current danmaku is like state, not click.");
      return;
    }
    FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)b(this.b, paramAbsDanmaku.ah);
    if (localStComment == null)
    {
      QLog.w("Refactor-QCircleDanmakuSmartView", 2, "[doCommentLikeRequest] comment is null.");
      return;
    }
    Object localObject1;
    if ((paramAbsDanmaku.aj) && (localStComment.vecReply != null) && (paramAbsDanmaku.ai < localStComment.vecReply.size()) && (paramAbsDanmaku.ai >= 0)) {
      localObject1 = (FeedCloudMeta.StReply)((FeedCloudMeta.StReply)localStComment.vecReply.get(paramAbsDanmaku.ai)).get();
    } else {
      localObject1 = null;
    }
    int i1;
    if (paramAbsDanmaku.aj) {
      i1 = 5;
    } else {
      i1 = 3;
    }
    if (paramAbsDanmaku.aj)
    {
      if (localObject1 != null) {
        localObject2 = (FeedCloudMeta.StLike)((FeedCloudMeta.StReply)localObject1).likeInfo.get();
      } else {
        localObject2 = null;
      }
    }
    else
    {
      if (localStComment.likeInfo != null) {
        localObject1 = (FeedCloudMeta.StLike)localStComment.likeInfo.get();
      } else {
        localObject1 = null;
      }
      localQCircleDoLikeRequest = null;
      localObject2 = localObject1;
      localObject1 = localQCircleDoLikeRequest;
    }
    QCircleDoLikeRequest localQCircleDoLikeRequest = new QCircleDoLikeRequest(b(this.i), i1, (FeedCloudMeta.StLike)localObject2, localStComment, (FeedCloudMeta.StReply)localObject1, this.j);
    QCircleDanmakuSmartView.DoLikeSuccessParam localDoLikeSuccessParam = new QCircleDanmakuSmartView.DoLikeSuccessParam();
    if (localStComment.id != null) {
      localObject2 = localStComment.id.get();
    } else {
      localObject2 = null;
    }
    localDoLikeSuccessParam.c = ((String)localObject2);
    Object localObject2 = new QCircleDanmakuSmartView.LikeRequestParam(null);
    ((QCircleDanmakuSmartView.LikeRequestParam)localObject2).a = localStComment;
    ((QCircleDanmakuSmartView.LikeRequestParam)localObject2).b = ((FeedCloudMeta.StReply)localObject1);
    paramAbsDanmaku = new QCircleDanmakuSmartView.DoLikeRequestCallback(this, paramAbsDanmaku, (QCircleDanmakuSmartView.LikeRequestParam)localObject2);
    VSNetworkHelper.getInstance().sendRequest(localQCircleDoLikeRequest, paramAbsDanmaku);
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleDanmakuSmartView.OnDanmakuSmartCallback localOnDanmakuSmartCallback = this.m;
    if (localOnDanmakuSmartCallback == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "notifyDanmakuExport danmaku smart callback is null.");
      return;
    }
    localOnDanmakuSmartCallback.b(paramStFeed);
  }
  
  private void b(ArrayList<PhotoDanmakuModel> paramArrayList)
  {
    e();
    f();
    this.f = new PhotoDanmakuManager(getContext(), this.e, 1);
    Object localObject = this.f;
    int i2 = ViewUtils.a(60.0F);
    int i3 = DisplayUtil.d();
    int i4 = ViewUtils.a(200.0F);
    int i1 = 0;
    ((PhotoDanmakuManager)localObject).a(new Rect(0, i2, i3, i4));
    this.g = this.f.l();
    this.h = this.f.k();
    localObject = new StringBuilder();
    if (paramArrayList != null) {
      i1 = paramArrayList.size();
    }
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(" | feed id: ");
    QLog.d("Refactor-QCircleDanmakuSmartView", 2, new Object[] { "[showPhotoCommentDanmaku] show size: ", ((StringBuilder)localObject).toString(), getFeedId() });
    if (this.g != null)
    {
      paramArrayList = c(paramArrayList);
      this.g.a(paramArrayList);
    }
    paramArrayList = this.d;
    if (paramArrayList != null)
    {
      paramArrayList.setOnTouchListener(this.f);
      this.d.post(new QCircleDanmakuSmartView.1(this));
    }
    this.f.a(true);
    this.f.a(this);
    this.f.a(0L);
    QCircleHostQzoneHelper.retentionReport(QCircleHostConstants.FunctionIdConstant.QZONE_PHOTO_DANMAKU());
  }
  
  private void b(List<QCircleCommentItemInfo> paramList)
  {
    Object localObject = this.n;
    if (localObject == null) {
      this.n = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    int i1 = 0;
    while (i1 < paramList.size())
    {
      localObject = a(paramList, i1);
      this.n.add(localObject);
      a(i1, (QCircleCommentItemInfo)b(paramList, i1));
      i1 += 1;
    }
    paramList = this.n;
    if ((paramList != null) && (paramList.size() > 0))
    {
      a(this.n);
      b(this.n);
      return;
    }
    QLog.d("Refactor-QCircleDanmakuSmartView", 2, "handlePhotoCommentResult danmaku list size is 0.");
    e();
  }
  
  private ViewGroup.LayoutParams c(AbsDanmaku paramAbsDanmaku)
  {
    if (paramAbsDanmaku == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 1, "[generateFlashLayoutParams] item == null.");
      return null;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)paramAbsDanmaku.T() + PhotoDanmakuConfig.b * 2, (int)paramAbsDanmaku.S() + PhotoDanmakuConfig.c * 2);
    localLayoutParams.leftMargin = ((int)paramAbsDanmaku.l());
    localLayoutParams.topMargin = ((int)paramAbsDanmaku.m() + (int)(paramAbsDanmaku.o() - paramAbsDanmaku.m() - paramAbsDanmaku.S()) / 2 - PhotoDanmakuConfig.c);
    return localLayoutParams;
  }
  
  private ArrayList<AbsDanmaku> c(ArrayList<PhotoDanmakuModel> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 1, "[convertToDanmakuItemList] danmaku model list should not be null.");
      return localArrayList;
    }
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localArrayList.add(a(paramArrayList, localArrayList, i1));
      i1 += 1;
    }
    return localArrayList;
  }
  
  private List<QCircleCommentItemInfo> c(List<FeedCloudMeta.StComment> paramList)
  {
    if (paramList == null)
    {
      QLog.e("Refactor-QCircleDanmakuSmartView", 2, "commentList == null");
      return new ArrayList();
    }
    this.b = paramList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
      QCircleCommentItemInfo localQCircleCommentItemInfo = new QCircleCommentItemInfo(localStComment);
      int i2 = paramList.size();
      int i1 = 3;
      if (i2 == 1) {
        i1 = localStComment.vecReply.size();
      } else if (localStComment.vecReply.size() <= 3) {
        i1 = localStComment.vecReply.size();
      }
      i2 = 0;
      while (i2 < i1)
      {
        localQCircleCommentItemInfo.a(1, (FeedCloudMeta.StReply)localStComment.vecReply.get(i2));
        i2 += 1;
      }
      if (i1 < localStComment.vecReply.size()) {
        localQCircleCommentItemInfo.a(2, localStComment.vecReply.size() - i1);
      }
      localArrayList.add(localQCircleCommentItemInfo);
    }
    return localArrayList;
  }
  
  private void c(ImageView paramImageView)
  {
    ViewGroup localViewGroup = this.d;
    if ((localViewGroup != null) && (paramImageView != null)) {
      localViewGroup.removeView(paramImageView);
    }
  }
  
  private RelativeLayout.LayoutParams d(AbsDanmaku paramAbsDanmaku)
  {
    if (paramAbsDanmaku == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "generateFlameLayoutParams item is null.");
      return null;
    }
    int i2 = (int)paramAbsDanmaku.T() + PhotoDanmakuConfig.b * 2;
    int i1 = i2;
    if (i2 > ViewUtils.a(205.0F)) {
      i1 = ViewUtils.a(205.0F);
    }
    i2 = i1;
    if (i1 < ViewUtils.a(102.0F)) {
      i2 = ViewUtils.a(102.0F);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i2, (int)paramAbsDanmaku.S() + PhotoDanmakuConfig.c * 2);
    localLayoutParams.leftMargin = ((int)paramAbsDanmaku.l());
    localLayoutParams.topMargin = ((int)paramAbsDanmaku.m() + (int)(paramAbsDanmaku.o() - paramAbsDanmaku.m() - paramAbsDanmaku.S()) / 2 - PhotoDanmakuConfig.c);
    return localLayoutParams;
  }
  
  private void f()
  {
    if (this.k)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "[initDanmakuSource] current loaded danmaku source, not handler.");
      return;
    }
    QLog.d("Refactor-QCircleDanmakuSmartView", 2, new Object[] { "[initDanmakuSource] load danmaku source, feed id: ", getFeedId() });
    ViewGroup localViewGroup = this.d;
    if (localViewGroup != null) {
      removeView(localViewGroup);
    }
    this.d = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131626946, null));
    addView(this.d);
    this.e = ((TextureView)this.d.findViewById(2131446650));
    this.e.setOpaque(false);
    this.k = true;
  }
  
  private String getFeedId()
  {
    QCircleCommentInfo localQCircleCommentInfo = this.i;
    if ((localQCircleCommentInfo != null) && (localQCircleCommentInfo.b != null)) {
      return this.i.b.id.get();
    }
    return "null";
  }
  
  private FeedCloudMeta.StUser getHostUser()
  {
    FeedCloudMeta.StFeed localStFeed = b(this.i);
    if ((localStFeed != null) && (localStFeed.poster.get() != null)) {
      return (FeedCloudMeta.StUser)localStFeed.poster.get();
    }
    return null;
  }
  
  public void a()
  {
    ViewGroup localViewGroup = this.d;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(0);
    }
  }
  
  public void a(QCircleCommentInfo paramQCircleCommentInfo)
  {
    this.i = paramQCircleCommentInfo;
  }
  
  public void a(AbsDanmaku paramAbsDanmaku, PhotoDanmakuManager.TouchPoint paramTouchPoint)
  {
    if (paramAbsDanmaku == null)
    {
      QLog.w("Refactor-QCircleDanmakuSmartView", 2, "onDanmakuClicked danmaku is null? stop handler...");
      return;
    }
    if (this.d == null)
    {
      QLog.w("Refactor-QCircleDanmakuSmartView", 2, "[onDanmakuClicked] danmaku view not is null.");
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.a;
    if (l1 - l2 < 1000L)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, new Object[] { "onDanmakuClicked execute repeat, last time: ", Long.valueOf(l2), " | current time: ", Long.valueOf(System.currentTimeMillis()) });
      return;
    }
    d();
    paramTouchPoint = new StringBuilder();
    paramTouchPoint.append("onDanmakuClicked item: ");
    paramTouchPoint.append(paramAbsDanmaku.toString());
    QLog.d("Refactor-QCircleDanmakuSmartView", 2, paramTouchPoint.toString());
    this.a = System.currentTimeMillis();
    paramTouchPoint = new ImageView(getContext());
    this.d.addView(paramTouchPoint, d(paramAbsDanmaku));
    b(paramTouchPoint);
    ImageView localImageView = new ImageView(getContext());
    ViewGroup.LayoutParams localLayoutParams = c(paramAbsDanmaku);
    this.d.addView(localImageView, localLayoutParams);
    a(localImageView);
    this.c = new QCircleDanmakuSmartView.DanmakuAnimationTask(this, paramAbsDanmaku, paramTouchPoint, localImageView);
    this.d.postDelayed(this.c, 900L);
    b(paramAbsDanmaku);
    a(b(this.i));
  }
  
  public void a(List<FeedCloudMeta.StComment> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      b(c(paramList));
      return;
    }
    QLog.d("Refactor-QCircleDanmakuSmartView", 2, "[open] current comment list is empty, not open.");
  }
  
  public void b()
  {
    ViewGroup localViewGroup = this.d;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
  }
  
  public boolean c()
  {
    PhotoDanmakuManager localPhotoDanmakuManager = this.f;
    if (localPhotoDanmakuManager == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "[resume] danmaku manager is null.");
      return false;
    }
    if (localPhotoDanmakuManager.g())
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "[resume] danmaku manager playing state.");
      return false;
    }
    if (!this.l)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "[resume] current danmaku no paused state, not resume.");
      return false;
    }
    this.f.a();
    return true;
  }
  
  public boolean d()
  {
    PhotoDanmakuManager localPhotoDanmakuManager = this.f;
    if (localPhotoDanmakuManager == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "[pause] danmaku manager is null.");
      return false;
    }
    if (!localPhotoDanmakuManager.g())
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, "[pause] current danmaku animation don't start state, not pause.");
      return false;
    }
    this.l = true;
    this.f.b();
    return true;
  }
  
  public void e()
  {
    b();
    Object localObject = this.f;
    if (localObject != null)
    {
      ((PhotoDanmakuManager)localObject).d();
      this.f.c();
      this.f.e();
      this.f.a(null);
      this.f = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((TextureView)localObject).setSurfaceTextureListener(null);
      this.e = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeCallbacks(this.c);
      removeView(this.d);
      this.d = null;
    }
    this.l = false;
    this.k = false;
  }
  
  public void setContentDetailPage(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setOnDanmakuSmartCallback(QCircleDanmakuSmartView.OnDanmakuSmartCallback paramOnDanmakuSmartCallback)
  {
    this.m = paramOnDanmakuSmartCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.QCircleDanmakuSmartView
 * JD-Core Version:    0.7.0.1
 */