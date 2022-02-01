package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StIconInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeGlobalInfo;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;

public class SubScribePersonalSharedCardView
  extends AbsSubscribeShareCardView
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public SubScribePersonalSharedCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubScribePersonalSharedCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubScribePersonalSharedCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    return 2131558875;
  }
  
  protected URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377997);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131377992));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377999));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377993));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378000));
    this.d = ((TextView)paramView.findViewById(2131377995));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377990));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377991));
  }
  
  public void a(ShareInfoBean paramShareInfoBean, Bitmap paramBitmap, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener)
  {
    super.a(paramShareInfoBean, paramBitmap, paramShareDataBindListener);
    CertifiedAccountMeta.StUser localStUser;
    if ((paramShareInfoBean != null) && (paramShareInfoBean.a() != null) && (paramShareInfoBean.a().poster != null))
    {
      localStUser = paramShareInfoBean.a().poster;
      if (!TextUtils.isEmpty(localStUser.iconInfo.iconUrl.get())) {
        break label251;
      }
    }
    label251:
    for (paramShareInfoBean = localStUser.icon.get();; paramShareInfoBean = localStUser.iconInfo.iconUrl.get())
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(paramShareInfoBean);
      localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      a(localArrayList1, localArrayList2, paramShareDataBindListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStUser.nick.get());
      paramShareDataBindListener = localStUser.desc.get();
      if ((!TextUtils.isEmpty(paramShareDataBindListener)) && (!paramShareDataBindListener.equals(HardCodeUtil.a(2131719638))))
      {
        paramShareInfoBean = paramShareDataBindListener;
        if (!TextUtils.isEmpty(paramShareDataBindListener.trim())) {}
      }
      else
      {
        paramShareInfoBean = HardCodeUtil.a(2131719637);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramShareInfoBean);
      paramShareInfoBean = SubscribeGlobalInfo.a();
      if (paramShareInfoBean != null)
      {
        this.d.setText(SubscribeUtils.a(paramShareInfoBean.fansCount.get()));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(SubscribeUtils.a(paramShareInfoBean.feedCount.get()));
        measure(jdField_c_of_type_Int, e);
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubScribePersonalSharedCardView
 * JD-Core Version:    0.7.0.1
 */