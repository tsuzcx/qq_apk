package com.tencent.mobileqq.apollo.api.ui.impl;

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
import com.tencent.mobileqq.apollo.api.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.api.player.ApolloPlayerParams;
import com.tencent.mobileqq.apollo.api.player.IApolloBrickPlayer;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.CMSCommonAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.player.IGetGifFrameCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.video.QzoneLiveVideoInterface;
import java.util.ArrayList;
import java.util.List;

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
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new CmshowFaceGridAdapter.CmshowFaceItemHolder(this);
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562034, paramViewGroup, false);
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject2).findViewById(2131364903));
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = ((VasAvatar)((View)localObject2).findViewById(2131364909));
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131364910));
      paramView = ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramView != null)
      {
        paramView.width = this.jdField_a_of_type_Int;
        paramView.height = this.b;
        label131:
        ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
        ((View)localObject2).setTag(localObject1);
        paramView = (View)localObject2;
      }
    }
    try
    {
      label150:
      localCmAvatarFaceInfo = (CmAvatarFaceInfo)getItem(paramInt);
      if (localCmAvatarFaceInfo == null) {
        break label572;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = (this.jdField_a_of_type_Int - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = (this.b - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      if (!TextUtils.isEmpty(localCmAvatarFaceInfo.getIcon())) {
        break label619;
      }
      localObject2 = URLDrawableHelper.getLoadingDrawable();
      label224:
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setImageDrawable((Drawable)localObject2);
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localCmAvatarFaceInfo);
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setVisibility(8);
      i = this.jdField_a_of_type_Int - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      j = this.b - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      localObject3 = new ApolloPlayerParams(this.jdField_a_of_type_AndroidContentContext, i, j, i);
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer = ((IApolloBrickPlayer)QRoute.api(IApolloBrickPlayer.class));
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.setParams((ApolloPlayerParams)localObject3);
      localObject3 = ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.getView();
      localObject4 = new RelativeLayout.LayoutParams(i, j);
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject3);
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
      i = localCmAvatarFaceInfo.getActionId();
      j = localCmAvatarFaceInfo.getActionType();
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof AvatarPendantActivity)) {
        break label678;
      }
      localObject4 = ((AvatarPendantActivity)this.jdField_a_of_type_AndroidContentContext).app.getCurrentUin();
      localObject3 = ((AvatarPendantActivity)this.jdField_a_of_type_AndroidContentContext).a;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        CmAvatarFaceInfo localCmAvatarFaceInfo;
        int i;
        int j;
        QLog.d("CmshowFaceGridAdapter", 1, "AvatarCmshowFace getView error :" + localThrowable.getMessage());
        continue;
        Object localObject3 = null;
        Object localObject4 = "";
      }
    }
    localObject4 = new CMSCommonAction(i, j, (String)localObject4, "", "");
    ((CMSAction)localObject4).a(MODE.ACTION_MODE_RECORD_GIF);
    ((CMSAction)localObject4).a().b(ApolloConstant.c);
    ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.setAction((CMSAction)localObject4);
    ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.setGetGifFrameCallback((IGetGifFrameCallback)localObject3);
    if (localObject2 != null) {
      ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.setLoadingView((Drawable)localObject2);
    }
    ((CmshowFaceGridAdapter.CmshowFaceItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.start();
    this.d = QzoneLiveVideoInterface.getSharedPreferences("facechoosedata", 0).getInt("ChooseFaceId", 0);
    if (this.d == localCmAvatarFaceInfo.getActionId()) {
      paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847768));
    }
    for (;;)
    {
      label572:
      localObject1 = paramView;
      break;
      QLog.d("AvatarPendantAdapter", 2, "getLayoutParams null, it's sad");
      paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.b);
      break label131;
      localObject1 = (CmshowFaceGridAdapter.CmshowFaceItemHolder)paramView.getTag();
      break label150;
      label619:
      localObject2 = URLDrawable.getDrawable(localCmAvatarFaceInfo.getIcon(), (URLDrawable.URLDrawableOptions)localObject2);
      break label224;
      paramView.setBackgroundDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ui.impl.CmshowFaceGridAdapter
 * JD-Core Version:    0.7.0.1
 */