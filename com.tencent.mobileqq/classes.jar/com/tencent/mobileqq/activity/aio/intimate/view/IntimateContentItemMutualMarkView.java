package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.info.EmptyStatusInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.MutualMarkConfBean;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkConfigHelper;
import com.tencent.mobileqq.mutualmark.alienation.MutualMarkAlienationHelper;
import com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType;
import com.tencent.mobileqq.notification.modularize.PushUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class IntimateContentItemMutualMarkView
  extends IntimateContentItemBaseView
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IntimateContentItemMutualMarkView.FriendMaskAdapter jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView$FriendMaskAdapter;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private RoundRectImageView jdField_a_of_type_ComTencentWidgetRoundRectImageView;
  private ArrayList<IntimateInfo.MutualMarkInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int c = 1;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  
  public IntimateContentItemMutualMarkView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemMutualMarkView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemMutualMarkView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    if (paramPrefetchMutualMarkInfo == null) {
      return null;
    }
    Bitmap localBitmap2 = a(paramPrefetchMutualMarkInfo.iconStaticUrl);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      i = MutualMarkConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), paramPrefetchMutualMarkInfo.type, paramPrefetchMutualMarkInfo.level);
      if (i == 0) {
        return null;
      }
      localBitmap2 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), i);
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        return null;
      }
    }
    localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    int j = localBitmap1.getHeight() + 32;
    int i = j;
    if (paramPrefetchMutualMarkInfo.days > 0) {
      i = j * paramPrefetchMutualMarkInfo.currentDays / paramPrefetchMutualMarkInfo.days;
    }
    i = 16 + localBitmap1.getHeight() - i;
    paramPrefetchMutualMarkInfo = new Rect(0, 0, localBitmap1.getWidth(), i);
    localCanvas.drawBitmap(localBitmap1, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, localPaint);
    paramPrefetchMutualMarkInfo = new Rect(0, i, localBitmap1.getWidth(), localBitmap1.getHeight());
    localCanvas.drawBitmap(localBitmap1, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, null);
    return localBitmap2;
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject1 = PushUtil.a.a(paramString);
      return localObject1;
    }
    catch (Exception paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("intimate_relationship", 2, "PushUtil.INSTANCE.getBitmapFromUrl() error = " + paramString);
    }
    return null;
  }
  
  private String a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo, boolean paramBoolean)
  {
    paramPrefetchMutualMarkInfo = "intimate_" + paramPrefetchMutualMarkInfo.type + paramPrefetchMutualMarkInfo.level + paramPrefetchMutualMarkInfo.days + paramPrefetchMutualMarkInfo.currentDays + paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "cacheName" + paramPrefetchMutualMarkInfo);
    }
    return paramPrefetchMutualMarkInfo;
  }
  
  private void a(ImageView paramImageView, String paramString, Drawable paramDrawable, int paramInt)
  {
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable, null, null);
    paramDrawable = paramImageView.getLayoutParams();
    paramDrawable.width = paramDrawable.height;
    paramImageView.setImageDrawable(null);
    paramImageView.setImageDrawable(paramString);
    paramImageView.setLayoutParams(paramDrawable);
    if (paramInt == 17)
    {
      paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      return;
    }
    paramImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  private void a(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("getPrefetchMarkIcon, type=%s, currDay=%s, day=%s", new Object[] { Integer.valueOf(paramPrefetchMutualMarkInfo.type), Integer.valueOf(paramPrefetchMutualMarkInfo.currentDays), Integer.valueOf(paramPrefetchMutualMarkInfo.days) }));
    }
    ThreadManager.getSubThreadHandler().post(new IntimateContentItemMutualMarkView.1(this, paramPrefetchMutualMarkInfo));
  }
  
  private boolean a(IntimateInfo.MutualMarkInfo paramMutualMarkInfo)
  {
    if (paramMutualMarkInfo == null) {}
    for (;;)
    {
      return false;
      if ((paramMutualMarkInfo == null) || (MutualMarkConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), paramMutualMarkInfo.type)))
      {
        int i = MutualMarkConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), paramMutualMarkInfo.type, paramMutualMarkInfo.level);
        if (paramMutualMarkInfo.type == 5) {
          paramMutualMarkInfo.iconStaticUrl = MutualMarkAlienationHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), paramMutualMarkInfo.type, paramMutualMarkInfo.level, paramMutualMarkInfo.subLevel, paramMutualMarkInfo.iconStaticUrl);
        }
        MutualMarkConfigIRType localMutualMarkConfigIRType = MutualMarkConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), paramMutualMarkInfo.type);
        if ((localMutualMarkConfigIRType != null) && (localMutualMarkConfigIRType.b)) {
          i = 0;
        }
        while ((!TextUtils.isEmpty(paramMutualMarkInfo.iconStaticUrl)) || (i != 0)) {
          return true;
        }
      }
    }
  }
  
  private Bitmap b(IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    int j = AIOUtils.a(56.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Bitmap localBitmap = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas1 = new Canvas(localBitmap);
    Object localObject = new RectF(0.0F, 0.0F, j, j);
    RectF localRectF = new RectF(2, 2, j - 2, j - 2);
    Paint localPaint = new Paint(1);
    localPaint.setColor(Color.parseColor("#E8E9F3"));
    localCanvas1.drawRoundRect((RectF)localObject, 14, 14, localPaint);
    localPaint.setColor(-1);
    localCanvas1.drawRoundRect(localRectF, 12, 12, localPaint);
    localObject = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas2 = new Canvas((Bitmap)localObject);
    localPaint.setColor(Color.parseColor("#F2F4F9"));
    localCanvas2.drawRoundRect(localRectF, 12, 12, localPaint);
    if (paramPrefetchMutualMarkInfo.days > 0) {}
    for (int i = paramPrefetchMutualMarkInfo.currentDays * j / paramPrefetchMutualMarkInfo.days;; i = j)
    {
      paramPrefetchMutualMarkInfo = new Rect(0, j - i, j, j);
      localCanvas1.drawBitmap((Bitmap)localObject, paramPrefetchMutualMarkInfo, paramPrefetchMutualMarkInfo, null);
      return localBitmap;
    }
  }
  
  private void m()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a())) && (NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a()))) {
      ((IntimateInfoHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
    }
  }
  
  protected void a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559383, this, true);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131367583);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)localView.findViewById(2131367584));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369207));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131368662));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368666));
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = ((RoundRectImageView)localView.findViewById(2131368667));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setTransTouchStateToParent(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView$FriendMaskAdapter = new IntimateContentItemMutualMarkView.FriendMaskAdapter(this, null);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(ViewUtils.a(5.0F));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView$FriendMaskAdapter);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode(ViewUtils.b(6.0F), 1);
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), QQBrowserActivity.class);
      String str = MutualMarkConfProcessor.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("goToC2CWebPage, url: %s", new Object[] { str }));
      }
      paramView.putExtra("url", str);
      paramView.putExtra("finish_animation_out_to_right", true);
      paramView.putExtra("is_wrap_content", true);
      paramView.putExtra("hide_left_button", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().startActivity(paramView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.isShowRedPoint)
      {
        m();
        this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.isShowRedPoint = false;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        MutualMarkBusinessLogicHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      }
      if (this.f)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B68E", "0X800B68E", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X8009F50", "0X8009F50", this.c, 0, "", "", "", "");
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.emptyStatusInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.emptyStatusInfo.a)));
    if (QQBrowserActivity.checkNotFrequentlyThenEnter(1000L))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B68D", "0X800B68D", 0, 0, "", "", "", "");
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.emptyStatusInfo.a);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    QQToast.a(getContext(), 1, this.jdField_a_of_type_AndroidContentContext.getString(2131693480), 0).a();
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    paramInt = 8;
    setVisibility(0);
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemMutualMarkView$FriendMaskAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    for (this.f = false;; this.f = true)
    {
      this.jdField_d_of_type_Boolean = MutualMarkBusinessLogicHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((paramIntimateInfo.isShowRedPoint) || (this.jdField_d_of_type_Boolean)) {
        paramInt = 0;
      }
      localImageView.setVisibility(paramInt);
      return;
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  protected boolean a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Iterator localIterator;
    IntimateInfo.MutualMarkInfo localMutualMarkInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.markInfoList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.markInfoList.size() > 0))
    {
      localIterator = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.markInfoList.iterator();
      while (localIterator.hasNext())
      {
        localMutualMarkInfo = (IntimateInfo.MutualMarkInfo)localIterator.next();
        if (a(localMutualMarkInfo))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localMutualMarkInfo);
          this.jdField_d_of_type_Int += 1;
        }
      }
      if (this.jdField_e_of_type_Boolean) {
        ReportController.b(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.c, 0, "", "", "", "");
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.prefetchMutualMarkInfoList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.prefetchMutualMarkInfoList.size() > 0))
    {
      localIterator = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.prefetchMutualMarkInfoList.iterator();
      while (localIterator.hasNext())
      {
        localMutualMarkInfo = (IntimateInfo.MutualMarkInfo)localIterator.next();
        if (a(localMutualMarkInfo))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localMutualMarkInfo);
          this.jdField_e_of_type_Int += 1;
        }
      }
      if (this.jdField_e_of_type_Boolean) {
        ReportController.b(null, "dc00898", "", "", "0X8009F52", "0X8009F52", this.c, 0, "", "", "", "");
      }
    }
    return true;
  }
  
  public void setNeedReportPage(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setReportType(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemMutualMarkView
 * JD-Core Version:    0.7.0.1
 */