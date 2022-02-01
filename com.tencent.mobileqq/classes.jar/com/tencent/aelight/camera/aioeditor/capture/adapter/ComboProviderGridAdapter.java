package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.util.List;

public class ComboProviderGridAdapter
  extends BaseAdapter
  implements Handler.Callback
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  public GridView a;
  List<QIMFilterCategoryItem> jdField_a_of_type_JavaUtilList;
  float b;
  float c;
  
  public ComboProviderGridAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = ViewUtils.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject2).setId(2131368343);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131368744);
    ((ImageView)localObject2).setVisibility(8);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject2).setImageResource(2130844513);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)localObject2).setId(2131371631);
    ((LinearLayout)localObject2).setOrientation(0);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject3).setImageResource(2130844514);
    Object localObject4 = new LinearLayout.LayoutParams(ViewUtils.b(11.0F), ViewUtils.b(4.5F));
    ((LinearLayout.LayoutParams)localObject4).gravity = 16;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setId(2131371653);
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
    ((TextView)localObject3).setMaxLines(1);
    ((TextView)localObject3).setLines(1);
    ((TextView)localObject3).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    localObject4 = new LinearLayout.LayoutParams(-2, -2);
    i = ViewUtils.b(5.0F);
    ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
    ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject3).setImageResource(2130844514);
    localObject4 = new LinearLayout.LayoutParams(ViewUtils.b(11.0F), ViewUtils.b(4.5F));
    ((LinearLayout.LayoutParams)localObject4).gravity = 16;
    ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131369017);
    ((RelativeLayout)localObject2).setBackgroundResource(2130844574);
    ((RelativeLayout)localObject2).setVisibility(8);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ViewUtils.b(16.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844575), null);
    ((TextView)localObject3).setCompoundDrawablePadding(ViewUtils.b(4.0F));
    ((TextView)localObject3).setText(HardCodeUtil.a(2131702354));
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(13, -1);
    ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131366842);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setLines(1);
    ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ViewUtils.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131366846);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131365257);
    ((ImageView)localObject1).setImageResource(2130846131);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131381214);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public static void a(ImageView paramImageView, CaptureComboBase paramCaptureComboBase, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    VideoFilterTools.a();
    boolean bool1 = VideoFilterTools.a(3, paramQIMFilterCategoryItem.jdField_a_of_type_Int, paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    int i = paramCaptureComboBase.jdField_a_of_type_Int;
    boolean bool2 = ((CaptureComboManager)QIMManager.a(5)).a().a(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    if ((!bool2) && (!paramQIMFilterCategoryItem.jdField_a_of_type_Boolean) && (!bool1))
    {
      paramImageView.setVisibility(8);
      return;
    }
    paramImageView.setVisibility(0);
    if (bool2)
    {
      paramImageView.setImageResource(2130844607);
      return;
    }
    if (bool1)
    {
      paramImageView.setImageResource(2130846132);
      return;
    }
    if (i != 1) {
      if (i != 2)
      {
        if (i == 3) {}
      }
      else
      {
        paramImageView.setImageResource(2130846131);
        return;
      }
    }
    paramImageView.setVisibility(8);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 600L);
  }
  
  public void a(int paramInt)
  {
    QIMFilterCategoryItem localQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).a().a;
    if ((localQIMFilterCategoryItem != null) && (localQIMFilterCategoryItem.jdField_a_of_type_Int == paramInt)) {
      a();
    }
  }
  
  public void a(ImageView paramImageView, AnimationDrawable paramAnimationDrawable, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation ");
    }
    ImageView localImageView = new ImageView(paramImageView.getContext());
    PopupWindow localPopupWindow = new PopupWindow(localImageView, -2, -2, true);
    localPopupWindow.setTouchable(true);
    localPopupWindow.setClippingEnabled(false);
    localPopupWindow.setOutsideTouchable(true);
    localPopupWindow.setBackgroundDrawable(new ColorDrawable(16777215));
    int[] arrayOfInt = new int[2];
    paramImageView.getLocationOnScreen(arrayOfInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showUnlockAnimation ");
      localStringBuilder.append(arrayOfInt[0]);
      localStringBuilder.append(",");
      localStringBuilder.append(arrayOfInt[1]);
      QLog.i("ComboProviderGridAdapter", 2, localStringBuilder.toString());
    }
    int j = ScreenUtil.dip2px(60.0F);
    int k = paramImageView.getWidth();
    int i = arrayOfInt[0];
    j = (j - k) / 2;
    localPopupWindow.showAtLocation(paramImageView, 8388659, i - j, arrayOfInt[1] - j);
    paramAnimationDrawable.setOneShot(true);
    paramAnimationDrawable = new ComboProviderGridAdapter.LockAnimationDrawable(paramAnimationDrawable, localImageView, localPopupWindow, paramImageView, paramQIMFilterCategoryItem);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ComboProviderGridAdapter.1(this, paramImageView), 200L);
    localImageView.setImageDrawable(paramAnimationDrawable);
    paramAnimationDrawable.start();
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Float <= 0.0F) && (paramViewGroup != null))
    {
      this.jdField_a_of_type_Float = paramViewGroup.getMeasuredWidth();
      this.b = ((this.jdField_a_of_type_Float - FilterProviderPagerAdapter.b * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4.0F + 0.5F);
      this.c = (this.b * 12.0F / 160.0F);
    }
    if (paramView == null) {
      paramView = a();
    }
    TextView localTextView1 = (TextView)paramView.findViewById(2131366842);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131368744);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131368343);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131365257);
    TextView localTextView2 = (TextView)paramView.findViewById(2131371653);
    View localView = paramView.findViewById(2131371631);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131366846);
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    Object localObject = VideoFilterTools.a().a[this.jdField_a_of_type_Int];
    paramViewGroup = null;
    if (localObject != null) {
      paramViewGroup = (QIMFilterCategoryItem)((ComboSet)localObject).a;
    }
    boolean bool1;
    if (paramViewGroup != null) {
      bool1 = TextUtils.equals(paramViewGroup.jdField_a_of_type_JavaLangString, localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1) {
      if (((paramViewGroup == null) || (paramViewGroup.b())) && (localQIMFilterCategoryItem.b())) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    paramView.setTag(localQIMFilterCategoryItem);
    localObject = (AbsListView.LayoutParams)paramView.getLayoutParams();
    paramViewGroup = (ViewGroup)localObject;
    if (localObject == null)
    {
      paramViewGroup = new AbsListView.LayoutParams(-1, -1);
      paramView.setLayoutParams(paramViewGroup);
    }
    paramViewGroup.height = ((int)this.b);
    if (localQIMFilterCategoryItem.b())
    {
      localImageView3.setVisibility(8);
      if (bool2) {
        localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844516));
      } else {
        localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844517));
      }
      localImageView2.setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(HardCodeUtil.a(2131702355));
      localView.setVisibility(8);
    }
    else
    {
      localTextView1.setVisibility(8);
      paramViewGroup = localCaptureComboManager.a(localQIMFilterCategoryItem);
      if (!TextUtils.isEmpty(localQIMFilterCategoryItem.b))
      {
        localView.setVisibility(0);
        localTextView2.setText(localQIMFilterCategoryItem.b);
      }
      else
      {
        localTextView2.setText("");
        localView.setVisibility(8);
      }
      if (bool2)
      {
        localImageView3.setImageResource(2130844515);
        localImageView3.setVisibility(0);
        localTextView1.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167004));
      }
      else
      {
        localImageView3.setVisibility(8);
        localTextView1.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167004));
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844512);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844512);
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      localQIMCommonLoadingView.setMax(10000);
      localObject = URLDrawable.getDrawable(localQIMFilterCategoryItem.d, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 2) {
        ((URLDrawable)localObject).restartDownload();
      }
      localImageView1.setImageDrawable((Drawable)localObject);
      localTextView1.setText(localQIMFilterCategoryItem.b);
      if (localQIMFilterCategoryItem.f())
      {
        localImageView2.setVisibility(8);
        paramViewGroup = (ImageView)paramView.findViewById(2131381214);
        paramViewGroup.setImageResource(2130846136);
        paramViewGroup.setVisibility(0);
        WeishiGuideUtils.a(localQIMFilterCategoryItem);
      }
      else
      {
        ((ImageView)paramView.findViewById(2131381214)).setVisibility(8);
        localQIMCommonLoadingView.setVisibility(0);
        localQIMCommonLoadingView.setBgCorner(this.c);
        localQIMCommonLoadingView.a(QIMCommonLoadingProgress.a(paramViewGroup));
        a(localImageView2, paramViewGroup, localQIMFilterCategoryItem);
      }
    }
    if (localCaptureComboManager.a().a != null) {
      this.jdField_a_of_type_AndroidOsHandler.hasMessages(9);
    }
    return paramView;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 0;
    if (j == 9)
    {
      paramMessage = this.jdField_a_of_type_ComTencentWidgetGridView;
      if ((paramMessage != null) && (paramMessage.isShown()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ComboLockManager", 2, "checkAnim");
        }
        j = this.jdField_a_of_type_ComTencentWidgetGridView.getChildCount();
        paramMessage = (CaptureComboManager)QIMManager.a(5);
        QIMFilterCategoryItem localQIMFilterCategoryItem = paramMessage.a().a;
        if (localQIMFilterCategoryItem != null) {
          while (i < j)
          {
            Object localObject1 = this.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i);
            Object localObject2 = ((View)localObject1).getTag();
            if ((QIMFilterCategoryItem.class.isInstance(localObject2)) && (((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaLangString.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)))
            {
              try
              {
                localObject1 = (ImageView)((View)localObject1).findViewById(2131365257);
                localObject2 = (AnimationDrawable)((ImageView)localObject1).getContext().getResources().getDrawable(2130844686);
                paramMessage.a().a = null;
                a((ImageView)localObject1, (AnimationDrawable)localObject2, localQIMFilterCategoryItem);
                return true;
              }
              catch (Exception paramMessage)
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
              }
              QLog.i("ComboProviderGridAdapter", 2, "showUnlockAnimation err", paramMessage);
              return true;
            }
            i += 1;
          }
        }
        return true;
      }
      QLog.i("ComboLockManager", 1, "checkAnim err, ignore");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */