package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.apollo.meme.ApolloPlayerParams;
import com.tencent.mobileqq.apollo.meme.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.meme.action.MODE;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.action.MemeCommonAction;
import com.tencent.mobileqq.apollo.meme.api.IApolloBrickPlayer;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class CmshowFaceGridAdapter
  extends BaseAdapter
{
  private Context a;
  private List<CmAvatarFaceInfo> b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public CmshowFaceGridAdapter(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramContext;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  private URLDrawable a(String paramString, int paramInt)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mGifRoundCorner = paramInt;
    localURLDrawableOptions.mUseMemoryCache = true;
    return URLDrawable.getFileDrawable(paramString, localURLDrawableOptions);
  }
  
  public void a(List<CmAvatarFaceInfo> paramList)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.clear();
    this.b.addAll(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.b;
    if (localList != null) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    Object localObject1;
    if (this.b == null)
    {
      localObject2 = paramView;
    }
    else if (paramView == null)
    {
      localObject1 = new CmshowFaceGridAdapter.CmshowFaceItemHolder(this);
      localObject2 = LayoutInflater.from(this.a).inflate(2131628285, paramViewGroup, false);
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).c = ((RelativeLayout)((View)localObject2).findViewById(2131430897));
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).a = ((VasAvatar)((View)localObject2).findViewById(2131430903));
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).b = ((ImageView)((View)localObject2).findViewById(2131430904));
      paramView = ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).c.getLayoutParams();
      if (paramView != null)
      {
        paramView.width = this.c;
        paramView.height = this.d;
      }
      else
      {
        QLog.d("AvatarPendantAdapter", 2, "getLayoutParams null, it's sad");
        paramView = new ViewGroup.LayoutParams(this.c, this.d);
      }
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).c.setLayoutParams(paramView);
      ((View)localObject2).setTag(localObject1);
      paramView = (View)localObject2;
    }
    else
    {
      localObject1 = (CmshowFaceGridAdapter.CmshowFaceItemHolder)paramView.getTag();
    }
    for (;;)
    {
      try
      {
        CmAvatarFaceInfo localCmAvatarFaceInfo = (CmAvatarFaceInfo)getItem(paramInt);
        localObject2 = paramView;
        if (localCmAvatarFaceInfo != null)
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = (this.c - ViewUtils.dip2px(10.0F));
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = (this.d - ViewUtils.dip2px(10.0F));
          if (TextUtils.isEmpty(localCmAvatarFaceInfo.getIcon())) {
            localObject2 = URLDrawableHelper.getLoadingDrawable();
          } else {
            localObject2 = URLDrawable.getDrawable(localCmAvatarFaceInfo.getIcon(), (URLDrawable.URLDrawableOptions)localObject2);
          }
          ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).a.setImageDrawable((Drawable)localObject2);
          ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).c.setTag(localCmAvatarFaceInfo);
          ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).a.setVisibility(8);
          if (((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).e != null) {
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).c.removeView(((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).e);
          }
          int i = this.c - ViewUtils.dip2px(10.0F);
          int j = this.d - ViewUtils.dip2px(10.0F);
          int k = localCmAvatarFaceInfo.getActionId();
          int m = localCmAvatarFaceInfo.getActionType();
          Object localObject3 = "";
          if (!(this.a instanceof AvatarPendantActivity)) {
            break label846;
          }
          localObject3 = ((AvatarPendantActivity)this.a).app.getCurrentUin();
          localIGetGifFrameCallback = ((AvatarPendantActivity)this.a).au;
          Object localObject4 = (IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class);
          if (((IApolloAvatarFileManager)localObject4).isHasGif(k, m, (String)localObject3))
          {
            localObject2 = ((IApolloAvatarFileManager)localObject4).getGifFilePath(k, m, (String)localObject3);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).a.setImageDrawable(a((String)localObject2, i));
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).a.setVisibility(0);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("isHasGif,actionId:");
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append(";gifpath: ");
            ((StringBuilder)localObject1).append((String)localObject2);
            QLog.i("CmshowFaceGridAdapter", 1, ((StringBuilder)localObject1).toString());
          }
          else
          {
            localObject4 = new ApolloPlayerParams(this.a, i, j, i);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).d = ((IApolloBrickPlayer)QRoute.api(IApolloBrickPlayer.class));
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).d.setParams((ApolloPlayerParams)localObject4);
            localObject4 = ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).d.getView();
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).c.addView((View)localObject4, localLayoutParams);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).e = ((View)localObject4);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).e.setVisibility(0);
            localObject3 = new MemeCommonAction(k, m, (String)localObject3, "", "");
            ((MemeAction)localObject3).a(MODE.ACTION_MODE_RECORD_GIF);
            ((MemeAction)localObject3).j().b(ApolloConstant.l);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).d.setAction((MemeAction)localObject3);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).d.setGetGifFrameCallback(localIGetGifFrameCallback);
            if (localObject2 != null) {
              ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).d.setLoadingView((Drawable)localObject2);
            }
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).d.start();
            QLog.i("CmshowFaceGridAdapter", 1, "notHasGif,mApolloBrickPlayer new");
          }
          this.f = MobileQQ.getContext().getSharedPreferences("facechoosedata", 0).getInt("ChooseFaceId", 0);
          if (this.f == localCmAvatarFaceInfo.getActionId())
          {
            paramView.setBackgroundDrawable(this.a.getResources().getDrawable(2130849295));
            localObject2 = paramView;
          }
          else
          {
            paramView.setBackgroundDrawable(null);
            localObject2 = paramView;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("AvatarCmshowFace getView error :");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.d("CmshowFaceGridAdapter", 1, ((StringBuilder)localObject2).toString());
        localObject2 = paramView;
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
      return localObject2;
      label846:
      IGetGifFrameCallback localIGetGifFrameCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.CmshowFaceGridAdapter
 * JD-Core Version:    0.7.0.1
 */