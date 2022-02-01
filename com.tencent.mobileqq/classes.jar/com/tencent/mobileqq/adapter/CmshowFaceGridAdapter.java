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
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.player.ApolloPlayerParams;
import com.tencent.mobileqq.apollo.player.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.CMSCommonAction;
import com.tencent.mobileqq.apollo.player.action.MODE;
import com.tencent.mobileqq.apollo.player.api.IApolloBrickPlayer;
import com.tencent.mobileqq.apollo.player.model.BusinessConfig;
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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<CmAvatarFaceInfo> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  private int d;
  
  public CmshowFaceGridAdapter(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
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
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
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
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      localObject2 = paramView;
    }
    else if (paramView == null)
    {
      localObject1 = new CmshowFaceGridAdapter.CmshowFaceItemHolder(this);
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561867, paramViewGroup, false);
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject2).findViewById(2131364789));
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = ((VasAvatar)((View)localObject2).findViewById(2131364795));
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131364796));
      paramView = ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramView != null)
      {
        paramView.width = this.jdField_a_of_type_Int;
        paramView.height = this.b;
      }
      else
      {
        QLog.d("AvatarPendantAdapter", 2, "getLayoutParams null, it's sad");
        paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.b);
      }
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
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
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = (this.jdField_a_of_type_Int - ViewUtils.a(10.0F));
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = (this.b - ViewUtils.a(10.0F));
          if (TextUtils.isEmpty(localCmAvatarFaceInfo.getIcon())) {
            localObject2 = URLDrawableHelper.getLoadingDrawable();
          } else {
            localObject2 = URLDrawable.getDrawable(localCmAvatarFaceInfo.getIcon(), (URLDrawable.URLDrawableOptions)localObject2);
          }
          ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setImageDrawable((Drawable)localObject2);
          ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localCmAvatarFaceInfo);
          ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setVisibility(8);
          if (((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidViewView != null) {
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidViewView);
          }
          int i = this.jdField_a_of_type_Int - ViewUtils.a(10.0F);
          int j = this.b - ViewUtils.a(10.0F);
          int k = localCmAvatarFaceInfo.getActionId();
          int m = localCmAvatarFaceInfo.getActionType();
          Object localObject3 = "";
          if (!(this.jdField_a_of_type_AndroidContentContext instanceof AvatarPendantActivity)) {
            break label846;
          }
          localObject3 = ((AvatarPendantActivity)this.jdField_a_of_type_AndroidContentContext).app.getCurrentUin();
          localIGetGifFrameCallback = ((AvatarPendantActivity)this.jdField_a_of_type_AndroidContentContext).a;
          Object localObject4 = (IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class);
          if (((IApolloAvatarFileManager)localObject4).isHasGif(k, m, (String)localObject3))
          {
            localObject2 = ((IApolloAvatarFileManager)localObject4).getGifFilePath(k, m, (String)localObject3);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setImageDrawable(a((String)localObject2, i));
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setVisibility(0);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("isHasGif,actionId:");
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append(";gifpath: ");
            ((StringBuilder)localObject1).append((String)localObject2);
            QLog.i("CmshowFaceGridAdapter", 1, ((StringBuilder)localObject1).toString());
          }
          else
          {
            localObject4 = new ApolloPlayerParams(this.jdField_a_of_type_AndroidContentContext, i, j, i);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer = ((IApolloBrickPlayer)QRoute.api(IApolloBrickPlayer.class));
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer.setParams((ApolloPlayerParams)localObject4);
            localObject4 = ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer.getView();
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject4, localLayoutParams);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject4);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            localObject3 = new CMSCommonAction(k, m, (String)localObject3, "", "");
            ((CMSAction)localObject3).a(MODE.ACTION_MODE_RECORD_GIF);
            ((CMSAction)localObject3).a().b(ApolloConstant.b);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer.setAction((CMSAction)localObject3);
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer.setGetGifFrameCallback(localIGetGifFrameCallback);
            if (localObject2 != null) {
              ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer.setLoadingView((Drawable)localObject2);
            }
            ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer.start();
            QLog.i("CmshowFaceGridAdapter", 1, "notHasGif,mApolloBrickPlayer new");
          }
          this.d = MobileQQ.getContext().getSharedPreferences("facechoosedata", 0).getInt("ChooseFaceId", 0);
          if (this.d == localCmAvatarFaceInfo.getActionId())
          {
            paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847635));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.CmshowFaceGridAdapter
 * JD-Core Version:    0.7.0.1
 */