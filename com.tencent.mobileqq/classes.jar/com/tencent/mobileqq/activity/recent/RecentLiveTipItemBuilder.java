package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.nearby.NearbyCardManager;
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
  
  private void a(FragmentActivity paramFragmentActivity, MessageForNearbyLiveTip paramMessageForNearbyLiveTip)
  {
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForNearbyLiveTip.senderuin);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForNearbyLiveTip.senderuin, Boolean.valueOf(true));
      paramFragmentActivity = paramFragmentActivity.app;
      ThreadManagerV2.excute(new RecentLiveTipItemBuilder.1(this, paramFragmentActivity, paramMessageForNearbyLiveTip, (NearbyCardManager)paramFragmentActivity.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 32, null, false);
    }
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, RecentLiveTipItemBuilder.RecentLiveTipItemHolder paramRecentLiveTipItemHolder)
  {
    MessageForNearbyLiveTip localMessageForNearbyLiveTip;
    Object localObject;
    if ((paramRecentBaseData instanceof RecentItemNearbyLiveTipData))
    {
      localMessageForNearbyLiveTip = ((RecentItemNearbyLiveTipData)paramRecentBaseData).nearbyLiveTipMsg;
      if (localMessageForNearbyLiveTip != null) {
        if (MsgProxyUtils.c(localMessageForNearbyLiveTip.senderuin))
        {
          if (paramRecentBaseData.getUnreadNum() >= 1) {
            break label355;
          }
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "msg_box", "assist_exp", 0, 0, "", "", "", (String)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ImageUtil.c();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ImageUtil.c();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      try
      {
        localObject = URLDrawable.getDrawable(localMessageForNearbyLiveTip.headUrl, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
        paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject);
        paramRecentLiveTipItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForNearbyLiveTip.nickName);
        if ((MessageForNearbyLiveTip.isHuayangTip(localMessageForNearbyLiveTip.jumpingUrl)) && (!localMessageForNearbyLiveTip.isLiving))
        {
          if (!TextUtils.isEmpty(localMessageForNearbyLiveTip.c2cMsgWording)) {
            localMessageForNearbyLiveTip.msg = localMessageForNearbyLiveTip.c2cMsgWording;
          }
        }
        else
        {
          paramRecentLiveTipItemHolder.d.setText(localMessageForNearbyLiveTip.msg);
          if (localMessageForNearbyLiveTip.senderuin.equals(String.valueOf(1822701914L + AppConstants.NOW_LIVE_TIP_UIN_BASE))) {
            localMessageForNearbyLiveTip.isLiving = false;
          }
          if ((!localMessageForNearbyLiveTip.isLiving) || (MessageForNearbyLiveTip.isGroupVideoTip(localMessageForNearbyLiveTip.jumpingUrl))) {
            break label457;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            localObject = NearbyImgDownloader.convertURL("https://8.url.cn/huayang/resource/now/gift/ilive_animation.gif");
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mPlayGifImage = true;
            localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
            paramRecentLiveTipItemHolder.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject);
            paramRecentLiveTipItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramRecentLiveTipItemHolder.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(0);
            paramRecentLiveTipItemHolder.c.setVisibility(8);
            a(paramRecentLiveTipItemHolder, paramContext);
            b(paramView, paramRecentBaseData, paramContext, paramRecentLiveTipItemHolder);
            a((FragmentActivity)paramContext, localMessageForNearbyLiveTip);
            return;
            label355:
            localObject = "1";
            break;
            localException = localException;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("Q.nearby.tag_nearby_live_tip", 2, "url=" + localMessageForNearbyLiveTip.headUrl);
            continue;
            localMessageForNearbyLiveTip.msg = localMessageForNearbyLiveTip.liveEndWording;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.nearby.freshNews", 2, "RecentLiveTipItemBuilder getview get nowBoardcastGif error, " + localMalformedURLException);
            continue;
          }
          label457:
          paramRecentLiveTipItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          paramRecentLiveTipItemHolder.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
          paramRecentLiveTipItemHolder.c.setVisibility(0);
          paramRecentLiveTipItemHolder.c.setText(paramRecentBaseData.mShowTime);
        }
      }
    }
  }
  
  private void b(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, RecentLiveTipItemBuilder.RecentLiveTipItemHolder paramRecentLiveTipItemHolder)
  {
    int j = 1;
    int k = 0;
    int i = paramRecentBaseData.mUnreadNum;
    int m = paramRecentBaseData.mUnreadFlag;
    if (i > 0) {
      if (m == 0)
      {
        paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
        j = 0;
        i = 0;
      }
    }
    for (;;)
    {
      CustomWidgetUtil.a(paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
      return;
      if (m == 2)
      {
        paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
        m = 0;
        i = j;
        j = m;
      }
      else if (m == 3)
      {
        paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
        paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167163));
        j = 2130850838;
        m = 3;
        k = i;
        i = m;
      }
      else
      {
        j = 2130850834;
        paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
        paramRecentLiveTipItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167164));
        k = i;
        i = 3;
        continue;
        j = 0;
        i = 0;
      }
    }
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if ((paramView.getTag() instanceof RecentLiveTipItemBuilder.RecentLiveTipItemHolder)) {
        paramViewGroup = (RecentLiveTipItemBuilder.RecentLiveTipItemHolder)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new RecentLiveTipItemBuilder.RecentLiveTipItemHolder();
      paramView = a(paramContext, 2131562920, paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)paramView.findViewById(2131368603));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380944));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370551));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)paramView.findViewById(2131370549));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131370043));
      paramViewGroup.d = ((TextView)paramView.findViewById(16908309));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379093);
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
      }
      this.b = paramContext.getResources().getDisplayMetrics().widthPixels;
      this.c = ((int)paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getText().toString()));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.d) {
        paramView.setContentDescription(null);
      }
      if ((paramObject instanceof RecentBaseData))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramOnDragModeChangedListener = null;
        if (paramRecentFaceDecoder != null) {
          paramOnDragModeChangedListener = paramRecentFaceDecoder.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramOnDragModeChangedListener);
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
        paramViewGroup.d.setText("");
        paramViewGroup.c.setText("");
      }
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = paramView.getTag();
      paramDrawable = null;
      if ((localObject instanceof RecentLiveTipItemBuilder.RecentLiveTipItemHolder)) {
        paramDrawable = (RecentLiveTipItemBuilder.RecentLiveTipItemHolder)localObject;
      }
      if (paramDrawable != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
    return;
    a(paramView, paramRecentBaseData, paramContext, paramDrawable);
  }
  
  protected void a(RecentLiveTipItemBuilder.RecentLiveTipItemHolder paramRecentLiveTipItemHolder, Context paramContext)
  {
    try
    {
      localObject = paramRecentLiveTipItemHolder.c;
      localView = paramRecentLiveTipItemHolder.jdField_a_of_type_AndroidViewView;
      paramRecentLiveTipItemHolder = paramRecentLiveTipItemHolder.jdField_a_of_type_AndroidWidgetTextView;
      if (((TextView)localObject).getVisibility() != 0)
      {
        i = ScreenUtil.dip2px(12.0F);
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), i, localView.getPaddingBottom());
        paramRecentLiveTipItemHolder.setMaxWidth(this.b - this.c - ScreenUtil.dip2px(113.0F));
        return;
      }
      paramRecentLiveTipItemHolder = TimeManager.a().a("000000", 1225168973512L);
      if (!TextUtils.isEmpty(paramRecentLiveTipItemHolder)) {
        break label318;
      }
      paramRecentLiveTipItemHolder = TimeManager.a().a();
    }
    catch (Exception paramRecentLiveTipItemHolder)
    {
      Object localObject;
      View localView;
      int i;
      float f;
      int j;
      label292:
      label318:
      while (QLog.isDevelopLevel())
      {
        QLog.i("RecentLiveTipItemBuilder", 4, paramRecentLiveTipItemHolder.toString());
        return;
        jdField_a_of_type_Int = i;
        continue;
        jdField_a_of_type_Int = (int)(paramContext.measureText("yyyy-MM-dd") + f * 6.0F);
        continue;
        i = 0;
      }
    }
    if ((!TextUtils.isEmpty(paramRecentLiveTipItemHolder)) && (paramRecentLiveTipItemHolder.length() != "yyyy-MM-dd".length()))
    {
      i = 1;
      if ((jdField_a_of_type_Int <= 0) || (i != 0))
      {
        f = paramContext.getResources().getDisplayMetrics().density;
        localObject = ((TextView)localObject).getPaint();
        paramContext = (Context)localObject;
        if (localObject == null)
        {
          paramContext = new TextPaint();
          paramContext.setTextSize(f * 12.0F);
        }
        if (i == 0) {
          break label292;
        }
        i = (int)(paramContext.measureText("yyyy-MM-dd") + f * 6.0F);
        j = (int)(paramContext.measureText(paramRecentLiveTipItemHolder) + f * 6.0F);
        if (j > i) {
          jdField_a_of_type_Int = j;
        }
      }
      else
      {
        i = localView.getPaddingRight();
        if (i >= jdField_a_of_type_Int) {
          return;
        }
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), i, localView.getPaddingBottom());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentLiveTipItemBuilder
 * JD-Core Version:    0.7.0.1
 */