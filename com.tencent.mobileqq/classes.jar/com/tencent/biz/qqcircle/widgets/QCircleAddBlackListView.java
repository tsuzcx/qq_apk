package com.tencent.biz.qqcircle.widgets;

import aazb;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import blir;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import vxv;
import vxw;

public class QCircleAddBlackListView
  extends TextView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  
  public QCircleAddBlackListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleAddBlackListView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleAddBlackListView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleFollowView);
    this.jdField_b_of_type_Int = paramContext.getResourceId(2, 2130843914);
    this.jdField_a_of_type_Int = paramContext.getResourceId(4, 2130843916);
    this.c = paramContext.getColor(3, getResources().getColor(2131166241));
    this.d = paramContext.getColor(5, getResources().getColor(2131166240));
    a();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.set(paramInt);
      QLog.d("QCircleAddBlackListView", 1, "uin:" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get() + " state:" + paramInt);
    }
    if (getVisibility() == 8) {
      return;
    }
    if (paramInt == 0)
    {
      c();
      return;
    }
    b();
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 0;
    int i;
    VSNetworkHelper localVSNetworkHelper;
    String str;
    if (!paramBoolean)
    {
      i = 1;
      if (paramBoolean) {
        j = 1;
      }
      localVSNetworkHelper = VSNetworkHelper.a();
      str = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get();
      if (!paramBoolean) {
        break label72;
      }
    }
    label72:
    for (int k = 1;; k = 2)
    {
      localVSNetworkHelper.a(new QCircleSetUnCareRequest(str, k, 1, null), new vxw(this, j, i));
      return;
      i = 0;
      break;
    }
  }
  
  private void d()
  {
    blir localblir = blir.a(getContext());
    localblir.a(getContext().getResources().getString(2131697166));
    localblir.a(2131694098, 3);
    localblir.c(2131690580);
    localblir.a(new vxv(this, localblir));
    if (!localblir.isShowing()) {
      localblir.show();
    }
  }
  
  protected URLDrawable a(int paramInt, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt);
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  protected void a()
  {
    setOnClickListener(this);
    b();
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_reload_get_main_page");
    localIntent.putExtra("uin", paramString);
    if (getContext() != null) {
      getContext().sendBroadcast(localIntent);
    }
  }
  
  protected void b()
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      setBackgroundDrawable(a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString));
    }
    for (;;)
    {
      setTextColor(this.d);
      setText(2131697325);
      return;
      setBackgroundResource(this.jdField_a_of_type_Int);
    }
  }
  
  protected void c()
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      setBackgroundDrawable(a(this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      setTextColor(this.c);
      setText(2131697170);
      return;
      setBackgroundResource(this.jdField_b_of_type_Int);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((aazb.a("QCircleblackViewClick")) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 1) {
        a(false);
      } else if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.get() == 0) {
        d();
      }
    }
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAddBlackListView
 * JD-Core Version:    0.7.0.1
 */