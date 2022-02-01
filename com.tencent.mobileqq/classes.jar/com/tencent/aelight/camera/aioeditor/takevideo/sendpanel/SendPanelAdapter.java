package com.tencent.aelight.camera.aioeditor.takevideo.sendpanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SendPanelAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private IHeaderUpdateListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIHeaderUpdateListener;
  private SendPanelPart jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart;
  private INonMainProcAvatarLoader jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
  private List<SendPanelItemInfo> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private INonMainProcAvatarLoader b;
  private INonMainProcAvatarLoader c;
  private INonMainProcAvatarLoader d;
  
  public SendPanelAdapter(Context paramContext, IHeaderUpdateListener paramIHeaderUpdateListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIHeaderUpdateListener = paramIHeaderUpdateListener;
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.f();
    this.jdField_a_of_type_Int = AIOUtils.b(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    EmptyDrawable localEmptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localEmptyDrawable, localEmptyDrawable);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getIconDrawable Exception, coverUrl=");
          localStringBuilder.append(paramString);
          QLog.e("SendPanelAdapter", 2, localStringBuilder.toString(), localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private SendPanelItemInfo a(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SendPanelItemInfo localSendPanelItemInfo = (SendPanelItemInfo)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localSendPanelItemInfo.jdField_a_of_type_JavaLangString)) && (paramString.equals(localSendPanelItemInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == localSendPanelItemInfo.jdField_a_of_type_Int))
          {
            localSendPanelItemInfo.jdField_b_of_type_Int = paramInt2;
            if (localSendPanelItemInfo.jdField_b_of_type_Int == 1) {
              localSendPanelItemInfo.jdField_b_of_type_Boolean = true;
            }
            return localSendPanelItemInfo;
          }
        }
      }
    }
    return null;
  }
  
  private void a(SendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder)
  {
    if ((paramSendPanelViewHolder != null) && (paramSendPanelViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo != null))
    {
      paramSendPanelViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(paramSendPanelViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_b_of_type_Int);
      if (paramSendPanelViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_b_of_type_Int == 1) {
        paramSendPanelViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(paramSendPanelViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_c_of_type_Int);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt3), (URLDrawable)paramString);
        }
        paramRecentDynamicAvatarView.setImageDrawable(paramString);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "url  is null ");
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a();
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(new SendPanelAdapter.1(this));
    this.b = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new SendPanelAdapter.2(this));
    this.c = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new SendPanelAdapter.3(this));
    this.d = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new SendPanelAdapter.4(this));
  }
  
  public void a()
  {
    INonMainProcAvatarLoader localINonMainProcAvatarLoader = this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
    if (localINonMainProcAvatarLoader != null) {
      localINonMainProcAvatarLoader.b();
    }
    localINonMainProcAvatarLoader = this.b;
    if (localINonMainProcAvatarLoader != null) {
      localINonMainProcAvatarLoader.b();
    }
    localINonMainProcAvatarLoader = this.d;
    if (localINonMainProcAvatarLoader != null) {
      localINonMainProcAvatarLoader.b();
    }
    a(false);
  }
  
  public void a(int paramInt, SendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder)
  {
    if ((paramSendPanelViewHolder != null) && (paramSendPanelViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo != null))
    {
      SendPanelItemInfo localSendPanelItemInfo = paramSendPanelViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo;
      if ((localSendPanelItemInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localSendPanelItemInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        paramSendPanelViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localSendPanelItemInfo.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      else
      {
        Object localObject;
        if (!TextUtils.isEmpty(localSendPanelItemInfo.d))
        {
          localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
          if (localObject != null)
          {
            paramSendPanelViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
          }
          else
          {
            localObject = localSendPanelItemInfo.d;
            int i = this.jdField_a_of_type_Int;
            a((String)localObject, i, i, paramSendPanelViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
          if ((localSendPanelItemInfo.jdField_a_of_type_Int != 0) && (localSendPanelItemInfo.jdField_a_of_type_Int != 1000) && (localSendPanelItemInfo.jdField_a_of_type_Int != 1004))
          {
            if (localSendPanelItemInfo.jdField_a_of_type_Int == 1)
            {
              if (localSendPanelItemInfo.jdField_c_of_type_Boolean) {
                localObject = this.c.a(localSendPanelItemInfo.jdField_a_of_type_JavaLangString, true);
              } else {
                localObject = this.b.a(localSendPanelItemInfo.jdField_a_of_type_JavaLangString, true);
              }
            }
            else if (localSendPanelItemInfo.jdField_a_of_type_Int == 3000) {
              localObject = this.d.a(localSendPanelItemInfo.jdField_a_of_type_JavaLangString, true);
            }
          }
          else {
            localObject = this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(localSendPanelItemInfo.jdField_a_of_type_JavaLangString, true);
          }
          if (localObject != null) {
            paramSendPanelViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          }
        }
      }
      paramSendPanelViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localSendPanelItemInfo.jdField_c_of_type_JavaLangString);
      paramSendPanelViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(paramSendPanelViewHolder);
      paramSendPanelViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(paramSendPanelViewHolder);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
    }
  }
  
  public void a(int paramInt, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramInt >= 0)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      if ((localList != null) && (paramInt <= localList.size()) && (paramSendPanelItemInfo != null))
      {
        this.jdField_a_of_type_JavaUtilList.set(paramInt, paramSendPanelItemInfo);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "onUpdate return");
    }
  }
  
  public void a(SendPanelPart paramSendPanelPart)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart = paramSendPanelPart;
  }
  
  public void a(List<SendPanelItemInfo> paramList)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "setData list is empty");
      }
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "setData do not need refresh");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "onEditUpdate");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (SendPanelItemInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((SendPanelItemInfo)localObject).e)) && (TextUtils.isEmpty(((SendPanelItemInfo)localObject).g))) {
        return;
      }
      if (paramBoolean)
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart;
        if (localObject != null) {
          CaptureReportUtil.c(((SendPanelPart)localObject).a);
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SendPanelItemInfo)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0)) {
      return TextUtils.isEmpty(((SendPanelItemInfo)this.jdField_a_of_type_JavaUtilList.get(0)).e) ^ true;
    }
    return false;
  }
  
  public void b()
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
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
      return (SendPanelItemInfo)localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt < localList.size())) {
      try
      {
        long l = Long.parseLong(((SendPanelItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
        return l;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getItemId exception = ");
          localStringBuilder.append(localException.getMessage());
          QLog.d("SendPanelAdapter", 2, localStringBuilder.toString());
        }
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (SendPanelItemInfo)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562839, null);
      localSendPanelViewHolder = new SendPanelAdapter.SendPanelViewHolder(this);
      localSendPanelViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368343));
      localSendPanelViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371697));
      localSendPanelViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131372171));
      localSendPanelViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo = paramViewGroup;
      a(paramInt, localSendPanelViewHolder);
      paramView.setTag(localSendPanelViewHolder);
      return paramView;
    }
    SendPanelAdapter.SendPanelViewHolder localSendPanelViewHolder = (SendPanelAdapter.SendPanelViewHolder)paramView.getTag();
    localSendPanelViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo = paramViewGroup;
    a(paramInt, localSendPanelViewHolder);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof SendPanelAdapter.SendPanelViewHolder))
    {
      paramView = (SendPanelAdapter.SendPanelViewHolder)paramView.getTag();
      if (paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
        }
        return;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onClick operateStatus = ");
        ((StringBuilder)localObject1).append(paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_b_of_type_Int);
        QLog.d("SendPanelAdapter", 2, ((StringBuilder)localObject1).toString());
      }
      int i = paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_b_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
          {
            paramView = this.jdField_a_of_type_AndroidContentContext;
            QQToast.a(paramView, paramView.getString(2131719240), 0).a();
            return;
          }
          localObject1 = a(paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_Int, 1);
          if (localObject1 != null)
          {
            paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo = ((SendPanelItemInfo)localObject1);
            a(paramView);
            PeakIpcController.b((SendPanelItemInfo)localObject1);
          }
          paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart;
          if (paramView != null) {
            CaptureReportUtil.a(paramView.a, (SendPanelItemInfo)localObject1);
          }
        }
        else
        {
          localObject1 = a(paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_Int, 0);
          if (localObject1 != null)
          {
            paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo = ((SendPanelItemInfo)localObject1);
            a(paramView);
            PeakIpcController.a((SendPanelItemInfo)localObject1);
          }
          paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart;
          if (paramView != null) {
            CaptureReportUtil.b(paramView.a, (SendPanelItemInfo)localObject1);
          }
        }
      }
      else
      {
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          paramView = this.jdField_a_of_type_AndroidContentContext;
          QQToast.a(paramView, paramView.getString(2131719240), 0).a();
          return;
        }
        if (!TextUtils.isEmpty(paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.g))
        {
          localObject1 = a(paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_Int, 1);
          if (localObject1 != null)
          {
            paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo = ((SendPanelItemInfo)localObject1);
            a(paramView);
            if (((SendPanelItemInfo)localObject1).jdField_a_of_type_Boolean) {
              PeakIpcController.a(((SendPanelItemInfo)localObject1).e, ((SendPanelItemInfo)localObject1).f, (SendPanelItemInfo)localObject1, SendPanelManager.a().jdField_a_of_type_JavaLangString, SendPanelManager.a().a());
            } else {
              PeakIpcController.a(((SendPanelItemInfo)localObject1).e, (SendPanelItemInfo)localObject1, SendPanelManager.a().jdField_a_of_type_JavaLangString, SendPanelManager.a().a());
            }
          }
          Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart;
          if (localObject2 != null) {
            CaptureReportUtil.c(((SendPanelPart)localObject2).a, (SendPanelItemInfo)localObject1);
          }
          localObject2 = (IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class);
          paramView = paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.g;
          if (localObject1 == null) {
            i = -1;
          } else {
            i = ((SendPanelItemInfo)localObject1).jdField_a_of_type_Int;
          }
          ((IAEBaseDataReporter)localObject2).reportPostBtn(paramView, i);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("【OnClick】messageType:");
          if (localObject1 == null) {
            paramView = "-1";
          } else {
            paramView = Integer.valueOf(((SendPanelItemInfo)localObject1).jdField_a_of_type_Int);
          }
          ((StringBuilder)localObject2).append(paramView);
          AEQLog.b("SendPanelAdapter", ((StringBuilder)localObject2).toString());
          return;
        }
        ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart.a.a(20, paramView.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelPart.a.f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelAdapter
 * JD-Core Version:    0.7.0.1
 */