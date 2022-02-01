package com.tencent.gdtad.api.feedback;

import android.graphics.drawable.Drawable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.AdFeedbackItemModel;
import com.tencent.gdtad.aditem.GdtAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class GdtFeedbackModel
{
  private static final String b = "GdtFeedbackModel";
  protected ArrayList<GdtFeedbackModel.GdtFeedbackItemModel> a = new ArrayList(5);
  private boolean c;
  private boolean d;
  private GdtAd e;
  
  private void f()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      GdtFeedbackModel.GdtFeedbackItemModel localGdtFeedbackItemModel = (GdtFeedbackModel.GdtFeedbackItemModel)localIterator.next();
      GdtFeedbackModel.GdtFeedbackItemModel.b(localGdtFeedbackItemModel);
      GdtFeedbackModel.GdtFeedbackItemModel.c(localGdtFeedbackItemModel);
    }
  }
  
  public AdError a()
  {
    AdLog.i(b, "[loadData] start loading");
    if (!this.e.isValid())
    {
      AdLog.i(b, "[loadData] mAd is invalid");
      return new AdError(4);
    }
    Object localObject1 = this.e.getFeedbackItems();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
      try
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AdFeedbackDialogFragment.AdFeedbackItemModel)((Iterator)localObject1).next();
          localObject3 = new GdtFeedbackModel.GdtFeedbackItemModel();
          GdtFeedbackModel.GdtFeedbackItemModel.a((GdtFeedbackModel.GdtFeedbackItemModel)localObject3, ((AdFeedbackDialogFragment.AdFeedbackItemModel)localObject2).mIconUrl);
          GdtFeedbackModel.GdtFeedbackItemModel.a((GdtFeedbackModel.GdtFeedbackItemModel)localObject3, ((AdFeedbackDialogFragment.AdFeedbackItemModel)localObject2).mReportType);
          GdtFeedbackModel.GdtFeedbackItemModel.b((GdtFeedbackModel.GdtFeedbackItemModel)localObject3, ((AdFeedbackDialogFragment.AdFeedbackItemModel)localObject2).mActionType);
          GdtFeedbackModel.GdtFeedbackItemModel.b((GdtFeedbackModel.GdtFeedbackItemModel)localObject3, ((AdFeedbackDialogFragment.AdFeedbackItemModel)localObject2).mText);
          GdtFeedbackModel.GdtFeedbackItemModel.c((GdtFeedbackModel.GdtFeedbackItemModel)localObject3, "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/web%E5%BC%80%E5%8F%91%E7%BB%84/%E8%B5%84%E6%BA%90%E6%96%87%E4%BB%B6/%E7%AE%AD%E5%A4%B4-%E6%A8%AA%E7%89%88@2x.png");
          GdtFeedbackModel.GdtFeedbackItemModel.d((GdtFeedbackModel.GdtFeedbackItemModel)localObject3, ((AdFeedbackDialogFragment.AdFeedbackItemModel)localObject2).mJumpUrl);
          GdtFeedbackModel.GdtFeedbackItemModel.e((GdtFeedbackModel.GdtFeedbackItemModel)localObject3, this.e.getUrlForFeedBack());
          this.a.add(localObject3);
        }
        f();
        AdLog.i(b, "[loadData] finish loading successfully");
        return new AdError(0);
      }
      catch (Exception localException)
      {
        Object localObject2 = b;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[loadData] fail to load data: ");
        ((StringBuilder)localObject3).append(localException.getMessage());
        AdLog.e((String)localObject2, ((StringBuilder)localObject3).toString());
        return new AdError(4);
      }
    }
    return new AdError(4);
  }
  
  public void a(int paramInt)
  {
    GdtFeedbackModel.GdtFeedbackItemModel.a((GdtFeedbackModel.GdtFeedbackItemModel)this.a.get(paramInt));
  }
  
  public void a(GdtAd paramGdtAd)
  {
    this.e = paramGdtAd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public int b()
  {
    return this.a.size();
  }
  
  public int b(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.d((GdtFeedbackModel.GdtFeedbackItemModel)this.a.get(paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public Drawable c(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.e((GdtFeedbackModel.GdtFeedbackItemModel)this.a.get(paramInt));
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public String d(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.f((GdtFeedbackModel.GdtFeedbackItemModel)this.a.get(paramInt));
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public String e(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.g((GdtFeedbackModel.GdtFeedbackItemModel)this.a.get(paramInt));
  }
  
  public String f(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.h((GdtFeedbackModel.GdtFeedbackItemModel)this.a.get(paramInt));
  }
  
  public Drawable g(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.i((GdtFeedbackModel.GdtFeedbackItemModel)this.a.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackModel
 * JD-Core Version:    0.7.0.1
 */