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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RecentLiveTipItemBuilder
  extends RecentItemBaseBuilder
{
  public static int a;
  private List a;
  private int b;
  private int c;
  
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
      paramView = a(paramContext, 2130971490, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362719));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131363207));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131374905));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131374906));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131363201));
      paramViewGroup.d = ((TextView)paramView.findViewById(16908309));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363202);
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
      }
      this.b = paramContext.getResources().getDisplayMetrics().widthPixels;
      this.jdField_c_of_type_Int = ((int)paramViewGroup.b.getPaint().measureText(paramViewGroup.b.getText().toString()));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.b) {
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
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        paramViewGroup.d.setText("");
        paramViewGroup.c.setText("");
      }
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
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
    int m = 0;
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof RecentLiveTipItemBuilder.RecentLiveTipItemHolder)) {}
    for (paramDrawable = (RecentLiveTipItemBuilder.RecentLiveTipItemHolder)localObject1;; paramDrawable = null)
    {
      if (paramDrawable == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject1);
        return;
      }
      if (!(paramRecentBaseData instanceof RecentItemNearbyLiveTipData)) {
        break;
      }
      localObject1 = ((RecentItemNearbyLiveTipData)paramRecentBaseData).a;
      if (localObject1 == null) {
        break;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramDrawable.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramDrawable.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ImageUtil.b();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ImageUtil.b();
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
      try
      {
        localObject2 = URLDrawable.getDrawable(((MessageForNearbyLiveTip)localObject1).headUrl, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
        paramDrawable.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        paramDrawable.jdField_a_of_type_AndroidWidgetTextView.setText(((MessageForNearbyLiveTip)localObject1).nickName);
        if ((MessageForNearbyLiveTip.isHuayangTip(((MessageForNearbyLiveTip)localObject1).jumpingUrl)) && (!((MessageForNearbyLiveTip)localObject1).isLiving))
        {
          if (!TextUtils.isEmpty(((MessageForNearbyLiveTip)localObject1).c2cMsgWording)) {
            ((MessageForNearbyLiveTip)localObject1).msg = ((MessageForNearbyLiveTip)localObject1).c2cMsgWording;
          }
        }
        else
        {
          paramDrawable.d.setText(((MessageForNearbyLiveTip)localObject1).msg);
          if ((!((MessageForNearbyLiveTip)localObject1).isLiving) || (MessageForNearbyLiveTip.isGroupVideoTip(((MessageForNearbyLiveTip)localObject1).jumpingUrl))) {
            break label501;
          }
        }
      }
      catch (Exception localException)
      {
        label645:
        for (;;)
        {
          int i;
          int j;
          int k;
          try
          {
            localObject1 = NearbyImgDownloader.a("http://8.url.cn/huayang/resource/now/gift/ilive_animation.gif");
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
            localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
            paramDrawable.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
            paramDrawable.b.setVisibility(0);
            paramDrawable.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
            paramDrawable.c.setVisibility(8);
            a(paramDrawable, paramContext);
            i = paramRecentBaseData.jdField_c_of_type_Int;
            j = paramRecentBaseData.b;
            if (i <= 0) {
              break label645;
            }
            if (j != 0) {
              break label545;
            }
            paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            k = 99;
            j = 0;
            i = 0;
            CustomWidgetUtil.a(paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
            return;
            localException = localException;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("Q.nearby.tag_nearby_live_tip", 2, "url=" + ((MessageForNearbyLiveTip)localObject1).headUrl);
            continue;
            ((MessageForNearbyLiveTip)localObject1).msg = ((MessageForNearbyLiveTip)localObject1).liveEndWording;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.nearby.freshNews", 2, "RecentLiveTipItemBuilder getview get nowBoardcastGif error, " + localMalformedURLException);
            continue;
          }
          label501:
          paramDrawable.b.setVisibility(8);
          paramDrawable.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          paramDrawable.c.setVisibility(0);
          paramDrawable.c.setText(paramRecentBaseData.jdField_c_of_type_JavaLangString);
          continue;
          label545:
          if (j == 2)
          {
            paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            k = 99;
            i = 1;
            j = 0;
          }
          else if (j == 3)
          {
            if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
            paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
            j = 2130846056;
            m = i;
            i = 3;
            k = 99;
          }
          else
          {
            j = 2130846055;
            paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
            m = i;
            i = 3;
            k = 99;
            continue;
            k = 99;
            j = 0;
            i = 0;
          }
        }
      }
    }
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
        i = ScreenUtil.a(12.0F);
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), i, localView.getPaddingBottom());
        paramRecentLiveTipItemHolder.setMaxWidth(this.b - this.jdField_c_of_type_Int - ScreenUtil.a(113.0F));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentLiveTipItemBuilder
 * JD-Core Version:    0.7.0.1
 */