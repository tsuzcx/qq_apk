package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StIconInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import alpo;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import xxf;
import xxl;
import xzf;
import yjf;

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
    return 2131558739;
  }
  
  protected URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376547);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131376542));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376549));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376543));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376550));
    this.d = ((TextView)paramView.findViewById(2131376545));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376540));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376541));
  }
  
  public void a(xzf paramxzf, Bitmap paramBitmap, yjf paramyjf)
  {
    super.a(paramxzf, paramBitmap, paramyjf);
    CertifiedAccountMeta.StUser localStUser;
    if ((paramxzf != null) && (paramxzf.a() != null) && (paramxzf.a().poster != null))
    {
      localStUser = paramxzf.a().poster;
      if (!TextUtils.isEmpty(localStUser.iconInfo.iconUrl.get())) {
        break label251;
      }
    }
    label251:
    for (paramxzf = localStUser.icon.get();; paramxzf = localStUser.iconInfo.iconUrl.get())
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(paramxzf);
      localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      a(localArrayList1, localArrayList2, paramyjf);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStUser.nick.get());
      paramyjf = localStUser.desc.get();
      if ((!TextUtils.isEmpty(paramyjf)) && (!paramyjf.equals(alpo.a(2131720468))))
      {
        paramxzf = paramyjf;
        if (!TextUtils.isEmpty(paramyjf.trim())) {}
      }
      else
      {
        paramxzf = alpo.a(2131720467);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramxzf);
      paramxzf = xxf.a();
      if (paramxzf != null)
      {
        this.d.setText(xxl.a(paramxzf.fansCount.get()));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(xxl.a(paramxzf.feedCount.get()));
        measure(jdField_c_of_type_Int, e);
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubScribePersonalSharedCardView
 * JD-Core Version:    0.7.0.1
 */