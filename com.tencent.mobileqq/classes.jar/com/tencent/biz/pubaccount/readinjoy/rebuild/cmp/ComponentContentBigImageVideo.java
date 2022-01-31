package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class ComponentContentBigImageVideo
  extends ComponentContentBig
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public ComponentContentBigImageVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentBigImageVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentBigImageVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969563, this, true);
  }
  
  public URL a(IReadInJoyModel paramIReadInJoyModel)
  {
    Object localObject = paramIReadInJoyModel.a();
    if (paramIReadInJoyModel.a() == 51)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentBigImageVideo", 2, "PolymericArticle use first page url");
      }
      paramIReadInJoyModel = ((ArticleInfo)localObject).mSinglePicture;
    }
    do
    {
      return paramIReadInJoyModel;
      localObject = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(false);
      if (localObject == null) {
        break;
      }
      paramIReadInJoyModel = (IReadInJoyModel)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("ComponentContentBigImageVideo", 2, "cut url : " + localObject);
    return localObject;
    return super.a(paramIReadInJoyModel);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364220));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367009));
    this.b = ((TextView)paramView.findViewById(2131367010));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = ((IReadInJoyModel)paramObject).a();
      if (paramObject != null) {
        if (((ReadInJoyBaseAdapter.f(paramObject)) || (ReadInJoyBaseAdapter.g(paramObject)) || (ReadInJoyBaseAdapter.h(paramObject)) || (ReadInJoyBaseAdapter.i(paramObject))) && ((ReadInJoyBaseAdapter.o(paramObject)) && (!ReadInJoyBaseAdapter.a(paramObject)) && (!ReadInJoyBaseAdapter.b(paramObject)))) {
          break label102;
        }
      }
    }
    while (NetworkUtil.h(getContext()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.b.setVisibility(4);
      return;
      label102:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(paramObject.mVideoDuration));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.b.setVisibility(0);
    Drawable localDrawable = getContext().getResources().getDrawable(2130840894);
    this.b.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.b.setCompoundDrawablePadding(AIOUtils.a(6.0F, getContext().getResources()));
    this.b.setVisibility(0);
    if (CUKingCardHelper.a() == 1)
    {
      this.b.setText("免流量播放");
      return;
    }
    if (paramObject.mXGFileSize > 0L)
    {
      this.b.setText(VideoFeedsHelper.b(paramObject.mXGFileSize) + "流量");
      return;
    }
    this.b.setText("流量播放");
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigImageVideo
 * JD-Core Version:    0.7.0.1
 */