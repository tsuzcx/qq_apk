package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.URLThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecentLiveTipItemBuilder
  extends RecentItemBaseBuilder
{
  public static int a;
  private List<String> jdField_a_of_type_JavaUtilList;
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int b;
  private int c;
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, RecentLiveTipItemBuilder.RecentLiveTipItemHolder paramRecentLiveTipItemHolder)
  {
    MessageForNearbyLiveTip localMessageForNearbyLiveTip;
    Object localObject1;
    if ((paramRecentBaseData instanceof RecentItemNearbyLiveTipData))
    {
      localMessageForNearbyLiveTip = ((RecentItemNearbyLiveTipData)paramRecentBaseData).nearbyLiveTipMsg;
      if (localMessageForNearbyLiveTip != null)
      {
        if (MsgProxyUtils.c(localMessageForNearbyLiveTip.senderuin))
        {
          if (paramRecentBaseData.getUnreadNum() < 1) {
            localObject1 = "0";
          } else {
            localObject1 = "1";
          }
          ReportController.b(null, "dc00899", "grp_lbs", "", "msg_box", "assist_exp", 0, 0, "", "", "", (String)localObject1);
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ImageUtil.e();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ImageUtil.e();
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      }
    }
    try
    {
      localObject1 = URLDrawable.getDrawable(localMessageForNearbyLiveTip.headUrl, (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
      paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject1);
    }
    catch (Exception localException)
    {
      label161:
      break label161;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("url=");
      ((StringBuilder)localObject1).append(localMessageForNearbyLiveTip.headUrl);
      QLog.i("Q.nearby.tag_nearby_live_tip", 2, ((StringBuilder)localObject1).toString());
    }
    paramRecentLiveTipItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForNearbyLiveTip.nickName);
    if ((MessageForNearbyLiveTip.isHuayangTip(localMessageForNearbyLiveTip.jumpingUrl)) && (!localMessageForNearbyLiveTip.isLiving)) {
      if (!TextUtils.isEmpty(localMessageForNearbyLiveTip.c2cMsgWording)) {
        localMessageForNearbyLiveTip.msg = localMessageForNearbyLiveTip.c2cMsgWording;
      } else {
        localMessageForNearbyLiveTip.msg = localMessageForNearbyLiveTip.liveEndWording;
      }
    }
    paramRecentLiveTipItemHolder.d.setText(localMessageForNearbyLiveTip.msg);
    if (localMessageForNearbyLiveTip.senderuin.equals(String.valueOf(AppConstants.NOW_LIVE_TIP_UIN_BASE + 1822701914L))) {
      localMessageForNearbyLiveTip.isLiving = false;
    }
    if ((localMessageForNearbyLiveTip.isLiving) && (!MessageForNearbyLiveTip.isGroupVideoTip(localMessageForNearbyLiveTip.jumpingUrl)))
    {
      try
      {
        localObject1 = NearbyImgDownloader.convertURL("https://8.url.cn/huayang/resource/now/gift/ilive_animation.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramRecentLiveTipItemHolder.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject1);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RecentLiveTipItemBuilder getview get nowBoardcastGif error, ");
          ((StringBuilder)localObject2).append(localMalformedURLException);
          QLog.d("Q.nearby.freshNews", 2, ((StringBuilder)localObject2).toString());
        }
      }
      paramRecentLiveTipItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramRecentLiveTipItemHolder.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(0);
      paramRecentLiveTipItemHolder.c.setVisibility(8);
    }
    else
    {
      paramRecentLiveTipItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramRecentLiveTipItemHolder.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
      paramRecentLiveTipItemHolder.c.setVisibility(0);
      paramRecentLiveTipItemHolder.c.setText(paramRecentBaseData.mShowTime);
    }
    a(paramRecentLiveTipItemHolder, paramContext);
    b(paramView, paramRecentBaseData, paramContext, paramRecentLiveTipItemHolder);
    a((BaseActivity)paramContext, localMessageForNearbyLiveTip);
  }
  
  private void a(BaseActivity paramBaseActivity, MessageForNearbyLiveTip paramMessageForNearbyLiveTip)
  {
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForNearbyLiveTip.senderuin);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForNearbyLiveTip.senderuin, Boolean.valueOf(true));
      paramBaseActivity = paramBaseActivity.app;
      ThreadManagerV2.excute(new RecentLiveTipItemBuilder.1(this, paramBaseActivity, paramMessageForNearbyLiveTip, (INearbyCardManager)paramBaseActivity.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 32, null, false);
    }
  }
  
  private void b(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, RecentLiveTipItemBuilder.RecentLiveTipItemHolder paramRecentLiveTipItemHolder)
  {
    int j = paramRecentBaseData.mUnreadNum;
    int i = paramRecentBaseData.mUnreadFlag;
    if (j > 0) {
      if (i == 0)
      {
        paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
      }
      else
      {
        if (i == 2)
        {
          paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
          i = 1;
          break label144;
        }
        if (i == 3)
        {
          paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
          paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167188));
          i = 3;
          k = 2130850774;
          break label150;
        }
        paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
        paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167189));
        i = 3;
        k = 2130850770;
        break label150;
      }
    }
    i = 0;
    label144:
    j = 0;
    int k = 0;
    label150:
    CustomWidgetUtil.a(paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    if ((paramView != null) && ((paramView.getTag() instanceof RecentLiveTipItemBuilder.RecentLiveTipItemHolder))) {
      paramViewGroup = (RecentLiveTipItemBuilder.RecentLiveTipItemHolder)paramView.getTag();
    } else {
      paramViewGroup = null;
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new RecentLiveTipItemBuilder.RecentLiveTipItemHolder();
      paramView = a(paramContext, 2131562735, paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)paramView.findViewById(2131368343));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380210));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370210));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)paramView.findViewById(2131370208));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131369727));
      paramViewGroup.d = ((TextView)paramView.findViewById(16908309));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378462);
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
      }
      this.b = paramContext.getResources().getDisplayMetrics().widthPixels;
      this.c = ((int)paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getText().toString()));
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    if (AppSetting.d) {
      paramView.setContentDescription(null);
    }
    if ((paramObject instanceof RecentBaseData))
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a(localRecentBaseData);
      }
      a(paramView, localRecentBaseData, paramContext, paramOnDragModeChangedListener);
    }
    else
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
      paramViewGroup.d.setText("");
      paramViewGroup.c.setText("");
    }
    a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
    paramView.setOnClickListener(paramOnClickListener);
    paramView.setOnLongClickListener(paramOnLongClickListener);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    return paramView;
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData != null) && (paramContext != null))
    {
      paramRecentBaseData = paramContext.getResources();
      paramContext = this.jdField_a_of_type_JavaUtilList;
      if (paramContext == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      } else {
        paramContext.clear();
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      Object localObject = paramView.getTag();
      paramDrawable = null;
      if ((localObject instanceof RecentLiveTipItemBuilder.RecentLiveTipItemHolder)) {
        paramDrawable = (RecentLiveTipItemBuilder.RecentLiveTipItemHolder)localObject;
      }
      if (paramDrawable == null)
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("bindView|holder is null, tag = ");
          paramView.append(localObject);
          QLog.i("Q.recent", 2, paramView.toString());
        }
        return;
      }
      a(paramView, paramRecentBaseData, paramContext, paramDrawable);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "bindView|param invalidate");
    }
  }
  
  protected void a(RecentLiveTipItemBuilder.RecentLiveTipItemHolder paramRecentLiveTipItemHolder, Context paramContext)
  {
    try
    {
      TextView localTextView = paramRecentLiveTipItemHolder.c;
      View localView = paramRecentLiveTipItemHolder.jdField_a_of_type_AndroidViewView;
      paramRecentLiveTipItemHolder = paramRecentLiveTipItemHolder.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView.getVisibility() != 0)
      {
        i = ScreenUtil.dip2px(12.0F);
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), i, localView.getPaddingBottom());
        paramRecentLiveTipItemHolder.setMaxWidth(this.b - this.c - ScreenUtil.dip2px(113.0F));
        return;
      }
      Object localObject = TimeManager.a().a("000000", 1225168973512L);
      paramRecentLiveTipItemHolder = (RecentLiveTipItemBuilder.RecentLiveTipItemHolder)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramRecentLiveTipItemHolder = TimeManager.a().a();
      }
      int j = 0;
      int i = j;
      if (!TextUtils.isEmpty(paramRecentLiveTipItemHolder))
      {
        i = j;
        if (paramRecentLiveTipItemHolder.length() != 10) {
          i = 1;
        }
      }
      if ((jdField_a_of_type_Int <= 0) || (i != 0))
      {
        float f2 = paramContext.getResources().getDisplayMetrics().density;
        localObject = localTextView.getPaint();
        paramContext = (Context)localObject;
        if (localObject == null)
        {
          paramContext = new TextPaint();
          paramContext.setTextSize(12.0F * f2);
        }
        if (i != 0)
        {
          float f1 = paramContext.measureText("yyyy-MM-dd");
          f2 *= 6.0F;
          i = (int)(f1 + f2);
          j = (int)(paramContext.measureText(paramRecentLiveTipItemHolder) + f2);
          if (j > i) {
            jdField_a_of_type_Int = j;
          } else {
            jdField_a_of_type_Int = i;
          }
        }
        else
        {
          jdField_a_of_type_Int = (int)(paramContext.measureText("yyyy-MM-dd") + f2 * 6.0F);
        }
      }
      i = localView.getPaddingRight();
      if (i < jdField_a_of_type_Int)
      {
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), i, localView.getPaddingBottom());
        return;
      }
    }
    catch (Exception paramRecentLiveTipItemHolder)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("RecentLiveTipItemBuilder", 4, paramRecentLiveTipItemHolder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentLiveTipItemBuilder
 * JD-Core Version:    0.7.0.1
 */