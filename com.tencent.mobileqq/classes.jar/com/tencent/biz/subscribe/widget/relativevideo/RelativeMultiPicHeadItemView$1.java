package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.transition.TransitionAnimHelper;
import com.tencent.biz.subscribe.widget.SubscribeBannerView.BannerAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class RelativeMultiPicHeadItemView$1
  extends SubscribeBannerView.BannerAdapter
{
  RelativeMultiPicHeadItemView$1(RelativeMultiPicHeadItemView paramRelativeMultiPicHeadItemView) {}
  
  private String a(Object paramObject)
  {
    if ((paramObject instanceof CertifiedAccountMeta.StImage)) {
      return ((CertifiedAccountMeta.StImage)paramObject).url.get();
    }
    return "";
  }
  
  protected View a(View paramView, Object paramObject)
  {
    Object localObject = a(paramObject);
    if (((paramObject instanceof CertifiedAccountMeta.StImage)) && (RelativeMultiPicHeadItemView.a(this.a) != 0))
    {
      paramObject = (CertifiedAccountMeta.StImage)paramObject;
      if ((paramObject.width.get() != 0) && (paramObject.height.get() != 0))
      {
        float f = paramObject.height.get() / paramObject.width.get();
        paramObject = paramView.getLayoutParams();
        int j = (int)(RelativeMultiPicHeadItemView.a(this.a) / f);
        int i = j;
        if (j > RelativeMultiPicHeadItemView.b(this.a)) {
          i = RelativeMultiPicHeadItemView.b(this.a);
        }
        paramObject.width = i;
        paramObject.height = RelativeMultiPicHeadItemView.a(this.a);
      }
    }
    if (localObject != null) {
      try
      {
        paramObject = TransitionAnimHelper.a((String)localObject);
        if (!TextUtils.isEmpty(paramObject))
        {
          paramObject = new File(paramObject);
          if (paramObject.exists())
          {
            ((URLImageView)paramView).setImageURI(Uri.fromFile(paramObject));
            return paramView;
          }
        }
        SubImageLoader.a((String)localObject, (URLImageView)paramView);
        return paramView;
      }
      catch (Error paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindItemView set local image path error!error:");
        ((StringBuilder)localObject).append(paramObject.getMessage());
        QLog.d("RelativeMultiPicHeadItemView", 1, ((StringBuilder)localObject).toString());
        return paramView;
      }
      catch (Exception paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindItemView set local image path error!exception:");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("RelativeMultiPicHeadItemView", 1, ((StringBuilder)localObject).toString());
      }
    }
    return paramView;
  }
  
  protected URLImageView a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new URLImageView(paramViewGroup.getContext());
    int i;
    if (RelativeMultiPicHeadItemView.a(this.a) == 0) {
      i = -1;
    } else {
      i = RelativeMultiPicHeadItemView.a(this.a);
    }
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView.1
 * JD-Core Version:    0.7.0.1
 */